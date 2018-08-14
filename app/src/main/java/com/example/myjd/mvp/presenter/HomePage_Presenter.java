package com.example.myjd.mvp.presenter;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.mvp.contract.HomePage_Contract;
import com.example.myjd.mvp.model.HomePage_Model;

public class HomePage_Presenter implements HomePage_Contract.Presenter, OnHttpCallBack<HomeBean>,HomePage_Contract.GetDataState {
    HomePage_Contract.View view;
    HomePage_Contract.Model model;

    public HomePage_Presenter(HomePage_Contract.View view) {
        this.view = view;
        model = new HomePage_Model();
    }

    @Override
    public void setData() {
        model.setData(this);
    }

    @Override
    public void setData1() {
        model.setData1(this);
    }

    @Override
    public void onSuccessful(HomeBean homeBean) {
        view.onSuccessful(homeBean);
    }

    @Override
    public void onFaild(String errorMsg) {
        view.onFaild(errorMsg);
    }

    @Override
    public void onError(String errorMsg) {
        view.onError(errorMsg);
    }

    @Override
    public void onSuccess(JGGDaoHangBean jggDaoHangBean) {
        view.onSuccess(jggDaoHangBean);
    }
}
