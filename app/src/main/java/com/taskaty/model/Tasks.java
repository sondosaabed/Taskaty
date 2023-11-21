package com.taskaty.model;

import java.util.ArrayList;

/*
    In this Wrapper class I use the ArrayList Data Structure to save the tasks
    Diffrent operations are done on this datastructure:
        - Adding a new task
        - Updating an existing task
        - Remove an existing task on the list
        - Checking if tasks exists on the list
        - save the task after each modification
        - Search by (keyword, month, category)
 */
public class Tasks {
    private static ArrayList<Task> tasks = Preferences.loadTasks();
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

    public static ArrayList<Task> search(String keyword, String month, String category){
        /*
            I will search like when we use filters
            - If task name contains a keyword
            - Month Filter on the list
            - Category Filter on the list
         */
        ArrayList<Task> foundtasks = new ArrayList<>();
        ArrayList<Task> tasks = Tasks.getTaskaty();

        if(keyword.trim().isEmpty() && category.equals("all") && month.equals("all")){
            return tasks; // Because all of them
        }

        if(!category.equals("all") || !month.equals("all")){
            for(int i = 0; i<tasks.size() ;i++){
                if(tasks.get(i).getCategory().equals(category)){
                    tasks.add(tasks.get(i)); // I add it to the found tasks
                }
            }
        }else{

        }

        return foundtasks;
    }

    /*
        Getters & Setters
    */
    public static ArrayList<Task> getTaskaty() {
        return tasks;
    }
}
