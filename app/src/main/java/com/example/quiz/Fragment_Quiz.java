package com.example.quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz.entity.Question;
import com.example.quiz.entity.QuestionGenerate;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment_Quiz extends Fragment {

    private ArrayList<Question> quest = null;
    private Button button1, button2, button3, button4, nextButton, backButton;
    private TextView questionView;
    private int i = 0;

    private Integer trueResult = 0;
    private Integer falseResult = 0;
    private String trueFalseResult;

    private DatabaseReference mDataBase;
    private String QUESTION_KEY = "Questions";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz, container, false);

        button1 = (Button) v.findViewById(R.id.btn1);
        button2 = (Button) v.findViewById(R.id.btn2);
        button3 = (Button) v.findViewById(R.id.btn3);
        button4 = (Button) v.findViewById(R.id.btn4);
        nextButton = (Button) v.findViewById(R.id.buttonNext);
        backButton = (Button) v.findViewById(R.id.buttonBack);
        questionView = (TextView) v.findViewById(R.id.questionText);
        mDataBase = FirebaseDatabase.getInstance().getReference(QUESTION_KEY);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            }
        }, 5000); //specify the number of milliseconds

        getFromData();

        Log.i(TAG_QUEST, "Quest in onCreatView" + quest);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;

                changeQuestionsAnswers(i);
                button1.setBackgroundColor(getResources().getColor(R.color.blue));
                button2.setBackgroundColor(getResources().getColor(R.color.blue));
                button3.setBackgroundColor(getResources().getColor(R.color.blue));
                button4.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).changeFragment(0);
            }
        });

        return v;
    }

    public void changeQuestionsAnswers(int i){
        switch(i){
            case 0:
                changeQA(0);
                break;
            case 1:
                changeQA(1);
                break;
            case 2:
                changeQA(2);
                break;
            case 3:
                changeQA(3);
                break;
            case 4:
                changeQA(4);
                break;
            case 5:
                changeQA(5);
                break;
            case 6:
                changeQA(6);
                break;
            case 7:
                changeQA(7);
                break;
            case 8:
                changeQA(8);
                break;
            case 9:
                changeQA(9);
                break;
            default:
                ((MainActivity)getActivity()).changeFragment(3);
                ((MainActivity)getActivity()).saveScore(trueFalseResult);
                break;
        }
    }

    public void changeQA(int q){
        questionView.setText(quest.get(q).getTextQuestion());
        button1.setText(quest.get(q).getAnswers().get(0).getTextAns());
        button2.setText(quest.get(q).getAnswers().get(1).getTextAns());
        button3.setText(quest.get(q).getAnswers().get(2).getTextAns());
        button4.setText(quest.get(q).getAnswers().get(3).getTextAns());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuestionGenerate.generate().get(q).getAnswers().get(0).isRight() == true){
                    button1.setBackgroundColor(getResources().getColor(R.color.green));
                    quizResult(true);
                }
                else {
                    button1.setBackgroundColor(getResources().getColor(R.color.red));
                    quizResult(false);
                }
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuestionGenerate.generate().get(q).getAnswers().get(1).isRight() == true){
                    button2.setBackgroundColor(getResources().getColor(R.color.green));
                    quizResult(true);
                }
                else {
                    button2.setBackgroundColor(getResources().getColor(R.color.red));
                    quizResult(false);
                }
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuestionGenerate.generate().get(q).getAnswers().get(2).isRight() == true){
                    button3.setBackgroundColor(getResources().getColor(R.color.green));
                    quizResult(true);
                }
                else {
                    button3.setBackgroundColor(getResources().getColor(R.color.red));
                    quizResult(false);
                }
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuestionGenerate.generate().get(q).getAnswers().get(3).isRight() == true){
                    button4.setBackgroundColor(getResources().getColor(R.color.green));
                    quizResult(true);
                }
                else {
                    button4.setBackgroundColor(getResources().getColor(R.color.red));
                    quizResult(false);
                }
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
            }
        });
    }

    public String quizResult(boolean result){
        if(result == true){
            trueResult = trueResult + 1;
        }
        if(result == false){
            falseResult = falseResult + 1;
        }
        trueFalseResult = "Correct answer: " + trueResult.toString() + "\n" + "Uncorrect answer: " + falseResult.toString();
        return trueFalseResult;
    }

    private static final String TAG_QUESTION = "Question";
    private static final String TAG_QUEST = "Quest";

    private void getFromData(){
        Query query = mDataBase.orderByKey();
        quest = new ArrayList<>();

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(quest.size() > 0){
                    quest.clear();
                }
                for (DataSnapshot ds : snapshot.getChildren()){
                    Question question = ds.getValue(Question.class);
                    assert question != null;
                    quest.add(new Question(question.getTextQuestion(), question.getAnswers()));
                    changeQuestionsAnswers(0);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Log.i(TAG_QUESTION, "Questiondata out for" + quest.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        query.addValueEventListener(valueEventListener);
    }
}