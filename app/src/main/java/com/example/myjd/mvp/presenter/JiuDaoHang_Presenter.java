package com.example.myjd.mvp.presenter;

import android.content.Context;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.mvp.contract.JiuDaoHang_Contract;
import com.example.myjd.mvp.model.JiuDaoHang_Model;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/11$ 11:02$
 */
public class JiuDaoHang_Presenter implements JiuDaoHang_Contract.Presenter, OnHttpCallBack<JGGDaoHangBean> {
    JiuDaoHang_Contract.View view;
    JiuDaoHang_Contract.Model model;

    public JiuDaoHang_Presenter(JiuDaoHang_Contract.View view) {
        this.view = view;
        model = new JiuDaoHang_Model();
    }

    @Override
    public void setData() {
        model.setData(view.getCurContext(),this);
    }

    @Override
    public void onSuccessful(JGGDaoHangBean jggDaoHangBean) {
        view.onSuccessful(jggDaoHangBean);
    }

    @Override
    public void onFaild(String errorMsg) {
        view.onFaild(errorMsg);
    }
}
