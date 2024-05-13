package model;

import java.time.LocalDate;

public class VoucherApplied extends Voucher {
  private int applicationId;
  private String status;
  private LocalDate applicationDate;

  public VoucherApplied(int id, String title, Float amount, String category, String description, LocalDate deadline, int applicationId, String status, LocalDate applicationDate) {
    super(id, title, amount, category, description, deadline);
    this.applicationId = applicationId;
    this.status = status;
    this.applicationDate = applicationDate;
  }

  public int getApplicationId() {
    return applicationId;
  }

  public String getStatus() {
    return status;
  }

  public LocalDate getApplicationDate() {
    return applicationDate;
  }
}
