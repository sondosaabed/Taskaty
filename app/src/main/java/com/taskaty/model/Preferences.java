package com.taskaty.model;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
/*
    I have created this class to ne used as a Prefrences opearions manager
    I use it to get shared prefrences and save and load tasks
 */
public class Preferences {
    /*
        Attriutes
     */
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

    public static ArrayList<Task> loadTasks() {
        Gson gson = new Gson();
        String str = preferences.getString(DATA, "");
        return gson.fromJson(str, new TypeToken<ArrayList<Task>>() {}.getType());
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

    private static void setupSharedPrefs(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }

    public static SharedPreferences getPreferences(Context context) {
        if (preferences == null) {
            setupSharedPrefs(context);
        }
        return preferences;
    }
}
