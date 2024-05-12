package repository;

import service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationRepository {
  public static boolean updateStatus(int applicationId, String status) {
    String query = "UPDATE application SET status = ? WHERE application_id = ?";

    try {
      Connection connection = ConnectionUtil.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, status);
      preparedStatement.setInt(2, applicationId);
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    } finally {
      try {
        ConnectionUtil.getConnection().close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
