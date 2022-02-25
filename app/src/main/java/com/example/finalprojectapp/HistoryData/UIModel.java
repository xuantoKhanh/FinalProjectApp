package com.example.finalprojectapp.HistoryData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UIModel {
    private static UIModel instance;
    public static UIModel getInstance() {
        if (instance == null) {
            instance = new UIModel();
        }
        return instance;
    }
    private Gson gson;
    public Gson provideGSon() {
        if (gson == null)
            gson = new GsonBuilder().create();
        return gson;
    }
}
