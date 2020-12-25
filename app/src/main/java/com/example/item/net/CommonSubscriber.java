package com.example.item.net;

import android.text.TextUtils;
import android.util.Log;


import com.example.item.interfaces.CallBack;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CommonSubscriber<T>  extends ResourceSubscriber<T> {

    private CallBack callBack;
    private String errorMsg;

    private boolean isShowErrorState=false;

    protected CommonSubscriber(CallBack callBack){
        this.callBack=callBack;
    }
    protected CommonSubscriber(CallBack callBack, String msg){
        this.callBack=callBack;
        errorMsg=msg;
    }


    @Override
    public void onError(Throwable t) {
        Log.i("TAG", "CommonSubscriber onError: "+t.getMessage());
        if(callBack==null)return;
        if(errorMsg!=null && TextUtils.isEmpty(errorMsg)){
            callBack.Fail(errorMsg);
        }

    }


    @Override
    public void onComplete() {

    }
}

