package com.midas.donation_android_app.Info;

/**
 * Created by YURIM on 2017-05-27.
 */

public class DonateHistoryInfo {
    private String title;
    private int amount;
    private int status;

    public DonateHistoryInfo(String title, int amount, int status) {
        this.title = title;
        this.amount = amount;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public int getStatus() {
        return status;
    }

}
