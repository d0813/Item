package com.example.item.interfaces.Net;

import com.example.item.bean.login.CarBean;
import com.example.item.bean.login.LoginBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

public interface ILoging {
    interface View extends IBaseView {
        void loginReturn(LoginBean loginBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void login(String username,String pw);
    }


    interface Model extends IBaseModel {
        void login(CallBack callback,String username, String pw);

    }
}
