package com.example.myjd.mvp.model;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.mvp.contract.HomePage_Contract;
import com.example.myjd.utils.RetrofitUtils;
import com.example.myjd.utils.RxJavaNetworkUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomePage_Model implements HomePage_Contract.Model {
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

    @Override
    public void setData1(final HomePage_Contract.GetDataState getDataState) {
        RetrofitUtils
                .newInstence("https://www.zhaoapi.cn/")
                .create(APIService.class)
                .homeJiuDaoHang()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JGGDaoHangBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                getDataState.onError("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            getDataState.onError("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            getDataState.onError("网络连接超时!!");
                        } else {
                            getDataState.onError("发生未知错误" + e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(JGGDaoHangBean homeBean) {
                        getDataState.onSuccess(homeBean);
                    }
                });
    }
}
