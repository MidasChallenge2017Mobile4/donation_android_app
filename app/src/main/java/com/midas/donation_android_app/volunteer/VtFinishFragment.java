package com.midas.donation_android_app.volunteer;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.midas.donation_android_app.R;
import com.midas.donation_android_app.application.ApplicationController;
import com.midas.donation_android_app.database.DbOpenHelper;

import java.util.ArrayList;

/**
 * Created by chaeeun on 2017-05-27.
 */
public class VtFinishFragment extends Fragment {

    private ArrayList<VtListData> vtList;
    private VolunteerListAdapter volunteerListAdapter;
    LinearLayoutManager mLayoutManager;
    DbOpenHelper mDbOpenHelper;

    public VtFinishFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_vt_list, container, false);

        mDbOpenHelper = ApplicationController.getInstance().mDbOpenHelper;


        vtList =  mDbOpenHelper.DbVtFinishSelect();


        RecyclerView rvVoluteerList = (RecyclerView) baseView.findViewById(R.id.rv_list);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVoluteerList.setLayoutManager(mLayoutManager);

        volunteerListAdapter = new VolunteerListAdapter();
        rvVoluteerList.setAdapter(volunteerListAdapter);


        return baseView;

    }


    class VolunteerListAdapter extends RecyclerView.Adapter<VolunteerListViewHolder> {

        @Override
        public VolunteerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View baseView = getActivity().getLayoutInflater().inflate(R.layout.list_item_volunteer, parent, false);
            VolunteerListViewHolder postViewHolder = new VolunteerListViewHolder(baseView);
            return postViewHolder;
        }

        @Override
        public void onBindViewHolder(VolunteerListViewHolder holder, int position) {


            holder.iv_img.setBackgroundResource(vtList.get(position).getImage1());
            holder.tv_date.setText(vtList.get(position).getDate());
            holder.tv_title.setText(vtList.get(position).getTitle());
            holder.chk_like.setChecked(vtList.get(position).isChecked());


        }

        @Override
        public int getItemCount() {
            return vtList.size();
        }
    }


    class VolunteerListViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout iv_img;
        public TextView tv_title;
        public TextView tv_date;
        public CheckBox chk_like;
        public VolunteerListViewHolder(View itemView) {
            super(itemView);
            iv_img = (RelativeLayout) itemView.findViewById(R.id.iv_img);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            chk_like = (CheckBox) itemView.findViewById(R.id.chk_like);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    Intent intent = new Intent(getActivity(), VtDetailActivity.class);
                    intent.putExtra("title",vtList.get(position).title);
                    startActivity(intent);




                }
            });

            chk_like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    int position = getLayoutPosition();
                    mDbOpenHelper.DbUpdateChk(vtList.get(position).id, isChecked);
                }
            });

        }


    }


}
