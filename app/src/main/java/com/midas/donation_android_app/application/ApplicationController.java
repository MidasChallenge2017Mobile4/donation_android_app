package com.midas.donation_android_app.application;

import android.app.Application;
import android.util.Log;


import com.midas.donation_android_app.database.DbOpenHelper;

import java.sql.SQLException;

public class ApplicationController extends Application {

    private static ApplicationController instance;
    public DbOpenHelper mDbOpenHelper;

    public static ApplicationController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TESTTEST","ONCREATE");
        ApplicationController.instance = this;
        this.buildDB();

    }

    public void buildDB() {
        // DB Create and Open
        mDbOpenHelper = new DbOpenHelper(this);
        try {
            mDbOpenHelper.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
