package com.yumka.leman.database;

/**
 * The Bean that represents a ISOPoint in the database
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class ISOPointBean {
  private String id;
  private boolean id_is_modified = false;
  private boolean id_is_initialized = false;

  private String description;
  private boolean description_is_modified = false;
  private boolean description_is_initialized = false;

  private String idisopoint;
  private boolean idisopoint_is_modified = false;
  private boolean idisopoint_is_initialized = false;

  private boolean _isNew = true;

  /**
   * Do not use this constructor directly, please use the factory method
   * available in the associated manager.
   */
  ISOPointBean() {
  }

  /**
   * Getter method for id.
   * <br>
   * PRIMARY KEY.<br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: ISOPOINTS.ID
   * <li>column size: 10
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of id
   */ public String getId() {
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
  public void setId(String newVal) {
    if ( (newVal != null && this.id != null && (newVal.compareTo(this.id) == 0)) ||
        (newVal == null && this.id == null && id_is_initialized)) {
      return;
    }
    this.id = newVal;
    id_is_modified = true;
    id_is_initialized = true;
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
   * Getter method for description.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: ISOPOINTS.DESCRIPTION
   * <li>column size: 50
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Setter method for description.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to description
   */
  public void setDescription(String newVal) {
    if ( (newVal != null && this.description != null &&
          (newVal.compareTo(this.description) == 0)) ||
        (newVal == null && this.description == null &&
         description_is_initialized)) {
      return;
    }
    this.description = newVal;
    description_is_modified = true;
    description_is_initialized = true;
  }

  /**
   * Determines if the description has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isDescriptionModified() {
    return description_is_modified;
  }

  /**
   * Determines if the description has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isDescriptionInitialized() {
    return description_is_initialized;
  }

  /**
   * Getter method for idisopoint.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: ISOPOINTS.IDISOPOINT
   * <li> foreign key: ISOPOINTS.ID
   * <li>column size: 10
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of idisopoint
   */
  public String getIdisopoint() {
    return idisopoint;
  }

  /**
   * Setter method for idisopoint.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to idisopoint
   */
  public void setIdisopoint(String newVal) {
    if ( (newVal != null && this.idisopoint != null &&
          (newVal.compareTo(this.idisopoint) == 0)) ||
        (newVal == null && this.idisopoint == null && idisopoint_is_initialized)) {
      return;
    }
    this.idisopoint = newVal;
    idisopoint_is_modified = true;
    idisopoint_is_initialized = true;
  }

  /**
   * Determines if the idisopoint has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIdisopointModified() {
    return idisopoint_is_modified;
  }

  /**
   * Determines if the idisopoint has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIdisopointInitialized() {
    return idisopoint_is_initialized;
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
    return id_is_modified || description_is_modified || idisopoint_is_modified;
  }

  /**
   * Resets the object modification status to 'not modified'.
   */
  public void resetIsModified() {
    id_is_modified = false;
    description_is_modified = false;
    idisopoint_is_modified = false;
  }

  /**
   * Copies the passed bean into the current bean.
   *
   * @param bean the bean to copy into the current bean
   */
  public void copy(ISOPointBean bean) {
    setId(bean.getId());
    setDescription(bean.getDescription());
    setIdisopoint(bean.getIdisopoint());
  }

  /**
   * Returns the object string representation.
   *
   * @return the object as a string
   */
  public String toString() {
    return "\n[ISOPOINTS] " + "\n - ISOPOINTS.ID = " +
        (id_is_initialized ? ("[" + (id == null ? null : id.toString()) + "]") :
         "not initialized") + "" + "\n - ISOPOINTS.DESCRIPTION = " +
        (description_is_initialized ?
         ("[" + (description == null ? null : description.toString()) + "]") :
         "not initialized") + "" + "\n - ISOPOINTS.IDISOPOINT = " +
        (idisopoint_is_initialized ?
         ("[" + (idisopoint == null ? null : idisopoint.toString()) + "]") :
         "not initialized") + "";
  }
}
