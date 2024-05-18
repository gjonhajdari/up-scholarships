package model.dto;

public class CreateStudentDto {
  String studentId;
  String firstName;
  String lastName;
  String email;
  String salt;
  String hashedPassword;

  public CreateStudentDto(String studentId, String firstName, String lastName, String email, String salt, String hashedPassword) {
    this.studentId = studentId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.salt = salt;
    this.hashedPassword = hashedPassword;
  }

  public String getStudentId() {
    return studentId;
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
