package com.taskaty.taskManagment;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.informational.StatusInform;
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
    Button search;
    ListView tasksVeiw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        setContentView(R.layout.tasks_list);

        setAdd(findViewById(R.id.add));
        setTasks(findViewById(R.id.taskListView));
        setSearch(findViewById(R.id.search));

        ArrayAdapter<Task> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                Tasks.getTaskaty());
        getTasks().setAdapter(listAdapter);

        handle_add(getAdd());
        handle_taskClick(getTasks());
        handle_search(getSearch());
    }

    private void handle_search(Button search) {
        /*
            When a user searches for a task by it's name
            - if it's not found the status inform of not found will be shown
         */
        search.setOnClickListener(veiw->{
            if(Tasks.findByname("name")==-1){
                Intent intent = new Intent(this, StatusInform.class);
                intent.putExtra("status", "not_found");
                startActivity(intent);
            }else{
                /*
                I either show a list or highlight the list
                 */
            }
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
    public Button getSearch() {
        return search;
    }
    public void setSearch(Button search) {
        this.search = search;
    }
}
