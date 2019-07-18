package com.yumka.leman.ui.login;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Panel para hacer login a la aplicación
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class PanelLogin extends JPanel {
  private JTextField userName = new JTextField(20);
  private JPasswordField userPassword = new JPasswordField(20);
  public PanelLogin() {
    this.setLayout(new GridLayout(2, 2));
    this.add(new JLabel("Nombre de Usuario:"));
    this.add(this.userName);
    this.add(new JLabel("Contraseña:"));
    this.add(this.userPassword);
  }
  public void addActionListenerFields(ActionListener al) {
    this.userName.addActionListener(al);
    this.userPassword.addActionListener(al);
  }
  public String getUserName() {
    return this.userName.getText();
  }
  public void setUserName(String _userName) {
    this.userName.setText(_userName);
  }
  public char[] getUserPassword() {
    return this.userPassword.getPassword();
  }
  public void setUserPassword(String _userPassword) {
    this.userPassword.setText(_userPassword);
  }
}
