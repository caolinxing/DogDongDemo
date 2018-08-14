package com.example.myjd.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.utils.Logger;
import com.example.myjd.view.R;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/11$ 17:49$
 */
public class MyCfyRecyclerAdapter_Left extends BaseQuickAdapter<JGGDaoHangBean.DataBean ,BaseViewHolder> {

    public MyCfyRecyclerAdapter_Left(int layoutResId, @Nullable List<JGGDaoHangBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JGGDaoHangBean.DataBean item) {
        TextView view = helper.getView(R.id.item_goodsList_tv);

        if (item.isIschecked()){
            view.setSelected(true);
        }else{
            view.setSelected(false);
        }
        helper.setText(R.id.item_goodsList_tv,item.getName());
    }
}
