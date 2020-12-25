package com.example.item.presenter;


import com.example.item.base.BasePresenter;
import com.example.item.bean.DeleteCarBean;
import com.example.item.bean.UpdateCarBean;
import com.example.item.bean.login.CarBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.ICar;
import com.example.item.model.CarModel;

import java.util.Map;

public class CarPresenter extends BasePresenter<ICar.View> implements ICar.Presenter {

    ICar.Model model;
    public CarPresenter(){
        model = new CarModel();
    }
    @Override
    public void getCarList() {
        model.getCarList(new CallBack() {
            @Override
            public void Success(Object data) {
                if(mView != null){
                    mView.getCarListReturn((CarBean) data);
                }
            }

            @Override
            public void Fail(String errorMsg) {

            }
        });
    }

    @Override
    public void updateCar(Map<String, String> map) {
        if(mView!=null){
            model.updateCar(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.updateCarReturn((UpdateCarBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },map);

        }
    }

    @Override
    public void deleteCar(String pIds) {
        if(mView!=null){
            model.deleteCar(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.deleteCarReturn((DeleteCarBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },pIds);
        }

    }
}
