package service;

import model.User;
import model.dto.LoginUserDto;
import repository.UserRepository;

public class UserService {

    public static boolean login(LoginUserDto loginData){
        User user = UserRepository.getByUsername(loginData.getStudentId());

        if(user == null){
            return false;
        }

        String password = loginData.getPassword();
        String salt = user.getSalt();
        String hashedPassword = user.getHashedPassword();

        return PasswordHasher.compareSaltedHash(password, salt, hashedPassword);
    }
}
