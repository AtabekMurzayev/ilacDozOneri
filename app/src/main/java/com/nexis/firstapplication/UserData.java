package com.nexis.firstapplication;

public class UserData {
    private static UserData instance;
    private String userInput;

    private UserData() {}

    public static synchronized UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
