package com.yumka.leman.database;

import java.util.Comparator;

/**
 * Comparator class is used to sort the IsopointsBean objects.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class ISOPointComparator implements Comparator {
  /**
   * Holds the field on which the comparison is performed.
   */
  private int iType;

  /**
   * Value that will contain the information about the order of the sort: normal or reversal.
   */
  private boolean bReverse;

  /**
   * Constructor class for IsopointsComparator.
   * <br>
   * Example:
   * <br>
   * <code>Arrays.sort(pArray, new IsopointsComparator(IsopointsManager.ID, bReverse));<code>
   *
   * @param iType the field from which you want to sort
   * <br>
   * Possible values are:
   * <ul>
   *   <li>IsopointsManager.ID_ID
   *   <li>IsopointsManager.ID_DESCRIPTION
   *   <li>IsopointsManager.ID_IDISOPOINT
   * </ul>
   */
  public ISOPointComparator(int iType) {
    this(iType, false);
  }

  /**
   * Constructor class for IsopointsComparator.
   * <br>
   * Example:
   * <br>
   * <code>Arrays.sort(pArray, new IsopointsComparator(IsopointsManager.ID, bReverse));<code>
   *
   * @param iType the field from which you want to sort.
   * <br>
   * Possible values are:
   * <ul>
   *   <li>IsopointsManager.ID_ID
   *   <li>IsopointsManager.ID_DESCRIPTION
   *   <li>IsopointsManager.ID_IDISOPOINT
   * </ul>
   *
   * @param bReverse set this value to true, if you want to reverse the sorting results
   */
  public ISOPointComparator(int iType, boolean bReverse) {
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
    ISOPointBean b1 = (ISOPointBean) pObj1;
    ISOPointBean b2 = (ISOPointBean) pObj2;
    int iReturn = 0;
    switch (iType) {
      case ISOPointManager.ID_ID:
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
      case ISOPointManager.ID_DESCRIPTION:
        if (b1.getDescription() == null && b2.getDescription() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getDescription() == null && b2.getDescription() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getDescription() != null && b2.getDescription() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getDescription().compareTo(b2.getDescription());
            }
          }
        }
        break;
      case ISOPointManager.ID_IDISOPOINT:
        if (b1.getIdisopoint() == null && b2.getIdisopoint() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getIdisopoint() == null && b2.getIdisopoint() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getIdisopoint() != null && b2.getIdisopoint() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getIdisopoint().compareTo(b2.getIdisopoint());
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
