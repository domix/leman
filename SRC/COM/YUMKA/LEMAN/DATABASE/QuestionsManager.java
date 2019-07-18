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
 * Handles database calls for the QUESTIONS table.
 */
public class QuestionsManager
// extends+

// extends-
{

  /**
   * Column ID of type Types.VARCHAR mapped to String.
   */
  public static final int ID_ID = 0;
  public static final int TYPE_ID = Types.VARCHAR;
  public static final String NAME_ID = "ID";

  /**
   * Column TOPIC of type Types.VARCHAR mapped to String.
   */
  public static final int ID_TOPIC = 1;
  public static final int TYPE_TOPIC = Types.VARCHAR;
  public static final String NAME_TOPIC = "TOPIC";

  /**
   * Column QUESTION of type Types.VARCHAR mapped to String.
   */
  public static final int ID_QUESTION = 2;
  public static final int TYPE_QUESTION = Types.VARCHAR;
  public static final String NAME_QUESTION = "QUESTION";

  private static final String TABLE_NAME = "QUESTIONS";

  /**
   * Create an array of type string containing all the fields of the QUESTIONS table.
   */
  private static final String[] FIELD_NAMES = {"QUESTIONS.ID",
      "QUESTIONS.TOPIC", "QUESTIONS.QUESTION"
  };

  /**
   * Field that contains the comma separated fields of the QUESTIONS table.
   */
  private static final String ALL_FIELDS = "QUESTIONS.ID" + ",QUESTIONS.TOPIC" +
                                           ",QUESTIONS.QUESTION";

  private static QuestionsManager singleton = new QuestionsManager();

  /**
   * Get the QuestionsManager singleton.
   *
   * @return QuestionsManager
   */
  synchronized public static QuestionsManager getInstance() {
    return singleton;
  }

  /**
   * Sets your own QuestionsManager instance.
   <br>
   * This is optional, by default we provide it for you.
   */
  synchronized public static void setInstance(QuestionsManager instance) {
    singleton = instance;
  }

  /**
   * Creates a new QuestionsBean instance.
   *
   * @return the new QuestionsBean
   */
  public QuestionsBean createQuestionsBean() {
    return new QuestionsBean();
  }

  //////////////////////////////////////
  // PRIMARY KEY METHODS
  //////////////////////////////////////

  /**
   * Loads a QuestionsBean from the QUESTIONS using its key fields.
   *
   * @return a unique QuestionsBean
   */
  //12
  public QuestionsBean loadByPrimaryKey(String id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM QUESTIONS WHERE QUESTIONS.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, id);
      QuestionsBean pReturn[] = loadByPreparedStatement(ps);
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
  public int deleteByPrimaryKey(String id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE from QUESTIONS WHERE QUESTIONS.ID=?",
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
   * Loads QuestionsBean array from the QUESTIONS table using its TOPIC field.
   *
   * @return an array of QuestionsBean
   */
  // LOAD BY IMPORTED KEY
  public QuestionsBean[] loadByTopic(String value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM QUESTIONS WHERE TOPIC=?",
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
   * Deletes from the QUESTIONS table by TOPIC field.
   *
   * @param value the key value to seek
   * @return the number of rows deleted
   */
  // DELETE BY IMPORTED KEY
  public int deleteByTopic(String value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("DELETE FROM QUESTIONS WHERE TOPIC=?");
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
   * Retrieves the IsopointsBean object from the QUESTIONS.ID field.
   *
   * @param pObject the QuestionsBean
   * @return the associated IsopointsBean pObject
   */
  // GET IMPORTED
  public ISOPointBean getIsopointsBean(QuestionsBean pObject) throws
      SQLException {
    ISOPointBean other = ISOPointManager.getInstance().createIsopointsBean();
    other.setId(pObject.getTopic());
    return ISOPointManager.getInstance().loadUniqueUsingTemplate(other);
  }

  /**
   * Associates the QuestionsBean object to the IsopointsBean object.
   *
   * @param pObject the QuestionsBean object to use
   * @param pObjectToBeSet the IsopointsBean object to associate to the QuestionsBean
   * @return the associated IsopointsBean pObject
   */
  // SET IMPORTED
  public QuestionsBean setIsopointsBean(QuestionsBean pObject,
                                        ISOPointBean pObjectToBeSet) {
    pObject.setTopic(pObjectToBeSet.getId());
    return pObject;
  }

  //////////////////////////////////////
  // LOAD ALL
  //////////////////////////////////////

  /**
   * Loads all the rows from QUESTIONS.
   *
   * @return an array of QuestionsManager pObject
   */
  //38
  public QuestionsBean[] loadAll() throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM QUESTIONS",
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
   * Retrieves an array of QuestionsBean given a sql 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the resulting QuestionsBean table
   */
  //49
  public QuestionsBean[] loadByWhere(String where) throws SQLException {
    return loadByWhere(where, null);
  }

  /**
   * Retrieves an array of QuestionsBean given a sql where clause, and a list of fields.
   * You must use the 'WHERE' keyword.
   *
   * @param where the sql 'where' clause
   * @param fieldList table of the field's associated constants
   * @return the resulting QuestionsBean table
   */
  //51
  public QuestionsBean[] loadByWhere(String where, int[] fieldList) throws
      SQLException {
    String sql = null;
    if (fieldList == null) {
      sql = "select " + ALL_FIELDS + " from QUESTIONS " + where;
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
      buff.append(" from QUESTIONS ");
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

      return (QuestionsBean[]) v.toArray(new QuestionsBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      }
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows from the QUESTIONS table using a 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the number of deleted rows
   */
  public int deleteWhere(String where) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      String delByWhereSQL = "DELETE FROM QUESTIONS WHERE " + where;
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
   * Saves the QuestionsBean pObject into the database.
   *
   * @param pObject the QuestionsBean pObject to be saved
   */
  //100
  public QuestionsBean save(QuestionsBean pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;

    try {
      c = getConnection();
      if (pObject.isNew()) { // SAVE
        beforeInsert(pObject); // listener callback
        int _dirtyCount = 0;
        _sql = new StringBuffer("INSERT into QUESTIONS (");

        if (pObject.isIdModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("ID");
          _dirtyCount++;
        }

        if (pObject.isTopicModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("TOPIC");
          _dirtyCount++;
        }

        if (pObject.isQuestionModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("QUESTION");
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

        if (pObject.isTopicModified()) {
          ps.setString(++_dirtyCount, pObject.getTopic());
        }

        if (pObject.isQuestionModified()) {
          ps.setString(++_dirtyCount, pObject.getQuestion());
        }

        ps.executeUpdate();

        pObject.isNew(false);
        pObject.resetIsModified();
        afterInsert(pObject); // listener callback
      }
      else { // UPDATE
        beforeUpdate(pObject); // listener callback
        _sql = new StringBuffer("UPDATE QUESTIONS SET ");
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

        if (pObject.isTopicModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("TOPIC").append("=?");
        }

        if (pObject.isQuestionModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("QUESTION").append("=?");
        }
        _sql.append(" WHERE ");
        _sql.append("QUESTIONS.ID=?");
        ps = c.prepareStatement(_sql.toString(),
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        int _dirtyCount = 0;

        if (pObject.isIdModified()) {
          ps.setString(++_dirtyCount, pObject.getId());
        }

        if (pObject.isTopicModified()) {
          ps.setString(++_dirtyCount, pObject.getTopic());
        }

        if (pObject.isQuestionModified()) {
          ps.setString(++_dirtyCount, pObject.getQuestion());
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
   * Saves an array of QuestionsBean pObjects into the database.
   *
   * @param pObjects the QuestionsBean pObject table to be saved
   * @return the Objects to be saved
   * TODO: BATCH UPDATE
   */
  //65
  public QuestionsBean[] save(QuestionsBean[] pObjects) throws SQLException {
    for (int iIndex = 0; iIndex < pObjects.length; iIndex++) {
      save(pObjects[iIndex]);
    }
    return pObjects;
  }

  ///////////////////////////////////////////////////////////////////////
  // USING TEMPLATE
  ///////////////////////////////////////////////////////////////////////
  /**
   * Loads a unique QuestionsBean pObject from a template one giving a c
   *
   * @param pObject the QuestionsBean pObject to look for
   * @return the pObject matching the template
   */
  //85
  public QuestionsBean loadUniqueUsingTemplate(QuestionsBean pObject) throws
      SQLException {
    QuestionsBean[] pReturn = loadUsingTemplate(pObject);
    if (pReturn.length == 0) {
      return null;
    }
    if (pReturn.length > 1) {
      throw new SQLException("More than one element !!");
    }
    return pReturn[0];
  }

  /**
   * Loads an array of QuestionsBean from a template one.
   *
   * @param pObject the QuestionsBean template to look for
   * @return all the QuestionsBean matching the template
   */
  //88
  public QuestionsBean[] loadUsingTemplate(QuestionsBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer where = new StringBuffer("");
    StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS +
                                         " from QUESTIONS WHERE ");
    StringBuffer _sqlWhere = new StringBuffer("");
    try {
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isTopicModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("TOPIC= ?");
      }

      if (pObject.isQuestionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("QUESTION= ?");
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

      if (pObject.isTopicModified()) {
        ps.setString(++_dirtyCount, pObject.getTopic());
      }

      if (pObject.isQuestionModified()) {
        ps.setString(++_dirtyCount, pObject.getQuestion());
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
   * Deletes rows using a QuestionsBean template.
   *
   * @param pObject the QuestionsBean object(s) to be deleted
   * @return the number of deleted objects
   */
  //63
  public int deleteUsingTemplate(QuestionsBean pObject) throws SQLException {
    if (pObject.isIdInitialized()) {
      return deleteByPrimaryKey(pObject.getId());
    }

    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer sql = null;

    try {
      sql = new StringBuffer("DELETE FROM QUESTIONS WHERE ");
      int _dirtyAnd = 0;
      if (pObject.isIdInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ID").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isTopicInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("TOPIC").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isQuestionInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("QUESTION").append("=?");
        _dirtyAnd++;
      }

      c = getConnection();
      ps = c.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      int _dirtyCount = 0;

      if (pObject.isIdInitialized()) {
        ps.setString(++_dirtyCount, pObject.getId());
      }

      if (pObject.isTopicInitialized()) {
        ps.setString(++_dirtyCount, pObject.getTopic());
      }

      if (pObject.isQuestionInitialized()) {
        ps.setString(++_dirtyCount, pObject.getQuestion());
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
   * Retrieves an array of EvaluationsBean using the relation table Evaluationsdetail given a QuestionsBean object.
   *
   * @param pObject the QuestionsBean pObject to be used
   * @return an array of EvaluationsBean
   */
  // MANY TO MANY
  public EvaluationsBean[] loadEvaluationsViaEvaluationsdetail(QuestionsBean
      pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT * FROM  " +
                    "        EVALUATIONS,EVALUATIONSDETAIL" + " WHERE " +
                    "     EVALUATIONSDETAIL.IDQUESTION = ?" +
                    " AND EVALUATIONSDETAIL.IDEVALUATION = EVALUATIONS.ID";
    try {
      c = getConnection();
      ps = c.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, pObject.getId());
      return EvaluationsManager.getInstance().loadByPreparedStatement(ps);
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Retrieves an array of ResponsesBean using the relation table Evaluationsdetail given a QuestionsBean object.
   *
   * @param pObject the QuestionsBean pObject to be used
   * @return an array of ResponsesBean
   */
  // MANY TO MANY
  public ResponseBean[] loadResponsesViaEvaluationsdetail(QuestionsBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    String strSQL = " SELECT " + "        *" + " FROM  " +
                    "        RESPONSES,EVALUATIONSDETAIL" + " WHERE " +
                    "     EVALUATIONSDETAIL.IDQUESTION = ?" +
                    " AND EVALUATIONSDETAIL.IDRESPONSE = RESPONSES.ID";
    try {
      c = getConnection();
      ps = c.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      ps.setString(1, pObject.getId());
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
   * Retrieves the number of rows of the table QUESTIONS.
   *
   * @return the number of rows returned
   */
  //78
  public int count() throws SQLException {
    return countWhere("");
  }

  /**
   * Retrieves the number of rows of the table QUESTIONS with a 'where' clause.
   * You must use the 'WHERE' keyword.
   *
   * @param where the restriction clause
   * @return the number of rows returned
   */
  public int countWhere(String where) throws SQLException {
    String sql = "select count(*) as MCOUNT from QUESTIONS " + where;
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
   * Retrieves the number of rows of the table QUESTIONS with a prepared statement.
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
   * Looks for the number of elements of a specific QuestionsBean pObject given a c
   *
   * @param pObject the QuestionsBean pObject to look for
   * @return the number of rows returned
   */
  //83
  public int countUsingTemplate(QuestionsBean pObject) throws SQLException {
    StringBuffer where = new StringBuffer("");
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;
    StringBuffer _sqlWhere = null;

    try {
      _sql = new StringBuffer(
          "SELECT count(*) as MCOUNT  from QUESTIONS WHERE ");
      _sqlWhere = new StringBuffer("");
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isTopicModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("TOPIC= ?");
      }

      if (pObject.isQuestionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("QUESTION= ?");
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

      if (pObject.isTopicModified()) {
        ps.setString(++_dirtyCount, pObject.getTopic());
      }

      if (pObject.isQuestionModified()) {
        ps.setString(++_dirtyCount, pObject.getQuestion());
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
   * Transforms a ResultSet iterating on the QUESTIONS on a QuestionsBean pObject.
   *
   * @param rs the ResultSet to be transformed
   * @return pObject resulting QuestionsBean pObject
   */
  //72
  public QuestionsBean decodeRow(ResultSet rs) throws SQLException {
    QuestionsBean pObject = createQuestionsBean();
    pObject.setId(rs.getString(1));
    pObject.setTopic(rs.getString(2));
    pObject.setQuestion(rs.getString(3));

    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  /**
   * Transforms a ResultSet iterating on the QUESTIONS table on a QuestionsBean pObject according to a list of fields.
   *
   * @param rs the ResultSet to be transformed
   * @param fieldList table of the field's associated constants
   * @return pObject resulting QuestionsBean pObject
   */
  //73
  public QuestionsBean decodeRow(ResultSet rs, int[] fieldList) throws
      SQLException {
    QuestionsBean pObject = createQuestionsBean();
    int pos = 0;
    for (int i = 0; i < fieldList.length; i++) {
      switch (fieldList[i]) {
        case ID_ID:
          ++pos;
          pObject.setId(rs.getString(pos));
          break;
        case ID_TOPIC:
          ++pos;
          pObject.setTopic(rs.getString(pos));
          break;
        case ID_QUESTION:
          ++pos;
          pObject.setQuestion(rs.getString(pos));
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
   * @return an array of QuestionsBean
   */
  //41
  public QuestionsBean[] loadByPreparedStatement(PreparedStatement ps) throws
      SQLException {
    return loadByPreparedStatement(ps, null);
  }

  /**
   * Loads all the elements using a prepared statement specifying a list of fields to be retrieved.
   *
   * @param ps the PreparedStatement to be used
   * @param fieldList table of the field's associated constants
   * @return an array of QuestionsBean
   */
  public QuestionsBean[] loadByPreparedStatement(PreparedStatement ps,
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
      return (QuestionsBean[]) v.toArray(new QuestionsBean[0]);
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
  private QuestionsListener listener = null;

  /**
   * Registers a unique QuestionsListener listener.
   */
  //66.5
  public void registerListener(QuestionsListener listener) {
    this.listener = listener;
  }

  /**
   * Before the save of the QuestionsBean pObject.
   *
   * @param pObject the QuestionsBean pObject to be saved
   */
  //67
  void beforeInsert(QuestionsBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeInsert(pObject);
    }
  }

  /**
   * After the save of the QuestionsBean pObject.
   *
   * @param pObject the QuestionsBean pObject to be saved
   */
  //68
  void afterInsert(QuestionsBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterInsert(pObject);
    }
  }

  /**
   * Before the update of the QuestionsBean pObject.
   *
   * @param pObject the QuestionsBean pObject to be updated
   */
  //69
  void beforeUpdate(QuestionsBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeUpdate(pObject);
    }
  }

  /**
   * After the update of the QuestionsBean pObject.
   *
   * @param pObject the QuestionsBean pObject to be updated
   */
  //70
  void afterUpdate(QuestionsBean pObject) throws SQLException {
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
