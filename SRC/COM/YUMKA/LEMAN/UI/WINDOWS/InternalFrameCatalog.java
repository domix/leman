package com.yumka.leman.ui.windows;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.TableModel;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class InternalFrameCatalog extends InternalFrame {
  private JToolBar jToolBar = new JToolBar();
  private JButton buttonAdd = new JButton();
  private JButton buttonEdit = new JButton();
  private JButton buttonDelete = new JButton();
  private JButton buttonReport = new JButton();
  protected JTable table;
  protected TableModel tableModel;

  public InternalFrameCatalog(JDesktopPane desktop, String title, JFrame parent) {
    super(desktop, title, parent, false);
    try {
      this.buildUI();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    this.showInternalFrame();
  }
  private void buildUI() throws Exception {
    this.table = new JTable(this.tableModel);
    this.buttonAdd.setText("Agregar");
    this.buttonEdit.setText("Editar");
    this.buttonDelete.setText("Borrar");
    this.buttonReport.setText("Reporte");
    this.jToolBar.add(this.buttonAdd);
    this.jToolBar.add(this.buttonEdit);
    this.jToolBar.add(this.buttonDelete);
    this.jToolBar.add(this.buttonReport);
    Container co = this.getContentPane();
    co.setLayout(new BorderLayout());
    co.add(this.jToolBar, BorderLayout.NORTH);
    co.add(new JScrollPane(this.table), BorderLayout.CENTER);
  }
  public void setTableModelRe(TableModel tableModel) {
    this.tableModel = tableModel;
    this.table.setModel(this.tableModel);
  }
  public void setButtonAddActionListener(ActionListener actionListener) {
    this.buttonAdd.addActionListener(actionListener);
  }
  public void setButtonEditActionListener(ActionListener actionListener) {
    this.buttonEdit.addActionListener(actionListener);
  }
  public void setButtonDeleteActionListener(ActionListener actionListener) {
    this.buttonDelete.addActionListener(actionListener);
  }
  public void setButtonReportActionListener(ActionListener actionListener) {
    this.buttonReport.addActionListener(actionListener);
  }

}
