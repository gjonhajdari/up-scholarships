package service;

import model.User;

public final class UserSession {
  private static UserSession instance;

  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String salt;
  private String hashedPassword;

  private UserSession(String id, String firstName, String lastName, String email, String salt, String hashedPassword) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.salt = salt;
    this.hashedPassword = hashedPassword;
  }

  public static UserSession getInstance(User user) {
    if (instance == null) {
      instance = new UserSession(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getSalt(),
        user.getHashedPassword()
      );
    }

    return instance;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getSalt() {
    return salt;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public void cleanUserSession() {
    this.id = "";
    this.firstName = "";
    this.lastName = "";
    this.email = "";
    this.salt = "";
    this.hashedPassword = "";
  }
}
