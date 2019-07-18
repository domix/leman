package com.yumka.leman.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * Handles database calls for the ISOPOINTS table.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class ISOPointManager {

  /**
   * Column ID of type Types.VARCHAR mapped to String.
   */
  public static final int ID_ID = 0;
  public static final int TYPE_ID = Types.VARCHAR;
  public static final String NAME_ID = "ID";

  /**
   * Column DESCRIPTION of type Types.VARCHAR mapped to String.
   */
  public static final int ID_DESCRIPTION = 1;
  public static final int TYPE_DESCRIPTION = Types.VARCHAR;
  public static final String NAME_DESCRIPTION = "DESCRIPTION";

  /**
   * Column IDISOPOINT of type Types.VARCHAR mapped to String.
   */
  public static final int ID_IDISOPOINT = 2;
  public static final int TYPE_IDISOPOINT = Types.VARCHAR;
  public static final String NAME_IDISOPOINT = "IDISOPOINT";

  private static final String TABLE_NAME = "ISOPOINTS";

  /**
   * Create an array of type string containing all the fields of the ISOPOINTS table.
   */
  private static final String[] FIELD_NAMES = {"ISOPOINTS.ID",
                                              "ISOPOINTS.DESCRIPTION",
                                              "ISOPOINTS.IDISOPOINT"
  };

  /**
   * Field that contains the comma separated fields of the ISOPOINTS table.
   */
  private static final String ALL_FIELDS = "ISOPOINTS.ID" +
                                           ",ISOPOINTS.DESCRIPTION" +
                                           ",ISOPOINTS.IDISOPOINT";

  private static ISOPointManager singleton = new ISOPointManager();

  /**
   * Get the IsopointsManager singleton.
   *
   * @return IsopointsManager
   */
  synchronized public static ISOPointManager getInstance() {
    return singleton;
  }

  /**
   * Sets your own IsopointsManager instance.<br>
   * This is optional, by default we provide it for you.
   * @param instance IsopointsManager
   */
  synchronized public static void setInstance(ISOPointManager instance) {
    singleton = instance;
  }

  /**
   * Creates a new IsopointsBean instance.
   *
   * @return the new IsopointsBean
   */
  public ISOPointBean createIsopointsBean() {
    return new ISOPointBean();
  }

  //////////////////////////////////////
  // PRIMARY KEY METHODS
  //////////////////////////////////////
  /**
   * Loads a IsopointsBean from the ISOPOINTS using its key fields.
   * @param id String
   * @throws SQLException
   * @return ISOPointBean a unique IsopointsBean
   */
  public ISOPointBean loadByPrimaryKey(String id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM ISOPOINTS WHERE ISOPOINTS.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, id);
      ISOPointBean pReturn[] = loadByPreparedStatement(ps);
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
   * @param id String
   * @throws SQLException
   * @return int the number of deleted rows
   */
  public int deleteByPrimaryKey(String id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE from ISOPOINTS WHERE ISOPOINTS.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, id);
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
   * Loads IsopointsBean array from the ISOPOINTS table using its IDISOPOINT field.
   *
   * @return an array of IsopointsBean
   */
  // LOAD BY IMPORTED KEY
  public ISOPointBean[] loadByIdisopoint(String value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM ISOPOINTS WHERE IDISOPOINT=?",
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
   * Deletes from the ISOPOINTS table by IDISOPOINT field.
   *
   * @param value the key value to seek
   * @return the number of rows deleted
   */
  // DELETE BY IMPORTED KEY
  public int deleteByIdisopoint(String value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE FROM ISOPOINTS WHERE IDISOPOINT=?");
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
   * Retrieves the IsopointsBean object from the ISOPOINTS.ID field.
   *
   * @param pObject the IsopointsBean
   * @return the associated IsopointsBean pObject
   */
  // GET IMPORTED
  public ISOPointBean getIsopointsBean(ISOPointBean pObject) throws
      SQLException {
    ISOPointBean other = ISOPointManager.getInstance().createIsopointsBean();
    other.setId(pObject.getIdisopoint());
    return ISOPointManager.getInstance().loadUniqueUsingTemplate(other);
  }

  /**
   * Associates the IsopointsBean object to the IsopointsBean object.
   *
   * @param pObject the IsopointsBean object to use
   * @param pObjectToBeSet the IsopointsBean object to associate to the IsopointsBean
   * @return the associated IsopointsBean pObject
   */
  // SET IMPORTED
  public ISOPointBean setIsopointsBean(ISOPointBean pObject,
                                       ISOPointBean pObjectToBeSet) {
    pObject.setIdisopoint(pObjectToBeSet.getId());
    return pObject;
  }

  //////////////////////////////////////
  // LOAD ALL
  //////////////////////////////////////

  /**
   * Loads all the rows from ISOPOINTS.
   *
   * @return an array of IsopointsManager pObject
   */
  //38
  public ISOPointBean[] loadAll() throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM ISOPOINTS",
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
   * Retrieves an array of IsopointsBean given a sql 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the resulting IsopointsBean table
   */
  //49
  public ISOPointBean[] loadByWhere(String where) throws SQLException {
    return loadByWhere(where, null);
  }

  /**
   * Retrieves an array of IsopointsBean given a sql where clause, and a list of fields.
   * You must use the 'WHERE' keyword.
   *
   * @param where the sql 'where' clause
   * @param fieldList table of the field's associated constants
   * @return the resulting IsopointsBean table
   */
  //51
  public ISOPointBean[] loadByWhere(String where, int[] fieldList) throws
      SQLException {
    String sql = null;
    if (fieldList == null) {
      sql = "select " + ALL_FIELDS + " from ISOPOINTS " + where;
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
      buff.append(" from ISOPOINTS ");
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

      return (ISOPointBean[]) v.toArray(new ISOPointBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      }
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows from the ISOPOINTS table using a 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the number of deleted rows
   */
  public int deleteWhere(String where) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      String delByWhereSQL = "DELETE FROM ISOPOINTS WHERE " + where;
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
   * Saves the IsopointsBean pObject into the database.
   *
   * @param pObject the IsopointsBean pObject to be saved
   */
  //100
  public ISOPointBean save(ISOPointBean pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;

    try {
      c = getConnection();
      if (pObject.isNew()) { // SAVE
        beforeInsert(pObject); // listener callback
        int _dirtyCount = 0;
        _sql = new StringBuffer("INSERT into ISOPOINTS (");

        if (pObject.isIdModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("ID");
          _dirtyCount++;
        }

        if (pObject.isDescriptionModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("DESCRIPTION");
          _dirtyCount++;
        }

        if (pObject.isIdisopointModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("IDISOPOINT");
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

        if (pObject.isIdModified()) {
          ps.setString(++_dirtyCount, pObject.getId());
        }

        if (pObject.isDescriptionModified()) {
          ps.setString(++_dirtyCount, pObject.getDescription());
        }

        if (pObject.isIdisopointModified()) {
          ps.setString(++_dirtyCount, pObject.getIdisopoint());
        }

        ps.executeUpdate();

        pObject.isNew(false);
        pObject.resetIsModified();
        afterInsert(pObject); // listener callback
      }
      else { // UPDATE
        beforeUpdate(pObject); // listener callback
        _sql = new StringBuffer("UPDATE ISOPOINTS SET ");
        boolean useComma = false;

        if (pObject.isIdModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("ID").append("=?");
        }

        if (pObject.isDescriptionModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("DESCRIPTION").append("=?");
        }

        if (pObject.isIdisopointModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("IDISOPOINT").append("=?");
        }
        _sql.append(" WHERE ");
        _sql.append("ISOPOINTS.ID=?");
        ps = c.prepareStatement(_sql.toString(),
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        int _dirtyCount = 0;

        if (pObject.isIdModified()) {
          ps.setString(++_dirtyCount, pObject.getId());
        }

        if (pObject.isDescriptionModified()) {
          ps.setString(++_dirtyCount, pObject.getDescription());
        }

        if (pObject.isIdisopointModified()) {
          ps.setString(++_dirtyCount, pObject.getIdisopoint());
        }

        if (_dirtyCount == 0) {
          return pObject;
        }

        ps.setString(++_dirtyCount, pObject.getId());
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
   * Saves an array of IsopointsBean pObjects into the database.
   *
   * @param pObjects the IsopointsBean pObject table to be saved
   * @return the Objects to be saved
   * TODO: BATCH UPDATE
   */
  //65
  public ISOPointBean[] save(ISOPointBean[] pObjects) throws SQLException {
    for (int iIndex = 0; iIndex < pObjects.length; iIndex++) {
      save(pObjects[iIndex]);
    }
    return pObjects;
  }

  ///////////////////////////////////////////////////////////////////////
  // USING TEMPLATE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Loads a unique IsopointsBean pObject from a template one giving a c
   *
   * @param pObject the IsopointsBean pObject to look for
   * @return the pObject matching the template
   */
  //85
  public ISOPointBean loadUniqueUsingTemplate(ISOPointBean pObject) throws
      SQLException {
    ISOPointBean[] pReturn = loadUsingTemplate(pObject);
    if (pReturn.length == 0) {
      return null;
    }
    if (pReturn.length > 1) {
      throw new SQLException("More than one element !!");
    }
    return pReturn[0];
  }

  /**
   * Loads an array of IsopointsBean from a template one.
   *
   * @param pObject the IsopointsBean template to look for
   * @return all the IsopointsBean matching the template
   */
  //88
  public ISOPointBean[] loadUsingTemplate(ISOPointBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer where = new StringBuffer("");
    StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS +
                                         " from ISOPOINTS WHERE ");
    StringBuffer _sqlWhere = new StringBuffer("");
    try {
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isDescriptionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("DESCRIPTION= ?");
      }

      if (pObject.isIdisopointModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDISOPOINT= ?");
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
        ps.setString(++_dirtyCount, pObject.getId());
      }

      if (pObject.isDescriptionModified()) {
        ps.setString(++_dirtyCount, pObject.getDescription());
      }

      if (pObject.isIdisopointModified()) {
        ps.setString(++_dirtyCount, pObject.getIdisopoint());
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
   * Deletes rows using a IsopointsBean template.
   *
   * @param pObject the IsopointsBean object(s) to be deleted
   * @return the number of deleted objects
   */
  //63
  public int deleteUsingTemplate(ISOPointBean pObject) throws SQLException {
    if (pObject.isIdInitialized()) {
      return deleteByPrimaryKey(pObject.getId());
    }

    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer sql = null;

    try {
      sql = new StringBuffer("DELETE FROM ISOPOINTS WHERE ");
      int _dirtyAnd = 0;
      if (pObject.isIdInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ID").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isDescriptionInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("DESCRIPTION").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isIdisopointInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("IDISOPOINT").append("=?");
        _dirtyAnd++;
      }

      c = getConnection();
      ps = c.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      int _dirtyCount = 0;

      if (pObject.isIdInitialized()) {
        ps.setString(++_dirtyCount, pObject.getId());
      }

      if (pObject.isDescriptionInitialized()) {
        ps.setString(++_dirtyCount, pObject.getDescription());
      }

      if (pObject.isIdisopointInitialized()) {
        ps.setString(++_dirtyCount, pObject.getIdisopoint());
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
  // COUNT
  ///////////////////////////////////////////////////////////////////////

  /**
   * Retrieves the number of rows of the table ISOPOINTS.
   *
   * @return the number of rows returned
   */
  //78
  public int count() throws SQLException {
    return countWhere("");
  }

  /**
   * Retrieves the number of rows of the table ISOPOINTS with a 'where' clause.
   * You must use the 'WHERE' keyword.
   *
   * @param where the restriction clause
   * @return the number of rows returned
   */
  public int countWhere(String where) throws SQLException {
    String sql = "select count(*) as MCOUNT from ISOPOINTS " + where;
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
   * Retrieves the number of rows of the table ISOPOINTS with a prepared statement.
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
   * Looks for the number of elements of a specific IsopointsBean pObject given a c
   *
   * @param pObject the IsopointsBean pObject to look for
   * @return the number of rows returned
   */
  //83
  public int countUsingTemplate(ISOPointBean pObject) throws SQLException {
    StringBuffer where = new StringBuffer("");
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;
    StringBuffer _sqlWhere = null;

    try {
      _sql = new StringBuffer(
          "SELECT count(*) as MCOUNT  from ISOPOINTS WHERE ");
      _sqlWhere = new StringBuffer("");
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isDescriptionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("DESCRIPTION= ?");
      }

      if (pObject.isIdisopointModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDISOPOINT= ?");
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
        ps.setString(++_dirtyCount, pObject.getId());
      }

      if (pObject.isDescriptionModified()) {
        ps.setString(++_dirtyCount, pObject.getDescription());
      }

      if (pObject.isIdisopointModified()) {
        ps.setString(++_dirtyCount, pObject.getIdisopoint());
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
   * Transforms a ResultSet iterating on the ISOPOINTS on a IsopointsBean pObject.
   *
   * @param rs the ResultSet to be transformed
   * @return pObject resulting IsopointsBean pObject
   */
  //72
  public ISOPointBean decodeRow(ResultSet rs) throws SQLException {
    ISOPointBean pObject = createIsopointsBean();
    pObject.setId(rs.getString(1));
    pObject.setDescription(rs.getString(2));
    pObject.setIdisopoint(rs.getString(3));

    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  /**
   * Transforms a ResultSet iterating on the ISOPOINTS table on a IsopointsBean pObject according to a list of fields.
   *
   * @param rs the ResultSet to be transformed
   * @param fieldList table of the field's associated constants
   * @return pObject resulting IsopointsBean pObject
   */
  //73
  public ISOPointBean decodeRow(ResultSet rs, int[] fieldList) throws
      SQLException {
    ISOPointBean pObject = createIsopointsBean();
    int pos = 0;
    for (int i = 0; i < fieldList.length; i++) {
      switch (fieldList[i]) {
        case ID_ID:
          ++pos;
          pObject.setId(rs.getString(pos));
          break;
        case ID_DESCRIPTION:
          ++pos;
          pObject.setDescription(rs.getString(pos));
          break;
        case ID_IDISOPOINT:
          ++pos;
          pObject.setIdisopoint(rs.getString(pos));
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
   * @return an array of IsopointsBean
   */
  //41
  public ISOPointBean[] loadByPreparedStatement(PreparedStatement ps) throws
      SQLException {
    return loadByPreparedStatement(ps, null);
  }

  /**
   * Loads all the elements using a prepared statement specifying a list of fields to be retrieved.
   *
   * @param ps the PreparedStatement to be used
   * @param fieldList table of the field's associated constants
   * @return an array of IsopointsBean
   */
  public ISOPointBean[] loadByPreparedStatement(PreparedStatement ps,
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
      return (ISOPointBean[]) v.toArray(new ISOPointBean[0]);
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
  private ISOPointListener listener = null;

  /**
   * Registers a unique IsopointsListener listener.
   */
  //66.5
  public void registerListener(ISOPointListener listener) {
    this.listener = listener;
  }

  /**
   * Before the save of the IsopointsBean pObject.
   *
   * @param pObject the IsopointsBean pObject to be saved
   */
  //67
  void beforeInsert(ISOPointBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeInsert(pObject);
    }
  }

  /**
   * After the save of the IsopointsBean pObject.
   *
   * @param pObject the IsopointsBean pObject to be saved
   */
  //68
  void afterInsert(ISOPointBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterInsert(pObject);
    }
  }

  /**
   * Before the update of the IsopointsBean pObject.
   *
   * @param pObject the IsopointsBean pObject to be updated
   */
  //69
  void beforeUpdate(ISOPointBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeUpdate(pObject);
    }
  }

  /**
   * After the update of the IsopointsBean pObject.
   *
   * @param pObject the IsopointsBean pObject to be updated
   */
  //70
  void afterUpdate(ISOPointBean pObject) throws SQLException {
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
}
