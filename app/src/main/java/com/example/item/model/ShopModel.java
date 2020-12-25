package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.ShopBean;
import com.example.item.bean.ShopListBean;
import com.example.item.bean.login.AddCarBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IShop;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import java.util.Map;

import retrofit2.http.HTTP;

public class ShopModel extends BaseModel implements IShop.Model {
    @Override
    public void getShop(CallBack callBack, int id) {
        addDisposible(HttpManager.getInstance().getShopApi().getGoodDetail(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<ShopBean>(callBack) {

            @Override
            public void onNext(ShopBean shopBean) {
                callBack.Success(shopBean);

            }
        }));
    }

    @Override
    public void getShopList(CallBack callBack, int id) {
        addDisposible(HttpManager.getInstance().getShopApi().getShopLIst(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<ShopListBean>(callBack) {

            @Override
            public void onNext(ShopListBean shopListBean) {
                callBack.Success(shopListBean);
            }
        }));
    }
    @Override
    public void addGoodCar(CallBack callBack, Map<String, String> map) {
        addDisposible(HttpManager.getInstance().getLoginApi().addCar(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AddCarBean>(callBack) {

                    @Override
                    public void onNext(AddCarBean addCarBean) {
                        callBack.Success(addCarBean);
                    }
                }));
    }
}

