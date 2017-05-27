package com.midas.donation_android_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.midas.donation_android_app.Info.DonateHistoryInfo;
import com.midas.donation_android_app.R;

import java.util.ArrayList;

/**
 * Created by YURIM on 2017-05-27.
 */

public class DonateHistoryAdapter extends ArrayAdapter<DonateHistoryInfo> {

    private ArrayList<DonateHistoryInfo> items;
    private Context mContext;

    public DonateHistoryAdapter(Context context, int textViewResourceId, ArrayList<DonateHistoryInfo> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_item_donate_history, null);
        }

        DonateHistoryInfo donateHistoryInfo = items.get(position);

        if (donateHistoryInfo != null) {
            TextView titleTextView = (TextView)v.findViewById(R.id.textview_title);
            titleTextView.setText(donateHistoryInfo.getTitle());

            TextView amountTextView = (TextView)v.findViewById(R.id.textview_amount);
            amountTextView.setText(donateHistoryInfo.getAmount() + "pt");
            // 형식 처리

            TextView statusTextView = (TextView)v.findViewById(R.id.textview_status);
            switch (donateHistoryInfo.getStatus()){
                case 1:
                    statusTextView.setText("진행중");
                    break;
                case 2:
                    statusTextView.setText("실패");
                    break;
                case 3:
                    statusTextView.setText("완료");
                    break;
            }


        }

        return v;
    }
}
