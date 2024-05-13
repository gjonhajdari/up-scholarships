package repository;

import model.User;
import utils.DatabaseUtils;
import utils.ResultSetUtils;

public class UserRepository {
  public static User getById(String studentId) {
    String query = "SELECT * FROM student WHERE student_id = ?";
    return DatabaseUtils.getOne(query, ResultSetUtils::UserResultSet, studentId);
  }


  public static boolean updatePassword(String id, String password, String salt) {
    String query = "UPDATE student SET salt = ?, password = ? WHERE student_id = ?";
    return DatabaseUtils.executeUpdate(query, salt, password, id);
  }
}
