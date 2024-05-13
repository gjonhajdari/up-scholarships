package service;

import model.Admin;

public final class AdminSession {
  private static AdminSession instance;

  private String username;
  private String salt;
  private String hashedPassword;

  private AdminSession(String username, String salt, String hashedPassword) {
    this.username = username;
    this.salt = salt;
    this.hashedPassword = hashedPassword;
  }

  public static AdminSession getInstance(Admin admin) {
    if (instance == null) {
      instance = new AdminSession(admin.getUsername(), admin.getSalt(), admin.getHashedPassword());
    }

    return instance;
  }

  public String getUsername() {
    return username;
  }

  public String getSalt() {
    return salt;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public void cleanAdminSession() {
    this.username = "";
    this.salt = "";
    this.hashedPassword = "";
    instance = null;
  }
}
