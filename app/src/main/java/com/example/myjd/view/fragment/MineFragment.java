package com.example.myjd.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myjd.adapter.MyMine_1_2RecyclerAdapter;
import com.example.myjd.adapter.MyMine_2_2RecyclerAdapter;
import com.example.myjd.adapter.MyMine_3_2RecyclerAdapter;
import com.example.myjd.adapter.MyTuiJian2Adapter;
import com.example.myjd.base.BaseFragment;
import com.example.myjd.bean.CartMutilRecyclerBean;
import com.example.myjd.bean.Mine1_Bean;
import com.example.myjd.utils.Logger;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;
import com.example.myjd.view.activity.LoginActivity;
import com.example.myjd.view.activity.UserInfoActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {


    private com.facebook.drawee.view.SimpleDraweeView mMineIvTouxiang;
    private android.widget.TextView mMineTvUname;
    private android.support.v7.widget.RecyclerView mMineRecycler1;
    private android.support.v7.widget.RecyclerView mMineRecycler2;
    private android.support.v7.widget.RecyclerView mMineRecycler3;
    private android.widget.LinearLayout mLinLayout;
    private SharedPreferences userinfo;
    private String uid;
    private List<Mine1_Bean> mine1_beanList;
    private ArrayList<Mine1_Bean> mine2_beanList;
    private MyMine_1_2RecyclerAdapter adapter_min1;
    private MyMine_2_2RecyclerAdapter adapter_min2;
    private ArrayList<CartMutilRecyclerBean> mine3_beanList = new ArrayList<>();
    private MyMine_3_2RecyclerAdapter adapter_min3;
    private RecyclerView mMineTJRecyclerView;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    protected void otherOpration() {

    }

    @Override
    protected void onClickListener() {
        /**
         * 监听
         */
        mLinLayout.setOnClickListener(this);
        mMineTvUname.setOnClickListener(this);
        mMineIvTouxiang.setOnClickListener(this);
    }

    @Override
    protected void setAdapter() {
        mine1_beanList = new ArrayList<>();
        mine1_beanList.add(new Mine1_Bean(R.drawable.fukuang,"待付款"));
        mine1_beanList.add(new Mine1_Bean(R.drawable.shouhuo,"待收货"));
        mine1_beanList.add(new Mine1_Bean(R.drawable.pingjia,"待评价"));
        mine1_beanList.add(new Mine1_Bean(R.drawable.shouhou,"退后/售后"));
        mine2_beanList = new ArrayList<>();
        mine2_beanList.add(new Mine1_Bean(R.string.mine1,"京豆"));
        mine2_beanList.add(new Mine1_Bean(R.string.mine1,"优惠卷"));
        mine2_beanList.add(new Mine1_Bean(R.string.mine2,"白条"));
        mine2_beanList.add(new Mine1_Bean(R.string.mine2,"京东小金库"));

        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.string.mine1,"商品关注"),CartMutilRecyclerBean.TYPE_1));
        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.string.mine1,"店铺关注"),CartMutilRecyclerBean.TYPE_1));
        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.string.mine1,"内容收藏"),CartMutilRecyclerBean.TYPE_1));
        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.string.mine1,"浏览记录"),CartMutilRecyclerBean.TYPE_1));
        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.drawable.rili,"我的活动"),CartMutilRecyclerBean.TYPE_2));
        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.drawable.shequ,"社区"),CartMutilRecyclerBean.TYPE_2));
        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.drawable.kefu,"客服服务"),CartMutilRecyclerBean.TYPE_2));
        mine3_beanList.add(new CartMutilRecyclerBean(new Mine1_Bean(R.drawable.shop,"京东超市"),CartMutilRecyclerBean.TYPE_2));

        adapter_min1 = new MyMine_1_2RecyclerAdapter(R.layout.mine_1_2_lauout,mine1_beanList);
        adapter_min2 = new MyMine_2_2RecyclerAdapter(R.layout.mine_2_2_lauout,mine2_beanList);
        adapter_min3 = new MyMine_3_2RecyclerAdapter(mine3_beanList);
        mMineRecycler1.setAdapter(adapter_min1);
        mMineRecycler2.setAdapter(adapter_min2);
        mMineRecycler3.setAdapter(adapter_min3);


        adapter_min1.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast(getActivity(),"点击了第"+position+"条");
            }
        });
        adapter_min2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast(getActivity(),"点击了第"+position+"条");
            }
        });
        adapter_min3.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast(getActivity(),"点击了第"+position+"条");
            }
        });
        mMineTJRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        /*MyTuiJian2Adapter adapter2 = new MyTuiJian2Adapter(getActivity(), );
        mMineTJRecyclerView.setAdapter(adapter2);*/
    }

    @Override
    protected void initData() {
        userinfo = getActivity().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        uid = userinfo.getString("uid", "");
    }

    @Override
    protected void findView(View v) {
        /**
         *初始化控件
         */
        initView1(v);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_mine;
    }

    private void initView1(View v) {
        mMineIvTouxiang = (SimpleDraweeView) v.findViewById(R.id.mine_iv_touxiang);
        mMineTvUname = (TextView) v.findViewById(R.id.mine_tv_uname);
        mMineRecycler1 = (RecyclerView) v.findViewById(R.id.mine_recycler_1);
        mMineRecycler2 = (RecyclerView) v.findViewById(R.id.mine_recycler_2);
        mMineRecycler3 = (RecyclerView) v.findViewById(R.id.mine_recycler_3);
        mLinLayout = (LinearLayout) v.findViewById(R.id.lin_layout);
        mMineRecycler1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mMineRecycler2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mMineRecycler3.setLayoutManager(new GridLayoutManager(getActivity(),4));
        mMineTJRecyclerView = (RecyclerView) v.findViewById(R.id.mine_TJ_recycler_view);
    }

    @Override
    public void onClick(View v) {
        /**
         * 判断跳转
         * 1：登入
         * 2：个人信息
         */
        switch (v.getId()){
            case R.id.lin_layout:
                isStartLogin();
                break;
            case R.id.mine_tv_uname:
                isStartLogin();
                break;
            case R.id.mine_iv_touxiang:
                isStartLogin();
                break;
        }
    }

    private void isStartLogin() {
        if (TextUtils.isEmpty(uid)){
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }else {
            Intent intent = new Intent(getActivity(),UserInfoActivity.class);
            intent.putExtra("uid", uid);
            Logger.i("--------------------"+uid);
            startActivity(intent);
        }
    }
}
