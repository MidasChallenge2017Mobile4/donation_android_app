package com.midas.donation_android_app.volunteer;

/**
 * Created by ichaeeun on 2017. 5. 27..
 */
public class CardItem {

    private String mTextResource;
    private String mTitleResource;

    public CardItem(String title, String text) {
        mTitleResource = title;
        mTextResource = text;
    }

    public String getText() {
        return mTextResource;
    }

    public String getTitle() {
        return mTitleResource;
    }
}
