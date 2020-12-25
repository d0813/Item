package com.example.item.presenter;

import com.example.item.base.BasePresenter;
import com.example.item.bean.login.CarBean;
import com.example.item.bean.login.LoginBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.ILoging;
import com.example.item.model.LogingModel;

public class LoginPresenter extends BasePresenter<ILoging.View> implements ILoging.Presenter {
    ILoging.Model model;

    public LoginPresenter() {
        model = new LogingModel();
    }

    @Override
    public void login(String username, String pw) {
        model.login(new CallBack() {
            @Override
            public void Success(Object data) {
                if (mView != null) {
                    mView.loginReturn((LoginBean) data);
                }
            }

            @Override
            public void Fail(String errorMsg) {

            }
        }, username, pw);
    }


}

