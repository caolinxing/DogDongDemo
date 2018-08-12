package com.example.myjd.mvp.model;

import android.content.Context;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.LoginBean;
import com.example.myjd.bean.UserInfo;
import com.example.myjd.mvp.contract.Login_Contract;
import com.example.myjd.utils.RxJavaNetworkUtil;
import com.example.myjd.utils.RetrofitUtils;
import com.socks.library.KLog;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Login_Model implements Login_Contract.Model {

    @Override
    public void login(UserInfo userInfo, final OnHttpCallBack<LoginBean> callBack) {
        //登录的网络请求
        RetrofitUtils.newInstence("https://www.zhaoapi.cn/")//实例化Retrofit对象
                .create(APIService.class)//创建Rxjava---->LoginService对象
                .userLogin(userInfo.getUserName(), userInfo.getPwd())//调用登录的接口
                .subscribeOn(Schedulers.newThread())//在新线程中执行登录请求
                .observeOn(AndroidSchedulers.mainThread())//在主线程中执行
                .subscribe(new Subscriber<LoginBean>() {
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
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccessful(loginBean);
                    }//网络(登录)请求回调

                });
    }

    @Override
    public void saveUserInfo(Context context, UserInfo user, String token) {
        KLog.e("开始保存用户信息" + user.toString());
        context.getSharedPreferences("userinfo", Context.MODE_PRIVATE).edit()
                .putString("userName", user.getUserName())
                .putString("pwd", user.getPwd())
                .putString("address", user.getAddress())
                .putString("phone", user.getPhone())
                .putString("token", token)
                .commit();
    }

}
