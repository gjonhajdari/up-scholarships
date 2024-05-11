package model.dto;

public class StudentChangePasswordDto {
  private String oldPassword;
  private String newPassword;

  public StudentChangePasswordDto(String oldPassword, String newPassword) {
    this.oldPassword = oldPassword;
    this.newPassword = newPassword;
  }

  public String getOldPassword() {
    return oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }
}
