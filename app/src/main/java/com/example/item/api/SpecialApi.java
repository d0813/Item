package com.example.item.api;

import com.example.item.bean.SpCommentBean;
import com.example.item.bean.SpDetailsBean;
import com.example.item.bean.SpecialBean;
import com.example.item.bean.SpecialDetailsButtomBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface SpecialApi {

    String SPECIAL_URL="https://cdplay.cn/";

    @GET("api/topic/list?page=1&size=10")
    Flowable<SpecialBean> getSpecial();

    //专题详情https://cdplay.cn/api/topic/detail?id=314
    @GET("api/topic/detail")
    Flowable<SpDetailsBean> getSpDetails(@Query("id") int id);

    //专题详情里的评论https://cdplay.cn/api/comment/list?valueId=314&typeId=1&size=5
    @GET("comment/list")
    Flowable<SpCommentBean> getSpComment(@QueryMap HashMap<String,String> map);

    //https://cdplay.cn/api/topic/related?id=314
    //专题底部列表
    @GET("api/topic/related")
    Flowable<SpecialDetailsButtomBean> getSpDetailsButtom(@Query("id") int id);

}
