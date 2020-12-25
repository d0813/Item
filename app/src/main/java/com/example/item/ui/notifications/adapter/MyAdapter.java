package com.example.item.ui.notifications.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.ClassifyDetailbean;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    public MyAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.my_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView myimg = (ImageView) vh.getViewById(R.id.my_img);
        TextView myText = (TextView) vh.getViewById(R.id.my_text);
        TextView myPrice = (TextView) vh.getViewById(R.id.my_price);
        ClassifyDetailbean.DataBeanX.GoodsListBean goodsListBean= (ClassifyDetailbean.DataBeanX.GoodsListBean) data;
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(myimg);
        myText.setText(goodsListBean.getName());
        myPrice.setText(goodsListBean.getRetail_price());

    }
}

