package com.example.myjd.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.MutilRecyclerBean_GoodsXaingQing;
import com.example.myjd.view.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

/**
 * @param
 * @param
 * @return
 */
public class MyCfyecyclerViewAdapter_Right extends BaseMultiItemQuickAdapter<MutilRecyclerBean_GoodsXaingQing,BaseViewHolder>{
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyCfyecyclerViewAdapter_Right(List<MutilRecyclerBean_GoodsXaingQing> data) {
        super(data);
        //必须绑定type和layout的关系
        addItemType(MutilRecyclerBean_GoodsXaingQing.TYPE_PIC, R.layout.item_right1);
        addItemType(MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO1, R.layout.item_right2);
        addItemType(MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO1_1, R.layout.item_right2_1);
        addItemType(MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO2, R.layout.item_right3);
        addItemType(MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO2_1, R.layout.item_right3_1);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MutilRecyclerBean_GoodsXaingQing item) {
        switch (helper.getItemViewType()){
            case MutilRecyclerBean_GoodsXaingQing.TYPE_PIC:
                Glide.with(mContext).load(R.mipmap.lunbotu3).into((ImageView) helper.getView(R.id.item_reight1_img));
                break;
            case MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO1:
                helper.setText(R.id.item_reight4_tv_title1,"常用分类");
                break;
            case MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO1_1:
                for (int i = 0; i < item.getHomeBean().getData().size(); i++) {
                        switch (i){
                            case 1:
                                helper.setText(R.id.item_reight2_tv_name,item.getHomeBean().getData().get(i).getName())
                                        .addOnClickListener(R.id.item_reight2_sdv)
                                        .addOnClickListener(R.id.item_reight2_tv_name);
                                SimpleDraweeView sdv1 = helper.getView(R.id.item_reight2_sdv);
                                Phoenix.with(sdv1).load(item.getHomeBean().getData().get(i).getIcon());
                               break;
                            case 2:
                                helper.setText(R.id.item_reight2_tv_name2,item.getHomeBean().getData().get(i).getName())
                                        .addOnClickListener(R.id.item_reight2_sdv2)
                                        .addOnClickListener(R.id.item_reight2_tv_name2);
                                SimpleDraweeView sdv2 = helper.getView(R.id.item_reight2_sdv2);
                                Phoenix.with(sdv2).load(item.getHomeBean().getData().get(i).getIcon());
                            case 3:
                                helper.setText(R.id.item_reight2_tv_name3,item.getHomeBean().getData().get(i).getName())
                                        .addOnClickListener(R.id.item_reight2_sdv3)
                                        .addOnClickListener(R.id.item_reight2_tv_name3);
                                SimpleDraweeView sdv3 = helper.getView(R.id.item_reight2_sdv3);
                                Phoenix.with(sdv3).load(item.getHomeBean().getData().get(i).getIcon());
                            case 4:
                                helper.setText(R.id.item_reight2_tv_name4,item.getHomeBean().getData().get(i).getName())
                                        .addOnClickListener(R.id.item_reight2_sdv4)
                                        .addOnClickListener(R.id.item_reight2_tv_name4);
                                SimpleDraweeView sdv4 = helper.getView(R.id.item_reight2_sdv4);
                                Phoenix.with(sdv4).load(item.getHomeBean().getData().get(i).getIcon());
                               break;
                            case 5:
                                helper.setText(R.id.item_reight2_tv_name5,item.getHomeBean().getData().get(i).getName())
                                        .addOnClickListener(R.id.item_reight2_sdv5)
                                        .addOnClickListener(R.id.item_reight2_tv_name5);
                                SimpleDraweeView sdv5 = helper.getView(R.id.item_reight2_sdv5);
                                Phoenix.with(sdv5).load(item.getHomeBean().getData().get(i).getIcon());
                            case 6:
                                helper.setText(R.id.item_reight2_tv_name6,item.getHomeBean().getData().get(i).getName())
                                        .addOnClickListener(R.id.item_reight2_sdv6)
                                        .addOnClickListener(R.id.item_reight2_tv_name6);
                                SimpleDraweeView sdv6 = helper.getView(R.id.item_reight2_sdv6);
                                Phoenix.with(sdv6).load(item.getHomeBean().getData().get(i).getIcon());
                    }
                }
                break;
            case MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO2:
                helper.setText(R.id.item_reight3_tv_title2,"热销榜 > ");
                helper.setText(R.id.item_reight3_tv_title1,"热门分类");
                break;
            case MutilRecyclerBean_GoodsXaingQing.TYPE_LIEBIAO2_1:
                for (int i = 0; i < item.getHomeBean().getData().size(); i++) {
                    switch (i) {
                        case 7:
                            helper.setText(R.id.item_reight3_tv_name, item.getHomeBean().getData().get(i).getName())
                                    .addOnClickListener(R.id.item_reight3_sdv)
                                    .addOnClickListener(R.id.item_reight3_tv_name);
                            SimpleDraweeView sdv1 = helper.getView(R.id.item_reight3_sdv);
                            Phoenix.with(sdv1).load(item.getHomeBean().getData().get(i).getIcon());
                            break;
                        case 8:
                            helper.setText(R.id.item_reight3_tv_name2, item.getHomeBean().getData().get(i).getName())
                                    .addOnClickListener(R.id.item_reight3_sdv2)
                                    .addOnClickListener(R.id.item_reight3_tv_name2);
                            SimpleDraweeView sdv2 = helper.getView(R.id.item_reight3_sdv2);
                            Phoenix.with(sdv2).load(item.getHomeBean().getData().get(i).getIcon());
                        case 9:
                            helper.setText(R.id.item_reight3_tv_name3, item.getHomeBean().getData().get(i).getName())
                                    .addOnClickListener(R.id.item_reight3_sdv3)
                                    .addOnClickListener(R.id.item_reight3_tv_name3);
                            SimpleDraweeView sdv3 = helper.getView(R.id.item_reight3_sdv3);
                            Phoenix.with(sdv3).load(item.getHomeBean().getData().get(i).getIcon());
                        case 10:
                            helper.setText(R.id.item_reight3_tv_name4, item.getHomeBean().getData().get(i).getName())
                                    .addOnClickListener(R.id.item_reight3_sdv4)
                                    .addOnClickListener(R.id.item_reight3_tv_name4);
                            SimpleDraweeView sdv4 = helper.getView(R.id.item_reight3_sdv4);
                            Phoenix.with(sdv4).load(item.getHomeBean().getData().get(i).getIcon());
                            break;
                        case 11:
                            helper.setText(R.id.item_reight3_tv_name5, item.getHomeBean().getData().get(i).getName())
                                    .addOnClickListener(R.id.item_reight3_sdv5)
                                    .addOnClickListener(R.id.item_reight3_tv_name5);
                            SimpleDraweeView sdv5 = helper.getView(R.id.item_reight3_sdv5);
                            Phoenix.with(sdv5).load(item.getHomeBean().getData().get(i).getIcon());
                        case 12:
                            helper.setText(R.id.item_reight3_tv_name6, item.getHomeBean().getData().get(i).getName())
                                    .addOnClickListener(R.id.item_reight3_sdv6)
                                    .addOnClickListener(R.id.item_reight3_tv_name6);
                            SimpleDraweeView sdv6 = helper.getView(R.id.item_reight3_sdv6);
                            Phoenix.with(sdv6).load(item.getHomeBean().getData().get(i).getIcon());
                    }
                }
                break;
        }
    }
}
