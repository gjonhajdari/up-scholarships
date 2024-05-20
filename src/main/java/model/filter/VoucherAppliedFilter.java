package model.filter;

public class VoucherAppliedFilter extends Filter {
  public enum Duration { WEEK, MONTH, YEAR, ALL }
  private Duration duration;

  public VoucherAppliedFilter(Duration duration) {
    this.duration = duration;
  }

  public void setDuration(Duration duration) {
    this.duration = duration;
  }

  public String buildQuery() {
    String query = "";
    switch (this.duration) {
      case WEEK:
        query += " AND application.application_date >= DATE_SUB(NOW(), INTERVAL 1 WEEK)";
        break;
      case MONTH:
        query += " AND application.application_date >= DATE_SUB(NOW(), INTERVAL 1 MONTH)";
        break;
      case YEAR:
        query += " AND application.application_date >= DATE_SUB(NOW(), INTERVAL 1 YEAR)";
        break;
      case ALL:
        break;
    }
    return query;
  }
}
