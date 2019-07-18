package com.yumka.leman.ui.windows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import org.jfree.report.JFreeReport;
import org.jfree.report.ReportProcessingException;
import org.jfree.report.modules.gui.base.PreviewFrame;
import org.jfree.report.modules.parser.base.ReportGenerator;
import org.jfree.ui.RefineryUtilities;
import org.jfree.xml.ElementDefinitionException;
import com.yumka.leman.database.ISOPointBean;
import com.yumka.leman.database.ISOPointManager;
import com.yumka.leman.ui.DialogISOPoint;
import com.yumka.leman.ui.table.ISOPointBeanTableModel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.report.Boot;
import org.jfree.report.ElementAlignment;
import org.jfree.report.JFreeReport;
import org.jfree.report.ReportProcessingException;
import org.jfree.report.elementfactory.TextFieldElementFactory;
import org.jfree.report.modules.gui.base.PreviewDialog;
import org.jfree.report.util.Log;
import org.jfree.ui.FloatDimension;
import org.jfree.report.modules.gui.base.PreviewInternalFrame;


public class InternalFrameCatalogISOPoints extends InternalFrameCatalog {
  ISOPointBean[] points;
  public InternalFrameCatalogISOPoints(JDesktopPane desktop, JFrame parent) {
    super(desktop, "Catálogo de los Puntos de la Norma ISO", parent);
    try {
      this.loadData();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    this.setButtonAddActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addISOPoint();
      }
    });
    this.setButtonEditActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editISOPoint();
      }
    });
    this.setButtonDeleteActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteISOPoint();
      }
    });
    this.setButtonReportActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        report();
      }
    });

  }
  public void loadData() throws Exception {
    points = ISOPointManager.getInstance().loadAll();
    this.setTableModelRe(new ISOPointBeanTableModel(points));
  }
  public void addISOPoint() {
    DialogISOPoint dialogISOPoint = new DialogISOPoint(this);
  }
  public void report() {
    this.attemptPreview();
  }

  /**
   * Reads the report from the swing-icons.xml report template.
   *
   * @param templateURL The template location.
   *
   * @return A report.
   * @throws ElementDefinitionException if the report generator encountered an error.
   * @throws IOException if there was an IO error while reading from the URL.
   */
  private JFreeReport parseReport(final URL templateURL) throws IOException,
      ElementDefinitionException {

    final ReportGenerator generator = ReportGenerator.getInstance();
    return generator.parseReport(templateURL);

  }

  /**
   * Creates a small dataset to use in a report.  JFreeReport always reads data from a
   * <code>TableModel</code> instance.
   *
   * @return a dataset.
   */
  private TableModel createData() {
    return tableModel;
  }



  /**
   * Displays a print preview screen for the sample report.
   */
  protected void attemptPreview() {
    final URL in = getClass().getResource(
        "/com/yumka/leman/ui/windows/ISOPointCatalogReport.xml");
    if (in == null) {
      JOptionPane.showMessageDialog(this, "no enconytrado", "error",
                                    JOptionPane.ERROR_MESSAGE);
    }

    JFreeReport report;
    try {
      report = parseReport(in);
      //report = this.createReportDefinition();
      report.setData(this.tableModel);
    }
    catch (Exception ex) {
      //showExceptionDialog("report.definitionfailure", ex);
      ex.printStackTrace();
      return;
    }

    try {
      final PreviewInternalFrame frame = new PreviewInternalFrame(report);
      frame.getBase().setLargeIconsEnabled(true);
      frame.getBase().setToolbarFloatable(false);
      frame.pack();
      frame.setClosable(true);
      frame.setAutoscrolls(true);
      frame.setSize(this.getSize());
      frame.setIconifiable(true);
      frame.setMaximizable(true);
      frame.setResizable(true);
      this.getDesktopPane().add(frame);
      frame.setVisible(true);
      frame.requestFocus();
    }
    catch (ReportProcessingException rpe) {
      rpe.printStackTrace();
    }

  }

  /**
   * Creates a report definition.
   *
   * @return a report definition.
   */
  private JFreeReport createReportDefinition() {
    final JFreeReport report = new JFreeReport();
    report.setName(getDescription());
    org.jfree.report.ReportHeader h = new org.jfree.report.ReportHeader();

    report.setReportHeader(h);
    TextFieldElementFactory factory = new TextFieldElementFactory();
    factory.setName("T1");
           factory.setAbsolutePosition(new Point2D.Float(0, 0));
           factory.setMinimumSize(new FloatDimension(150, 20));
           factory.setColor(Color.black);
           factory.setHorizontalAlignment(ElementAlignment.LEFT);
           factory.setVerticalAlignment(ElementAlignment.MIDDLE);
           factory.setNullString("-");
           factory.setFieldname("Punto");
           report.getItemBand().addElement(factory.createElement());

           factory = new TextFieldElementFactory();
           factory.setName("T2");
           factory.setAbsolutePosition(new Point2D.Float(200, 0));
           factory.setMinimumSize(new FloatDimension(150, 20));
           factory.setColor(Color.black);
           factory.setHorizontalAlignment(ElementAlignment.LEFT);
           factory.setVerticalAlignment(ElementAlignment.MIDDLE);
           factory.setNullString("-");
           factory.setFieldname("Descripción");
           report.getItemBand().addElement(factory.createElement());
     return report;
  }

  /**
   * Returns a short description of the demo.
   * @return
   */
  public String getDescription() {
    return "A Very Simple Report";
  }
  public void editISOPoint() {
    int num = this.table.getSelectedRow();

    if (num >= 0) {
      try {
        ISOPointBean point = ISOPointManager.getInstance().loadByPrimaryKey( ( (
            String)this.table.getValueAt(num, 0)));
        DialogISOPoint dialogISOPoint = new DialogISOPoint(this, point);
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }
  public void deleteISOPoint() {
    int numISOPoint = this.table.getSelectedRow();

    if (numISOPoint >= 0) {
      String men = "¿Deseas borrar el Punto ISO " +
                   table.getValueAt(numISOPoint, 1) + "?";
      int i = JOptionPane.showConfirmDialog(this.frame, men, "Leman-Puntos ISO",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);
      if (i == 0) {

        try {
          ISOPointManager.getInstance().deleteByPrimaryKey( ( (String)this.
              table.getValueAt(numISOPoint, 0)));
          this.loadData();
        }
        catch (Exception ex) {}
      }
    }
  }
}
