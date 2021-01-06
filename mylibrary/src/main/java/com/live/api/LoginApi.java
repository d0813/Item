package com.live.api;



import com.live.bean.LoginBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginApi {
    //https://cdplay.cn/api/auth/login
    String BASE_URL="https://cdplay.cn/";
    //https://cdplay.cn/api/auth/login


    @POST("api/auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> login(@Field("username") String username, @Field("password") String pw);


}


