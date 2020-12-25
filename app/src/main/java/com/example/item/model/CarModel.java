package com.example.item.model;


import android.util.Log;

import com.example.item.base.BaseModel;
import com.example.item.bean.DeleteCarBean;
import com.example.item.bean.UpdateCarBean;
import com.example.item.bean.login.CarBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.ICar;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import java.util.Map;


import retrofit2.http.HTTP;

public class CarModel extends BaseModel implements ICar.Model {


    @Override
    public void getCarList(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getLoginApi().getCarList().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<CarBean>(callBack) {
                    @Override
                    public void onNext(CarBean carBean) {
                        callBack.Success(carBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        Log.i("TAG", "onError: "+t.getMessage());
                    }
                }));
    }
    /**
     * 更新购物车
     * @param map
     * @param callback
     */
    @Override
    public void updateCar(CallBack callback, Map<String, String> map) {
        addDisposible(HttpManager.getInstance().getLoginApi().updateCar(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UpdateCarBean>(callback) {

                    @Override
                    public void onNext(UpdateCarBean updateCarBean) {
                        callback.Success(updateCarBean);

                    }
                }));
    }
//删除购物车
    @Override
    public void deleteCar(CallBack callBack, String pIds) {
        addDisposible(HttpManager.getInstance().getLoginApi().deleteCar(pIds)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<DeleteCarBean>(callBack) {

            @Override
            public void onNext(DeleteCarBean deleteCarBean) {
                callBack.Success(deleteCarBean);

            }

        }));


    }







}
