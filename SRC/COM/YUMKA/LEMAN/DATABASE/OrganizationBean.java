package com.yumka.leman.database;

/**
 * The Bean that represents a Organization in the database
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class OrganizationBean {
  private Integer id;
  private boolean id_is_modified = false;
  private boolean id_is_initialized = false;

  private String name;
  private boolean name_is_modified = false;
  private boolean name_is_initialized = false;

  private String address;
  private boolean address_is_modified = false;
  private boolean address_is_initialized = false;

  private String telephone;
  private boolean telephone_is_modified = false;
  private boolean telephone_is_initialized = false;

  private boolean _isNew = true;

  /**
   * Do not use this constructor directly, please use the factory method
   * available in the associated manager.
   */
  OrganizationBean() {
  }

  /**
   * Getter method for id.
   * <br>
   * PRIMARY KEY.<br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: ORGANIZATIONS.ID
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
   * Getter method for name.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: ORGANIZATIONS.NAME
   * <li>column size: 50
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter method for name.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to name
   */
  public void setName(String newVal) {
    if ( (newVal != null && this.name != null &&
          (newVal.compareTo(this.name) == 0)) ||
        (newVal == null && this.name == null && name_is_initialized)) {
      return;
    }
    this.name = newVal;
    name_is_modified = true;
    name_is_initialized = true;
  }

  /**
   * Determines if the name has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isNameModified() {
    return name_is_modified;
  }

  /**
   * Determines if the name has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isNameInitialized() {
    return name_is_initialized;
  }

  /**
   * Getter method for address.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: ORGANIZATIONS.ADDRESS
   * <li>column size: 50
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Setter method for address.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to address
   */
  public void setAddress(String newVal) {
    if ( (newVal != null && this.address != null &&
          (newVal.compareTo(this.address) == 0)) ||
        (newVal == null && this.address == null && address_is_initialized)) {
      return;
    }
    this.address = newVal;
    address_is_modified = true;
    address_is_initialized = true;
  }

  /**
   * Determines if the address has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isAddressModified() {
    return address_is_modified;
  }

  /**
   * Determines if the address has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isAddressInitialized() {
    return address_is_initialized;
  }

  /**
   * Getter method for telephone.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: ORGANIZATIONS.TELEPHONE
   * <li>column size: 20
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of telephone
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Setter method for telephone.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to telephone
   */
  public void setTelephone(String newVal) {
    if ( (newVal != null && this.telephone != null &&
          (newVal.compareTo(this.telephone) == 0)) ||
        (newVal == null && this.telephone == null && telephone_is_initialized)) {
      return;
    }
    this.telephone = newVal;
    telephone_is_modified = true;
    telephone_is_initialized = true;
  }

  /**
   * Determines if the telephone has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isTelephoneModified() {
    return telephone_is_modified;
  }

  /**
   * Determines if the telephone has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isTelephoneInitialized() {
    return telephone_is_initialized;
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
    return id_is_modified || name_is_modified || address_is_modified ||
        telephone_is_modified;
  }

  /**
   * Resets the object modification status to 'not modified'.
   */
  public void resetIsModified() {
    id_is_modified = false;
    name_is_modified = false;
    address_is_modified = false;
    telephone_is_modified = false;
  }

  /**
   * Copies the passed bean into the current bean.
   *
   * @param bean the bean to copy into the current bean
   */
  public void copy(OrganizationBean bean) {
    setId(bean.getId());
    setName(bean.getName());
    setAddress(bean.getAddress());
    setTelephone(bean.getTelephone());
  }

  /**
   * Returns the object string representation.
   *
   * @return the object as a string
   */
  public String toString() {
    return "\n[ORGANIZATIONS] " + "\n - ORGANIZATIONS.ID = " +
        (id_is_initialized ? ("[" + (id == null ? null : id.toString()) + "]") :
         "not initialized") + "" + "\n - ORGANIZATIONS.NAME = " +
        (name_is_initialized ?
         ("[" + (name == null ? null : name.toString()) + "]") :
         "not initialized") + "" + "\n - ORGANIZATIONS.ADDRESS = " +
        (address_is_initialized ?
         ("[" + (address == null ? null : address.toString()) + "]") :
         "not initialized") + "" + "\n - ORGANIZATIONS.TELEPHONE = " +
        (telephone_is_initialized ?
         ("[" + (telephone == null ? null : telephone.toString()) + "]") :
         "not initialized") + "";
  }
}

//360
