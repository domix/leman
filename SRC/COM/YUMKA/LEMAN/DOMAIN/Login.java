package com.yumka.leman.domain;

import java.sql.SQLException;

public class Login {
  private String userName;
  private String password;
  public Login(String user, String password) {
    this.setUserName(user);
    this.setPassword(password);
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public boolean isCorrectLogin() throws SQLException {
    boolean result = false;
    return result;
  }
}
