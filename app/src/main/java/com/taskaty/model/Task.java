package com.taskaty.model;

import androidx.annotation.NonNull;

import java.util.GregorianCalendar;

/*
    This is a class that I created to represent the task object
    and it's attribure
 */
public class Task {
    /*
        Attributes
     */
    private int id;
    private String title; // The title of the task ex: Shopping For Mom
    private Boolean isDone = false; // If true then it is done, if false then it's to do
    private String description; // A description of the task I will make it optional
    private String category ="None"; // Personal, Work, Shopping, to-read, to-watch, None (I will make it optional
    private GregorianCalendar dueDate = new GregorianCalendar(); // They can set the due date of the task

    /*
        Constructor
     */
    public Task(String title, String description, String category, GregorianCalendar dueDate, Boolean isDone) {
        setTitle(title);
        /*
               Because these are all optional for the user
               So I decided on the constructor, like to use one constructor instead of multi
         */
        if (category != null && !category.isEmpty()) {
            setCategory(category);
        }
        if (description != null && !description.isEmpty()) {
            setDescription(description);
        }
        if (dueDate != null) {
            setDueDate(dueDate);
        }
        setDone(isDone);
    }

    public Task(int id, String title, String description, String category, GregorianCalendar dueDate, Boolean isDone) {
        setTitle(title);
        /*
               Because these are all optional for the user
               So I decided on the constructor, like to use one constructor instead of multi
         */
        if (category != null && !category.isEmpty()) {
            setCategory(category);
        }
        if (description != null && !description.isEmpty()) {
            setDescription(description);
        }
        if (dueDate != null) {
            setDueDate(dueDate);
        }
        setDone(isDone);
        setId(id);
    }
    /*
        I Used these icons to indicate it's done or not for better User experience
     */
    @NonNull
    @Override
    public String toString() {
        String title =getTittle();
        if(isDone){
            return "✔ ~~~~~~~~" + title + "~~~~~~~";
        }else{
            return "▢ " + title;
        }
    }

    /*
        Getters & Setters
    */
    public String getTittle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getDone() {
        return isDone;
    }
    public void setDone(Boolean done) {
        isDone = done;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public GregorianCalendar getDueDate() {
        return dueDate;
    }
    public void setDueDate(GregorianCalendar date) {
        this.dueDate = date;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
