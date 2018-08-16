package com.example.myjd.view.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myjd.adapter.CartMutiAdapter;
import com.example.myjd.base.BaseFragment;
import com.example.myjd.bean.CartBean;
import com.example.myjd.bean.QueryCartMutilplterBean;
import com.example.myjd.mvp.contract.QueryCart_Contract;
import com.example.myjd.mvp.presenter.QueryCart_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.view.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends BaseFragment implements QueryCart_Contract.View {


    private android.support.v7.widget.RecyclerView mGoodsRecyclerView;
    private android.widget.CheckBox mGoodsCbCheckedAll;
    private android.widget.TextView mGoodsTvSelect;
    private android.widget.TextView mGoodsAllGoodsNum;
    private android.widget.TextView mGoodsAllPrice;
    private android.widget.Button mGoodsBtnCount;
    private QueryCart_Contract.Presenter presenter;
    private List<QueryCartMutilplterBean> cartList;
    String uid = "72";
    private CartMutiAdapter adapter;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    protected void otherOpration() {

    }

    @Override
    protected void onClickListener() {

    }

    @Override
    protected void setAdapter() {

    }

    @Override
    protected void initData() {
        cartList = new ArrayList<>();
        presenter = new QueryCart_Presenter(this);
        presenter.setData(uid);

    }

    @Override
    protected void findView(View v) {
        mGoodsRecyclerView = (RecyclerView)v.findViewById(R.id.goods_recyclerView);
        mGoodsCbCheckedAll = (CheckBox) v.findViewById(R.id.goods_cb_checkedAll);
        mGoodsTvSelect = (TextView) v.findViewById(R.id.goods_tv_select);
        mGoodsAllGoodsNum = (TextView) v.findViewById(R.id.goods_allGoodsNum);
        mGoodsAllPrice = (TextView) v.findViewById(R.id.goods_allPrice);
        mGoodsBtnCount = (Button) v.findViewById(R.id.goods_btn_count);
        mGoodsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int initView() {
        return R.layout.fragment_cart;
    }

    @Override
    public void onFaild(String errorMsg) {
        Logger.i(errorMsg);
    }

    @Override
    public void onSuccessful(CartBean cartBean) {
        for (int i = 1; i <cartBean.getData().size() ; i++) {
            cartList.add(new QueryCartMutilplterBean(null,cartBean.getData().get(i),QueryCartMutilplterBean.TYPE_SHOP_NAME));
            List<CartBean.DataBean.ListBean> listBeans = cartBean.getData().get(i).getList();
            for (int j = 0; j <listBeans.size() ; j++) {
                cartList.add(new QueryCartMutilplterBean(listBeans.get(j),null,QueryCartMutilplterBean.TYPE_GOODS_XIANGQING));
            }
        }
        adapter = new CartMutiAdapter(cartList);
        mGoodsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        presenter.onDestory();
        super.onDestroy();

    }
}
