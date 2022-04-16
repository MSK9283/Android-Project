package com.example.umore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class SetWorkWeek extends DialogFragment {

    public TimePicker timePicker;
    public Button confirmButton;
    public Button cancelButton;

    SetWorkWeek temp = this;


    public SetWorkWeek() {
    }

    public SetWorkWeek(String CurrentQuizTime) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        timePicker = view.findViewById(R.id.ww_fromTime);
        confirmButton = view.findViewById(R.id.ww_confirm_button);
        cancelButton = view.findViewById(R.id.ww_cancel_Button);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp.dismiss();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_daily_quiz_time, container, false);
    }
}