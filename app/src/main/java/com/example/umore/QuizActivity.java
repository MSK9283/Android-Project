package com.example.umore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    RecyclerView quizHolder;
    Button SubmitButton;
    List<quizItem> listOfQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_setting);

        setContentView(R.layout.activity_quiz);

        quizHolder = findViewById(R.id.quizRecycler);
        SubmitButton = findViewById(R.id.submitQuiz);

        quizHolder.setHasFixedSize(true);
        RecyclerView.LayoutManager quizLayoutManager = new LinearLayoutManager(this);
        quizAdapter adapter = new quizAdapter((ArrayList<quizItem>) listOfQuestions);

        quizHolder.setLayoutManager(quizLayoutManager);
        quizHolder.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            listOfQuestions.add(new quizItem("" + i, 0));
        }

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollectQuizResponse();
            }
        });

    }




    void CollectQuizResponse(){

    }
}