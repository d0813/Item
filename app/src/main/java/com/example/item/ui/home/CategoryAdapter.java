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

public class CategoryAdapter extends BaseAdapter {
    public CategoryAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.category_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView categoryimg = (ImageView) vh.getViewById(R.id.category_img);
        TextView categorytetx = (TextView) vh.getViewById(R.id.category_text);
        TextView categoryprice = (TextView) vh.getViewById(R.id.category_price);

        HomeBean.DataBean.CategoryListBean.GoodsListBean categoryListBean
                = (HomeBean.DataBean.CategoryListBean.GoodsListBean) data;
        Glide.with(context).load(categoryListBean.getList_pic_url()).into(categoryimg);
        categorytetx.setText(categoryListBean.getName());
        categoryprice.setText("¥"+categoryListBean.getRetail_price());


    }
}

