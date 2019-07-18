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
import com.yumka.leman.database.OrganizationBean;
import com.yumka.leman.database.OrganizationsManager;
import com.yumka.leman.ui.table.OrganizationBeanTableModel;
import com.yumka.leman.ui.windows.InternalFrame;

public class InternalFrameOrganizations extends InternalFrame {
  JFrame frame;
  JToolBar jToolBar = new JToolBar();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  JTable tableOrgs;
  OrganizationBean[] orgs;

  public InternalFrameOrganizations(JDesktopPane desktop, JFrame frame) throws
      SQLException {
    super(desktop, "Catalogo de Organizaciones", frame, true);
    this.frame = frame;
    buildUI();
  }
  private void buildUI() throws SQLException {
    tableOrgs = new JTable();
    orgs = OrganizationsManager.getInstance().loadAll();
    try {
      tableOrgs.setModel(new OrganizationBeanTableModel(orgs));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    jButton1.setText("Nuevo");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addOrganization();
      }
    });
    jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editOrganization();
      }
    });
    jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteOrganization();
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
    co.add(new JScrollPane(tableOrgs), BorderLayout.CENTER);
  }
  public void addOrganization() {
    DialogOrganization dialogOrganization = new DialogOrganization(this.frame, this);
  }
  public void editOrganization() {
    int numOrganization = this.tableOrgs.getSelectedRow();

    if (numOrganization >= 0) {
      try {
        OrganizationBean[] orgsa = OrganizationsManager.getInstance().
                                   loadByWhere("where ORGANIZATIONS.NAME = '" +
                                               ( (String)this.tableOrgs.
                                                getValueAt(numOrganization, 0)) +
                                               "'");
        OrganizationBean orgEdit = orgsa[0];
        DialogOrganization dialogOrganization = new DialogOrganization(this.
            frame, this, orgEdit);
      }
      catch (SQLException ex) {}
    }
  }
  public void refreshOrgs() {
    try {
      orgs = OrganizationsManager.getInstance().loadAll();
      this.tableOrgs.setModel(new OrganizationBeanTableModel(orgs));
    }
    catch (SQLException ex) {
    }
  }
  public void deleteOrganization() {

    int numOrganization = this.tableOrgs.getSelectedRow();

    if (numOrganization >= 0) {
      String men = "¿Desean borrar a la organización " +
                   tableOrgs.getValueAt(numOrganization, 0) + "?";
      int i = JOptionPane.showConfirmDialog(this.frame, men,
                                            "Leman-Organizaciones",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);
      if (i == 0) {

        try {
          OrganizationsManager.getInstance().deleteWhere("Name = '" +
              ( (String)this.tableOrgs.getValueAt(numOrganization, 0)) + "'");
          //Manager.getInstance().endTransaction(true);
          this.refreshOrgs();
        }
        catch (SQLException ex) {}
      }
    }
  }
}
