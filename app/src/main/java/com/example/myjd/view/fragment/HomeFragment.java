package com.example.myjd.view.fragment;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myjd.adapter.HomeMutiplterRecyclerViewAdapter;
import com.example.myjd.base.BaseFragment;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.bean.MutilRecyclerBean;
import com.example.myjd.mvp.contract.HomePage_Contract;
import com.example.myjd.mvp.presenter.HomePage_Presenter;
import com.example.myjd.mvp.presenter.JiuDaoHang_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.view.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomePage_Contract.View {
    Activity mActivity;
    private HomePage_Contract.Presenter presenter;
    private List<MutilRecyclerBean> recyclerBeanList = new ArrayList<>();
    private android.support.design.widget.AppBarLayout mAppBar;
    private ImageView mToolbarIvSaoyisao;
    private ImageView mToolbarIvSearch;
    private TextView mToolbarEdiSearch;
    private ImageView mToolbarIvRoot;
    private ImageView mToolbarIvMsg;
    private RecyclerView mRecyview;
    private HomeMutiplterRecyclerViewAdapter adapter;
    private JiuDaoHang_Presenter presenter1;
    JGGDaoHangBean jggDaoHangBean1;
    HomeBean homeBean1;

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
        presenter = new HomePage_Presenter(this);
        presenter.setData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.setData1();
            }
        },200);
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
        homeBean1 = homeBean;
        recyclerBeanList.add(new MutilRecyclerBean(homeBean1,null,MutilRecyclerBean.TYPE_BANNER));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMsg) {
        Logger.e(errorMsg);
    }

    @Override
    public void onSuccess(JGGDaoHangBean jggDaoHangBean) {
        Logger.i(jggDaoHangBean.getMsg());
        recyclerBeanList.add(new MutilRecyclerBean(homeBean1,jggDaoHangBean,MutilRecyclerBean.TYPE_CAIDAN));
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
