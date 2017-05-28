package com.midas.donation_android_app;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.midas.donation_android_app.Adapter.DonateHistoryAdapter;
import com.midas.donation_android_app.Adapter.PointHistoryAdapter;
import com.midas.donation_android_app.Info.DonateHistoryInfo;
import com.midas.donation_android_app.Info.PointHistoryInfo;
import com.midas.donation_android_app.application.ApplicationController;
import com.midas.donation_android_app.database.DbOpenHelper;
import com.midas.donation_android_app.volunteer.VtListData;

import java.sql.SQLException;
import java.util.ArrayList;

public class MyPageActivity extends AppCompatActivity {

    private TabHost tabHost;

    private ListView pointHistoryListView;
    private ArrayList<PointHistoryInfo> pointHistoryInfoList = new ArrayList<PointHistoryInfo>();
    private PointHistoryAdapter pointHistoryAdapter;

    private ListView donateHistoryListView;
    private ArrayList<DonateHistoryInfo> donateHistoryInfoList = new ArrayList<DonateHistoryInfo>();
    private DonateHistoryAdapter donateHistoryAdapter;

    private ListView volunteerListView;
    private ArrayList<VtListData> vtListDataList = new ArrayList<VtListData>();
//    private DonateHistoryAdapter donateHistoryAdapter;

    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        init();
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
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

        mDbOpenHelper= ApplicationController.getInstance().mDbOpenHelper;

//        mDbOpenHelper.getAllPHistory();
//        mDbOpenHelper.getAllDonateHistory();


        pointHistoryListView = (ListView)findViewById(R.id.tab1_listview);
        pointHistoryAdapter = new PointHistoryAdapter(this,R.layout.list_item_getpoint,pointHistoryInfoList);
        pointHistoryListView.setAdapter(pointHistoryAdapter);

        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.05",2,200));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.10",1,100));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.18",3,300));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.04.27",3,300));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.05.07",2,200));
        pointHistoryInfoList.add(0, new PointHistoryInfo("2017.05.05",1,100));
        pointHistoryAdapter.notifyDataSetChanged();
//

        donateHistoryListView = (ListView)findViewById(R.id.tab2_listview);
        donateHistoryAdapter = new DonateHistoryAdapter(this,R.layout.list_item_donate_history,donateHistoryInfoList);
        donateHistoryListView.setAdapter(donateHistoryAdapter);

        donateHistoryInfoList.add(0, new DonateHistoryInfo("나눔쌀화환 기부",1000,1));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("김장나눔행사 기부",2000,2));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("의류나눔행사 기부",1000,2));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("사랑의도시락 나눔 기부",1000,1));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄나눔행사 기부",3000,3));
        donateHistoryInfoList.add(0, new DonateHistoryInfo("주거환경개선행사 기부",1000,3));

        donateHistoryAdapter.notifyDataSetChanged();

//      봉사 탭
//        volunteerListView = (ListView)findViewById(R.id.tab3_listview);
//        donateHistoryAdapter = new DonateHistoryAdapter(this,R.layout.list_item_donate_history,vtListDataList);
//        volunteerListView.setAdapter(donateHistoryAdapter);
//
//
//        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,1));
//        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,2));
//        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,3));
//        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,1));
//        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,2));
//        donateHistoryInfoList.add(0, new DonateHistoryInfo("연탄모금행사 기부",300,3));
//
//        donateHistoryAdapter.notifyDataSetChanged();

    }

}
