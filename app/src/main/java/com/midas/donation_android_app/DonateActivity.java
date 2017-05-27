package com.midas.donation_android_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TabHost;

import com.midas.donation_android_app.Adapter.DonateAdapter;
import com.midas.donation_android_app.Info.Donation;

import java.util.ArrayList;

public class DonateActivity extends AppCompatActivity {
    TabHost tabHost;
    ListView tab1list, tab2list, tab3list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        init();
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
        ArrayList<Donation> donateArr = new ArrayList<Donation>();
        Donation d1 = new Donation("제목1", "2017.05.27", 1000, 10000);
        Donation d2 = new Donation("제목2", "2017.05.27", 1000, 10000);
        donateArr.add(d1);
        donateArr.add(d2);

        DonateAdapter da = new DonateAdapter(this, R.layout.donate_row, donateArr);
        tab1list.setAdapter(da);

        //tab2 ListView
        tab2list = (ListView)findViewById(R.id.tab2);

        //DonateAdapter da = new DonateAdapter(this, R.layout.donate_row, donateArr);
        tab1list.setAdapter(da);

        //tab3 ListView
        tab3list = (ListView)findViewById(R.id.tab3);

        //DonateAdapter da = new DonateAdapter(this, R.layout.donate_row, donateArr);
        tab3list.setAdapter(da);
    }
}
