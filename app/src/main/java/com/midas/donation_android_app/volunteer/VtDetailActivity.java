package com.midas.donation_android_app.volunteer;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView main_title;

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private DbOpenHelper dbOpenHelper;
    private String title;
    private VtListData vtItem;
    private Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vt_detail);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        backButton = (ImageButton)findViewById(R.id.back_btn);
        main_title = (TextView) findViewById(R.id.main_title);
        shareButton = (ImageButton)findViewById(R.id.share_btn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCardAdapter = new CardPagerAdapter();
        dbOpenHelper = ApplicationController.getInstance().mDbOpenHelper;
        applyButton = (Button) findViewById(R.id.btn_apply);

        Intent intent = getIntent();
        title = intent.getExtras().getString("title");
        vtItem = dbOpenHelper.DbVtDetailSelect(title);


        if(vtItem.isChecked == true) {
            applyButton.setText("참여확정");
        } else {
            applyButton.setText("참여하기");
        }

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, vtItem.content1);
                intent.putExtra(Intent.EXTRA_TEXT, vtItem.date);
                Intent chooser = Intent.createChooser(intent, "공유");
                startActivity(chooser);
            }
        });



        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Toast.makeText(getApplicationContext(),"참여 신청이 되었습니다.",Toast.LENGTH_LONG).show();
                    applyButton.setText("참여확정");
                    dbOpenHelper.DbUpdateChk(vtItem.id, true);


            }
        });

        mCardAdapter.addCardItem(new CardItem(vtItem.getContent1(), vtItem.image1));
        mCardAdapter.addCardItem(new CardItem(vtItem.getContent2(), vtItem.image2));
        mCardAdapter.addCardItem(new CardItem(vtItem.getContent3(), vtItem.image3));
        mCardAdapter.addCardItem(new CardItem(vtItem.getContent4(), vtItem.image4));
        mCardAdapter.addCardItem(new CardItem(vtItem.getContent5(), vtItem.image5));
        main_title.setText(vtItem.getTitle());


        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);


    }
}
