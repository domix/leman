package com.yumka.leman.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

// imports+

// imports-

/**
 * Handles database calls for the ORGANIZATIONS table.
 */
public class OrganizationsManager
// extends+

// extends-
{

  /**
   * Column ID of type Types.INTEGER mapped to Integer.
   */
  public static final int ID_ID = 0;
  public static final int TYPE_ID = Types.INTEGER;
  public static final String NAME_ID = "ID";

  /**
   * Column NAME of type Types.VARCHAR mapped to String.
   */
  public static final int ID_NAME = 1;
  public static final int TYPE_NAME = Types.VARCHAR;
  public static final String NAME_NAME = "NAME";

  /**
   * Column ADDRESS of type Types.VARCHAR mapped to String.
   */
  public static final int ID_ADDRESS = 2;
  public static final int TYPE_ADDRESS = Types.VARCHAR;
  public static final String NAME_ADDRESS = "ADDRESS";

  /**
   * Column TELEPHONE of type Types.VARCHAR mapped to String.
   */
  public static final int ID_TELEPHONE = 3;
  public static final int TYPE_TELEPHONE = Types.VARCHAR;
  public static final String NAME_TELEPHONE = "TELEPHONE";

  private static final String TABLE_NAME = "ORGANIZATIONS";

  /**
   * Create an array of type string containing all the fields of the ORGANIZATIONS table.
   */
  private static final String[] FIELD_NAMES = {"ORGANIZATIONS.ID",
      "ORGANIZATIONS.NAME", "ORGANIZATIONS.ADDRESS", "ORGANIZATIONS.TELEPHONE"
  };

  /**
   * Field that contains the comma separated fields of the ORGANIZATIONS table.
   */
  private static final String ALL_FIELDS = "ORGANIZATIONS.ID" +
                                           ",ORGANIZATIONS.NAME" +
                                           ",ORGANIZATIONS.ADDRESS" +
                                           ",ORGANIZATIONS.TELEPHONE";

  private static OrganizationsManager singleton = new OrganizationsManager();

  /**
   * Get the OrganizationsManager singleton.
   *
   * @return OrganizationsManager
   */
  synchronized public static OrganizationsManager getInstance() {
    return singleton;
  }

  /**
   * Sets your own OrganizationsManager instance.
   <br>
   * This is optional, by default we provide it for you.
   */
  synchronized public static void setInstance(OrganizationsManager instance) {
    singleton = instance;
  }

  /**
   * Creates a new OrganizationsBean instance.
   *
   * @return the new OrganizationsBean
   */
  public OrganizationBean createOrganizationsBean() {
    return new OrganizationBean();
  }

  //////////////////////////////////////
  // PRIMARY KEY METHODS
  //////////////////////////////////////

  /**
   * Loads a OrganizationsBean from the ORGANIZATIONS using its key fields.
   *
   * @return a unique OrganizationsBean
   */
  //12
  public OrganizationBean loadByPrimaryKey(Integer id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM ORGANIZATIONS WHERE ORGANIZATIONS.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, id);
      OrganizationBean pReturn[] = loadByPreparedStatement(ps);
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

  /**
   * Deletes rows according to its keys.
   *
   * @return the number of deleted rows
   */
  //60
  public int deleteByPrimaryKey(Integer id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement(
          "DELETE from ORGANIZATIONS WHERE ORGANIZATIONS.ID=?",
          ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, id);
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
   * Loads all the rows from ORGANIZATIONS.
   *
   * @return an array of OrganizationsManager pObject
   */
  //38
  public OrganizationBean[] loadAll() throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM ORGANIZATIONS",
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
   * Retrieves an array of OrganizationsBean given a sql 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the resulting OrganizationsBean table
   */
  //49
  public OrganizationBean[] loadByWhere(String where) throws SQLException {
    return loadByWhere(where, null);
  }

  /**
   * Retrieves an array of OrganizationsBean given a sql where clause, and a list of fields.
   * You must use the 'WHERE' keyword.
   *
   * @param where the sql 'where' clause
   * @param fieldList table of the field's associated constants
   * @return the resulting OrganizationsBean table
   */
  //51
  public OrganizationBean[] loadByWhere(String where, int[] fieldList) throws
      SQLException {
    String sql = null;
    if (fieldList == null) {
      sql = "select " + ALL_FIELDS + " from ORGANIZATIONS " + where;
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
      buff.append(" from ORGANIZATIONS ");
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

      return (OrganizationBean[]) v.toArray(new OrganizationBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      }
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows from the ORGANIZATIONS table using a 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the number of deleted rows
   */
  public int deleteWhere(String where) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      String delByWhereSQL = "DELETE FROM ORGANIZATIONS WHERE " + where;
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
   * Saves the OrganizationsBean pObject into the database.
   *
   * @param pObject the OrganizationsBean pObject to be saved
   */
  //100
  public OrganizationBean save(OrganizationBean pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;

    try {
      c = getConnection();
      if (pObject.isNew()) { // SAVE
        beforeInsert(pObject); // listener callback
        int _dirtyCount = 0;
        _sql = new StringBuffer("INSERT into ORGANIZATIONS (");

        /*if (pObject.isIdModified()) {
            if (_dirtyCount>0) {
                _sql.append(",");
            }
            _sql.append("ID");
            _dirtyCount++;
                         }*/

        if (pObject.isNameModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("NAME");
          _dirtyCount++;
        }

        if (pObject.isAddressModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("ADDRESS");
          _dirtyCount++;
        }

        if (pObject.isTelephoneModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("TELEPHONE");
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

        /*if (pObject.isIdModified()) {
            Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
                         }*/

        if (pObject.isNameModified()) {
          ps.setString(++_dirtyCount, pObject.getName());
        }

        if (pObject.isAddressModified()) {
          ps.setString(++_dirtyCount, pObject.getAddress());
        }

        if (pObject.isTelephoneModified()) {
          ps.setString(++_dirtyCount, pObject.getTelephone());
        }

        ps.executeUpdate();
        /* if (!pObject.isIdModified())
         {
             ResultSet rs = ps.getGeneratedKeys();
             try {
                 if(rs.next())
                     pObject.setId(Manager.getInteger(rs, 1));
                 else
         getManager().log("ATTENTION: Could not retrieve auto generated key!");
             } finally {
                 getManager().close(rs);
             }
         }*/

        pObject.isNew(false);
        pObject.resetIsModified();
        afterInsert(pObject); // listener callback
      }
      else { // UPDATE
        beforeUpdate(pObject); // listener callback
        _sql = new StringBuffer("UPDATE ORGANIZATIONS SET ");
        boolean useComma = false;

        /*if (pObject.isIdModified()) {
            if (useComma) {
                _sql.append(",");
            } else {
                useComma=true;
            }
            _sql.append("ID").append("=?");
                         }*/

        if (pObject.isNameModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("NAME").append("=?");
        }

        if (pObject.isAddressModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("ADDRESS").append("=?");
        }

        if (pObject.isTelephoneModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("TELEPHONE").append("=?");
        }
        _sql.append(" WHERE ");
        _sql.append("ORGANIZATIONS.ID=?");
        ps = c.prepareStatement(_sql.toString(),
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        int _dirtyCount = 0;

        /*if (pObject.isIdModified()) {
              Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
                         }*/

        if (pObject.isNameModified()) {
          ps.setString(++_dirtyCount, pObject.getName());
        }

        if (pObject.isAddressModified()) {
          ps.setString(++_dirtyCount, pObject.getAddress());
        }

        if (pObject.isTelephoneModified()) {
          ps.setString(++_dirtyCount, pObject.getTelephone());
        }

        if (_dirtyCount == 0) {
          return pObject;
        }

        Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
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
   * Saves an array of OrganizationsBean pObjects into the database.
   *
   * @param pObjects the OrganizationsBean pObject table to be saved
   * @return the Objects to be saved
   * TODO: BATCH UPDATE
   */
  //65
  public OrganizationBean[] save(OrganizationBean[] pObjects) throws
      SQLException {
    for (int iIndex = 0; iIndex < pObjects.length; iIndex++) {
      save(pObjects[iIndex]);
    }
    return pObjects;
  }

  ///////////////////////////////////////////////////////////////////////
  // USING TEMPLATE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Loads a unique OrganizationsBean pObject from a template one giving a c
   *
   * @param pObject the OrganizationsBean pObject to look for
   * @return the pObject matching the template
   */
  //85
  public OrganizationBean loadUniqueUsingTemplate(OrganizationBean pObject) throws
      SQLException {
    OrganizationBean[] pReturn = loadUsingTemplate(pObject);
    if (pReturn.length == 0) {
      return null;
    }
    if (pReturn.length > 1) {
      throw new SQLException("More than one element !!");
    }
    return pReturn[0];
  }

  /**
   * Loads an array of OrganizationsBean from a template one.
   *
   * @param pObject the OrganizationsBean template to look for
   * @return all the OrganizationsBean matching the template
   */
  //88
  public OrganizationBean[] loadUsingTemplate(OrganizationBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer where = new StringBuffer("");
    StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS +
                                         " from ORGANIZATIONS WHERE ");
    StringBuffer _sqlWhere = new StringBuffer("");
    try {
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isNameModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("NAME= ?");
      }

      if (pObject.isAddressModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ADDRESS= ?");
      }

      if (pObject.isTelephoneModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("TELEPHONE= ?");
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

      if (pObject.isIdModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
      }

      if (pObject.isNameModified()) {
        ps.setString(++_dirtyCount, pObject.getName());
      }

      if (pObject.isAddressModified()) {
        ps.setString(++_dirtyCount, pObject.getAddress());
      }

      if (pObject.isTelephoneModified()) {
        ps.setString(++_dirtyCount, pObject.getTelephone());
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
   * Deletes rows using a OrganizationsBean template.
   *
   * @param pObject the OrganizationsBean object(s) to be deleted
   * @return the number of deleted objects
   */
  //63
  public int deleteUsingTemplate(OrganizationBean pObject) throws SQLException {
    if (pObject.isIdInitialized()) {
      return deleteByPrimaryKey(pObject.getId());
    }

    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer sql = null;

    try {
      sql = new StringBuffer("DELETE FROM ORGANIZATIONS WHERE ");
      int _dirtyAnd = 0;
      if (pObject.isIdInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ID").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isNameInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("NAME").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isAddressInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ADDRESS").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isTelephoneInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("TELEPHONE").append("=?");
        _dirtyAnd++;
      }

      c = getConnection();
      ps = c.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      int _dirtyCount = 0;

      if (pObject.isIdInitialized()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
      }

      if (pObject.isNameInitialized()) {
        ps.setString(++_dirtyCount, pObject.getName());
      }

      if (pObject.isAddressInitialized()) {
        ps.setString(++_dirtyCount, pObject.getAddress());
      }

      if (pObject.isTelephoneInitialized()) {
        ps.setString(++_dirtyCount, pObject.getTelephone());
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
   * Retrieves an array of UsersBean using the relation table Evaluations given a OrganizationsBean object.
   *
   * @param pObject the OrganizationsBean pObject to be used
   * @return an array of UsersBean
   */
  // MANY TO MANY
  public UserBean[] loadUsersViaEvaluations(OrganizationBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT " + "        *" + " FROM  " +
                    "        USERS,EVALUATIONS" + " WHERE " +
                    "     EVALUATIONS.IDORGANIZATION = ?" +
                    " AND EVALUATIONS.IDUSER = USERS.LOGIN";
    try {
      c = getConnection();
      ps = c.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, pObject.getId());
      return UserManager.getInstance().loadByPreparedStatement(ps);
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
   * Retrieves the number of rows of the table ORGANIZATIONS.
   *
   * @return the number of rows returned
   */
  //78
  public int count() throws SQLException {
    return countWhere("");
  }

  /**
   * Retrieves the number of rows of the table ORGANIZATIONS with a 'where' clause.
   * You must use the 'WHERE' keyword.
   *
   * @param where the restriction clause
   * @return the number of rows returned
   */
  public int countWhere(String where) throws SQLException {
    String sql = "select count(*) as MCOUNT from ORGANIZATIONS " + where;
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
   * Retrieves the number of rows of the table ORGANIZATIONS with a prepared statement.
   *
   * @param ps the PreparedStatement to be used
   * @return the number of rows returned
   */
  //82
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
   * Looks for the number of elements of a specific OrganizationsBean pObject given a c
   *
   * @param pObject the OrganizationsBean pObject to look for
   * @return the number of rows returned
   */
  //83
  public int countUsingTemplate(OrganizationBean pObject) throws SQLException {
    StringBuffer where = new StringBuffer("");
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;
    StringBuffer _sqlWhere = null;

    try {
      _sql = new StringBuffer(
          "SELECT count(*) as MCOUNT  from ORGANIZATIONS WHERE ");
      _sqlWhere = new StringBuffer("");
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isNameModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("NAME= ?");
      }

      if (pObject.isAddressModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ADDRESS= ?");
      }

      if (pObject.isTelephoneModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("TELEPHONE= ?");
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

      if (pObject.isIdModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
      }

      if (pObject.isNameModified()) {
        ps.setString(++_dirtyCount, pObject.getName());
      }

      if (pObject.isAddressModified()) {
        ps.setString(++_dirtyCount, pObject.getAddress());
      }

      if (pObject.isTelephoneModified()) {
        ps.setString(++_dirtyCount, pObject.getTelephone());
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
   * Transforms a ResultSet iterating on the ORGANIZATIONS on a OrganizationsBean pObject.
   *
   * @param rs the ResultSet to be transformed
   * @return pObject resulting OrganizationsBean pObject
   */
  //72
  public OrganizationBean decodeRow(ResultSet rs) throws SQLException {
    OrganizationBean pObject = createOrganizationsBean();
    pObject.setId(Manager.getInteger(rs, 1));
    pObject.setName(rs.getString(2));
    pObject.setAddress(rs.getString(3));
    pObject.setTelephone(rs.getString(4));

    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  /**
   * Transforms a ResultSet iterating on the ORGANIZATIONS table on a OrganizationsBean pObject according to a list of fields.
   *
   * @param rs the ResultSet to be transformed
   * @param fieldList table of the field's associated constants
   * @return pObject resulting OrganizationsBean pObject
   */
  //73
  public OrganizationBean decodeRow(ResultSet rs, int[] fieldList) throws
      SQLException {
    OrganizationBean pObject = createOrganizationsBean();
    int pos = 0;
    for (int i = 0; i < fieldList.length; i++) {
      switch (fieldList[i]) {
        case ID_ID:
          ++pos;
          pObject.setId(Manager.getInteger(rs, pos));
          break;
        case ID_NAME:
          ++pos;
          pObject.setName(rs.getString(pos));
          break;
        case ID_ADDRESS:
          ++pos;
          pObject.setAddress(rs.getString(pos));
          break;
        case ID_TELEPHONE:
          ++pos;
          pObject.setTelephone(rs.getString(pos));
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
   *
   * @param ps the PreparedStatement to be used
   * @return an array of OrganizationsBean
   */
  //41
  public OrganizationBean[] loadByPreparedStatement(PreparedStatement ps) throws
      SQLException {
    return loadByPreparedStatement(ps, null);
  }

  /**
   * Loads all the elements using a prepared statement specifying a list of fields to be retrieved.
   *
   * @param ps the PreparedStatement to be used
   * @param fieldList table of the field's associated constants
   * @return an array of OrganizationsBean
   */
  public OrganizationBean[] loadByPreparedStatement(PreparedStatement ps,
      int[] fieldList) throws SQLException {
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
      return (OrganizationBean[]) v.toArray(new OrganizationBean[0]);
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
  private OrganizationsListener listener = null;

  /**
   * Registers a unique OrganizationsListener listener.
   */
  //66.5
  public void registerListener(OrganizationsListener listener) {
    this.listener = listener;
  }

  /**
   * Before the save of the OrganizationsBean pObject.
   *
   * @param pObject the OrganizationsBean pObject to be saved
   */
  //67
  void beforeInsert(OrganizationBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeInsert(pObject);
    }
  }

  /**
   * After the save of the OrganizationsBean pObject.
   *
   * @param pObject the OrganizationsBean pObject to be saved
   */
  //68
  void afterInsert(OrganizationBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterInsert(pObject);
    }
  }

  /**
   * Before the update of the OrganizationsBean pObject.
   *
   * @param pObject the OrganizationsBean pObject to be updated
   */
  //69
  void beforeUpdate(OrganizationBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeUpdate(pObject);
    }
  }

  /**
   * After the update of the OrganizationsBean pObject.
   *
   * @param pObject the OrganizationsBean pObject to be updated
   */
  //70
  void afterUpdate(OrganizationBean pObject) throws SQLException {
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
  //2
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
   */
  Connection getConnection() throws SQLException {
    return getManager().getConnection();
  }

// class+

// class-
}
