package com.example.item.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.InformationBean;

import java.util.List;

public class InforAdapter extends BaseAdapter {
    public InforAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.infotadapter_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView infortext = (TextView) vh.getViewById(R.id.infor_text);
        TextView inforprice = (TextView) vh.getViewById(R.id.infor_price);
        ImageView inforimg = (ImageView) vh.getViewById(R.id.infor_img);
        InformationBean.DataBeanX.GoodsListBean goodsListBean= (InformationBean.DataBeanX.GoodsListBean) data;
        infortext.setText(goodsListBean.getName());
        inforprice.setText("¥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(inforimg);
    }
}

