package com.yumka.leman.ui;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class ResourceLoader {
  /**
   * Get a URL for the given image file name.
   * @param image String
   * @return URL
   */
  public static URL getURLImage(String image) {
    return ResourceLoader.class.getResource("images/" + image);
  }

  /**
   * Gets a ImageIcon for the given image file name.
   * @param image String
   * @return ImageIcon
   */
  public static ImageIcon getImageIcon(String image) {
    return new ImageIcon(ResourceLoader.getURLImage(image));
  }

  /**
   * Gets a Image for the given image file name.
   * @param image String
   * @return Image
   */
  public static Image getImage(String image) {
    return ResourceLoader.getImageIcon(image).getImage();
  }

  /**
   * Get a URL for the given data file name.
   * @param data String
   * @return URL
   */
  public static URL getURLData(String data) {
    return ResourceLoader.class.getResource("data/" + data);
  }
  public static String getData(String data) {
    return ResourceLoader.getURLData(data).toString();
  }

  public static String getTextFile(String file) {
    String result = "";
    BufferedReader input = null;
    try {
      input = new BufferedReader(new FileReader("H:/proyectos/Octavo/CNDS/SistemaGestionCalidad/Software/Leman/src/com/yumka/leman/ui/data/" +
                                                file));
      String s, s2 = "";
      while ( (s = input.readLine()) != null) {
        result += s + "\n";
      }
      input.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }
  public static String readFile(String name) {
    String str = new String();
    String s = new String();
    String h;
    try {
      h = ResourceLoader.getData(name);
      FileInputStream fstream = new FileInputStream(h);
      DataInputStream in = new DataInputStream(fstream);

      while ( (s = in.readLine()) != null) {
        str += s + "\n";
      }

      in.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return str;
  }

}
