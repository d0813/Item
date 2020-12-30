package com.example.item.interfaces.Net;

import com.example.item.bean.UserInfoBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

import java.util.HashMap;

public interface IUser {

    interface Model extends IBaseModel{
        void User(CallBack callBack, HashMap<String,String> map);
    }
    interface View extends IBaseView{
        void User(UserInfoBean userInfoBean);
    }
    interface  presenter extends IBasePresenter<IUser.View>{
        void user(HashMap<String,String> map);
    }

}
