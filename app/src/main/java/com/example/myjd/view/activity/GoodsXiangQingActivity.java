package com.example.myjd.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.myjd.view.R;

public class GoodsXiangQingActivity extends AppCompatActivity {

    private WebView mSecondWeb;
    private TextView mTvAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_xiang_qing);
        //初始化控件
        initView();
        String url = getIntent().getStringExtra("url");
        if(url!=null){
            mSecondWeb.loadUrl(url);
            mSecondWeb.setWebChromeClient(new WebChromeClient(){

            });
        }
    }

    private void initView() {
        mSecondWeb = (WebView) findViewById(R.id.second_web);
        mTvAddCart = (TextView) findViewById(R.id.tv_addCart);
    }
}
