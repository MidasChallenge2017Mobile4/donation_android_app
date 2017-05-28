package com.midas.donation_android_app.volunteer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.midas.donation_android_app.R;

public class VolunteerActivity extends AppCompatActivity {

    Fragment[] arrFragments;
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        backButton = (ImageButton) findViewById(R.id.back_btn);

        arrFragments = new Fragment[3];
        arrFragments[0] = new VtListFragment();
        arrFragments[1] = new VtFinishFragment();
        arrFragments[2] = new VtMyListFragment();

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), arrFragments);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class MainPagerAdapter extends FragmentPagerAdapter {

        Fragment[] arrFragments;

        public MainPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }




        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "진행중인 봉사 ";
                case 1:
                    return "종료된 봉사";
                case 2:
                    return "나의 봉사 내역";

                default:
                    return "";
            }
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }
    }
}


