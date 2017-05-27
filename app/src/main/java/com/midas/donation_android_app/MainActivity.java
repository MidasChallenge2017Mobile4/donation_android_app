package com.midas.donation_android_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.midas.donation_android_app.volunteer.VolunteerActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mypageBtn;
    private LinearLayout donationLayout;
    private LinearLayout volunteerLayout;

    private PieChart pieChart;

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

        donationLayout = (LinearLayout) findViewById(R.id.linear_donation);
        donationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DonateActivity.class);
                startActivity(intent);
            }
        });

        volunteerLayout = (LinearLayout)findViewById(R.id.linear_volunteer);
        volunteerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolunteerActivity.class);
                startActivity(intent);
            }
        });
        makePieChart();
    }

    private void makePieChart(){
        pieChart = (PieChart)findViewById(R.id.piechart);

        List<PieEntry> entries = new ArrayList<>();

//        파이차트에 데이터넣기

        entries.add(new PieEntry(45f, "아침"));
        entries.add(new PieEntry(30f, "운동"));
        entries.add(new PieEntry(25f, "정시출근"));

        PieDataSet set = new PieDataSet(entries, "");

        ArrayList<Integer> colors = new ArrayList<Integer>();


        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
        colors.add(c);

//        for (int c : ColorTemplate.COLORFUL_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.LIBERTY_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.PASTEL_COLORS)
//            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        set.setColors(colors);

        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.invalidate(); // refresh
    }
}
