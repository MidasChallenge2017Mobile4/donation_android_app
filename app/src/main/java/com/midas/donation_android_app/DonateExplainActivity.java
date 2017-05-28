package com.midas.donation_android_app;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.midas.donation_android_app.DonateAdapter;
import com.midas.donation_android_app.Donation;
import com.midas.donation_android_app.R;

import java.util.ArrayList;

public class DonateExplainActivity extends AppCompatActivity {
    Button donate_btn;
    ImageButton back_btn;
    TextView tv, title, content;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_explain);
        init();
    }
    void init(){
        Intent intent = getIntent();
        tv = (TextView) findViewById(R.id.donate_money);
        title = (TextView) findViewById(R.id.title);
        title.setText(intent.getStringExtra("title"));
        iv = (ImageView) findViewById(R.id.iv);
        if(intent.getStringExtra("image").equals("don_1")){
            iv.setImageResource(R.drawable.dnt_1);
        }
        content = (TextView) findViewById(R.id.content);
        content.setText("어려운 이웃에게 연탄을 선물하세요! \n1000원 단위로 포인트를 기부할 수 있습니다.");
        donate_btn = (Button) findViewById(R.id.donate_btn);
        donate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tv.getText().toString();
                int money = Integer.parseInt(text);
                if(money%1000!=0) {
                    Toast.makeText(getApplicationContext(),"1000원 단위로 가능합니다.", Toast.LENGTH_SHORT).show();
                    tv.setText(" ");
                }else{
                    Toast.makeText(getApplicationContext(),"멋진 기부를 하셨네요!", Toast.LENGTH_SHORT).show();
                    tv.setText(" ");
                }
            }
        });

        back_btn = (ImageButton)findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
