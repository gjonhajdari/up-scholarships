package repository;

import model.Voucher;
import model.dto.CreateVoucherDto;
import service.ConnectionUtil;
import service.DateFormat;

import java.sql.*;
import java.time.LocalDate;
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

    public static List<Voucher> getAll() {
      String query = "SELECT * FROM voucher";
      List<Voucher> vouchers = new ArrayList<>();

      try {
        Connection connection = ConnectionUtil.getConnection();
        Statement st = connection.createStatement();

        ResultSet resultSet = st.executeQuery(query);

        while (resultSet.next()) {
          vouchers.add(getFromResultSet(resultSet));
        }

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
          DateFormat.convertFromDate(deadline)
      );
    }
}
