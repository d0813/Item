package com.example.item.presenter;

import com.example.item.base.BasePresenter;
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
import com.example.item.interfaces.Net.IHome.Presenter;
import com.example.item.interfaces.Net.INetease;
import com.example.item.model.HomeModel;
import com.example.item.model.NeteaseModel;

import java.util.HashMap;

public class HomePresenter extends BasePresenter<IHome.View> implements IHome.Presenter {
    IHome.Model model;

    public HomePresenter() {
        model = new HomeModel();
    }

    @Override
    public void getHome() {
        if (mView != null) {
            model.getHome(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getHomeReturn((HomeBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);
                }
            });
        }


    }

    @Override
    public void getDetail(int id) {
        if(mView!=null){
           model.getDetail(new CallBack() {
               @Override
               public void Success(Object data) {
                  mView.getDetailReturn((DetailBean) data);

               }

               @Override
               public void Fail(String errorMsg) {
                   mView.show(errorMsg);

               }
           },id);
        }
    }

    @Override
    public void getInfor(int categoryId, int page, int size) {
        if (mView!=null){
            model.getInfor(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getInfor((InformationBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },categoryId,page,size);
        }
    }

    @Override
    public void getHomeDetail() {
        if(mView!=null){
            model.getHomeDetail(new CallBack() {
                @Override
                public void Success(Object data) {
                   mView.getHomeDetail((HomeDetailBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            });
        }
    }

    @Override
    public void getHomeNew() {
        if(mView!=null){
            model.getHomeNew(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getHomeNew((HomeNewBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            });
        }
    }

    @Override
    public void getSubdetailHead(int id) {
        if(mView!=null){
            model.getSubdetailHead(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.getSubdetailHead((SubDetailHeadBean) data);
                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },id);
        }
    }

    @Override
    public void getsubDetail(int brandId, int page, int size) {
        if(mView!=null){
            model.getsubDetail(new CallBack() {
                @Override
                public void Success(Object data) {
                    if(mView!=null){
                        mView.getsubDetail((SubHomeDetailBean) data);
                    }

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },brandId,page,size);
        }

    }

    @Override
    public void gethomenewprice(HashMap<String, String> map) {
        if(mView!=null){
            model.gethomenewprice(new CallBack() {
                @Override
                public void Success(Object data) {
                    mView.gethomenewprice((HomeNewPriceBean) data);

                }

                @Override
                public void Fail(String errorMsg) {
                    mView.show(errorMsg);

                }
            },map);
        }
    }


}

