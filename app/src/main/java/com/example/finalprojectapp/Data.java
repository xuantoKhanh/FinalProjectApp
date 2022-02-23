package com.example.finalprojectapp;

public class Data {


    private String time, hr, sp;

    public Data() {
    }

    public Data(String spValue, String hr, String time) {
        this.sp = sp;
        this.hr = hr;
        this.time    = time;

    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }


}
