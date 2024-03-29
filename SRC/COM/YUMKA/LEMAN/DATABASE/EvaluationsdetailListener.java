// --------------------------------------------------------
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: org.hsqldb.jdbcDriver
//
// Please help us improve this tool by reporting:
//    problems,
//    suggestions,
//    feedbacks,
//    ideas,
//  to http://sourceforge.net/projects/sql2java/
// --------------------------------------------------------

package com.yumka.leman.database;

import java.sql.SQLException;

// imports+

// imports-


/**
 * Listener that is notified of EVALUATIONSDETAIL table changes.
 */
public interface EvaluationsdetailListener
// extends+

// extends-
{
  /**
   * Invoked just before inserting a EvaluationsdetailBean record into the database.
   *
   * @param pObject the EvaluationsdetailBean that is about to be inserted
   */
  public void beforeInsert(EvaluationsdetailBean pObject) throws SQLException;

  /**
   * Invoked just after a EvaluationsdetailBean record is inserted in the database.
   *
   * @param pObject the EvaluationsdetailBean that was just inserted
   */
  public void afterInsert(EvaluationsdetailBean pObject) throws SQLException;

  /**
   * Invoked just before updating a EvaluationsdetailBean record in the database.
   *
   * @param pObject the EvaluationsdetailBean that is about to be updated
   */
  public void beforeUpdate(EvaluationsdetailBean pObject) throws SQLException;

  /**
   * Invoked just after updating a EvaluationsdetailBean record in the database.
   *
   * @param pObject the EvaluationsdetailBean that was just updated
   */
  public void afterUpdate(EvaluationsdetailBean pObject) throws SQLException;

// class+

// class-
}
