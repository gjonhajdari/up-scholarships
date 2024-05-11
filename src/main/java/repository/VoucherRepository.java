package repository;

import model.dto.CreateVoucherDto;
import service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
