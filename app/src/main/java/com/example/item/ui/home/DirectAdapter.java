package com.example.item.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.HomeBean;

import java.util.List;

public class DirectAdapter extends BaseAdapter {

    public DirectAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.direct_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.BrandListBean brandListBean= (HomeBean.DataBean.BrandListBean) data;
        ImageView directimg = (ImageView) vh.getViewById(R.id.direct_img);
        TextView directtext = (TextView) vh.getViewById(R.id.direct_text);
        TextView directprice = (TextView) vh.getViewById(R.id.direct_price);
        Glide.with(context).load(brandListBean.getNew_pic_url()).into(directimg);
        directtext.setText(brandListBean.getName());
        directprice.setText(brandListBean.getFloor_price()+"元起");

    }
}

