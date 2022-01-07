package com.example.quiz.entity;

import java.util.List;

public class Question {
    private String textQuestion;
    private List<Answer> answers;

    public Question() {
    }

    public Question(String textQuestion, List<Answer> answers) {
        this.textQuestion = textQuestion;
        this.answers = answers;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "textQuestion='" + textQuestion + '\'' +
                ", answers=" + answers +
                '}';
    }
}
