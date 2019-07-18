package com.yumka.leman.ui.table.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

//import jp.gr.java_conf.tame.swing.table.*;


/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class PushableHeaderExample extends JPanel {

  public PushableHeaderExample() {
    setLayout(new BorderLayout());
    String[] headerStr = {"Push", "me", "here"};

    DefaultTableModel dm = new DefaultTableModel(headerStr, 4);
    JTable table = new JTable(dm);
    ButtonHeaderRenderer renderer = new ButtonHeaderRenderer();
    TableColumnModel model = table.getColumnModel();
    int n = headerStr.length;
    for (int i = 0; i < n; i++) {
      model.getColumn(i).setHeaderRenderer(renderer);
    }

    JTableHeader header = table.getTableHeader();
    header.addMouseListener(new HeaderListener(header, renderer));
    JScrollPane pane = new JScrollPane(table);
    add(pane, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    JFrame f = new JFrame("PushableHeaderTable Example");
    f.getContentPane().add(new PushableHeaderExample(), BorderLayout.CENTER);
    f.setSize(400, 100);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);
      }
    });
  }

  class HeaderListener extends MouseAdapter {
    JTableHeader header;
    ButtonHeaderRenderer renderer;

    HeaderListener(JTableHeader header, ButtonHeaderRenderer renderer) {
      this.header = header;
      this.renderer = renderer;
    }

    public void mousePressed(MouseEvent e) {
      int col = header.columnAtPoint(e.getPoint());
      renderer.setPressedColumn(col);
      header.repaint();

      System.out.println("Ouch! " + col);
    }

    public void mouseReleased(MouseEvent e) {
      int col = header.columnAtPoint(e.getPoint());
      renderer.setPressedColumn( -1); // clear
      header.repaint();
    }
  }

  class ButtonHeaderRenderer extends JButton implements TableCellRenderer {
    int pushedColumn;

    public ButtonHeaderRenderer() {
      pushedColumn = -1;
      setMargin(new Insets(0, 0, 0, 0));
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      setText( (value == null) ? "" : value.toString());
      boolean isPressed = (column == pushedColumn);
      getModel().setPressed(isPressed);
      getModel().setArmed(isPressed);
      return this;
    }

    public void setPressedColumn(int col) {
      pushedColumn = col;
    }
  }
}
