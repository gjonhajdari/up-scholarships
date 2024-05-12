package repository;

import model.Voucher;
import model.dto.CreateVoucherDto;
import service.ConnectionUtil;
import service.Formatter;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoucherRepository {
  public static boolean create(CreateVoucherDto voucherData) {
    String query = "INSERT INTO voucher (title, amount, deadline, category, description) VALUES (?, ?, ?, ?, ?)";

    try {
      Connection connection = ConnectionUtil.getConnection();
      PreparedStatement pst = connection.prepareStatement(query);
      pst.setString(1, voucherData.getTitle());
      pst.setFloat(2, voucherData.getAmount());
      pst.setDate(3, voucherData.getDeadline());
      pst.setString(4, voucherData.getCategory());
      pst.setString(5, voucherData.getDescription());
      pst.execute();

      return true;
    } catch (Exception e) {
      return false;
    } finally {
      try {
        ConnectionUtil.getConnection().close();
      } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }


  public static boolean apply(int voucherId, String studentId) {
    String query = "INSERT INTO application (voucher_id, student_id) VALUES (?, ?)";

    try {
      Connection connection = ConnectionUtil.getConnection();
      PreparedStatement pst = connection.prepareStatement(query);
      pst.setInt(1, voucherId);
      pst.setString(2, studentId);
      pst.execute();

      return true;
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    } finally {
      try {
        ConnectionUtil.getConnection().close();
      } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }


  public static List<Voucher> getAll() {
    String query = "SELECT * FROM voucher";
    return getVouchers(query);
  }

  
  public static List<Voucher> getAllValid(String studentId) {
    String query = """
            SELECT * FROM voucher
              WHERE voucher.voucher_id NOT IN (
                  SELECT application.voucher_id FROM application
                  WHERE application.student_id = ?
                )
            AND deadline > CURDATE();
            """;

    return getVouchers(query, studentId);
  }


  private static List<Voucher> getApplicants(int voucherId) {
    String query = """
            SELECT * FROM voucher
            JOIN application ON voucher.voucher_id = application.voucher_id
            WHERE voucher.voucher_id = ?
            """;

    return getVouchers(query, voucherId);
  }


  public static Voucher getById(int id) {
    String query = "SELECT * FROM voucher WHERE voucher_id = ?";
    return getVoucher(query, id);
  }


  private static List<Voucher> getVouchers(String query, Object... params) {
    List<Voucher> vouchers = new ArrayList<>();

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
        vouchers.add(getFromResultSet(rs));

    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      try {
        ConnectionUtil.getConnection().close();
      } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    return vouchers;
  }


  private static Voucher getVoucher(String query, Object... params) {
    List<Voucher> vouchers = getVouchers(query, params);
    return vouchers.isEmpty() ? null : vouchers.get(0);
  }


  private static Voucher getFromResultSet(ResultSet resultSet) throws SQLException {
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
}
