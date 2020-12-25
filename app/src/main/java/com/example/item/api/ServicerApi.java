package com.example.item.api;

import com.example.item.bean.HomeBean;
import com.example.item.bean.NeteaseBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ServicerApi {
    String BASE_URL="https://www.getpostman.com/";



    @GET("collections/912c9ec15259bffdb258")
    Flowable<NeteaseBean> getNetease();


}
