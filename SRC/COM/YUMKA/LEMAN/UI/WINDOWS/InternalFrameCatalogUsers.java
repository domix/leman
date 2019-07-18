package com.yumka.leman.ui.windows;

import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.yumka.leman.database.Manager;
import com.yumka.leman.database.UserBean;
import com.yumka.leman.database.UserManager;
import com.yumka.leman.ui.table.UserBeanTableModel;
import com.yumka.leman.ui.users.DialogUser;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class InternalFrameCatalogUsers extends InternalFrameCatalog {
  UserBean[] users;
  public InternalFrameCatalogUsers(JDesktopPane desktop, JFrame parent) {
    super(desktop, "Catalogo de Usuarios", parent);
    try {
      this.loadData();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    this.setButtonAddActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addUser();
      }
    });
    this.setButtonEditActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editUser();
      }
    });
    this.setButtonDeleteActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteUser();
      }
    });
  }
  public void loadData() throws Exception {
    users = UserManager.getInstance().loadAll();
    this.setTableModelRe(new UserBeanTableModel(users));
  }
  public void addUser() {
    DialogUser dialogUser = new DialogUser(this);
  }
  public void editUser() {
    int numUser = this.table.getSelectedRow();

    if (numUser >= 0) {
      try {
        UserBean user = UserManager.getInstance().loadByPrimaryKey( ( (String)this.
            table.getValueAt(numUser, 0)));
        DialogUser dialogUser = new DialogUser(this, user);
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }
  public void deleteUser() {
    int numUser = this.table.getSelectedRow();

    if (numUser >= 0) {
      String men = "¿Deseas borrar al usuario " + table.getValueAt(numUser, 1) +
                   "?";
      int i = JOptionPane.showConfirmDialog(this.frame, men, "Leman-Usuarios",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);
      if (i == 0) {

        try {
          UserManager.getInstance().deleteByPrimaryKey( ( (String)this.table.
              getValueAt(numUser, 0)));
          //Manager.getInstance().endTransaction(true);
          this.loadData();
        }
        catch (Exception ex) {}
      }
    }
  }
}
