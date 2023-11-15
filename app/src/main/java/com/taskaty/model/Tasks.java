package com.taskaty.model;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.GregorianCalendar;

//import com.google.gson.Gson;


/*
    In this class I use the ArrayList Data Structure to save the tasks
    Diffrent operations are done on this datastructure:
        - Adding a new task
        - Updating an existing task
        - Checking if tasks exists on the list
 */
public class Tasks {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private SharedPreferences sharedPrefrences;
    private SharedPreferences.Editor editor;

    public static void initializeSampleTasks(){
        /*
            In this method I initialize Sample Tasks in the tasks list
         */

        Task t1 = new Task("Smile to a Stranger","Today I will smile and make someone happy");
        Task t2 = new Task("Submit Assignment 1","Your mobile course work","Study",new GregorianCalendar(2023,11,18));
        t2.setDone(true);
        addTask(t1);
        addTask(t2);
    }

    /*
        Operations on the list
     */
    public static void addTask(Task task){
        getTasks().add(task);
        //When I add a new Task I set the ID of the object task as their index in the arrayList
        task.setId(getTasks().indexOf(task));
    }

    public static void updateTask(int oldID, Task updatedTask) {
        getTasks().set(oldID, updatedTask);
    }

    /*
        Getters & Setters
    */
    public static ArrayList<Task> getTasks() {
        return tasks;
    }
}
