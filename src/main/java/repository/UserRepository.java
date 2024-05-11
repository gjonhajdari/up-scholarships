package repository;

import model.User;
import service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {
    public static User getById(String id){
        String query = "SELECT * FROM student WHERE student_id = ? LIMIT 1";
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, id);
            ResultSet result = pst.executeQuery();

            if(result.next()){
                return getFromResultSet(result);
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }

    public static boolean updatePassword(String id, String password, String salt){
        String query = "UPDATE student SET salt = ?, password = ? WHERE student_id = ?";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, salt);
            pst.setString(2, password);
            pst.setString(3, id);

            return pst.executeUpdate() > 0;
        } catch (Exception e){
            return false;
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

            return new User(id, firstName, lastName, email, salt, hashedPassword);
        }catch (Exception e){
            return null;
        }
    }
}
