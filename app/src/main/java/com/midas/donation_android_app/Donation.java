package com.midas.donation_android_app;

import android.widget.ImageView;

/**
 * Created by Soora on 2017-05-27.
 */

public class Donation {
    String title, date, content, image;
    int goal, total;
    int state;
    public Donation(String title, String date, String image, int goal, int total, int state){
        this.title = title;
        this.date = date;
        this.goal = goal;
        this.image = image;
        this.total = total;
        this.state = state;
    }
    public Donation(String title, String content, int state){
        this.title = title;
        this.content = content;
        this.state = state;
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
    public int getState() { return this.state; }
    public String getContent() { return this.content; }

}
