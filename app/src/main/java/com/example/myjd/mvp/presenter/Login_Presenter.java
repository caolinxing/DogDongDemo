package com.example.myjd.mvp.presenter;


import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.LoginBean;
import com.example.myjd.mvp.contract.Login_Contract;
import com.example.myjd.mvp.model.Login_Model;

public class Login_Presenter implements Login_Contract.Presenter {
    Login_Contract.View mLoginView;
    Login_Contract.Model mLoginModel;

    public Login_Presenter(Login_Contract.View lView) {
        this.mLoginView = lView;
        mLoginModel = new Login_Model();
    }

    @Override
    public void login() {
        mLoginView.showProgress(); //显示登录进度条
        final int i = 0;
        mLoginModel.login(mLoginView.getCurContext(),mLoginView.getUserLoginInfo(), new OnHttpCallBack<LoginBean>() {
            @Override
            public void onSuccessful(LoginBean tokenResult) {
                if (tokenResult.getMsg().equals("登录成功")){
                    mLoginView.hideProgress();//隐藏进度条
                    mLoginView.toMain();//跳转到主页面
                    mLoginModel.saveUserInfo(mLoginView.getCurContext(), mLoginView.getUserLoginInfo(), tokenResult.getData().getUid()+"");//保存用户数据
                    mLoginView.showInfo("登录成功,您的用户toekn/uid为:" + tokenResult.getData().getUid());//提示用户登录成功
                }else {
                    mLoginView.hideProgress();//隐藏进度条
                    mLoginView.showInfo("用户名或密码错误！");
                }
            }

            @Override
            public void onFaild(String errorMsg) {
                mLoginView.hideProgress();//隐藏进度条
                mLoginView.showErrorMsg(errorMsg);//登录失败  显示错误信息
            }
        });
    }

    @Override
    public void reg() {
        mLoginView.toRegister();
    }

    @Override
    public void hideOrShowPwd() {
        mLoginView.hideOrShowPwd();
    }

    @Override
    public void onDestory() {
        mLoginView=null;
    }
}
