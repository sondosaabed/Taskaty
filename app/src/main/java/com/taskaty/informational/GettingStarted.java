package com.taskaty.informational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.taskaty.taskManagment.TasksList;
import com.taskaty.R;

/*
    This is the starting activity of the mobile app, the user is able to
    start
 */
public class GettingStarted extends AppCompatActivity {
    /*
        Attributes
     */
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
            Check if it's the first time for the user using taskaty
            if so show them getting started otherwise show them welcome back
            for more personalized experience
         */
        if (isFirstTime()) {
            setNotFirstTime();
            setContentView(R.layout.getting_started);
            initialize();
        } else {
            startActivity(new Intent(this, WelcomeBack.class));
            finish();
        }
    }
    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        return preferences.getBoolean("is_first_time", true);
    }

    private void setNotFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("is_first_time", false);
        editor.apply();
    }

    private void initialize() {
        getSupportActionBar().hide();
        setContentView(R.layout.getting_started);
        setStart(findViewById(R.id.start));
        handle_start(getStart());
    }

    private void handle_start(Button start) {
        start.setOnClickListener(view -> {
            Intent intent = new Intent(this, TasksList.class);
            startActivity(intent);
        });
    }

    /*
        Getters & Setters
     */
    public Button getStart() {
        return start;
    }

    public void setStart(Button start) {
        this.start = start;
    }
}
