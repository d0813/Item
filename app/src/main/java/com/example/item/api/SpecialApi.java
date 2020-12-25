package com.example.item.api;

import com.example.item.bean.SpecialBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpecialApi {

    String SPECIAL_URL="https://cdplay.cn/";

    @GET("api/topic/list?page=1&size=10")
    Flowable<SpecialBean> getSpecial();
}
