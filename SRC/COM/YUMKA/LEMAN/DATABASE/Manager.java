package com.yumka.leman.database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import javax.sql.DataSource;

/**
 * The Manager provides connections and manages transactions transparently.
 * <br>
 * It is a singleton, you get its instance with the getInstance() method.
 * All of the XxxxManager classes use the Manager to get database connections.
 * Before doing any operation, you must pass either a
 * datasource or a jdbc driver/url/username/password.
 * You may extend it and use setInstance() method to make sure your
 * implementation is used as a singleton.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class Manager {
  private static Manager manager_instance = new Manager();
  private static InheritableThreadLocal trans_conn = new InheritableThreadLocal();
  public static PoolConnection pool = null;

  private PrintWriter pw = new PrintWriter(System.out);
  private DataSource ds = null;
  private String jdbc_driver = null;
  private String jdbc_url = null;
  private String jdbc_username = null;
  private String jdbc_password = null;

  /**
   * Returns the manager singleton instance.
   * @return Manager
   */
  public static Manager getInstance() {
    return manager_instance;
  }

  /**
   * Sets the datasource to be used by the manager.
   * <br>
   * A good datasource manages a pool of connections.
   *
   * @param ds the data source
   */
  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  /**
   * Loads the passed jdbc driver.
   * <br>
   * Only needed if the datasource is not set.
   * @param jdbc_driver String
   * @throws ClassNotFoundException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  public void setJdbcDriver(String jdbc_driver) throws ClassNotFoundException,
      InstantiationException, IllegalAccessException {
    this.jdbc_driver = jdbc_driver;
    Class.forName(jdbc_driver).newInstance();
  }

  /**
   * Sets the jdbc url.
   * <br>
   * Only needed if the datasource is not set.
   * @param jdbc_url String
   */
  public void setJdbcUrl(String jdbc_url) {
    this.jdbc_url = jdbc_url;
  }

  /**
   * Sets the username used to access the database.
   * <br>
   * Only needed if the datasource is not set.
   * @param jdbc_username String
   */
  public void setJdbcUsername(String jdbc_username) {
    this.jdbc_username = jdbc_username;
  }

  /**
   * Sets the password used to access the database.
   * <br>
   * Only needed if the datasource is not set.
   * @param jdbc_password String
   */
  public void setJdbcPassword(String jdbc_password) {
    this.jdbc_password = jdbc_password;
  }

  /**
   * Gets an auto commit connection.
   * <br>
   * Normally you do not need this method that much ;-)
   * @throws SQLException
   * @return Connection an auto commit connection
   */
  public synchronized Connection getConnection() throws SQLException {
    Connection tc = (Connection) trans_conn.get();
    if (tc != null) {
      return tc;
    }
    if (ds != null) {
      return ds.getConnection();
    }
    else {
      if (jdbc_driver != null && jdbc_url != null && jdbc_username != null &&
          jdbc_password != null) {
        if(this.pool == null) {
          this.pool = new PoolConnection(jdbc_driver, jdbc_url,
                        jdbc_username, jdbc_password, 10,
                        20,
                        true);
        }
        /*else {
        }*/
       return this.pool.getConnection();
        //.getConnection()
        /*return DriverManager.getConnection(jdbc_url, jdbc_username,
                                           jdbc_password);*/
        //return null;
      }
      else {
        throw new IllegalStateException(
            "Please set a datasource or a jdbc driver/url/username/password");
      }
    }
  }

  /**
   * Releases the database connection.
   * <br>
   * Normally you should not need this method ;-)
   * @param c Connection
   */
  public synchronized void releaseConnection(Connection c) {
    Connection tc = (Connection) trans_conn.get();
    if (tc != null) {
      return;
    }
    try {
      if (c != null) {
        /*c.setAutoCommit(true);
        c.close();*/
        this.pool.free(c);
      }
    }
    catch (Exception x) {
      log("Could not release the connection: " + x.toString());
    }
  }

  /**
   * Initiates a database transaction.
   * <br>
   * When working within a transaction, you should invoke this method first.
   * The connection is returned just in case you need to set the isolation level.
   * @throws SQLException
   * @return Connection a non-auto commit connection with the default transaction isolation level
   */
  public Connection beginTransaction() throws SQLException {
    Connection c = getConnection();
    c.setAutoCommit(false);
    trans_conn.set(c);
    return c;
  }

  /**
   * Releases connection used for the transaction and performs a commit or rollback.
   * @param commit boolean commit tells whether this connection should be committed
   *        true for commit(), false for rollback()
   * @throws SQLException
   */
  public void endTransaction(boolean commit) throws SQLException {
    Connection c = (Connection) trans_conn.get();
    if (c == null) {
      return;
    }
    try {
      if (commit) {
        c.commit();
      }
      else {
        c.rollback();
      }
    }
    finally {
      trans_conn.set(null);
      releaseConnection(c);
    }
  }

  /**
   * Sets the PrintWriter where logs are printed.
   * <br>
   * You may pass 'null' to disable logging.
   *
   * @param pw the PrintWriter for log messages
   */
  public void setLogWriter(PrintWriter pw) {
    this.pw = pw;
  }

  ////////////////////////////////////////////////////
  // Utils method
  ////////////////////////////////////////////////////
  /**
   * Logs a message using the underlying logwriter, if not null.
   * @param message String
   */
  public void log(String message) {
    if (pw != null) {
      pw.println(message);
    }
  }

  /**
   * Closes the passed Statement.
   * @param s Statement
   */
  public void close(Statement s) {
    try {
      if (s != null) {
        s.close();
      }
    }
    catch (SQLException x) {
      log("Could not close statement!: " + x.toString());
    }
    ;
  }

  /**
   * Closes the passed ResultSet.
   * @param rs ResultSet
   */
  public void close(ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    }
    catch (SQLException x) {
      log("Could not close result set!: " + x.toString());
    }
    ;
  }

  /**
   * Closes the passed Statement and ResultSet.
   * @param s Statement
   * @param rs ResultSet
   */
  public void close(Statement s, ResultSet rs) {
    close(rs);
    close(s);
  }

  /**
   * Retrieves an int value from the passed result set as an Integer object.
   * @param rs ResultSet
   * @param pos int
   * @throws SQLException
   * @return Integer
   */
  public static Integer getInteger(ResultSet rs, int pos) throws SQLException {
    int i = rs.getInt(pos);
    return rs.wasNull() ? (Integer)null : new Integer(i);
  }

  /**
   * Set an Integer object to the passed prepared statement as an int or as null.
   * @param ps PreparedStatement
   * @param pos int
   * @param i Integer
   * @throws SQLException
   */
  public static void setInteger(PreparedStatement ps, int pos, Integer i) throws
      SQLException {
    if (i == null) {
      ps.setNull(pos, Types.INTEGER);
    }
    else {
      ps.setInt(pos, i.intValue());
    }
  }

  /**
   * Retrieves a float value from the passed result set as a Float object.
   * @param rs ResultSet
   * @param pos int
   * @throws SQLException
   * @return Float
   */
  public static Float getFloat(ResultSet rs, int pos) throws SQLException {
    float f = rs.getFloat(pos);
    return rs.wasNull() ? (Float)null : new Float(f);
  }

  /**
   * Set a Float object to the passed prepared statement as a float or as null.
   * @param ps PreparedStatement
   * @param pos int
   * @param f Float
   * @throws SQLException
   */
  public static void setFloat(PreparedStatement ps, int pos, Float f) throws
      SQLException {
    if (f == null) {
      ps.setNull(pos, Types.FLOAT);
    }
    else {
      ps.setFloat(pos, f.floatValue());
    }
  }

  /**
   * Retrieves a double value from the passed result set as a Double object.
   * @param rs ResultSet
   * @param pos int
   * @throws SQLException
   * @return Double
   */
  public static Double getDouble(ResultSet rs, int pos) throws SQLException {
    double d = rs.getDouble(pos);
    return rs.wasNull() ? (Double)null : new Double(d);
  }

  /**
   * Set a Double object to the passed prepared statement as a double or as null.
   * @param ps PreparedStatement
   * @param pos int
   * @param d Double
   * @throws SQLException
   */
  public static void setDouble(PreparedStatement ps, int pos, Double d) throws
      SQLException {
    if (d == null) {
      ps.setNull(pos, Types.DOUBLE);
    }
    else {
      ps.setDouble(pos, d.doubleValue());
    }
  }

  /**
   * Retrieves a long value from the passed result set as a Long object.
   * @param rs ResultSet
   * @param pos int
   * @throws SQLException
   * @return Long
   */
  public static Long getLong(ResultSet rs, int pos) throws SQLException {
    long l = rs.getLong(pos);
    return rs.wasNull() ? (Long)null : new Long(l);
  }

  /**
   * Set a Long object to the passed prepared statement as a long or as null.
   * @param ps PreparedStatement
   * @param pos int
   * @param l Long
   * @throws SQLException
   */
  public static void setLong(PreparedStatement ps, int pos, Long l) throws
      SQLException {
    if (l == null) {
      ps.setNull(pos, Types.BIGINT);
    }
    else {
      ps.setLong(pos, l.longValue());
    }
  }

  /**
   * Retrieves a boolean value from the passed result set as a Boolean object.
   * @param rs ResultSet
   * @param pos int
   * @throws SQLException
   * @return Boolean
   */
  public static Boolean getBoolean(ResultSet rs, int pos) throws SQLException {
    boolean b = rs.getBoolean(pos);
    return rs.wasNull() ? (Boolean)null : new Boolean(b);
  }

  /**
   * Set a Boolean object to the passed prepared statement as a boolean or as null.
   * @param ps PreparedStatement
   * @param pos int
   * @param b Boolean
   * @throws SQLException
   */
  public static void setBoolean(PreparedStatement ps, int pos, Boolean b) throws
      SQLException {
    if (b == null) {
      ps.setNull(pos, Types.BOOLEAN);
    }
    else {
      ps.setBoolean(pos, b.booleanValue());
    }
  }
}
