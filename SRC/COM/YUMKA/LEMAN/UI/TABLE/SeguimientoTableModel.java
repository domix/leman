package com.yumka.leman.ui.table;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.*;

import com.yumka.leman.database.*;
import com.yumka.leman.*;
import java.sql.*;


public class SeguimientoTableModel implements TableModel {
  ObservationsBean[] results;
  String[][] data;
  int numcols, numrows; // How many rows and columns in the table

  public SeguimientoTableModel(EvaluationsBean evaluation) {
    EvaluationsdetailBean[] detalles;
    ObservationsBean[] obs;

    try {
      detalles = EvaluationsdetailManager.getInstance().loadByIdevaluation(evaluation.getId());
      String[][] temp;
      data = new String[9][detalles.length];
      temp = new String[9][detalles.length];
      int row = 0;
      for (int i = 0; i < detalles.length; i++) {
        try {
          obs = ObservationsManager.getInstance().loadByIdevaluationdetail(detalles[i].getId());
          if(obs.length > 0) {
            temp[0][i] = obs[0].getId().toString();
            temp[1][i] = detalles[i].getId().toString();
            temp[2][i] = detalles[i].getIdquestion().substring(0, detalles[i].getIdquestion().lastIndexOf("."));  //"Punto ISO";
            QuestionsBean pregunta = QuestionsManager.getInstance().loadByPrimaryKey(detalles[i].getIdquestion());
            temp[3][i] = pregunta.getQuestion();
            temp[4][i] = (ResponseManager.getInstance().loadByPrimaryKey(detalles[i].getIdresponse())).getMessage();
            temp[5][i] = obs[0].getMessage();
            temp[6][i] = obs[0].getResponsable();
            temp[7][i] = obs[0].getAccion();
            temp[8][i] = obs[0].getPlazo();
            row++;
            }
        }
        catch (Exception ex) {
          ex.printStackTrace();
        }
      }
      data = new String[9][row];
      row = 0;
      for (int i = 0; i < temp[0].length; i++) {
        if((temp[0][i] != null) && (!temp[0][i].equals(""))) {
          for (int j = 0; j < 9; j++) {
            data[j][row] = temp[j][i];
          }
          row++;
        }
      }

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * These two TableModel methods return the size of the table
   * @return int
   */
  public int getColumnCount() {
    return 9;
  }

  /**
   *
   * @return int
   */
  public int getRowCount() {
    return data[0].length;
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
        result = "id";
        break;
      case 1:
        result = "idEvaDetalle";
        break;
      case 2:
        result = "Punto ISO";
        break;
      case 3:
        result = "Pregunta";
        break;
      case 4:
        result = "Respuesta";
        break;
      case 5:
        result = "Comentario";
        break;
      case 6:
        result = "Responsable";
        break;
      case 7:
        result = "Accion a Realizar";
        break;
      case 8:
        result = "Plazo";
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
    /*switch (column) {
      case 0:
        result = (String) ( ( (QuestionsBean) results[row]).getId());
        break;
      case 1:
        result = (String) ( ( (QuestionsBean) results[row]).getTopic());
        break;
      case 2:
        result = (String) ( ( (QuestionsBean) results[row]).getQuestion());
        break;
      default:
        result = "_________";
        break;
    }*/
    result = this.data[column][row];
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
