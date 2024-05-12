package model;

import java.time.LocalDate;

public class ApplicantWithData {
  private String id;
  private String firstName;
  private String lastName;
  private String status;
  private LocalDate applicationDate;

  public ApplicantWithData(String id, String firstName, String lastName, String status, LocalDate applicationDate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
    this.applicationDate = applicationDate;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getStatus() {
    return status;
  }

  public LocalDate getApplicationDate() {
    return applicationDate;
  }
}
