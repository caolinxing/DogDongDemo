package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.CartBean;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 17:09$
 */
public interface QueryCart_Contract {
    interface Model {
        void setData(String uid,OnHttpCallBack<CartBean> onHttpCallBack);
    }

    interface View extends OnHttpCallBack<CartBean> {
        @Override
        void onFaild(String errorMsg);

        @Override
        void onSuccessful(CartBean cartBean);
    }

    interface Presenter {
        void setData(String uid);
        void onDestory();
    }
}
