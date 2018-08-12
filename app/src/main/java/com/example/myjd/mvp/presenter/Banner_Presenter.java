package com.example.myjd.mvp.presenter;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.mvp.contract.Banner_Contract;
import com.example.myjd.mvp.model.Banner_Model;

public class Banner_Presenter implements Banner_Contract.Presenter, OnHttpCallBack<HomeBean> {
    Banner_Contract.View view;
    Banner_Contract.Model model;

    public Banner_Presenter(Banner_Contract.View view) {
        this.view = view;
        model = new Banner_Model();
    }

    @Override
    public void setData() {
        model.setData(this);
    }

    @Override
    public void onSuccessful(HomeBean homeBean) {
        view.onSuccessful(homeBean);
    }

    @Override
    public void onFaild(String errorMsg) {
        view.onFaild(errorMsg);
    }
}
