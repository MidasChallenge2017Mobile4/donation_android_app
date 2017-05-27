package com.midas.donation_android_app;

/**
 * Created by YURIM on 2017-05-27.
 */

public class PointHistoryInfo {
    private String date;
    private int point;

    public PointHistoryInfo(String date, int point) {
        this.date = date;
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public int getPoint() {
        return point;
    }
}
