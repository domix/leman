package com.yumka.leman.database;

import java.sql.SQLException;

/**
 * Listener that is notified of RESPONSES table changes.
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public interface ResponseListener {
  /**
   * Invoked just before inserting a ResponsesBean record into the database.
   * @param pObject ResponseBean pObject the ResponsesBean that is about to be inserted
   * @throws SQLException
   */
  public void beforeInsert(ResponseBean pObject) throws SQLException;

  /**
   * Invoked just after a ResponsesBean record is inserted in the database.
   * @param pObject ResponseBean
   * @throws SQLException
   */
  public void afterInsert(ResponseBean pObject) throws SQLException;

  /**
   * Invoked just before updating a ResponsesBean record in the database.
   * @param pObject ResponseBean pObject the ResponsesBean that is about to be updated
   * @throws SQLException
   */
  public void beforeUpdate(ResponseBean pObject) throws SQLException;

  /**
   * Invoked just after updating a ResponsesBean record in the database.
   * @param pObject ResponseBean pObject the ResponsesBean that was just updated
   * @throws SQLException
   */
  public void afterUpdate(ResponseBean pObject) throws SQLException;
}
