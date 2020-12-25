package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.NeteaseBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.INetease;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import io.reactivex.disposables.Disposable;

public class NeteaseModel extends BaseModel implements INetease.Model {
    @Override
    public void getNetease(final CallBack callBack) {
        addDisposible(HttpManager.getInstance().getServicerApi().getNetease()
        .compose(RxUtils.<NeteaseBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<NeteaseBean>(callBack) {
            @Override
            public void onNext(NeteaseBean neteaseBean) {
                callBack.Success(neteaseBean);
            }
        }));
    }
}

