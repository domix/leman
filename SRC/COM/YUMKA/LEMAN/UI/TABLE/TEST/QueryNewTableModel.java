package com.yumka.leman.ui.table.test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class QueryNewTableModel extends AbstractTableModel {
  Vector cache; // will hold String[] objects . . .
  int colCount;
  String[] headers;
  Statement statement;
  public QueryNewTableModel(ResultSet rs) {
    cache = new Vector();
    // All the real work happens here; in a real application,
    // we'd probably perform the query in a separate thread.
    try {
      // Execute the query and store the result set and its metadata
      ResultSetMetaData meta = rs.getMetaData();
      colCount = meta.getColumnCount();
      // Now we must rebuild the headers array with the new column names
      headers = new String[colCount];
      for (int h = 1; h <= colCount; h++) {
        headers[h - 1] = meta.getColumnName(h);
      }
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
      this.fireTableChanged(null);
      rs.close();
    }
    catch (Exception e) {
      cache = new Vector(); // blank it out and keep going.
      e.printStackTrace();
    }
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
}
