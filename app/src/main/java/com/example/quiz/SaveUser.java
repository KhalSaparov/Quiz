package com.example.quiz;

public class SaveUser {
    private String userName;
    private String score;

    public SaveUser() {
    }

    public SaveUser(String userName, String score) {
        this.userName = userName;
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public String getScore() {
        return score;
    }
}
