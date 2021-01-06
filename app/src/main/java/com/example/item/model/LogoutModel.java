package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.LogoutBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.ILogout;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

public class LogoutModel extends BaseModel implements ILogout.Model {
    @Override
    public void logout(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getLoginApi().postlogout()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<LogoutBean>(callBack) {
            /**
             * Data notification sent by the {@link Publisher} in response to requests to {@link Subscription#request(long)}.
             *
             * @param logoutBean the element signaled
             */
            @Override
            public void onNext(LogoutBean logoutBean) {
                callBack.Success(logoutBean);
            }
        }));

    }
}

