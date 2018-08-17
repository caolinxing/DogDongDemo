package com.example.myjd.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myjd.adapter.GlistRecyclerAdapter;
import com.example.myjd.adapter.SearchRecyclerAdapter;
import com.example.myjd.base.BaseActivity;
import com.example.myjd.bean.EventBusBean;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.bean.SearchBean;
import com.example.myjd.mvp.contract.GoodsList_Contract;
import com.example.myjd.mvp.contract.Search_Contract;
import com.example.myjd.mvp.presenter.GoodsList_Presenter;
import com.example.myjd.mvp.presenter.Search_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsListActivity extends BaseActivity implements GoodsList_Contract.View, Search_Contract.View {
    @BindView(R.id.glist_recycler)
    RecyclerView glistRecycler;
    List<GoodsListBean.DataBean> goodsList = new ArrayList<>();
    List<SearchBean.DataBean> searchList = new ArrayList<>();
    @BindView(R.id.toolbar_iv_kind)
    ImageView toolbarIvKind;
    @BindView(R.id.toolbar_edi_search)
    EditText toolbarEdiSearch;
    @BindView(R.id.toolbar_iv_search)
    ImageView toolbarIvSearch;
    @BindView(R.id.toolbar_iv_saoyisao)
    ImageView toolbarIvSaoyisao;
    @BindView(R.id.toolbar_iv_root)
    ImageView toolbarIvRoot;
    @BindView(R.id.tv_px_zonghe)
    TextView tvPxZonghe;
    @BindView(R.id.tv_px_xiaoliang)
    TextView tvPxXiaoliang;
    @BindView(R.id.tv_px_price)
    TextView tvPxPrice;
    @BindView(R.id.tv_px_sx)
    TextView tvPxSx;
    private GlistRecyclerAdapter adapter;
    private GoodsList_Contract.Presenter presenter;
    boolean flag = true;
    private Search_Presenter presenter1;
    int page = 0;
    int sort_moRen = 0;
    int sort_xiaoLiang = 1;
    int sort_price = 2;
    private SearchRecyclerAdapter adapter1;
    SearchBean searchBean1 ;
    private String uid;

    @Override
    protected int bindView() {
        return R.layout.activity_goods_list;
    }

    @Override
    protected void setOtherOption() {

    }
    @Override
    protected void initData() {
        /**
         * sp:uid
         */
        SharedPreferences userInfo = getSharedPreferences("userinfo", MODE_PRIVATE);
        uid = userInfo.getString("uid", "");
        Logger.i("---------0-------uid:"+uid);
        glistRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GlistRecyclerAdapter(R.layout.item_goods, goodsList);
        glistRecycler.setAdapter(adapter);
        presenter = new GoodsList_Presenter(this);
        presenter1 = new Search_Presenter(this);
        Intent intent = getIntent();
        if (intent != null) {
            String psic = intent.getStringExtra("pscid");
            presenter.setData(psic);
        } else {
            presenter.setData("2");
        }
    }

    @Override
    protected void setClickListener() {
    }


    @Override
    public void onFaild(String errorMsg) {
        Logger.i(errorMsg);
    }

    @Override
    public void onSuccessful(SearchBean searchBean) {
        searchBean1 = searchBean;
        searchList.addAll(searchBean.getData());
        adapter1.notifyDataSetChanged();
    }

    @Override
    public void onSuccessful(GoodsListBean goodsListBean) {
        goodsList.clear();
        ToastUtils.showToast(this, goodsListBean.getMsg());
        goodsList.addAll(goodsListBean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_iv_kind, R.id.toolbar_edi_search, R.id.toolbar_iv_search,R.id.toolbar_iv_saoyisao, R.id.toolbar_iv_root, R.id.tv_px_zonghe, R.id.tv_px_xiaoliang, R.id.tv_px_price, R.id.tv_px_sx})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_kind:
                if (flag) {
                    toolbarIvKind.setImageResource(R.drawable.kind_grid);
                    glistRecycler.setLayoutManager(new GridLayoutManager(this, 2));
                    flag = false;
                } else {
                    toolbarIvKind.setImageResource(R.drawable.kind_liner);
                    glistRecycler.setLayoutManager(new LinearLayoutManager(this));
                    flag = true;
                }
                break;
            case R.id.toolbar_iv_search:
                adapter1 = new SearchRecyclerAdapter(R.layout.item_goods, searchList);
                glistRecycler.setAdapter(adapter1);
                presenter1.setData(toolbarEdiSearch.getText().toString(), 0, sort_moRen);
                adapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        EventBus.getDefault().postSticky(new EventBusBean(uid,searchList.get(position).getPid(),searchList.get(position).getDetailUrl(),null,null,null));
                        startActivity(new Intent(GoodsListActivity.this,GoodsXiangQingActivity.class));
                    }
                });
                break;
            case R.id.toolbar_iv_saoyisao:
                break;
            case R.id.tv_px_zonghe:
                tvPxPrice.setTextColor(Color.BLACK);
                tvPxSx.setTextColor(Color.BLACK);
                tvPxXiaoliang.setTextColor(Color.BLACK);
                tvPxZonghe.setTextColor(Color.RED);
                searchList.clear();
                presenter1.setData(toolbarEdiSearch.getText().toString(), 0, sort_moRen);
                break;
            case R.id.tv_px_xiaoliang:
                tvPxPrice.setTextColor(Color.BLACK);
                tvPxSx.setTextColor(Color.BLACK);
                tvPxXiaoliang.setTextColor(Color.RED);
                tvPxZonghe.setTextColor(Color.BLACK);
                searchList.clear();
                presenter1.setData(toolbarEdiSearch.getText().toString(), 0, sort_xiaoLiang);
                break;
            case R.id.tv_px_price:
                tvPxPrice.setTextColor(Color.RED);
                tvPxSx.setTextColor(Color.BLACK);
                tvPxXiaoliang.setTextColor(Color.BLACK);
                tvPxZonghe.setTextColor(Color.BLACK);
                searchList.clear();
                presenter1.setData(toolbarEdiSearch.getText().toString(), 0, sort_price);
                break;
            case R.id.tv_px_sx:
                tvPxPrice.setTextColor(Color.BLACK);
                tvPxSx.setTextColor(Color.RED);
                tvPxXiaoliang.setTextColor(Color.BLACK);
                tvPxZonghe.setTextColor(Color.BLACK);
                break;
        }
    }
}

