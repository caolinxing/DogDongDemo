package com.example.myjd.greedaotest.db;

import android.content.Context;

import com.example.myjd.bean.GrennDao_GoodsList;
import com.example.myjd.bean.JGGDaoHangBean;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/12$ 18:55$
 */
public class GoodsHelper {
    public static void insertGoodsData(Context context, GrennDao_GoodsList dataBean){
        if (dataBean==null){
            return;
        }
        DbMannager.getDaoSession(context).getGrennDao_GoodsListDao().insert(dataBean);
    }
}
