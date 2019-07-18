package com.yumka.leman;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class LoginDialogOld extends JDialog {
  //componentes graficos
  private JTextField user, user2, eMail;
  private JPasswordField pass, pass2;

  //private LoginListener listener;

  public LoginDialogOld(Frame frame /*LoginListener listener*/) {
    super(frame, "Login", true);
    //this.set
    //this.listener = listener;

    Container c = getContentPane();

    //central panel
    JPanel central = new JPanel();
    GridLayout centralLayout = new GridLayout(1, 2);
    centralLayout.setVgap(10);
    centralLayout.setHgap(10);
    central.setLayout(centralLayout);

    //login components
    JPanel login = new JPanel();
    BorderLayout border = new BorderLayout();
    border.setVgap(10);
    border.setHgap(10);
    login.setLayout(border);
    login.setBorder(BorderFactory.createTitledBorder("Login"));
    user = new JTextField(10);
    pass = new JPasswordField(10);
    //pass.setEchoChar('*');
    JPanel loginFields = new JPanel();
    GridLayout layout = new GridLayout(2, 2);
    layout.setVgap(10);
    layout.setHgap(10);
    loginFields.setLayout(layout);
    loginFields.add(new JLabel("Nombre"));
    loginFields.add(user);
    loginFields.add(new JLabel("Contraseña"));
    loginFields.add(pass);
    JButton loginSubmit = new JButton("Login");
    login.add(loginFields);
    login.add(loginSubmit, BorderLayout.SOUTH);

    //create account components
    JPanel account = new JPanel();
    BorderLayout border2 = new BorderLayout();
    border2.setVgap(10);
    border2.setHgap(10);
    account.setLayout(border2);
    account.setBorder(BorderFactory.createTitledBorder("Crear nueva cuenta"));
    user2 = new JTextField(10);
    pass2 = new JPasswordField(10);
    //pass2.setEchoChar('*');
    eMail = new JTextField(10);
    JPanel accountFields = new JPanel();
    GridLayout layout2 = new GridLayout(3, 2);
    /*layout2.setVgap(10);
         layout2.setHgap(10);*/accountFields.setLayout(layout2);
    accountFields.add(new JLabel("Nombre"));
    accountFields.add(user2);
    accountFields.add(new JLabel("Contraseña"));
    accountFields.add(pass2);
    accountFields.add(new JLabel("eMail"));
    accountFields.add(eMail);
    JButton accountSubmit = new JButton("Crear cuenta");
    account.add(accountFields);
    account.add(accountSubmit, BorderLayout.SOUTH);

    //buttons panel
    JPanel buttons = new JPanel();
    buttons.setLayout(new FlowLayout());
    JButton close = new JButton("Cerrar");
    //close.setIcon(Images.getImageIcon("cancel"));
    close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        clear();
      }
    });

    //loginSubmit.setIcon(Images.getImageIcon("ok"));
    loginSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireLoginEvent();
        setVisible(false);
        clear();
      }
    });

    //accountSubmit.setIcon(Images.getImageIcon("ok"));
    accountSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireCreateAccountEvent();
        setVisible(false);
        clear();
      }
    });

    buttons.add(close);
    central.add(login);
    central.add(account);

    //c.add(new JLabel("Login", Images.getImageIcon("login"), JLabel.LEFT), BorderLayout.NORTH);
    c.add(new JLabel("Login", JLabel.LEFT), BorderLayout.NORTH);
    c.add(central);
    c.add(buttons, BorderLayout.SOUTH);
    //pack();

    Dimension dlgSize = this.getPreferredSize();
    Dimension frmSize = frame.getSize();
    Point loc = frame.getLocation();
    this.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
                     (frmSize.height - dlgSize.height) / 2 + loc.y);
    //dlg.setTitle(title);
    //dlg.setMessage(msg);
    this.setModal(true);
    this.pack();
    this.show();

  }

  private void fireLoginEvent() {
    //listener.login(user.getText(), new String(pass.getPassword()));
  }

  private void fireCreateAccountEvent() {
    //listener.createAccount(user2.getText(), new String(pass2.getPassword()), eMail.getText());
  }

  private void clear() {
    user.setText("");
    user2.setText("");
    eMail.setText("");
    pass.setText("");
    pass2.setText("");
  }

}
