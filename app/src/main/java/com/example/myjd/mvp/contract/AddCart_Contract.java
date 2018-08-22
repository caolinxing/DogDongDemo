package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack1;
import com.example.myjd.bean.AddCartBean;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/17$ 20:33$
 */
public interface AddCart_Contract {
    interface Model {
        void setData(String uid, String pid, OnHttpCallBack1<AddCartBean> onHttpCallBack);
    }

    interface View extends OnHttpCallBack1<AddCartBean> {
        @Override
        void onFaild1(String errorMsg);

        @Override
        void onSuccessful1(AddCartBean cartBean);
    }

    interface Presenter {
        void setData(String uid, String pid);

        void onDestory();
    }
}
