package com.example.item.interfaces.Net;

import com.example.item.bean.UserInfoBean;
import com.example.item.bean.login.LoginBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

import java.util.Map;

public interface IPro {
    interface View extends IBaseView {
        void PresonReturn(UserInfoBean userInfoBean);
    }

    interface Presenter extends IBasePresenter<IPro.View> {
        void Preson(Map<String,String> map);
    }


    interface Model extends IBaseModel {
        void Preson(CallBack callback,Map<String,String> map);

    }
}

