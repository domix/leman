package com.yumka.leman;

/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

class Box {
  int b, w;
  void Box(int b, int w) {
    this.b = b;
    this.w = w;
  }
}

public class MyBox extends Box {
  MyBox() {
    this.Box(10, 15);
    System.out.println(b + ", " + w);
  }
  static public void main(String args[]) {
    MyBox box = new MyBox();
  }
}
