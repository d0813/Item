package com.example.item.interfaces.Net;

import com.example.item.bean.DetailBean;
import com.example.item.bean.HomeBean;
import com.example.item.bean.InformationBean;
import com.example.item.bean.SpecialBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

public interface ISpecial {
    interface View extends IBaseView {
       void getSpecial(SpecialBean specialBean);

    }

    interface Presenter extends IBasePresenter<ISpecial.View> {
       void getSpecial();

    }

    interface Model extends IBaseModel {
        void getSpecial(CallBack callBack);

    }

}
