package com.example.myjd.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 17:24$
 */
public class QueryCartMutilplterBean implements MultiItemEntity {
    public static final int TYPE_SHOP_NAME = 0;
    public static final int TYPE_GOODS_XIANGQING = 1;

    private CartBean.DataBean.ListBean cartListBean;
    private CartBean.DataBean cartDataBean;
    private int itemType;

    public QueryCartMutilplterBean(CartBean.DataBean.ListBean cartListBean, CartBean.DataBean cartDataBean, int itemType) {
        this.cartListBean = cartListBean;
        this.cartDataBean = cartDataBean;
        this.itemType = itemType;
    }

    public CartBean.DataBean.ListBean getCartListBean() {
        return cartListBean;
    }

    public CartBean.DataBean getCartDataBean() {
        return cartDataBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
