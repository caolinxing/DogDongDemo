package com.example.myjd.utils;

import com.example.myjd.base.OnHttpCallBack;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;

public class RxJavaNetworkUtil {
    private static final String TAG = RxJavaNetworkUtil.class.getSimpleName();
    public static void netWork(Throwable e,OnHttpCallBack callBack) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            if (code == 500 || code == 404) {
                callBack.onFaild("服务器出错");
            }
        } else if (e instanceof ConnectException) {
            callBack.onFaild("网络断开,请打开网络!");
        } else if (e instanceof SocketTimeoutException) {
            callBack.onFaild("网络连接超时!!");
        } else {
            callBack.onFaild("发生未知错误" + e.getMessage());
        }
    }
}
