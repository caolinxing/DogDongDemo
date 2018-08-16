package com.example.myjd.mvp.model;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.bean.SearchBean;
import com.example.myjd.mvp.contract.Search_Contract;
import com.example.myjd.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 11:57$
 */
public class Search_Model implements Search_Contract.Model {
    @Override
    public void setData(String kwords, int page,int sort, final OnHttpCallBack<SearchBean> onHttpCallBack) {
        RetrofitUtils.newInstence("https://www.zhaoapi.cn/")
                .create(APIService.class)
                .rxSearch(kwords, page,sort)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<SearchBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onHttpCallBack.onFaild(e.getMessage());
                    }

                    @Override
                    public void onNext(SearchBean dataBean) {
                        onHttpCallBack.onSuccessful(dataBean);
                    }
                });
    }
}
