package com.example.quiz.entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionGenerate {

    public static List<Question> generate(){
        List<Question> questions = new ArrayList<>();

        List<Answer> answers1 = new ArrayList<>();
        Answer a11 = new Answer("Ashgabat", true);
        Answer a12 = new Answer("Baku", false);
        Answer a13 = new Answer("Tashkent", false);
        Answer a14 = new Answer("Abu Dhabi", false);

        answers1.add(a11);
        answers1.add(a12);
        answers1.add(a13);
        answers1.add(a14);

        List<Answer> answers2 = new ArrayList<>();
        Answer a21 = new Answer("Dubai", false);
        Answer a22 = new Answer("Washington D.C.", false);
        Answer a23 = new Answer("London", true);
        Answer a24 = new Answer("Paris", false);

        answers2.add(a21);
        answers2.add(a22);
        answers2.add(a23);
        answers2.add(a24);

        List<Answer> answers3 = new ArrayList<>();
        Answer a31 = new Answer("Gomel", false);
        Answer a32 = new Answer("Brest", false);
        Answer a33 = new Answer("Grodno", false);
        Answer a34 = new Answer("Minsk", true);

        answers3.add(a31);
        answers3.add(a32);
        answers3.add(a33);
        answers3.add(a34);

        List<Answer> answers4 = new ArrayList<>();
        Answer a41 = new Answer("Tashkent", true);
        Answer a42 = new Answer("Nursultan", false);
        Answer a43 = new Answer("Bishkek", false);
        Answer a44 = new Answer("Mary", false);

        answers4.add(a41);
        answers4.add(a42);
        answers4.add(a43);
        answers4.add(a44);

        List<Answer> answers5 = new ArrayList<>();
        Answer a51 = new Answer("Pilsen", false);
        Answer a52 = new Answer("Prague", true);
        Answer a53 = new Answer("Amsterdam", false);
        Answer a54 = new Answer("Wales", false);

        answers5.add(a51);
        answers5.add(a52);
        answers5.add(a53);
        answers5.add(a54);

        List<Answer> answers6 = new ArrayList<>();
        Answer a61 = new Answer("Abu Dhabi", true);
        Answer a62 = new Answer("Dubai", false);
        Answer a63 = new Answer("Islamabad", false);
        Answer a64 = new Answer("Istanbul", false);

        answers6.add(a61);
        answers6.add(a62);
        answers6.add(a63);
        answers6.add(a64);

        List<Answer> answers7 = new ArrayList<>();
        Answer a71 = new Answer("Los Angeles", false);
        Answer a72 = new Answer("Chicago", false);
        Answer a73 = new Answer("New York", false);
        Answer a74 = new Answer("Washington D.C.", true);

        answers7.add(a71);
        answers7.add(a72);
        answers7.add(a73);
        answers7.add(a74);

        List<Answer> answers8 = new ArrayList<>();
        Answer a81 = new Answer("Baku", true);
        Answer a82 = new Answer("Yerevan", false);
        Answer a83 = new Answer("Makhachkhala", false);
        Answer a84 = new Answer("Grozny", false);

        answers8.add(a81);
        answers8.add(a82);
        answers8.add(a83);
        answers8.add(a84);

        List<Answer> answers9 = new ArrayList<>();
        Answer a91 = new Answer("Istanbul", false);
        Answer a92 = new Answer("Ankara", true);
        Answer a93 = new Answer("Izmir", false);
        Answer a94 = new Answer("Antalya", false);

        answers9.add(a91);
        answers9.add(a92);
        answers9.add(a93);
        answers9.add(a94);

        List<Answer> answers10 = new ArrayList<>();
        Answer a101 = new Answer("Berlin", false);
        Answer a102 = new Answer("Riga", false);
        Answer a103 = new Answer("Vienna", true);
        Answer a104 = new Answer("Madrid", false);

        answers10.add(a101);
        answers10.add(a102);
        answers10.add(a103);
        answers10.add(a104);

        questions.add(new Question("The Capital of Turkmenistan?",answers1));
        questions.add(new Question("The Capital of Great Britain?",answers2));
        questions.add(new Question("The Capital of Belarus?",answers3));
        questions.add(new Question("The Capital of Uzbekistan?",answers4));
        questions.add(new Question("The Capital of Czech Republic?",answers5));
        questions.add(new Question("The Capital of UAE?",answers6));
        questions.add(new Question("The Capital of USA?",answers7));
        questions.add(new Question("The Capital of Azerbaijan?",answers8));
        questions.add(new Question("The Capital of Turkey?",answers9));
        questions.add(new Question("The Capital of Austria?",answers10));
        return questions;
    }

}
