package com.yumka.leman.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class PanelAddISOPointData extends JPanel {
  private BorderLayout layout = new BorderLayout();
  private JLabel labelPoint;
  private JLabel labelDescription;
  private JLabel labelBelongsToISOPoint;

  private JTextField textPoint;
  private JTextField textDescription;
  private JTextField textBelongsToISOPoint;

  private JPanel labels;
  private JPanel textFields;
  private JSplitPane splitPane;
  private JPanel panel;

  public PanelAddISOPointData() {
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
    this.labelPoint = new JLabel("Punto");
    this.labelDescription = new JLabel("Descripción");
    this.labelBelongsToISOPoint = new JLabel("Pertenece a");

    this.textPoint = new JTextField(50);
    this.textDescription = new JTextField(30);
    this.textBelongsToISOPoint = new JTextField(50);

    this.labels.add(this.labelPoint);
    this.labels.add(this.labelDescription);
    this.labels.add(this.labelBelongsToISOPoint);

    this.textFields.add(this.textPoint);
    this.textFields.add(this.textDescription);
    this.textFields.add(this.textBelongsToISOPoint);

    this.panel.add(this.splitPane);

    this.add(new JScrollPane(this.panel), BorderLayout.CENTER);
  }
  public String getBelongsToISOPoint() {
    return this.textBelongsToISOPoint.getText();
  }
  public void setBelongsToISOPoint(String belongsTo) {
    this.textBelongsToISOPoint.setText(belongsTo);
  }
  public String getPoint() {
    return this.textPoint.getText();
  }
  public void setPoint(String point) {
    this.textPoint.setText(point);
  }
  public String getDescription() {
    return this.textDescription.getText();
  }
  public void setDescription(String description) {
    this.textDescription.setText(description);
  }
}
