package com.taskaty.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

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
        /* Since the user could have removed an elemnt at any index of the arrayylist
        * I need to update the following tasks ID's since I set their id (Object ID) to it's index */
        // if the removed task is not the last elment in the arraylist then the ids has to be updated
        getTaskaty().remove(selectedTaskID);
        getTaskaty().trimToSize();

        if(selectedTaskID < getTaskaty().size()){
            for(int i=getTaskaty().size()-1; i>=selectedTaskID; i--){
                getTaskaty().get(i).setId(getTaskaty().get(i).getId()-1);
            }
        }
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

        for(Task task: tasks){
            boolean containsKeyword = task.getTittle().contains(keyword.toLowerCase(Locale.ROOT));
            boolean inCategory = task.getCategory().equals(category) || category.equals("all");
            boolean inMonth = task.getDueDate().getMonth().equals(
                    LocalDate.parse(month.toUpperCase(Locale.ROOT)))
                    || month.equals("all");
            if(containsKeyword && inCategory && inMonth){
                foundtasks.add(task);
            }
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
