package com.taskaty.taskManagment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.informational.StatusInform;
import com.taskaty.model.Task;
import com.taskaty.model.Tasks;

import java.util.ArrayList;

/*
    I have created this activity to enable the user to search for existing tasks
    Using diffrent attributes:
    - If the name contains a keyword
    - If in a specific month
    - If have a specific category
 */
public class FindTasks extends AppCompatActivity {
    /*
        Attributes
    */
    Button search;
    EditText keyword;
    Spinner month;
    Spinner categorySpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        setContentView(R.layout.search);
        setSearch(findViewById(R.id.search));
        setKeyword(findViewById(R.id.keyword));
        setMonth(findViewById(R.id.monthSpinner));
        setCategorySpinner(findViewById(R.id.categorySpinner2));

        handle_serach(getSearch());
    }
    /*
        Buttons Handlers
     */
    private void handle_serach(Button search) {
        search.setOnClickListener(vewi->{
            ArrayList<Task> foundtasks = Tasks.search(getKeyword().getText().toString(),
                    getMonth().getSelectedItem().toString(),
                    getCategorySpinner().getSelectedItem().toString());

            if(foundtasks.size()!=0){
                Intent intent = new Intent(this, FoundTasks.class);
                intent.putExtra("keyword",getKeyword().getText().toString());
                intent.putExtra("month",getMonth().getSelectedItem().toString());
                intent.putExtra("category",getCategorySpinner().getSelectedItem().toString());
                startActivity(intent);
            }else{
                Intent intent = new Intent(this, StatusInform.class);
                intent.putExtra("status", "not_found");
                startActivity(intent);
            }
        });
    }
    /*
        Getters & Setters
     */
    public Button getSearch() {
        return search;
    }
    public void setSearch(Button search) {
        this.search = search;
    }
    public EditText getKeyword() {
        return keyword;
    }
    public void setKeyword(EditText keyword) {
        this.keyword = keyword;
    }
    public Spinner getMonth() {
        return month;
    }
    public void setMonth(Spinner month) {
        this.month = month;
    }
    public Spinner getCategorySpinner() {
        return categorySpinner;
    }
    public void setCategorySpinner(Spinner categorySpinner) {
        this.categorySpinner = categorySpinner;
    }
}
