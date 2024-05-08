package model;

public class User {
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String salt;
  private String hashedPassword;

  public User(String id, String firstName, String lastName, String email, String salt, String hashedPassword) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.salt = salt;
    this.hashedPassword = hashedPassword;
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
}
