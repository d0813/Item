package com.example.item.interfaces.Net;

import com.example.item.bean.ShopBean;
import com.example.item.bean.ShopListBean;
import com.example.item.bean.login.AddCarBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

import java.util.Map;

public interface IShop {

    interface  View extends IBaseView{
        void  getShopReturn(ShopBean shopBean);
        void  getShopList(ShopListBean shopListBean);
        void addGoodCarReturn(AddCarBean addCarBean);
    }

    interface  Presenter extends IBasePresenter<View>{
        void  getShop(int id);
        void  getShopList(int id);
        //添加进购物车
        void addGoodCar(Map<String, String> map);
    }

    interface  Model extends IBaseModel{
        void getShop(CallBack callBack,int id);
        void getShopList(CallBack callBack,int id);
        //添加进购物车
        void addGoodCar(CallBack callBack,Map<String,String> map);
    }
}

