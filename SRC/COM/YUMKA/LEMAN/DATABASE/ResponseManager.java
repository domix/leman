package com.yumka.leman.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * Handles database calls for the RESPONSES table.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class ResponseManager {

  /**
   * Column ID of type Types.INTEGER mapped to Integer.
   */
  public static final int ID_ID = 0;
  public static final int TYPE_ID = Types.INTEGER;
  public static final String NAME_ID = "ID";

  /**
   * Column MESSAGE of type Types.VARCHAR mapped to String.
   */
  public static final int ID_MESSAGE = 1;
  public static final int TYPE_MESSAGE = Types.VARCHAR;
  public static final String NAME_MESSAGE = "MESSAGE";

  private static final String TABLE_NAME = "RESPONSES";

  /**
   * Create an array of type string containing all the fields of the RESPONSES table.
   */
  private static final String[] FIELD_NAMES = {"RESPONSES.ID",
                                              "RESPONSES.MESSAGE"
  };

  /**
   * Field that contains the comma separated fields of the RESPONSES table.
   */
  private static final String ALL_FIELDS = "RESPONSES.ID" +
                                           ",RESPONSES.MESSAGE";

  private static ResponseManager singleton = new ResponseManager();

  /**
   * Get the ResponsesManager singleton.
   *
   * @return ResponsesManager
   */
  synchronized public static ResponseManager getInstance() {
    return singleton;
  }

  /**
   * Sets your own ResponsesManager instance. <br>
   * This is optional, by default we provide it for you.
   * @param instance ResponsesManager
   */
  synchronized public static void setInstance(ResponseManager instance) {
    singleton = instance;
  }

  /**
   * Creates a new ResponsesBean instance.
   *
   * @return the new ResponsesBean
   */
  public ResponseBean createResponsesBean() {
    return new ResponseBean();
  }

  //////////////////////////////////////
  // PRIMARY KEY METHODS
  //////////////////////////////////////
  /**
   * Loads a ResponsesBean from the RESPONSES using its key fields.
   * @param id Integer
   * @throws SQLException
   * @return ResponseBean a unique ResponsesBean
   */
  public ResponseBean loadByPrimaryKey(Integer id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM RESPONSES WHERE RESPONSES.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, id);
      ResponseBean pReturn[] = loadByPreparedStatement(ps);
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
   * @param id Integer
   * @throws SQLException
   * @return int the number of deleted rows
   */
  public int deleteByPrimaryKey(Integer id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE from RESPONSES WHERE RESPONSES.ID=?",
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
  // LOAD ALL
  //////////////////////////////////////
  /**
   * Loads all the rows from RESPONSES.
   * @throws SQLException
   * @return ResponseBean[] an array of ResponsesManager pObject
   */
  public ResponseBean[] loadAll() throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM RESPONSES",
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
   * Retrieves an array of ResponsesBean given a sql 'where' clause.
   * @param where String where the sql 'where' clause
   * @throws SQLException
   * @return ResponseBean[] the resulting ResponsesBean table
   */
  public ResponseBean[] loadByWhere(String where) throws SQLException {
    return loadByWhere(where, null);
  }

  /**
   * Retrieves an array of ResponsesBean given a sql where clause, and a list
   * of fields. You must use the 'WHERE' keyword.
   * @param where String where the sql 'where' clause
   * @param fieldList int[] fieldList table of the field's associated constants
   * @throws SQLException
   * @return ResponseBean[] the resulting ResponsesBean table
   */
  public ResponseBean[] loadByWhere(String where, int[] fieldList) throws
      SQLException {
    String sql = null;
    if (fieldList == null) {
      sql = "select " + ALL_FIELDS + " from RESPONSES " + where;
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
      buff.append(" from RESPONSES ");
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

      return (ResponseBean[]) v.toArray(new ResponseBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      }
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows from the RESPONSES table using a 'where' clause.
   * @param where String where the sql 'where' clause
   * @throws SQLException
   * @return int the number of deleted rows
   */
  public int deleteWhere(String where) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      String delByWhereSQL = "DELETE FROM RESPONSES WHERE " + where;
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
   * Saves the ResponsesBean pObject into the database.
   * @param pObject ResponseBean pObject the ResponsesBean pObject to be saved
   * @throws SQLException
   * @return ResponseBean
   */
  public ResponseBean save(ResponseBean pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;

    try {
      c = getConnection();
      if (pObject.isNew()) { // SAVE
        beforeInsert(pObject); // listener callback
        int _dirtyCount = 0;
        _sql = new StringBuffer("INSERT into RESPONSES (");

        /*if (pObject.isIdModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("ID");
          _dirtyCount++;
                 }*/

        if (pObject.isMessageModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("MESSAGE");
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

        if (pObject.isMessageModified()) {
          ps.setString(++_dirtyCount, pObject.getMessage());
        }

        ps.executeUpdate();
        /*if (!pObject.isIdModified()) {
          ResultSet rs = ps.getGeneratedKeys();
          try {
            if (rs.next()) {
              pObject.setId(Manager.getInteger(rs, 1));
            }
            else {
              getManager().log(
                  "ATTENTION: Could not retrieve auto generated key!");
            }
          }
          finally {
            getManager().close(rs);
          }
                 }*/

        pObject.isNew(false);
        pObject.resetIsModified();
        afterInsert(pObject); // listener callback
      }
      else { // UPDATE
        beforeUpdate(pObject); // listener callback
        _sql = new StringBuffer("UPDATE RESPONSES SET ");
        boolean useComma = false;

        /*if (pObject.isIdModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("ID").append("=?");
                 }*/

        if (pObject.isMessageModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("MESSAGE").append("=?");
        }
        _sql.append(" WHERE ");
        _sql.append("RESPONSES.ID=?");
        ps = c.prepareStatement(_sql.toString(),
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        int _dirtyCount = 0;

        /*if (pObject.isIdModified()) {
          Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
                 }*/

        if (pObject.isMessageModified()) {
          ps.setString(++_dirtyCount, pObject.getMessage());
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
   * Saves an array of ResponsesBean pObjects into the database.
   * @param pObjects ResponseBean[] pObjects the ResponsesBean pObject table to be saved
   * @throws SQLException
   * @return ResponseBean[] the Objects to be saved
   * @todo BATCH UPDATE
   */
  public ResponseBean[] save(ResponseBean[] pObjects) throws SQLException {
    for (int iIndex = 0; iIndex < pObjects.length; iIndex++) {
      save(pObjects[iIndex]);
    }
    return pObjects;
  }

  ///////////////////////////////////////////////////////////////////////
  // USING TEMPLATE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Loads a unique ResponsesBean pObject from a template one giving a c
   * @param pObject ResponseBean pObject the ResponsesBean pObject to look for
   * @throws SQLException
   * @return ResponseBean the pObject matching the template
   */
  public ResponseBean loadUniqueUsingTemplate(ResponseBean pObject) throws
      SQLException {
    ResponseBean[] pReturn = loadUsingTemplate(pObject);
    if (pReturn.length == 0) {
      return null;
    }
    if (pReturn.length > 1) {
      throw new SQLException("More than one element !!");
    }
    return pReturn[0];
  }

  /**
   * Loads an array of ResponsesBean from a template one.
   * @param pObject ResponseBean pObject the ResponsesBean template to look for
   * @throws SQLException
   * @return ResponseBean[] all the ResponsesBean matching the template
   */
  public ResponseBean[] loadUsingTemplate(ResponseBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer where = new StringBuffer("");
    StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS +
                                         " from RESPONSES WHERE ");
    StringBuffer _sqlWhere = new StringBuffer("");
    try {
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isMessageModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("MESSAGE= ?");
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

      if (pObject.isMessageModified()) {
        ps.setString(++_dirtyCount, pObject.getMessage());
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
   * Deletes rows using a ResponsesBean template.
   * @param pObject ResponseBean pObject the ResponsesBean object(s) to be deleted
   * @throws SQLException
   * @return int the number of deleted objects
   */
  public int deleteUsingTemplate(ResponseBean pObject) throws SQLException {
    if (pObject.isIdInitialized()) {
      return deleteByPrimaryKey(pObject.getId());
    }

    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer sql = null;

    try {
      sql = new StringBuffer("DELETE FROM RESPONSES WHERE ");
      int _dirtyAnd = 0;
      if (pObject.isIdInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ID").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isMessageInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("MESSAGE").append("=?");
        _dirtyAnd++;
      }

      c = getConnection();
      ps = c.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      int _dirtyCount = 0;

      if (pObject.isIdInitialized()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
      }

      if (pObject.isMessageInitialized()) {
        ps.setString(++_dirtyCount, pObject.getMessage());
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
  // MANY TO MANY
  /**
   * Retrieves an array of EvaluationsBean using the relation table Evaluationsdetail given a ResponsesBean object.
   * @param pObject ResponseBean pObject the ResponsesBean pObject to be used
   * @throws SQLException
   * @return EvaluationsBean[] an array of EvaluationsBean
   */
  public EvaluationsBean[] loadEvaluationsViaEvaluationsdetail(ResponseBean
      pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT " + "        *" + " FROM  " +
                    "        EVALUATIONS,EVALUATIONSDETAIL" + " WHERE " +
                    "     EVALUATIONSDETAIL.IDRESPONSE = ?" +
                    " AND EVALUATIONSDETAIL.IDEVALUATION = EVALUATIONS.ID";
    try {
      c = getConnection();
      ps = c.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, pObject.getId());
      return EvaluationsManager.getInstance().loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  // MANY TO MANY
  /**
   * Retrieves an array of QuestionsBean using the relation table
   * Evaluationsdetail given a ResponsesBean object.
   * @param pObject ResponseBean pObject the ResponsesBean pObject to be used
   * @throws SQLException
   * @return QuestionsBean[] an array of QuestionsBean
   */
  public QuestionsBean[] loadQuestionsViaEvaluationsdetail(ResponseBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT " + "        *" + " FROM  " +
                    "        QUESTIONS,EVALUATIONSDETAIL" + " WHERE " +
                    "     EVALUATIONSDETAIL.IDRESPONSE = ?" +
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

  ///////////////////////////////////////////////////////////////////////
  // COUNT
  ///////////////////////////////////////////////////////////////////////
  /**
   * Retrieves the number of rows of the table RESPONSES.
   * @throws SQLException
   * @return int the number of rows returned
   */
  public int count() throws SQLException {
    return countWhere("");
  }

  /**
   * Retrieves the number of rows of the table RESPONSES with a 'where' clause.
   * You must use the 'WHERE' keyword.
   * @param where String where the restriction clause
   * @throws SQLException
   * @return int the number of rows returned
   */
  public int countWhere(String where) throws SQLException {
    String sql = "select count(*) as MCOUNT from RESPONSES " + where;
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
   * Retrieves the number of rows of the table RESPONSES with a prepared statement.
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
   * Looks for the number of elements of a specific ResponsesBean pObject given a c
   * @param pObject ResponseBean pObject the ResponsesBean pObject to look for
   * @throws SQLException
   * @return int the number of rows returned
   */
  public int countUsingTemplate(ResponseBean pObject) throws SQLException {
    StringBuffer where = new StringBuffer("");
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;
    StringBuffer _sqlWhere = null;

    try {
      _sql = new StringBuffer(
          "SELECT count(*) as MCOUNT  from RESPONSES WHERE ");
      _sqlWhere = new StringBuffer("");
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isMessageModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("MESSAGE= ?");
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
      if (pObject.isMessageModified()) {
        ps.setString(++_dirtyCount, pObject.getMessage());
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
   * Transforms a ResultSet iterating on the RESPONSES on a ResponsesBean pObject.
   * @param rs ResultSet rs the ResultSet to be transformed
   * @throws SQLException
   * @return ResponseBean pObject resulting ResponsesBean pObject
   */
  public ResponseBean decodeRow(ResultSet rs) throws SQLException {
    ResponseBean pObject = createResponsesBean();
    pObject.setId(Manager.getInteger(rs, 1));
    pObject.setMessage(rs.getString(2));

    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  /**
   * Transforms a ResultSet iterating on the RESPONSES table on a ResponsesBean
   * pObject according to a list of fields.
   * @param rs ResultSet the ResultSet to be transformed
   * @param fieldList int[] table of the field's associated constants
   * @throws SQLException
   * @return ResponseBean pObject resulting ResponsesBean pObject
   */
  public ResponseBean decodeRow(ResultSet rs, int[] fieldList) throws
      SQLException {
    ResponseBean pObject = createResponsesBean();
    int pos = 0;
    for (int i = 0; i < fieldList.length; i++) {
      switch (fieldList[i]) {
        case ID_ID:
          ++pos;
          pObject.setId(Manager.getInteger(rs, pos));
          break;
        case ID_MESSAGE:
          ++pos;
          pObject.setMessage(rs.getString(pos));
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
   * @param ps PreparedStatement ps the PreparedStatement to be used
   * @throws SQLException
   * @return ResponseBean[] an array of ResponsesBean
   */
  public ResponseBean[] loadByPreparedStatement(PreparedStatement ps) throws
      SQLException {
    return loadByPreparedStatement(ps, null);
  }

  /**
   * Loads all the elements using a prepared statement specifying a list of
   * fields to be retrieved.
   * @param ps PreparedStatement ps the PreparedStatement to be used
   * @param fieldList int[] fieldList table of the field's associated constants
   * @throws SQLException
   * @return ResponseBean[] an array of ResponsesBean
   */
  public ResponseBean[] loadByPreparedStatement(PreparedStatement ps,
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
      return (ResponseBean[]) v.toArray(new ResponseBean[0]);
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
  private ResponseListener listener = null;

  /**
   * Registers a unique ResponsesListener listener.
   * @param listener ResponsesListener
   */
  public void registerListener(ResponseListener listener) {
    this.listener = listener;
  }

  /**
   * Before the save of the ResponsesBean pObject.
   * @param pObject ResponseBean pObject the ResponsesBean pObject to be saved
   * @throws SQLException
   */
  void beforeInsert(ResponseBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeInsert(pObject);
    }
  }

  /**
   * After the save of the ResponsesBean pObject.
   * @param pObject ResponseBean pObject the ResponsesBean pObject to be saved
   * @throws SQLException
   */
  void afterInsert(ResponseBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterInsert(pObject);
    }
  }

  /**
   * Before the update of the ResponsesBean pObject.
   * @param pObject ResponseBean pObject the ResponsesBean pObject to be updated
   * @throws SQLException
   */
  void beforeUpdate(ResponseBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeUpdate(pObject);
    }
  }

  /**
   * After the update of the ResponsesBean pObject.
   * @param pObject ResponseBean pObject the ResponsesBean pObject to be updated
   * @throws SQLException
   */
  void afterUpdate(ResponseBean pObject) throws SQLException {
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
   * @throws SQLException
   * @return Connection
   */
  Connection getConnection() throws SQLException {
    return getManager().getConnection();
  }
}
