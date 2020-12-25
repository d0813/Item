package com.example.item.api;

import com.example.item.bean.DetailBean;
import com.example.item.bean.HomeBean;
import com.example.item.bean.HomeDetailBean;
import com.example.item.bean.HomeNewBean;
import com.example.item.bean.HomeNewPriceBean;
import com.example.item.bean.InformationBean;
import com.example.item.bean.SubDetailHeadBean;
import com.example.item.bean.SubHomeDetailBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface HomeApi {

    String HOME_URL="https://cdplay.cn/";

    @GET("api/index")
    Flowable<HomeBean> getHome();
//    https://cdplay.cn/goods/category?id=1005000

    @GET("goods/category")
    Flowable<DetailBean> getdetail(@Query("id") int id);

//   https://cdplay.cn/api/goods/list?id=1005000&page=1&size=5

    @GET("api/goods/list")
    Flowable<InformationBean> getInformation(@Query("categoryId") int id,@Query("page") int page,@Query("size") int size);



    //https://cdplay.cn/api/goods/list?isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0
    //新品


    @GET("api/goods/list?isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0")
    Flowable<HomeNewBean> gethomenew();

    //https://cdplay.cn/api/brand/list?page=1&size=1000制造商一层
    @GET("api/brand/list?page=1&size=1000")
    Flowable<HomeDetailBean> gethomedetail();

    //https://cdplay.cn/api/brand/detail?id=1001000制造成二层头部
    @GET("brand/detail")
    Flowable<SubDetailHeadBean> getsubDetailhead(@Query("id") int id);

    //https://cdplay.cn/api/goods/list?brandId=1001000&page=1&size=1000制造商二层列表
    @GET("api/goods/list")
    Flowable<SubHomeDetailBean> getsubHomeDetail(@Query("brandId") int id,@Query("page") int page,@Query("size") int size);

    //新品价格升序降序接口
    //https://cdplay.cn/api/goods/list?isNew=1&page=1&size =1000&order=asc&sort=price&categoryId=1005000

    @GET("api/goods/list")
    Flowable<HomeNewPriceBean> gethomenewprice(@QueryMap HashMap<String,String> map);



}
