package com.example.myjd.view.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myjd.adapter.HomeMutiplterRecyclerViewAdapter;
import com.example.myjd.base.BaseFragment;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.bean.MutilRecyclerBean;
import com.example.myjd.mvp.contract.Banner_Contract;
import com.example.myjd.mvp.presenter.Banner_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.view.R;
import com.example.myjd.widget.ClearEditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements Banner_Contract.View {
    Activity mActivity;
    private Banner_Contract.Presenter presenter;
    private List<MutilRecyclerBean> recyclerBeanList = new ArrayList<>();
    private android.support.design.widget.AppBarLayout mAppBar;
    private ImageView mToolbarIvSaoyisao;
    private ImageView mToolbarIvSearch;
    private TextView mToolbarEdiSearch;
    private ImageView mToolbarIvRoot;
    private ImageView mToolbarIvMsg;
    private RecyclerView mRecyview;
    private HomeMutiplterRecyclerViewAdapter adapter;

    @Override
    protected void otherOpration() {

    }

    @Override
    protected void onClickListener() {

    }

    @Override
    protected void setAdapter() {
        adapter = new HomeMutiplterRecyclerViewAdapter(recyclerBeanList);
        mRecyview.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        presenter = new Banner_Presenter(this);
        presenter.setData();
    }

    @Override
    protected void findView(View v) {
        initView(v);
    }


    @Override
    protected int initView() {
        return R.layout.fragment_home;
    }



    @Override
    public void onFaild(String errorMsg) {
        Logger.e(errorMsg);
    }

    @Override
    public void onSuccessful(HomeBean homeBean) {
        Logger.i(homeBean.getMsg());
        recyclerBeanList.add(new MutilRecyclerBean(homeBean,MutilRecyclerBean.TYPE_BANNER));
        adapter.notifyDataSetChanged();
    }

    private void initView(View v) {
        mToolbarIvSaoyisao = (ImageView) v.findViewById(R.id.toolbar_iv_saoyisao);
        mToolbarIvSearch = (ImageView) v.findViewById(R.id.toolbar_iv_search);
        mToolbarEdiSearch = (TextView) v.findViewById(R.id.toolbar_edi_search);
        mToolbarIvRoot = (ImageView) v.findViewById(R.id.toolbar_iv_root);
        mToolbarIvMsg = (ImageView) v.findViewById(R.id.toolbar_iv_msg);
        mRecyview = (RecyclerView) v.findViewById(R.id.recyview);
        mRecyview.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
