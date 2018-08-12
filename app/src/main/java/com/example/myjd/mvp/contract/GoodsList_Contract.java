package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.GoodsListBean;

/**
 * @author user
 * @version 1.0
 * @date 2018/8/12$ 19:58$
 */
public interface GoodsList_Contract {
    interface Model {
        void setData(String pscid,OnHttpCallBack<GoodsListBean> onHttpCallBack);
    }

    interface View extends OnHttpCallBack<GoodsListBean> {
        @Override
        void onFaild(String errorMsg);

        @Override
        void onSuccessful(GoodsListBean goodsListBean);
    }

    interface Presenter {
        void setData(String pscid);
    }
}
