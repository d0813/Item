package com.example.item.presenter;

import com.example.item.base.BasePresenter;
import com.example.item.bean.NeteaseBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.INetease;
import com.example.item.model.NeteaseModel;

public class NeteasePresenter extends BasePresenter<INetease.View> implements INetease.Presenter {
    INetease.Model model;

    public NeteasePresenter() {
        model = new NeteaseModel();

    }

    @Override
    public void getNetease() {
        if (mView != null) {
            model.getNetease(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getNeteaseReturn((NeteaseBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);
                }
            });
        }

    }
}

