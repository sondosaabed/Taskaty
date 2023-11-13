package com.taskaty;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
    I have created this activity to enable the user to add a new task to their list
 */
public class UpdateTask extends AppCompatActivity {
    Button update;
    EditText title;
    EditText description;
    Button updateDate;
    EditText date;
    Spinner categorySpinner;

    @Override
    public void onCreate(Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initialize();
    }

    private void initialize() {
        setContentView(R.layout.update_task);

        setUpdate(findViewById(R.id.updateTaskButton));
        setTitle((EditText) findViewById(R.id.titleEditTextUpdate));
        setDescription(findViewById(R.id.descriptionEditTextUpdate));
        setDate(findViewById(R.id.dateEditTextUpdate));
        setCategorySpinner(findViewById(R.id.categorySpinnerUpdate));
        setUpdateDate(findViewById(R.id.uodateDate));

        handle_date(getUpdateDate());
        handle_add(getUpdate());
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

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public EditText getttitle() {
        return title;
    }

    public void setTitle(EditText title) {
        this.title = title;
    }

    public EditText getDescription() {
        return description;
    }

    public void setDescription(EditText description) {
        this.description = description;
    }

    public Button getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Button updateDate) {
        this.updateDate = updateDate;
    }

    public EditText getDate() {
        return date;
    }

    public void setDate(EditText date) {
        this.date = date;
    }

    public Spinner getCategorySpinner() {
        return categorySpinner;
    }

    public void setCategorySpinner(Spinner categorySpinner) {
        this.categorySpinner = categorySpinner;
    }
}
