package com.taskaty.informational;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.taskManagment.Home;

public class StatusInform extends AppCompatActivity {
    /*
        I have created this activity becaue I have noticed in my prev. code that there could be some kind of template
        since they all have the same functionalities so the idea of this class is to make cleaner code
     */
    Button back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String status = getIntent().getStringExtra("status");
        initialize(status);
    }

    private void initialize(String status) {
        if(status.equals("completed")){
            setContentView(R.layout.completed);
        } else if (status.equals("updated")) {
            setContentView(R.layout.updated);
        } else if (status.equals("added")) {
            setContentView(R.layout.added);
        }
        setBack(findViewById(R.id.backHome));
        handle_back(getBack());
    }

    private void handle_back(Button back) {
        back.setOnClickListener(veiw ->{
            Intent intent = new Intent(this, Home.class);
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
