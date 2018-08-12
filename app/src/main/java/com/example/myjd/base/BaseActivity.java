package com.example.myjd.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myjd.utils.ZTLUtils;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2016/7/22.
 */
import butterknife.BindView;
public abstract class BaseActivity extends AppCompatActivity {
    public Activity mActivity;
    private Unbinder bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定视图
        setContentView(bindView());
        mActivity = this;
        //沉浸式
        ImmersiveMode();
        //获取ButterKnife
        bind = ButterKnife.bind(this);
        //初始化
        init();
    }

    private void ImmersiveMode() {
        View view = mActivity.getWindow().getDecorView();
        new ZTLUtils(mActivity).setTranslucentStatus(view);
    }


    private void init() {
        //初始化数据
        initData();
        //点击监听
        setClickListener();
        //其他操作
        setOtherOption();
    }

    protected abstract int bindView();



    protected abstract void setOtherOption();

    protected abstract void initData();

    protected abstract void setClickListener();

    @Override
    protected void onDestroy() {
        bind.unbind();
        super.onDestroy();
    }
}
