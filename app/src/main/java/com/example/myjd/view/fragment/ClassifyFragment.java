package com.example.myjd.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myjd.adapter.MyCfyRecyclerAdapter_Left;
import com.example.myjd.adapter.MyCfyecyclerViewAdapter_Right;
import com.example.myjd.base.BaseFragment;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.bean.MutilRecyclerBean_GoodsXaingQing;
import com.example.myjd.mvp.contract.JiuDaoHang_Contract;
import com.example.myjd.mvp.presenter.JiuDaoHang_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.view.R;
import com.example.myjd.view.activity.GoodsListActivity;
import com.example.myjd.widget.ClearEditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment implements JiuDaoHang_Contract.View {


    private ImageView mToolbarIvSaoyisao;
    private ImageView mToolbarIvSearch;
    private ClearEditText mToolbarEdiSearch;
    private ImageView mToolbarIvRoot;
    private ImageView mToolbarIvMsg;
    private RecyclerView mRecyclerType;
    private RecyclerView mRecyclerXiangqing;
    private JiuDaoHang_Contract.Presenter presenter;
    private List<JGGDaoHangBean.DataBean> goodsList = new ArrayList<>();
    private List<MutilRecyclerBean_GoodsXaingQing> dataList = new ArrayList<>();
    private MyCfyRecyclerAdapter_Left adapter_left;
    private MyCfyecyclerViewAdapter_Right adapter_right;
    private int i=1;

    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    protected void otherOpration() {

    }

    @Override
    protected void onClickListener() {
        adapter_left.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.i(goodsList.get(position).isIschecked()+"------0");
                for (int j = 0; j <goodsList.size() ; j++) {
                    if (position==j){
                        goodsList.get(j).setIschecked(true);
                    }else {
                        goodsList.get(j).setIschecked(false);
                    }
                }
                adapter_left.notifyDataSetChanged();
                dataList.clear();
                presenter.setData();
                setLeftadapter();
            }
        });
        adapter_right.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                i++;
                Intent intent = new Intent(getActivity(), GoodsListActivity.class);
                if (i%2==0){
                    intent.putExtra("pscid","1");
                }else if (i%2==1){
                    intent.putExtra("pscid","2");
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setAdapter() {
        adapter_left = new MyCfyRecyclerAdapter_Left(R.layout.item_goodslist, goodsList);
        mRecyclerType.setAdapter(adapter_left);
        dataList.add(new MutilRecyclerBean_GoodsXaingQing(null,MutilRecyclerBean_GoodsXaingQing.TYPE_PIC));
        adapter_right = new MyCfyecyclerViewAdapter_Right(dataList);
        mRecyclerXiangqing.setAdapter(adapter_right);
    }

    private void setLeftadapter() {
        adapter_right.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        presenter.setData();
    }

    @Override
    protected void findView(View v) {
        //初始化控件
        initView(v);
        presenter = new JiuDaoHang_Presenter(this);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_classify;
    }

    private void initView(View v) {
        mToolbarIvSaoyisao = (ImageView) v.findViewById(R.id.toolbar_iv_saoyisao);
        mToolbarIvSearch = (ImageView) v.findViewById(R.id.toolbar_iv_search);
        mToolbarEdiSearch = (ClearEditText) v.findViewById(R.id.toolbar_edi_search);
        mToolbarIvRoot = (ImageView) v.findViewById(R.id.toolbar_iv_root);
        mToolbarIvMsg = (ImageView) v.findViewById(R.id.toolbar_iv_msg);
        mRecyclerType = (RecyclerView) v.findViewById(R.id.recycler_type);
        mRecyclerXiangqing = (RecyclerView) v.findViewById(R.id.recycler_xiangqing);
        mRecyclerType.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerXiangqing.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public Context getCurContext() {
        return getActivity();
    }

    @Override
    public void onFaild(String errorMsg) {
        Logger.i(errorMsg);
    }

    @Override
    public void onSuccessful(JGGDaoHangBean homeBean) {
     //   ToastUtils.showToast(getActivity(),"请求到"+homeBean.getData().size()+"条数据");
        goodsList.clear();
        goodsList.addAll(homeBean.getData());
        for (int i = 0; i <4 ; i++) {
            if (i==0){
                dataList.add(new MutilRecyclerBean_GoodsXaingQing(null,MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO1));
            }else if (i==1){
                dataList.add(new MutilRecyclerBean_GoodsXaingQing(homeBean,MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO1_1));
            }else if (i==2){
                dataList.add(new MutilRecyclerBean_GoodsXaingQing(null,MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO2));
            }else if (i==3){
                dataList.add(new MutilRecyclerBean_GoodsXaingQing(homeBean,MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO2_1));
            }
        }
        adapter_right.notifyDataSetChanged();
    }
}
