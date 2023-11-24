package com.taskaty.taskManagment;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.model.Task;
import com.taskaty.model.Tasks;

import java.util.ArrayList;

/*
    This is the main app activity that shows the tasks list
 */
public class FoundTasks extends AppCompatActivity{
    /*
        Attributes
    */
    Button back;
    ListView tasksVeiw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        setContentView(R.layout.found_results);

        setTasks(findViewById(R.id.foundListView));
        setBack(findViewById(R.id.backHome2));

        ArrayList<Task> foundtasks = Tasks.search(getIntent().getStringExtra("keyword"),
                getIntent().getStringExtra("month"),
                getIntent().getStringExtra("category"));

        ArrayAdapter<Task> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                foundtasks);
        getTasks().setAdapter(listAdapter);

        handle_back(getBack());
        handle_taskClick(getTasks());
    }

    private void handle_back(Button back) {
        /*
         */
        back.setOnClickListener(veiw->{
            Intent intent = new Intent(this, TasksList.class);
            startActivity(intent);
        });
    }

    private void handle_taskClick(ListView tasks) {
        /*
            When a user clicks on a list item they are allowed to edit it
         */
        tasks.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, EditTask.class);
            intent.putExtra("selectedTaskID", position);
            startActivity(intent);
        });
    }

    /*
        Getters & Setters
     */
    public void setTasks(ListView tasks) {
        this.tasksVeiw = tasks;
    }
    public ListView getTasks() {
        return tasksVeiw;
    }
    public Button getBack() {
        return back;
    }
    public void setBack(Button back) {
        this.back = back;
    }
}
