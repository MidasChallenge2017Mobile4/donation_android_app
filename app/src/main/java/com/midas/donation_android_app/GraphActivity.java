package com.midas.donation_android_app;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    private BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        setLayout();
    }

    private void setLayout(){
        barChart = (BarChart) findViewById(R.id.barchart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        entries.add(new BarEntry(4f, 60f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");

        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        data.setValueTextSize(12f);

        Legend legend = barChart.getLegend();

        YAxis left = barChart.getAxisLeft();
        YAxis right = barChart.getAxisLeft();
        XAxis xAxis = barChart.getXAxis();

        left.setDrawAxisLine(false); // no axis line
        left.setDrawGridLines(false); // no grid lines
        right.setDrawAxisLine(false); // no axis line
        right.setDrawGridLines(false); // no grid lines
        right.setDrawLabels(true);
        right.setDrawZeroLine(true);
        xAxis.setDrawLabels(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        barChart.getXAxis().setEnabled(false);
        barChart.getAxisRight().setDrawAxisLine(false);


        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        set.setColors(colors);

        Description description = new Description();
        description.setText("");
        barChart.setDescription(description);
        barChart.setData(data);
        barChart.setDrawBorders(false);
        barChart.setBorderColor(R.color.white);

        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh
    }
}
