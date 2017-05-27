package com.midas.donation_android_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
            TextView state = (TextView) v.findViewById(R.id.state);
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
                goal.setText(d.getGoal()+"원");
            }
            if (total != null)
            {
                total.setText((d.getTotal()/d.getGoal())*100+"%");
            }
            if(state !=null){
                if(d.getState()==2) {
                    state.setText("모금실패");
                }
            }
        }
        return v;
    }
}
