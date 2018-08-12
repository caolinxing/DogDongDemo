package com.example.myjd.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myjd.view.R;

public abstract class BaseFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(initView(), container, false);
        setHasOptionsMenu(true);
        //初始化
        init(v);
        return v;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_layout, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void init(View v) {
        //初始化
        findView(v);
        //设置适配器
        setAdapter();
        //加载数据
        initData();
        //点击监听
        onClickListener();
        //预留接口
        otherOpration();
    }

    protected abstract void otherOpration();

    protected abstract void onClickListener();

    protected abstract void setAdapter();

    protected abstract void initData();

    protected abstract void findView(View v);

    protected abstract int initView();
}
