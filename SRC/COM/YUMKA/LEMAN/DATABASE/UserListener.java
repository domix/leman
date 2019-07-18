package com.yumka.leman.database;

import java.sql.SQLException;

/**
 * Listener that is notified of USERS table changes.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public interface UserListener {
  /**
   * Invoked just before inserting a UsersBean record into the database.
   * @param pObject UsersBean pObject the UsersBean that is about to be inserted
   * @throws SQLException
   */
  public void beforeInsert(UserBean pObject) throws SQLException;

  /**
   * Invoked just after a UsersBean record is inserted in the database.
   * @param pObject UsersBean pObject the UsersBean that was just inserted
   * @throws SQLException
   */
  public void afterInsert(UserBean pObject) throws SQLException;

  /**
   * Invoked just before updating a UsersBean record in the database.
   * @param pObject UsersBean pObject the UsersBean that is about to be updated
   * @throws SQLException
   */
  public void beforeUpdate(UserBean pObject) throws SQLException;

  /**
   * Invoked just after updating a UsersBean record in the database.
   * @param pObject UsersBean pObject the UsersBean that was just updated
   * @throws SQLException
   */
  public void afterUpdate(UserBean pObject) throws SQLException;
}
