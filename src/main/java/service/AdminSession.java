package service;

import model.Admin;

public class AdminSession {
    private static Admin admin;

    public static void setAdminSession(Admin newAdmin) { admin = newAdmin; }

    public static Admin getAdmin() { return admin; }

    public static void clearAdminSession() { admin = null; }
}
