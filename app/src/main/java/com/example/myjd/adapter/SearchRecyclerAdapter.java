package com.example.myjd.adapter;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.bean.SearchBean;
import com.example.myjd.view.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/12$ 20:24$
 */
public class SearchRecyclerAdapter extends BaseQuickAdapter<SearchBean.DataBean,BaseViewHolder>{
    public SearchRecyclerAdapter(int layoutResId, @Nullable List<SearchBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.DataBean item) {
        helper.setText(R.id.item_gl_tv_price,"优惠价:￥"+item.getPrice())
                .setText(R.id.item_gl_bargin_price,"原价:￥"+item.getBargainPrice())
                .setText(R.id.item_gl_tv_title,item.getTitle())
                .setText(R.id.item_gl_tv_time,item.getCreatetime());
        SimpleDraweeView sdv = helper.getView(R.id.item_gl_sdv);
        TextView textView = helper.getView(R.id.item_gl_bargin_price);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Phoenix.with(sdv).load(item.getImages().split("[|]")[0]);
    }
}
