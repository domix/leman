package com.yumka.leman.ui.login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.yumka.leman.LemanMain;
import com.yumka.leman.database.UserBean;
import com.yumka.leman.ui.PanelDataInputUser;

public class DialogLogin extends JDialog {
  public PanelLogin panelLogin = new PanelLogin();
  public PanelDataInputUser panelUser = new PanelDataInputUser();
  private Container cp;
  private JButton ok = new JButton("Ok");
  private JButton cancel = new JButton("Cancelar");
  private JPanel buttons = new JPanel();
  public DialogLogin(Frame owner) {
    super(owner, "Ingreso al Sistema", true);
    this.setResizable(false);
    cp = this.getContentPane();

    cp.setLayout(new BorderLayout());
    cp.add(this.panelLogin, BorderLayout.CENTER);

    ActionListener al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        checkLogin();
      }
    };
    this.ok.addActionListener(al);
    this.panelLogin.addActionListenerFields(al);
    this.cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancelLogin();
      }
    });

    buttons.setLayout(new GridLayout(1, 3));
    buttons.add(new JPanel());
    buttons.add(this.ok);
    buttons.add(this.cancel);

    cp.add(this.buttons, BorderLayout.SOUTH);
    cp.add(new JPanel(), BorderLayout.NORTH);
    cp.add(new JPanel(), BorderLayout.EAST);
    cp.add(new JPanel(), BorderLayout.WEST);

    Dimension dlgSize = this.getPreferredSize();
    Dimension frmSize = owner.getSize();
    Point loc = owner.getLocation();
    this.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
                     (frmSize.height - dlgSize.height) / 2 + loc.y);
    this.pack();
    this.show();
  }
  public boolean checkLogin() {
    System.out.println("login");
    boolean result = false;
    String user = this.panelLogin.getUserName();
    String password = new String(this.panelLogin.getUserPassword());
    UserBean userBean = LemanMain.database.login(user, password);

    if (userBean != null) {
      LemanMain.setUser(userBean);
      result = true;
      this.cancel();
    }

    return result;
  }
  public void cancelLogin() {
    this.cancel();
    System.exit(0);
  }

  /**
   * Overridden so we can exit when window is closed
   * @param e WindowEvent
   */
  protected void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      this.cancelLogin();
    }
    super.processWindowEvent(e);
  }

  /**
   * Close the dialog
   */
  void cancel() {
    dispose();
  }
}
