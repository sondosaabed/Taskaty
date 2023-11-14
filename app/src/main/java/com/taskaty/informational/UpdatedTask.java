package com.taskaty.informational;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import com.taskaty.R;
import com.taskaty.taskManagment.Home;

public class UpdatedTask extends AppCompatActivity {
    Button back;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        setContentView(R.layout.updated);
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
