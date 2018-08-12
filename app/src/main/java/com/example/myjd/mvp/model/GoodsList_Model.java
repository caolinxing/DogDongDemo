package com.example.myjd.mvp.model;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.mvp.contract.GoodsList_Contract;
import com.example.myjd.mvp.presenter.GoodsList_Presenter;
import com.example.myjd.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/12$ 19:58$
 */
public class GoodsList_Model implements GoodsList_Contract.Model {
    @Override
    public void setData(String pscid, final OnHttpCallBack<GoodsListBean> onHttpCallBack) {
        RetrofitUtils.newInstence("https://www.zhaoapi.cn/")
                .create(APIService.class)
                .goodsList(pscid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<GoodsListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onHttpCallBack.onFaild(e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsListBean dataBean) {
                        onHttpCallBack.onSuccessful(dataBean);
                    }
                });
    }
}
