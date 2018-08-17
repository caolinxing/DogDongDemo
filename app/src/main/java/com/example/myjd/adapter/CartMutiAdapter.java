package com.example.myjd.adapter;

import android.widget.CheckBox;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.QueryCartMutilplterBean;
import com.example.myjd.view.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

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
               /* //如果商家里所有的商品select都为1，则设置商家isSelectedState为true
                boolean flag = true;
                //如果商家isSelectedState为true的话则设置商家里所有的商品select为1（选中状态）
                if (item.getCartDataBean().isSelectedState()){
                    for (int i = 0; i <item.getCartDataBean().getList().size() ; i++) {
                        item.getCartDataBean().getList().get(i).setSelected("1");
                    }
                }else {
                    for (int i = 0; i <item.getCartDataBean().getList().size() ; i++) {
                        item.getCartDataBean().getList().get(i).setSelected("0");
                    }
                }
                for (int i = 0; i <item.getCartDataBean().getList().size() ; i++) {
                    if (item.getCartDataBean().getList().get(i).getSelected().equals("0")){
                        flag =false;//有一个不为1为设置false
                    }
                }
                if (flag){
                    item.getCartDataBean().setSelectedState(true);
                }else {
                    item.getCartDataBean().setSelectedState(false);
                }*/
                break;
            case QueryCartMutilplterBean.TYPE_GOODS_XIANGQING:
                helper.setText(R.id.item_tv_good_title,item.getCartListBean().getTitle())
                        .setText(R.id.item_tv_goods_price,item.getCartListBean().getPrice())
                        .setText(R.id.item_tv_goodsNum,item.getCartListBean().getNum())
                        .addOnClickListener(R.id.item_cb_goods_seletorchild)
                        .addOnClickListener(R.id.item_iv_goodsAdd)
                        .addOnClickListener(R.id.item_iv_jian2);
                CheckBox cb_goods = helper.getView(R.id.item_cb_goods_seletorchild);
                CheckBox cb_shop = helper.getView(R.id.item_cb_seletor_zong);
                ImageView img = helper.getView(R.id.item_iv_jian2);
                SimpleDraweeView sdv = helper.getView(R.id.item_sdv_goods_icon2);
                Phoenix.with(sdv).load(item.getCartListBean().getImages().split("[|]")[0]);

                if (item.getCartListBean().getSelected().equals("1")){
                    cb_goods.setChecked(true);
                }else if(item.getCartListBean().getSelected().equals("0")) {
                    cb_goods.setChecked(false);
                }
                if (item.getCartListBean().getNum().equals("1")){
                    img.setImageResource(R.drawable.jian_0);
                }else {
                    img.setImageResource(R.drawable.jian_1);
                }
                break;
        }
    }
}
