package com.yumka.leman.test;

import com.yumka.leman.ui.ResourceLoader;

/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class Prueba {
  public Prueba() {
    /*float num = new Float(66.766).floatValue();
    System.out.println(String.copyValueOf(Float.toString(num).toCharArray(), 3,2) +"/100 M.N.");*/
  System.out.println(ResourceLoader.readFile("license-LGPL.txt"));
  }
  public static void main(String[] args) {
    Prueba prueba1 = new Prueba();
  }
//

}
