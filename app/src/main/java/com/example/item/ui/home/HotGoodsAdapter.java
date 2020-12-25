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

public class HotGoodsAdapter extends BaseAdapter {
    public HotGoodsAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.hotgoods_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView hotimg = (ImageView) vh.getViewById(R.id.iv_hotgoods_img);
        TextView hotname = (TextView) vh.getViewById(R.id.tv_hotgoods_name);
        TextView hotintroduce = (TextView) vh.getViewById(R.id.tv_hotgoods_introduce);
        TextView hotprice = (TextView) vh.getViewById(R.id.tv_hotgoods_price);

        HomeBean.DataBean.HotGoodsListBean hotGoodsListBean= (HomeBean.DataBean.HotGoodsListBean) data;

        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(hotimg);
        hotname.setText(hotGoodsListBean.getName());
        hotintroduce.setText(hotGoodsListBean.getGoods_brief());
        hotprice.setText("¥"+hotGoodsListBean.getRetail_price());
    }
}

