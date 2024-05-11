package service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateFormat {
  public static LocalDate convertFromDate(Date oldDate) {
    return Instant.ofEpochMilli(oldDate.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
  }
}
