package com.yumka.leman.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.yumka.leman.LemanMain;
import com.yumka.leman.database.QuestionsBean;
import com.yumka.leman.ui.windows.InternalFrame;

public class DialogQuestion extends JDialog {
  JFrame frame;
  InternalFrame frameQuestions;
  JPanel panel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  PanelAddQuestionData panelQuestionData;
  JPanel buttons = new JPanel();
  JButton ok = new JButton("Aceptar");
  JButton cancel = new JButton("Cancelar");
  QuestionsBean question;
  public DialogQuestion(InternalFrame frameQuestions) {
    super(frameQuestions.getFrame(), "Leman-Preguntas", true);
    this.frame = frameQuestions.getFrame();
    this.frameQuestions = frameQuestions;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public DialogQuestion(InternalFrame frameQuestions, QuestionsBean question) {
    super(frameQuestions.getFrame(), "Leman-Preguntas", true);
    this.frame = frameQuestions.getFrame();
    this.frameQuestions = frameQuestions;
    this.question = question;

    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   *
   * @throws Exception
   */
  private void jbInit() throws Exception {
    buttons.setLayout(new GridLayout(1, 3));
    buttons.add(new JPanel());
    buttons.add(ok);
    buttons.add(cancel);
    panel.setLayout(borderLayout1);
    panelQuestionData = new PanelAddQuestionData();
    panel.add(new JPanel(), BorderLayout.NORTH);
    panel.add(new JPanel(), BorderLayout.EAST);
    panel.add(new JPanel(), BorderLayout.WEST);
    panel.add(panelQuestionData, BorderLayout.CENTER);
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
        addQuestion();
      }
    });
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancel();
      }
    });
    if (this.question != null) {
      this.panelQuestionData.setId(question.getId());
      this.panelQuestionData.setTopic(question.getTopic());
      this.panelQuestionData.setQuestion(question.getQuestion());
    }
    this.pack();
    this.show();
  }
  public void addQuestion() {
    try {
      QuestionsBean question = LemanMain.database.addQuestion(this.
          panelQuestionData.getId(), this.panelQuestionData.getQuestion(),
          this.panelQuestionData.getTopic());
      frameQuestions.loadData();
    }
    catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Leman-Error",
                                    JOptionPane.ERROR_MESSAGE);
    }

    this.cancel();
  }
  public void cancel() {
    this.dispose();
  }
}
