package com.taskaty.model;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

/*
    I have created this class to ne used as a Prefrences opearions manager
    I use it to get shared prefrences and save and load tasks
 */
public class Preferences {
    /*
        Attriutes
     */
    // I initialize Sample Tasks in the tasks list
    static Task t1 = new Task(0,"Smile to a Stranger","Today I will smile and make someone happy","",null, false);
    static Task t2 = new Task(1,"Submit Assignment 1","Your mobile course work","Study",new GregorianCalendar(2023,11,18), true);
    private static final String DATA = "DATA";
    private static final String FIRST_TIME = "is_first_time";
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    /*
        I created these two methods in order to show diffrent activities when the user starts or gets back
     */
    public static boolean isFirstTime(Context context) {
        preferences = getPreferences(context);
        return preferences.getBoolean(FIRST_TIME, true);
    }

    public static void setNotFirstTime(Context context) {
        preferences = getPreferences(context);
        editor = preferences.edit();
        editor.putBoolean(FIRST_TIME, false);
        editor.apply();
    }

    public static ArrayList<Task> initializeTaskatySample(){
        return new ArrayList<>(Arrays.asList(t1, t2));
    }

    public static ArrayList<Task> loadTasks() {
        Gson gson = new Gson();
        String str = preferences.getString(DATA, "");
        Task[] tasks = gson.fromJson(str, Task[].class);
        if(tasks != null){
            return new ArrayList<>(Arrays.asList(tasks));
        }
        return initializeTaskatySample();
    }

    /*
        I created this method to save the tasks list which I called after each modification on the list
     */
    public static void saveTaskaty(ArrayList<Task> tasks) {
        Gson gson = new Gson();
        String str = gson.toJson(tasks);
        editor.putString(DATA, str);
        editor.apply();
    }

    public static SharedPreferences getPreferences(Context context) {
        if (preferences == null) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
            editor = preferences.edit();
        }
        return preferences;
    }
}
