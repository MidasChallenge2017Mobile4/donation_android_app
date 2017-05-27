package com.midas.donation_android_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.midas.donation_android_app.Info.Donation;
import com.midas.donation_android_app.R;

import java.util.ArrayList;

/**
 * Created by Soora on 2017-05-27.
 */

public class DonateAdapter extends ArrayAdapter<Donation> {

    ArrayList<Donation> items;
    Context context;
    public DonateAdapter(Context context, int textViewResourceId,
                         ArrayList<Donation> objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
        this.items = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.donate_row, null);
        }
        Donation d = items.get(position);
        if (d != null) {
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView date = (TextView) v.findViewById(R.id.date);
            TextView goal = (TextView) v.findViewById(R.id.goal);
            TextView total = (TextView) v.findViewById(R.id.total);
            if (title != null)
            {
                title.setText(d.getTitle());
            }
            if (date != null)
            {
                date.setText(d.getDate());
            }
            if (goal != null)
            {
                goal.setText(d.getGoal()+"원 목표");
            }
            if (total != null)
            {
                total.setText(d.getTotal()/d.getGoal()+"%");
            }
        }
        return v;
    }
}
