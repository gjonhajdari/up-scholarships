package service;

import model.VoucherApplied;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FilterService {
  public static List<VoucherApplied> filterLastWeek(List<VoucherApplied> vouchers) {
    return vouchers.stream()
            .filter(voucher -> voucher.getApplicationDate().isAfter(LocalDate.now().minusWeeks(1)))
            .collect(Collectors.toList());
  }

  public static List<VoucherApplied> filterLastMonth(List<VoucherApplied> vouchers) {
    return vouchers.stream()
            .filter(voucher -> voucher.getApplicationDate().isAfter(LocalDate.now().minusMonths(1)))
            .collect(Collectors.toList());
  }

  public static List<VoucherApplied> filterLastYear(List<VoucherApplied> vouchers) {
    return vouchers.stream()
            .filter(voucher -> voucher.getApplicationDate().isAfter(LocalDate.now().minusYears(1)))
            .collect(Collectors.toList());
  }
}
