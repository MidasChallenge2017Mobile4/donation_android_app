package com.midas.donation_android_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mypageBtn;
    private Button donationBtn;
    private Button volunteerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();
    }

    private void setLayout(){
        mypageBtn = (Button)findViewById(R.id.btn_mypage);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });

        donationBtn = (Button)findViewById(R.id.btn_donation);
        donationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DonateActivity.class);
                Log.d("TESTTEST","BUTTON CLICK");
                startActivity(intent);
            }
        });

        volunteerBtn = (Button)findViewById(R.id.btn_donation);
        volunteerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MyPageActivity.class);
//                startActivity(intent);
            }
        });
    }
}
