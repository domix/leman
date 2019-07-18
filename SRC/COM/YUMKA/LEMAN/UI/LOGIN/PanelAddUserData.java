package com.yumka.leman.ui.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class PanelAddUserData extends JPanel {
  private BorderLayout layout = new BorderLayout();
  private JLabel labelLogin;
  private JLabel labelName;
  private JLabel labelCompany;
  private JLabel labelJobPosition;
  private JLabel labelPassword;
  private JLabel labelConfirmPassword;

  private JTextField textLogin;
  private JTextField textName;
  private JTextField textCompany;
  private JTextField textJobPosition;
  private JPasswordField textPassword;
  private JPasswordField textConfirmPassword;

  private JPanel labels;
  private JPanel textFields;
  private JSplitPane splitPane;
  private JPanel panel;

  public PanelAddUserData() {
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.panel = new JPanel(new GridLayout(1, 1));
    this.labels = new JPanel(new GridLayout(6, 1));
    this.textFields = new JPanel(new GridLayout(6, 1));
    this.textFields.setMinimumSize(new Dimension(400, 100));
    this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.labels,
                                    this.textFields);

    this.setLayout(layout);
    this.labelLogin = new JLabel(" Login");
    this.labelName = new JLabel(" Nombre");
    this.labelCompany = new JLabel(" Organización");
    this.labelJobPosition = new JLabel(" Puesto");
    this.labelPassword = new JLabel(" Contraseña");
    this.labelConfirmPassword = new JLabel(" Confirma la Contraseña");

    this.textLogin = new JTextField(50);
    this.textName = new JTextField(30);
    this.textCompany = new JTextField(50);
    this.textJobPosition = new JTextField(20);
    this.textPassword = new JPasswordField(20);
    this.textConfirmPassword = new JPasswordField(20);

    this.labels.add(this.labelLogin);
    this.labels.add(this.labelName);
    this.labels.add(this.labelCompany);
    this.labels.add(this.labelJobPosition);
    this.labels.add(this.labelPassword);
    this.labels.add(this.labelConfirmPassword);

    this.textFields.add(this.textLogin);
    this.textFields.add(this.textName);
    this.textFields.add(this.textCompany);
    this.textFields.add(this.textJobPosition);
    this.textFields.add(this.textPassword);
    this.textFields.add(this.textConfirmPassword);

    this.panel.add(this.splitPane);

    this.add(new JScrollPane(this.panel), BorderLayout.CENTER);
  }
  public String getUserCompany() {
    return this.textCompany.getText();
  }
  public void setUserCompany(String company) {
    this.textCompany.setText(company);
  }
  public String getUserJobPosition() {
    return this.textJobPosition.getText();
  }
  public void setUserJobPosition(String jobPosition) {
    this.textJobPosition.setText(jobPosition);
  }
  public char[] getUserPassword() {
    return this.textPassword.getPassword();
  }
  public void setUserPassword(String password) {
    this.textPassword.setText(password);
  }
  public String getUserLogin() {
    return this.textLogin.getText();
  }
  public void setUserLogin(String nameUser) {
    this.textLogin.setText(nameUser);
  }
  public String getUserName() {
    return this.textName.getText();
  }
  public void setUserName(String nameUser) {
    this.textName.setText(nameUser);
  }
  public boolean isUserPasswordTypedCorrectly() {
    return new String(this.textPassword.getPassword()).equals(new String(this.
        textConfirmPassword.getPassword()));
  }
}
