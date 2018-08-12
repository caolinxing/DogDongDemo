package com.example.myjd.mvp.model;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.mvp.contract.Banner_Contract;
import com.example.myjd.utils.Logger;
import com.example.myjd.utils.RetrofitUtils;
import com.example.myjd.utils.RxJavaNetworkUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Banner_Model implements Banner_Contract.Model {
    @Override
    public void setData(final OnHttpCallBack onHttpCallBack) {
       RetrofitUtils
               .newInstence("https://www.zhaoapi.cn/")
               .create(APIService.class)
               .homeBanner()
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .subscribe(new Subscriber<HomeBean>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {
                       RxJavaNetworkUtil.netWork(e,onHttpCallBack);
                   }

                   @Override
                   public void onNext(HomeBean homeBean) {
                        onHttpCallBack.onSuccessful(homeBean);
                   }
               });

    }
}
