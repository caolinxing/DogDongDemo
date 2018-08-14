package com.example.myjd.adapter;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myjd.bean.MutilRecyclerBean;
import com.example.myjd.utils.SpacesItemDecoration;
import com.example.myjd.view.R;
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @param
 * @param
 * @return
 */
public class HomeMutiplterRecyclerViewAdapter extends BaseMultiItemQuickAdapter<MutilRecyclerBean,BaseViewHolder>{

    private int index;

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
        addItemType(MutilRecyclerBean.TYPE_CAIDAN, R.layout.item_ciadan);
        addItemType(MutilRecyclerBean.TYPE_MIAOSHA, R.layout.item_miaosha_0);
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
                //1.获取每页的数量
                int pageSize = 10;
                //2.获取总的页数 总数/每页的数量，并取正math.ceil
                int pageCount = (int) Math.ceil(item.getJggBean().getData().size() * 1.0 / pageSize);
                //获取viewPager
                ViewPager vp = helper.getView(R.id.candan_vp);
                //4.创建viewpagerList集合
                final ArrayList<View> viewpagerList = new ArrayList<>();
                //5.根据数据数量创建recyclerview试图
                LayoutInflater inflater = LayoutInflater.from(mContext);
                for (int i = 0; i < pageCount; i++) {
                    index = i;
                    RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.item_viewpager,vp,false);
                    recyclerView.setLayoutManager(new GridLayoutManager(mContext,5));
                    RecyclerView_JGG adapter = new RecyclerView_JGG(mContext,item.getJggBean().getData(),index, new RecyclerView_JGG.onItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                        }
                    });
                    recyclerView.setAdapter(adapter);
                    //添加layout进viewpagerList
                    viewpagerList.add(recyclerView);
                }
                //设置适配器
                vp.setAdapter(new MyViewPagerAdapter(viewpagerList));
                break;
            case MutilRecyclerBean.TYPE_MIAOSHA:
                SimpleMarqueeView<String> marqueeView = helper.getView(R.id.simpleMarqueeView);
                final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
                //SimpleMarqueeView<T>，SimpleMF<T>：泛型T指定其填充的数据类型，比如String，Spanned等
                SimpleMF<String> marqueeFactory = new SimpleMF(mContext);
                marqueeFactory.setData(datas);
                marqueeView.setMarqueeFactory(marqueeFactory);
                marqueeView.startFlipping();
                RecyclerView recycler = helper.getView(R.id.miaosha_recycler);
                recycler.setLayoutManager(new GridLayoutManager(mContext,2));
                recycler.addItemDecoration(new SpacesItemDecoration(5));
                MyMiaoShaAdapter adapter = new MyMiaoShaAdapter(mContext, item.getHomeBean().getMiaosha().getList());
                recycler.setAdapter(adapter);
                break;
        }
    }
}
