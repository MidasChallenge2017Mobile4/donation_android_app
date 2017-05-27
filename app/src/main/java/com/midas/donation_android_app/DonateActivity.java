package com.midas.donation_android_app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class DonateActivity extends AppCompatActivity {
    TabHost tabHost;
    ListView tab1list, tab2list, tab3list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
        Date currentTime = new Date ();
        String mTime = mSimpleDateFormat.format ( currentTime );

        Donate1 tab1db = new Donate1();
        tab1db.execute(mTime);

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
        ArrayList<Donation> donateArr1 = new ArrayList<Donation>();
        Donation d1 = new Donation("제목1", "2017.05.27", 1000, 10000, 1);
        Donation d2 = new Donation("제목2", "2017.05.27", 1000, 10000, 1);
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

    public class Donate1 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String result = null;
            DonateService service = getDonateService();
            Call<List<Donation>> c = service.DonateInfo(params[0]);
            try {
                c.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        public DonateService getDonateService(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.48/") // '/'를 꼭 붙여주어야함!
                    //json과 xml을 사용하기 위함
                    .addConverterFactory(GsonConverterFactory.create())
                    //    .addConverterFactory(SimpleXmlConverterFactory.create()) //xml 사용하기 위해서
                    .build();
            DonateService service =  retrofit.create(DonateService.class);
            return service;
        }
    }

    public interface DonateService {
        @FormUrlEncoded
        @POST("donate1.php") // '/'를 붙이지 않음
        //siteurl으로 찾는 예시
        public Call<List<Donation>> DonateInfo(@Field("date") String date);
    }

}
