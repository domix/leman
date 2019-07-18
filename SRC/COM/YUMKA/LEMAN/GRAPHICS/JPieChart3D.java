package com.yumka.leman.graphics;

import java.text.NumberFormat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieItemLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.DefaultPieDataset;
import org.jfree.util.Rotation;
import com.yumka.leman.database.EvaluationsBean;
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


public class JPieChart3D {
  public static JFreeChart getJPieChart3D() {
    JFreeChart result = null;
    return result;
  }
}
