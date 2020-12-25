package com.example.item.presenter;

import com.example.item.base.BasePresenter;
import com.example.item.bean.DetailBean;
import com.example.item.bean.HomeBean;
import com.example.item.bean.InformationBean;
import com.example.item.bean.SpecialBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IHome;
import com.example.item.interfaces.Net.IHome.Presenter;
import com.example.item.interfaces.Net.ISpecial;
import com.example.item.model.HomeModel;
import com.example.item.model.SpecialModel;

public class SpecialPresenter extends BasePresenter<ISpecial.View> implements ISpecial.Presenter {
    ISpecial.Model model;

    public SpecialPresenter() {
        model = new SpecialModel();
    }


    @Override
    public void getSpecial() {
        if(mView!=null){
            model.getSpecial(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getSpecial((SpecialBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);
                }
            });
        }

    }
}

