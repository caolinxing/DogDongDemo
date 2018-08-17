package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack1;
import com.example.myjd.bean.UpdataCartBean;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/17$ 11:37$
 */
public interface UpdataCart_Contract {
    interface Model {
        void setData(String uid,String sellerid,String pid,String selected,String num,OnHttpCallBack1<UpdataCartBean> onHttpCallBack);
    }

    interface View extends OnHttpCallBack1<UpdataCartBean> {
        @Override
        void onFaild1(String errorMsg);

        @Override
        void onSuccessful1(UpdataCartBean cartBean);
    }

    interface Presenter {
        void setData(String uid,String sellerid,String pid,String selected,String num);
        void onDestory();
    }
}
