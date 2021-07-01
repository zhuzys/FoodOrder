package com.example.foodorderapp.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class Hours {
   private String Sunday, Monday, Tuesday, Wednesday, Friday, Thursday, Saturday;

    public String getSunday() {
        return Sunday;
    }

    public void setSunday(String sunday) {
        Sunday = sunday;
    }

    public String getMonday() {
        return Monday;
    }

    public void setMonday(String monday) {
        Monday = monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String tuesday) {
        Tuesday = tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String wednesday) {
        Wednesday = wednesday;
    }

    public String getFriday() {
        return Friday;
    }

    public void setFriday(String friday) {
        Friday = friday;
    }

    public String getThursday() {
        return Thursday;
    }

    public void setThursday(String thursday) {
        Thursday = thursday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public void setSaturday(String saturday) {
        Saturday = saturday;
    }

    public String getTodayHours() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        switch (day) {
            case "Sunday":
                return this.Sunday;
            case "Thursday":
                return this.Thursday;
            case "Tuesday":
                return this.Tuesday;
            case "Friday":
                return this.Friday;
            case "Wednesday":
                return this.Wednesday;
            case "Monday":
                return this.Monday;
            case "Saturday":
                return this.Saturday;
            default:
                return this.Sunday;


        }

    }
}
