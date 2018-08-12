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
        if (mRetrofit==null){
            OkHttpClient client = new OkHttpClient();//初始化一个client,不然retrofit会自己默认添加一个
            client.newBuilder()
                    .readTimeout(READ_TIMEOUT, TimeUnit.MINUTES)//设置读取时间为一分钟
                    .connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS);//设置连接时间为12s
            mRetrofit = new Retrofit.Builder()
                    .client(client)//添加一个client,不然retrofit会自己默认添加一个
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

        }
        return mRetrofit;
    }


}
