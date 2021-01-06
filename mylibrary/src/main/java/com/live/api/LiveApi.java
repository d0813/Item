package com.live.api;


import com.live.bean.BeginLiveBean;
import com.live.bean.GainBean;
import com.live.bean.LiveBean;
import com.live.bean.MyRoomBean;
import com.live.bean.RoomLiveUrlBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LiveApi {

    String BaseURl = "https://cdplay.cn/";

    //https://cdplay.cn/api/live/createRoom
    //创建房间
    @POST("api/live/createRoom")
    Flowable<LiveBean> live(@FieldMap Map<String, String> map);


    //https://cdplay.cn/api/live/startLive
    //https://cdplay.cn/api/live/startLive
    //开启直播
    @POST("api/live/startLive")
    @FormUrlEncoded
    Flowable<BeginLiveBean> beginLive(@Field("title") String name, @Field("roomid") int roomid);

    //https://cdplay.cn/api/live/getRoomList
    //获取房间列表
    @GET("api/live/getRoomList")
    Flowable<GainBean> getGain();

    //https://cdplay.cn/api/live/myroom
    //获取自己房间列表
    @POST("api/live/myroom")
    Flowable<MyRoomBean> myRoom();

    //https://cdplay.cn/api/live/roomLiveUrl
    //房间播放地址获取
    @POST("api/live/roomLiveUrl")
    @FormUrlEncoded
    Flowable<RoomLiveUrlBean> roomLiveURl(@FieldMap Map<String, String> map);
}
