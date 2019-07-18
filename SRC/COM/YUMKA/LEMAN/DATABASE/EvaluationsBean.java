package com.yumka.leman.database;

public class EvaluationsBean
// extends+

// extends-
{
  private Integer id;
  private boolean id_is_modified = false;
  private boolean id_is_initialized = false;

  private Integer idorganization;
  private boolean idorganization_is_modified = false;
  private boolean idorganization_is_initialized = false;

  private String iduser;
  private boolean iduser_is_modified = false;
  private boolean iduser_is_initialized = false;

  private java.util.Date date;
  private boolean date_is_modified = false;
  private boolean date_is_initialized = false;

  private java.util.Date time;
  private boolean time_is_modified = false;
  private boolean time_is_initialized = false;

  private String organization;
  private boolean organization_is_modified = false;
  private boolean organization_is_initialized = false;

  private boolean _isNew = true;

  /**
   * Do not use this constructor directly, please use the factory method
   * available in the associated manager.
   */
  EvaluationsBean() {
  }

  /**
   * Getter method for id.
   * <br>
   * PRIMARY KEY.<br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONS.ID
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
   * Getter method for idorganization.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONS.IDORGANIZATION
   * <li> foreign key: ORGANIZATIONS.ID
   * <li>column size: 0
   * <li>jdbc type returned by the driver: Types.INTEGER
   * </ul>
   *
   * @return the value of idorganization
   */
  public Integer getIdorganization() {
    return idorganization;
  }

  /**
   * Setter method for idorganization.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to idorganization
   */
  public void setIdorganization(Integer newVal) {
    if ( (newVal != null && this.idorganization != null &&
          (newVal.compareTo(this.idorganization) == 0)) ||
        (newVal == null && this.idorganization == null &&
         idorganization_is_initialized)) {
      return;
    }
    this.idorganization = newVal;
    idorganization_is_modified = true;
    idorganization_is_initialized = true;
  }

  /**
   * Setter method for idorganization.
   * <br>
   * Convenient for those who do not want to deal with Objects for primary types.
   *
   * @param newVal the new value to be assigned to idorganization
   */
  public void setIdorganization(int newVal) {
    setIdorganization(new Integer(newVal));
  }

  /**
   * Determines if the idorganization has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIdorganizationModified() {
    return idorganization_is_modified;
  }

  /**
   * Determines if the idorganization has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIdorganizationInitialized() {
    return idorganization_is_initialized;
  }

  /**
   * Getter method for iduser.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONS.IDUSER
   * <li> foreign key: USERS.LOGIN
   * <li>column size: 15
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of iduser
   */
  public String getIduser() {
    return iduser;
  }

  /**
   * Setter method for iduser.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to iduser
   */
  public void setIduser(String newVal) {
    if ( (newVal != null && this.iduser != null &&
          (newVal.compareTo(this.iduser) == 0)) ||
        (newVal == null && this.iduser == null && iduser_is_initialized)) {
      return;
    }
    this.iduser = newVal;
    iduser_is_modified = true;
    iduser_is_initialized = true;
  }

  /**
   * Determines if the iduser has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIduserModified() {
    return iduser_is_modified;
  }

  /**
   * Determines if the iduser has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIduserInitialized() {
    return iduser_is_initialized;
  }

  /**
   * Getter method for date.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONS.DATE
   * <li>column size: 0
   * <li>jdbc type returned by the driver: Types.DATE
   * </ul>
   *
   * @return the value of date
   */
  public java.util.Date getDate() {
    return date;
  }

  /**
   * Setter method for date.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to date
   */
  public void setDate(java.util.Date newVal) {
    if ( (newVal != null && this.date != null &&
          (newVal.compareTo(this.date) == 0)) ||
        (newVal == null && this.date == null && date_is_initialized)) {
      return;
    }
    this.date = newVal;
    date_is_modified = true;
    date_is_initialized = true;
  }

  /**
   * Setter method for date.
   * <br>
   * Convenient for those who do not want to deal with Objects for primary types.
   *
   * @param newVal the new value to be assigned to date
   */
  public void setDate(long newVal) {
    setDate(new java.util.Date(newVal));
  }

  /**
   * Determines if the date has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isDateModified() {
    return date_is_modified;
  }

  /**
   * Determines if the date has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isDateInitialized() {
    return date_is_initialized;
  }

  /**
   * Getter method for time.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONS.TIME
   * <li>column size: 0
   * <li>jdbc type returned by the driver: Types.TIME
   * </ul>
   *
   * @return the value of time
   */
  public java.util.Date getTime() {
    return time;
  }

  /**
   * Setter method for time.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to time
   */
  public void setTime(java.util.Date newVal) {
    if ( (newVal != null && this.time != null &&
          (newVal.compareTo(this.time) == 0)) ||
        (newVal == null && this.time == null && time_is_initialized)) {
      return;
    }
    this.time = newVal;
    time_is_modified = true;
    time_is_initialized = true;
  }

  /**
   * Setter method for time.
   * <br>
   * Convenient for those who do not want to deal with Objects for primary types.
   *
   * @param newVal the new value to be assigned to time
   */
  public void setTime(long newVal) {
    setTime(new java.util.Date(newVal));
  }

  /**
   * Determines if the time has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isTimeModified() {
    return time_is_modified;
  }

  /**
   * Determines if the time has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isTimeInitialized() {
    return time_is_initialized;
  }

  /**
   * Getter method for organization.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: EVALUATIONS.ORGANIZATION
   * <li>column size: 100
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of organization
   */
  public String getOrganization() {
    return organization;
  }

  /**
   * Setter method for organization.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to organization
   */
  public void setOrganization(String newVal) {
    if ( (newVal != null && this.organization != null &&
          (newVal.compareTo(this.organization) == 0)) ||
        (newVal == null && this.organization == null &&
         organization_is_initialized)) {
      return;
    }
    this.organization = newVal;
    organization_is_modified = true;
    organization_is_initialized = true;
  }

  /**
   * Determines if the organization has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isOrganizationModified() {
    return organization_is_modified;
  }

  /**
   * Determines if the organization has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isOrganizationInitialized() {
    return organization_is_initialized;
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
    return id_is_modified || idorganization_is_modified || iduser_is_modified ||
        date_is_modified || time_is_modified || organization_is_modified;
  }

  /**
   * Resets the object modification status to 'not modified'.
   */
  public void resetIsModified() {
    id_is_modified = false;
    idorganization_is_modified = false;
    iduser_is_modified = false;
    date_is_modified = false;
    time_is_modified = false;
    organization_is_modified = false;
  }

  /**
   * Copies the passed bean into the current bean.
   *
   * @param bean the bean to copy into the current bean
   */
  public void copy(EvaluationsBean bean) {
    setId(bean.getId());
    setIdorganization(bean.getIdorganization());
    setIduser(bean.getIduser());
    setDate(bean.getDate());
    setTime(bean.getTime());
    setOrganization(bean.getOrganization());
  }

  /**
   * Returns the object string representation.
   *
   * @return the object as a string
   */
  public String toString() {
    return "\n[EVALUATIONS] " + "\n - EVALUATIONS.ID = " +
        (id_is_initialized ? ("[" + (id == null ? null : id.toString()) + "]") :
         "not initialized") + "" + "\n - EVALUATIONS.IDORGANIZATION = " +
        (idorganization_is_initialized ?
         ("[" + (idorganization == null ? null : idorganization.toString()) +
          "]") : "not initialized") + "" + "\n - EVALUATIONS.IDUSER = " +
        (iduser_is_initialized ?
         ("[" + (iduser == null ? null : iduser.toString()) + "]") :
         "not initialized") + "" + "\n - EVALUATIONS.DATE = " +
        (date_is_initialized ?
         ("[" + (date == null ? null : date.toString()) + "]") :
         "not initialized") + "" + "\n - EVALUATIONS.TIME = " +
        (time_is_initialized ?
         ("[" + (time == null ? null : time.toString()) + "]") :
         "not initialized") + "" + "\n - EVALUATIONS.ORGANIZATION = " +
        (organization_is_initialized ?
         ("[" + (organization == null ? null : organization.toString()) + "]") :
         "not initialized") + "";
  }

// class+

// class-
}
