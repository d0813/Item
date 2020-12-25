package com.example.item.api;

import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ClassifyApi {
    //旁边数据
//    https://cdplay.cn/api/catalog/current?id=1005001
    //导航栏
//    https://cdplay.cn/api/catalog/index

    String BASE_URL="https://cdplay.cn";

    @GET("api/catalog/current")
    Flowable<ClassifyBean> getclassify(@Query("id") int id);

    @GET("catalog/index")
    Flowable<ClassifyVerticalBean> getclassifylist();

    //http://cdplay.cn/goods/category?id=1008002
    @GET("goods/category")
    Flowable<ClassifyTitleBean> getclassifytitle(@Query("id") int id);

    //https://cdplay.cn/api/goods/list?categoryId=1005007&page=1&size=100

    @GET("api/goods/list")
    Flowable<ClassifyDetailbean> getclassdetail(@Query("categoryId") int categoryId,@Query("id") int id,@Query("size") int size);
}
