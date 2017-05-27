package com.midas.donation_android_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.midas.donation_android_app.Adapter.DonateHistoryAdapter;
import com.midas.donation_android_app.Adapter.PointHistoryAdapter;
import com.midas.donation_android_app.Info.DonateHistoryInfo;
import com.midas.donation_android_app.Info.PointHistoryInfo;

import java.util.ArrayList;

public class MyPageActivity extends AppCompatActivity {

    private TabHost tabHost;

    private ListView pointHistoryListView;
    private ArrayList<PointHistoryInfo> pointHistoryInfoList = new ArrayList<PointHistoryInfo>();
    private PointHistoryAdapter pointHistoryAdapter;

    private ListView donateHistoryListView;
    private ArrayList<DonateHistoryInfo> donateHistoryInfoList = new ArrayList<DonateHistoryInfo>();
    private DonateHistoryAdapter donateHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        init();
    }

    private void init(){
        tabHost = (TabHost)findViewById(R.id.mypageTab);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setIndicator("획득 이력");
        spec.setContent(R.id.tab1);
        tabHost.addTab(spec); //첫번째 탭 추가

        spec = tabHost.newTabSpec("tab2");
        spec.setIndicator("기부 이력");
        spec.setContent(R.id.tab2);
        tabHost.addTab(spec); //두번째 탭 추가

        spec = tabHost.newTabSpec("tab3");
        spec.setIndicator("예정 봉사");
        spec.setContent(R.id.tab3);
        tabHost.addTab(spec); //두번째 탭 추가

        tabHost.setCurrentTab(0); //기본 적으로 활성화 시킬 Tab 설정함
        //현재 Tab1 활성화. 1일 경우 Tab2 활성화.

        pointHistoryListView = (ListView)findViewById(R.id.tab1_listview);
        pointHistoryAdapter = new PointHistoryAdapter(this,R.layout.list_item_getpoint,pointHistoryInfoList);
        pointHistoryListView.setAdapter(pointHistoryAdapter);

        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.05",1,100));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.05",2,100));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.05",1,100));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.05",3,100));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.05",1,100));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.05",2,100));

        pointHistoryAdapter.notifyDataSetChanged();



        donateHistoryListView = (ListView)findViewById(R.id.tab2_listview);
        donateHistoryAdapter = new DonateHistoryAdapter(this,R.layout.list_item_donate_history,donateHistoryInfoList);
        donateHistoryListView.setAdapter(donateHistoryAdapter);

        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,1));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,2));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,3));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,1));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,2));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,3));

        donateHistoryAdapter.notifyDataSetChanged();


    }
}
