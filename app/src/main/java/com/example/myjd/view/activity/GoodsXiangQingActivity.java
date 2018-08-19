package com.example.myjd.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.myjd.bean.AddCartBean;
import com.example.myjd.bean.EventBusBean;
import com.example.myjd.mvp.contract.AddCart_Contract;
import com.example.myjd.mvp.presenter.AddCart_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class GoodsXiangQingActivity extends AppCompatActivity implements AddCart_Contract.View {

    private WebView mSecondWeb;
    private TextView mTvAddCart;
    private String uid;
    private String pid;
    private AddCart_Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * EventBus 注册
         */
        setContentView(R.layout.activity_goods_xiang_qing);
        //初始化控件
        initView();
        EventBus.getDefault().register(GoodsXiangQingActivity.this);
        presenter = new AddCart_Presenter(this);
        mTvAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.i("---------------uid:"+uid+"pid:"+pid);
                presenter.setData(uid,pid);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void Event(EventBusBean messageEvent) {
        Logger.i("--------------"+messageEvent.getUrl());
        uid = messageEvent.getUid();
        pid = messageEvent.getPid();
        String url = messageEvent.getUrl();
        mSecondWeb.loadUrl(url);
        mSecondWeb.setWebChromeClient(new WebChromeClient(){});
    }

    private void initView() {
        mSecondWeb = (WebView) findViewById(R.id.second_web);
        mTvAddCart = (TextView) findViewById(R.id.tv_addCart);
    }

    @Override
    protected void onDestroy() {
        /**
         * 解绑操作
         */
        EventBus.getDefault().unregister(this);
        presenter.onDestory();
        super.onDestroy();
    }

    @Override
    public void onFaild1(String errorMsg) {
        Logger.i(errorMsg);
    }

    @Override
    public void onSuccessful1(AddCartBean cartBean) {
        if (cartBean.getMsg().equals("加购成功")){
            ToastUtils.showToast(GoodsXiangQingActivity.this,"加购成功");
        }else {
            ToastUtils.showToast(GoodsXiangQingActivity.this,"吖，您还未登录,正在为你跳转登入界面"+cartBean.getMsg());
            startActivity(new Intent(GoodsXiangQingActivity.this, LoginActivity.class));
        }
    }
}
