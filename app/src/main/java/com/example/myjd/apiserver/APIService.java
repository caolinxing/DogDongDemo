package com.example.myjd.apiserver;


import com.example.myjd.bean.AddCartBean;
import com.example.myjd.bean.CartBean;
import com.example.myjd.bean.DingDanBean;
import com.example.myjd.bean.GoodsListBean;
import com.example.myjd.bean.HomeBean;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.bean.LoginBean;
import com.example.myjd.bean.RegisterBean;
import com.example.myjd.bean.RelaxBean;
import com.example.myjd.bean.SearchBean;
import com.example.myjd.bean.UpdataCartBean;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API--接口  服务[这里处理的是同一的返回格式 resultCode  resultInfo Data<T> --->这里的data才是返回的结果,T就是泛型 具体返回的been对象或集合]
 * Created by HDL on 2016/8/3.
 */
public interface APIService {
    /**
     * 用户登录注册的接口
     *
     * @param username 用户名
     * @param pwd      密码
     * @return RxJava 对象
     */
    @GET("user/login")
    Observable<LoginBean> userLogin(@Query("mobile") String username, @Query("password") String pwd);

    @GET("user/reg")
    Observable<RegisterBean> userRegister(@Query("mobile") String username, @Query("password") String pwd);

    /**
     * 注册
     * @return
     */
    @GET("ad/getAd")
    Observable<HomeBean> homeBanner();

    /**
     * 九宫格分类导航
     * @return
     */
    @GET("product/getCatagory")
    Observable<JGGDaoHangBean> homeJiuDaoHang();

    /**
     * 商品详情
     * @修改人和其它信息:
     */
    @GET("product/getProducts")
    Observable<GoodsListBean> goodsList(@Query("pscid")String pscid);

    /**
     * 搜索
     * @修改人和其它信息:
     */
    @GET("product/searchProducts")
    Observable<SearchBean> rxSearch(@Query("keywords")String keywords,@Query("page")int page,@Query("sort")int sort);

    /**
     *  加入购物车
     * @修改人和其它信息:
     */
    @GET("product/addCart")
    Observable<AddCartBean> rxAddCart(@Query("Uid")String uid, @Query("pid")String pid);

    /**
     * 查询购物车
     * @修改人和其它信息:
     */
    @GET("product/getCarts")
    Observable<CartBean> rxQueryCart(@Query("uid")String uid);

    /**
     * 更新购物车
     * @修改人和其它信息:
     */
    @GET("product/updateCarts")
    Observable<UpdataCartBean> rxUpdataCart(@Query("uid")String uid,@Query("sellerid")String sellerid,@Query("pid")String pid,@Query("selected") String selected,@Query("num") String num);


    /**
     * 休闲一刻
     * @修改人和其它信息:
     */
    @GET("api/data/%E7%A6%8F%E5%88%A9/10/2")
    Observable<RelaxBean> rxRelax();

    /**
     * 提交订单
     * @修改人和其它信息:
     */
    @GET("product/createOrder")
    Observable<DingDanBean> rxDingDan(@Query("uid") String uid,@Query("price") String price );
}
