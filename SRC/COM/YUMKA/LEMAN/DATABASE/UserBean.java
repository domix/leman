package com.yumka.leman.database;

/**
 * The Bean that represents a user in the database
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */
public class UserBean {
  private String login;
  private boolean login_is_modified = false;
  private boolean login_is_initialized = false;

  private String name;
  private boolean name_is_modified = false;
  private boolean name_is_initialized = false;

  private String company;
  private boolean company_is_modified = false;
  private boolean company_is_initialized = false;

  private String jobposition;
  private boolean jobposition_is_modified = false;
  private boolean jobposition_is_initialized = false;

  private String password;
  private boolean password_is_modified = false;
  private boolean password_is_initialized = false;

  private boolean _isNew = true;

  /**
   * Do not use this constructor directly, please use the factory method
   * available in the associated manager.
   */
  UserBean() {
  }

  /**
   * Getter method for login.
   * <br>
   * PRIMARY KEY.<br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: USERS.LOGIN
   * <li>column size: 15
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of login
   */ public String getLogin() {
    return login;
  }

  /**
   * Setter method for login.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to login
   */
  public void setLogin(String newVal) {
    if ( (newVal != null && this.login != null &&
          (newVal.compareTo(this.login) == 0)) ||
        (newVal == null && this.login == null && login_is_initialized)) {
      return;
    }
    this.login = newVal;
    login_is_modified = true;
    login_is_initialized = true;
  }

  /**
   * Determines if the login has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isLoginModified() {
    return login_is_modified;
  }

  /**
   * Determines if the login has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isLoginInitialized() {
    return login_is_initialized;
  }

  /**
   * Getter method for name.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: USERS.NAME
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
   * Getter method for company.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: USERS.COMPANY
   * <li>column size: 50
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of company
   */
  public String getCompany() {
    return company;
  }

  /**
   * Setter method for company.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to company
   */
  public void setCompany(String newVal) {
    if ( (newVal != null && this.company != null &&
          (newVal.compareTo(this.company) == 0)) ||
        (newVal == null && this.company == null && company_is_initialized)) {
      return;
    }
    this.company = newVal;
    company_is_modified = true;
    company_is_initialized = true;
  }

  /**
   * Determines if the company has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isCompanyModified() {
    return company_is_modified;
  }

  /**
   * Determines if the company has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isCompanyInitialized() {
    return company_is_initialized;
  }

  /**
   * Getter method for jobposition.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: USERS.JOBPOSITION
   * <li>column size: 20
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of jobposition
   */
  public String getJobposition() {
    return jobposition;
  }

  /**
   * Setter method for jobposition.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to jobposition
   */
  public void setJobposition(String newVal) {
    if ( (newVal != null && this.jobposition != null &&
          (newVal.compareTo(this.jobposition) == 0)) ||
        (newVal == null && this.jobposition == null &&
         jobposition_is_initialized)) {
      return;
    }
    this.jobposition = newVal;
    jobposition_is_modified = true;
    jobposition_is_initialized = true;
  }

  /**
   * Determines if the jobposition has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isJobpositionModified() {
    return jobposition_is_modified;
  }

  /**
   * Determines if the jobposition has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isJobpositionInitialized() {
    return jobposition_is_initialized;
  }

  /**
   * Getter method for password.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: USERS.PASSWORD
   * <li>column size: 15
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter method for password.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to password
   */
  public void setPassword(String newVal) {
    if ( (newVal != null && this.password != null &&
          (newVal.compareTo(this.password) == 0)) ||
        (newVal == null && this.password == null && password_is_initialized)) {
      return;
    }
    this.password = newVal;
    password_is_modified = true;
    password_is_initialized = true;
  }

  /**
   * Determines if the password has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isPasswordModified() {
    return password_is_modified;
  }

  /**
   * Determines if the password has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isPasswordInitialized() {
    return password_is_initialized;
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
    return login_is_modified || name_is_modified || company_is_modified ||
        jobposition_is_modified || password_is_modified;
  }

  /**
   * Resets the object modification status to 'not modified'.
   */
  public void resetIsModified() {
    login_is_modified = false;
    name_is_modified = false;
    company_is_modified = false;
    jobposition_is_modified = false;
    password_is_modified = false;
  }

  /**
   * Copies the passed bean into the current bean.
   *
   * @param bean the bean to copy into the current bean
   */
  public void copy(UserBean bean) {
    setLogin(bean.getLogin());
    setName(bean.getName());
    setCompany(bean.getCompany());
    setJobposition(bean.getJobposition());
    setPassword(bean.getPassword());
  }

  /**
   * Returns the object string representation.
   *
   * @return the object as a string
   */
  public String toString() {
    return "\n[USERS] " + "\n - USERS.LOGIN = " +
        (login_is_initialized ?
         ("[" + (login == null ? null : login.toString()) + "]") :
         "not initialized") + "" + "\n - USERS.NAME = " +
        (name_is_initialized ?
         ("[" + (name == null ? null : name.toString()) + "]") :
         "not initialized") + "" + "\n - USERS.COMPANY = " +
        (company_is_initialized ?
         ("[" + (company == null ? null : company.toString()) + "]") :
         "not initialized") + "" + "\n - USERS.JOBPOSITION = " +
        (jobposition_is_initialized ?
         ("[" + (jobposition == null ? null : jobposition.toString()) + "]") :
         "not initialized") + "" + "\n - USERS.PASSWORD = " + "[]";
  }
}
