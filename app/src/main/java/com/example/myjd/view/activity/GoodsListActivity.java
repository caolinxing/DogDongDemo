package com.example.myjd.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myjd.adapter.GlistRecyclerAdapter;
import com.example.myjd.base.BaseActivity;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.mvp.contract.GoodsList_Contract;
import com.example.myjd.mvp.presenter.GoodsList_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListActivity extends BaseActivity implements GoodsList_Contract.View {
    @BindView(R.id.glist_recycler)
    RecyclerView glistRecycler;
    List<GoodsListBean.DataBean> goodsList = new ArrayList<>();
    private GlistRecyclerAdapter adapter;
    private GoodsList_Contract.Presenter presenter;

    @Override
    protected int bindView() {
        return R.layout.activity_goods_list;
    }

    @Override
    protected void setOtherOption() {

    }

    @Override
    protected void initData() {
        glistRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GlistRecyclerAdapter(R.layout.item_goods, goodsList);
        glistRecycler.setAdapter(adapter);
        presenter = new GoodsList_Presenter(this);
        Intent intent = getIntent();
        if (intent!=null){
            String psic = intent.getStringExtra("pscid");
            presenter.setData(psic);
        }else {
            presenter.setData("2");
        }
    }

    @Override
    protected void setClickListener() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @Override
    public void onFaild(String errorMsg) {
        Logger.i(errorMsg);
    }

    @Override
    public void onSuccessful(GoodsListBean goodsListBean) {
        goodsList.clear();
        ToastUtils.showToast(this,goodsListBean.getMsg()+"sssssssssssss");
        goodsList.addAll(goodsListBean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

