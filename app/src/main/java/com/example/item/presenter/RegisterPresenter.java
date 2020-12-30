package com.example.item.presenter;

import com.example.item.base.BasePresenter;
import com.example.item.bean.RegisterBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IRegister;
import com.example.item.interfaces.Net.IRegister.Presenter;
import com.example.item.model.RegiserModel;
import com.example.item.ui.login.RegisterActivity;

import java.util.HashMap;

public class RegisterPresenter extends BasePresenter<IRegister.View> implements Presenter {

    IRegister.Model model;

    public RegisterPresenter(RegisterActivity registerActivity) {
        model = new RegiserModel();
    }

    @Override
    public void Register(HashMap<String, String> map) {
        if(mView!=null){
            model.RegisterList(map, new CallBack() {
                @Override
                public void Success(Object data) {
                    if(mView!=null){
                        mView.RegisterReturn((RegisterBean) data);
                    }
                }

                @Override
                public void Fail(String errorMsg) {

                }
            });
        }

    }
}

