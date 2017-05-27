package com.midas.donation_android_app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class PushActivity extends AppCompatActivity {
    Button push_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worklife);
        init();
    }
    void init(){
       push_btn = (Button)findViewById(R.id.pushbtn);
        push_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //알림(Notification)을 관리하는 NotificationManager 얻어오기

                NotificationManager manager= (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);



                //알림(Notification)을 만들어내는 Builder 객체 생성

                //API 11 버전 이하도 지원하기 위해 NotificationCampat 클래스 사용

                //만약 minimum SDK가 API 11 이상이면 Notification 클래스 사용 가능

                NotificationCompat.Builder builder= new NotificationCompat.Builder(v.getContext());


                //Notification.Builder에게 Notification 제목, 내용, 이미지 등을 설정//////////////////////////////////////
                Intent viewIntent = new Intent(v.getContext(), DonateActivity.class);
                PendingIntent viewPendingIntent =
                        PendingIntent.getActivity(v.getContext(), 0, viewIntent, 0);


                builder.addAction (android.R.drawable.ic_dialog_email,
                "내 포인트 확인하러 가기", viewPendingIntent);

                builder.setSmallIcon(android.R.drawable.ic_dialog_email);//상태표시줄에 보이는 아이콘 모양
                builder.setTicker("포인트가 적립되었습니다."); //알림이 발생될 때 잠시 보이는 글씨



                //상태바를 드래그하여 아래로 내리면 보이는 알림창(확장 상태바)의 아이콘 모양 지정

                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_input_add));
                builder.setContentTitle("사랑의 아침밥");    //알림창에서의 제목
                builder.setContentText("100포인트 적립");   //알림창에서의 글씨
                Notification notification= builder.build();   //Notification 객체 생성

                manager.notify(1, notification);             //NotificationManager가 알림(Notification)을 표시
            }
        });
    }
}
