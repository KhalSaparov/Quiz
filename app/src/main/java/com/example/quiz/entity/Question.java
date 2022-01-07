package com.example.quiz.entity;

import java.util.List;

public class Question {
    private String textQuestion;
    private List<Answer> answers;
//    String answer1;
//    String answer2;
//    String answer3;
//    String answer4;
//    String right;

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

    //    public Question(String textQuestion, String answer1, String answer2, String answer3, String answer4, String right) {
//        this.textQuestion = textQuestion;
//        this.answer1 = answer1;
//        this.answer2 = answer2;
//        this.answer3 = answer3;
//        this.answer4 = answer4;
//        this.right = right;
//    }
//
//    public String getTextQuestion() {
//        return textQuestion;
//    }
//
//    public void setTextQuestion(String textQuestion) {
//        this.textQuestion = textQuestion;
//    }
//
//    public String getAnswer1() {
//        return answer1;
//    }
//
//    public void setAnswer1(String answer1) {
//        this.answer1 = answer1;
//    }
//
//    public String getAnswer2() {
//        return answer2;
//    }
//
//    public void setAnswer2(String answer2) {
//        this.answer2 = answer2;
//    }
//
//    public String getAnswer3() {
//        return answer3;
//    }
//
//    public void setAnswer3(String answer3) {
//        this.answer3 = answer3;
//    }
//
//    public String getAnswer4() {
//        return answer4;
//    }
//
//    public void setAnswer4(String answer4) {
//        this.answer4 = answer4;
//    }
//
//    public String getRight() {
//        return right;
//    }
//
//    public void setRight(String right) {
//        this.right = right;
//    }

    @Override
    public String toString() {
        return "Question{" +
                "textQuestion='" + textQuestion + '\'' +
                ", answers=" + answers +
                '}';
    }
}
