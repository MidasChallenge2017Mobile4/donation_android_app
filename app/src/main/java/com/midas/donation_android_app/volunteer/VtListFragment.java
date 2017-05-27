package com.midas.donation_android_app.volunteer;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.midas.donation_android_app.R;
import com.midas.donation_android_app.application.ApplicationController;
import com.midas.donation_android_app.database.DbOpenHelper;

import java.util.ArrayList;

/**
 * Created by chaeeun on 2017-05-27.
 */
public class VtListFragment extends Fragment {

    private ArrayList<VtListData> vtList;
    private VolunteerListAdapter volunteerListAdapter;
    LinearLayoutManager mLayoutManager;
    DbOpenHelper mDbOpenHelper;

    public VtListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_vt_list, container, false);

        vtList = new ArrayList<VtListData>();
        mDbOpenHelper = ApplicationController.getInstance().mDbOpenHelper;

//        for (int i = 0; i < 20; i++) {
//            VtListData vtListData1 = new VtListData();
//            vtListData1.setTitle("마이다스 나눔가게,\n사랑의 의류나눔");
//            vtListData1.setImage(R.drawable.e1);
//            vtListData1.setDate("2017.05.27");
//            matchingListDatas.add(vtListData1);
//
//        }

        VtListData vtListData1 = new VtListData();
        vtList =  mDbOpenHelper.DbMainSelect();


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
        public VolunteerListViewHolder(View itemView) {
            super(itemView);
            iv_img = (RelativeLayout) itemView.findViewById(R.id.iv_img);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), VtDetailActivity.class);
                    startActivity(intent);


                }
            });

        }


    }


}
