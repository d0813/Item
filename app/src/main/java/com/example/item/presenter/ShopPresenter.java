package com.example.item.presenter;

import com.example.item.base.BasePresenter;
import com.example.item.bean.ShopBean;
import com.example.item.bean.ShopListBean;
import com.example.item.bean.login.AddCarBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IShop;
import com.example.item.model.ShopModel;

import java.util.Map;

public class ShopPresenter extends BasePresenter<IShop.View> implements IShop.Presenter {

    IShop.Model model;

    public ShopPresenter() {
        model = new ShopModel();
    }

    @Override
    public void getShop(int id) {
        if(mView!=null){
            model.getShop(new CallBack() {
                @Override
                public void Success(Object data) {
                    if(mView!=null){

                        mView.getShopReturn((ShopBean) data);
                    }


                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },id);
        }

    }

    @Override
    public void getShopList(int id) {
        if(mView!=null){
            model.getShopList(new CallBack() {
                @Override
                public void Success(Object data) {
                    if(mView!=null){

                        mView.getShopList((ShopListBean) data);
                    }

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },id);
        }
    }
    @Override
    public void addGoodCar(Map<String, String> map) {
        model.addGoodCar(new CallBack() {
            @Override
            public void Success(Object data) {
                if(mView!=null){
                    mView.addGoodCarReturn((AddCarBean) data);
                }

            }

            @Override
            public void Fail(String errorMsg) {

            }
        },map);
    }
}

