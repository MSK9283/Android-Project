package com.example.umore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class SettingActivity extends AppCompatActivity {
    ImageView back_button;
    Button setDailyQuizTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_setting);

        back_button = findViewById(R.id.setting_backbutton);
        setDailyQuizTime = findViewById(R.id.setting_DailyQuizTime);

        setDailyQuizTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetDailyQuizTime temp = new SetDailyQuizTime();
                temp.show(getSupportFragmentManager(), "Edit Notification Time");
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}