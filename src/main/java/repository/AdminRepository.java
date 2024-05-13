package repository;

import model.Admin;
import utils.DatabaseUtils;
import utils.ResultSetUtils;

public class AdminRepository {
  public static Admin getByUsername(String username) {
    String query = "SELECT * FROM admin WHERE username = ?";
    return DatabaseUtils.getOne(query, ResultSetUtils::AdminResultSet, username);
  }


  public static boolean updatePassword(int id, String password, String salt) {
    String query = "UPDATE admin SET salt = ?, password = ? WHERE admin_id = ?";
    return DatabaseUtils.executeUpdate(query, salt, password, id);
  }
}
