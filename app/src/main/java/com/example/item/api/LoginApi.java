package com.example.item.api;

import com.example.item.bean.DeleteCarBean;
import com.example.item.bean.UpdateCarBean;
import com.example.item.bean.login.AddCarBean;
import com.example.item.bean.login.CarBean;
import com.example.item.bean.login.LoginBean;

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


    @POST("api/auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> login(@Field("username") String username, @Field("password") String pw);


    //添加到购物车
    @POST("api/cart/add")
    @FormUrlEncoded
    Flowable<AddCarBean> addCar(@FieldMap Map<String,String> map);

//    //购物车列表
//    @GET("api/cart/index")
//    Flowable<CarBean> addCar();

    //更新购物车的数据
    @POST("api/cart/update")
    @FormUrlEncoded
    Flowable<UpdateCarBean> updateCar(@FieldMap Map<String,String> map);

    //删除购物车数据
    @POST("api/cart/delete")
    @FormUrlEncoded
    Flowable<DeleteCarBean> deleteCar(@Field("productIds") String productIds);

    //购物车列表
    @GET("api/cart/index")
    Flowable<CarBean> getCarList();

}


