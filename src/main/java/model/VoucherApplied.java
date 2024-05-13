package model;

import java.time.LocalDate;

public class VoucherApplied extends Voucher {
  private String status;
  private LocalDate applicationDate;

  public VoucherApplied(int id, String title, Float amount, String category, String description, LocalDate deadline, String status, LocalDate applicationDate) {
    super(id, title, amount, category, description, deadline);
    this.status = status;
    this.applicationDate = applicationDate;
  }

  public String getStatus() {
    return status;
  }

  public LocalDate getApplicationDate() {
    return applicationDate;
  }
}
