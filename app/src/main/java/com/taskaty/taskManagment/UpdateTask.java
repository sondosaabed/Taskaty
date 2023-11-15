package com.taskaty.taskManagment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.informational.StatusInform;
import com.taskaty.model.Task;
import com.taskaty.model.Tasks;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
    I have created this activity to enable the user to update an existing task, for example to set it as done
 */
public class UpdateTask extends AppCompatActivity {
    /*
        Attributes
    */
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
        String selectedTaskID = getIntent().getStringExtra("selectedTaskID");
        initialize(selectedTaskID);
    }

    private void initialize(String selectedTaskID) {
        getSupportActionBar().hide();
        setContentView(R.layout.update_task);

        setUpdate(findViewById(R.id.updateTaskButton));
        setUpdateDate(findViewById(R.id.uodateDate));

        setTitle((EditText) findViewById(R.id.titleEditTextUpdate));
        setDescription(findViewById(R.id.descriptionEditTextUpdate));
        setDate(findViewById(R.id.dateEditTextUpdate));
        setCategorySpinner(findViewById(R.id.categorySpinnerUpdate));
        setIsDone(findViewById(R.id.isDone));

        handle_date(getUpdateDate());
        handle_update(getUpdate(), selectedTaskID);

        setValuesToBeUpdated();
    }

    private void setValuesToBeUpdated() {
        /*
            TODO
             When the usre wants to update a task it's previous values should be there
             I will add them next step
         */
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
                    /*
                        replaced by lamda suggested by android studio
                     */
                    (view1, year1, month1, dayOfMonth) -> {
                        String datestr = dayOfMonth + "-" + (month1 + 1) + "-" + year1 ;
                        getDate().setText(datestr);
                    }
                    ,year, month, day);
            datePickerDialog.show();
        });
    }

    private void handle_update(Button update, String selectedTaskID){
        update.setOnClickListener(view->{
            /*
                Handling the date as a string
             */
            String dateStr = getDate().getText().toString().trim();
            String[] dateElments = dateStr.split("-");

            int year= Integer.parseInt(dateElments[2]);
            int month = Integer.parseInt(dateElments[1]);
            int day = Integer.parseInt(dateElments[0]);

            GregorianCalendar date = new GregorianCalendar(day,month,year);
            Task updatedtask = new Task(getTitle().toString().trim(),
                                        getDescription().toString().trim(),
                                        getCategorySpinner().getSelectedItem().toString(),
                                        date);

            Tasks.updateTask(Integer.parseInt(selectedTaskID), updatedtask);
            /*
                Status information to the user
             */
            Intent intent = null;
            if(getIsDone().isChecked()){
                intent = new Intent(this, StatusInform.class);
                intent.putExtra("status", "completed");
            } else if (!getIsDone().isChecked()) {
                intent = new Intent(this, StatusInform.class);
                intent.putExtra("status", "updated");
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
