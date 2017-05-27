package com.midas.donation_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;


import java.util.ArrayList;




public class DonateActivity extends AppCompatActivity {
    TabHost tabHost;
    ListView tab1list, tab2list, tab3list;
    ImageButton back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

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
        Donation d1 = new Donation("제목1", "2017.05.27", 10000, 100, 1);
        Donation d2 = new Donation("제목2", "2017.05.27", 1000, 100, 1);
        donateArr1.add(d1);
        donateArr1.add(d2);

        DonateAdapter da1 = new DonateAdapter(this, R.layout.donate_row, donateArr1);
        tab1list.setAdapter(da1);

        //tab2 ListView
        tab2list = (ListView)findViewById(R.id.tab2);
        ArrayList<Donation> donateArr2 = new ArrayList<Donation>();
        Donation d3 = new Donation("제목1", "2017.05.27", 100000, 1000, 2);
        Donation d4 = new Donation("제목2", "2017.05.27", 100000, 1000, 2);
        donateArr2.add(d3);
        donateArr2.add(d4);
        DonateAdapter da2 = new DonateAdapter(this, R.layout.donate_row, donateArr2);
        tab2list.setAdapter(da2);

        //tab3 ListView
        tab3list = (ListView)findViewById(R.id.tab3);
        //DonateAdapter da = new DonateAdapter(this, R.layout.donate_row, donateArr);
        ArrayList<Donation> donateArr3 = new ArrayList<Donation>();
        Donation d5 = new Donation("제목1", "2017.05.27", 100000, 1000, 3);
        Donation d6 = new Donation("제목2", "2017.05.27", 100000, 1000, 3);
        donateArr3.add(d5);
        donateArr3.add(d6);
        DonateAdapter da3 = new DonateAdapter(this, R.layout.donate_row, donateArr3);
        tab3list.setAdapter(da3);




        //아이템 클릭하면 다음 화면으로 넘어가기
        tab1list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), DonateExplainActivity.class);
                intent.putExtra("donateID", 1);
                startActivity(intent);
            }
        });
    }





}
