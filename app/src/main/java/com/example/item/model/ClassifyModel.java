package com.example.item.model;

import com.example.item.base.BaseModel;
import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IClassify;
import com.example.item.net.CommonSubscriber;
import com.example.item.net.HttpManager;
import com.example.item.utils.RxUtils;

public class ClassifyModel extends BaseModel implements IClassify.Model {
    @Override
    public void getClassifyReturn(CallBack callBack, int id) {
        addDisposible(HttpManager.getInstance().getClassifyApi().getclassify(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<ClassifyBean>(callBack) {

            @Override
            public void onNext(ClassifyBean classifyBean) {
                callBack.Success(classifyBean);

            }
        }));
    }

    @Override
    public void getClassifyTitleReturn(CallBack callBack, int id) {
        addDisposible(HttpManager.getInstance().getClassifyApi().getclassifytitle(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ClassifyTitleBean>(callBack) {

                    @Override
                    public void onNext(ClassifyTitleBean classifyTitleBean) {
                        callBack.Success(classifyTitleBean);

                    }
                }));
    }

    @Override
    public void getClassifyListReturn(CallBack callBack) {
        addDisposible(HttpManager.getInstance().getClassifyApi().getclassifylist()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<ClassifyVerticalBean>(callBack) {

            @Override
            public void onNext(ClassifyVerticalBean classifyVerticalBean) {
                callBack.Success(classifyVerticalBean);
            }
        }));

    }

    @Override
    public void getclassdetail(CallBack callBack, int categoryId, int id, int size) {
        addDisposible(HttpManager.getInstance().getClassifyApi().getclassdetail(categoryId,id,size)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<ClassifyDetailbean>(callBack) {
            @Override
            public void onNext(ClassifyDetailbean classifyDetailbean) {
                callBack.Success(classifyDetailbean);
            }
        }));
    }
}

