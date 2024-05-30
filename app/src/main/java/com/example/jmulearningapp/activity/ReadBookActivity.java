package com.example.jmulearningapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jmulearningapp.R;

public class ReadBookActivity extends Activity {
    private TextView tv_back;
    private TextView tv_main_title;
    private TextView tv_save;
    private RelativeLayout title_bar;
    private WebView webView;
    private String path;

    private int currentPage = 1;

    private String vId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book);

        initView();
    }

    private void initView() {
        tv_back = findViewById(R.id.tv_back);
        tv_main_title = findViewById(R.id.tv_main_title);
        tv_save = findViewById(R.id.tv_save);
        title_bar = findViewById(R.id.title_bar);
        tv_main_title.setText("经典阅读");
        title_bar.setBackgroundColor(Color.parseColor("#D81B60"));

        webView=findViewById(R.id.wv_list);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent=getIntent();
        vId = intent.getStringExtra("st");

        // 保证从APP加载网页
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        loadPage();
        // 侦听退出按钮事件
        tv_back = findViewById(R.id.tv_back);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.jmulearningapp.activity.ReadBookActivity.this.finish();
            }
        });
        // 侦听上一页下一页按钮侦听事件
        Button prevButton = findViewById(R.id.btn_previous);
        Button nextButton = findViewById(R.id.btn_next);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPage > 1)
                    currentPage--;
                loadPage();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage++;
                loadPage();
            }
        });
    }
    private void loadPage() {
        switch (vId){
            case "2131231154":webView.loadUrl("http://47.245.90.4/res/classic/classic_1.html?page="+currentPage);break;
            case "2131231155":webView.loadUrl("http://47.245.90.4/res/classic/classic_2.html?page="+currentPage);break;
            case "2131231156":webView.loadUrl("http://47.245.90.4/res/classic/classic_3.html?page="+currentPage);break;
            case "2131231157":webView.loadUrl("http://47.245.90.4/res/classic/classic_4.html?page="+currentPage);break;
        }
    }
}