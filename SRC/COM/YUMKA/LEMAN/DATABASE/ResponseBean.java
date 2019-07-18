package com.yumka.leman.database;

public class ResponseBean {
  private Integer id;
  private boolean id_is_modified = false;
  private boolean id_is_initialized = false;

  private String message;
  private boolean message_is_modified = false;
  private boolean message_is_initialized = false;

  private boolean _isNew = true;

  /**
   * Do not use this constructor directly, please use the factory method
   * available in the associated manager.
   */
  ResponseBean() {
  }

  /**
   * Getter method for id.
   * <br>
   * PRIMARY KEY.<br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: RESPONSES.ID
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
   * Getter method for message.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: RESPONSES.MESSAGE
   * <li>column size: 100
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Setter method for message.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to message
   */
  public void setMessage(String newVal) {
    //this.setId(1500);
    if ( (newVal != null && this.message != null &&
          (newVal.compareTo(this.message) == 0)) ||
        (newVal == null && this.message == null && message_is_initialized)) {
      return;
    }
    this.message = newVal;
    message_is_modified = true;
    message_is_initialized = true;
  }

  /**
   * Determines if the message has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isMessageModified() {
    return message_is_modified;
  }

  /**
   * Determines if the message has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isMessageInitialized() {
    return message_is_initialized;
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
    return id_is_modified || message_is_modified;
  }

  /**
   * Resets the object modification status to 'not modified'.
   */
  public void resetIsModified() {
    id_is_modified = false;
    message_is_modified = false;
  }

  /**
   * Copies the passed bean into the current bean.
   *
   * @param bean the bean to copy into the current bean
   */
  public void copy(ResponseBean bean) {
    setId(bean.getId());
    setMessage(bean.getMessage());
  }

  /**
   * Returns the object string representation.
   *
   * @return the object as a string
   */
  public String toString() {
    return "\n[RESPONSES] " + "\n - RESPONSES.ID = " +
        (id_is_initialized ? ("[" + (id == null ? null : id.toString()) + "]") :
         "not initialized") + "" + "\n - RESPONSES.MESSAGE = " +
        (message_is_initialized ?
         ("[" + (message == null ? null : message.toString()) + "]") :
         "not initialized") + "";
  }
}
