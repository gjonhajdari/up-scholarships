package model;

public class Admin {
  private int id;
  private String username;
  private String salt;
  private String hashedPassword;

  public Admin(int id, String username, String salt, String password) {
    this.id = id;
    this.username = username;
    this.salt = salt;
    this.hashedPassword = password;
  }

  public int getId() {
    return id;
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
}
