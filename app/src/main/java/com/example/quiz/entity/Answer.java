package com.example.quiz.entity;

public class Answer {
    private String textAns;
    private boolean right;

    public Answer() {
    }

    public Answer(String textAns, boolean right) {
        this.textAns = textAns;
        this.right = right;
    }

    public String getTextAns() {
        return textAns;
    }

    public void setTextAns(String textAns) {
        this.textAns = textAns;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "textAns='" + textAns + '\'' +
                ", right=" + right +
                '}';
    }
}
