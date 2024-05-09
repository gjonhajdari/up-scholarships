package model.dto;

public class LoginUserDto {
  private String studentId;
  private String password;

  public LoginUserDto(String username, String password) {
    this.studentId = username;
    this.password = password;
  }

  public String getStudentId() {
    return studentId;
  }

  public String getPassword() {
    return password;
  }
}
