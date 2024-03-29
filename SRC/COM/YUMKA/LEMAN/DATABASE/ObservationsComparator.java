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

import java.util.*;
// imports+ 

// imports- 

/**
 * Comparator class is used to sort the ObservationsBean objects.
 */
public class ObservationsComparator implements Comparator
// extends+ 

// extends- 
{
    /**
     * Holds the field on which the comparison is performed.
     */
    private int iType;
    /**
     * Value that will contain the information about the order of the sort: normal or reversal.
     */
    private boolean bReverse;

    /**
     * Constructor class for ObservationsComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new ObservationsComparator(ObservationsManager.ID, bReverse));<code>
     *
     * @param iType the field from which you want to sort
     * <br>
     * Possible values are:
     * <ul>
     *   <li>ObservationsManager.ID_ID
     *   <li>ObservationsManager.ID_IDEVALUATIONDETAIL
     *   <li>ObservationsManager.ID_MESSAGE
     *   <li>ObservationsManager.ID_RESPONSABLE
     *   <li>ObservationsManager.ID_ACCION
     *   <li>ObservationsManager.ID_PLAZO
     * </ul>
     */
    public ObservationsComparator(int iType)
    {
        this(iType, false);
    }

    /**
     * Constructor class for ObservationsComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new ObservationsComparator(ObservationsManager.ID, bReverse));<code>
     *
     * @param iType the field from which you want to sort.
     * <br>
     * Possible values are:
     * <ul>
     *   <li>ObservationsManager.ID_ID
     *   <li>ObservationsManager.ID_IDEVALUATIONDETAIL
     *   <li>ObservationsManager.ID_MESSAGE
     *   <li>ObservationsManager.ID_RESPONSABLE
     *   <li>ObservationsManager.ID_ACCION
     *   <li>ObservationsManager.ID_PLAZO
     * </ul>
     *
     * @param bReverse set this value to true, if you want to reverse the sorting results
     */
    public ObservationsComparator(int iType, boolean bReverse)
    {
        this.iType = iType;
        this.bReverse = bReverse;
    }

    /**
     * Implementation of the compare method.
     */
    public int compare(Object pObj1, Object pObj2)
    {
        ObservationsBean b1 = (ObservationsBean)pObj1;
        ObservationsBean b2 = (ObservationsBean)pObj2;
        int iReturn = 0;
        switch(iType)
        {
            case ObservationsManager.ID_ID:
                if (b1.getId() == null && b2.getId() != null) {
                    iReturn = -1;
                } else if (b1.getId() == null && b2.getId() == null) {
                    iReturn = 0;
                } else if (b1.getId() != null && b2.getId() == null) {
                    iReturn = 1;
                } else { 
                    iReturn = b1.getId().compareTo(b2.getId());
                }
                break;
            case ObservationsManager.ID_IDEVALUATIONDETAIL:
                if (b1.getIdevaluationdetail() == null && b2.getIdevaluationdetail() != null) {
                    iReturn = -1;
                } else if (b1.getIdevaluationdetail() == null && b2.getIdevaluationdetail() == null) {
                    iReturn = 0;
                } else if (b1.getIdevaluationdetail() != null && b2.getIdevaluationdetail() == null) {
                    iReturn = 1;
                } else { 
                    iReturn = b1.getIdevaluationdetail().compareTo(b2.getIdevaluationdetail());
                }
                break;
            case ObservationsManager.ID_MESSAGE:
                if (b1.getMessage() == null && b2.getMessage() != null) {
                    iReturn = -1;
                } else if (b1.getMessage() == null && b2.getMessage() == null) {
                    iReturn = 0;
                } else if (b1.getMessage() != null && b2.getMessage() == null) {
                    iReturn = 1;
                } else { 
                    iReturn = b1.getMessage().compareTo(b2.getMessage());
                }
                break;
            case ObservationsManager.ID_RESPONSABLE:
                if (b1.getResponsable() == null && b2.getResponsable() != null) {
                    iReturn = -1;
                } else if (b1.getResponsable() == null && b2.getResponsable() == null) {
                    iReturn = 0;
                } else if (b1.getResponsable() != null && b2.getResponsable() == null) {
                    iReturn = 1;
                } else { 
                    iReturn = b1.getResponsable().compareTo(b2.getResponsable());
                }
                break;
            case ObservationsManager.ID_ACCION:
                if (b1.getAccion() == null && b2.getAccion() != null) {
                    iReturn = -1;
                } else if (b1.getAccion() == null && b2.getAccion() == null) {
                    iReturn = 0;
                } else if (b1.getAccion() != null && b2.getAccion() == null) {
                    iReturn = 1;
                } else { 
                    iReturn = b1.getAccion().compareTo(b2.getAccion());
                }
                break;
            case ObservationsManager.ID_PLAZO:
                if (b1.getPlazo() == null && b2.getPlazo() != null) {
                    iReturn = -1;
                } else if (b1.getPlazo() == null && b2.getPlazo() == null) {
                    iReturn = 0;
                } else if (b1.getPlazo() != null && b2.getPlazo() == null) {
                    iReturn = 1;
                } else { 
                    iReturn = b1.getPlazo().compareTo(b2.getPlazo());
                }
                break;
            default: 
                throw new IllegalArgumentException("Type passed for the field is not supported");
        }

        return bReverse ? (-1 * iReturn) : iReturn;
    }
// class+ 

// class- 
}
