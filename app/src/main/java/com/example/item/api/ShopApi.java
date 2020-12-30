package com.example.item.api;

import com.example.item.bean.ShopBean;
import com.example.item.bean.ShopListBean;
import com.example.item.bean.AddressCityBean;
import com.example.item.bean.UserInfoBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopApi {
    String SHOP_URL="https://cdplay.cn/";
    //商品详情购买页
    @GET("api/goods/detail")
    Flowable<ShopBean> getGoodDetail(@Query("id") int id);
    //商品详情购买页底下的推荐列表
    @GET("api/goods/related")
    Flowable<ShopListBean> getShopLIst(@Query("id") int id);

    //获取地址
    @GET("api/region/list")
    Flowable<AddressCityBean> getAddressCity(@Query("parentId") int parentId);

    //用户信息更新
//https://cdplay.cn/api/user/updateUserInfo
    @GET("user/updateUserInfo")
    Flowable<UserInfoBean> updateUserInfo(@FieldMap Map<String,String> map);
}
