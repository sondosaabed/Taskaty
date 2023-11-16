package com.taskaty.informational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.taskaty.model.Preferences;
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
        if (Preferences.isFirstTime(this)) {
            Preferences.setNotFirstTime(this);
            setContentView(R.layout.getting_started);
            initialize();
        } else {
            startActivity(new Intent(this, WelcomeBack.class));
            finish();
        }
    }

    private void initialize() {
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        setContentView(R.layout.getting_started);
        setStart(findViewById(R.id.start));
        handle_start(getStart());
    }

    private void handle_start(Button start) {
        /*
            When the start button is clicked show the main tasks list
               It will contain two sample task I added
         */
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
