package com.live.presenter;

import android.util.Log;

import com.live.base.BasePresenter;
import com.live.bean.BeginLiveBean;
import com.live.bean.GainBean;
import com.live.bean.LiveBean;
import com.live.bean.MyRoomBean;
import com.live.bean.RoomLiveUrlBean;
import com.live.interfaces.CallBack;
import com.live.interfaces.IBaseView;
import com.live.interfaces.live.ILive;
import com.live.model.LiveModel;

import java.util.Map;

public class LivePresenter extends BasePresenter<ILive.View> implements ILive.Presenter {
    ILive.View view;
    ILive.Model model;

    public LivePresenter(ILive.View view) {
        this.view = view;
        model=new LiveModel();
    }

    @Override
    public void live(Map<String,String> map) {
        if(view!=null){
            model.live(new CallBack() {
                @Override
                public void Success(Object data) {
                    if(view!=null){
                        view.liveReturn((LiveBean) data);
                    }
                }

                @Override
                public void Fail(String errorMsg) {
                    if (view!=null){
                        view.show(errorMsg);
                    }

                }
            },map);
        }
    }

    @Override
    public void beginLive(String name,int roomid) {
        if(view!=null){
            model.beginLive(new CallBack() {
                @Override
                public void Success(Object data) {
                    view.beginLiveReturn((BeginLiveBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    view.show(errorMsg);
                    Log.i("TAG", "Fail: "+errorMsg);
                }
            },name,roomid);
        }

    }

    @Override
    public void getGainReturn() {
        if(view!=null){
            model.getGainReturn(new CallBack() {
                @Override
                public void Success(Object data) {
                    if(view!=null){
                        view.getGainReturn((GainBean) data);
                    }
                }

                @Override
                public void Fail(String errorMsg) {

                }
            });
        }

    }

    @Override
    public void MyRoomReturn() {
        if(view!=null){
            model.MyRoomReturn(new CallBack() {
                @Override
                public void Success(Object data) {
                    if(view!=null){
                        view.MyRoomReturn((MyRoomBean) data);
                    }
                }

                @Override
                public void Fail(String errorMsg) {

                }
            });
        }

    }

    @Override
    public void RoomLiveUrlReturn(Map<String,String> map) {
        if(view!=null){
            model.RoomLiveUrlReturn(new CallBack() {
                @Override
                public void Success(Object data) {
                    if(view!=null){
                        view.RoomLiveUrlReturn((RoomLiveUrlBean) data);
                    }
                }

                @Override
                public void Fail(String errorMsg) {

                }
            },map);
        }

    }
}

