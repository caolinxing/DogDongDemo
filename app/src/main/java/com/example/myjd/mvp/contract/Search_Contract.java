package com.example.myjd.mvp.contract;

import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.bean.SearchBean;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 11:57$
 */
public interface Search_Contract {
    interface Model {
        void setData(String kwords,int page,int sort,OnHttpCallBack<SearchBean> onHttpCallBack);
    }
    interface View  {
        void onFaild(String errorMsg);

        void onSuccessful(SearchBean searchBean);
    }

    interface Presenter {
        void setData(String kwords,int page,int sort);
    }
}
