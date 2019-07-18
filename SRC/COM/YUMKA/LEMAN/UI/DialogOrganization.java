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
import com.yumka.leman.database.OrganizationBean;

//import com.yumka.leman.ui.login.PanelAddUserData;

public class DialogOrganization extends JDialog {
  JFrame frame;
  InternalFrameOrganizations frameOrganizations;
  JPanel panel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  PanelAddOrganizationData panelOrganizationData;
  JPanel buttons = new JPanel();
  JButton ok = new JButton("Aceptar");
  JButton cancel = new JButton("Cancelar");
  OrganizationBean organization;
  /**
   *
   * @param frame JFrame
   */public DialogOrganization(JFrame frame,
                               InternalFrameOrganizations frameOrganizations) {
    super(frame, "Leman-Organizaciones", true);
    this.frame = frame;
    this.frameOrganizations = frameOrganizations;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public DialogOrganization(JFrame frame,
                            InternalFrameOrganizations frameOrganizations,
                            OrganizationBean organization) {
    super(frame, "Leman-Organizaciones", true);
    this.frame = frame;
    this.frameOrganizations = frameOrganizations;
    this.organization = organization;

    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   *
   * @throws Exception
   */
  private void jbInit() throws Exception {
    buttons.setLayout(new GridLayout(1, 3));
    buttons.add(new JPanel());
    buttons.add(ok);
    buttons.add(cancel);
    panel.setLayout(borderLayout1);
    panelOrganizationData = new PanelAddOrganizationData();
    panel.add(new JPanel(), BorderLayout.NORTH);
    panel.add(new JPanel(), BorderLayout.EAST);
    panel.add(new JPanel(), BorderLayout.WEST);
    panel.add(panelOrganizationData, BorderLayout.CENTER);
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
        addOrganization();
      }
    });
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancel();
      }
    });
    if (this.organization != null) {
      this.panelOrganizationData.setOrganizationName(organization.getName());
      this.panelOrganizationData.setOrganizationAddress(organization.getAddress());
      this.panelOrganizationData.setOrganizationTelephone(organization.
          getTelephone());
    }
    this.pack();
    this.show();
  }
  public void addOrganization() {
    try {
      OrganizationBean organi = LemanMain.database.addOrganization(this.
          panelOrganizationData.getOrganizationName(),
                                this.panelOrganizationData.
                                            getOrganizationAddress(),
                                            this.panelOrganizationData.
                                            getOrganizationTelephone());
    }
    catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Leman-Error",
                                    JOptionPane.ERROR_MESSAGE);
    }
    frameOrganizations.refreshOrgs();
    this.cancel();
  }
  public void cancel() {
    this.dispose();
  }
}
