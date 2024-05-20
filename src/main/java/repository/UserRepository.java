package repository;

import model.User;
import model.dto.CreateStudentDto;
import utils.DatabaseUtils;
import utils.ResultSetUtils;

public class UserRepository {
  public static boolean create(CreateStudentDto studentData) {
    String query = "INSERT INTO student (student_id, first_name, last_name, email, salt, password) VALUES (?, ?, ?, ?, ?, ?)";

    return DatabaseUtils.executeUpdate(
      query,
      studentData.getStudentId(),
      studentData.getFirstName(),
      studentData.getLastName(),
      studentData.getEmail(),
      studentData.getSalt(),
      studentData.getHashedPassword()
    );
  }

  public static User getById(String studentId) {
    String query = "SELECT * FROM student WHERE student_id = ?";
    return DatabaseUtils.getOne(query, ResultSetUtils::UserResultSet, studentId);
  }


  public static boolean updatePassword(String id, String password, String salt) {
    String query = "UPDATE student SET salt = ?, password = ? WHERE student_id = ?";
    return DatabaseUtils.executeUpdate(query, salt, password, id);
  }
}
