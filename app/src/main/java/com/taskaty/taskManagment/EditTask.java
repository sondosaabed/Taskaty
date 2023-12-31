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

import java.time.LocalDate;
import java.util.Calendar;

/*
    I have created this activity to enable the user to update an existing task, for example to set it as done
 */
public class EditTask extends AppCompatActivity {
    /*
        Attributes
    */
    Button update;
    Button delete;
    EditText title;
    EditText description;
    Button updateDate;
    EditText date;
    Spinner categorySpinner;
    CheckBox isDone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int selectedTaskID = getIntent().getIntExtra("selectedTaskID", 0);
        initialize(selectedTaskID);
    }

    private void initialize(int selectedTaskID) {
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        setContentView(R.layout.edit_task);

        setUpdate(findViewById(R.id.updateTaskButton));
        setUpdateDate(findViewById(R.id.uodateDate));

        setTitle((EditText) findViewById(R.id.titleEditTextUpdate));
        setDescriptionn(findViewById(R.id.descriptionEditTextUpdate));
        setDate(findViewById(R.id.dateEditTextUpdate));
        setCategorySpinner(findViewById(R.id.categorySpinnerUpdate));
        setIsDone(findViewById(R.id.isDone));
        setDelete(findViewById(R.id.delete));

        handle_date(getUpdateDate());
        handle_update(getUpdate(), selectedTaskID);
        handle_delete(getDelete(), selectedTaskID);

        setValuesToBeUpdated(selectedTaskID);
    }

    private void handle_delete(Button delete, int selectedTaskID) {
        delete.setOnClickListener(veiw->{
            Tasks.deleteTask(selectedTaskID);

            Intent intent = new Intent(this, StatusInform.class);
            intent.putExtra("status", "deleted");
            startActivity(intent);
        });
    }

    private void setValuesToBeUpdated(int selectedTaskID) {
        /*
             In this method, When the usre wants to update a task it's previous values should be there
         */
        Task taskToUpdate = Tasks.getTaskaty().get(selectedTaskID);

        String title = taskToUpdate.getTittle();
        getTittle().setText(title);

        Boolean isDone = taskToUpdate.getDone();
        getIsDone().setChecked(isDone);

        String description = taskToUpdate.getDescription();
        getDescriptionn().setText(description);

        LocalDate date = taskToUpdate.getDueDate();
        String datStr ="";

        if(date != null){
            datStr = date.getDayOfMonth() +"-" +
                    date.getMonthValue() +"-"+
                    date.getYear();
        }
        if(!datStr.equals("0-0-0"))
            getDate().setText(datStr);
        else
            getDate().setText("");

        String category = taskToUpdate.getCategory();
        // I tried to use asList it only worked for api 34 so I had to iterate through an array
        String[] categories  = getResources().getStringArray(R.array.category_array);
        int index =0;
        for (int i = 0; i< categories.length; i++) {
            if(categories[i].equals(category)){
                index = i;
            }
        }
        getCategorySpinner().setSelection(index);
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
                    EditTask.this,
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

    private void handle_update(Button update, int selectedTaskID){
        update.setOnClickListener(view->{
            /*
                Handling the date as a string
             */
            LocalDate date = null;

            String dateStr = getDate().getText().toString().trim();

            if(!dateStr.isEmpty()){
                String[] dateElments = dateStr.split("-");

                int year= Integer.parseInt(dateElments[2]);
                int month = Integer.parseInt(dateElments[1]);
                int day = Integer.parseInt(dateElments[0]);

                date = LocalDate.of(year, month,day);
            }

            Boolean isDone = getIsDone().isChecked();

            Task updatedtask = new Task(getTittle().getText().toString().trim(),
                                        getDescriptionn().getText().toString().trim(),
                                        getCategorySpinner().getSelectedItem().toString(),
                                        date, isDone);

            Tasks.updateTask(selectedTaskID, updatedtask);
            /*
                Status information to the user
             */
            String status;

            if(isDone){
                status= "completed";
            } else {
                status = "updated";
            }
            Intent intent = new Intent(this, StatusInform.class);
            intent.putExtra("status", status);
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
    public EditText getTittle() {
        return title;
    }
    public EditText getDescriptionn() {
        return description;
    }
    public void setDescriptionn(EditText description) {
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
    public Button getDelete() {
        return delete;
    }
    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
