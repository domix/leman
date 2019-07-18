package com.yumka.leman.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class PanelAddOrganizationData extends JPanel {
  private BorderLayout layout = new BorderLayout();
  private JLabel labelName;
  private JLabel labelAddress;
  private JLabel labelTelephone;

  private JTextField textName;
  private JTextField textAddress;
  private JTextField textTelephone;

  private JPanel labels;
  private JPanel textFields;
  private JSplitPane splitPane;
  private JPanel panel;

  public PanelAddOrganizationData() {
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
    this.labelName = new JLabel(" Nombre");
    this.labelAddress = new JLabel(" Dirección");
    this.labelTelephone = new JLabel(" Teléfono");

    this.textName = new JTextField(30);
    this.textAddress = new JTextField(50);
    this.textTelephone = new JTextField(20);

    this.labels.add(this.labelName);
    this.labels.add(this.labelAddress);
    this.labels.add(this.labelTelephone);

    this.textFields.add(this.textName);
    this.textFields.add(this.textAddress);
    this.textFields.add(this.textTelephone);

    this.panel.add(this.splitPane);

    this.add(new JScrollPane(this.panel), BorderLayout.CENTER);
  }
  public String getOrganizationAddress() {
    return this.textAddress.getText();
  }
  public void setOrganizationAddress(String address) {
    this.textAddress.setText(address);
  }
  public String getOrganizationTelephone() {
    return this.textTelephone.getText();
  }
  public void setOrganizationTelephone(String telephone) {
    this.textTelephone.setText(telephone);
  }
  public String getOrganizationName() {
    return this.textName.getText();
  }
  public void setOrganizationName(String name) {
    this.textName.setText(name);
  }
}
