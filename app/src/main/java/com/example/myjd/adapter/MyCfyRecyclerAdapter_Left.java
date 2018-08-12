package com.example.myjd.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.JGGDaoHangBean;
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
        helper.setText(R.id.item_goodsList_tv,item.getName());
    }
}
