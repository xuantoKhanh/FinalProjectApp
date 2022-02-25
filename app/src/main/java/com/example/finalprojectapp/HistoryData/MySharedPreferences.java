package com.example.finalprojectapp.HistoryData;

import android.content.Context;

public class MySharedPreferences {
    private android.content.SharedPreferences.Editor editor;
    private android.content.SharedPreferences my_share;

    public MySharedPreferences(Context mContext) {
        my_share = mContext.getSharedPreferences("CLIENT_ID", 0);
        editor = my_share.edit();
    }

    public void removeKey(String key) {
        editor.remove(key);
        editor.apply();
    }


    public boolean checkKey(String key) {
        return my_share.contains(key);
    }

    public String getString(String key) {
        return my_share.getString(key, "");
    }

    public void setString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void setBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return my_share.getBoolean(key, false);
    }
}
