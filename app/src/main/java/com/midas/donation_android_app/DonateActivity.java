package com.midas.donation_android_app;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;


import com.midas.donation_android_app.application.ApplicationController;
import com.midas.donation_android_app.database.DbOpenHelper;

import java.util.ArrayList;




public class DonateActivity extends AppCompatActivity {
    TabHost tabHost;
    ListView tab1list, tab2list, tab3list;
    ImageButton back_btn;
    SQLiteDatabase m_db;
    DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        mDbOpenHelper = ApplicationController.getInstance().mDbOpenHelper;
        //mDbOpenHelper.DoEpilInsert();
        //mDbOpenHelper.DoDoInsert();
        init();
        back_btn = (ImageButton) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    void init(){

        tabHost = (TabHost)findViewById(R.id.donateTab);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setIndicator("기부 진행");
        spec.setContent(R.id.tab1);
        tabHost.addTab(spec); //첫번째 탭 추가

        spec = tabHost.newTabSpec("tab2");
        spec.setIndicator("기부 종료");
        spec.setContent(R.id.tab2);
        tabHost.addTab(spec); //두번째 탭 추가

        spec = tabHost.newTabSpec("tab3");
        spec.setIndicator("기부 완료");
        spec.setContent(R.id.tab3);
        tabHost.addTab(spec); //두번째 탭 추가

        tabHost.setCurrentTab(0); //기본 적으로 활성화 시킬 Tab 설정함
        //현재 Tab1 활성화. 1일 경우 Tab2 활성화.


        //tab1 ListView
        tab1list = (ListView)findViewById(R.id.tab1);
        ArrayList<Donation> donateArr1 = new ArrayList<Donation>();
        Donation d1 = new Donation("2017 연탄 나눔 봉사", "2017.05.30", "don_1", 100000, 1000, 1);
        donateArr1.add(d1);
        //ArrayList<Donation> dnarr1 =  mDbOpenHelper.DoDo1Select();
        DonateAdapter da1 = new DonateAdapter(this, R.layout.donate_row, donateArr1);
        tab1list.setAdapter(da1);

        //tab2 ListView
        tab2list = (ListView)findViewById(R.id.tab2);
///*        ArrayList<Donation> dnarr2 =  mDbOpenHelper.DoDo2Select();
//        DonateAdapter da2 = new DonateAdapter(this, R.layout.donate_row, dnarr2);
//        tab2list.setAdapter(da2);*/
        ArrayList<Donation> donateArr2 = new ArrayList<Donation>();
        Donation d4 = new Donation("2017 아기 용품 전달", "2017.05.23", "don_2", 100000, 5000, 2);
        donateArr2.add(d4);
        DonateAdapter da2 = new DonateAdapter(this, R.layout.donate_row, donateArr2);
        tab2list.setAdapter(da2);

        //tab3 ListView
        tab3list = (ListView)findViewById(R.id.tab3);
        ArrayList<Donation> donateArr3 = new ArrayList<>();
        Donation d5 = new Donation("2017 2분기 연탄 나눔 봉사", "2017.05.27", "don_1", 100000, 100000, 3);
        Donation d6 = new Donation("2017 1분기 연탄 나눔 봉사", "2017.01.31", "don_3", 100000, 100000, 3);
        donateArr3.add(d5);
        donateArr3.add(d6);
        DonateAdapter da3 = new DonateAdapter(this, R.layout.donate_row, donateArr3);
        tab3list.setAdapter(da3);




        //아이템 클릭하면 다음 화면으로 넘어가기
        tab1list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), DonateExplainActivity.class);
                intent.putExtra("title", "2017 연탄 나눔 봉사");
                intent.putExtra("image", "don_1");
                startActivity(intent);
            }
        });
        tab3list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), DonateEpilogueActivity.class);
                if(position==1) {
                    intent.putExtra("URL", "http://www.midasit.com/upload/BRD_Nanum/%EA%B3%A0%EB%93%B1%EB%8F%99.png");
                    startActivity(intent);
                }else{
                    intent.putExtra("URL", "http://www.midasit.com/upload/BRD_Nanum/%EC%97%B0%ED%83%84%EB%B4%89%EC%82%AC-%ED%9B%84%EA%B8%B0_%EC%B5%9C%EC%A2%85(1).png");
                    startActivity(intent);
                }
            }
        });
    }





}
