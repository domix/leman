package com.yumka.leman.graphics;

import java.awt.Color;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import com.yumka.leman.database.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.ui.*;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

import java.sql.*;
import java.awt.image.*;
import javax.swing.*;
import com.yumka.leman.database.*;
import org.jfree.chart.*;
import org.jfree.chart.annotations.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.event.*;
import org.jfree.chart.imagemap.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.needle.*;
import org.jfree.chart.plot.*;

import org.jfree.chart.renderer.*;
import org.jfree.chart.resources.*;
import org.jfree.chart.title.*;
import org.jfree.chart.ui.*;
import org.jfree.chart.urls.*;
import org.jfree.data.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.DefaultPieDataset;
import org.jfree.data.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

import java.sql.*;
import java.awt.image.*;
import javax.swing.*;
import com.yumka.leman.database.*;
import org.jfree.chart.*;
import org.jfree.chart.annotations.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.event.*;
import org.jfree.chart.imagemap.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.needle.*;
import org.jfree.chart.plot.*;

import org.jfree.chart.renderer.*;
import org.jfree.chart.resources.*;
import org.jfree.chart.title.*;
import org.jfree.chart.ui.*;
import org.jfree.chart.urls.*;
import org.jfree.data.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.DefaultPieDataset;
import org.jfree.data.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;


public class Graphics {

  public static ImageIcon createPieChartDemo(EvaluationsBean evaluation) {
    DefaultPieDataset pieDataset = new DefaultPieDataset();
    pieDataset.setValue("Java", new Integer(75));
    pieDataset.setValue("C++", new Integer(25));
    pieDataset.setValue("Delphi", new Integer(50));
    pieDataset.setValue("Other", new Integer(5));

    JFreeChart chart =
      ChartFactory.createPieChart3D("Ejemplo de 3D",
        pieDataset, true, true, true);

    PiePlot3D plot = (PiePlot3D) chart.getPlot();
         /* plot.setStartAngle(290);
          plot.setDirection(Rotation.CLOCKWISE);*/
          plot.setForegroundAlpha(0.5f);
          //plot.setNoDataMessage("No data to display");
          //plot.setLabelGenerator(new CustomLabelGenerator());



    //chart.setAntiAlias(true);
    return new ImageIcon(chart.createBufferedImage(500, 200));
  }
  public ImageIcon createPieChartFromEvaluation(EvaluationsBean evaluation) {
    ImageIcon result = null;
    EvaluationsdetailBean[] detailsEvaluation = null;
    EvaluationsdetailBean[] detailsEvaluationISOPoint4 = null;
    EvaluationsdetailBean[] detailsEvaluationISOPoint5 = null;
    EvaluationsdetailBean[] detailsEvaluationISOPoint6 = null;
    EvaluationsdetailBean[] detailsEvaluationISOPoint7 = null;
    EvaluationsdetailBean[] detailsEvaluationISOPoint8 = null;
    try {
      StringBuffer sb = new StringBuffer();
      sb.append("WHERE EVALUATIONSDETAIL.IDEVALUATION=");
      sb.append(evaluation.getId());
      sb.append(" AND EVALUATIONSDETAIL.IDQUESTION=");
      sb.append("");
      sb.append("");
      sb.append("");
      sb.append("");
      sb.append("");
      sb.append("");
      sb.append("");

      /*
       "", "",
      "EVALUATIONSDETAIL.IDRESPONSE"
       */

       detailsEvaluation = EvaluationsdetailManager.getInstance().loadByIdevaluation(evaluation.getId());
       detailsEvaluationISOPoint4 = EvaluationsdetailManager.getInstance().loadByWhere("");
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    int i = detailsEvaluation.length;


    return result;
  }
  public JFreeChart getChart() {
    return null;
  }
}
