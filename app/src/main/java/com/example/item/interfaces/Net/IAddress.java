package com.example.item.interfaces.Net;

import com.example.item.bean.AddressCityBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;
public interface IAddress {
    //Address业务下的View
    interface View extends IBaseView {
        void getAddressCityReturn(AddressCityBean addressCityBean);
    }
    //Address业务下的Presenter
    interface Presenter extends IBasePresenter<IAddress.View> {
        void getAddressCity(int parentId);
    }

    //Address业务下的Model
    interface Model extends IBaseModel {
        void getAddressCity(int parentId, CallBack callback);
    }
}
