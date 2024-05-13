package utils;

import model.ApplicantWithData;
import model.Voucher;
import model.VoucherApplied;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ResultSetUtils {
  public static Voucher getVoucherFromResultSet(ResultSet resultSet) throws SQLException {
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
  }

  public static VoucherApplied getVoucherAppliedFromResultSet(ResultSet resultSet) throws SQLException {
    int id = resultSet.getInt("voucher_id");
    String title = resultSet.getString("title");
    Float amount = resultSet.getFloat("amount");
    String category = resultSet.getString("category");
    String description = resultSet.getString("description");
    Date deadline = resultSet.getDate("deadline");
    String status = resultSet.getString("status");
    Date applicationDate = resultSet.getDate("application_date");

    return new VoucherApplied(
      id,
      title,
      amount,
      category,
      description,
      Formatter.convertFromDate(deadline),
      status,
      Formatter.convertFromDate(applicationDate)
    );
  }

  public static ApplicantWithData getApplicantFromResultSet(ResultSet resultSet) throws SQLException {
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
  }
}
