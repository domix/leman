package com.yumka.leman.ui.table.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class QueryTableModel extends AbstractTableModel {
  Vector cache; // will hold String[] objects . . .
  int colCount;
  String[] headers;
  Connection db;
  Statement statement;
  public QueryTableModel(Connection conn, String query) {
    cache = new Vector();
    db = conn;
    try {
      statement = db.createStatement();
    }
    catch (SQLException e) {
    }
    this.setQuery(query);
  }
  public String getColumnName(int i) {
    return headers[i];
  }
  public int getColumnCount() {
    return headers.length;
  }
  public int getRowCount() {
    return cache.size();
  }
  public Object getValueAt(int row, int col) {
    return ( (String[]) cache.elementAt(row))[col];
  }

  // All the real work happens here; in a real application,
  // we'd probably perform the query in a separate thread.
  public void setQuery(String q) {
    cache = new Vector();
    try {
      // Execute the query and store the result set and its metadata
      ResultSet rs = statement.executeQuery(q);
      ResultSetMetaData meta = rs.getMetaData();
      colCount = meta.getColumnCount();
      // Now we must rebuild the headers array with the new column names
      headers = new String[colCount];
      for (int h = 1; h <= colCount; h++) {
        headers[h - 1] = meta.getColumnName(h);
      }
      /*for (int i = 0; i < headers.length; i++) {
          System.out.println(headers[i]);
             }*/
      // and file the cache with the records from our query. This would not be
      // practical if we were expecting a few million records in response to our
      // query, but we aren't, so we can do this.
      while (rs.next()) {
        String[] record = new String[colCount];
        for (int i = 0; i < colCount; i++) {
          record[i] = rs.getString(i + 1);
        }
        cache.addElement(record);
      }
      //this.fireTableDataChanged();
      this.fireTableChanged(null);
      rs.close();
      this.closeDB();
    }
    catch (Exception e) {
      cache = new Vector(); // blank it out and keep going.
      e.printStackTrace();
    }
  }
  public void closeDB() {
    try {
      if (statement != null) {
        statement.close();
      }
      if (db != null) {
        db.close();
      }
    }
    catch (Exception e) {
      System.out.println("Could not close the current connection.");
      e.printStackTrace();
    }
  }
}
