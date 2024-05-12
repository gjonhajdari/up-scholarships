package model;

import java.time.LocalDate;

public class ApplicantWithData {
  private int id;
  private String studentId;
  private String firstName;
  private String lastName;
  private String status;
  private LocalDate applicationDate;

  public ApplicantWithData(int id, String studentId, String firstName, String lastName, String status, LocalDate applicationDate) {
    this.id = id;
    this.studentId = studentId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
    this.applicationDate = applicationDate;
  }

  public int getId() {
    return id;
  }

  public String getStudentId() {
    return studentId;
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

  public void setStatus(String status) {
    this.status = status;
  }
}
