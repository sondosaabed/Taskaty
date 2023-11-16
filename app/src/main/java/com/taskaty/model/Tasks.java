package com.taskaty.model;

import java.util.ArrayList;

/*
    In this Wrapper class I use the ArrayList Data Structure to save the tasks
    Diffrent operations are done on this datastructure:
        - Adding a new task
        - Updating an existing task
        - Checking if tasks exists on the list
        - save the task
        - load the tasks
 */
public class Tasks {
    // I initialize Sample Tasks in the tasks list
    //static Task t1 = new Task(0,"Smile to a Stranger","Today I will smile and make someone happy","",null, false);
    //static Task t2 = new Task(1,"Submit Assignment 1","Your mobile course work","Study",new GregorianCalendar(2023,11,18), true);
    private static final ArrayList<Task> tasks = Preferences.loadTasks();

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
        getTaskaty().set(oldID, updatedTask);
        // Becuase it's ID is suppose to stay the same, just makeing sure I thinks it does
        updatedTask.setId(getTaskaty().indexOf(updatedTask));
        Preferences.saveTaskaty(getTaskaty());
    }

    /*
        Getters & Setters
    */
    public static ArrayList<Task> getTaskaty() {
        return tasks;
    }
}
