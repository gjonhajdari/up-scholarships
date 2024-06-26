package service;

import model.User;
import model.dto.CreateStudentDto;
import model.dto.LoginUserDto;
import model.dto.StudentChangePasswordDto;
import model.dto.StudentDto;
import repository.UserRepository;

public class UserService {
  public static boolean create(StudentDto studentData) {
    String salt = PasswordHasher.generateSalt();
    String password = PasswordHasher.generateSaltedHash("12345", salt);

    CreateStudentDto createStudentData = new CreateStudentDto(
      studentData.getStudentId(),
      studentData.getFirstName(),
      studentData.getLastName(),
      studentData.getEmail(),
      salt,
      password
    );

    return UserRepository.create(createStudentData);
  }

  public static boolean login(LoginUserDto loginData) {
    User user = UserRepository.getById(loginData.getStudentId());

    if(user == null){
      return false;
    }

    String password = loginData.getPassword();
    String salt = user.getSalt();
    String hashedPassword = user.getHashedPassword();

    if (!PasswordHasher.compareSaltedHash(password, salt, hashedPassword)) {
      return false;
    }

    UserSession.setUserSession(user);
    return true;
  }

  public static boolean updatePassword(StudentChangePasswordDto saveData) {
    String studentId = UserSession.getUser().getId();
    User user = UserRepository.getById(studentId);

    if (user == null){
        return false;
    }

    String oldPassword = saveData.getOldPassword();
    String newPassword = saveData.getNewPassword();

    String salt = PasswordHasher.generateSalt();
    String newHashedPassword = PasswordHasher.generateSaltedHash(newPassword, salt);

    if(!PasswordHasher.compareSaltedHash(oldPassword, user.getSalt(), user.getHashedPassword())){
      return false;
    }

    return UserRepository.updatePassword(user.getId(), newHashedPassword, salt);
  }
}
