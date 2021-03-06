package com.midas.donation_android_app.volunteer;



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

import java.util.ArrayList;

/**
 * Created by chaeeun on 2017-05-27.
 */
public class VolunteerListFragment extends Fragment {

    private ArrayList<VolunteerListData> matchingListDatas;
    private VolunteerListAdapter volunteerListAdapter;

    public VolunteerListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_volunteer_list, container, false);

        matchingListDatas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            VolunteerListData matchingListData1 = new VolunteerListData();
            matchingListData1.setTitle("마이다스 나눔가게,\n사랑의 의류나눔");
            matchingListData1.setImage(R.drawable.sep_img_5_03);
            matchingListData1.setDate("2017.05.27");
            matchingListDatas.add(matchingListData1);

        }

        RecyclerView rvVoluteerList = (RecyclerView) baseView.findViewById(R.id.rv_list);
        rvVoluteerList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
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


            holder.iv_img.setBackgroundResource(matchingListDatas.get(position).getImage());
            holder.tv_date.setText(matchingListDatas.get(position).getDate());
            holder.tv_title.setText(matchingListDatas.get(position).getTitle());


        }

        @Override
        public int getItemCount() {
            return matchingListDatas.size();
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
//                    Intent intent = new Intent(getActivity(), VolunteerDetailActivity.class);
//                    startActivity(intent);
                    Toast.makeText(getContext(), "클릭", Toast.LENGTH_SHORT);

                }
            });

        }


    }


}
