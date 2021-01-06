package com.live.interfaces;


import com.live.bean.LoginBean;

public interface ILoging {
    interface View extends IBaseView {
        void loginReturn(LoginBean loginBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void login(String username, String pw);
    }


    interface Model extends IBaseModel {
        void login(CallBack callback, String username, String pw);

    }
}
