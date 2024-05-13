package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Formatter {
  public static LocalDate convertFromDate(Date oldDate) {
    return Instant.ofEpochMilli(oldDate.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
  }

  public static String formatCurrency(float amount) {
    return String.format("%.2f", amount);
  }

  public static String formatDate(LocalDate date) {
    return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
  }
}
