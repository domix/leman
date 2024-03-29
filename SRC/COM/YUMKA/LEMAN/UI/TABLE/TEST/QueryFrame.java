package com.yumka.leman.ui.table.test;

import java.sql.SQLException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.yumka.leman.ui.table.ResultSetTableModelFactory;

/**
 *
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * This class creates a Swing GUI that allows the user to enter a SQL query.
 * It then obtains a ResultSetTableModel for the query and uses it to display
 * the results of the query in a scrolling JTable component.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class QueryFrame extends JFrame {
  ResultSetTableModelFactory factory; // A factory to obtain our table data
  JTextField query; // A field to enter a query in
  JTable table; // The table for displaying data
  JLabel msgline; // For displaying messages
  /**
   * This constructor method creates a simple GUI and hooks up an event
   * listener that updates the table when the user enters a new query.
   * @param f ResultSetTableModelFactory
   */public QueryFrame(ResultSetTableModelFactory f) {
    super("QueryFrame"); // Set window title

    // Arrange to quit the program when the user closes the window
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);
      }
    });

    // Remember the factory object that was passed to us
    this.factory = f;

    // Create the Swing components we'll be using
    query = new JTextField(); // Lets the user enter a query
    table = new JTable(); // Displays the table
    msgline = new JLabel(); // Displays messages

    // Place the components within this window
    Container contentPane = getContentPane();
    contentPane.add(query, BorderLayout.NORTH);
    contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
    contentPane.add(msgline, BorderLayout.SOUTH);

    // Now hook up the JTextField so that when the user types a query
    // and hits ENTER, the query results get displayed in the JTable
    query.addActionListener(new ActionListener() {
      // This method is invoked when the user hits ENTER in the field
      public void actionPerformed(ActionEvent e) {
        // Get the user's query and pass to displayQueryResults()
        displayQueryResults(query.getText());
      }
    });
  }

  /**
   * This method uses the supplied SQL query string, and the
   * ResultSetTableModelFactory object to create a TableModel that holds
   * the results of the database query.  It passes that TableModel to the
   * JTable component for display.
   * @param q String
   */
  public void displayQueryResults(final String q) {
    // It may take a while to get the results, so give the user some
    // immediate feedback that their query was accepted.
    msgline.setText("Contacting database...");

    // In order to allow the feedback message to be displayed, we don't
    // run the query directly, but instead place it on the event queue
    // to be run after all pending events and redisplays are done.
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          // This is the crux of it all.  Use the factory object
          // to obtain a TableModel object for the query results
          // and display that model in the JTable component.
          table.setModel(factory.getResultSetTableModel(q));
          // We're done, so clear the feedback message
          msgline.setText(" ");
        }
        catch (SQLException ex) {
          // If something goes wrong, clear the message line
          msgline.setText(" ");
          // Then display the error in a dialog box
          JOptionPane.showMessageDialog(QueryFrame.this,  // Display a 2-line message
                                        new String[] {ex.getClass().getName() +
                                        ": ", ex.getMessage()
          });
        }
      }
    });
  }

  /**
   * This simple main method tests the class.  It expects four command-line
   * arguments: the driver classname, the database URL, the username, and
   * the password
   * @param args String[]
   * @throws Exception
   */
  public static void main(String args[]) throws Exception {
    // Create the factory object that holds the database connection using
    // the data specified on the command line
    ResultSetTableModelFactory factory = new ResultSetTableModelFactory(
        "org.hsqldb.jdbcDriver", "jdbc:hsqldb:/sgc/database/leman", "sa", "");

    // Create a QueryFrame component that uses the factory object.
    QueryFrame qf = new QueryFrame(factory);

    // Set the size of the QueryFrame, then pop it up
    qf.setSize(500, 600);
    qf.setVisible(true);
  }
}
