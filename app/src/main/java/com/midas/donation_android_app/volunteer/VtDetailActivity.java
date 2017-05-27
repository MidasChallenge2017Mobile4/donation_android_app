package com.midas.donation_android_app.volunteer;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.midas.donation_android_app.R;

public class VtDetailActivity extends AppCompatActivity {

    private ImageButton backButton;

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vt_detail);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        backButton = (ImageButton)findViewById(R.id.back_btn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("봉사제목1", "봉사설명1"));
        mCardAdapter.addCardItem(new CardItem("봉사제목2", "봉사설명2"));
        mCardAdapter.addCardItem(new CardItem("봉사제목3", "봉사설명3"));
        mCardAdapter.addCardItem(new CardItem("봉사제목4", "봉사설명4"));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
    }
}
