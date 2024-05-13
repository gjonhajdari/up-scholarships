package utils;

import service.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
  public interface ResultHandler<T> {
    T handle(ResultSet rs) throws SQLException;
  }

  public static <T> List<T> executeSelect(String query, ResultHandler<T> handler, Object... params) {
    List<T> results = new ArrayList<>();

    try {
      Connection connection = ConnectionUtil.getConnection();
      ResultSet rs;

      if (params.length > 0) {
        PreparedStatement pst = connection.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
          pst.setObject(i + 1, params[i]);
        }

        rs = pst.executeQuery();
      } else {
        Statement st = connection.createStatement();
        rs = st.executeQuery(query);
      }

      while (rs.next()) {
        results.add(handler.handle(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        ConnectionUtil.getConnection().close();
      } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    return results;
  }


  public static boolean executeUpdate(String query, Object... params) {
    try {
      Connection connection = ConnectionUtil.getConnection();
      PreparedStatement pst = connection.prepareStatement(query);

      for (int i = 0; i < params.length; i++) {
        pst.setObject(i + 1, params[i]);
      }

      int rowsAffected = pst.executeUpdate();
      return rowsAffected > 0;
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


  public static <T> T getFirstItem(String query, ResultHandler<T> handler, Object... params) {
    List<T> items = executeSelect(query, handler, params);
    return items.isEmpty() ? null : items.getFirst();
  }
}
