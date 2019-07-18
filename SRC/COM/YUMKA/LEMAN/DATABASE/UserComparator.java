package com.yumka.leman.database;

import java.util.Comparator;

/**
 * Comparator class is used to sort the UsersBean objects.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class UserComparator implements Comparator {
  /**
   * Holds the field on which the comparison is performed.
   */
  private int iType;

  /**
   * Value that will contain the information about the order of the sort: normal or reversal.
   */
  private boolean bReverse;

  /**
   * Constructor class for UsersComparator.
   * <br>
   * Example:
   * <br>
   * <code>Arrays.sort(pArray, new UsersComparator(UsersManager.LOGIN, bReverse));<code>
   *
   * @param iType the field from which you want to sort
   * <br>
   * Possible values are:
   * <ul>
   *   <li>UsersManager.ID_LOGIN
   *   <li>UsersManager.ID_NAME
   *   <li>UsersManager.ID_COMPANY
   *   <li>UsersManager.ID_JOBPOSITION
   *   <li>UsersManager.ID_PASSWORD
   * </ul>
   */
  public UserComparator(int iType) {
    this(iType, false);
  }

  /**
   * Constructor class for UsersComparator.
   * <br>
   * Example:
   * <br>
   * <code>Arrays.sort(pArray, new UsersComparator(UsersManager.LOGIN, bReverse));<code>
   *
   * @param iType the field from which you want to sort.
   * <br>
   * Possible values are:
   * <ul>
   *   <li>UsersManager.ID_LOGIN
   *   <li>UsersManager.ID_NAME
   *   <li>UsersManager.ID_COMPANY
   *   <li>UsersManager.ID_JOBPOSITION
   *   <li>UsersManager.ID_PASSWORD
   * </ul>
   *
   * @param bReverse set this value to true, if you want to reverse the sorting results
   */
  public UserComparator(int iType, boolean bReverse) {
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
    UserBean b1 = (UserBean) pObj1;
    UserBean b2 = (UserBean) pObj2;
    int iReturn = 0;
    switch (iType) {
      case UserManager.ID_LOGIN:
        if (b1.getLogin() == null && b2.getLogin() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getLogin() == null && b2.getLogin() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getLogin() != null && b2.getLogin() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getLogin().compareTo(b2.getLogin());
            }
          }
        }
        break;
      case UserManager.ID_NAME:
        if (b1.getName() == null && b2.getName() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getName() == null && b2.getName() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getName() != null && b2.getName() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getName().compareTo(b2.getName());
            }
          }
        }
        break;
      case UserManager.ID_COMPANY:
        if (b1.getCompany() == null && b2.getCompany() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getCompany() == null && b2.getCompany() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getCompany() != null && b2.getCompany() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getCompany().compareTo(b2.getCompany());
            }
          }
        }
        break;
      case UserManager.ID_JOBPOSITION:
        if (b1.getJobposition() == null && b2.getJobposition() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getJobposition() == null && b2.getJobposition() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getJobposition() != null && b2.getJobposition() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getJobposition().compareTo(b2.getJobposition());
            }
          }
        }
        break;
      case UserManager.ID_PASSWORD:
        if (b1.getPassword() == null && b2.getPassword() != null) {
          iReturn = -1;
        }
        else {
          if (b1.getPassword() == null && b2.getPassword() == null) {
            iReturn = 0;
          }
          else {
            if (b1.getPassword() != null && b2.getPassword() == null) {
              iReturn = 1;
            }
            else {
              iReturn = b1.getPassword().compareTo(b2.getPassword());
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
