package repository;

import model.Admin;
import service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepository {

  public static Admin getByUsername(String username) throws SQLException {
    String query = "SELECT * FROM admin WHERE username = ?";
    Connection connection = ConnectionUtil.getConnection();

    try {
      PreparedStatement pst = connection.prepareStatement(query);
      pst.setString(1, username);
      ResultSet result = pst.executeQuery();

      if (result.next()) {
        return getFromResultSet(result);
      }

      return null;
    } catch (Exception e){
      return null;
    }
  }

  public static boolean updatePassword(int id, String password, String salt) throws SQLException {
    String query = "UPDATE admin SET salt = ?, password = ? WHERE admin_id = ?";
    Connection connection = ConnectionUtil.getConnection();

    try {
      PreparedStatement pst = connection.prepareStatement(query);
      pst.setString(1, salt);
      pst.setString(2, password);
      pst.setInt(3, id);

      return pst.executeUpdate() > 0;
    } catch (Exception e){
      return false;
    }

  }

  private static Admin getFromResultSet(ResultSet result){
    try{
      int id = result.getInt("admin_id");
      String username = result.getString("username");
      String salt = result.getString("salt");
      String passwordHash = result.getString("password");

      return new Admin(id, username, salt, passwordHash);
    }catch (SQLException e) {
      return null;
    }
  }
}
