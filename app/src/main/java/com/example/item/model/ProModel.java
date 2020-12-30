package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.UserInfoBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IPro;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import java.util.Map;

public class ProModel extends BaseModel implements IPro.Model {
    @Override
    public void Preson(CallBack callback, Map<String, String> map) {
        addDisposible(HttpManager.getInstance().getLoginApi().updateUserInfo(map)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<UserInfoBean>(callback) {

            @Override
            public void onNext(UserInfoBean userInfoBean) {
                callback.Success(userInfoBean);
            }
        }));

    }
}

