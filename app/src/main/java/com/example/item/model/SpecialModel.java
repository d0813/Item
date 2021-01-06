package com.example.item.model;

import android.util.Log;

import com.example.item.base.BaseModel;
import com.example.item.bean.SpCommentBean;
import com.example.item.bean.SpDetailsBean;
import com.example.item.bean.SpecialBean;
import com.example.item.bean.SpecialDetailsButtomBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.ISpecial;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import java.util.HashMap;

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

    //专题详情
    @Override
    public void getgSpDetails(CallBack callBack, int id) {
        addDisposible(HttpManager.getInstance().getSpecialApi().getSpDetails(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<SpDetailsBean>(callBack) {
            @Override
            public void onNext(SpDetailsBean spDetailsBean) {
                callBack.Success(spDetailsBean);
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                Log.i("TAG", "onError: "+t.getMessage());
            }
        }));
    }

    @Override
    public void getSpComment(CallBack callBack, HashMap<String, String> map) {
        addDisposible(HttpManager.getInstance().getSpecialApi().getSpComment(map)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<SpCommentBean>(callBack) {
            @Override
            public void onNext(SpCommentBean spCommentBean) {
        callBack.Success(spCommentBean);
            }
            @Override
            public void onError(Throwable t) {
                super.onError(t);
                Log.i("TAG", "onError: "+t.getMessage());
            }
        }));

    }

    @Override
    public void getSpDetailsButtom(CallBack callBack, int id) {
        addDisposible(HttpManager.getInstance().getSpecialApi().getSpDetailsButtom(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<SpecialDetailsButtomBean>(callBack) {
            /**
             * Data notification sent by the {@link Publisher} in response to requests to {@link Subscription#request(long)}.
             *
             * @param specialDetailsButtomBean the element signaled
             */
            @Override
            public void onNext(SpecialDetailsButtomBean specialDetailsButtomBean) {
                callBack.Success(specialDetailsButtomBean);
            }
        }));
    }
}

