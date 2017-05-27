package com.midas.donation_android_app.volunteer;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.midas.donation_android_app.R;
import com.midas.donation_android_app.application.ApplicationController;
import com.midas.donation_android_app.database.DbOpenHelper;

import java.util.ArrayList;

/**
 * Created by ichaeeun on 2017. 5. 27..
 */
public class VtDetailActivity extends AppCompatActivity {

    private ImageButton backButton;
    private ImageButton shareButton;

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private DbOpenHelper dbOpenHelper;
    ArrayList<VtListData> vtList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vt_detail);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        backButton = (ImageButton)findViewById(R.id.back_btn);
        shareButton = (ImageButton)findViewById(R.id.share_btn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCardAdapter = new CardPagerAdapter();
        dbOpenHelper = ApplicationController.getInstance().mDbOpenHelper;
        vtList = dbOpenHelper.DbMainSelect();

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "제목테스트");
                intent.putExtra(Intent.EXTRA_TEXT, "내용테스트");
                Intent chooser = Intent.createChooser(intent, "공유");
                startActivity(chooser);
            }
        });



        mCardAdapter.addCardItem(new CardItem(vtList.get(0).getContent1(), vtList.get(0).image1));
        mCardAdapter.addCardItem(new CardItem(vtList.get(0).getContent2(), vtList.get(0).image2));
        mCardAdapter.addCardItem(new CardItem(vtList.get(0).getContent3(), vtList.get(0).image3));
        mCardAdapter.addCardItem(new CardItem(vtList.get(0).getContent4(), vtList.get(0).image4));
        mCardAdapter.addCardItem(new CardItem(vtList.get(0).getContent5(), vtList.get(0).image5));


        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
    }
}
