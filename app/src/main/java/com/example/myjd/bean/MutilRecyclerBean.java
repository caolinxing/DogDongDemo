package com.example.myjd.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 *  recyclerView 多条目bean
 * @author  user
 * @version 1.0
 * @date 2018/8/11 9:51
 */
public class MutilRecyclerBean implements MultiItemEntity {
    public static final int TYPE_BANNER = 0;
    public static final int TYPE_CAIDAN = 1;
    public static final int TYPE_PAOMADENG = 2;
    public static final int TYPE_GOODSlIST = 3;

    private HomeBean homeBean;
    private JGGDaoHangBean jggBean;
    private int itemType;

    public MutilRecyclerBean(HomeBean homeBean,JGGDaoHangBean jggBean, int itemType) {
        this.homeBean = homeBean;
        this.itemType = itemType;
        this.jggBean = jggBean;
    }

    public HomeBean getHomeBean() {
        return homeBean;
    }

    public JGGDaoHangBean getJggBean() {
        return jggBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
