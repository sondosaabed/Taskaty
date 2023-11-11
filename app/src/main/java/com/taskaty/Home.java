package com.taskaty;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
    This is the main app activity
 */
public class Home extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initialize();
    }

    private void initialize() {
        setContentView(R.layout.home);
    }
}
