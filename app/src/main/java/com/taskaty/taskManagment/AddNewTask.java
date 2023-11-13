package com.taskaty.taskManagment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;

/*
    I have created this activity to enable the user to add a new task to their list
 */
public class AddNewTask extends AppCompatActivity {
    Button add;
    EditText title;
    EditText description;
    Button pickDate;
    EditText date;
    Spinner categorySpinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initialize();
    }

    private void initialize() {
        setContentView(R.layout.add_new_task);
        setAdd(findViewById(R.id.createTaskButton));
        setTitle((EditText) findViewById(R.id.titleEditText));
        setDescription(findViewById(R.id.descriptionEditText));
        setDate(findViewById(R.id.dateEditText));
        setCategorySpinner(findViewById(R.id.categorySpinner));
        setPickDate(findViewById(R.id.pickDate));
        handle_date(getPickDate());
        handle_add(getAdd());
    }

    /*
        Buttons Handlers
     */
    private void handle_date(Button date){
        date.setOnClickListener(view->{

        });
    }
    private void handle_add(Button add){
        add.setOnClickListener(view->{

        });
    }
    /*
        Getters & Setters
     */
    public void setAdd(Button add) {
        this.add= add;
    }
    public Button getAdd() {
        return add;
    }
    public void setTitle(EditText title) {
        this.title = title;
    }
    public EditText gettitle() {
        return title;
    }
    public void setDescription(EditText description) {
        this.description = description;
    }
    public EditText getDescription() {
        return description;
    }
    public void setDate(EditText date) {
        this.date = date;
    }
    public EditText getDate() {
        return date;
    }
    public Spinner getCategorySpinner() {
        return categorySpinner;
    }
    public void setCategorySpinner(Spinner categorySpinner) {
        this.categorySpinner = categorySpinner;
    }
    public Button getPickDate() {
        return pickDate;
    }

    public void setPickDate(Button pickDate) {
        this.pickDate = pickDate;
    }
}
