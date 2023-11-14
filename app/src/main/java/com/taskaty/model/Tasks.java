package com.taskaty.model;

import java.util.ArrayList;
import java.util.Date;

public class Tasks {
    private static ArrayList<Task> tasks = new ArrayList();

    public static void initializeSampleTasks(){
        Task t1 = new Task("Smile to a Stranger","Today I will smile and make someone happy");
        Task t2 = new Task("Submit Assignment 1","Your mobile course work","",new Date(11,18,2023));
    }

    public static boolean addTask(Task task){
       return getTasks().add(task);
    }

    public static boolean findByID(Task task){
        getTasks().get(task.getId());
        return true;
    }

    public static boolean updateTask(int oldID, Task updatedTask){
        getTasks().get(oldID);
        return true;
    }

    /*
        Getters & Setters
     */
    public static ArrayList getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList tasks) {
        this.tasks = tasks;
    }
}
