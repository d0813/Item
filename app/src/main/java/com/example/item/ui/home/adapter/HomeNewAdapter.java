package com.example.item.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.HomeNewBean;
import com.example.item.bean.HomeNewPriceBean;

import java.util.List;

public class HomeNewAdapter extends BaseAdapter {

    public HomeNewAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_new_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView newimg = (ImageView) vh.getViewById(R.id.new_img);
        TextView newtext = (TextView) vh.getViewById(R.id.new_text);
        TextView newprice = (TextView) vh.getViewById(R.id.new_price);
       HomeNewPriceBean.DataBeanX.DataBean dataBean= (HomeNewPriceBean.DataBeanX.DataBean) data;
        Glide.with(context).load(dataBean.getList_pic_url()).into(newimg);
        newtext.setText(dataBean.getName());
        newprice.setText("¥"+dataBean.getRetail_price());

    }
}

