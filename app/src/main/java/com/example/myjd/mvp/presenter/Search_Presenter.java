package com.example.myjd.mvp.presenter;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.SearchBean;
import com.example.myjd.mvp.contract.Search_Contract;
import com.example.myjd.mvp.model.Search_Model;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 11:57$
 */
public class Search_Presenter implements Search_Contract.Presenter, OnHttpCallBack<SearchBean> {
    Search_Contract.View view;
    Search_Contract.Model model;

    public Search_Presenter(Search_Contract.View view) {
        this.view = view;
        model = new Search_Model();
    }

    @Override
    public void setData(String kwords, int page,int sort) {
        model.setData(kwords,page,sort,this);
    }

    @Override
    public void onSuccessful(SearchBean searchBean) {
        view.onSuccessful(searchBean);
    }

    @Override
    public void onFaild(String errorMsg) {
        view.onFaild(errorMsg);
    }
}
