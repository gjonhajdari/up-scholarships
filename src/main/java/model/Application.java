package model;

import java.time.LocalDate;

public class Application {
    private int id;
    private String studentId;
    private int vouchId;
    private String status;
    private LocalDate appDate;

    public Application(int id, String studentId, int vouchId, String status, LocalDate appDate) {
        this.id = id;
        this.studentId = studentId;
        this.vouchId = vouchId;
        this.status = status;
        this.appDate = appDate;
    }

    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getVouchId() {
        return vouchId;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAppDate() {
        return appDate;
    }
}
