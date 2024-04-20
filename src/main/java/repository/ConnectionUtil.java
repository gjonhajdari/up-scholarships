package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
  private static Connection connection;
  private static String URL = "jdbc:mysql://localhost:3306/scholarships";
  private static String USER = "root";
  private static String PASSWORD = "";

  public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
      try {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }

    return connection;
  }
}