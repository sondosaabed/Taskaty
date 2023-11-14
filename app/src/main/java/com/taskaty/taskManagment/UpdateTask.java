package com.taskaty.taskManagment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.informational.CompletedTask;
import com.taskaty.informational.UpdatedTask;

import java.util.Calendar;

/*
    I have created this activity to enable the user to update an existing task, for example to set it as done
 */
public class UpdateTask extends AppCompatActivity {
    Button update;
    EditText title;
    EditText description;
    Button updateDate;
    EditText date;
    Spinner categorySpinner;
    CheckBox isDone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setIsDone(findViewById(R.id.isDone));

        handle_date(getUpdateDate());
        handle_add(getUpdate());
    }

    /*
        Buttons Handlers
     */
    private void handle_date(Button date){
        date.setOnClickListener(view->{
            /*
                https://www.geeksforgeeks.org/datepicker-in-android/
             */
            final Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    UpdateTask.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            getDate().setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }
                    ,year, month, day);
            datePickerDialog.show();
        });
    }
    private void handle_add(Button update){
        update.setOnClickListener(view->{
            Intent intent = null;
            if(getIsDone().isChecked()){
                intent = new Intent(this, CompletedTask.class);
            } else if (!getIsDone().isChecked()) {
                intent = new Intent(this, UpdatedTask.class);
            }
            startActivity(intent);
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

    public void setIsDone(CheckBox isDone) {
        this.isDone = isDone;
    }

    public CheckBox getIsDone() {
        return isDone;
    }
}
