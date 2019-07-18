package com.yumka.leman.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class PanelAddQuestionData extends JPanel {
  private BorderLayout layout = new BorderLayout();
  private JLabel labelId;
  private JLabel labelTopic;
  private JLabel labelQuestion;

  private JTextField textId;
  private JTextField textTopic;
  private JTextField textQuestion;

  private JPanel labels;
  private JPanel textFields;
  private JSplitPane splitPane;
  private JPanel panel;

  public PanelAddQuestionData() {
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.panel = new JPanel(new GridLayout(1, 1));
    this.labels = new JPanel(new GridLayout(3, 1));
    this.textFields = new JPanel(new GridLayout(3, 1));
    this.textFields.setMinimumSize(new Dimension(400, 100));
    this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.labels,
                                    this.textFields);

    this.setLayout(layout);
    this.labelId = new JLabel("# Pregunta");
    this.labelTopic = new JLabel("Punto ISO");
    this.labelQuestion = new JLabel("Pregunta");

    this.textId = new JTextField(50);
    this.textTopic = new JTextField(30);
    this.textQuestion = new JTextField(50);

    this.labels.add(this.labelId);
    this.labels.add(this.labelTopic);
    this.labels.add(this.labelQuestion);

    this.textFields.add(this.textId);
    this.textFields.add(this.textTopic);
    this.textFields.add(this.textQuestion);

    this.panel.add(this.splitPane);

    this.add(new JScrollPane(this.panel), BorderLayout.CENTER);
  }
  public String getQuestion() {
    return this.textQuestion.getText();
  }
  public void setQuestion(String question) {
    this.textQuestion.setText(question);
  }
  public String getId() {
    return this.textId.getText();
  }
  public void setId(String id) {
    this.textId.setText(id);
  }
  public String getTopic() {
    return this.textTopic.getText();
  }
  public void setTopic(String topic) {
    this.textTopic.setText(topic);
  }
}
