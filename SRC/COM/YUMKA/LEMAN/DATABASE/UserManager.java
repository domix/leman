package com.yumka.leman.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * Handles database calls for the USERS table.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class UserManager {
  /**
   * Column LOGIN of type Types.VARCHAR mapped to String.
   */
  public static final int ID_LOGIN = 0;
  public static final int TYPE_LOGIN = Types.VARCHAR;
  public static final String NAME_LOGIN = "LOGIN";

  /**
   * Column NAME of type Types.VARCHAR mapped to String.
   */
  public static final int ID_NAME = 1;
  public static final int TYPE_NAME = Types.VARCHAR;
  public static final String NAME_NAME = "NAME";

  /**
   * Column COMPANY of type Types.VARCHAR mapped to String.
   */
  public static final int ID_COMPANY = 2;
  public static final int TYPE_COMPANY = Types.VARCHAR;
  public static final String NAME_COMPANY = "COMPANY";

  /**
   * Column JOBPOSITION of type Types.VARCHAR mapped to String.
   */
  public static final int ID_JOBPOSITION = 3;
  public static final int TYPE_JOBPOSITION = Types.VARCHAR;
  public static final String NAME_JOBPOSITION = "JOBPOSITION";

  /**
   * Column PASSWORD of type Types.VARCHAR mapped to String.
   */
  public static final int ID_PASSWORD = 4;
  public static final int TYPE_PASSWORD = Types.VARCHAR;
  public static final String NAME_PASSWORD = "PASSWORD";

  private static final String TABLE_NAME = "USERS";

  /**
   * Create an array of type string containing all the fields of the USERS table.
   */
  private static final String[] FIELD_NAMES = {TABLE_NAME + "." + NAME_LOGIN,
                                              TABLE_NAME + ".NAME",
                                              TABLE_NAME + ".COMPANY",
                                              TABLE_NAME + ".JOBPOSITION",
                                              TABLE_NAME + ".PASSWORD"
  };

  /**
   * Field that contains the comma separated fields of the USERS table.
   */
  private static final String ALL_FIELDS = "USERS.LOGIN ,USERS.NAME," +
                                           "USERS.COMPANY ,USERS.JOBPOSITION," +
                                           "USERS.PASSWORD";

  private static UserManager singleton = new UserManager();

  /**
   * Get the UserManager singleton.
   *
   * @return UserManager
   */
  synchronized public static UserManager getInstance() {
    return singleton;
  }

  /**
   * Sets your own UserManager instance.
   * <br>
   * This is optional, by default we provide it for you.
   * @param instance UserManager
   */
  synchronized public static void setInstance(UserManager instance) {
    singleton = instance;
  }

  /**
   * Creates a new UserBean instance.
   *
   * @return the new UserBean
   */
  public UserBean createUserBean() {
    return new UserBean();
  }

  //////////////////////////////////////
  // PRIMARY KEY METHODS
  //////////////////////////////////////
  /**
   * Loads a UserBean from the USERS using its key fields.
   * @param login String
   * @throws SQLException
   * @return UserBean a unique UserBean
   */
  public UserBean loadByPrimaryKey(String login) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM USERS WHERE USERS.LOGIN=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, login);
      UserBean pReturn[] = loadByPreparedStatement(ps);
      if (pReturn.length < 1) {
        return null;
      }
      else {
        return pReturn[0];
      }
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  public void createSchema(String login) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();

      Statement st = null;
      ResultSet rs = null;

      st = c.createStatement();
      rs = st.executeQuery("expression");
      st.close();
    }
    finally {
      freeConnection(c);
    }
  }

  /**
   * Deletes rows according to its keys.
   * @param login String
   * @throws SQLException
   * @return int the number of deleted rows
   */
  public int deleteByPrimaryKey(String login) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE from USERS WHERE USERS.LOGIN=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, login);
      return ps.executeUpdate();
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  //////////////////////////////////////
  // LOAD ALL
  //////////////////////////////////////
  /**
   * Loads all the rows from USERS.
   * @throws SQLException
   * @return UserBean[] an array of UserManager pObject
   */
  public UserBean[] loadAll() throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM USERS",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      return loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  //////////////////////////////////////
  // SQL 'WHERE' METHOD
  //////////////////////////////////////
  /**
   * Retrieves an array of UserBean given a sql 'where' clause.
   * @param where String where the sql 'where' clause
   * @throws SQLException
   * @return UserBean[] the resulting UserBean table
   */
  public UserBean[] loadByWhere(String where) throws SQLException {
    return loadByWhere(where, null);
  }

  /**
   * Retrieves an array of UserBean given a sql where clause, and a list of fields.
   * You must use the 'WHERE' keyword.
   * @param where String where the sql 'where' clause
   * @param fieldList int[] fieldList table of the field's associated constants
   * @throws SQLException
   * @return UserBean[] the resulting UserBean table
   */
  public UserBean[] loadByWhere(String where, int[] fieldList) throws
      SQLException {
    String sql = null;
    if (fieldList == null) {
      sql = "select " + ALL_FIELDS + " from USERS " + where;
    }
    else {
      StringBuffer buff = new StringBuffer(128);
      buff.append("select ");
      for (int i = 0; i < fieldList.length; i++) {
        if (i != 0) {
          buff.append(",");
        }
        buff.append(FIELD_NAMES[fieldList[i]]);
      }
      buff.append(" from USERS ");
      buff.append(where);
      sql = buff.toString();
      buff = null;
    }
    Connection c = null;
    Statement pStatement = null;
    ResultSet rs = null;
    java.util.ArrayList v = null;
    try {
      c = getConnection();
      pStatement = c.createStatement();
      rs = pStatement.executeQuery(sql);
      v = new java.util.ArrayList();
      while (rs.next()) {
        if (fieldList == null) {
          v.add(decodeRow(rs));
        }
        else {
          v.add(decodeRow(rs, fieldList));
        }
      }

      return (UserBean[]) v.toArray(new UserBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      }
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows from the USERS table using a 'where' clause.
   * @param where String where the sql 'where' clause
   * @throws SQLException
   * @return int the number of deleted rows
   */
  public int deleteWhere(String where) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      String delByWhereSQL = "DELETE FROM USERS WHERE " + where;
      ps = c.prepareStatement(delByWhereSQL);
      return ps.executeUpdate();
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  ///////////////////////////////////////////////////////////////////////
  // SAVE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Saves the UserBean pObject into the database.
   * @param pObject UserBean pObject the UserBean pObject to be saved
   * @throws SQLException
   * @return UserBean
   */
  public UserBean save(UserBean pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;

    try {
      c = getConnection();
      if (pObject.isNew()) { // SAVE
        beforeInsert(pObject); // listener callback
        int _dirtyCount = 0;
        _sql = new StringBuffer("INSERT into USERS (");

        if (pObject.isLoginModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("LOGIN");
          _dirtyCount++;
        }

        if (pObject.isNameModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("NAME");
          _dirtyCount++;
        }

        if (pObject.isCompanyModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("COMPANY");
          _dirtyCount++;
        }

        if (pObject.isJobpositionModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("JOBPOSITION");
          _dirtyCount++;
        }

        if (pObject.isPasswordModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("PASSWORD");
          _dirtyCount++;
        }

        _sql.append(") values (");
        if (_dirtyCount > 0) {
          _sql.append("?");
          for (int i = 1; i < _dirtyCount; i++) {
            _sql.append(",?");
          }
        }
        _sql.append(")");

        //ps = c.prepareStatement(_sql.toString(), Statement.RETURN_GENERATED_KEYS);
        ps = c.prepareStatement(_sql.toString());
        _dirtyCount = 0;

        if (pObject.isLoginModified()) {
          ps.setString(++_dirtyCount, pObject.getLogin());
        }

        if (pObject.isNameModified()) {
          ps.setString(++_dirtyCount, pObject.getName());
        }

        if (pObject.isCompanyModified()) {
          ps.setString(++_dirtyCount, pObject.getCompany());
        }

        if (pObject.isJobpositionModified()) {
          ps.setString(++_dirtyCount, pObject.getJobposition());
        }

        if (pObject.isPasswordModified()) {
          ps.setString(++_dirtyCount, pObject.getPassword());
        }

        ps.executeUpdate();

        pObject.isNew(false);
        pObject.resetIsModified();
        afterInsert(pObject); // listener callback
      }
      else { // UPDATE
        beforeUpdate(pObject); // listener callback
        _sql = new StringBuffer("UPDATE USERS SET ");
        boolean useComma = false;

        if (pObject.isLoginModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("LOGIN").append("=?");
        }

        if (pObject.isNameModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("NAME").append("=?");
        }

        if (pObject.isCompanyModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("COMPANY").append("=?");
        }

        if (pObject.isJobpositionModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("JOBPOSITION").append("=?");
        }

        if (pObject.isPasswordModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("PASSWORD").append("=?");
        }
        _sql.append(" WHERE ");
        _sql.append("USERS.LOGIN=?");
        ps = c.prepareStatement(_sql.toString(),
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        int _dirtyCount = 0;

        if (pObject.isLoginModified()) {
          ps.setString(++_dirtyCount, pObject.getLogin());
        }

        if (pObject.isNameModified()) {
          ps.setString(++_dirtyCount, pObject.getName());
        }

        if (pObject.isCompanyModified()) {
          ps.setString(++_dirtyCount, pObject.getCompany());
        }

        if (pObject.isJobpositionModified()) {
          ps.setString(++_dirtyCount, pObject.getJobposition());
        }

        if (pObject.isPasswordModified()) {
          ps.setString(++_dirtyCount, pObject.getPassword());
        }

        if (_dirtyCount == 0) {
          return pObject;
        }

        ps.setString(++_dirtyCount, pObject.getLogin());
        ps.executeUpdate();
        pObject.resetIsModified();
        afterUpdate(pObject); // listener callback
      }

      return pObject;
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Saves an array of UserBean pObjects into the database.
   * @param pObjects UserBean[] pObjects the UserBean pObject table to be saved
   * @throws SQLException
   * @return UserBean[] the Objects to be saved
   * @todo BATCH UPDATE
   */
  public UserBean[] save(UserBean[] pObjects) throws SQLException {
    for (int iIndex = 0; iIndex < pObjects.length; iIndex++) {
      save(pObjects[iIndex]);
    }
    return pObjects;
  }

  ///////////////////////////////////////////////////////////////////////
  // USING TEMPLATE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Loads a unique UserBean pObject from a template one giving a c
   * @param pObject UserBean pObject the UserBean pObject to look for
   * @throws SQLException
   * @return UserBean the pObject matching the template
   */
  public UserBean loadUniqueUsingTemplate(UserBean pObject) throws SQLException {
    UserBean[] pReturn = loadUsingTemplate(pObject);
    if (pReturn.length == 0) {
      return null;
    }
    if (pReturn.length > 1) {
      throw new SQLException("More than one element !!");
    }
    return pReturn[0];
  }

  /**
   * Loads an array of UserBean from a template one.
   * @param pObject UserBean pObject the UserBean template to look for
   * @throws SQLException
   * @return UserBean[] all the UserBean matching the template
   */
  public UserBean[] loadUsingTemplate(UserBean pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer where = new StringBuffer("");
    StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS +
                                         " from USERS WHERE ");
    StringBuffer _sqlWhere = new StringBuffer("");
    try {
      int _dirtyCount = 0;

      if (pObject.isLoginModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("LOGIN= ?");
      }

      if (pObject.isNameModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("NAME= ?");
      }

      if (pObject.isCompanyModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("COMPANY= ?");
      }

      if (pObject.isJobpositionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("JOBPOSITION= ?");
      }

      if (pObject.isPasswordModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("PASSWORD= ?");
      }

      if (_dirtyCount == 0) {
        throw new SQLException(
            "The pObject to look for is invalid : not initialized !");
      }
      _sql.append(_sqlWhere);
      c = getConnection();
      ps = c.prepareStatement(_sql.toString(),
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      _dirtyCount = 0;

      if (pObject.isLoginModified()) {
        ps.setString(++_dirtyCount, pObject.getLogin());
      }

      if (pObject.isNameModified()) {
        ps.setString(++_dirtyCount, pObject.getName());
      }

      if (pObject.isCompanyModified()) {
        ps.setString(++_dirtyCount, pObject.getCompany());
      }

      if (pObject.isJobpositionModified()) {
        ps.setString(++_dirtyCount, pObject.getJobposition());
      }

      if (pObject.isPasswordModified()) {
        ps.setString(++_dirtyCount, pObject.getPassword());
      }

      ps.executeQuery();
      return loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows using a UserBean template.
   * @param pObject UserBean pObject the UserBean object(s) to be deleted
   * @throws SQLException
   * @return int the number of deleted objects
   */
  public int deleteUsingTemplate(UserBean pObject) throws SQLException {
    if (pObject.isLoginInitialized()) {
      return deleteByPrimaryKey(pObject.getLogin());
    }

    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer sql = null;

    try {
      sql = new StringBuffer("DELETE FROM USERS WHERE ");
      int _dirtyAnd = 0;
      if (pObject.isLoginInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("LOGIN").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isNameInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("NAME").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isCompanyInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("COMPANY").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isJobpositionInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("JOBPOSITION").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isPasswordInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("PASSWORD").append("=?");
        _dirtyAnd++;
      }

      c = getConnection();
      ps = c.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      int _dirtyCount = 0;

      if (pObject.isLoginInitialized()) {
        ps.setString(++_dirtyCount, pObject.getLogin());
      }

      if (pObject.isNameInitialized()) {
        ps.setString(++_dirtyCount, pObject.getName());
      }

      if (pObject.isCompanyInitialized()) {
        ps.setString(++_dirtyCount, pObject.getCompany());
      }

      if (pObject.isJobpositionInitialized()) {
        ps.setString(++_dirtyCount, pObject.getJobposition());
      }

      if (pObject.isPasswordInitialized()) {
        ps.setString(++_dirtyCount, pObject.getPassword());
      }

      int _rows = ps.executeUpdate();
      return _rows;
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  ///////////////////////////////////////////////////////////////////////
  // MANY TO MANY: LOAD OTHER BEAN VIA JUNCTION TABLE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Retrieves an array of OrganizationsBean using the relation table
   * Evaluations given a UserBean object.
   * @param pObject UserBean pObject the UserBean pObject to be used
   * @throws SQLException
   * @return OrganizationsBean[] an array of OrganizationsBean
   */
  public OrganizationBean[] loadOrganizationsViaEvaluations(UserBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT * FROM  " +
                    "        ORGANIZATIONS,EVALUATIONS WHERE " +
                    "     EVALUATIONS.IDUSER = ?" +
                    " AND EVALUATIONS.IDORGANIZATION = ORGANIZATIONS.ID";
    try {
      c = getConnection();
      ps = c.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, pObject.getLogin());
      return OrganizationsManager.getInstance().loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  ///////////////////////////////////////////////////////////////////////
  // COUNT
  ///////////////////////////////////////////////////////////////////////
  /**
   * Retrieves the number of rows of the table USERS.
   * @throws SQLException
   * @return int the number of rows returned
   */
  public int count() throws SQLException {
    return countWhere("");
  }

  /**
   * Retrieves the number of rows of the table USERS with a 'where' clause.
   * You must use the 'WHERE' keyword.
   * @param where String where the restriction clause
   * @throws SQLException
   * @return int the number of rows returned
   */
  public int countWhere(String where) throws SQLException {
    String sql = "select count(*) as MCOUNT from USERS " + where;
    Connection c = null;
    Statement pStatement = null;
    ResultSet rs = null;
    try {
      int iReturn = -1;
      c = getConnection();
      pStatement = c.createStatement();
      rs = pStatement.executeQuery(sql);
      if (rs.next()) {
        iReturn = rs.getInt("MCOUNT");
      }
      if (iReturn != -1) {
        return iReturn;
      }
    }
    finally {
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
    throw new SQLException("Error in countWhere");
  }

  /**
   * Retrieves the number of rows of the table USERS with a prepared statement.
   * @param ps PreparedStatement ps the PreparedStatement to be used
   * @throws SQLException
   * @return int the number of rows returned
   */
  int countByPreparedStatement(PreparedStatement ps) throws SQLException {
    ResultSet rs = null;
    try {
      int iReturn = -1;
      rs = ps.executeQuery();
      if (rs.next()) {
        iReturn = rs.getInt("MCOUNT");
      }
      if (iReturn != -1) {
        return iReturn;
      }
    }
    finally {
      getManager().close(rs);
    }
    throw new SQLException("Error in countByPreparedStatement");
  }

  /**
   * Looks for the number of elements of a specific UserBean pObject given a c
   * @param pObject UserBean pObject the UserBean pObject to look for
   * @throws SQLException
   * @return int the number of rows returned
   */
  public int countUsingTemplate(UserBean pObject) throws SQLException {
    StringBuffer where = new StringBuffer("");
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;
    StringBuffer _sqlWhere = null;

    try {
      _sql = new StringBuffer("SELECT count(*) as MCOUNT  from USERS WHERE ");
      _sqlWhere = new StringBuffer("");
      int _dirtyCount = 0;

      if (pObject.isLoginModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("LOGIN= ?");
      }

      if (pObject.isNameModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("NAME= ?");
      }

      if (pObject.isCompanyModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("COMPANY= ?");
      }

      if (pObject.isJobpositionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("JOBPOSITION= ?");
      }

      if (pObject.isPasswordModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("PASSWORD= ?");
      }

      if (_dirtyCount == 0) {
        throw new SQLException(
            "The pObject to look is unvalid : not initialized !");
      }

      _sql.append(_sqlWhere);
      c = getConnection();
      ps = c.prepareStatement(_sql.toString(),
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);

      _dirtyCount = 0;

      if (pObject.isLoginModified()) {
        ps.setString(++_dirtyCount, pObject.getLogin());
      }

      if (pObject.isNameModified()) {
        ps.setString(++_dirtyCount, pObject.getName());
      }

      if (pObject.isCompanyModified()) {
        ps.setString(++_dirtyCount, pObject.getCompany());
      }

      if (pObject.isJobpositionModified()) {
        ps.setString(++_dirtyCount, pObject.getJobposition());
      }

      if (pObject.isPasswordModified()) {
        ps.setString(++_dirtyCount, pObject.getPassword());
      }

      return countByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  ///////////////////////////////////////////////////////////////////////
  // DECODE RESULT SET
  ///////////////////////////////////////////////////////////////////////
  /**
   * Transforms a ResultSet iterating on the USERS on a UserBean pObject.
   * @param rs ResultSet the ResultSet to be transformed
   * @throws SQLException
   * @return UserBean pObject resulting UserBean pObject
   */
  public UserBean decodeRow(ResultSet rs) throws SQLException {
    UserBean pObject = createUserBean();
    pObject.setLogin(rs.getString(1));
    pObject.setName(rs.getString(2));
    pObject.setCompany(rs.getString(3));
    pObject.setJobposition(rs.getString(4));
    pObject.setPassword(rs.getString(5));

    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  /**
   * Transforms a ResultSet iterating on the USERS table on a UserBean pObject
   * according to a list of fields.
   * @param rs ResultSet the ResultSet to be transformed
   * @param fieldList int[] fieldList table of the field's associated constants
   * @throws SQLException
   * @return UserBean pObject resulting UserBean pObject
   */
  public UserBean decodeRow(ResultSet rs, int[] fieldList) throws SQLException {
    UserBean pObject = createUserBean();
    int pos = 0;
    for (int i = 0; i < fieldList.length; i++) {
      switch (fieldList[i]) {
        case ID_LOGIN:
          ++pos;
          pObject.setLogin(rs.getString(pos));
          break;
        case ID_NAME:
          ++pos;
          pObject.setName(rs.getString(pos));
          break;
        case ID_COMPANY:
          ++pos;
          pObject.setCompany(rs.getString(pos));
          break;
        case ID_JOBPOSITION:
          ++pos;
          pObject.setJobposition(rs.getString(pos));
          break;
        case ID_PASSWORD:
          ++pos;
          pObject.setPassword(rs.getString(pos));
          break;
      }
    }
    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  //////////////////////////////////////
  // PREPARED STATEMENT LOADER
  //////////////////////////////////////
  /**
   * Loads all the elements using a prepared statement.
   * @param ps PreparedStatement the PreparedStatement to be used
   * @throws SQLException
   * @return UserBean[] an array of UserBean
   */
  public UserBean[] loadByPreparedStatement(PreparedStatement ps) throws
      SQLException {
    return loadByPreparedStatement(ps, null);
  }

  /**
   * Loads all the elements using a prepared statement specifying a list of
   * fields to be retrieved.
   * @param ps PreparedStatement the PreparedStatement to be used
   * @param fieldList int[] fieldList table of the field's associated constants
   * @throws SQLException
   * @return UserBean[] an array of UserBean
   */
  public UserBean[] loadByPreparedStatement(PreparedStatement ps,
                                            int[] fieldList) throws
      SQLException {
    ResultSet rs = null;
    java.util.ArrayList v = null;
    try {
      rs = ps.executeQuery();
      v = new java.util.ArrayList();
      while (rs.next()) {
        if (fieldList == null) {
          v.add(decodeRow(rs));
        }
        else {
          v.add(decodeRow(rs, fieldList));
        }
      }
      return (UserBean[]) v.toArray(new UserBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      v = null;
      }
      getManager().close(rs);
    }
  }

  ///////////////////////////////////////////////////////////////////////
  // LISTENER
  ///////////////////////////////////////////////////////////////////////
  private UserListener listener = null;

  /**
   * Registers a unique UserListener listener.
   * @param listener UserListener
   */
  public void registerListener(UserListener listener) {
    this.listener = listener;
  }

  /**
   * Before the save of the UserBean pObject.
   * @param pObject UserBean pObject the UserBean pObject to be saved
   * @throws SQLException
   */
  void beforeInsert(UserBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeInsert(pObject);
    }
  }

  /**
   * After the save of the UserBean pObject.
   * @param pObject UserBean pObject the UserBean pObject to be saved
   * @throws SQLException
   */
  void afterInsert(UserBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterInsert(pObject);
    }
  }

  /**
   * Before the update of the UserBean pObject.
   * @param pObject UserBean pObject the UserBean pObject to be updated
   * @throws SQLException
   */
  void beforeUpdate(UserBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeUpdate(pObject);
    }
  }

  /**
   * After the update of the UserBean pObject.
   * @param pObject UserBean pObject the UserBean pObject to be updated
   * @throws SQLException
   */
  void afterUpdate(UserBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterUpdate(pObject);
    }
  }

  ///////////////////////////////////////////////////////////////////////
  // UTILS
  ///////////////////////////////////////////////////////////////////////
  /**
   * Retrieves the manager object used to get connections.
   *
   * @return the manager used
   */
  Manager getManager() {
    return Manager.getInstance();
  }

  /**
   * Frees the connection.
   *
   * @param c the connection to release
   */ void freeConnection(Connection c) {
    getManager().releaseConnection(c); // back to pool
  }

  /**
   * Gets the connection.
   * @throws SQLException
   * @return Connection
   */
  Connection getConnection() throws SQLException {
    return getManager().getConnection();
  }
}
