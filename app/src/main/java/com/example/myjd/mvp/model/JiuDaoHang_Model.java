package com.example.myjd.mvp.model;

import android.content.Context;

import com.example.myjd.apiserver.APIService;
import com.example.myjd.base.OnHttpCallBack;
import com.example.myjd.bean.GrennDao_GoodsList;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.greedaotest.db.GoodsHelper;
import com.example.myjd.mvp.contract.JiuDaoHang_Contract;
import com.example.myjd.utils.RetrofitUtils;
import com.example.myjd.utils.RxJavaNetworkUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/11$ 11:02$
 */
public class JiuDaoHang_Model implements JiuDaoHang_Contract.Model {


    @Override
    public void setData(final Context context, final OnHttpCallBack<JGGDaoHangBean> onHttpCallBack) {
        RetrofitUtils
                .newInstence("https://www.zhaoapi.cn/")
                .create(APIService.class)
                .homeJiuDaoHang()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JGGDaoHangBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        RxJavaNetworkUtil.netWork(e,onHttpCallBack);
                    }

                    @Override
                    public void onNext(JGGDaoHangBean jggDaoHangBean) {
                        onHttpCallBack.onSuccessful(jggDaoHangBean);
                        //保存商品列表信息
                        for (int i = 0; i <jggDaoHangBean.getData().size() ; i++) {
                            GrennDao_GoodsList goods = new GrennDao_GoodsList();
                            goods.setCid(jggDaoHangBean.getData().get(i).getCid());
                            goods.setCreatetime(jggDaoHangBean.getData().get(i).getCreatetime());
                            goods.setIcon(jggDaoHangBean.getData().get(i).getIcon());
                            goods.setIshome(jggDaoHangBean.getData().get(i).getIshome());
                            goods.setName(jggDaoHangBean.getData().get(i).getName());
                            GoodsHelper.insertGoodsData(context,goods);
                        }
                    }
                });
    }
}
