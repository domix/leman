package com.yumka.leman.ui.windows;

import java.sql.SQLException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.yumka.leman.LemanMain;
import com.yumka.leman.database.EvaluationsBean;
import com.yumka.leman.database.EvaluationsManager;
import com.yumka.leman.database.EvaluationsdetailManager;
import com.yumka.leman.database.OrganizationBean;
import com.yumka.leman.database.OrganizationsManager;
import com.yumka.leman.database.QuestionsBean;
import com.yumka.leman.database.QuestionsManager;
import com.yumka.leman.database.ResponseBean;
import com.yumka.leman.database.ResponseManager;
import com.yumka.leman.database.*;
import com.yumka.leman.graphics.JPanelPieChart;
import com.yumka.leman.ui.DialogAskQuestion;

public class InternalFrameEvaluation extends InternalFrame {
  public static InternalFrame iF;
  private JPanel jToolBar = new JPanel();
  private JButton buttonStartAll = new JButton();
  private JButton buttonStartByPoint = new JButton();
  private JButton buttonEditByPoint = new JButton();
  private JButton buttonEditDetail = new JButton();
  private JPanel content = new JPanel();
  private EvaluationsBean evaluation;
  private OrganizationBean organization;
  private JPanelPieChart panelCharts;

  public InternalFrameEvaluation(JDesktopPane desktop, JFrame parent) {
    super(desktop, "Nueva evaluación", parent, false);
    iF = this;

    try {
      organization = this.getOrganization();
      if(organization == null) {
        this.dispose();
        return;
      }
      evaluation = LemanMain.database.addEvaluation(organization.getId().
          intValue(), this.getUser().getLogin());
      this.buildUI();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    this.showInternalFrame();
  }
  public InternalFrameEvaluation(JDesktopPane desktop, JFrame parent, EvaluationsBean eval) {
    super(desktop, "Evaluación de ", parent, false);
    iF = this;
    this.evaluation = eval;
    try {
      this.organization = OrganizationsManager.getInstance().loadByPrimaryKey(eval.getIdorganization());
      this.buildUI();
      this.setTitle("Evaluación de " + this.organization.getName());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    this.showInternalFrame();

  }
  private void buildUI() throws Exception {
    Container co = this.getContentPane();
    panelCharts = new JPanelPieChart(evaluation);

    this.content.setLayout(new BorderLayout());
    this.content.add(this.panelCharts, BorderLayout.CENTER);
    this.buttonStartAll.setText("Iniciar evaluación");
    this.buttonStartAll.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        startEvaluation();
      }
    });
    buttonStartByPoint.setText("Evaluación por punto");
    buttonStartByPoint.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        startEvaluationByPoint();
      }
    });
    buttonEditByPoint.setText("Modificar por punto");
    buttonEditByPoint.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editEvaluationByPoint();
      }
    });
    buttonEditDetail.setText("Modificar pregunta");
    buttonEditDetail.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editQuestion();
      }
    });



    this.jToolBar.setLayout(new GridLayout(1, 4));
    this.jToolBar.add(this.buttonStartAll);
    this.jToolBar.add(buttonStartByPoint);
    this.jToolBar.add(buttonEditByPoint);
    this.jToolBar.add(buttonEditDetail);
    co.setLayout(new BorderLayout());
    co.add(this.jToolBar, BorderLayout.NORTH);
    co.add(new JScrollPane(this.content), BorderLayout.CENTER);
  }
  public void refreshInfo() {
    this.panelCharts.refreshCharts();
  }
  private OrganizationBean getOrganization() {
    OrganizationBean result = null;
    OrganizationBean[] orgs = null;
    try {
      orgs = OrganizationsManager.getInstance().loadAll();
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }

    String[] array = new String[orgs.length];
    for (int i = 0; i < orgs.length; i++) {
      array[i] = orgs[i].getName();
    }

    int j = JOptionPane.showOptionDialog(this.frame,
        "Escoge a la organización que se va a evaluar", "Leman-Evaluación",
                                         JOptionPane.OK_OPTION,
                                         JOptionPane.QUESTION_MESSAGE, null,
                                         array, null);
    try {
      result = orgs[j];
    }
    catch (Exception ex) {
      ex.printStackTrace();
      result = null;
    }

    return result;
  }
  private UserBean getUser() {
    return LemanMain.getUser();
  }
  public void startEvaluation() {
    int i = InternalFrameEvaluation.runEvaluation(this.evaluation, "");
    if (i == -1) {
      this.dispose();
    }
    this.refreshInfo();
  }
  public void startEvaluationByPoint() {
    ISOPointBean[] isoPoints = null;
    try {
      isoPoints = ISOPointManager.getInstance().loadByWhere("WHERE ISOPOINTS.IDISOPOINT='0' AND ISOPOINTS.ID>=4");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    String[] array = new String[isoPoints.length];
    for (int i = 0; i < isoPoints.length; i++) {
      array[i] = isoPoints[i].getId() + ".-" + isoPoints[i].getDescription();
    }

    int j = JOptionPane.showOptionDialog(this.frame,
        "Escoge el Punto ISO", "Leman-Evaluación",
                                         JOptionPane.OK_OPTION,
                                         JOptionPane.QUESTION_MESSAGE, null,
                                         array, null);
    String punto = "";
    try {
      punto = isoPoints[j].getId() + "%";
      System.out.println("punto: " + punto);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      punto = "";
    }


    int i = InternalFrameEvaluation.runEvaluation(this.evaluation, punto);
    if (i == -1) {
      this.dispose();
    }
    this.refreshInfo();
  }



   public void editEvaluationByPoint() {
       ISOPointBean[] isoPoints = null;
       try {
         isoPoints = ISOPointManager.getInstance().loadByWhere("WHERE ISOPOINTS.IDISOPOINT='0' AND ISOPOINTS.ID>=4");
       }
       catch (Exception ex) {
         ex.printStackTrace();
       }

       String[] array = new String[isoPoints.length];
       for (int i = 0; i < isoPoints.length; i++) {
         array[i] = isoPoints[i].getId() + ".-" + isoPoints[i].getDescription();
       }

       int j = JOptionPane.showOptionDialog(this.frame,
           "Escoge el Punto ISO", "Leman-Evaluación",
                                            JOptionPane.OK_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null,
                                            array, null);
       String punto = "";
       try {
         punto = isoPoints[j].getId() + "%";
         System.out.println("punto: " + punto);
       }
       catch (Exception ex) {
         ex.printStackTrace();
         punto = "";
       }


       int i = InternalFrameEvaluation.editEvaluation(this.evaluation, punto);
       if (i == -1) {
         this.dispose();
       }
       this.refreshInfo();
     }

   public static int editEvaluation(EvaluationsBean evaluation, String byPoint) {
       EvaluationsdetailBean[] questions = null;
       ResponseBean[] responses = null;
       String[] _arrayResponses = null;
       int result = -2;
       try {
         responses = ResponseManager.getInstance().loadAll();
         _arrayResponses = new String[responses.length];
         for (int i = 0; i < responses.length; i++) {
           _arrayResponses[i] = responses[i].getMessage();
         }
       }
       catch (SQLException e) {
         e.printStackTrace();
       }

       try {
         String sql = "WHERE EVALUATIONSDETAIL.IDEVALUATION=" +
                      evaluation.getId() + " AND EVALUATIONSDETAIL.IDQUESTION LIKE '" +
                      byPoint + "'";

         questions = EvaluationsdetailManager.getInstance().loadByWhere(sql);

         for (int i = 0; i < questions.length; i++) {
           int j = editQuestion(evaluation, questions[i], responses);
           result = j;
           if (j == -1) {
             cancelEvaluation(evaluation);
             break;
           }
           if (j == 0) {
             break;
           }
         }
       }
       catch (SQLException e) {
         e.printStackTrace();
       }
       return result;
     }


  public static int runEvaluation(EvaluationsBean evaluation, String byPoint) {
    QuestionsBean[] questions = null;
    ResponseBean[] responses = null;
    String[] _arrayResponses = null;
    int result = -2;
    try {
      responses = ResponseManager.getInstance().loadAll();
      _arrayResponses = new String[responses.length];
      for (int i = 0; i < responses.length; i++) {
        _arrayResponses[i] = responses[i].getMessage();
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      if((byPoint == null) || (byPoint.trim().equals(""))) {
        questions = QuestionsManager.getInstance().loadAll();
      }
      else {
        String sql = "WHERE QUESTIONS.TOPIC LIKE '"+byPoint+"'";
        questions = QuestionsManager.getInstance().loadByWhere(sql);
      }
      for (int i = 0; i < questions.length; i++) {
        int j = askQuestion(evaluation, questions[i], responses);
        result = j;
        if (j == -1) {
          cancelEvaluation(evaluation);
          break;
        }
        if (j == 0) {
          break;
        }
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
  public static void cancelEvaluation(EvaluationsBean evaluation) {
    try {
      EvaluationsdetailManager.getInstance().deleteByIdevaluation(evaluation.
          getId());
      EvaluationsManager.getInstance().deleteUsingTemplate(evaluation);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public static int askQuestion(EvaluationsBean evaluation,
                                QuestionsBean question,
                                ResponseBean[] responses) {

    if (!LemanMain.database.questionAlreadyAnswered(evaluation.getId().intValue(),
        question.getId())) {
      DialogAskQuestion d = new DialogAskQuestion(InternalFrameEvaluation.iF,
                                                  evaluation, question,
                                                  responses);
      return d.status;
    }
    return 1;
  }
  public static int editQuestion(EvaluationsBean evaluation,
                                EvaluationsdetailBean question,
                                ResponseBean[] responses) {
      DialogAskQuestion d = new DialogAskQuestion(InternalFrameEvaluation.iF,
                                                  evaluation, question,
                                                  responses);
      return d.status;
  }
  public InternalFrame getIF() {
    return this;
  }
  public void editQuestion() {
      /* ISOPointBean[] isoPoints = null;
       try {
         isoPoints = ISOPointManager.getInstance().loadByWhere("WHERE ISOPOINTS.IDISOPOINT='0' AND ISOPOINTS.ID>=4");
       }
       catch (Exception ex) {
         ex.printStackTrace();
       }

       String[] array = new String[isoPoints.length];
       for (int i = 0; i < isoPoints.length; i++) {
         array[i] = isoPoints[i].getId() + ".-" + isoPoints[i].getDescription();
       }

       int j = JOptionPane.showOptionDialog(this.frame,
           "Escoge el Punto ISO", "Leman-Evaluación",
                                            JOptionPane.OK_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null,
                                            array, null);
       String punto = "";
       try {
         punto = isoPoints[j].getId() + "%";
         System.out.println("punto: " + punto);
       }
       catch (Exception ex) {
         ex.printStackTrace();
         punto = "";
       }


       int i = InternalFrameEvaluation.editEvaluation(this.evaluation, punto);
       if (i == -1) {
         this.dispose();
       }
       this.refreshInfo();*/
     }

}
