package com.example.myjd.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.Collection;

/**
 *  recyclerView 多条目bean
 * @author  user
 * @version 1.0
 * @date 2018/8/11 9:51
 */
public class MutilRecyclerBean_GoodsXaingQing implements MultiItemEntity {
    public static final int TYPE_PIC = 0;
    public static final int TYPE_LIEBIAO1= 1;
    public static final int TYPE_LIEBIAO1_1= 2;
    public static final int TYPE_LIEBIAO2= 3;
    public static final int TYPE_LIEBIAO2_1= 4;

    private JGGDaoHangBean homeBean;
    private int itemType;

    public MutilRecyclerBean_GoodsXaingQing(JGGDaoHangBean homeBean, int itemType) {
        this.homeBean = homeBean;
        this.itemType = itemType;
    }

    public JGGDaoHangBean getHomeBean() {
        return homeBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
