package com.example.jmulearningapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jmulearningapp.R;

/**
 * @author lrui1
 * @description
 * @date 2024/5/30 15:08
 */
public class ReadBookActivity extends Activity {
    private TextView tv_back;
    private TextView tv_main_title;
    private TextView tv_save;
    private RelativeLayout title_bar;
    private WebView webView;
    private String path;
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
        title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));

        webView=findViewById(R.id.wv_list);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent=getIntent();

        switch (intent.getStringExtra("st")){
            case "2131230908":webView.loadUrl("http://47.100.53.114/book/m1.php?page=1");break;
            case "2131230909":webView.loadUrl("http://47.100.53.114/book/m2.php?page=1");break;
            case "2131230910":webView.loadUrl("http://47.100.53.114/book/m3.php?page=1");break;
            case "2131230911":webView.loadUrl("http://47.100.53.114/book/m4.php?page=1");break;
        }
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        tv_back = findViewById(R.id.tv_back);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.jmulearningapp.activity.ReadBookActivity.this.finish();
            }
        });
    }

}
