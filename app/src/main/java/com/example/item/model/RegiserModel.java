package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.RegisterBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IRegister;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import java.util.HashMap;

public class RegiserModel extends BaseModel implements IRegister.Model {
    @Override
    public void RegisterList(HashMap<String, String> map, CallBack callback) {
        addDisposible(HttpManager.getInstance().getLoginApi().register(map)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<RegisterBean>(callback) {
            /**
             * Data notification sent by the {@link Publisher} in response to requests to {@link Subscription#request(long)}.
             *
             * @param registerBean the element signaled
             */
            @Override
            public void onNext(RegisterBean registerBean) {
                callback.Success(registerBean);

            }
        }));
    }
}
