package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.bean.JGGDaoHangBean;

public interface HomePage_Contract {
    interface Model {
        void setData(OnHttpCallBack<HomeBean> onHttpCallBack);
        void setData1(GetDataState getDataState);
    }
    interface GetDataState{
        void onError(String errorMsg);

        void onSuccess(JGGDaoHangBean jggDaoHangBean);
    }
    interface View extends OnHttpCallBack<HomeBean> {
        @Override
        void onFaild(String errorMsg);

        @Override
        void onSuccessful(HomeBean homeBean);

        void onError(String errorMsg);

        void onSuccess(JGGDaoHangBean jggDaoHangBean);
    }

    interface Presenter {
        void setData();
        void setData1();
    }
}
