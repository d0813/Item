package com.live.model;

import android.util.Log;

import com.live.base.BaseModel;
import com.live.bean.BeginLiveBean;
import com.live.bean.GainBean;
import com.live.bean.LiveBean;
import com.live.bean.MyRoomBean;
import com.live.bean.RoomLiveUrlBean;
import com.live.interfaces.CallBack;
import com.live.interfaces.IBaseModel;
import com.live.interfaces.live.ILive;
import com.live.net.CommonSubscriber;
import com.live.net.HttpManager;
import com.live.util.RxUtils;

import java.util.Map;

public class LiveModel extends BaseModel implements ILive.Model {
    //创建房间
    @Override
    public void live(CallBack callBack, Map<String,String> map) {
        addDisposible(HttpManager.getInstance().getLiveApi().live(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<LiveBean>(callBack) {
                    @Override
                    public void onNext(LiveBean liveBean) {
                        callBack.Success(liveBean);
                    }
                }));
    }

    //开启房间
    @Override
    public void beginLive(CallBack callBack,String name,int roomid) {
        addDisposible(HttpManager.getInstance().getLiveApi().beginLive(name,roomid)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<BeginLiveBean>(callBack) {
                    @Override
                    public void onNext(BeginLiveBean beginLiveBean) {
                        callBack.Success(beginLiveBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        Log.i("TAG", "onError: "+t.getMessage());
                    }
                }));

    }

    //获取房间列表
    @Override
    public void getGainReturn(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getLiveApi().getGain()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<GainBean>(callBack) {

                    @Override
                    public void onNext(GainBean gainBean) {
                        callBack.Success(gainBean);

                    }
                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        Log.i("111", "onError: 错误"+t.getMessage());
                    }
                }));

    }

    //获取自己房间列表
    @Override
    public void MyRoomReturn(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getLiveApi().myRoom().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<MyRoomBean>(callBack) {
                    @Override
                    public void onNext(MyRoomBean myRoomBean) {
                        callBack.Success(myRoomBean);
                    }
                }));

    }

    //房间播放地址获取
    @Override
    public void RoomLiveUrlReturn(CallBack callBack,Map<String,String> map) {
        addDisposible(HttpManager.getInstance().getLiveApi().roomLiveURl(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<RoomLiveUrlBean>(callBack) {
                    @Override
                    public void onNext(RoomLiveUrlBean roomLiveUrlBean) {
                        callBack.Success(roomLiveUrlBean);

                    }
                }));

    }
}

