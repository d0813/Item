package com.example.item.interfaces.Net;

import com.example.item.bean.NeteaseBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

public interface INetease {

    interface View extends IBaseView {
        void getNeteaseReturn(NeteaseBean neteaseBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getNetease();
    }

    interface Model extends IBaseModel {
        void getNetease(CallBack callBack);
    }
}
