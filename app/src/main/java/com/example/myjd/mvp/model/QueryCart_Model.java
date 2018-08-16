package com.example.myjd.mvp.model;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.CartBean;
import com.example.myjd.mvp.contract.QueryCart_Contract;
import com.example.myjd.utils.ApiUtils;
import com.example.myjd.utils.RetrofitUtils;
import com.example.myjd.utils.RxJavaNetworkUtil;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 17:09$
 */
public class QueryCart_Model implements QueryCart_Contract.Model {
    @Override
    public void setData(String uid, final OnHttpCallBack<CartBean> onHttpCallBack) {
        RetrofitUtils.newInstence(ApiUtils.BASEURL)
                .create(APIService.class)
                .rxQueryCart(uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        RxJavaNetworkUtil.netWork(e,onHttpCallBack);
                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        onHttpCallBack.onSuccessful(cartBean);
                    }
                });
    }
}
