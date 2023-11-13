package com.taskaty;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
    This is the main app activity
 */
public class Home extends AppCompatActivity{
    ImageButton add;
    ListView tasks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        setContentView(R.layout.home);
        setAdd(findViewById(R.id.add));
        setTasks(findViewById(R.id.taskListView));
        handle_add(getAdd());
    }

    private void handle_add(ImageButton add) {
        add.setOnClickListener(veiw->{
            Intent intent = new Intent(this, AddNewTask.class);
            startActivity(intent);
        });
    }

    /*
        Getters & Setters
     */
    public void setAdd(ImageButton add) {
        this.add = add;
    }

    public ImageButton getAdd() {
        return add;
    }

    public void setTasks(ListView tasks) {
        this.tasks = tasks;
    }
}
