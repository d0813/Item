package com.example.item.base;

import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
   WeakReference<V> weakReference;
   protected  V mView;

    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<>(view);
        mView=weakReference.get();

    }

    @Override
    public void unAttachView() {
        weakReference.clear();
        mView=null;

    }
}

