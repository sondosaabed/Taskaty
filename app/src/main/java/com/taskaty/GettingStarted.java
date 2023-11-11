package com.taskaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
        initialize();
    }

    private void initialize() {
        getSupportActionBar().hide();
        setContentView(R.layout.getting_started);
        setStart(findViewById(R.id.start));
        handle_start(getStart());
    }

    private void handle_start(Button start) {
        start.setOnClickListener(view -> {
            Intent intent = new Intent(this, Home.class);
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
