package com.example.item.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.HomeDetailBean;

import java.util.List;

import retrofit2.http.GET;

public class HomeDetailAdapter extends BaseAdapter {
    public HomeDetailAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.homedetailadapter_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView hdimg = (ImageView) vh.getViewById(R.id.hd_img);
        TextView hdtitle = (TextView) vh.getViewById(R.id.hd_title);
        TextView hdprice = (TextView) vh.getViewById(R.id.hd_price);
        HomeDetailBean.DataBeanX.DataBean dataBean= (HomeDetailBean.DataBeanX.DataBean) data;
        Glide.with(context).load(dataBean.getApp_list_pic_url()).into(hdimg);
        hdtitle.setText(dataBean.getName());
        hdprice.setText(dataBean.getFloor_price());

    }
}

