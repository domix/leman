package com.yumka.leman;


import java.util.ArrayList;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import org.jfree.ui.about.AboutFrame;
import org.jfree.ui.about.Contributor;
import org.jfree.ui.about.Library;
import org.jfree.ui.about.ProjectInfo;
import com.yumka.leman.ui.InternalFrameOrganizations;
import com.yumka.leman.ui.MenuLeman;
import com.yumka.leman.ui.DialogOpenEvaluation;
import com.yumka.leman.ui.ResourceLoader;
import com.yumka.leman.ui.windows.InternalFrameCatalogISOPoints;
import com.yumka.leman.ui.windows.InternalFrameCatalogQuestions;
import com.yumka.leman.ui.windows.InternalFrameCatalogUsers;
import com.yumka.leman.ui.windows.InternalFrameEvaluation;
import com.yumka.leman.database.*;
import java.awt.event.*;


/**
 * Application's GUI
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class Frame extends JFrame {
  JDesktopPane desk;
  JPanel contentPane;
  JToolBar jToolBar = new JToolBar();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  JLabel statusBar = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();

  /**
   * Get the JDesktopPane
   * @return JDesktopPane
   */public JDesktopPane getDesktop() {
    return this.desk;
  }

  /**
   * Construct the frame
   */
  public Frame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Component initialization
   * @throws Exception
   */
  private void jbInit() throws Exception {
    // Create a desktop and set it as the content pane. Don't set the layered
    // pane, since it needs to hold the menubar too.
    desk = new JDesktopPane();

    image1 = ResourceLoader.getImageIcon("openFile.png");
    image2 = ResourceLoader.getImageIcon("closeFile.png");
    image3 = ResourceLoader.getImageIcon("help.png");
    contentPane = (JPanel)this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(800, 550));
    this.setTitle("Leman - Sistema de Gestión de la Calidad");
    statusBar.setText(" ");
    jButton1.setIcon(image1);
    jButton1.setToolTipText("Abrir Evaluación");
    jButton2.setIcon(image2);
    jButton2.setToolTipText("Cerrar Archivo");
    jButton3.setIcon(image3);
    jButton3.setToolTipText("Ayuda");
    jButton1.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                 jMenuFileOpenEvaluation_actionPerformed(e);
               }
             });
    jToolBar.add(jButton1);
    jToolBar.addSeparator();
    jToolBar.add(jButton3);
    this.setJMenuBar(new MenuLeman(this));
    contentPane.add(jToolBar, BorderLayout.NORTH);
    contentPane.add(statusBar, BorderLayout.SOUTH);

    JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   new NavigationPanel(this),
                                   new JScrollPane(desk));
    contentPane.add(sp);

  }

  /**
   * Set a message in the frame's status bar
   * @param message String
   */
  public void setMessageStatus(String message) {
    this.statusBar.setText(message);
  }
  public void setNameUser() {
    this.setMessageStatus("Usuario: " + LemanMain.getUser().getName());
  }

  /**
   * File | Exit action performed
   * @param e ActionEvent
   */
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    LemanMain.database.closeAllConnections();
    System.exit(0);
  }
  public void jMenuFileNewEvaluation_actionPerformed(ActionEvent e) {
    new InternalFrameEvaluation(this.getDesktop(), this);
  }


  /**
   * Help | About action performed
   * @param e ActionEvent
   */
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    ArrayList contributors = new ArrayList();
        ArrayList libraries = new ArrayList();
        Contributor c;
        Library l;
        c = new Contributor("Cesar Serrano", "cesareo@hotmail.com");
        contributors.add(c);
        c = new Contributor("Domingo Suárez Torres", "yumkasoftware@prodigy.net.mx");
        contributors.add(c);
        c = new Contributor("Elmy Helen", "elhemylen@hotmail.com");
        contributors.add(c);
        c = new Contributor("Juan Manuel Trujillo Moreno", "jhonybravojm@hotmail.com");
        contributors.add(c);

        l = new Library("JFreeChart", "0.9.18", "license", "info");
        libraries.add(l);
        l = new Library("JFreeReport", "0.8.4.10", "license", "info");
        libraries.add(l);
        l = new Library("jCommon", "0.9.3", "license", "info");
        libraries.add(l);
        l = new Library("HiperSonic SQL", "0.9.3", "license", "info");
        libraries.add(l);

        ProjectInfo pI = new ProjectInfo();
        pI.setContributors(contributors);
        pI.setCopyright("Copyrigth (c) 1997-2004");
        pI.setInfo("Coordinador: M.Sc. Miguel Angel López Flores");
        pI.setLicenceName("GPL");
        pI.setLicenceText(ResourceLoader.getTextFile("licence-LGPL.txt"));
        pI.setLogo(ResourceLoader.getImage("about.png"));
        pI.setName("Leman-Sistema de Gestión de la Calidad");
        pI.setVersion("1.0");
        pI.setLibraries(libraries);
        AboutFrame aF = new AboutFrame("Acerca de...", pI);
        Dimension dlgSize = aF.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        aF.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        aF.pack();
        aF.show();

  }

  /**
   *
   * @param e ActionEvent
   */
  public void jMenuCatalogsUsers_actionPerformed(ActionEvent e) throws
      Exception {
    new InternalFrameCatalogUsers(this.getDesktop(), this);
  }

  public void jMenuCatalogOrganizations_actionPerformed(ActionEvent e) throws
      Exception {
    new InternalFrameOrganizations(this.getDesktop(), this);
  }
  public void jMenuCatalogISOPoints_actionPerformed(ActionEvent e) throws
      Exception {
    new InternalFrameCatalogISOPoints(this.getDesktop(), this);
  }
  public void jMenuCatalogQuestions_actionPerformed(ActionEvent e) throws
      Exception {
    new InternalFrameCatalogQuestions(this.getDesktop(), this);
  }
  /**
   * Overridden so we can exit when window is closed
   * @param e WindowEvent
   */
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      jMenuFileExit_actionPerformed(null);
    }
  }

  /**
   * jMenuFileOpenEvaluation_actionPerformed
   *
   * @param e ActionEvent
   */
  public void jMenuFileOpenEvaluation_actionPerformed(ActionEvent e) {
    DialogOpenEvaluation dialog = new DialogOpenEvaluation(this);
    EvaluationsBean eval = dialog.getEvaluation();
    if(eval != null) {
      System.out.println("Abriendo evaluación" + eval);
      new InternalFrameEvaluation(this.desk, this, eval);
    }
    else {
      System.out.println("No se abre evaluación");
    }
  }
}
