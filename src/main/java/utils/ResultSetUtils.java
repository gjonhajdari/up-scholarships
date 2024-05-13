package utils;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ResultSetUtils {
  public static Voucher VoucherResultSet(ResultSet resultSet) {
    try {
      int id = resultSet.getInt("voucher_id");
      String title = resultSet.getString("title");
      Float amount = resultSet.getFloat("amount");
      String category = resultSet.getString("category");
      String description = resultSet.getString("description");
      Date deadline = resultSet.getDate("deadline");

      return new Voucher(
        id,
        title,
        amount,
        category,
        description,
        Formatter.convertFromDate(deadline)
      );
    } catch (SQLException e) {
      return null;
    }
  }

  public static VoucherApplied VoucherAppliedResultSet(ResultSet resultSet) {
    try {
      int id = resultSet.getInt("voucher_id");
      String title = resultSet.getString("title");
      Float amount = resultSet.getFloat("amount");
      String category = resultSet.getString("category");
      String description = resultSet.getString("description");
      Date deadline = resultSet.getDate("deadline");
      int applicationId = resultSet.getInt("application_id");
      String status = resultSet.getString("status");
      Date applicationDate = resultSet.getDate("application_date");

      return new VoucherApplied(
        id,
        title,
        amount,
        category,
        description,
        Formatter.convertFromDate(deadline),
        applicationId,
        status,
        Formatter.convertFromDate(applicationDate)
      );
    } catch (SQLException e) {
      return null;
    }
  }

  public static ApplicantWithData ApplicantResultSet(ResultSet resultSet) {
    try {
      int id = resultSet.getInt("application_id");
      String studentId = resultSet.getString("student_id");
      String firstName = resultSet.getString("first_name");
      String lastName = resultSet.getString("last_name");
      String status = resultSet.getString("status");
      Date applicationDate = resultSet.getDate("application_date");

      return new ApplicantWithData(
        id,
        studentId,
        firstName,
        lastName,
        status,
        Formatter.convertFromDate(applicationDate)
      );
    } catch (SQLException e) {
      return null;
    }
  }

  public static User UserResultSet(ResultSet result) {
    try {
      String id = result.getString("student_id");
      String firstName = result.getString("first_name");
      String lastName = result.getString("last_name");
      String email = result.getString("email");
      String salt = result.getString("salt");
      String hashedPassword = result.getString("password");

      return new User(
        id,
        firstName,
        lastName,
        email,
        salt,
        hashedPassword
      );
    } catch (Exception e){
      return null;
    }
  }

  public static Application ApplicationResultSet(ResultSet resultSet) {
    try {
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
    } catch (SQLException e) {
      return null;
    }
  }

  public static Admin AdminResultSet(ResultSet result) {
    try {
      int id = result.getInt("admin_id");
      String username = result.getString("username");
      String salt = result.getString("salt");
      String passwordHash = result.getString("password");

      return new Admin(
        id,
        username,
        salt,
        passwordHash
      );
    } catch (SQLException e) {
      return null;
    }
  }
}
