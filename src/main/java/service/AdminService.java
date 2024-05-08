package service;

import model.Admin;
import model.dto.LoginUserDto;
import repository.AdminRepository;

import java.sql.SQLException;

public class AdminService {
  public static boolean login(LoginUserDto loginData) throws SQLException {
    Admin admin = AdminRepository.getByUsername(loginData.getUsername());

    if (admin == null) {
      return false;
    }

    String password = loginData.getPassword();
    String salt = admin.getSalt();
    String hashedPassword = admin.getHashedPassword();

    return PasswordHasher.compareSaltedHash(password, salt, hashedPassword);
  }
}
