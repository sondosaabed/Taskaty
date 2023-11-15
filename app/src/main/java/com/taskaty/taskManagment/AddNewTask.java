package com.taskaty.taskManagment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.taskaty.R;
import com.taskaty.informational.StatusInform;
import com.taskaty.model.Task;
import com.taskaty.model.Tasks;

import java.util.Calendar;
import java.util.Date;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        getSupportActionBar().hide();
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
            /*
                https://www.geeksforgeeks.org/datepicker-in-android/
             */
            final Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    AddNewTask.this,
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
    private void handle_add(Button add){
        add.setOnClickListener(view->{
            String title = gettitle().getText().toString().trim();
            String description = getDescription().getText().toString().trim();

            /*
            Handling the date as a string
             */
            String dateStr = getDate().getText().toString().trim();
            String[] dateElments = dateStr.split("-");

            int year= Integer.parseInt(dateElments[2]);
            int month = Integer.parseInt(dateElments[1]);
            int day = Integer.parseInt(dateElments[0]);

            Date date = new Date(day,month,year);
            String category = getCategorySpinner().getSelectedItem().toString().trim();

            Intent intent = new Intent(this, StatusInform.class);
            intent.putExtra("status", "added");
            startActivity(intent);

            if(!title.isEmpty()){
                Task newTask = new Task(title, description, category, date);
                Boolean checkAdd = Tasks.getTasks().add(newTask);
                if(checkAdd){
                    Intent intent1 = new Intent(this, StatusInform.class);
                    intent1.putExtra("status", "added");
                    startActivity(intent1);
                }
            }else{

            }
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
    public void setCategorySpinner(Spinner categorySpinner) {this.categorySpinner = categorySpinner;}
    public Button getPickDate() {
        return pickDate;
    }

    public void setPickDate(Button pickDate) {
        this.pickDate = pickDate;
    }
}
