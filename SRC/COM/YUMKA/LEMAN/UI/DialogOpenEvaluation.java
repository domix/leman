package com.yumka.leman.ui;

import java.awt.*;
import javax.swing.*;
import com.yumka.leman.ui.table.*;
import com.yumka.leman.database.*;
import java.awt.event.*;
import com.yumka.leman.LemanMain;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class DialogOpenEvaluation extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JSplitPane split;
  JTable tableEvaluation;
  JPanel dataEvaluation;
  EvaluationsBean[] evaluations;
  EvaluationsBean evaluation = null;
  JPanel panelBotones;
  JButton okButton;
  JButton cancelButton;

  public DialogOpenEvaluation(Frame frame) {
    super(frame, "Abrir Evaluación", true);
    try {
      jbInit();
      pack();
      Dimension dlgSize = this.getPreferredSize();
      Dimension frmSize = frame.getSize();
      Point loc = frame.getLocation();
      this.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    panelBotones = new JPanel();
    panelBotones.setLayout(new GridLayout(1, 5));
    this.okButton = new JButton("Abrir");
    this.okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                      open();
                    }
                  });
    this.cancelButton = new JButton("Cancelar");
    this.cancelButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                          cancel();
                        }
                      });
    panelBotones.add(new JPanel());
    panelBotones.add(new JPanel());
    panelBotones.add(new JPanel());
    panelBotones.add(this.okButton);
    panelBotones.add(this.cancelButton);
    evaluations =  EvaluationsManager.getInstance().loadAll();

    this.tableEvaluation = new JTable(new EvaluationBeanTableModel(evaluations));
    this.dataEvaluation = new JPanel();


    this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(this.tableEvaluation), this.dataEvaluation);
    panel1.add(this.split, BorderLayout.CENTER);
    panel1.add(this.panelBotones, BorderLayout.SOUTH);


    getContentPane().add(panel1);
  }
  public EvaluationsBean getEvaluation() {
    return this.evaluation;
  }
  public void cancel() {
    evaluation = null;
    this.dispose();
  }
  public void open() {
    int num = this.tableEvaluation.getSelectedRow();
    int i  = 0;
    if (num >= 0) {
      try {
      i = Integer.parseInt((String)this.tableEvaluation.getValueAt(num, 4));
        /*String date = (String);
        System.out.println("date:" + date);
        String time = (String)this.tableEvaluation.getValueAt(num, 3);
        System.out.println("time:" + time);*/
        this.evaluation = EvaluationsManager.getInstance().loadByPrimaryKey(new Integer(i));
      }
      catch (Exception ex) {
        ex.printStackTrace();
        this.evaluation = null;
      }
      this.dispose();
    }
  }
}
