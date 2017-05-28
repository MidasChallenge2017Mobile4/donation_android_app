package com.midas.donation_android_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.midas.donation_android_app.DonateAdapter;
import com.midas.donation_android_app.Donation;
import com.midas.donation_android_app.R;

import java.util.ArrayList;

public class DonateExplainActivity extends AppCompatActivity {
    Button donate_btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_explain);
        init();
    }
    void init(){
      //  tv = (TextView) findViewById(R.id.donate_money);
        donate_btn = (Button) findViewById(R.id.donate_btn);
        donate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tv.getText().toString();
                int money = Integer.parseInt(text);
                tv.setText(" ");
            }
        });
    }
}
