package com.example.myjd.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.MutilRecyclerBean;
import com.example.myjd.utils.Logger;
import com.example.myjd.view.R;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @param
 * @return
 */
public class HomeMutiplterRecyclerViewAdapter extends BaseMultiItemQuickAdapter<MutilRecyclerBean,BaseViewHolder>{
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeMutiplterRecyclerViewAdapter(List<MutilRecyclerBean> data) {
        super(data);
        //必须绑定type和layout的关系
        addItemType(MutilRecyclerBean.TYPE_BANNER, R.layout.item_banner);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MutilRecyclerBean item) {
        switch (helper.getItemViewType()){
            case MutilRecyclerBean.TYPE_BANNER:
                XBanner banner = helper.getView(R.id.xbanner);
                final List<String> imgList = new ArrayList<>();
                for (int i = 0; i < item.getHomeBean().getData().size(); i++) {
                    imgList.add(item.getHomeBean().getData().get(i).getIcon());
                }
                banner.setData(imgList,null);
                banner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(mContext).load(imgList.get(position)).into((ImageView) view);
                    }
                });
                break;
            case MutilRecyclerBean.TYPE_CAIDAN:

                break;
        }
    }
}
