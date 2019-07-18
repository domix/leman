package com.yumka.leman.domain;

public class User {
  private String login;
  private String name;
  private String company;
  private String jobPosition;
  private String password;
  public User() {
  }
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }
  public String getJobPosition() {
    return jobPosition;
  }
  public void setJobPosition(String jobPosition) {
    this.jobPosition = jobPosition;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
