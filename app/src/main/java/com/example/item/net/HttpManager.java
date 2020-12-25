package com.example.item.net;

import com.example.item.api.ClassifyApi;
import com.example.item.api.HomeApi;
import com.example.item.api.LoginApi;
import com.example.item.api.ShopApi;
import com.example.item.api.ServicerApi;
import com.example.item.api.SpecialApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static HttpManager inseance;

    public static HttpManager getInstance() {
        if (inseance == null) {
            synchronized ((HttpManager.class)) {
                if (inseance == null) {
                    inseance = new HttpManager();
                }
            }
        }
        return inseance;
    }



    private Retrofit getRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
    private ServicerApi servicerApi;
    private HomeApi homeApi;
    private SpecialApi specialApi;
    private ShopApi shopApi;
    private ClassifyApi classifyApi;
    private LoginApi loginApi;

    public LoginApi getLoginApi(){
        if(loginApi==null){
            loginApi=getRetrofit(LoginApi.BASE_URL).create(LoginApi.class);
        }
        return loginApi;
    }

    public ClassifyApi getClassifyApi(){
        if(classifyApi == null){
            classifyApi=getRetrofit(ClassifyApi.BASE_URL).create(ClassifyApi.class);
        }
        return classifyApi;
    }

    public ShopApi getShopApi(){
        if(shopApi==null){
            shopApi=getRetrofit(ShopApi.SHOP_URL).create(ShopApi.class);
        }
        return shopApi;
    }

    public ServicerApi getServicerApi(){
        if(servicerApi==null){
            servicerApi=getRetrofit(ServicerApi.BASE_URL).create(ServicerApi.class);
        }
        return  servicerApi;
    }
    public HomeApi getHomeApi(){
        if(homeApi==null){
            homeApi=getRetrofit(HomeApi.HOME_URL).create(HomeApi.class);
        }
        return homeApi;
    }
    public SpecialApi getSpecialApi(){
        if(specialApi==null){
            specialApi=getRetrofit(SpecialApi.SPECIAL_URL).create(SpecialApi.class);

        }
        return specialApi;
    }

}

