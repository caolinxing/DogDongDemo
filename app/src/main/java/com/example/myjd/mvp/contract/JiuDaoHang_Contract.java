package com.example.myjd.mvp.contract;

import android.content.Context;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.JGGDaoHangBean;

/**
 * @author user
 * @version 1.0
 * @date 2018/8/11$ 11:02$
 */

public interface JiuDaoHang_Contract {
    interface Model {
        void setData(Context context,OnHttpCallBack<JGGDaoHangBean> onHttpCallBack);
    }

    interface View extends OnHttpCallBack<JGGDaoHangBean> {
        Context getCurContext();//获取上下文对象,用于保存数据等
        @Override
        void onFaild(String errorMsg);

        @Override
        void onSuccessful(JGGDaoHangBean homeBean);
    }

    interface Presenter {
        void setData();
    }
}
