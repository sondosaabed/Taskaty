package com.taskaty.taskManagment;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.model.Task;
import com.taskaty.model.Tasks;

/*
    This is the main app activity that shows the tasks list
 */
public class TasksList extends AppCompatActivity{
    /*
        Attributes
    */
    ImageButton add;
    ListView tasksVeiw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        getSupportActionBar().hide();
        setContentView(R.layout.tasks_list);

        setAdd(findViewById(R.id.add));
        setTasks(findViewById(R.id.taskListView));

        ArrayAdapter<Task> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                Tasks.getTasks());

        getTasks().setAdapter(listAdapter);

        handle_add(getAdd());
        handle_taskClick(getTasks());
    }

    private void handle_taskClick(ListView tasks) {
        /*
        When a user clicks on a list item they are allowed to edit it
         */
        tasks.setOnItemClickListener((parent, view, position, id) -> {
            Task selectedTask = Tasks.getTasks().get(position);
            /*
                TODO I must make sure this is right
             */
            Intent intent = new Intent(this, UpdateTask.class);
            intent.putExtra("selectedTaskID", selectedTask.getId());
            startActivity(intent);
        });
    }

    private void handle_add(ImageButton add) {
        /*
            When the user clicks Add, the user is able to fill a form and add a new one
         */
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
        this.tasksVeiw = tasks;
    }
    public ListView getTasks() {
        return tasksVeiw;
    }
}
