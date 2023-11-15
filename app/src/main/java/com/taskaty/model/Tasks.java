package com.taskaty.model;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

//import com.google.gson.Gson;


/*
    In this Wrapper class I use the ArrayList Data Structure to save the tasks
    Diffrent operations are done on this datastructure:
        - Adding a new task
        - Updating an existing task
        - Checking if tasks exists on the list
 */
public class Tasks {
    // I initialize Sample Tasks in the tasks list
    static Task t1 = new Task(0,"Smile to a Stranger","Today I will smile and make someone happy","",null, false);
    static Task t2 = new Task(1,"Submit Assignment 1","Your mobile course work","Study",new GregorianCalendar(2023,11,18), true);
    private static final ArrayList<Task> tasks = new ArrayList<>(Arrays.asList(t1,t2));
    private SharedPreferences sharedPrefrences;
    private SharedPreferences.Editor editor;

    /*
        Operations on the list
     */
    public static void addTask(Task task){
        getTasks().add(task);
        //When I add a new Task I set the ID of the object Task as their index in the arrayList
        task.setId(getTasks().indexOf(task));
    }

    public static void updateTask(int oldID, Task updatedTask) {
        getTasks().set(oldID, updatedTask);
        // Becuase it's ID is suppose to stay the same, just makeing sure I thinks it does
        updatedTask.setId(getTasks().indexOf(updatedTask));
    }

    /*
        Getters & Setters
    */
    public static ArrayList<Task> getTasks() {
        return tasks;
    }
}
