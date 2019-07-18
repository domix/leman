package com.yumka.leman.database;

// imports+

// imports-

public class EvaluationsdetailBean
// extends+

// extends-
{
  private Integer id;
  private boolean id_is_modified = false;
  private boolean id_is_initialized = false;

  private Integer idevaluation;
  private boolean idevaluation_is_modified = false;
  private boolean idevaluation_is_initialized = false;

  private String idquestion;
  private boolean idquestion_is_modified = false;
  private boolean idquestion_is_initialized = false;

  private Integer idresponse;
  private boolean idresponse_is_modified = false;
  private boolean idresponse_is_initialized = false;

  private boolean _isNew = true;

  /**
   * Do not use this constructor directly, please use the factory method
   * available in the associated manager.
   */
  EvaluationsdetailBean() {
  }

  /**
   * Getter method for id.
   * <br>
   * PRIMARY KEY.<br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONSDETAIL.ID
   * <li>comments: IDENTITY
   * <li>column size: 0
   * <li>jdbc type returned by the driver: Types.INTEGER
   * </ul>
   *
   * @return the value of id
   */ public Integer getId() {
    return id;
  }

  /**
   * Setter method for id.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to id
   */
  public void setId(Integer newVal) {
    if ( (newVal != null && this.id != null && (newVal.compareTo(this.id) == 0)) ||
        (newVal == null && this.id == null && id_is_initialized)) {
      return;
    }
    this.id = newVal;
    id_is_modified = true;
    id_is_initialized = true;
  }

  /**
   * Setter method for id.
   * <br>
   * Convenient for those who do not want to deal with Objects for primary types.
   *
   * @param newVal the new value to be assigned to id
   */
  public void setId(int newVal) {
    setId(new Integer(newVal));
  }

  /**
   * Determines if the id has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIdModified() {
    return id_is_modified;
  }

  /**
   * Determines if the id has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIdInitialized() {
    return id_is_initialized;
  }

  /**
   * Getter method for idevaluation.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONSDETAIL.IDEVALUATION
   * <li> foreign key: EVALUATIONS.ID
   * <li>column size: 0
   * <li>jdbc type returned by the driver: Types.INTEGER
   * </ul>
   *
   * @return the value of idevaluation
   */
  public Integer getIdevaluation() {
    return idevaluation;
  }

  /**
   * Setter method for idevaluation.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to idevaluation
   */
  public void setIdevaluation(Integer newVal) {
    if ( (newVal != null && this.idevaluation != null &&
          (newVal.compareTo(this.idevaluation) == 0)) ||
        (newVal == null && this.idevaluation == null &&
         idevaluation_is_initialized)) {
      return;
    }
    this.idevaluation = newVal;
    idevaluation_is_modified = true;
    idevaluation_is_initialized = true;
  }

  /**
   * Setter method for idevaluation.
   * <br>
   * Convenient for those who do not want to deal with Objects for primary types.
   *
   * @param newVal the new value to be assigned to idevaluation
   */
  public void setIdevaluation(int newVal) {
    setIdevaluation(new Integer(newVal));
  }

  /**
   * Determines if the idevaluation has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIdevaluationModified() {
    return idevaluation_is_modified;
  }

  /**
   * Determines if the idevaluation has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIdevaluationInitialized() {
    return idevaluation_is_initialized;
  }

  /**
   * Getter method for idquestion.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONSDETAIL.IDQUESTION
   * <li> foreign key: QUESTIONS.ID
   * <li>column size: 10
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of idquestion
   */
  public String getIdquestion() {
    return idquestion;
  }

  /**
   * Setter method for idquestion.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to idquestion
   */
  public void setIdquestion(String newVal) {
    if ( (newVal != null && this.idquestion != null &&
          (newVal.compareTo(this.idquestion) == 0)) ||
        (newVal == null && this.idquestion == null && idquestion_is_initialized)) {
      return;
    }
    this.idquestion = newVal;
    idquestion_is_modified = true;
    idquestion_is_initialized = true;
  }

  /**
   * Determines if the idquestion has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIdquestionModified() {
    return idquestion_is_modified;
  }

  /**
   * Determines if the idquestion has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIdquestionInitialized() {
    return idquestion_is_initialized;
  }

  /**
   * Getter method for idresponse.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONSDETAIL.IDRESPONSE
   * <li> foreign key: RESPONSES.ID
   * <li>column size: 0
   * <li>jdbc type returned by the driver: Types.INTEGER
   * </ul>
   *
   * @return the value of idresponse
   */
  public Integer getIdresponse() {
    return idresponse;
  }

  /**
   * Setter method for idresponse.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to idresponse
   */
  public void setIdresponse(Integer newVal) {
    if ( (newVal != null && this.idresponse != null &&
          (newVal.compareTo(this.idresponse) == 0)) ||
        (newVal == null && this.idresponse == null && idresponse_is_initialized)) {
      return;
    }
    this.idresponse = newVal;
    idresponse_is_modified = true;
    idresponse_is_initialized = true;
  }

  /**
   * Setter method for idresponse.
   * <br>
   * Convenient for those who do not want to deal with Objects for primary types.
   *
   * @param newVal the new value to be assigned to idresponse
   */
  public void setIdresponse(int newVal) {
    setIdresponse(new Integer(newVal));
  }

  /**
   * Determines if the idresponse has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIdresponseModified() {
    return idresponse_is_modified;
  }

  /**
   * Determines if the idresponse has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIdresponseInitialized() {
    return idresponse_is_initialized;
  }

  /**
   * Determines if the current object is new.
   *
   * @return true if the current object is new, false if the object is not new
   */
  public boolean isNew() {
    return _isNew;
  }

  /**
   * Specifies to the object if it has been set as new.
   *
   * @param isNew the boolean value to be assigned to the isNew field
   */
  public void isNew(boolean isNew) {
    this._isNew = isNew;
  }

  /**
   * Determines if the object has been modified since the last time this method was called.
   * <br>
   * We can also determine if this object has ever been modified since its creation.
   *
   * @return true if the object has been modified, false if the object has not been modified
   */
  public boolean isModified() {
    return id_is_modified || idevaluation_is_modified || idquestion_is_modified ||
        idresponse_is_modified;
  }

  /**
   * Resets the object modification status to 'not modified'.
   */
  public void resetIsModified() {
    id_is_modified = false;
    idevaluation_is_modified = false;
    idquestion_is_modified = false;
    idresponse_is_modified = false;
  }

  /**
   * Copies the passed bean into the current bean.
   *
   * @param bean the bean to copy into the current bean
   */
  public void copy(EvaluationsdetailBean bean) {
    setId(bean.getId());
    setIdevaluation(bean.getIdevaluation());
    setIdquestion(bean.getIdquestion());
    setIdresponse(bean.getIdresponse());
  }

  /**
   * Returns the object string representation.
   *
   * @return the object as a string
   */
  public String toString() {
    return "\n[EVALUATIONSDETAIL] " + "\n - EVALUATIONSDETAIL.ID = " +
        (id_is_initialized ? ("[" + (id == null ? null : id.toString()) + "]") :
         "not initialized") + "" + "\n - EVALUATIONSDETAIL.IDEVALUATION = " +
        (idevaluation_is_initialized ?
         ("[" + (idevaluation == null ? null : idevaluation.toString()) + "]") :
         "not initialized") + "" + "\n - EVALUATIONSDETAIL.IDQUESTION = " +
        (idquestion_is_initialized ?
         ("[" + (idquestion == null ? null : idquestion.toString()) + "]") :
         "not initialized") + "" + "\n - EVALUATIONSDETAIL.IDRESPONSE = " +
        (idresponse_is_initialized ?
         ("[" + (idresponse == null ? null : idresponse.toString()) + "]") :
         "not initialized") + "";
  }

// class+

// class-
}
