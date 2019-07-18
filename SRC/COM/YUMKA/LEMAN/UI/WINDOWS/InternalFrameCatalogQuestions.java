package com.yumka.leman.ui.windows;

import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.yumka.leman.database.Manager;
import com.yumka.leman.database.QuestionsBean;
import com.yumka.leman.database.QuestionsManager;
import com.yumka.leman.ui.table.QuestionBeanTableModel;
import com.yumka.leman.ui.DialogQuestion;

public class InternalFrameCatalogQuestions extends InternalFrameCatalog {
  QuestionsBean[] questions;
  public InternalFrameCatalogQuestions(JDesktopPane desktop, JFrame parent) {
    super(desktop, "Catálogo de Preguntas", parent);
    try {
      this.loadData();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    this.setButtonAddActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addQuestion();
      }
    });
    this.setButtonEditActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editQuestion();
      }
    });
    this.setButtonDeleteActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteQuestion();
      }
    });
  }
  public void loadData() throws Exception {
    questions = QuestionsManager.getInstance().loadAll();
    this.setTableModelRe(new QuestionBeanTableModel(questions));
  }
  public void addQuestion() {
    DialogQuestion dialogQuestion = new DialogQuestion(this);
  }
  public void editQuestion() {
    int numQuestion = this.table.getSelectedRow();

    if (numQuestion >= 0) {
      try {
        QuestionsBean question = QuestionsManager.getInstance().loadByPrimaryKey( ( (String)this.
            table.getValueAt(numQuestion, 0)));
        DialogQuestion dialogQuestion = new DialogQuestion(this, question);
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }
  public void deleteQuestion() {
    int numQuestion = this.table.getSelectedRow();

    if (numQuestion >= 0) {
      String men = "¿Deseas borrar la pregunta " + table.getValueAt(numQuestion, 0) +
                   "?";
      int i = JOptionPane.showConfirmDialog(this.frame, men, "Leman-Preguntas",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);
      if (i == 0) {

        try {
          QuestionsManager.getInstance().deleteByPrimaryKey( ( (String)this.table.
              getValueAt(numQuestion, 0)));
          //Manager.getInstance().endTransaction(true);
          this.loadData();
        }
        catch (Exception ex) {}
      }
    }
  }
}
