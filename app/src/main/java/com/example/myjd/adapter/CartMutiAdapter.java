package com.example.myjd.adapter;

import android.view.View;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.QueryCartMutilplterBean;
import com.example.myjd.view.R;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/16$ 19:06$
 */
public class CartMutiAdapter extends BaseMultiItemQuickAdapter<QueryCartMutilplterBean,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public CartMutiAdapter(List<QueryCartMutilplterBean> data) {
        super(data);
        addItemType(QueryCartMutilplterBean.TYPE_SHOP_NAME, R.layout.item_cart_item_goods);
        addItemType(QueryCartMutilplterBean.TYPE_GOODS_XIANGQING, R.layout.item_cart_item_goods2);
    }

    @Override
    protected void convert(BaseViewHolder helper, QueryCartMutilplterBean item) {
        switch (helper.getItemViewType()){
            case QueryCartMutilplterBean.TYPE_SHOP_NAME:
                helper.setText(R.id.item_tv_shop_name,item.getCartDataBean().getSellerName())
                .addOnClickListener(R.id.item_cb_seletor_zong);
                break;
            case QueryCartMutilplterBean.TYPE_GOODS_XIANGQING:
                helper.setText(R.id.item_tv_good_title,item.getCartListBean().getTitle())
                        .setText(R.id.item_tv_goods_price,item.getCartListBean().getPrice())
                        .setText(R.id.item_tv_goodsNum,item.getCartListBean().getNum())
                        .addOnClickListener(R.id.item_cb_goods_seletorchild);
                CheckBox cb_goods = helper.getView(R.id.item_cb_goods_seletorchild);
                if (item.getCartListBean().getSelected().equals("0")){
                    cb_goods.setChecked(false);
                }else {
                    cb_goods.setChecked(true);
                }
                break;
        }
    }
}
