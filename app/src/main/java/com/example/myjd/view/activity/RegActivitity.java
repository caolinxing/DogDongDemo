package com.example.myjd.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myjd.base.BaseActivity;
import com.example.myjd.bean.UserInfo;
import com.example.myjd.mvp.contract.Register_Contract;
import com.example.myjd.mvp.presenter.Register_Presenter;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;
import com.example.myjd.widget.ClearEditText;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegActivitity extends BaseActivity implements Register_Contract.View {
    @BindView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @BindView(R.id.bar1_tv_title)
    TextView bar1TvTitle;
    @BindView(R.id.reg_edi_name)
    ClearEditText regEdiName;
    @BindView(R.id.reg_edi_pwd)
    ClearEditText regEdiPwd;
    @BindView(R.id.reg_see_state)
    ImageView regSeeState;
    @BindView(R.id.reg_btn_reg)
    Button regBtnReg;
    @BindView(R.id.pb_progress)
    ProgressBar pbProgress;
    private int i = 1;
    private Unbinder bind;
    private Register_Contract.Presenter p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        p = new Register_Presenter(this);
    }

    @Override
    protected int bindView() {
        return R.layout.activity_register;
    }


    @Override
    protected void setOtherOption() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setClickListener() {

    }

    @OnClick({R.id.iv_title_back, R.id.reg_see_state, R.id.reg_btn_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back:
                finish();
                break;
            case R.id.reg_see_state:
                hideOrShowPwd();
                break;
            case R.id.reg_btn_reg:
                p.register();
                break;
        }
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
                regSeeState.setBackgroundResource(R.drawable.eyes_o);
                regEdiPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                break;
            } else if (i % 2 == 1) {
                regSeeState.setBackgroundResource(R.drawable.eye_off);
                regEdiPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            }
        }
    }

    @Override
    public void showInfo(String info) {
        ToastUtils.showToast(this, info);
    }

    @Override
    public void showErrorMsg(String msg) {
        KLog.i(msg);
    }

    @Override
    public UserInfo getUserRegisterInfo() {
        return new UserInfo(regEdiName.getText().toString(), regEdiPwd.getText().toString());
    }

    @Override
    public void toLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
