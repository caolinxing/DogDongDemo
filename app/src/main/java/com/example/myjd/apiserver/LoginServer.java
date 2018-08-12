package com.example.myjd.apiserver;


import com.example.myjd.bean.LoginBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginServer {
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginBean> loginBeanCall(
            @Field("mobile")String mobile ,
            @Field("password") String pwd);

}
