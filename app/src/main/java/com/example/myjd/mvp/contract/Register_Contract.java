package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.UserInfo;

public interface Register_Contract {
    interface Model {

        void onRegister(UserInfo userInfo, OnHttpCallBack onHttpCallBack);

    }

    interface View {

        void showProgress();//显示进度条

        void hideProgress();//隐藏进度条

        void hideOrShowPwd();//显示隐藏密码

        void showErrorMsg(String msg);//提示错误信息

        void showInfo(String info);//提示用户,提升友好交互

        UserInfo getUserRegisterInfo(); //获取注册信息

        void toLogin();//进入登入页

    }

    interface Presenter {
        void register();//唯一桥梁注册
    }
}
