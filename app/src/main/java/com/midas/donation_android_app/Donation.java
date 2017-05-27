package com.midas.donation_android_app;

/**
 * Created by Soora on 2017-05-27.
 */

public class Donation {
    String title, date;
    int goal, total;
    Donation(String title, String date, int goal, int total){
        this.title = title;
        this.date = date;
        this.goal = goal;
        this.total = total;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDate(){
        return this.date;
    }
    public int getGoal(){
        return this.goal;
    }
    public int getTotal(){
        return this.total;
    }


}
