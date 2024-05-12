package model;

import java.time.LocalDate;

public class Application {

    private int appId;
    private int stdId;
    private int vouchId;
    private LocalDate appDate;
    private String status;

    public Application(int appId, int stdId, int vouchId,String status){
        this.appId=appId;
        this.stdId=stdId;
        this.vouchId=vouchId;
        this.appDate= LocalDate.now();
        this.status=status;
    }
    public int getAppId(){
        return appId;
    }
    public int getStdId(){
        return stdId;
    }
    public int getVouchId(){
        return vouchId;
    }
    public LocalDate getAppDate(){
        return appDate;
    }

    public String getStatus(){
        return status;
    }
}
