package com.yumka.leman;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

import com.yumka.leman.ui.JButtonLeman;
import com.yumka.leman.ui.windows.InternalFrame;
import java.awt.event.*;
import com.yumka.leman.ui.*;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class NavigationPanel extends JPanel {
  GridLayout gridLayout = new GridLayout(15, 1);
  private JButton b01;
  private JButton b02;
  private JButton b03;
  private Frame frame;
  private String introduction = new String("Introducción");
  private String whoApply = new String("¿A quien se aplica?");

  public NavigationPanel(Frame frame) {
    this.frame = frame;
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setMinimumSize(new Dimension(170, 200));
    this.setLayout(gridLayout);
    this.b01 = new JButtonLeman(introduction);
    this.b02 = new JButtonLeman(whoApply);
    b03 = new JButtonLeman("Rogaro, S.A. de C.V.");

    this.add(b01);
    this.add(b02);
    this.add(b03);
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());

    this.b01.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        introduction();
      }
    });
    this.b02.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whoApply();
      }
    });
    this.b03.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        info();
      }
    });

  }
  public void introduction() {
    final InternalFrame iff = new InternalFrame(this.frame.getDesktop(), introduction,
                                          frame, true);
    JEditorPane htmlViewer = null;
    try {
      htmlViewer = new JEditorPane("text/html", "");
      htmlViewer.setEditable(false);
      htmlViewer.setFocusable(false);
      StringBuffer html = new StringBuffer();

      html.append("<html>");
      html.append("<body>");
      html.append("<h1 align=\"center\">Introducci&oacute;n</h1>");
      html.append("<p>Hoy en d&iacute;a, las empresas buscan la forma de estar a la vanguardia apoy&aacute;ndose ");
      html.append("en todos los casos de la automatizaci&oacute;n para facilitar el desempe&ntilde;o");
      html.append("de todos los procesos que implica una organizaci&oacute;n, mostr&aacute;ndose");
      html.append("ante el mercado como un competidor fuerte, adem&aacute;s de lograr eficiencia");
      html.append("oportuna que beneficiar&aacute; al logro general que la empresa busca.</p>");
      html.append("<p>Leman, pretende automatizar uno de los procesos m&aacute;s importantes para");
      html.append("cualquier empresa, la evaluaci&oacute;n a travez de la norma ISO 9001:2002</p>");
      html.append("</body>");
      html.append("</html>");
      htmlViewer.setText(html.toString());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    Container cp = iff.getContentPane();
    cp.setLayout(new BorderLayout());
    JButton cerrar = new JButton("Cerrar");
    cerrar.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
               iff.dispose();
             }
           });
    cp.add(htmlViewer, BorderLayout.CENTER);
    cp.add(cerrar, BorderLayout.SOUTH);

  }
  public void whoApply() {
    final InternalFrame iff = new InternalFrame(this.frame.getDesktop(), introduction,
                                          frame, true);
    JEditorPane htmlViewer = null;
    try {
      htmlViewer = new JEditorPane("text/html", "");
      htmlViewer.setEditable(false);
      htmlViewer.setFocusable(false);
      StringBuffer html = new StringBuffer();

      html.append("<html>");
      html.append("<body>");
      html.append("<h1 align=\"center\">&iquest;A qui&eacute;n se aplica?</h1>");
      html.append("<p>Sabemos que la Calidad se da como resultado de una variedad de procesos involucrados");
      html.append("entre si que intervienen para brindar un bien y/o servicio. Siempre y cuando");
      html.append("satisfagan las expectativas del mercado al que va dirigido, por lo anterior");
      html.append("tenemos que se deben cumplir con ciertos est&aacute;ndares establecidos para");
      html.append("lograr el cumplimiento de la Calidad.</p>");
      html.append("<p>Este trabajo engloba el esfuerzo por encontrar nuevas formas de control sobre");
      html.append("los procesos.</p>");
      html.append("</body>");
      html.append("</html>");
      htmlViewer.setText(html.toString());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    Container cp = iff.getContentPane();
    cp.setLayout(new BorderLayout());
    JButton cerrar = new JButton("Cerrar");
    cerrar.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
               iff.dispose();
             }
           });
    cp.add(htmlViewer, BorderLayout.CENTER);
    cp.add(cerrar, BorderLayout.SOUTH);

  }

  public void info() {
    new Rogaro(this.frame.getDesktop(), frame, true);


  }

}
