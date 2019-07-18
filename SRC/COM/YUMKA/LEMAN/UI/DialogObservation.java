package com.yumka.leman.ui;

import java.awt.*;
import javax.swing.*;
import com.yumka.leman.database.*;
import com.yumka.leman.LemanMain;
import java.awt.event.*;

public class DialogObservation extends JDialog {
  JPanel panel1 = new JPanel();
  JPanel panelLabels = new JPanel();
  JPanel panelText = new JPanel();
  JPanel panelBotones = new JPanel();
  JTextArea obs = new JTextArea();
  JTextField resp = new JTextField();
  JTextField acc = new JTextField();
  JTextField plazo = new JTextField();
  JButton ok = new JButton("Aceptar");
  EvaluationsdetailBean evaluationDetail;

  public DialogObservation(Frame frame, EvaluationsdetailBean evaluationDetail) {
    super(frame, "Account-Observación", true);
    this.evaluationDetail = evaluationDetail;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    this.setLocation( (screenSize.width - frameSize.width) / 2,
                      (screenSize.height - frameSize.height) / 2);


    show();
  }

  private void jbInit() throws Exception {
    panelLabels.setLayout(new GridLayout(4, 1));
    panelLabels.add(new JLabel("Observación"));
    panelLabels.add(new JLabel("Responsable"));
    panelLabels.add(new JLabel("Acción a tomar"));
    panelLabels.add(new JLabel("Plazo"));

    obs = new JTextArea(2, 30);
    obs.setWrapStyleWord(true);
    obs.setLineWrap(true);


    panelText.setLayout(new GridLayout(4, 1));
    panelText.add(new JScrollPane(this.obs));
    panelText.add(this.resp);
    panelText.add(this.acc);
    panelText.add(this.plazo);

    panel1.setLayout(new GridLayout(1, 2));
    panel1.add(panelLabels);
    panel1.add(panelText);

    panelBotones.setLayout(new GridLayout(1, 4));
    panelBotones.add(new JPanel());
    panelBotones.add(new JPanel());
    panelBotones.add(new JPanel());
    panelBotones.add(this.ok);

    this.ok.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                saveComment();
              }
            });


    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(panel1, BorderLayout.CENTER);
    cp.add(new JPanel(), BorderLayout.NORTH);
    cp.add(panelBotones, BorderLayout.SOUTH);
    cp.add(new JPanel(), BorderLayout.WEST);
    cp.add(new JPanel(), BorderLayout.EAST);
  }
  public void cancel() {
    this.dispose();
  }
  public void saveComment() {
    //String comment, String responsable, String plazo, String accion
    LemanMain.database.addComment(this.evaluationDetail, this.obs.getText(), this.resp.getText(), this.plazo.getText(), this.acc.getText());
    this.cancel();
  }
}
