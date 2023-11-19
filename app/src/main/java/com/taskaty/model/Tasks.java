package com.taskaty.model;

import java.util.ArrayList;

/*
    In this Wrapper class I use the ArrayList Data Structure to save the tasks
    Diffrent operations are done on this datastructure:
        - Adding a new task
        - Updating an existing task
        - Checking if tasks exists on the list
        - save the task after each modification
 */
public class Tasks {
    private static ArrayList<Task> tasks = Preferences.loadTasks();//= Preferences.loadTasks()
    /*
        Operations on the list
     */
    public static void addTask(Task task){
        getTaskaty().add(task);
        //When I add a new Task I set the ID of the object Task as their index in the arrayList
        task.setId(getTaskaty().indexOf(task));
        Preferences.saveTaskaty(getTaskaty());
    }

    public static void updateTask(int oldID, Task updatedTask) {
        updatedTask.setId(oldID); // Becuase it's ID is suppose to stay the same
        getTaskaty().set(oldID, updatedTask);
        Preferences.saveTaskaty(getTaskaty());
    }

    public static void deleteTask(int selectedTaskID) {
        getTaskaty().remove(selectedTaskID);
        Preferences.saveTaskaty(getTaskaty());
    }

    /*
        Getters & Setters
    */
    public static ArrayList<Task> getTaskaty() {
        return tasks;
    }
}
