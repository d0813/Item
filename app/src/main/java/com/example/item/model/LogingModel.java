package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.login.CarBean;
import com.example.item.bean.login.LoginBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.ILoging;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

public class LogingModel extends BaseModel implements ILoging.Model {
    @Override
    public void login(CallBack callback, String username, String pw) {
        addDisposible(HttpManager.getInstance().getLoginApi().login(username,pw)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<LoginBean>(callback) {

            @Override
            public void onNext(LoginBean loginBean) {
                callback.Success(loginBean);

            }
        }));
    }


}

