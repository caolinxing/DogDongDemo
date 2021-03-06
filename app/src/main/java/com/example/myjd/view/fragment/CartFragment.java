package com.example.myjd.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myjd.adapter.CartMutiAdapter;
import com.example.myjd.base.BaseFragment;
import com.example.myjd.bean.CartBean;
import com.example.myjd.bean.QueryCartMutilplterBean;
import com.example.myjd.bean.UpdataCartBean;
import com.example.myjd.mvp.contract.DingDan_Contract;
import com.example.myjd.mvp.contract.QueryCart_Contract;
import com.example.myjd.mvp.contract.UpdataCart_Contract;
import com.example.myjd.mvp.presenter.QueryCart_Presenter;
import com.example.myjd.mvp.presenter.UpdataCart_Presenter;
import com.example.myjd.utils.Logger;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;
import com.example.myjd.view.activity.DingDan;
import com.example.myjd.view.activity.LoginActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends BaseFragment implements QueryCart_Contract.View,UpdataCart_Contract.View{


    private android.support.v7.widget.RecyclerView mGoodsRecyclerView;
    private android.widget.CheckBox mGoodsCbCheckedAll;
    private android.widget.TextView mGoodsAllPrice;
    private QueryCart_Contract.Presenter presenter;
    private List<QueryCartMutilplterBean> cartList;
    private List<CartBean.DataBean> CBCartList = new ArrayList<>();
    private CartMutiAdapter adapter;
    private UpdataCart_Presenter presenter_up;
    private String uid1;
    private String selected = "1";
    private DecimalFormat df = new DecimalFormat("0.00");//保留两位小数
    boolean Checked ;
    private int selected1;
    private boolean b;
    private TextView mCartTvTishi;
    private Button mGoodsBnCount;
    private String allPrice_1;
    private DingDan_Contract.Presenter dingDan_presenter;


    public CartFragment() {
    }


    @Override
    protected void otherOpration() {

    }

    /**
     *每次切换fragment回调onHiddenChanged()
     * 及时更新页面
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        initData();
    }

    @Override
    protected void onClickListener() {
        /**
         * 全选更新购物车
         */
       mGoodsCbCheckedAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            private String selected_qx;
            private String num_qx;
            private String pid_qx;
            private String sellerid_qx;

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Logger.i("isChecked:"+isChecked+"数据大小："+CBCartList.size());
                    Checked = isChecked;

                    presenter.setData(uid1);
                }else if (!isChecked){
                    Logger.i("isChecked:"+isChecked+"数据大小："+CBCartList.size());
                    Checked = isChecked;
                    presenter.setData(uid1);
                }
                /**
                 * 点击全选标记
                 */
                b = true;
                adapter.notifyDataSetChanged();
            }
        });

       //下单
        mGoodsBnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DingDan.class);
                intent.putExtra("price",allPrice_1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setAdapter() {

    }

    @Override
    protected void initData() {
        /**
         * 从sp存储取出uid
         */
        SharedPreferences userInfo = getActivity().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        uid1 = userInfo.getString("uid","");
        if (!TextUtils.isEmpty(uid1)){
            cartList = new ArrayList<>();
            presenter = new QueryCart_Presenter(this);
            presenter_up = new UpdataCart_Presenter(this);
            presenter.setData(uid1);
        }else {
            mCartTvTishi.setVisibility(View.VISIBLE);
        }

        mCartTvTishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

    }

    /**
     * 初始化控件
     * @param v
     */
    @Override
    protected void findView(View v) {
        mGoodsRecyclerView = (RecyclerView)v.findViewById(R.id.goods_recyclerView);
        mGoodsCbCheckedAll = (CheckBox) v.findViewById(R.id.goods_cb_checkedAll);
        mGoodsAllPrice = (TextView) v.findViewById(R.id.goods_allPrice);
        mGoodsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCartTvTishi = (TextView) v.findViewById(R.id.cart_tv_tishi);
        mGoodsBnCount = (Button) v.findViewById(R.id.goods_btn_count);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_cart;
    }

    @Override
    public void onFaild(String errorMsg) {
        Logger.i(errorMsg);
    }

    @Override
    public void onFaild1(String errorMsg) {
        Logger.i("onFaild1: "+errorMsg);
    }

    /**
     * 更新数据成功 返回参数success
     * 则重新查询GoodsCart数据
     * @param cartBean
     */
    @Override
    public void onSuccessful1(UpdataCartBean cartBean) {
        Logger.i("update:"+cartBean.getMsg());
        if (cartBean.getMsg().equals("success")){
            presenter.setData(uid1);
        }
    }

    @Override
    public void onSuccessful(final CartBean cartBean) {
        CBCartList=cartBean.getData();
        cartList.clear();
        /**
         * allprice :商品总价
         */
        float allPrice = 0;
        for (int i = 1; i <cartBean.getData().size() ; i++) {
            cartList.add(new QueryCartMutilplterBean(null,cartBean.getData().get(i),QueryCartMutilplterBean.TYPE_SHOP_NAME));
            List<CartBean.DataBean.ListBean> listBeans = cartBean.getData().get(i).getList();
            for (int j = 0; j <listBeans.size() ; j++) {
                /**
                 * 判断是否选中全选
                 * 点击全选标记 ：b :true :点击了全选，false:没点击全选
                 *
                 */
                if (Checked&&b){
                    listBeans.get(j).setSelected("1");
                }else if (!Checked&&b){
                    listBeans.get(j).setSelected("0");
                }
                cartList.add(new QueryCartMutilplterBean(listBeans.get(j),null,QueryCartMutilplterBean.TYPE_GOODS_XIANGQING));
                /**
                 * 商品选中状态为1的商品计算总价
                 */
                if (listBeans.get(j).getSelected().equals("1")){
                    float price =  Float.parseFloat(listBeans.get(j).getPrice());
                    int num =  Integer.parseInt(listBeans.get(j).getNum());
                    allPrice  += price * num;
                }
            }
        }
        /**
         * 执行完循环重置全选标记
         */
        b=false;
        adapter = new CartMutiAdapter(cartList);
        mGoodsRecyclerView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    /**
                     * 商铺选中状态
                     */
                    case R.id.item_cb_seletor_zong:
                        CheckBox cb = view.findViewById(R.id.item_cb_seletor_zong);
                        if (cb.isChecked()){
                            cartList.get(position).getCartDataBean().setSelectedState(true);
                        }else {
                            cartList.get(position).getCartDataBean().setSelectedState(false);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    /**
                     * 商品选中状态
                     */
                    case R.id.item_cb_goods_seletorchild:
                        //点击checkbox,如果商品选中状态为1（）true则设置为0（false）否则反之
                        String selected1 = cartList.get(position).getCartListBean().getSelected();
                        if (selected1.equals("1")){
                             selected1 ="0";
                        }else if (selected1.equals("0")){
                            selected1 ="1";
                        }
                        ToastUtils.showToast(getActivity(),"点击了条目"+position+"checkbox");
                        int num0 = Integer.parseInt(cartList.get(position).getCartListBean().getNum());
                        String sellerid0 = cartList.get(position).getCartListBean().getSellerid();
                        String pid0 = cartList.get(position).getCartListBean().getPid();
                        presenter_up.setData(uid1,sellerid0,pid0,selected1, String.valueOf(num0));
                        adapter.notifyItemChanged(position);
                        break;
                    /**
                     * 商品添加
                     *  点击添加 商品更改选中状态为1
                     *  商品数num+1
                     *
                     */
                    case R.id.item_iv_goodsAdd:
                        ToastUtils.showToast(getActivity(),"点击了条目"+position+"add");
                        int num = Integer.parseInt(cartList.get(position).getCartListBean().getNum());
                        num++;
                        String sellerid = cartList.get(position).getCartListBean().getSellerid();
                        String pid = cartList.get(position).getCartListBean().getPid();
                        presenter_up.setData(uid1,sellerid,pid, CartFragment.this.selected, String.valueOf(num));
                        adapter.notifyItemChanged(position);
                        break;
                    /**
                     * 商品减少
                     *  点击添加 商品更改选中状态为1
                     *  商品数为1不减
                     *  商品数num-1
                     *
                     */
                    case R.id.item_iv_jian2:
                        int num1 = Integer.parseInt(cartList.get(position).getCartListBean().getNum());
                        if (num1>1){
                            ToastUtils.showToast(getActivity(),"点击了条目"+position+"jian");
                            num1--;
                            cartList.get(position).getCartListBean().setNum(num1+"");
                            cartList.get(position).getCartListBean().setSelected("1");
                            String sellerid1 = cartList.get(position).getCartListBean().getSellerid();
                            String pid1 = cartList.get(position).getCartListBean().getPid();
                            presenter_up.setData(uid1,sellerid1,pid1, CartFragment.this.selected, String.valueOf(num1));
                            adapter.notifyItemChanged(position);
                        }
                        break;
                }
            }
        });
        /**
         * 格式化价格数据为0.00(保留两位)
         */
        String GoodsAllPrice = df.format(allPrice);
        allPrice_1 = GoodsAllPrice;
        mGoodsAllPrice.setText("￥"+GoodsAllPrice);
    }

    @Override
    public void onDestroy() {
        presenter.onDestory();
        presenter_up.onDestory();
        super.onDestroy();

    }



}
