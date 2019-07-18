package com.yumka.leman.ui.users;

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
import com.yumka.leman.database.UserBean;
import com.yumka.leman.ui.login.PanelAddUserData;
import com.yumka.leman.ui.windows.InternalFrame;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class DialogUser extends JDialog {
  JFrame frame;
  InternalFrame frameUsers;
  JPanel panel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  PanelAddUserData panelUserData;
  JPanel buttons = new JPanel();
  JButton ok = new JButton("Aceptar");
  JButton cancel = new JButton("Cancelar");
  UserBean user;
  /**
   *
   * @param frame JFrame
   */public DialogUser(InternalFrame frameUsers) {
    super(frameUsers.getFrame(), "Leman-Usuarios", true);
    //frameUsers.getfra
    this.frame = frameUsers.getFrame();
    this.frameUsers = frameUsers;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public DialogUser(InternalFrame frameUsers, UserBean user) {
    super(frameUsers.getFrame(), "Leman-Usuarios", true);
    this.frame = frameUsers.getFrame();
    this.frameUsers = frameUsers;
    this.user = user;

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
    panelUserData = new PanelAddUserData();
    panel.add(new JPanel(), BorderLayout.NORTH);
    panel.add(new JPanel(), BorderLayout.EAST);
    panel.add(new JPanel(), BorderLayout.WEST);
    panel.add(panelUserData, BorderLayout.CENTER);
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
        addUser();
      }
    });
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancel();
      }
    });
    if (this.user != null) {
      this.panelUserData.setUserLogin(user.getLogin());
      this.panelUserData.setUserName(user.getName());
      this.panelUserData.setUserCompany(user.getCompany());
      this.panelUserData.setUserJobPosition(user.getJobposition());
      this.panelUserData.setUserPassword(user.getPassword());
    }
    this.pack();
    this.show();
  }
  public void addUser() {
    try {
      UserBean user = LemanMain.database.addUser(this.panelUserData.
                                                 getUserLogin(),
                                                 this.panelUserData.getUserName(),
                                                 new
                                                 String(this.panelUserData.getUserPassword()),
                                                 this.panelUserData.
                                                 getUserCompany(),
                                                 this.panelUserData.
                                                 getUserJobPosition());
      frameUsers.loadData();
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
