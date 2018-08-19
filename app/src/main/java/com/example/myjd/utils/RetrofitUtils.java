package com.example.myjd.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retofit网络请求工具类
 */
public class RetrofitUtils {
    private static final int READ_TIMEOUT = 60;//读取超时时间,单位  秒
    private static final int CONN_TIMEOUT = 12;//连接超时时间,单位  秒

    private static Retrofit mRetrofit = null;

    private RetrofitUtils() {

    }

    public static Retrofit newInstence(String url) {
        if (mRetrofit == null) {
            synchronized (RetrofitUtils.class) {
                if (mRetrofit == null) {
                    OkHttpClient.Builder client = new OkHttpClient().newBuilder() ;
                    client.readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)
                            .connectTimeout(CONN_TIMEOUT,TimeUnit.SECONDS)
                            .build() ;
                    mRetrofit = new Retrofit.Builder()
                            .client(client.build())//添加一个client,不然retrofit会自己默认添加一个
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                }
            }
        }
        return mRetrofit;
    }
}
