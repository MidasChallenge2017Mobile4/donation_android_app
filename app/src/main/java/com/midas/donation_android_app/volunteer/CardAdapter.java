package com.midas.donation_android_app.volunteer;


import android.support.v7.widget.CardView;

/**
 * Created by ichaeeun on 2017. 5. 27..
 */
public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
