package com.yumka.leman.graphics;

import java.text.NumberFormat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieItemLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.DefaultPieDataset;
import org.jfree.util.Rotation;
import com.yumka.leman.database.*;
import com.yumka.leman.database.EvaluationsdetailBean;
import com.yumka.leman.database.EvaluationsdetailManager;
import com.yumka.leman.database.ISOPointBean;
import com.yumka.leman.database.ISOPointManager;
import com.yumka.leman.database.OrganizationBean;
import com.yumka.leman.database.OrganizationsManager;
import com.yumka.leman.database.QuestionsBean;
import com.yumka.leman.database.QuestionsManager;
import com.yumka.leman.database.ResponseBean;
import com.yumka.leman.database.ResponseManager;
import com.yumka.leman.ui.table.*;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class JPanelPieChart extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  EvaluationsBean evaluation;
  JTabbedPane tabbedPane;
  ISOPointBean[] isoPoints = null;
  ChartPanel[] chartPanel = null;
  JFreeChart[] charts = null;
  JPanel panelSeguimiento = new JPanel();
  JTable tableSeguimiento;

  public JPanelPieChart(EvaluationsBean evaluation) {
    this.evaluation = evaluation;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    tableSeguimiento = new JTable();
    panelSeguimiento.setLayout(new BorderLayout());
    panelSeguimiento.add(new JScrollPane(this.tableSeguimiento), BorderLayout.CENTER);
    isoPoints = ISOPointManager.getInstance().loadByWhere(
        "WHERE ISOPOINTS.IDISOPOINT='0' AND ISOPOINTS.ID>=4");
    this.setLayout(borderLayout1);
    tabbedPane = new JTabbedPane();
    chartPanel = new ChartPanel[isoPoints.length + 1];
    charts = new JFreeChart[isoPoints.length + 1];

    this.charts[0] = this.getChart();
    this.chartPanel[0] = new ChartPanel(this.charts[0]);
    this.chartPanel[0].setPreferredSize(new java.awt.Dimension(500, 200));
    this.tabbedPane.addTab("Todos", chartPanel[0]);

    for (int i = 1; i < isoPoints.length + 1; i++) {

      this.charts[i] = this.getChart(isoPoints[i - 1]);
      this.chartPanel[i] = new ChartPanel(this.charts[i]);
      this.chartPanel[i].setPreferredSize(new java.awt.Dimension(500, 200));
      this.tabbedPane.addTab(isoPoints[i - 1].getId() + ".- " + isoPoints[i -
                             1].getDescription(), chartPanel[i]);
    }
    this.loadSeguimiento();
    this.tabbedPane.addTab("Seguimiento", panelSeguimiento);
    this.add(this.tabbedPane);
  }

  private void loadSeguimiento() {
    this.tableSeguimiento.setModel(this.getModelSeguimiento());
  }

  /**
   * getModelSeguimiento
   *
   * @return TableModel
   */
  private TableModel getModelSeguimiento() {
    return new SeguimientoTableModel(this.evaluation);
  }

  private JFreeChart getChart(ISOPointBean isoPoint) {
    JFreeChart result = null;
    if (evaluation != null) {
      DefaultPieDataset data = new DefaultPieDataset();
      ResponseBean[] responses = null;
      OrganizationBean organization = null;
      EvaluationsdetailBean[] evaluationsDetail = null;
      QuestionsBean[] questions = null;
      try {
        StringBuffer sql1 = new StringBuffer();
        sql1.append("WHERE QUESTIONS.TOPIC LIKE '");
        sql1.append(isoPoint.getId());
        sql1.append("%'");
        questions = QuestionsManager.getInstance().loadByWhere(sql1.toString());
        for (int i = 0; i < questions.length; i++) {
          try {
            organization = OrganizationsManager.getInstance().loadByPrimaryKey(
                evaluation.getIdorganization());
            responses = ResponseManager.getInstance().loadAll();

            for (int j = 0; j < responses.length; j++) {
              StringBuffer sql = new StringBuffer();
              sql.append("WHERE EVALUATIONSDETAIL.IDEVALUATION=");
              sql.append(evaluation.getId());
              sql.append(" AND EVALUATIONSDETAIL.IDRESPONSE=");
              sql.append(responses[j].getId());
              sql.append(" AND EVALUATIONSDETAIL.IDQUESTION LIKE '");
              sql.append(questions[i].getId().substring(0, 1));
              sql.append("%'");
              evaluationsDetail = EvaluationsdetailManager.getInstance().
                                  loadByWhere(sql.toString());
              data.setValue(responses[j].getMessage(), evaluationsDetail.length);
            }
          }
          catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
      String titleChart = "";
      titleChart = isoPoint.getId() + ".- " + isoPoint.getDescription();
      result = ChartFactory.createPieChart3D(titleChart, data, true, true, false); // include legend
      PiePlot3D plot = (PiePlot3D) result.getPlot();
      plot.setNoDataMessage("La evaluación aún no determina este punto");
      plot.setStartAngle(270);
      plot.setDirection(Rotation.ANTICLOCKWISE);
      plot.setForegroundAlpha(0.60f);
      plot.setInteriorGap(0.33);
      plot.setLabelGenerator(new StandardPieItemLabelGenerator(
          "{0}: ({1} = {2})", NumberFormat.getNumberInstance(),
          NumberFormat.getPercentInstance()));

      Rotator rotator = new Rotator(plot);
      rotator.start();
    }
    return result;
  }
  public void refreshCharts() {
    this.charts[0] = this.getChart();
    this.chartPanel[0].setChart(this.charts[0]);
    for (int i = 1; i < this.isoPoints.length + 1; i++) {
      this.charts[i] = this.getChart(isoPoints[i - 1]);
      this.chartPanel[i].setChart(this.charts[i]);
    }
    this.loadSeguimiento();
  }

  private JFreeChart getChart() {
    JFreeChart result = null;
    DefaultPieDataset data = new DefaultPieDataset();
    if (evaluation != null) {

      ResponseBean[] responses = null;
      OrganizationBean organization = null;
      EvaluationsdetailBean[] evaluationsDetail = null;
      QuestionsBean[] questions = null;

      try {
        questions = QuestionsManager.getInstance().loadAll();
        responses = ResponseManager.getInstance().loadAll();
        for (int i = 0; i < responses.length; i++) {
          StringBuffer sql = new StringBuffer();
          sql.append("WHERE EVALUATIONSDETAIL.IDEVALUATION=");
          sql.append(evaluation.getId());
          sql.append(" AND EVALUATIONSDETAIL.IDRESPONSE=");
          sql.append(responses[i].getId());

          evaluationsDetail = EvaluationsdetailManager.getInstance().
                              loadByWhere(sql.toString());

          data.setValue(responses[i].getMessage(), evaluationsDetail.length);
        }
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
      String titleChart = "Todos los puntos";
      result = ChartFactory.createPieChart3D(titleChart, data, true, true, false); // include legend
      PiePlot3D plot = (PiePlot3D) result.getPlot();
      plot.setNoDataMessage("La evaluación aún no determina este punto");
      plot.setStartAngle(270);
      plot.setDirection(Rotation.ANTICLOCKWISE);
      plot.setForegroundAlpha(0.60f);
      plot.setInteriorGap(0.33);
      plot.setLabelGenerator(new StandardPieItemLabelGenerator(
          "{0}: ({1} = {2})", NumberFormat.getNumberInstance(),
          NumberFormat.getPercentInstance()));

      Rotator rotator = new Rotator(plot);
      rotator.start();
    }
    return result;
  }

}

/**
 *
 * The rotator.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
class Rotator extends Timer implements ActionListener {
  private boolean stopped = false;
  public void setStopped(boolean stopped) {
    this.stopped = stopped;
  }

  /** The plot. */
  private PiePlot3D plot;

  /** The angle. */
  private int angle = 270;

  /**
   * Constructor.
   *
   * @param plot  the plot.
   */
  Rotator(PiePlot3D plot) {
    super(100, null);
    this.plot = plot;
    addActionListener(this);
  }

  /**
   * Modifies the starting angle.
   *
   * @param event  the action event.
   */ public void actionPerformed(ActionEvent event) {
    if (!this.stopped) {
      this.plot.setStartAngle(this.angle);
      this.angle = this.angle + 1;
      if (this.angle == 360) {
        this.angle = 0;
      }
    }
  }
}
