package repository;

import model.Application;
import service.ConnectionUtil;
import utils.Formatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


  private static List<Application> getApplications(String query, Object... params) {
    List<Application> applications = new ArrayList<>();

    try {
      Connection connection = ConnectionUtil.getConnection();
      PreparedStatement pst;

      if (params.length > 0) {
        pst = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
          pst.setObject(i + 1, params[i]);
        }
      } else {
        pst = connection.prepareStatement(query);
      }

      ResultSet rs = pst.executeQuery();

      while (rs.next())
        applications.add(getFromResultSet(rs));

    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      try {
        ConnectionUtil.getConnection().close();
      } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    return applications;
  }

  private static Application getApplication(String query, Object... params) {
    List<Application> applications = getApplications(query, params);
    return applications.isEmpty() ? null : applications.getFirst();
  }


  private static Application getFromResultSet(ResultSet resultSet) throws SQLException {
    int id = resultSet.getInt("application_id");
    String studentId = resultSet.getString("student_id");
    int voucherId = resultSet.getInt("voucher_id");
    String status = resultSet.getString("status");
    Date applicationDate = resultSet.getDate("application_date");

    return new Application(
      id,
      studentId,
      voucherId,
      status,
      Formatter.convertFromDate(applicationDate)
    );
  }
}
