package com.example.finalprojectapp.HistoryData;

public class Data {


    private String time, hr, sp;

    public Data() {
    }

    public Data(String sp, String hr, String time) {
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

    @Override
    public String toString() {
        return "Data{" +
                "time='" + time + '\'' +
                ", hr='" + hr + '\'' +
                ", sp='" + sp + '\'' +
                '}';
    }
}
