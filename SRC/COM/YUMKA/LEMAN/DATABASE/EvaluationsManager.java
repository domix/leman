
package com.yumka.leman.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * Handles database calls for the EVALUATIONS table.
 */
public class EvaluationsManager {

  /**
   * Column ID of type Types.INTEGER mapped to Integer.
   */
  public static final int ID_ID = 0;
  public static final int TYPE_ID = Types.INTEGER;
  public static final String NAME_ID = "ID";

  /**
   * Column IDORGANIZATION of type Types.INTEGER mapped to Integer.
   */
  public static final int ID_IDORGANIZATION = 1;
  public static final int TYPE_IDORGANIZATION = Types.INTEGER;
  public static final String NAME_IDORGANIZATION = "IDORGANIZATION";

  /**
   * Column IDUSER of type Types.VARCHAR mapped to String.
   */
  public static final int ID_IDUSER = 2;
  public static final int TYPE_IDUSER = Types.VARCHAR;
  public static final String NAME_IDUSER = "IDUSER";

  /**
   * Column DATE of type Types.DATE mapped to java.util.Date.
   */
  public static final int ID_DATE = 3;
  public static final int TYPE_DATE = Types.DATE;
  public static final String NAME_DATE = "DATE";

  /**
   * Column TIME of type Types.TIME mapped to java.util.Date.
   */
  public static final int ID_TIME = 4;
  public static final int TYPE_TIME = Types.TIME;
  public static final String NAME_TIME = "TIME";

  /**
   * Column ORGANIZATION of type Types.VARCHAR mapped to String.
   */
  public static final int ID_ORGANIZATION = 5;
  public static final int TYPE_ORGANIZATION = Types.VARCHAR;
  public static final String NAME_ORGANIZATION = "ORGANIZATION";

  private static final String TABLE_NAME = "EVALUATIONS";

  /**
   * Create an array of type string containing all the fields of the EVALUATIONS table.
   */
  private static final String[] FIELD_NAMES = {"EVALUATIONS.ID",
      "EVALUATIONS.IDORGANIZATION", "EVALUATIONS.IDUSER", "EVALUATIONS.DATE",
      "EVALUATIONS.TIME", "EVALUATIONS.ORGANIZATION"
  };

  /**
   * Field that contains the comma separated fields of the EVALUATIONS table.
   */
  private static final String ALL_FIELDS = "EVALUATIONS.ID" +
                                           ",EVALUATIONS.IDORGANIZATION" +
                                           ",EVALUATIONS.IDUSER" +
                                           ",EVALUATIONS.DATE" +
                                           ",EVALUATIONS.TIME" +
                                           ",EVALUATIONS.ORGANIZATION";

  private static EvaluationsManager singleton = new EvaluationsManager();

  /**
   * Get the EvaluationsManager singleton.
   *
   * @return EvaluationsManager
   */
  synchronized public static EvaluationsManager getInstance() {
    return singleton;
  }

  /**
   * Sets your own EvaluationsManager instance.
   <br>
   * This is optional, by default we provide it for you.
   */
  synchronized public static void setInstance(EvaluationsManager instance) {
    singleton = instance;
  }

  /**
   * Creates a new EvaluationsBean instance.
   *
   * @return the new EvaluationsBean
   */
  public EvaluationsBean createEvaluationsBean() {
    return new EvaluationsBean();
  }

  //////////////////////////////////////
  // PRIMARY KEY METHODS
  //////////////////////////////////////

  /**
   * Loads a EvaluationsBean from the EVALUATIONS using its key fields.
   *
   * @return a unique EvaluationsBean
   */
  //12
  public EvaluationsBean loadByPrimaryKey(Integer id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM EVALUATIONS WHERE EVALUATIONS.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, id);
      EvaluationsBean pReturn[] = loadByPreparedStatement(ps);
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
      ps = c.prepareStatement("DELETE from EVALUATIONS WHERE EVALUATIONS.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, id);
      return ps.executeUpdate();
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  //////////////////////////////////////
  // FOREIGN KEY METHODS
  //////////////////////////////////////

  /**
   * Loads EvaluationsBean array from the EVALUATIONS table using its IDORGANIZATION field.
   *
   * @return an array of EvaluationsBean
   */
  // LOAD BY IMPORTED KEY
  public EvaluationsBean[] loadByIdorganization(Integer value) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM EVALUATIONS WHERE IDORGANIZATION=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, value);
      return loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Deletes from the EVALUATIONS table by IDORGANIZATION field.
   *
   * @param value the key value to seek
   * @return the number of rows deleted
   */
  // DELETE BY IMPORTED KEY
  public int deleteByIdorganization(Integer value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE FROM EVALUATIONS WHERE IDORGANIZATION=?");
      Manager.setInteger(ps, 1, value);
      return ps.executeUpdate();
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Loads EvaluationsBean array from the EVALUATIONS table using its IDUSER field.
   *
   * @return an array of EvaluationsBean
   */
  // LOAD BY IMPORTED KEY
  public EvaluationsBean[] loadByIduser(String value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM EVALUATIONS WHERE IDUSER=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, value);
      return loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Deletes from the EVALUATIONS table by IDUSER field.
   *
   * @param value the key value to seek
   * @return the number of rows deleted
   */
  // DELETE BY IMPORTED KEY
  public int deleteByIduser(String value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE FROM EVALUATIONS WHERE IDUSER=?");
      ps.setString(1, value);
      return ps.executeUpdate();
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  //////////////////////////////////////
  // GET/SET FOREIGN KEY BEAN METHOD
  //////////////////////////////////////
  /**
   * Retrieves the OrganizationsBean object from the EVALUATIONS.ID field.
   *
   * @param pObject the EvaluationsBean
   * @return the associated OrganizationsBean pObject
   */
  // GET IMPORTED
  public OrganizationBean getOrganizationsBean(EvaluationsBean pObject) throws
      SQLException {
    OrganizationBean other = OrganizationsManager.getInstance().
                             createOrganizationsBean();
    other.setId(pObject.getIdorganization());
    return OrganizationsManager.getInstance().loadUniqueUsingTemplate(other);
  }

  /**
   * Associates the EvaluationsBean object to the OrganizationsBean object.
   *
   * @param pObject the EvaluationsBean object to use
   * @param pObjectToBeSet the OrganizationsBean object to associate to the EvaluationsBean
   * @return the associated OrganizationsBean pObject
   */
  // SET IMPORTED
  public EvaluationsBean setOrganizationsBean(EvaluationsBean pObject,
                                              OrganizationBean pObjectToBeSet) {
    pObject.setIdorganization(pObjectToBeSet.getId());
    return pObject;
  }

  /**
   * Retrieves the UsersBean object from the EVALUATIONS.LOGIN field.
   *
   * @param pObject the EvaluationsBean
   * @return the associated UsersBean pObject
   */
  // GET IMPORTED
  public UserBean getUsersBean(EvaluationsBean pObject) throws SQLException {
    UserBean other = UserManager.getInstance().createUserBean();
    other.setLogin(pObject.getIduser());
    return UserManager.getInstance().loadUniqueUsingTemplate(other);
  }

  /**
   * Associates the EvaluationsBean object to the UsersBean object.
   *
   * @param pObject the EvaluationsBean object to use
   * @param pObjectToBeSet the UsersBean object to associate to the EvaluationsBean
   * @return the associated UsersBean pObject
   */
  // SET IMPORTED
  public EvaluationsBean setUsersBean(EvaluationsBean pObject,
                                      UserBean pObjectToBeSet) {
    pObject.setIduser(pObjectToBeSet.getLogin());
    return pObject;
  }

  //////////////////////////////////////
  // LOAD ALL
  //////////////////////////////////////

  /**
   * Loads all the rows from EVALUATIONS.
   *
   * @return an array of EvaluationsManager pObject
   */
  //38
  public EvaluationsBean[] loadAll() throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM EVALUATIONS",
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
   * Retrieves an array of EvaluationsBean given a sql 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the resulting EvaluationsBean table
   */
  //49
  public EvaluationsBean[] loadByWhere(String where) throws SQLException {
    return loadByWhere(where, null);
  }

  /**
   * Retrieves an array of EvaluationsBean given a sql where clause, and a list of fields.
   * You must use the 'WHERE' keyword.
   *
   * @param where the sql 'where' clause
   * @param fieldList table of the field's associated constants
   * @return the resulting EvaluationsBean table
   */
  //51
  public EvaluationsBean[] loadByWhere(String where, int[] fieldList) throws
      SQLException {
    String sql = null;
    if (fieldList == null) {
      sql = "select " + ALL_FIELDS + " from EVALUATIONS " + where;
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
      buff.append(" from EVALUATIONS ");
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

      return (EvaluationsBean[]) v.toArray(new EvaluationsBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      }
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows from the EVALUATIONS table using a 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the number of deleted rows
   */
  public int deleteWhere(String where) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      String delByWhereSQL = "DELETE FROM EVALUATIONS WHERE " + where;
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
   * Saves the EvaluationsBean pObject into the database.
   *
   * @param pObject the EvaluationsBean pObject to be saved
   */
  //100
  public EvaluationsBean save(EvaluationsBean pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;

    try {
      c = getConnection();
      if (pObject.isNew()) { // SAVE
        beforeInsert(pObject); // listener callback
        int _dirtyCount = 0;
        _sql = new StringBuffer("INSERT into EVALUATIONS (");

        /*if (pObject.isIdModified()) {
            if (_dirtyCount>0) {
                _sql.append(",");
            }
            _sql.append("ID");
            _dirtyCount++;
                         }*/

        if (pObject.isIdorganizationModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("IDORGANIZATION");
          _dirtyCount++;
        }

        if (pObject.isIduserModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("IDUSER");
          _dirtyCount++;
        }

        if (pObject.isDateModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("DATE");
          _dirtyCount++;
        }

        if (pObject.isTimeModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("TIME");
          _dirtyCount++;
        }

        if (pObject.isOrganizationModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("ORGANIZATION");
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

        if (pObject.isIdorganizationModified()) {
          Manager.setInteger(ps, ++_dirtyCount, pObject.getIdorganization());
        }

        if (pObject.isIduserModified()) {
          ps.setString(++_dirtyCount, pObject.getIduser());
        }

        if (pObject.isDateModified()) {
          if (pObject.getDate() == null) {
            ps.setNull(++_dirtyCount, Types.DATE);
          }
          else {
            ps.setDate(++_dirtyCount,
                       new java.sql.Date(pObject.getDate().getTime()));
          }
        }

        if (pObject.isTimeModified()) {
          if (pObject.getTime() == null) {
            ps.setNull(++_dirtyCount, Types.TIME);
          }
          else {
            ps.setTime(++_dirtyCount,
                       new java.sql.Time(pObject.getTime().getTime()));
          }
        }

        if (pObject.isOrganizationModified()) {
          ps.setString(++_dirtyCount, pObject.getOrganization());
        }

        ps.executeUpdate();
        /*if (!pObject.isIdModified())
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
        _sql = new StringBuffer("UPDATE EVALUATIONS SET ");
        boolean useComma = false;

        /*if (pObject.isIdModified()) {
            if (useComma) {
                _sql.append(",");
            } else {
                useComma=true;
            }
            _sql.append("ID").append("=?");
                         }*/

        if (pObject.isIdorganizationModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("IDORGANIZATION").append("=?");
        }

        if (pObject.isIduserModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("IDUSER").append("=?");
        }

        if (pObject.isDateModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("DATE").append("=?");
        }

        if (pObject.isTimeModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("TIME").append("=?");
        }

        if (pObject.isOrganizationModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("ORGANIZATION").append("=?");
        }
        _sql.append(" WHERE ");
        _sql.append("EVALUATIONS.ID=?");
        ps = c.prepareStatement(_sql.toString(),
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        int _dirtyCount = 0;

        /*if (pObject.isIdModified()) {
              Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
                         }*/

        if (pObject.isIdorganizationModified()) {
          Manager.setInteger(ps, ++_dirtyCount, pObject.getIdorganization());
        }

        if (pObject.isIduserModified()) {
          ps.setString(++_dirtyCount, pObject.getIduser());
        }

        if (pObject.isDateModified()) {
          if (pObject.getDate() == null) {
            ps.setNull(++_dirtyCount, Types.DATE);
          }
          else {
            ps.setDate(++_dirtyCount,
                       new java.sql.Date(pObject.getDate().getTime()));
          }
        }

        if (pObject.isTimeModified()) {
          if (pObject.getTime() == null) {
            ps.setNull(++_dirtyCount, Types.TIME);
          }
          else {
            ps.setTime(++_dirtyCount,
                       new java.sql.Time(pObject.getTime().getTime()));
          }
        }

        if (pObject.isOrganizationModified()) {
          ps.setString(++_dirtyCount, pObject.getOrganization());
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
   * Saves an array of EvaluationsBean pObjects into the database.
   *
   * @param pObjects the EvaluationsBean pObject table to be saved
   * @return the Objects to be saved
   * TODO: BATCH UPDATE
   */
  //65
  public EvaluationsBean[] save(EvaluationsBean[] pObjects) throws SQLException {
    for (int iIndex = 0; iIndex < pObjects.length; iIndex++) {
      save(pObjects[iIndex]);
    }
    return pObjects;
  }

  ///////////////////////////////////////////////////////////////////////
  // USING TEMPLATE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Loads a unique EvaluationsBean pObject from a template one giving a c
   *
   * @param pObject the EvaluationsBean pObject to look for
   * @return the pObject matching the template
   */
  //85
  public EvaluationsBean loadUniqueUsingTemplate(EvaluationsBean pObject) throws
      SQLException {
    EvaluationsBean[] pReturn = loadUsingTemplate(pObject);
    if (pReturn.length == 0) {
      return null;
    }
    if (pReturn.length > 1) {
      throw new SQLException("More than one element !!");
    }
    return pReturn[0];
  }

  /**
   * Loads an array of EvaluationsBean from a template one.
   *
   * @param pObject the EvaluationsBean template to look for
   * @return all the EvaluationsBean matching the template
   */
  //88
  public EvaluationsBean[] loadUsingTemplate(EvaluationsBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer where = new StringBuffer("");
    StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS +
                                         " from EVALUATIONS WHERE ");
    StringBuffer _sqlWhere = new StringBuffer("");
    try {
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isIdorganizationModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDORGANIZATION= ?");
      }

      if (pObject.isIduserModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDUSER= ?");
      }

      if (pObject.isDateModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("DATE= ?");
      }

      if (pObject.isTimeModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("TIME= ?");
      }

      if (pObject.isOrganizationModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ORGANIZATION= ?");
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

      if (pObject.isIdorganizationModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdorganization());
      }

      if (pObject.isIduserModified()) {
        ps.setString(++_dirtyCount, pObject.getIduser());
      }

      if (pObject.isDateModified()) {
        if (pObject.getDate() == null) {
          ps.setNull(++_dirtyCount, Types.DATE);
        }
        else {
          ps.setDate(++_dirtyCount, new java.sql.Date(pObject.getDate().getTime()));
        }
      }

      if (pObject.isTimeModified()) {
        if (pObject.getTime() == null) {
          ps.setNull(++_dirtyCount, Types.TIME);
        }
        else {
          ps.setTime(++_dirtyCount, new java.sql.Time(pObject.getTime().getTime()));
        }
      }

      if (pObject.isOrganizationModified()) {
        ps.setString(++_dirtyCount, pObject.getOrganization());
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
   * Deletes rows using a EvaluationsBean template.
   *
   * @param pObject the EvaluationsBean object(s) to be deleted
   * @return the number of deleted objects
   */
  //63
  public int deleteUsingTemplate(EvaluationsBean pObject) throws SQLException {
    if (pObject.isIdInitialized()) {
      return deleteByPrimaryKey(pObject.getId());
    }

    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer sql = null;

    try {
      sql = new StringBuffer("DELETE FROM EVALUATIONS WHERE ");
      int _dirtyAnd = 0;
      if (pObject.isIdInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ID").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isIdorganizationInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("IDORGANIZATION").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isIduserInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("IDUSER").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isDateInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("DATE").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isTimeInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("TIME").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isOrganizationInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ORGANIZATION").append("=?");
        _dirtyAnd++;
      }

      c = getConnection();
      ps = c.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      int _dirtyCount = 0;

      if (pObject.isIdInitialized()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
      }

      if (pObject.isIdorganizationInitialized()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdorganization());
      }

      if (pObject.isIduserInitialized()) {
        ps.setString(++_dirtyCount, pObject.getIduser());
      }

      if (pObject.isDateInitialized()) {
        if (pObject.getDate() == null) {
          ps.setNull(++_dirtyCount, Types.DATE);
        }
        else {
          ps.setDate(++_dirtyCount, new java.sql.Date(pObject.getDate().getTime()));
        }
      }

      if (pObject.isTimeInitialized()) {
        if (pObject.getTime() == null) {
          ps.setNull(++_dirtyCount, Types.TIME);
        }
        else {
          ps.setTime(++_dirtyCount, new java.sql.Time(pObject.getTime().getTime()));
        }
      }

      if (pObject.isOrganizationInitialized()) {
        ps.setString(++_dirtyCount, pObject.getOrganization());
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
   * Retrieves an array of QuestionsBean using the relation table Evaluationsdetail given a EvaluationsBean object.
   *
   * @param pObject the EvaluationsBean pObject to be used
   * @return an array of QuestionsBean
   */
  // MANY TO MANY
  public QuestionsBean[] loadQuestionsViaEvaluationsdetail(EvaluationsBean
      pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT " + "        *" + " FROM  " +
                    "        QUESTIONS,EVALUATIONSDETAIL" + " WHERE " +
                    "     EVALUATIONSDETAIL.IDEVALUATION = ?" +
                    " AND EVALUATIONSDETAIL.IDQUESTION = QUESTIONS.ID";
    try {
      c = getConnection();
      ps = c.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, pObject.getId());
      return QuestionsManager.getInstance().loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Retrieves an array of ResponsesBean using the relation table Evaluationsdetail given a EvaluationsBean object.
   *
   * @param pObject the EvaluationsBean pObject to be used
   * @return an array of ResponsesBean
   */
  // MANY TO MANY
  public ResponseBean[] loadResponsesViaEvaluationsdetail(EvaluationsBean
      pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT " + "        *" + " FROM  " +
                    "        RESPONSES,EVALUATIONSDETAIL" + " WHERE " +
                    "     EVALUATIONSDETAIL.IDEVALUATION = ?" +
                    " AND EVALUATIONSDETAIL.IDRESPONSE = RESPONSES.ID";
    try {
      c = getConnection();
      ps = c.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, pObject.getId());
      return ResponseManager.getInstance().loadByPreparedStatement(ps);
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
   * Retrieves the number of rows of the table EVALUATIONS.
   *
   * @return the number of rows returned
   */
  //78
  public int count() throws SQLException {
    return countWhere("");
  }

  /**
   * Retrieves the number of rows of the table EVALUATIONS with a 'where' clause.
   * You must use the 'WHERE' keyword.
   *
   * @param where the restriction clause
   * @return the number of rows returned
   */
  public int countWhere(String where) throws SQLException {
    String sql = "select count(*) as MCOUNT from EVALUATIONS " + where;
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
   * Retrieves the number of rows of the table EVALUATIONS with a prepared statement.
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
   * Looks for the number of elements of a specific EvaluationsBean pObject given a c
   *
   * @param pObject the EvaluationsBean pObject to look for
   * @return the number of rows returned
   */
  //83
  public int countUsingTemplate(EvaluationsBean pObject) throws SQLException {
    StringBuffer where = new StringBuffer("");
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;
    StringBuffer _sqlWhere = null;

    try {
      _sql = new StringBuffer(
          "SELECT count(*) as MCOUNT  from EVALUATIONS WHERE ");
      _sqlWhere = new StringBuffer("");
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isIdorganizationModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDORGANIZATION= ?");
      }

      if (pObject.isIduserModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDUSER= ?");
      }

      if (pObject.isDateModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("DATE= ?");
      }

      if (pObject.isTimeModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("TIME= ?");
      }

      if (pObject.isOrganizationModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ORGANIZATION= ?");
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

      if (pObject.isIdorganizationModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdorganization());
      }

      if (pObject.isIduserModified()) {
        ps.setString(++_dirtyCount, pObject.getIduser());
      }

      if (pObject.isDateModified()) {
        if (pObject.getDate() == null) {
          ps.setNull(++_dirtyCount, Types.DATE);
        }
        else {
          ps.setDate(++_dirtyCount, new java.sql.Date(pObject.getDate().getTime()));
        }
      }

      if (pObject.isTimeModified()) {
        if (pObject.getTime() == null) {
          ps.setNull(++_dirtyCount, Types.TIME);
        }
        else {
          ps.setTime(++_dirtyCount, new java.sql.Time(pObject.getTime().getTime()));
        }
      }

      if (pObject.isOrganizationModified()) {
        ps.setString(++_dirtyCount, pObject.getOrganization());
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
   * Transforms a ResultSet iterating on the EVALUATIONS on a EvaluationsBean pObject.
   *
   * @param rs the ResultSet to be transformed
   * @return pObject resulting EvaluationsBean pObject
   */
  //72
  public EvaluationsBean decodeRow(ResultSet rs) throws SQLException {
    EvaluationsBean pObject = createEvaluationsBean();
    pObject.setId(Manager.getInteger(rs, 1));
    pObject.setIdorganization(Manager.getInteger(rs, 2));
    pObject.setIduser(rs.getString(3));
    pObject.setDate(rs.getDate(4));
    pObject.setTime(rs.getTime(5));
    pObject.setOrganization(rs.getString(6));

    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  /**
   * Transforms a ResultSet iterating on the EVALUATIONS table on a EvaluationsBean pObject according to a list of fields.
   *
   * @param rs the ResultSet to be transformed
   * @param fieldList table of the field's associated constants
   * @return pObject resulting EvaluationsBean pObject
   */
  //73
  public EvaluationsBean decodeRow(ResultSet rs, int[] fieldList) throws
      SQLException {
    EvaluationsBean pObject = createEvaluationsBean();
    int pos = 0;
    for (int i = 0; i < fieldList.length; i++) {
      switch (fieldList[i]) {
        case ID_ID:
          ++pos;
          pObject.setId(Manager.getInteger(rs, pos));
          break;
        case ID_IDORGANIZATION:
          ++pos;
          pObject.setIdorganization(Manager.getInteger(rs, pos));
          break;
        case ID_IDUSER:
          ++pos;
          pObject.setIduser(rs.getString(pos));
          break;
        case ID_DATE:
          ++pos;
          pObject.setDate(rs.getDate(pos));
          break;
        case ID_TIME:
          ++pos;
          pObject.setTime(rs.getTime(pos));
          break;
        case ID_ORGANIZATION:
          ++pos;
          pObject.setOrganization(rs.getString(pos));
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
   * @return an array of EvaluationsBean
   */
  //41
  public EvaluationsBean[] loadByPreparedStatement(PreparedStatement ps) throws
      SQLException {
    return loadByPreparedStatement(ps, null);
  }

  /**
   * Loads all the elements using a prepared statement specifying a list of fields to be retrieved.
   *
   * @param ps the PreparedStatement to be used
   * @param fieldList table of the field's associated constants
   * @return an array of EvaluationsBean
   */
  public EvaluationsBean[] loadByPreparedStatement(PreparedStatement ps,
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
      return (EvaluationsBean[]) v.toArray(new EvaluationsBean[0]);
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
  private EvaluationsListener listener = null;

  /**
   * Registers a unique EvaluationsListener listener.
   */
  //66.5
  public void registerListener(EvaluationsListener listener) {
    this.listener = listener;
  }

  /**
   * Before the save of the EvaluationsBean pObject.
   *
   * @param pObject the EvaluationsBean pObject to be saved
   */
  //67
  void beforeInsert(EvaluationsBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeInsert(pObject);
    }
  }

  /**
   * After the save of the EvaluationsBean pObject.
   *
   * @param pObject the EvaluationsBean pObject to be saved
   */
  //68
  void afterInsert(EvaluationsBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterInsert(pObject);
    }
  }

  /**
   * Before the update of the EvaluationsBean pObject.
   *
   * @param pObject the EvaluationsBean pObject to be updated
   */
  //69
  void beforeUpdate(EvaluationsBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeUpdate(pObject);
    }
  }

  /**
   * After the update of the EvaluationsBean pObject.
   *
   * @param pObject the EvaluationsBean pObject to be updated
   */
  //70
  void afterUpdate(EvaluationsBean pObject) throws SQLException {
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

//1399
