package com.example.item.interfaces.Net;

import com.example.item.bean.DetailBean;
import com.example.item.bean.HomeBean;
import com.example.item.bean.InformationBean;
import com.example.item.bean.SpCommentBean;
import com.example.item.bean.SpDetailsBean;
import com.example.item.bean.SpecialBean;
import com.example.item.bean.SpecialDetailsButtomBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

import java.util.HashMap;

import retrofit2.http.Query;

public interface ISpecial {
    interface View extends IBaseView {
        //专题
        void getSpecial(SpecialBean specialBean);

        //专题详情
        void getgSpDetails(SpDetailsBean spDetailsBean);

        //专题详情评论
        void getSpComment(SpCommentBean spCommentBean);

        //专题底部数据
        void getSpDetailsButtom(SpecialDetailsButtomBean specialDetailsButtomBean);

    }

    interface Presenter extends IBasePresenter<ISpecial.View> {
        void getSpecial();

        void getgSpDetails(int id);

        void getSpComment(HashMap<String, String> map);
        //专题底部数据
        void getSpDetailsButtom(int id);


    }

    interface Model extends IBaseModel {
        void getSpecial(CallBack callBack);

        void getgSpDetails(CallBack callBack, int id);

        void getSpComment(CallBack callBack, HashMap<String, String> map);
        //专题底部数据
        void getSpDetailsButtom(CallBack callBack, int id);

    }

}
