package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.AddressCityBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.Net.IAddress;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import io.reactivex.disposables.Disposable;


public class AddressCityModel extends BaseModel implements IAddress.Model {


    @Override
    public void getAddressCity(int parentId, CallBack callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getAddressCity(parentId)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<AddressCityBean>(callback) {

            @Override
            public void onNext(AddressCityBean addressCityBean) {
                callback.Success(addressCityBean);
            }
        }));
    }
}
