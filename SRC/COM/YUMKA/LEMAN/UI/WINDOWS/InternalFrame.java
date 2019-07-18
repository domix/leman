package com.yumka.leman.ui.windows;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class InternalFrame extends JInternalFrame {
  protected JFrame frame;
  protected JDesktopPane desktop;
  public InternalFrame(JDesktopPane desktop, String title, JFrame parent,
                       boolean show) {
    super(title, true, true, true, true);
    this.frame = parent;
    this.desktop = desktop;
    this.setBounds(0, 0, 615, 450);
    if (show) {
      this.showInternalFrame();
    }
  }
  public void showInternalFrame() {
    this.show();
    this.desktop.add(this);
    this.toFront();
  }
  public JFrame getFrame() {
    return frame;
  }
  public void loadData() throws Exception {
  }
}
