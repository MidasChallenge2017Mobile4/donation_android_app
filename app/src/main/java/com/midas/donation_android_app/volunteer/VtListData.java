package com.midas.donation_android_app.volunteer;

/**
 * Created by chaeeun on 2017-05-27.
 */


public class VtListData {
    public int id;
    public String title;
    public String content;
    public int image;
    public String date;   // 봉사 날짜
    public String status;
    public int view;
    public boolean isChecked;


    public VtListData() {

    }

    public VtListData(int id, String title, String content, int image, String date, String status, int view, boolean isChecked) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.date = date;
        this.status = status;
        this.view = view;
        this.isChecked = isChecked;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
