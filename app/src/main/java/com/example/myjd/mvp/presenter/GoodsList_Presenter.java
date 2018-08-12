package com.example.myjd.mvp.presenter;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.mvp.contract.GoodsList_Contract;
import com.example.myjd.mvp.model.GoodsList_Model;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/12$ 19:58$
 */
public class GoodsList_Presenter implements GoodsList_Contract.Presenter, OnHttpCallBack<GoodsListBean> {
    GoodsList_Contract.View view;
    GoodsList_Model model;

    public GoodsList_Presenter(GoodsList_Contract.View view) {
        this.view = view;
        model = new GoodsList_Model();
    }

    @Override
    public void setData(String psicd) {
        model.setData(psicd,this);
    }

    @Override
    public void onSuccessful(GoodsListBean goodsListBean) {
        view.onSuccessful(goodsListBean);
    }

    @Override
    public void onFaild(String errorMsg) {
        view.onFaild(errorMsg);
    }
}
