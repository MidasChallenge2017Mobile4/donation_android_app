package com.midas.donation_android_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YURIM on 2017-05-27.
 */


public class PointHistoryAdapter extends ArrayAdapter<PointHistoryInfo> {

    private ArrayList<PointHistoryInfo> items;
    private Context mContext;

    public PointHistoryAdapter(Context context, int textViewResourceId, ArrayList<PointHistoryInfo> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_item_getpoint, null);
        }

        PointHistoryInfo pointHistoryInfo = items.get(position);

        if (pointHistoryInfo != null) {
            TextView dateTextView = (TextView)v.findViewById(R.id.textview_date);
            dateTextView.setText(pointHistoryInfo.getDate());
            // 날짜 들어오는 형식에 맞춰서 처리

            TextView pointTextView = (TextView)v.findViewById(R.id.textview_point);
            pointTextView.setText(pointHistoryInfo.getPoint() + "pt");
            // 형식 처리
        }

        return v;
    }
}
