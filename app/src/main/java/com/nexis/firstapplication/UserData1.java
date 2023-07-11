package com.nexis.firstapplication;

public class UserData1 {
    private static UserData1 instance;
    private String userInput;

    private UserData1() {}

    public static synchronized UserData1 getInstance() {
        if (instance == null) {
            instance = new UserData1();
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
