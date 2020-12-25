package com.example.item.interfaces;


import com.example.item.bean.DeleteCarBean;
import com.example.item.bean.UpdateCarBean;
import com.example.item.bean.login.CarBean;

import java.util.Map;



public interface ICar {
    interface View extends IBaseView {
        void getCarListReturn(CarBean carBean);
        //更新 购物车
        void updateCarReturn(UpdateCarBean result);

        //删除购物车
        void deleteCarReturn(DeleteCarBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void getCarList();

        //更新购物车的数据
        void  updateCar(Map<String,String> map);

        //删除购物车列表
        void deleteCar(String pIds);
    }


    interface Model extends IBaseModel {
        void getCarList(CallBack callBack);
        void updateCar(CallBack callback,Map<String,String> map);

        void deleteCar(CallBack callBack,String pIds);
    }

}
