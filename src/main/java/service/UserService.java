package service;

import model.User;
import model.dto.LoginUserDto;
import model.dto.StudentChangePasswordDto;
import repository.UserRepository;

public class UserService {

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

        UserSession.getInstance(user);
        return true;
    }

    public static boolean updatePassword(StudentChangePasswordDto saveData) {
        String studentId = UserSession.getInstance(null).getId();
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
