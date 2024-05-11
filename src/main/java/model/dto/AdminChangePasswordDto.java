package model.dto;

public class AdminChangePasswordDto {
  private String oldPassword;
  private String newPassword;

  public AdminChangePasswordDto(String oldPassword, String newPassword) {
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
