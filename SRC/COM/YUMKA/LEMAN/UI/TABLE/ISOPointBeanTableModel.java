package com.yumka.leman.ui.table;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.yumka.leman.database.ISOPointBean;

public class ISOPointBeanTableModel implements TableModel {
  ISOPointBean[] results;
  int numcols, numrows; // How many rows and columns in the table

  public ISOPointBeanTableModel(ISOPointBean[] points) {
    this.results = points;
    numcols = 2; // How many columns?
    numrows = points.length; // How many rows?
  }

  /**
   * These two TableModel methods return the size of the table
   * @return int
   */
  public int getColumnCount() {
    return numcols;
  }

  /**
   *
   * @return int
   */
  public int getRowCount() {
    return numrows;
  }

  /**
   * This TableModel method returns columns names
   * @param column int
   * @return String
   */
  public String getColumnName(int column) {
    String result = "";
    switch (column) {
      case 0:
        result = "Punto";
        break;
      case 1:
        result = "Descripción";
        break;
      case 2:
        result = "Pertenece";
        break;
      default:
        result = "";
        break;
    }
    return result;
  }

  /**
   * This TableModel method specifies the data type for each column.
   * We could map SQL types to Java types, but for this example, we'll just
   * convert all the returned data to strings.
   * @param column int
   * @return Class
   */
  public Class getColumnClass(int column) {
    return String.class;
  }

  /**
   * This is the key method of TableModel: it returns the value at each cell
   * of the table.  We use strings in this case.  If anything goes wrong, we
   * return the exception as a string, so it will be displayed in the table.
   * Note that SQL row and column numbers start at 1, but TableModel column
   * numbers start at 0.
   * @param row int
   * @param column int
   * @return Object
   */
  public Object getValueAt(int row, int column) {
    String result = "";
    switch (column) {
      case 0:
        result = (String) ( ( (ISOPointBean) results[row]).getId());
        break;
      case 1:
        result = (String) ( ( (ISOPointBean) results[row]).getDescription());
        break;
      case 2:
        result = (String) ( ( (ISOPointBean) results[row]).getIdisopoint());
        break;
      default:
        result = "_________";
        break;
    }
    return result;
  }

  /**
   * Our table isn't editable
   * @param row int
   * @param column int
   * @return boolean
   */
  public boolean isCellEditable(int row, int column) {
    return false;
  }

  /**
   * Since its not editable, we don't need to implement these methods
   * @param value Object
   * @param row int
   * @param column int
   */
  public void setValueAt(Object value, int row, int column) {}

  /**
   * Since its not editable, we don't need to implement these methods
   * @param l TableModelListener
   */
  public void addTableModelListener(TableModelListener l) {}

  /**
   * Since its not editable, we don't need to implement these methods
   * @param l TableModelListener
   */
  public void removeTableModelListener(TableModelListener l) {}
}
