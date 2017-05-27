package com.midas.donation_android_app;

/**
 * Created by Soora on 2017-05-27.
 */

public class Donation {
    String title, date;
    double goal, total;
    Donation(String title, String date, double goal, double total){
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
    public double getGoal(){
        return this.goal;
    }
    public double getTotal(){
        return this.total;
    }


}
