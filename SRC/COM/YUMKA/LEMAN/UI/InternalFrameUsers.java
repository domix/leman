package com.yumka.leman.ui;

import java.sql.SQLException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import com.yumka.leman.database.Manager;
import com.yumka.leman.database.UserBean;
import com.yumka.leman.database.UserManager;
import com.yumka.leman.ui.table.UserBeanTableModel;
import com.yumka.leman.ui.users.DialogUser;
import com.yumka.leman.ui.windows.InternalFrame;

/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class InternalFrameUsers extends InternalFrame {
  //JFrame frame;
  JToolBar jToolBar = new JToolBar();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  JTable tableUsers;
  UserBean[] users;

  public InternalFrameUsers(JDesktopPane desktop, String title, JFrame frame) throws
      SQLException {
    super(desktop, title, frame, true);
    //this.frame = frame;
    buildUI();
  }
  private void buildUI() throws SQLException {
    tableUsers = new JTable();
    users = UserManager.getInstance().loadAll();
    try {
      tableUsers.setModel(new UserBeanTableModel(users));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    jButton1.setText("Nuevo");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addUser();
      }
    });
    jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editUser();
      }
    });
    jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteUser();
      }
    });
    jButton2.setText("Editar");
    jButton3.setText("Borrar");
    jToolBar.add(jButton1);
    jToolBar.add(jButton2);
    jToolBar.add(jButton3);
    Container co = this.getContentPane();
    co.setLayout(new BorderLayout());
    co.add(this.jToolBar, BorderLayout.NORTH);
    co.add(new JScrollPane(tableUsers), BorderLayout.CENTER);
  }

  /**
   * Add a user.
   */
  public void addUser() {
    DialogUser dialogUser = new DialogUser(this);
  }
  public void editUser() {
    int numUser = this.tableUsers.getSelectedRow();

    if (numUser >= 0) {
      try {
        UserBean user = UserManager.getInstance().loadByPrimaryKey( ( (String)this.
            tableUsers.getValueAt(numUser, 0)));
        DialogUser dialogUser = new DialogUser(this, user);
      }
      catch (SQLException ex) {}
    }
  }

  /**
   * refreshUsers
   */
  public void refreshUsers() {
    try {
      users = UserManager.getInstance().loadAll();
      this.tableUsers.setModel(new UserBeanTableModel(users));
    }
    catch (SQLException ex) {
    }
  }
  public void deleteUser() {

    int numUser = this.tableUsers.getSelectedRow();

    if (numUser >= 0) {
      String men = "¿Deseas borrar al usuario " +
                   tableUsers.getValueAt(numUser, 1) + "?";
      int i = JOptionPane.showConfirmDialog(this.frame, men, "Leman-Usuarios",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);
      if (i == 0) {

        try {
          UserManager.getInstance().deleteByPrimaryKey( ( (String)this.
              tableUsers.getValueAt(numUser, 0)));
          //Manager.getInstance().endTransaction(true);
          this.refreshUsers();
        }
        catch (SQLException ex) {}
      }
    }
  }
}
