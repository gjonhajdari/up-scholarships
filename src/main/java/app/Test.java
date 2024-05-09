package app;

import service.ConnectionUtil;
import service.PasswordHasher;

import java.sql.*;

public class Test {
  public static void main(String[] args) throws SQLException {
//    printUser();
    // Hash passwords for 6 test users
    for (int i = 0; i <= 5 ; i++) {
      String salt = PasswordHasher.generateSalt();
      String hashedPassword = PasswordHasher.generateSaltedHash("12345", salt);

      System.out.println("User " + (i + 1));
      System.out.println("Salt: " + salt);
      System.out.println("Hashed Password: " + hashedPassword);
      System.out.println("--------------------");
    }
  }

  public static void printUser() throws SQLException {
    String sql = "SELECT * FROM student";

    Connection connection = ConnectionUtil.getConnection();
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(sql);

    while (result.next()) {
      String resultId = result.getString("student_id");
      String resultFirstName = result.getString("first_name");
      String resultLastName = result.getString("last_name");

      System.out.println("ID: " + resultId);
      System.out.println("First Name: " + resultFirstName);
      System.out.println("Last Name: " + resultLastName);
    }
  }
}
