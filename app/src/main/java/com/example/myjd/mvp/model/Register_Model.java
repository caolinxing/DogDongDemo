package com.example.myjd.mvp.model;


import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.RegisterBean;
import com.example.myjd.bean.UserInfo;
import com.example.myjd.mvp.contract.Register_Contract;
import com.example.myjd.utils.RxJavaNetworkUtil;
import com.example.myjd.utils.RetrofitUtils;
import com.socks.library.KLog;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Register_Model implements Register_Contract.Model {

    @Override
    public void onRegister(UserInfo userInfo, final OnHttpCallBack callBack) {
        RetrofitUtils.newInstence("https://www.zhaoapi.cn/")
                .create(APIService.class)
                .userRegister(userInfo.getUserName(),userInfo.getPwd())
                .subscribeOn(Schedulers.newThread())//在新线程中执行登录请求
                .observeOn(AndroidSchedulers.mainThread())//在主线程中执行
                .subscribe(new Subscriber<RegisterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.getMessage() + "--");
                        e.printStackTrace();
                        //失败的时候调用-----一下可以忽略 直接 callBack.onFaild("请求失败");
                        RxJavaNetworkUtil.netWork(e,callBack);
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        KLog.i(registerBean.getMsg());
                        callBack.onSuccessful(registerBean);
                    }//网络(登录)请求回调

                });
    }
}
