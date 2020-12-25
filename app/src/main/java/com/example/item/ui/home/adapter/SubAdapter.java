package com.example.item.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.SubHomeDetailBean;

import java.util.List;

public class SubAdapter extends BaseAdapter {
    public SubAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.subadapter_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView subprice = (TextView) vh.getViewById(R.id.sub_price);
        TextView subtext = (TextView) vh.getViewById(R.id.sub_text);
        ImageView subimg = (ImageView) vh.getViewById(R.id.sub_img);
        SubHomeDetailBean.DataBeanX.GoodsListBean dataBean= (SubHomeDetailBean.DataBeanX.GoodsListBean) data;
        subtext.setText(dataBean.getName());
        subprice.setText(dataBean.getRetail_price());
        Glide.with(context).load(dataBean.getList_pic_url()).into(subimg);

    }
}

