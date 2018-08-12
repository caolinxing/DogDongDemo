package com.example.myjd.mvp.contract;

import android.content.Context;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.LoginBean;
import com.example.myjd.bean.UserInfo;

public interface Login_Contract {
    interface Model {
        void login(UserInfo userInfo, OnHttpCallBack<LoginBean> callBack);//登录

        void saveUserInfo(Context context, UserInfo user,String token);//登录成功就保存用户信息
    }

    interface View {
        Context getCurContext();//获取上下文对象,用于保存数据等

        void showProgress();//可以显示进度条

        void hideProgress();//可以隐藏进度条

        void hideOrShowPwd();

        void showInfo(String info);//提示用户,提升友好交互

        void showErrorMsg(String msg);//发生错误就显示错误信息

        void toMain();//跳转到主页面

        void toRegister();//跳转到注册页面

        UserInfo getUserLoginInfo();//获取用户登录信息
    }

    interface Presenter {
        void login();//唯一的桥梁就是登录注册了
        void reg();
        void hideOrShowPwd();
        void onDestory();
    }
}
