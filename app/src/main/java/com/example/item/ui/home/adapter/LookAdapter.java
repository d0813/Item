package com.example.item.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.ShopListBean;

import java.util.List;

public class LookAdapter extends BaseAdapter {
    public LookAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.look_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView img = (ImageView) vh.getViewById(R.id.img);
        TextView text = (TextView) vh.getViewById(R.id.text);
        TextView price = (TextView) vh.getViewById(R.id.price);
        ShopListBean.DataBean.GoodsListBean goodsListBean= (ShopListBean.DataBean.GoodsListBean) data;
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(img);
        text.setText(goodsListBean.getName());
        price.setText(goodsListBean.getRetail_price());

    }
}

