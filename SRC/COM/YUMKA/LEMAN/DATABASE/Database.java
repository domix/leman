package com.yumka.leman.database;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Chido.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class Database {
  private Manager manager = null;
  private UserManager userManager = null;
  private ISOPointManager isoPointManager = null;
  private ResponseManager responseManager = null;
  private QuestionsManager questionManager = null;
  private OrganizationsManager organizationsManager = null;
  private EvaluationsManager evaluationManager = null;
   private EvaluationsdetailManager evaluationsDetailManager = null;

  /**
   * Database
   * @throws ClassNotFoundException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  public Database() throws ClassNotFoundException, InstantiationException,
      IllegalAccessException {
    manager = Manager.getInstance();
    manager.setJdbcDriver("org.hsqldb.jdbcDriver");
    manager.setJdbcUrl("jdbc:hsqldb:/sgc/database/leman");
    manager.setJdbcUsername("sa");
    manager.setJdbcPassword("");
    userManager = UserManager.getInstance();
    isoPointManager = ISOPointManager.getInstance();
    responseManager = ResponseManager.getInstance();
    questionManager = QuestionsManager.getInstance();
    organizationsManager = OrganizationsManager.getInstance();
    evaluationManager = EvaluationsManager.getInstance();
    evaluationsDetailManager =EvaluationsdetailManager.getInstance();
  }

  /**
   * Adds a user to the database.
   * @param login String
   * @param name String
   * @param password String
   * @param company String
   * @param jobPosition String
   * @throws SQLException
   * @return UserBean
   */
  public UserBean addUser(String login, String name, String password,
                          String company, String jobPosition) throws
      SQLException {

    UserBean user = userManager.loadByPrimaryKey(login);

    if (user == null) {
      user = userManager.createUserBean();
      user.setLogin(login);
    }

    user.setName(name);
    user.setPassword(password);
    user.setCompany(company);
    user.setJobposition(jobPosition);
    userManager.save(user);
    return user;
  }

  /**
   * Adds a ISOPoint to the database
   * @param id String
   * @param description String
   * @param idISOPoint String
   * @throws SQLException
   * @return ISOPointBean
   */
  public ISOPointBean addISOPoint(String id, String description,
                                  String idISOPoint) throws SQLException {

    ISOPointBean isoPoint = isoPointManager.loadByPrimaryKey(id);

    if (isoPoint == null) {
      isoPoint = isoPointManager.createIsopointsBean();
      isoPoint.setId(id);
    }

    isoPoint.setDescription(description);
    isoPoint.setIdisopoint(idISOPoint);
    isoPointManager.save(isoPoint);
    return isoPoint;
  }
  public ISOPointBean addISOPoint(String id, String description) throws
      SQLException {
    if (id.length() > 2) {
      int i = id.lastIndexOf(".");
      String belongs = id.substring(0, i);
      return this.addISOPoint(id, description, belongs);
    }
    else {
      return null;
    }

  }

  /**
   * Adds a Response to the database.
   * @param message String
   * @throws SQLException
   * @return ResponseBean
   */
  public ResponseBean addResponse(String message) throws SQLException {
    ResponseBean response = responseManager.createResponsesBean();
    response.setMessage(message);
    responseManager.save(response);
    return response;
  }

  /**
   * Adds a question to the database.
   * @param id String
   * @param questionText String
   * @param topic String
   * @throws SQLException
   * @return QuestionsBean
   */
  public QuestionsBean addQuestion(String id, String questionText, String topic) throws
      SQLException {
    QuestionsBean question = questionManager.loadByPrimaryKey(id);

    if (question == null) {
      question = questionManager.createQuestionsBean();
      question.setId(id);
    }
    question.setQuestion(questionText);
    question.setTopic(topic);
    questionManager.save(question);
    return question;
  }
  public QuestionsBean addQuestion(String id, String questionText) throws
      SQLException {
    if (id.length() > 2) {
      int i = id.lastIndexOf(".");
      String topic = id.substring(0, i);
      return this.addQuestion(id, questionText, topic);
    }
    else {
      return null;
    }
  }

  /**
   *
   * @param login String
   * @param password String
   * @return UserBean
   */
  public UserBean login(String login, String password) {
    UserBean result = null;
    try {
      result = this.userManager.loadByPrimaryKey(login);
    }
    catch (SQLException e) {
      result = null;
    }
    if (result != null && result.getPassword().equals(password)) {
      return result;
    }
    result = null;
    if (result == null) {
      JOptionPane.showMessageDialog(null,
          "Tu nombre de usuario y/o contraseña son incorrectos",
                                    "Login incorrecto",
                                    JOptionPane.ERROR_MESSAGE);
    }
    return result;
  }

  public OrganizationBean addOrganization(String name, String address,
                                          String telephone) throws SQLException {

    OrganizationBean[] organizations = organizationsManager.loadByWhere(
        "where ORGANIZATIONS.NAME = '" + name + "'");
    OrganizationBean organization;
    try {
      organization = organizations[0];
    }
    catch (Exception ex) {
      organization = null;
    }

    if (organization == null) {
      organization = organizationsManager.createOrganizationsBean();
    }

    organization.setName(name);
    organization.setAddress(address);
    organization.setTelephone(telephone);

    organizationsManager.save(organization);
    return organization;
  }
  public EvaluationsBean addEvaluation(int idOrganization, String user) throws
      SQLException {
    //manager.beginTransaction();
    EvaluationsBean result;
    result = evaluationManager.createEvaluationsBean();
    result.setIdorganization(idOrganization);
    result.setIduser(user);
    Date date = new Date(System.currentTimeMillis());
    Time time = new Time(System.currentTimeMillis());
    result.setDate(date);
    result.setTime(time);
    result.setOrganization("");
    evaluationManager.save(result);
    //System.out.println(result);
    StringBuffer sql = new StringBuffer();
    sql.append("where EVALUATIONS.IDORGANIZATION=");
    sql.append(idOrganization);
    sql.append(" AND EVALUATIONS.IDUSER='");
    sql.append(user);
    sql.append("' AND EVALUATIONS.DATE='");
    sql.append(date);
    sql.append("' AND EVALUATIONS.TIME='");
    sql.append(time);
    sql.append("'");

    result = evaluationManager.loadByWhere(sql.toString())[0];
    //System.out.println(result);
    //manager.endTransaction(true);

    return result;
  }
  public EvaluationsdetailBean addEvaluationDetail(EvaluationsBean evaluation, QuestionsBean question, ResponseBean response) throws
    SQLException {
  //manager.beginTransaction();
  EvaluationsdetailBean result = null;
  StringBuffer sql = new StringBuffer();
  sql.append("WHERE EVALUATIONSDETAIL.IDEVALUATION=");
  sql.append(evaluation.getId());
  sql.append(" AND EVALUATIONSDETAIL.IDQUESTION='");
  sql.append(question.getId());
  sql.append("'");
  try {
    result = evaluationsDetailManager.loadByWhere(sql.toString())[0];
  }
  catch(Exception ex) {
    //ex.printStackTrace();
    result = null;
  }

  if(result==null) {
    result = evaluationsDetailManager.createEvaluationsdetailBean();
    result.setIdevaluation(evaluation.getId());
    result.setIdquestion(question.getId());

  }
  result.setIdresponse(response.getId());
  evaluationsDetailManager.save(result);

  sql = new StringBuffer();
  sql.append("WHERE EVALUATIONSDETAIL.IDEVALUATION=");
  sql.append(result.getIdevaluation());
  sql.append(" AND EVALUATIONSDETAIL.IDQUESTION='");
  sql.append(result.getIdquestion());
  sql.append("'");

  result = evaluationsDetailManager.loadByWhere(sql.toString())[0];

  return result;
}

  public int getQuestionsFromEvaluation(EvaluationsBean evaluation) {
    int result = 0;
    try {
      result = EvaluationsManager.getInstance().
               loadQuestionsViaEvaluationsdetail(evaluation).length;
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public boolean questionAlreadyAnswered(int evaluation, String question) {
    boolean result = false;
    EvaluationsdetailBean answered = null;
    StringBuffer sql = new StringBuffer();

    sql.append("WHERE EVALUATIONSDETAIL.IDEVALUATION=");
    sql.append(evaluation);
    sql.append(" AND EVALUATIONSDETAIL.IDQUESTION='");
    sql.append(question);
    sql.append("'");

    try {


      answered = evaluationsDetailManager.loadByWhere(sql.toString())[0];
      if (answered != null)
        return true;
    }
      catch(Exception e) {
        return false;
      }
    return result;
  }
  public void getEvaluationDetail(EvaluationsBean evaluation, ISOPointBean point) {
    //this.evaluationManager.loadQuestionsViaEvaluationsdetail(null);
  }

  /**
   * closeAllConnections
   */
  public void closeAllConnections() {
    manager.pool.closeAllConnections();
  }



  public static int value(String value) {
    if(value.length() == 1) {
      return Integer.valueOf(value).intValue();
    }
    return 0;
  }
  public String getOrganizationName(int idOrg) {
    String result = "";
    try {
      OrganizationBean[] org;
      StringBuffer sql = new StringBuffer();
      sql.append("WHERE ORGANIZATIONS.ID=");
      sql.append(idOrg);
      org = OrganizationsManager.getInstance().loadByWhere(sql.toString());
      result = org[0].getName();
    }
    catch (Exception ex) {
      result = "Organización no encontrada";
      //ex.printStackTrace();
    }
    return result;
  }
  public String getUserOrganizationName(int idOrg) {
    String result = "";
    try {
      OrganizationBean[] org;
      StringBuffer sql = new StringBuffer();
      sql.append("WHERE ORGANIZATIONS.ID=");
      sql.append(idOrg);
      org = OrganizationsManager.getInstance().loadByWhere(sql.toString());
      result = org[0].getName();
    }
    catch (Exception ex) {
      result = "Organización no encontrada";
      //ex.printStackTrace();
    }
    return result;
  }
  public EvaluationsBean getEvaluation(String fecha, String hora) {
    Date date = null;
    Time time = null;

    return this.getEvaluation(date, time);
  }
  public EvaluationsBean getEvaluation(Date fecha, Time hora) {
    EvaluationsBean result = null;
    return result;
  }

  /**
   * addComment
   *
   * @param evaluationsdetailBean EvaluationsdetailBean
   * @param comment JButton
   */
  public ObservationsBean addComment(EvaluationsdetailBean evaluationsdetailBean,
                         String comment, String responsable, String plazo, String accion) {
    ObservationsBean result = null;
    StringBuffer sql = new StringBuffer();
    sql.append("WHERE OBSERVATIONS.IDEVALUATIONDETAIL=");
    sql.append(evaluationsdetailBean.getId());
    try {
      result = ObservationsManager.getInstance().loadByWhere(sql.toString())[0];
    }
    catch(Exception ex) {
      //ex.printStackTrace();
      result = null;
    }
    if(result==null) {
      result = ObservationsManager.getInstance().createObservationsBean();

    }
    result.setIdevaluationdetail(evaluationsdetailBean.getId());
    result.setMessage(comment);
    result.setResponsable(responsable);
    result.setPlazo(plazo);
    result.setAccion(accion);
    try {
      ObservationsManager.getInstance().save(result);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }


    return result;
  }
  //use for SQL commands DROP and INSERT and UPDATE
  public static synchronized void update(String expression) throws SQLException {
    Statement st = null;

    Connection conn  = Manager.pool.getConnection();

    st = conn.createStatement(); // statements

    int i = st.executeUpdate(expression); // run the query

    if (i == -1) {
      System.out.println("db error : " + expression);
    }
    st.close();
    Manager.pool.free(conn);
  } // void update()

}
