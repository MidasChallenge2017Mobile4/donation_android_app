package com.midas.donation_android_app.Info;

/**
 * Created by YURIM on 2017-05-27.
 */

public class PointHistoryInfo {
    private String date;
    private int status;
    private int point;

    public PointHistoryInfo(String date, int status, int point) {
        this.date = date;
        this.status = status;
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }

    public int getPoint() {
        return point;
    }
}
