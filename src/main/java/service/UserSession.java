package service;

import model.User;

public class UserSession {
    private static User user;

    public static void setUserSession(User newUser) { user = newUser; }

    public static User getUser() { return user; }

    public static void clearUserSession() { user = null; }
}
