package com.example.item.presenter;

import com.example.item.base.BasePresenter;
import com.example.item.bean.LogoutBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.ILogout;
import com.example.item.model.LogoutModel;

public class Logoutpresenter extends BasePresenter<ILogout.View> implements ILogout.Presenter {
   ILogout.View view;
   ILogout.Model model;

    public Logoutpresenter(ILogout.View view) {
        this.view = view;
        model=new LogoutModel();
    }

    @Override
    public void Logout() {
        if(view!=null){
            model.logout(new CallBack() {
                @Override
                public void Success(Object data) {
                    view.LogoutReturn((LogoutBean) data);
                }

                @Override
                public void Fail(String errorMsg) {

                }
            });
        }


    }
}

