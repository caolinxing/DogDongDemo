package com.example.myjd.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.myjd.base.BaseActivity;
import com.example.myjd.view.R;
import com.example.myjd.view.fragment.CartFragment;
import com.example.myjd.view.fragment.ClassifyFragment;
import com.example.myjd.view.fragment.HomeFragment;
import com.example.myjd.view.fragment.MineFragment;
import com.example.view.fragment.FindFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.container)
    LinearLayout mContainer;
    private FragmentManager manager;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private ClassifyFragment classifyFragment;
    private CartFragment cartFragment;

    //绑定视图
    @Override
    protected int bindView() {
        return R.layout.activity_main;
    }


    //初始化数据
    @Override
    protected void initData() {
        manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.frame_layout, homeFragment).commit();
        mBottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)//设置可以设置以下书信
                .setActiveColor("#F23030")//未选择的颜色
                .setInActiveColor("#84858D")//已选择的颜色
                .setMode(BottomNavigationBar.MODE_FIXED)//可以切换导航栏模式
                .setAnimation(null);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.fenlei, "分类"))
                .addItem(new BottomNavigationItem(R.drawable.find, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.ic_shopping_cart_black_24dp, "购物车 & TV"))
                .addItem(new BottomNavigationItem(R.drawable.mine, "我的"))
                .initialise();
    }

    @Override
    protected void setClickListener() {
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {

            @Override
            public void onTabSelected(int position) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                if (homeFragment != null) {
                    transaction1.hide(homeFragment);
                }
                if (mineFragment != null) {
                    transaction1.hide(mineFragment);
                }
                if (findFragment != null) {
                    transaction1.hide(findFragment);
                }
                if (cartFragment != null) {
                    transaction1.hide(cartFragment);
                }
                if (classifyFragment != null) {
                    transaction1.hide(classifyFragment);
                }
                switch (position) {
                    case 0:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            transaction1.add(R.id.frame_layout, homeFragment);
                        } else {
                            transaction1.show(homeFragment);
                        }
                        break;
                    case 1:
                        if (classifyFragment == null) {
                            classifyFragment = new ClassifyFragment();
                            transaction1.add(R.id.frame_layout, classifyFragment);
                        } else {
                            transaction1.show(classifyFragment);
                        }
                        break;
                    case 2:
                        if (findFragment == null) {
                            findFragment = new FindFragment();
                            transaction1.add(R.id.frame_layout, findFragment);
                        } else {
                            transaction1.show(findFragment);
                        }
                        break;
                    case 3:
                        if (cartFragment == null) {
                            cartFragment = new CartFragment();
                            transaction1.add(R.id.frame_layout, cartFragment);
                        } else {
                            transaction1.show(cartFragment);
                        }
                        break;
                    case 4:
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                            transaction1.add(R.id.frame_layout, mineFragment);
                        } else {
                            transaction1.show(mineFragment);
                        }
                        break;
                }
                transaction1.commit();
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }

        });

    }
    //预留操作接口
    @Override
    protected void setOtherOption() {

    }
}
