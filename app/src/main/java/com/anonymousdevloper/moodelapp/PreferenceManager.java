package com.anonymousdevloper.moodelapp;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor mEditor;
//    private static PreferenceManager preferenceManager;

//    public static PreferenceManager getInstance(Context context, String string) {
//        if (preferenceManager == null) {
//            preferenceManager = new PreferenceManager(context);
//        }
//        return preferenceManager;
//    }

    public PreferenceManager(Context context){
        sharedPreferences = context.getSharedPreferences(ApiConstant.KEY_PREFERENCE_NAME, context.MODE_PRIVATE);

    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void putBoolean(String key, Boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public Boolean getBoolean(String key){

        return sharedPreferences.getBoolean(key, false);
    }

    public void setUserName(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ApiConstant.KEY_USERNAME,username);
        editor.apply();
    }



    public void putString(String key, String value){
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }
    public void clearPreference(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.remove(ApiConstant.KEY_IS_SIGNED_IN);
        editor.apply();

    }
}
