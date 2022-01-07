package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    public String getScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new Fragment_Menu();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment, null)
                    .commit();
        }
    }

    public void changeFragment(int item){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        switch (item){
            case 0:
                fragment = new Fragment_Menu();
                break;
            case 1:
                fragment = new Fragment_Quiz();
                break;
            case 2:
                fragment = new Fragment_Rating();
                break;
            case 3:
                fragment = new Fragment_Finish();
                break;
        }
        fm.beginTransaction()
                .replace(R.id.fragment_container, fragment, null)
                .commit();
    }

    @Override
    public void onBackPressed() {
            changeFragment(0);
    }

    public void saveScore(String saveScore){
        getScore = saveScore;
    }

    public String getScore(){
        return getScore;
    }
}

