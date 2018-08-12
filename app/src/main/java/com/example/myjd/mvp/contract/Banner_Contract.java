package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.HomeBean;

public interface Banner_Contract {
    interface Model {
        void setData(OnHttpCallBack<HomeBean> onHttpCallBack);
    }

    interface View extends OnHttpCallBack<HomeBean> {
        @Override
        void onFaild(String errorMsg);

        @Override
        void onSuccessful(HomeBean homeBean);
    }

    interface Presenter {
        void setData();
    }
}
