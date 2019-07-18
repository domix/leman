package com.yumka.leman.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.yumka.leman.LemanMain;
import com.yumka.leman.database.ISOPointBean;
import com.yumka.leman.ui.windows.InternalFrame;

public class DialogISOPoint extends JDialog {
  JFrame frame;
  InternalFrame frameISOPoints;
  JPanel panel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  PanelAddISOPointData panelISOPointData;
  JPanel buttons = new JPanel();
  JButton ok = new JButton("Aceptar");
  JButton cancel = new JButton("Cancelar");
  ISOPointBean point;
  public DialogISOPoint(InternalFrame frameISOPoints) {
    super(frameISOPoints.getFrame(), "Leman-Puntos ISO", true);
    this.frame = frameISOPoints.getFrame();
    this.frameISOPoints = frameISOPoints;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public DialogISOPoint(InternalFrame frameISOPoints, ISOPointBean point) {
    super(frameISOPoints.getFrame(), "Leman-Puntos ISO", true);
    this.frame = frameISOPoints.getFrame();
    this.frameISOPoints = frameISOPoints;
    this.point = point;

    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    buttons.setLayout(new GridLayout(1, 3));
    buttons.add(new JPanel());
    buttons.add(ok);
    buttons.add(cancel);
    panel.setLayout(borderLayout1);
    panelISOPointData = new PanelAddISOPointData();
    panel.add(new JPanel(), BorderLayout.NORTH);
    panel.add(new JPanel(), BorderLayout.EAST);
    panel.add(new JPanel(), BorderLayout.WEST);
    panel.add(panelISOPointData, BorderLayout.CENTER);
    panel.add(buttons, BorderLayout.SOUTH);
    Container con = this.getContentPane();
    con.setLayout(new BorderLayout());
    con.add(panel, BorderLayout.CENTER);
    this.setResizable(true);

    Dimension dlgSize = this.getPreferredSize();
    Dimension frmSize = frame.getSize();
    Point loc = frame.getLocation();
    this.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
                     (frmSize.height - dlgSize.height) / 2 + loc.y);

    ok.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addISOPoint();
      }
    });
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancel();
      }
    });
    if (this.point != null) {
      this.panelISOPointData.setPoint(point.getId());
      this.panelISOPointData.setDescription(point.getDescription());
      this.panelISOPointData.setBelongsToISOPoint(point.getIdisopoint());
    }
    this.pack();
    this.show();
  }
  public void addISOPoint() {
    try {
      ISOPointBean point = LemanMain.database.addISOPoint(this.
          panelISOPointData.getPoint(), this.panelISOPointData.getDescription(),
          this.panelISOPointData.getBelongsToISOPoint());
      frameISOPoints.loadData();
    }
    catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Leman-Error",
                                    JOptionPane.ERROR_MESSAGE);
    }

    this.cancel();
  }
  public void cancel() {
    this.dispose();
  }
}
