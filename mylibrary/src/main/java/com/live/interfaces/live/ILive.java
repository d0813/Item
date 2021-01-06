package com.live.interfaces.live;

import com.live.bean.BeginLiveBean;
import com.live.bean.GainBean;
import com.live.bean.LiveBean;
import com.live.bean.MyRoomBean;
import com.live.bean.RoomLiveUrlBean;
import com.live.interfaces.CallBack;
import com.live.interfaces.IBaseModel;
import com.live.interfaces.IBasePresenter;
import com.live.interfaces.IBaseView;

import java.util.Map;

public interface ILive {

    interface View extends IBaseView{
        //创建房间
        void liveReturn(LiveBean liveBean);
        //开启直播
        void beginLiveReturn(BeginLiveBean beginLiveBean);
        //获取房间列表
        void getGainReturn(GainBean gainBean);
        //获取自己房间列表
        void MyRoomReturn(MyRoomBean myRoomBean);
        //房间播放地址获取
        void RoomLiveUrlReturn(RoomLiveUrlBean roomLiveUrlBean);
    }

    interface Presenter extends IBasePresenter<View>{
        void live(Map<String,String> map);

        void beginLive(String name,int roomid);

        void getGainReturn();

        void MyRoomReturn();

        void RoomLiveUrlReturn(Map<String,String> map);
    }

    interface Model extends IBaseModel{
        void live(CallBack callBack,Map<String,String> map);

        void beginLive(CallBack callBack,String name,int roomid);

        void getGainReturn(CallBack callBack);

        void MyRoomReturn(CallBack callBack);

        void RoomLiveUrlReturn(CallBack callBack,Map<String,String> map);
    }
}

