package com.yumka.leman.database;

import java.util.Comparator;

/**
 * Comparator class is used to sort the ResponsesBean objects.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class ResponseComparator implements Comparator {
  /**
   * Holds the field on which the comparison is performed.
   */
  private int iType;

  /**
   * Value that will contain the information about the order of the sort: normal or reversal.
   */
  private boolean bReverse;

  /**
   * Constructor class for ResponsesComparator.
   * <br>
   * Example:
   * <br>
   * <code>Arrays.sort(pArray, new ResponsesComparator(ResponsesManager.ID, bReverse));<code>
   *
   * @param iType the field from which you want to sort
   * <br>
   * Possible values are:
   * <ul>
   *   <li>ResponsesManager.ID_ID
   *   <li>ResponsesManager.ID_MESSAGE
   * </ul>
   */
  public ResponseComparator(int iType) {
    this(iType, false);
  }

  /**
   * Constructor class for ResponsesComparator.
   * <br>
   * Example:
   * <br>
   * <code>Arrays.sort(pArray, new ResponsesComparator(ResponsesManager.ID, bReverse));<code>
   *
   * @param iType the field from which you want to sort.
   * <br>
   * Possible values are:
   * <ul>
   *   <li>ResponsesManager.ID_ID
   *   <li>ResponsesManager.ID_MESSAGE
   * </ul>
   *
   * @param bReverse set this value to true, if you want to reverse the sorting results
   */
  public ResponseComparator(int iType, boolean bReverse) {
    this.iType = iType;
    this.bReverse = bReverse;
  }

  /**
   * Implementation of the compare method.
   * @param pObj1 Object
   * @param pObj2 Object
   * @return int
   */
  public int compare(Object pObj1, Object pObj2) {
    ResponseBean b1 = (ResponseBean) pObj1;
    ResponseBean b2 = (ResponseBean) pObj2;
    int iReturn = 0;
    switch (iType) {
      case ResponseManager.ID_ID:
        if (b1.getId() == null && b2.getId() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getId() == null && b2.getId() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getId() != null && b2.getId() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getId().compareTo(b2.getId());
            }
          }
        }
        break;
      case ResponseManager.ID_MESSAGE:
        if (b1.getMessage() == null && b2.getMessage() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getMessage() == null && b2.getMessage() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getMessage() != null && b2.getMessage() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getMessage().compareTo(b2.getMessage());
            }
          }
        }
        break;
      default:
        throw new IllegalArgumentException(
            "Type passed for the field is not supported");
    }

    return bReverse ? ( -1 * iReturn) : iReturn;
  }
}
