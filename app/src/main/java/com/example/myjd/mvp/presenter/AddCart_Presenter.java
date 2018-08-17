package com.example.myjd.mvp.presenter;

import com.example.myjd.base.OnHttpCallBack1;
import com.example.myjd.bean.AddCartBean;
import com.example.myjd.mvp.contract.AddCart_Contract;
import com.example.myjd.mvp.model.AddCart_Model;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/17$ 20:33$
 */
public class AddCart_Presenter implements AddCart_Contract.Presenter, OnHttpCallBack1<AddCartBean> {
    AddCart_Contract.View view;
    AddCart_Contract.Model model;

    public AddCart_Presenter(AddCart_Contract.View view) {
        this.view = view;
        model = new AddCart_Model();
    }


    @Override
    public void setData(String uid,  String pid) {
        model.setData(uid,pid,this);
    }

    @Override
    public void onDestory() {
        view=null;
    }

    @Override
    public void onSuccessful1(AddCartBean updataCartBean) {
        view.onSuccessful1(updataCartBean);
    }

    @Override
    public void onFaild1(String errorMsg) {
        view.onFaild1(errorMsg);
    }
}
