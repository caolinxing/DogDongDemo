package com.example.myjd.mvp.presenter;


import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.LoginBean;
import com.example.myjd.bean.RegisterBean;
import com.example.myjd.bean.UserInfo;
import com.example.myjd.mvp.contract.Register_Contract;
import com.example.myjd.mvp.model.Register_Model;
import com.socks.library.KLog;

public class Register_Presenter implements Register_Contract.Presenter {
    Register_Contract.View view;
    Register_Contract.Model model;

    public Register_Presenter(Register_Contract.View view) {
        this.view = view;
        model = new Register_Model();
    }
    @Override
    public void register() {
        UserInfo info = view.getUserRegisterInfo();
        model.onRegister(info, new OnHttpCallBack<RegisterBean>() {

            @Override
            public void onSuccessful(RegisterBean loginBean) {
                if (loginBean.getMsg().equals("注册成功")){
                    view.hideProgress();//隐藏进度条
                    view.toLogin();//跳转到登入页面
                    //提示用户注册成功
                    view.showInfo(loginBean.getMsg());
                }else {
                    view.hideProgress();//隐藏进度条
                    view.showInfo(loginBean.getMsg());
                }
            }

            @Override
            public void onFaild(String errorMsg) {
                KLog.i(errorMsg);
            }
        });
    }

}
