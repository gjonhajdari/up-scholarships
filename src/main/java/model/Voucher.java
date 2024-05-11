package model;

import java.time.LocalDate;

public class Voucher {
  private int id;
  private String title;
  private Float amount;
  private String category;
  private String description;
  private LocalDate deadline;

  public Voucher(int id, String title, Float amount, String category, String description, LocalDate deadline) {
    this.id = id;
    this.title = title;
    this.amount = amount;
    this.category = category;
    this.description = description;
    this.deadline = deadline;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Float getAmount() {
    return amount;
  }

  public String getCategory() {
    return category;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDeadline() {
    return deadline;
  }
}
