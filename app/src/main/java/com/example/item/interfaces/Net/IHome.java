package com.example.item.interfaces.Net;

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
import com.example.item.interfaces.IBaseModel;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.interfaces.IBaseView;

import java.util.HashMap;
import java.util.Map;

public interface IHome {
    interface View extends IBaseView {
        void getHomeReturn(HomeBean homeBean);

        void getDetailReturn(DetailBean detailBean);

        void getInfor(InformationBean informationBean);

        void getHomeDetail(HomeDetailBean homeDetailBean);

        void getHomeNew(HomeNewBean homeNewBean);

        void getSubdetailHead(SubDetailHeadBean subDetailHeadBean);

        void getsubDetail(SubHomeDetailBean subHomeDetailBean);

        void gethomenewprice(HomeNewPriceBean homeNewPriceBean);

    }

    interface Presenter extends IBasePresenter<IHome.View> {
        void getHome();

        void getDetail(int id);

        void getInfor(int categoryId, int page, int size);

        void getHomeDetail();

        void getHomeNew();

        void getSubdetailHead(int id);

        void getsubDetail(int brandId, int page, int size);

        void gethomenewprice(HashMap<String,String> map);


    }

    interface Model extends IBaseModel {
        void getHome(CallBack callBack);

        void getDetail(CallBack callBack, int id);

        void getInfor(CallBack callBack, int categoryId, int page, int size);

        void getHomeDetail(CallBack callBack);

        void getHomeNew(CallBack callBack);

        void getSubdetailHead(CallBack callBack,int id);

        void getsubDetail(CallBack callBack,int brandId, int page, int size);

        void gethomenewprice(CallBack callBack,HashMap<String,String> map);
    }
}
