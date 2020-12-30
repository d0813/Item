package com.example.item.presenter;


import com.example.item.base.BasePresenter;
import com.example.item.bean.AddressCityBean;
import com.example.item.interfaces.CallBack;
import com.example.item.interfaces.Net.IAddress;
import com.example.item.model.AddressCityModel;

public class AddressCityPresenter extends BasePresenter<IAddress.View> implements IAddress.Presenter {
    IAddress.Model model;
    IAddress.View view;

    public AddressCityPresenter(IAddress.View view) {
        this.view = view;
        model = new AddressCityModel();
    }

    @Override
    public void getAddressCity(int parentId) {
        if(view!=null){
            model.getAddressCity(parentId, new CallBack() {
                @Override
                public void Success(Object data) {
                    view.getAddressCityReturn((AddressCityBean) data);
                }

                @Override
                public void Fail(String errorMsg) {

                }
            });
        }

    }
}
