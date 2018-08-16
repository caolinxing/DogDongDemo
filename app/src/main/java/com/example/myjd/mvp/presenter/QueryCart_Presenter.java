package com.example.myjd.mvp.presenter;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.CartBean;
import com.example.myjd.mvp.contract.QueryCart_Contract;
import com.example.myjd.mvp.model.QueryCart_Model;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 17:09$
 */
public class QueryCart_Presenter implements QueryCart_Contract.Presenter, OnHttpCallBack<CartBean> {
    QueryCart_Contract.View view;
    QueryCart_Contract.Model model;

    public QueryCart_Presenter(QueryCart_Contract.View view) {
        this.view = view;
        model = new QueryCart_Model();
    }

    @Override
    public void setData(String uid) {
        model.setData(uid,this);
    }

    @Override
    public void onDestory() {
        view=null;
    }

    @Override
    public void onSuccessful(CartBean cartBean) {
        view.onSuccessful(cartBean);
    }

    @Override
    public void onFaild(String errorMsg) {
        view.onFaild(errorMsg);
    }
}
