package com.example.item.model;

import android.util.Log;

import com.example.item.base.BaseModel;
import com.example.item.bean.DetailBean;
import com.example.item.bean.HomeBean;
import com.example.item.bean.HomeDetailBean;
import com.example.item.bean.HomeNewBean;
import com.example.item.bean.HomeNewPriceBean;
import com.example.item.bean.InformationBean;
import com.example.item.bean.NeteaseBean;
import com.example.item.bean.SubDetailHeadBean;
import com.example.item.bean.SubHomeDetailBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IHome;
import com.example.item.interfaces.Net.INetease;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

import java.util.HashMap;

public class HomeModel extends BaseModel implements IHome.Model {

    @Override
    public void getHome(CallBack callBack) {
       addDisposible(
               HttpManager.getInstance().getHomeApi().getHome()
       .compose(RxUtils.rxScheduler())
       .subscribeWith(new CommonSubscriber<HomeBean>(callBack) {

           @Override
           public void onNext(HomeBean homeBean) {
               callBack.Success(homeBean);

           }

           @Override
           public void onError(Throwable t) {
               super.onError(t);
               Log.i("TAG", "onError: 错误"+t.getMessage());
           }
       }));
    }

    @Override
    public void getDetail(CallBack callBack, int id) {
        addDisposible(HttpManager.getInstance().getHomeApi().getdetail(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<DetailBean>(callBack) {

            @Override
            public void onNext(DetailBean detailBean) {
                callBack.Success(detailBean);

            }
        }));
    }

    @Override
    public void getInfor(CallBack callBack, int categoryId, int page, int size) {
       addDisposible(HttpManager.getInstance().getHomeApi().getInformation(categoryId,page,size)
       .compose(RxUtils.rxScheduler())
       .subscribeWith(new CommonSubscriber<InformationBean>(callBack) {

           @Override
           public void onNext(InformationBean informationBean) {
               callBack.Success(informationBean);

           }

           @Override
           public void onError(Throwable t) {
               super.onError(t);
               Log.i("TAG", "onError: "+t.getMessage());
           }
       }));
    }

    @Override
    public void getHomeDetail(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getHomeApi().gethomedetail()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeDetailBean>(callBack) {

            @Override
            public void onNext(HomeDetailBean homeDetailBean) {
                callBack.Success(homeDetailBean);
            }
        }));
    }

    @Override
    public void getHomeNew(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getHomeApi().gethomenew()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeNewBean>(callBack) {

            @Override
            public void onNext(HomeNewBean homeNewBean) {
                callBack.Success(homeNewBean);

            }
        }));
    }

    @Override
    public void getSubdetailHead(CallBack callBack,int id) {
        addDisposible(HttpManager.getInstance().getHomeApi().getsubDetailhead(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<SubDetailHeadBean>(callBack) {

            @Override
            public void onNext(SubDetailHeadBean subDetailHeadBean) {
                callBack.Success(subDetailHeadBean);

            }
        }));
    }

    @Override
    public void getsubDetail(CallBack callBack,int brandId, int page, int size) {
        addDisposible(HttpManager.getInstance().getHomeApi().getsubHomeDetail(brandId,page,size)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<SubHomeDetailBean>(callBack) {
            @Override
            public void onNext(SubHomeDetailBean subHomeDetailBean) {
                callBack.Success(subHomeDetailBean);

            }
        }));

    }

    @Override
    public void gethomenewprice(CallBack callBack, HashMap<String, String> map) {
       addDisposible( HttpManager.getInstance().getHomeApi().gethomenewprice(map)
       .compose(RxUtils.rxScheduler())
       .subscribeWith(new CommonSubscriber<HomeNewPriceBean>(callBack) {
           @Override
           public void onNext(HomeNewPriceBean homeNewPriceBean) {
               callBack.Success(homeNewPriceBean);
           }
       }));
    }


}

