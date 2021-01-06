package com.live.net;


import android.util.Log;

import com.live.api.LiveApi;
import com.live.api.LoginApi;
import com.live.util.SpUtils;
import com.luck.picture.lib.tools.SPUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
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
                .client(ok())
                .build();
        return retrofit;
    }

    private OkHttpClient ok() {
        OkHttpClient build = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new HeaderInterceptor())
                .build();
        return build;
    }

    private class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            ResponseBody responseBody = response.peekBody(Integer.MAX_VALUE);
            Log.i("responseBody", responseBody.string());
            return response;
        }
    }

    static class HeaderInterceptor implements Interceptor {

        private String TAG = "httpManager";
        private String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoieW8wY2NoNHFsYiIsImlhdCI6MTYwOTkwMTQwMn0.QNIfDOi1uoVKIOf59uExYdPZavJGv8U4-bj7oDtI5xM";

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            if (headerMap != null) {
                Iterator<String> it = headerMap.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    builder.addHeader(key, headerMap.get(key));
                }
            }
//                    .addHeader("Authorization","APPCODE 964e16aa1ae944e9828e87b8b9fbd30a")
//                    .addHeader("X-Nideshop-Token",token)
//                   // .addHeader("X-Nideshop-Token", SpUtils.getInstance().getString("token"))
//                    .addHeader("Client-Type","ANDROID")
//                    .build();
//                      Log.e(TAG, "intercept: " +  SpUtil.getInstance().getString("token"));
            Request request = builder.build();
            return chain.proceed(request);
        }
    }

    private LoginApi loginApi;
    private LiveApi liveApi;
    private static Map<String, String> headerMap;

    /**
     * 设置请求头信息
     *
     * @param map
     */
    public void setHeaders(Map<String, String> map) {
        headerMap = map;
    }

    public LiveApi getLiveApi() {
        if (liveApi == null) {
            liveApi = getRetrofit(LiveApi.BaseURl).create(LiveApi.class);
        }
        return liveApi;
    }

    public LoginApi getLoginApi() {
        if (loginApi == null) {
            loginApi = getRetrofit(LoginApi.BASE_URL).create(LoginApi.class);
        }
        return loginApi;
    }


}

