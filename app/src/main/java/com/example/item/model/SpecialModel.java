package com.example.item.model;

import android.util.Log;

import com.example.item.base.BaseModel;
import com.example.item.bean.SpecialBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.ISpecial;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

public class SpecialModel extends BaseModel implements ISpecial.Model {
    @Override
    public void getSpecial(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getSpecialApi().getSpecial()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<SpecialBean>(callBack) {

            @Override
            public void onNext(SpecialBean specialBean) {
                callBack.Success(specialBean);

            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                Log.i("TAG", "onError: "+t.getMessage());
            }
        }));
    }
}

