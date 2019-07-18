package com.yumka.leman;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.*;

import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import com.yumka.leman.database.Database;
import com.yumka.leman.database.UserBean;
import com.yumka.leman.ui.login.DialogLogin;
import org.jfree.report.Boot;

/**
 * Application's Main class
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class LemanMain {
  boolean packFrame = false;
  public static Database database;
  private static UserBean user;

  /**
   * Construct the application
   */
  public LemanMain() {
    try {
      database = new Database();
    }
    catch (ClassNotFoundException ex) {
    }
    catch (InstantiationException ex) {
    }
    catch (IllegalAccessException ex) {
    }

    Frame frame = new Frame();

    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation( (screenSize.width - frameSize.width) / 2,
                      (screenSize.height - frameSize.height) / 2);
    this.login(frame);
    frame.setVisible(true);
    frame.setNameUser();
  }

  /**
   * Main method
   * @param args String[]
   */
  public static void main(String[] args) {
    try {
      Boot.start();
      JFrame.setDefaultLookAndFeelDecorated(true);
      JDialog.setDefaultLookAndFeelDecorated(true);

      SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack(LemanMain.class.
          getResource("aquathemepack.zip")));
      SkinLookAndFeel.enable();
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    new LemanMain();
  }
  private void login(JFrame frame) {
    DialogLogin dialog = new DialogLogin(frame);
  }
  public static void setUser(UserBean _user) {
    user = _user;
  }
  public static UserBean getUser() {
    return user;
  }
}
