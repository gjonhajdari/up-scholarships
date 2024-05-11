package service;

import model.Admin;
import model.dto.AdminChangePasswordDto;
import model.dto.LoginUserDto;
import repository.AdminRepository;

import java.sql.SQLException;

public class AdminService {
  public static boolean login(LoginUserDto loginData) throws SQLException {
    Admin admin = AdminRepository.getByUsername(loginData.getStudentId());

    if (admin == null) {
      return false;
    }

    String password = loginData.getPassword();
    String salt = admin.getSalt();
    String hashedPassword = admin.getHashedPassword();

    return PasswordHasher.compareSaltedHash(password, salt, hashedPassword);
  }

  public static boolean updatePassword(AdminChangePasswordDto saveData) throws SQLException {
    Admin admin = AdminRepository.getByUsername("admin");

    if (admin == null) {
      return false;
    }

    String oldPassword = saveData.getOldPassword();
    String newPassword = saveData.getNewPassword();

    String salt = PasswordHasher.generateSalt();
    String newHashedPassword = PasswordHasher.generateSaltedHash(newPassword, salt);

    if (!PasswordHasher.compareSaltedHash(oldPassword, admin.getSalt(), admin.getHashedPassword())) {
      return false;
    }

    return AdminRepository.updatePassword(admin.getId(), newHashedPassword, salt);
  }
}
