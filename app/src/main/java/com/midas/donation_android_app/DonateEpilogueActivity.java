package com.midas.donation_android_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;


public class DonateEpilogueActivity extends AppCompatActivity {
    WebView webpage;
    ImageButton back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_epilogue);


        back_btn = (ImageButton) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        webpage = (WebView) findViewById(R.id.webview);
        WebSettings webSet = webpage.getSettings();

        webSet.setJavaScriptEnabled(true);
        webSet.setLoadWithOverviewMode(true);
        webSet.setUseWideViewPort(true);
        webSet.setDomStorageEnabled(true);
        webSet.setAppCacheEnabled(false);

        webSet.setJavaScriptCanOpenWindowsAutomatically(true);
        webSet.setSupportMultipleWindows(true);

        WebChromeClient ChromeClient = new WebChromeClient(); //팝업창 처리
        webpage .setWebChromeClient(ChromeClient); //팝업창 처리

        webpage.setFocusable(true);
        webpage.setWebViewClient(new WebViewClient() {


            @Override
            public void onLoadResource(WebView view, String url) {
                //페이지
                super.onLoadResource(view, url);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //페이지 끝날 때
                super.onPageFinished(view, url);


            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //페이지 시작할 때
                super.onPageStarted(view, url, favicon);

            }
        });
        webpage.setOnTouchListener(new View.OnTouchListener() {
            float downY = 0f, down = 0f, up = 0f;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    downY = webpage.getScrollY();
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    down = downY + 100;
                    up=downY-100;
                    //up = downY - 80;


                }
                return false;
            }
        });
        webpage.getSettings().setBuiltInZoomControls(true);
        webpage.getSettings().setSupportZoom(true);
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");

        webpage.loadUrl(url);
        // webpage.setOnDragListener();
    }





}
