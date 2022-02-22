package com.example.finalprojectapp;

public class Data {


    private String time, hrValue, spValue;

    public Data() {
    }

    public Data(String spValue, String hrValue, String time) {
        this.spValue = spValue;
        this.hrValue = hrValue;
        this.time    = time;

    }

    public String getHrValue() {
        return hrValue;
    }

    public void setHrValue(String hrValue) {
        this.hrValue = hrValue;
    }

    public String getSpValue() {
        return spValue;
    }

    public void setSpValue(String spValue) {
        this.spValue = spValue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
