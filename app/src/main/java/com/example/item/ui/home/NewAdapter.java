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

public class NewAdapter extends BaseAdapter {
    public NewAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.new_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView newimg = (ImageView) vh.getViewById(R.id.new_img);
        TextView newText = (TextView) vh.getViewById(R.id.new_text);
        TextView newPrice = (TextView) vh.getViewById(R.id.new_price);
        HomeBean.DataBean.NewGoodsListBean newGoodsListBean= (HomeBean.DataBean.NewGoodsListBean) data;
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(newimg);
        newText.setText(newGoodsListBean.getName());
        newPrice.setText("¥"+newGoodsListBean.getRetail_price());

    }
}

