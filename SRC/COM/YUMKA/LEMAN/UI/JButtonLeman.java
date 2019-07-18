package com.yumka.leman.ui;

import java.awt.Cursor;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class JButtonLeman extends JButton {
  private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
  public JButtonLeman() {
    super();
  }

  public JButtonLeman(String p0) {
    super(p0);
    this.setCursor(cursor);
  }

  public JButtonLeman(Action p0) {
    super(p0);
    this.setCursor(cursor);
  }

  public JButtonLeman(Icon p0) {
    super(p0);
    this.setCursor(cursor);
  }

  public JButtonLeman(String p0, Icon p1) {
    super(p0, p1);
    this.setCursor(cursor);
  }
}
