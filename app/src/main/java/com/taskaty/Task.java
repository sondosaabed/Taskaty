package com.taskaty;

import java.util.Date;

/*
    This is a class that I created to represent the task object
    and it's attribure
 */
public class Task {
    /*
        Attributes
     */
    private String title; // The title of the task ex: Shopping For Mom
    private Boolean isDone = false; // If true then it is done, if false then it's to do
    private String description; // A description of the task I will make it optional
    private String category ="None"; // Personal, Work, Shopping, to-read, to-watch, None (I will make it optional
    private Date dueDate; // They can set the due date of the task

    /*
        Constructors
     */
    public Task(String title, String description, String category, Date dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        if (category != null && !category.isEmpty()) {
            setCategory(category);
        }
        if (description != null && !description.isEmpty()) {
            setDescription(description);
        }
    }

    /*
        Getters & Setters
    */
    public String getTitle() {
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date date) {
        this.dueDate = date;
    }
}
