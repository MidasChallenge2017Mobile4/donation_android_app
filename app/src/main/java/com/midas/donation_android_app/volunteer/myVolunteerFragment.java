package com.midas.donation_android_app.volunteer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midas.donation_android_app.R;

/**
 * Created by chaeeun on 2017-05-27.
 */
public class myVolunteerFragment extends Fragment {


    public myVolunteerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_volunteer, container, false);
    }

}
