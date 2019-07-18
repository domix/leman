package com.yumka.leman.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.yumka.leman.Frame;
import java.awt.event.*;

/**
 *
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class MenuLeman extends JMenuBar {
  Frame frame;
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenuItem jMenuFileNewEvaluation = new JMenuItem();
  JMenuItem jMenuFileOpenEvaluation = new JMenuItem();
  JMenuItem jMenuFileOptions = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();
  JMenu jMenuCatalogs = new JMenu();
  JMenuItem jMenuCatalogsISOPoints = new JMenuItem();
  JMenuItem jMenuCatalogsQuestions = new JMenuItem();
  JMenuItem jMenuCatalogsResponses = new JMenuItem();
  JMenuItem jMenuCatalogsUsers = new JMenuItem();
  JMenuItem jMenuCatalogsOrganizations = new JMenuItem();

  public MenuLeman(Frame frame) {
    this.frame = frame;
    this.buildMenu();
  }
  private void buildMenu() {
    jMenuFile.setText("Archivo");
    jMenuFileNewEvaluation.setText("Realizar evaluación");
    jMenuFileNewEvaluation.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                               frame.jMenuFileNewEvaluation_actionPerformed(e);
                             }
                           });
    jMenuFileOpenEvaluation.setText("Abrir evaluación");
    jMenuFileOpenEvaluation.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.jMenuFileOpenEvaluation_actionPerformed(e);
      }
    });

    this.jMenuFileOptions.setText("Opciones");
    jMenuFileExit.setText("Salir");
    jMenuFileExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.jMenuFileExit_actionPerformed(e);
      }
    });
    jMenuCatalogs.setText("Catálogos");
    jMenuCatalogsISOPoints.setText("Puntos ISO");
    jMenuCatalogsISOPoints.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          frame.jMenuCatalogISOPoints_actionPerformed(e);
        }
        catch (Exception ex) {
          ex.printStackTrace();
        }

      }
    });
    jMenuCatalogsQuestions.setText("Preguntas");
    jMenuCatalogsQuestions.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          frame.jMenuCatalogQuestions_actionPerformed(e);
        }
        catch (Exception ex) {
          ex.printStackTrace();
        }

      }
    });
    jMenuCatalogsResponses.setText("Respuestas");
    jMenuCatalogsUsers.setText("Usuarios");

    jMenuCatalogsUsers.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          frame.jMenuCatalogsUsers_actionPerformed(e);
        }
        catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    jMenuCatalogsOrganizations.setText("Organizaciones");
    jMenuCatalogsOrganizations.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          frame.jMenuCatalogOrganizations_actionPerformed(e);
        }
        catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });

    jMenuHelp.setText("Ayuda");
    jMenuHelpAbout.setText("Acerca de...");
    jMenuHelpAbout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.jMenuHelpAbout_actionPerformed(e);
      }
    });
    //jMenuFile.add(jMenuFileOptions);
    jMenuFile.add(jMenuFileNewEvaluation);
    jMenuFile.add(jMenuFileOpenEvaluation);
    jMenuFile.addSeparator();
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuCatalogs.add(jMenuCatalogsUsers);
    jMenuCatalogs.addSeparator();
    jMenuCatalogs.add(jMenuCatalogsOrganizations);
    jMenuCatalogs.addSeparator();
    jMenuCatalogs.add(jMenuCatalogsISOPoints);
    jMenuCatalogs.add(jMenuCatalogsQuestions);
    jMenuCatalogs.add(jMenuCatalogsResponses);
    this.add(jMenuFile);
    this.add(jMenuCatalogs);
    this.add(jMenuHelp);
  }
}
