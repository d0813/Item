package com.example.item.api;

import com.example.item.bean.ShopBean;
import com.example.item.bean.ShopListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ShopApi {
    String SHOP_URL="https://cdplay.cn/";
    //商品详情购买页
    @GET("api/goods/detail")
    Flowable<ShopBean> getGoodDetail(@Query("id") int id);
    //商品详情购买页底下的推荐列表
    @GET("api/goods/related")
    Flowable<ShopListBean> getShopLIst(@Query("id") int id);
}
