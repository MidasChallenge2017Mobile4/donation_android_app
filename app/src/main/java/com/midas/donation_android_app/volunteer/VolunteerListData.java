package com.midas.donation_android_app.volunteer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * Created by chaeeun on 2017-05-27.
 */


public class VolunteerListData {
    private int id;
    private String title;
    private String contents;
    private int image;
    private String date;   // 봉사 날짜
    private String owner;
    private int view;


    public VolunteerListData() {

    }

    public VolunteerListData(int id, String title, String contents, int image, String date, String owner, int view) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.image = image;
        this.date = date;
        this.owner = owner;
        this.view = view;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
