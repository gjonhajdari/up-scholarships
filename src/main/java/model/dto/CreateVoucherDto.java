package model.dto;

import java.sql.Date;

public class CreateVoucherDto {
  private String title;
  private Float amount;
  private Date deadline;
  private String category;
  private String description;

  public CreateVoucherDto(String title, Float amount, Date deadline, String category, String description) {
    this.title = title;
    this.amount = amount;
    this.deadline = deadline;
    this.category = category;
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public Float getAmount() {
    return amount;
  }

  public Date getDeadline() {
    return deadline;
  }

  public String getCategory() {
    return category;
  }

  public String getDescription() {
    return description;
  }
}
