package com.taskaty.informational;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.taskManagment.TasksList;
/*
    I have created this activity becaue I have noticed in my prev. code that there could be some kind of template
    since they all have the same functionalities so the idea of this class is to make cleaner code
 */
public class StatusInform extends AppCompatActivity {
        /*
        Attributes
     */
    Button back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String status = getIntent().getStringExtra("status");
        if (status != null)
            initialize(status);
    }

    private void initialize(@NonNull String status) {
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        // Based on the status the status layout will be shown
        /*
            replaced to switch sugeested by android studio
         */
        switch (status) {
            case "completed":
                setContentView(R.layout.completed);
                break;
            case "updated":
                setContentView(R.layout.edited);
                break;
            case "added":
                setContentView(R.layout.added);
                break;
        }
        setBack(findViewById(R.id.backHome));
        handle_back(getBack());
    }

    private void handle_back(Button back) {
        /*
            When the back button is clicked get back to the main which is TasksList
         */
        back.setOnClickListener(veiw ->{
            Intent intent = new Intent(this, TasksList.class);
            startActivity(intent);
        });
    }

    /*
        Getters & Setters
     */
    public void setBack(Button back) {
        this.back = back;
    }

    public Button getBack() {
        return back;
    }
}
