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
 * Handles database calls for the EVALUATIONSDETAIL table.
 */
public class EvaluationsdetailManager
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
   * Column IDEVALUATION of type Types.INTEGER mapped to Integer.
   */
  public static final int ID_IDEVALUATION = 1;
  public static final int TYPE_IDEVALUATION = Types.INTEGER;
  public static final String NAME_IDEVALUATION = "IDEVALUATION";

  /**
   * Column IDQUESTION of type Types.VARCHAR mapped to String.
   */
  public static final int ID_IDQUESTION = 2;
  public static final int TYPE_IDQUESTION = Types.VARCHAR;
  public static final String NAME_IDQUESTION = "IDQUESTION";

  /**
   * Column IDRESPONSE of type Types.INTEGER mapped to Integer.
   */
  public static final int ID_IDRESPONSE = 3;
  public static final int TYPE_IDRESPONSE = Types.INTEGER;
  public static final String NAME_IDRESPONSE = "IDRESPONSE";

  private static final String TABLE_NAME = "EVALUATIONSDETAIL";

  /**
   * Create an array of type string containing all the fields of the EVALUATIONSDETAIL table.
   */
  private static final String[] FIELD_NAMES = {"EVALUATIONSDETAIL.ID",
      "EVALUATIONSDETAIL.IDEVALUATION", "EVALUATIONSDETAIL.IDQUESTION",
      "EVALUATIONSDETAIL.IDRESPONSE"
  };

  /**
   * Field that contains the comma separated fields of the EVALUATIONSDETAIL table.
   */
  private static final String ALL_FIELDS = "EVALUATIONSDETAIL.ID" +
                                           ",EVALUATIONSDETAIL.IDEVALUATION" +
                                           ",EVALUATIONSDETAIL.IDQUESTION" +
                                           ",EVALUATIONSDETAIL.IDRESPONSE";

  private static EvaluationsdetailManager singleton = new
      EvaluationsdetailManager();

  /**
   * Get the EvaluationsdetailManager singleton.
   *
   * @return EvaluationsdetailManager
   */
  synchronized public static EvaluationsdetailManager getInstance() {
    return singleton;
  }

  /**
   * Sets your own EvaluationsdetailManager instance.
   <br>
   * This is optional, by default we provide it for you.
   */
  synchronized public static void setInstance(EvaluationsdetailManager instance) {
    singleton = instance;
  }

  /**
   * Creates a new EvaluationsdetailBean instance.
   *
   * @return the new EvaluationsdetailBean
   */
  public EvaluationsdetailBean createEvaluationsdetailBean() {
    return new EvaluationsdetailBean();
  }

  //////////////////////////////////////
  // PRIMARY KEY METHODS
  //////////////////////////////////////

  /**
   * Loads a EvaluationsdetailBean from the EVALUATIONSDETAIL using its key fields.
   *
   * @return a unique EvaluationsdetailBean
   */
  //12
  public EvaluationsdetailBean loadByPrimaryKey(Integer id) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
          " FROM EVALUATIONSDETAIL WHERE EVALUATIONSDETAIL.ID=?",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      Manager.setInteger(ps, 1, id);
      EvaluationsdetailBean pReturn[] = loadByPreparedStatement(ps);
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
          "DELETE from EVALUATIONSDETAIL WHERE EVALUATIONSDETAIL.ID=?",
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
  // FOREIGN KEY METHODS
  //////////////////////////////////////

  /**
   * Loads EvaluationsdetailBean array from the EVALUATIONSDETAIL table using its IDEVALUATION field.
   *
   * @return an array of EvaluationsdetailBean
   */
  // LOAD BY IMPORTED KEY
  public EvaluationsdetailBean[] loadByIdevaluation(Integer value) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM EVALUATIONSDETAIL WHERE IDEVALUATION=?",
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
   * Deletes from the EVALUATIONSDETAIL table by IDEVALUATION field.
   *
   * @param value the key value to seek
   * @return the number of rows deleted
   */
  // DELETE BY IMPORTED KEY
  public int deleteByIdevaluation(Integer value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement(
          "DELETE FROM EVALUATIONSDETAIL WHERE IDEVALUATION=?");
      Manager.setInteger(ps, 1, value);
      return ps.executeUpdate();
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Loads EvaluationsdetailBean array from the EVALUATIONSDETAIL table using its IDQUESTION field.
   *
   * @return an array of EvaluationsdetailBean
   */
  // LOAD BY IMPORTED KEY
  public EvaluationsdetailBean[] loadByIdquestion(String value) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM EVALUATIONSDETAIL WHERE IDQUESTION=?",
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
   * Deletes from the EVALUATIONSDETAIL table by IDQUESTION field.
   *
   * @param value the key value to seek
   * @return the number of rows deleted
   */
  // DELETE BY IMPORTED KEY
  public int deleteByIdquestion(String value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement(
          "DELETE FROM EVALUATIONSDETAIL WHERE IDQUESTION=?");
      ps.setString(1, value);
      return ps.executeUpdate();
    }
    finally {
      getManager().close(ps);
      freeConnection(c);
    }
  }

  /**
   * Loads EvaluationsdetailBean array from the EVALUATIONSDETAIL table using its IDRESPONSE field.
   *
   * @return an array of EvaluationsdetailBean
   */
  // LOAD BY IMPORTED KEY
  public EvaluationsdetailBean[] loadByIdresponse(Integer value) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM EVALUATIONSDETAIL WHERE IDRESPONSE=?",
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
   * Deletes from the EVALUATIONSDETAIL table by IDRESPONSE field.
   *
   * @param value the key value to seek
   * @return the number of rows deleted
   */
  // DELETE BY IMPORTED KEY
  public int deleteByIdresponse(Integer value) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement(
          "DELETE FROM EVALUATIONSDETAIL WHERE IDRESPONSE=?");
      Manager.setInteger(ps, 1, value);
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
   * Retrieves the EvaluationsBean object from the EVALUATIONSDETAIL.ID field.
   *
   * @param pObject the EvaluationsdetailBean
   * @return the associated EvaluationsBean pObject
   */
  // GET IMPORTED
  public EvaluationsBean getEvaluationsBean(EvaluationsdetailBean pObject) throws
      SQLException {
    EvaluationsBean other = EvaluationsManager.getInstance().
                            createEvaluationsBean();
    other.setId(pObject.getIdevaluation());
    return EvaluationsManager.getInstance().loadUniqueUsingTemplate(other);
  }

  /**
   * Associates the EvaluationsdetailBean object to the EvaluationsBean object.
   *
   * @param pObject the EvaluationsdetailBean object to use
   * @param pObjectToBeSet the EvaluationsBean object to associate to the EvaluationsdetailBean
   * @return the associated EvaluationsBean pObject
   */
  // SET IMPORTED
  public EvaluationsdetailBean setEvaluationsBean(EvaluationsdetailBean pObject,
                                                  EvaluationsBean
                                                  pObjectToBeSet) {
    pObject.setIdevaluation(pObjectToBeSet.getId());
    return pObject;
  }

  /**
   * Retrieves the QuestionsBean object from the EVALUATIONSDETAIL.ID field.
   *
   * @param pObject the EvaluationsdetailBean
   * @return the associated QuestionsBean pObject
   */
  // GET IMPORTED
  public QuestionsBean getQuestionsBean(EvaluationsdetailBean pObject) throws
      SQLException {
    QuestionsBean other = QuestionsManager.getInstance().createQuestionsBean();
    other.setId(pObject.getIdquestion());
    return QuestionsManager.getInstance().loadUniqueUsingTemplate(other);
  }

  /**
   * Associates the EvaluationsdetailBean object to the QuestionsBean object.
   *
   * @param pObject the EvaluationsdetailBean object to use
   * @param pObjectToBeSet the QuestionsBean object to associate to the EvaluationsdetailBean
   * @return the associated QuestionsBean pObject
   */
  // SET IMPORTED
  public EvaluationsdetailBean setQuestionsBean(EvaluationsdetailBean pObject,
                                                QuestionsBean pObjectToBeSet) {
    pObject.setIdquestion(pObjectToBeSet.getId());
    return pObject;
  }

  /**
   * Retrieves the ResponsesBean object from the EVALUATIONSDETAIL.ID field.
   *
   * @param pObject the EvaluationsdetailBean
   * @return the associated ResponsesBean pObject
   */
  // GET IMPORTED
  public ResponseBean getResponsesBean(EvaluationsdetailBean pObject) throws
      SQLException {
    ResponseBean other = ResponseManager.getInstance().createResponsesBean();
    other.setId(pObject.getIdresponse());
    return ResponseManager.getInstance().loadUniqueUsingTemplate(other);
  }

  /**
   * Associates the EvaluationsdetailBean object to the ResponsesBean object.
   *
   * @param pObject the EvaluationsdetailBean object to use
   * @param pObjectToBeSet the ResponsesBean object to associate to the EvaluationsdetailBean
   * @return the associated ResponsesBean pObject
   */
  // SET IMPORTED
  public EvaluationsdetailBean setResponsesBean(EvaluationsdetailBean pObject,
                                                ResponseBean pObjectToBeSet) {
    pObject.setIdresponse(pObjectToBeSet.getId());
    return pObject;
  }

  //////////////////////////////////////
  // LOAD ALL
  //////////////////////////////////////

  /**
   * Loads all the rows from EVALUATIONSDETAIL.
   *
   * @return an array of EvaluationsdetailManager pObject
   */
  //38
  public EvaluationsdetailBean[] loadAll() throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      ps = c.prepareStatement("SELECT " + ALL_FIELDS +
                              " FROM EVALUATIONSDETAIL",
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
   * Retrieves an array of EvaluationsdetailBean given a sql 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the resulting EvaluationsdetailBean table
   */
  //49
  public EvaluationsdetailBean[] loadByWhere(String where) throws SQLException {
    return loadByWhere(where, null);
  }

  /**
   * Retrieves an array of EvaluationsdetailBean given a sql where clause, and a list of fields.
   * You must use the 'WHERE' keyword.
   *
   * @param where the sql 'where' clause
   * @param fieldList table of the field's associated constants
   * @return the resulting EvaluationsdetailBean table
   */
  //51
  public EvaluationsdetailBean[] loadByWhere(String where, int[] fieldList) throws
      SQLException {
    String sql = null;
    if (fieldList == null) {
      sql = "select " + ALL_FIELDS + " from EVALUATIONSDETAIL " + where;
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
      buff.append(" from EVALUATIONSDETAIL ");
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

      return (EvaluationsdetailBean[]) v.toArray(new EvaluationsdetailBean[0]);
    }
    finally {
      if (v != null) {v.clear();
      }
      getManager().close(pStatement, rs);
      freeConnection(c);
    }
  }

  /**
   * Deletes rows from the EVALUATIONSDETAIL table using a 'where' clause.
   *
   * @param where the sql 'where' clause
   * @return the number of deleted rows
   */
  public int deleteWhere(String where) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    try {
      c = getConnection();
      String delByWhereSQL = "DELETE FROM EVALUATIONSDETAIL WHERE " + where;
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
   * Saves the EvaluationsdetailBean pObject into the database.
   *
   * @param pObject the EvaluationsdetailBean pObject to be saved
   */
  //100
  public EvaluationsdetailBean save(EvaluationsdetailBean pObject) throws
      SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;

    try {
      c = getConnection();
      if (pObject.isNew()) { // SAVE
        beforeInsert(pObject); // listener callback
        int _dirtyCount = 0;
        _sql = new StringBuffer("INSERT into EVALUATIONSDETAIL (");

        /*if (pObject.isIdModified()) {
            if (_dirtyCount>0) {
                _sql.append(",");
            }
            _sql.append("ID");
            _dirtyCount++;
                         }*/

        if (pObject.isIdevaluationModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("IDEVALUATION");
          _dirtyCount++;
        }

        if (pObject.isIdquestionModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("IDQUESTION");
          _dirtyCount++;
        }

        if (pObject.isIdresponseModified()) {
          if (_dirtyCount > 0) {
            _sql.append(",");
          }
          _sql.append("IDRESPONSE");
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

        if (pObject.isIdevaluationModified()) {
          Manager.setInteger(ps, ++_dirtyCount, pObject.getIdevaluation());
        }

        if (pObject.isIdquestionModified()) {
          ps.setString(++_dirtyCount, pObject.getIdquestion());
        }

        if (pObject.isIdresponseModified()) {
          Manager.setInteger(ps, ++_dirtyCount, pObject.getIdresponse());
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
        _sql = new StringBuffer("UPDATE EVALUATIONSDETAIL SET ");
        boolean useComma = false;

        /*if (pObject.isIdModified()) {
            if (useComma) {
                _sql.append(",");
            } else {
                useComma=true;
            }
            _sql.append("ID").append("=?");
                         }*/

        if (pObject.isIdevaluationModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("IDEVALUATION").append("=?");
        }

        if (pObject.isIdquestionModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("IDQUESTION").append("=?");
        }

        if (pObject.isIdresponseModified()) {
          if (useComma) {
            _sql.append(",");
          }
          else {
            useComma = true;
          }
          _sql.append("IDRESPONSE").append("=?");
        }
        _sql.append(" WHERE ");
        _sql.append("EVALUATIONSDETAIL.ID=?");
        ps = c.prepareStatement(_sql.toString(),
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        int _dirtyCount = 0;

        /*if (pObject.isIdModified()) {
              Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
                         }*/

        if (pObject.isIdevaluationModified()) {
          Manager.setInteger(ps, ++_dirtyCount, pObject.getIdevaluation());
        }

        if (pObject.isIdquestionModified()) {
          ps.setString(++_dirtyCount, pObject.getIdquestion());
        }

        if (pObject.isIdresponseModified()) {
          Manager.setInteger(ps, ++_dirtyCount, pObject.getIdresponse());
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
   * Saves an array of EvaluationsdetailBean pObjects into the database.
   *
   * @param pObjects the EvaluationsdetailBean pObject table to be saved
   * @return the Objects to be saved
   * TODO: BATCH UPDATE
   */
  //65
  public EvaluationsdetailBean[] save(EvaluationsdetailBean[] pObjects) throws
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
   * Loads a unique EvaluationsdetailBean pObject from a template one giving a c
   *
   * @param pObject the EvaluationsdetailBean pObject to look for
   * @return the pObject matching the template
   */
  //85
  public EvaluationsdetailBean loadUniqueUsingTemplate(EvaluationsdetailBean
      pObject) throws SQLException {
    EvaluationsdetailBean[] pReturn = loadUsingTemplate(pObject);
    if (pReturn.length == 0) {
      return null;
    }
    if (pReturn.length > 1) {
      throw new SQLException("More than one element !!");
    }
    return pReturn[0];
  }

  /**
   * Loads an array of EvaluationsdetailBean from a template one.
   *
   * @param pObject the EvaluationsdetailBean template to look for
   * @return all the EvaluationsdetailBean matching the template
   */
  //88
  public EvaluationsdetailBean[] loadUsingTemplate(EvaluationsdetailBean
      pObject) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer where = new StringBuffer("");
    StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS +
                                         " from EVALUATIONSDETAIL WHERE ");
    StringBuffer _sqlWhere = new StringBuffer("");
    try {
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isIdevaluationModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDEVALUATION= ?");
      }

      if (pObject.isIdquestionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDQUESTION= ?");
      }

      if (pObject.isIdresponseModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDRESPONSE= ?");
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

      if (pObject.isIdevaluationModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdevaluation());
      }

      if (pObject.isIdquestionModified()) {
        ps.setString(++_dirtyCount, pObject.getIdquestion());
      }

      if (pObject.isIdresponseModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdresponse());
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
   * Deletes rows using a EvaluationsdetailBean template.
   *
   * @param pObject the EvaluationsdetailBean object(s) to be deleted
   * @return the number of deleted objects
   */
  //63
  public int deleteUsingTemplate(EvaluationsdetailBean pObject) throws
      SQLException {
    if (pObject.isIdInitialized()) {
      return deleteByPrimaryKey(pObject.getId());
    }

    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer sql = null;

    try {
      sql = new StringBuffer("DELETE FROM EVALUATIONSDETAIL WHERE ");
      int _dirtyAnd = 0;
      if (pObject.isIdInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("ID").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isIdevaluationInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("IDEVALUATION").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isIdquestionInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("IDQUESTION").append("=?");
        _dirtyAnd++;
      }

      if (pObject.isIdresponseInitialized()) {
        if (_dirtyAnd > 0) {
          sql.append(" AND ");
        }
        sql.append("IDRESPONSE").append("=?");
        _dirtyAnd++;
      }

      c = getConnection();
      ps = c.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_READ_ONLY);
      int _dirtyCount = 0;

      if (pObject.isIdInitialized()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getId());
      }

      if (pObject.isIdevaluationInitialized()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdevaluation());
      }

      if (pObject.isIdquestionInitialized()) {
        ps.setString(++_dirtyCount, pObject.getIdquestion());
      }

      if (pObject.isIdresponseInitialized()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdresponse());
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
   * Retrieves the number of rows of the table EVALUATIONSDETAIL.
   *
   * @return the number of rows returned
   */
  //78
  public int count() throws SQLException {
    return countWhere("");
  }

  /**
   * Retrieves the number of rows of the table EVALUATIONSDETAIL with a 'where' clause.
   * You must use the 'WHERE' keyword.
   *
   * @param where the restriction clause
   * @return the number of rows returned
   */
  public int countWhere(String where) throws SQLException {
    String sql = "select count(*) as MCOUNT from EVALUATIONSDETAIL " + where;
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
   * Retrieves the number of rows of the table EVALUATIONSDETAIL with a prepared statement.
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
   * Looks for the number of elements of a specific EvaluationsdetailBean pObject given a c
   *
   * @param pObject the EvaluationsdetailBean pObject to look for
   * @return the number of rows returned
   */
  //83
  public int countUsingTemplate(EvaluationsdetailBean pObject) throws
      SQLException {
    StringBuffer where = new StringBuffer("");
    Connection c = null;
    PreparedStatement ps = null;
    StringBuffer _sql = null;
    StringBuffer _sqlWhere = null;

    try {
      _sql = new StringBuffer(
          "SELECT count(*) as MCOUNT  from EVALUATIONSDETAIL WHERE ");
      _sqlWhere = new StringBuffer("");
      int _dirtyCount = 0;

      if (pObject.isIdModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("ID= ?");
      }

      if (pObject.isIdevaluationModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDEVALUATION= ?");
      }

      if (pObject.isIdquestionModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDQUESTION= ?");
      }

      if (pObject.isIdresponseModified()) {
        _dirtyCount++;
        _sqlWhere.append( (_sqlWhere.length() == 0) ? " " :
            " AND ").append("IDRESPONSE= ?");
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

      if (pObject.isIdevaluationModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdevaluation());
      }

      if (pObject.isIdquestionModified()) {
        ps.setString(++_dirtyCount, pObject.getIdquestion());
      }

      if (pObject.isIdresponseModified()) {
        Manager.setInteger(ps, ++_dirtyCount, pObject.getIdresponse());
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
   * Transforms a ResultSet iterating on the EVALUATIONSDETAIL on a EvaluationsdetailBean pObject.
   *
   * @param rs the ResultSet to be transformed
   * @return pObject resulting EvaluationsdetailBean pObject
   */
  //72
  public EvaluationsdetailBean decodeRow(ResultSet rs) throws SQLException {
    EvaluationsdetailBean pObject = createEvaluationsdetailBean();
    pObject.setId(Manager.getInteger(rs, 1));
    pObject.setIdevaluation(Manager.getInteger(rs, 2));
    pObject.setIdquestion(rs.getString(3));
    pObject.setIdresponse(Manager.getInteger(rs, 4));

    pObject.isNew(false);
    pObject.resetIsModified();

    return pObject;
  }

  /**
   * Transforms a ResultSet iterating on the EVALUATIONSDETAIL table on a EvaluationsdetailBean pObject according to a list of fields.
   *
   * @param rs the ResultSet to be transformed
   * @param fieldList table of the field's associated constants
   * @return pObject resulting EvaluationsdetailBean pObject
   */
  //73
  public EvaluationsdetailBean decodeRow(ResultSet rs, int[] fieldList) throws
      SQLException {
    EvaluationsdetailBean pObject = createEvaluationsdetailBean();
    int pos = 0;
    for (int i = 0; i < fieldList.length; i++) {
      switch (fieldList[i]) {
        case ID_ID:
          ++pos;
          pObject.setId(Manager.getInteger(rs, pos));
          break;
        case ID_IDEVALUATION:
          ++pos;
          pObject.setIdevaluation(Manager.getInteger(rs, pos));
          break;
        case ID_IDQUESTION:
          ++pos;
          pObject.setIdquestion(rs.getString(pos));
          break;
        case ID_IDRESPONSE:
          ++pos;
          pObject.setIdresponse(Manager.getInteger(rs, pos));
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
   * @return an array of EvaluationsdetailBean
   */
  //41
  public EvaluationsdetailBean[] loadByPreparedStatement(PreparedStatement ps) throws
      SQLException {
    return loadByPreparedStatement(ps, null);
  }

  /**
   * Loads all the elements using a prepared statement specifying a list of fields to be retrieved.
   *
   * @param ps the PreparedStatement to be used
   * @param fieldList table of the field's associated constants
   * @return an array of EvaluationsdetailBean
   */
  public EvaluationsdetailBean[] loadByPreparedStatement(PreparedStatement ps,
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
      return (EvaluationsdetailBean[]) v.toArray(new EvaluationsdetailBean[0]);
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
  private EvaluationsdetailListener listener = null;

  /**
   * Registers a unique EvaluationsdetailListener listener.
   */
  //66.5
  public void registerListener(EvaluationsdetailListener listener) {
    this.listener = listener;
  }

  /**
   * Before the save of the EvaluationsdetailBean pObject.
   *
   * @param pObject the EvaluationsdetailBean pObject to be saved
   */
  //67
  void beforeInsert(EvaluationsdetailBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeInsert(pObject);
    }
  }

  /**
   * After the save of the EvaluationsdetailBean pObject.
   *
   * @param pObject the EvaluationsdetailBean pObject to be saved
   */
  //68
  void afterInsert(EvaluationsdetailBean pObject) throws SQLException {
    if (listener != null) {
      listener.afterInsert(pObject);
    }
  }

  /**
   * Before the update of the EvaluationsdetailBean pObject.
   *
   * @param pObject the EvaluationsdetailBean pObject to be updated
   */
  //69
  void beforeUpdate(EvaluationsdetailBean pObject) throws SQLException {
    if (listener != null) {
      listener.beforeUpdate(pObject);
    }
  }

  /**
   * After the update of the EvaluationsdetailBean pObject.
   *
   * @param pObject the EvaluationsdetailBean pObject to be updated
   */
  //70
  void afterUpdate(EvaluationsdetailBean pObject) throws SQLException {
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

//1272
