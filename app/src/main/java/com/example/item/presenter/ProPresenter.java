package com.example.item.presenter;

import android.view.Display;
import android.view.MotionEvent;

import com.example.item.base.BasePresenter;
import com.example.item.bean.UserInfoBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IPro;
import com.example.item.model.ProModel;

import java.util.Map;

public class ProPresenter extends BasePresenter<IPro.View> implements IPro.Presenter  {
    IPro.Model model;
    public ProPresenter(){
        model=new ProModel();
    }
    @Override
    public void Preson(Map<String, String> map) {
        if(mView!=null){
            model.Preson(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.PresonReturn((UserInfoBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },map);
        }

    }
}

