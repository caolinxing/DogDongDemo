package com.example.myjd.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myjd.base.BaseActivity;
import com.example.myjd.bean.UserInfo;
import com.example.myjd.mvp.contract.Login_Contract;
import com.example.myjd.mvp.presenter.Login_Presenter;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends BaseActivity implements Login_Contract.View {

    @BindView(R.id.edi_name)
    EditText ediName;
    @BindView(R.id.edi_pwd)
    EditText ediPwd;
    @BindView(R.id.see_state)
    ImageView seeState;
    @BindView(R.id.forget_pwd)
    TextView forgetPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.pb_progress)
    ProgressBar pbProgress;
    @BindView(R.id.tv_yanzhengma)
    TextView tvYanzhengma;
    @BindView(R.id.tv_reg)
    TextView tvReg;
    @BindView(R.id.iv_wechat)
    ImageView ivWechat;
    @BindView(R.id.iv_qqchat)
    ImageView ivQqchat;
    @BindView(R.id.tv_login_xieyi)
    TextView tvLoginXieyi;
    private String pwd;
    private String name;
    private Login_Contract.Presenter presenter;
    private int i = 1;
    private Unbinder bind;

    @Override
    protected int bindView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        presenter = new Login_Presenter(this);
    }


    @OnClick({R.id.edi_name, R.id.edi_pwd, R.id.see_state, R.id.forget_pwd, R.id.lin, R.id.btn_login,R.id.tv_yanzhengma, R.id.tv_reg, R.id.iv_wechat, R.id.iv_qqchat, R.id.tv_login_xieyi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.see_state:
                presenter.hideOrShowPwd();
                break;
            case R.id.forget_pwd:
                break;
            case R.id.lin:
                break;
            case R.id.btn_login:
                presenter.login();
                break;
            case R.id.tv_yanzhengma:
                break;
            case R.id.tv_reg:
                presenter.reg();
                break;
            case R.id.iv_wechat:
                break;
            case R.id.iv_qqchat:
                break;
            case R.id.tv_login_xieyi:
                break;
        }
    }

    @Override
    public Context getCurContext() {
        return mActivity;
    }

    @Override
    public void showProgress() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void hideOrShowPwd() {

        while (true) {
            i++;
            if (i % 2 == 0) {
                seeState.setBackgroundResource(R.drawable.eyes_o);
                ediPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                break;
            } else if (i % 2 == 1) {
                seeState.setBackgroundResource(R.drawable.eye_off);
                ediPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            }
        }
    }

    @Override
    public void showInfo(String info) {
        ToastUtils.showToast(LoginActivity.this, info);
    }

    @Override
    public void showErrorMsg(String msg) {
        KLog.i(msg);
    }

    @Override
    public void toMain() {
        finish();
    }

    @Override
    public void toRegister() {
        startActivity(new Intent(LoginActivity.this, RegActivitity.class));
    }

    @Override
    public UserInfo getUserLoginInfo() {
        return new UserInfo(ediName.getText().toString(), ediPwd.getText().toString());
    }

    @Override
    protected void setClickListener() {

    }

    //预留操作接口
    @Override
    protected void setOtherOption() {

    }
}
