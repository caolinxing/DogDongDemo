package com.example.myjd.mvp.presenter;

import com.example.myjd.base.OnHttpCallBack1;
import com.example.myjd.bean.UpdataCartBean;
import com.example.myjd.mvp.contract.UpdataCart_Contract;
import com.example.myjd.mvp.model.UpdataCart_Model;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/17$ 11:37$
 */
public class UpdataCart_Presenter implements UpdataCart_Contract.Presenter, OnHttpCallBack1<UpdataCartBean> {
    UpdataCart_Contract.View view;
    UpdataCart_Contract.Model model;

    public UpdataCart_Presenter(UpdataCart_Contract.View view) {
        this.view = view;
        model = new UpdataCart_Model();
    }


    @Override
    public void setData(String uid, String sellerid, String pid, String selected, String num) {
        model.setData(uid,sellerid,pid,selected,num,this);
    }

    @Override
    public void onDestory() {
        view=null;
    }

    @Override
    public void onSuccessful1(UpdataCartBean updataCartBean) {
        view.onSuccessful1(updataCartBean);
    }

    @Override
    public void onFaild1(String errorMsg) {
        view.onFaild1(errorMsg);
    }
}
