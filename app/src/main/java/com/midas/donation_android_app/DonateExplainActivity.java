package com.midas.donation_android_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.midas.donation_android_app.DonateAdapter;
import com.midas.donation_android_app.Donation;
import com.midas.donation_android_app.R;

import java.util.ArrayList;

public class DonateExplainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_explain);
        init();
    }
    void init(){

    }
}
