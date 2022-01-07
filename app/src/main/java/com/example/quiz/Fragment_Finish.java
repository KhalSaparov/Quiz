package com.example.quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fragment_Finish extends Fragment {

    private TextView finishTextView;
    private EditText finishEditText;
    private Button finishBackButton, finishSaveButton;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_finish, container, false);
        init(v);

        String score = ((MainActivity)getActivity()).getScore();
        finishTextView.setText(score);

        finishSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = finishEditText.getText().toString();
                SaveUser saveUser = new SaveUser(name, score);
                mDataBase.push().setValue(saveUser);
                Toast.makeText(getContext().getApplicationContext(), "User saved", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).changeFragment(0);
            }
        });

        finishBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment(0);
            }
        });

        return v;
    }

    public void init(View v){
        finishTextView = v.findViewById(R.id.finish_TextView);
        finishEditText = v.findViewById(R.id.finish_EditText);
        finishBackButton = v.findViewById(R.id.finish_back);
        finishSaveButton = v.findViewById(R.id.finish_save);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }
}