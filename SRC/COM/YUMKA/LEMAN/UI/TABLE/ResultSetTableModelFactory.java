package com.yumka.leman.ui.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class encapsulates a JDBC database connection and, given a SQL query
 * as a string, returns a ResultSetTableModel object suitable for display
 * in a JTable Swing component
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class ResultSetTableModelFactory {
  Connection connection; // Holds the connection to the database
  /**
   * The constructor method uses the arguments to create db Connection
   * @param driverClassName String
   * @param dbname String
   * @param username String
   * @param password String
   * @throws ClassNotFoundException
   * @throws SQLException
   */public ResultSetTableModelFactory(String driverClassName, String dbname,
                                       String username, String password) throws
      ClassNotFoundException, SQLException {
    // Look up the JDBC driver by class name.  When the class loads, it
    // automatically registers itself with the DriverManager used in
    // the next step.
    Class driver = Class.forName(driverClassName);

    // Now use that driver to connect to the database
    connection = DriverManager.getConnection(dbname, username, password);
  }

  /**
   * ResultSetTableModelFactory
   *
   * @param conn Connection
   */
  public ResultSetTableModelFactory(Connection conn) {
    this.connection = conn;
  }

  /**
   * This method takes a SQL query, passes it to the database, obtains the
   * results as a ResultSet, and returns a ResultSetTableModel object that
   * holds the results in a form that the Swing JTable component can use.
   * @param query String
   * @throws SQLException
   * @return ResultSetTableModel
   */
  public ResultSetTableModel getResultSetTableModel(String query) throws
      SQLException {
    // If we've called close(), then we can't call this method
    if (connection == null) {
      throw new IllegalStateException("Connection already closed.");
    }

    // Create a Statement object that will be used to excecute the query.
    // The arguments specify that the returned ResultSet will be
    // scrollable, read-only, and insensitive to changes in the db.
    Statement statement = connection.createStatement(ResultSet.
        TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    // Run the query, creating a ResultSet
    ResultSet r = statement.executeQuery(query);
    // Create and return a TableModel for the ResultSet
    return new ResultSetTableModel(r);
  }

  /**
   * Call this method when done with the factory to close the DB connection
   **/
  public void close() {
    try {connection.close();
    } // Try to close the connection
    catch (Exception e) {} // Do nothing on error. At least we tried.
    connection = null;
  }

  /** Automatically close the connection when we're garbage collected */
  protected void finalize() {
    close();
  }
}

//90
