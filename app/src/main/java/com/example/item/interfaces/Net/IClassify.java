package com.example.item.interfaces.Net;

import com.example.item.base.BaseModel;
import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

public interface IClassify {

    interface View extends IBaseView{
        void getClassifyReturn(ClassifyBean classifyBean);
        void getClassifyTitleReturn(ClassifyTitleBean classifyTitleBean);
        void getClassifyListReturn(ClassifyVerticalBean classifyVerticalBeanBean);
        void getclassdetailReturn(ClassifyDetailbean classifyDetailbean);

    }

    interface Model extends IBaseModel {
        void getClassifyReturn(CallBack callBack,int id);
        void getClassifyTitleReturn(CallBack callBack,int id);
        void getClassifyListReturn(CallBack callBack);
        void  getclassdetail(CallBack callBack,int categoryId,int id,int size);

    }

    interface Presenter extends IBasePresenter<View>{
        void getClassifyReturn(int id);
        void getClassifyTitleReturn(int id);
        void getClassifyListReturn();
        void getclassdetail(int categoryId,int id,int size);
    }
}

