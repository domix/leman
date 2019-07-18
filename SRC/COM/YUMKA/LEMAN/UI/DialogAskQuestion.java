package com.yumka.leman.ui;

import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;

import com.yumka.leman.LemanMain;
import com.yumka.leman.database.*;
import com.yumka.leman.ui.windows.*;
import java.awt.event.*;
import java.sql.*;

public class DialogAskQuestion extends JDialog {
  JFrame frame;
  InternalFrame frameEvaluation;
  JPanel panel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel buttons = new JPanel();
  JPanel panelButtonsResponses = new JPanel();
  JButton ok = new JButton("Suspender");
  JButton cancel = new JButton("Cancelar");
  JButton comment = new JButton("Comentario");
  JLabel title;
  JTextArea areaQuestion;
  EvaluationsBean evaluation;
  QuestionsBean question;
  EvaluationsdetailBean questionE;
  ResponseBean[] responses;
  EvaluationsdetailBean evaluationDetail;
  JButton[] buttonsResponses;
  public int status = -2;

  public DialogAskQuestion(InternalFrame frameEvaluation, EvaluationsBean evaluation, QuestionsBean question, ResponseBean[] responses) {
    super(frameEvaluation.getFrame(), "Leman-Evaluación", true);
    this.frame = frameEvaluation.getFrame();
    this.frameEvaluation = frameEvaluation;
    this.evaluation = evaluation;
    this.question = question;
    this.responses = responses;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogAskQuestion(InternalFrame frameEvaluation, EvaluationsBean evaluation, EvaluationsdetailBean question, ResponseBean[] responses) {
    super(frameEvaluation.getFrame(), "Leman-Evaluación", true);
    this.frame = frameEvaluation.getFrame();
    this.frameEvaluation = frameEvaluation;
    this.evaluation = evaluation;
    this.questionE = question;
    try {
      String sql = "WHERE QUESTIONS.ID='" + this.questionE.getIdquestion() + "'";
      QuestionsBean[] questions = QuestionsManager.getInstance().loadByWhere(sql);
      this.question = questions[0];
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    this.responses = responses;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    buttonsResponses = new JButton[this.responses.length];
    panelButtonsResponses.setLayout(new GridLayout(responses.length+4, 1) );
    panelButtonsResponses.add(new JPanel());
    /*this.comment.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                     //doComment();
                   }
                 });*/
    for (int i = 0; i < responses.length; i++) {
      buttonsResponses[i] = new JButton(responses[i].getMessage());
      panelButtonsResponses.add(buttonsResponses[i]);
      buttonsResponses[i].addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                              saveEvaluationDetail(e);
                            }
                          });
    }
    panelButtonsResponses.add(new JPanel());
    panelButtonsResponses.add(this.comment);
    panelButtonsResponses.add(new JPanel());

    buttons.setLayout(new GridLayout(1, 3));
    buttons.add(new JPanel());
    ok.setToolTipText("Suspende la evaluación. Puede continuarse en otra ocasión.");
    cancel.setToolTipText("Cancela la evaluación. No guarda los datos.");
    buttons.add(ok);
    buttons.add(cancel);
    panel.setLayout(borderLayout1);
    areaQuestion = new JTextArea(5, 40);
    areaQuestion.setWrapStyleWord(true);
    areaQuestion.setLineWrap(true);
    areaQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
    areaQuestion.setEditable(false);
    areaQuestion.setText("\n"+this.question.getQuestion());
    title = new JLabel("Pregunta \n"+this.question.getId());
    title.setFont(new Font("Tahoma", Font.BOLD, 16));
    JPanel tmp = new JPanel();
    tmp.add(title);
    panel.add(tmp, BorderLayout.NORTH);
    panel.add(panelButtonsResponses, BorderLayout.EAST);
    panel.add(new JPanel(), BorderLayout.WEST);
    panel.add(areaQuestion, BorderLayout.CENTER);
    panel.add(buttons, BorderLayout.SOUTH);
    Container con = this.getContentPane();
    con.setLayout(new BorderLayout());
    con.add(panel, BorderLayout.CENTER);
    this.setResizable(true);

    Dimension dlgSize = this.getPreferredSize();
    Dimension frmSize = frame.getSize();
    Point loc = frame.getLocation();
    this.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
                     (frmSize.height - dlgSize.height) / 2 + loc.y);

    ok.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        suspend();
      }
    });
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancel();
      }
    });
    this.pack();
    this.show();
  }
  public void cancel() {
    this.status = -1;
    this.dispose();
  }
  public void suspend() {
    this.status = 0;
    this.dispose();
  }
  public void doComment(EvaluationsdetailBean evaluationDetailPadre) {
    /*String commet = JOptionPane.showInputDialog(this, "Introduce el comentario", "Leman-Comentario", JOptionPane.QUESTION_MESSAGE);
    LemanMain.database.addComment(this.evaluationDetail, comment);*/
    DialogObservation dialog = new DialogObservation(InternalFrameEvaluation.iF.getFrame(), evaluationDetailPadre);
  }
  public void saveEvaluationDetail(ActionEvent e){
    for (int i = 0; i < this.responses.length; i++) {
      if(e.getActionCommand().equals(this.responses[i].getMessage())) {
        //System.out.println("Guardando");
        this.status = i+1;
        try {
          EvaluationsdetailBean t = LemanMain.database.addEvaluationDetail(this.evaluation, this.question,
                                                 this.responses[i]);
          int k = JOptionPane.showConfirmDialog(InternalFrameEvaluation.iF.getFrame(), "¿Deseas Agregar un comentario?", "Leman-Comentario", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if(k==0) {
            //JOptionPane.showConfirmDialog(InternalFrameEvaluation.iF.getFrame(), t.toString(), "Leman-Comentario", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            this.doComment(t);
          }
        }
        catch(SQLException ex) {
          ex.printStackTrace();
        }
        break;
      }
    }
    this.dispose();
  }
}
