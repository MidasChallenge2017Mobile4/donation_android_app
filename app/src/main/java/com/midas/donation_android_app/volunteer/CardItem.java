package com.midas.donation_android_app.volunteer;

/**
 * Created by ichaeeun on 2017. 5. 27..
 */
public class CardItem {

    private String mTextResource;
    private int mImage;

    public CardItem(String text, int image) {
        mTextResource = text;
        mImage = image;
    }

    public String getText() {
        return mTextResource;
    }


    public int getImage() {
        return mImage;
    }
}
