package com.example.item.presenter;

import com.example.item.base.BasePresenter;
import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IClassify;
import com.example.item.model.ClassifyModel;

public class ClassifyPresenter extends BasePresenter<IClassify.View> implements IClassify.Presenter {
    IClassify.Model model;

    public ClassifyPresenter() {
        model=new ClassifyModel();
    }

    @Override
    public void getClassifyReturn(int id) {
        if(mView!=null){
            model.getClassifyReturn(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getClassifyReturn((ClassifyBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },id);
        }

    }

    @Override
    public void getClassifyTitleReturn(int id) {
        if(mView!=null){
            model.getClassifyTitleReturn(new CallBack() {
                @Override
                public void Success(Object data) {
                   mView.getClassifyTitleReturn((ClassifyTitleBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },id);
        }


    }

    @Override
    public void getClassifyListReturn() {
        if(mView!=null){
            model.getClassifyListReturn(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getClassifyListReturn((ClassifyVerticalBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            });
        }

    }

    @Override
    public void getclassdetail(int categoryId, int id, int size) {
        if(mView!=null){
            model.getclassdetail(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getclassdetailReturn((ClassifyDetailbean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },categoryId,id,size);
        }
    }
}

