package com.example.item.interfaces.Net;


import com.example.item.bean.RegisterBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

import java.util.HashMap;

public interface IRegister {
    interface View extends IBaseView {
        void RegisterReturn(RegisterBean registerBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void Register(HashMap<String, String> map);
    }


    interface Model extends IBaseModel {
        void RegisterList(HashMap<String, String> map, CallBack callback);
    }
}
