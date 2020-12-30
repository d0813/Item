package com.example.item.ui.shopping;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.login.CarBean;

import java.util.List;

public class PayAdapter extends BaseAdapter {
    public PayAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.address_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CarBean.DataBean.CartListBean cartListBean = (CarBean.DataBean.CartListBean) data;
        ImageView img = (ImageView) vh.getViewById(R.id.iv_address_item_img);
        TextView Name = (TextView) vh.getViewById(R.id.tv_address_item_name);
        TextView Price = (TextView) vh.getViewById(R.id.tv_address_item_price);
        TextView Number = (TextView) vh.getViewById(R.id.tv_address_item_count);
        Glide.with(context).load(cartListBean.getList_pic_url()).into(img);
        Price.setText("￥"+cartListBean.getRetail_price());
        Name.setText(cartListBean.getGoods_name());
        Number.setText(String.valueOf(cartListBean.getNumber()));

    }

}

