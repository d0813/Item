package com.example.item.presenter;

import android.util.Log;

import com.example.item.base.BasePresenter;
import com.example.item.bean.DetailBean;
import com.example.item.bean.HomeBean;
import com.example.item.bean.InformationBean;
import com.example.item.bean.SpCommentBean;
import com.example.item.bean.SpDetailsBean;
import com.example.item.bean.SpecialBean;
import com.example.item.bean.SpecialDetailsButtomBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IHome;
import com.example.item.interfaces.Net.IHome.Presenter;
import com.example.item.interfaces.Net.ISpecial;
import com.example.item.model.HomeModel;
import com.example.item.model.SpecialModel;

import java.util.HashMap;

public class SpecialPresenter extends BasePresenter<ISpecial.View> implements ISpecial.Presenter {
   ISpecial.View view;
    ISpecial.Model model;

    public SpecialPresenter(ISpecial.View view) {
        this.view=view;
        model = new SpecialModel();
    }


    @Override
    public void getSpecial() {
        if(mView!=null){
            model.getSpecial(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getSpecial((SpecialBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);
                }
            });
        }

    }

    @Override
    public void getgSpDetails(int id) {
        if(view!=null){
            model.getgSpDetails(new CallBack() {
                @Override
                public void Success(Object data) {
                    view.getgSpDetails((SpDetailsBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    view.show(errorMsg);
                    Log.i("TAG", "Fail: "+errorMsg);

                }
            },id);
        }
    }

    @Override
    public void getSpComment(HashMap<String, String> map) {
        if(view!=null){
            model.getSpComment(new CallBack() {
                @Override
                public void Success(Object data) {
                    view.getSpComment((SpCommentBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    view.show(errorMsg);

                }
            },map);
        }

    }

    @Override
    public void getSpDetailsButtom(int id) {
        if(view!=null){
            model.getSpDetailsButtom(new CallBack() {
                @Override
                public void Success(Object data) {
                    view.getSpDetailsButtom((SpecialDetailsButtomBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    view.show(errorMsg);

                }
            },id);
        }
    }
}

