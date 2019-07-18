package com.yumka.leman.database;

import java.sql.SQLException;

/**
 * Listener that is notified of ISOPOINTS table changes.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public interface ISOPointListener {
  /**
   * Invoked just before inserting a IsopointsBean record into the database.
   * @param pObject ISOPointBean pObject the IsopointsBean that is about to be inserted
   * @throws SQLException
   */
  public void beforeInsert(ISOPointBean pObject) throws SQLException;

  /**
   * Invoked just after a IsopointsBean record is inserted in the database.
   * @param pObject ISOPointBean pObject the IsopointsBean that was just inserted
   * @throws SQLException
   */
  public void afterInsert(ISOPointBean pObject) throws SQLException;

  /**
   * Invoked just before updating a IsopointsBean record in the database.
   * @param pObject ISOPointBean pObject the IsopointsBean that is about to be updated
   * @throws SQLException
   */
  public void beforeUpdate(ISOPointBean pObject) throws SQLException;

  /**
   * Invoked just after updating a IsopointsBean record in the database.
   * @param pObject ISOPointBean pObject the IsopointsBean that was just updated
   * @throws SQLException
   */
  public void afterUpdate(ISOPointBean pObject) throws SQLException;
}
