package repository;

import model.User;
import service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {


    public static User getByUsername(String username){
        String query = "SELECT * FROM student WHERE student_id = ? LIMIT 1";
        try{
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                return getFromResultSet(result);
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    private static User getFromResultSet(ResultSet result){
        try{
            String id = result.getString("student_id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            String salt = result.getString("salt");
            String hashedPassword = result.getString("password");
            return new User(
                    id, firstName, lastName, email, salt, hashedPassword
            );
        }catch (Exception e){
            return null;
        }
    }
}
