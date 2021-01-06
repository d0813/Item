package com.example.item.interfaces.Net;

import com.example.item.bean.LogoutBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

public interface ILogout {
    interface View extends IBaseView{
        void LogoutReturn(LogoutBean logoutBean);
    }

    interface Presenter extends IBasePresenter<View>{
        void Logout();
    }
    interface  Model extends IBaseModel{
        void logout(CallBack callBack);
    }
}
