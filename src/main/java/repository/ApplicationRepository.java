package repository;

import model.Application;
import utils.DatabaseUtils;
import utils.ResultSetUtils;

public class ApplicationRepository {
  public static boolean updateStatus(int applicationId, String status) {
    String query = "UPDATE application SET status = ? WHERE application_id = ?";
    return DatabaseUtils.executeUpdate(query, status, applicationId);
  }


  private static Application getApplication(String query, Object... params) {
    return DatabaseUtils.getOne(query, ResultSetUtils::ApplicationResultSet, params);
  }
}
