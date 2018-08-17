package com.example.myjd.mvp.model;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack1;
import com.example.myjd.bean.UpdataCartBean;
import com.example.myjd.mvp.contract.UpdataCart_Contract;
import com.example.myjd.utils.ApiUtils;
import com.example.myjd.utils.RetrofitUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/17$ 11:37$
 */
public class UpdataCart_Model implements UpdataCart_Contract.Model {
    @Override
    public void setData(String uid, String sellerid, String pid, String selected, String num, final OnHttpCallBack1<UpdataCartBean> onHttpCallBack) {
        RetrofitUtils.newInstence(ApiUtils.BASEURL)
                .create(APIService.class)
                .rxUpdataCart(uid,sellerid,pid,selected,num)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<UpdataCartBean>() {
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
                                onHttpCallBack.onFaild1("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            onHttpCallBack.onFaild1("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            onHttpCallBack.onFaild1("网络连接超时!!");
                        } else {
                            onHttpCallBack.onFaild1("发生未知错误" + e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(UpdataCartBean cartBean) {
                        onHttpCallBack.onSuccessful1(cartBean);
                    }
                });
    }
}
