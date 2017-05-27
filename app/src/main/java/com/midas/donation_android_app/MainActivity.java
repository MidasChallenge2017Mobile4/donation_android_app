package com.midas.donation_android_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.midas.donation_android_app.database.DataBases;
import com.midas.donation_android_app.database.DbOpenHelper;
import com.midas.donation_android_app.volunteer.VolunteerActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mypageLayout;
    private LinearLayout donationLayout;
    private LinearLayout volunteerLayout;

    private TextView textView1;
    private TextView textView2;

    private PieChart pieChart;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();
    }

    private void setLayout(){


        mypageLayout = (LinearLayout) findViewById(R.id.linear_Mypage);
        mypageLayout.setOnClickListener(new View.OnClickListener() {
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

        textView1 = (TextView)findViewById(R.id.textview_1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                intent.putExtra("status",1);
                startActivity(intent);
            }
        });

        textView2 = (TextView)findViewById(R.id.textview_2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                intent.putExtra("status",2);
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
//        DbOpenHelper.DatabaseHelper openHelper = new DbOpenHelper.DatabaseHelper(getApplicationContext(), "memolist.db",null,1);
//        openHelper.getWritableDatabase().execSQL("INSERT INTO " + DataBases.CreatePHistoryTable._TABLENAME + " VALUES (null,1,'',2,310);");
//        openHelper.getWritableDatabase().close();

//        for (int c : ColorTemplate.JOYFUL_COLORS)
//            colors.add(c);

//        for (int c : ColorTemplate.VORDIPLOM_COLORS)
//        colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
//
//        for (int c : ColorTemplate.PASTEL_COLORS)
//            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        set.setColors(colors);

        PieData data = new PieData(set);
        data.setValueTextSize(12f);
        data.setValueTextColor(R.color.text2);

        Description description = new Description();
        description.setText("");
        pieChart.setDescription(description);
        pieChart.setData(data);

        Legend legend = pieChart.getLegend();
        legend.setEnabled(false);
        pieChart.invalidate(); // refresh
    }
}
