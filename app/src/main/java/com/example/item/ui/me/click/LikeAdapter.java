package com.example.item.ui.me.click;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;

import java.util.List;

public class LikeAdapter extends BaseAdapter<LikeBean> {
    public LikeAdapter(Context context, List<LikeBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.like_item;
    }

    @Override
    protected void bindData(LikeBean data, VH vh) {
        ImageView img_collect = (ImageView) vh.getViewById(R.id.img_collect);
        TextView txt_desc = (TextView) vh.getViewById(R.id.txt_desc);
        TextView txt_title = (TextView) vh.getViewById(R.id.txt_title);
        TextView txt_price = (TextView) vh.getViewById(R.id.txt_price);
        Glide.with(context).load(data.getImgPath()).into(img_collect);
        txt_desc.setText(data.getDesc());
        txt_price.setText("￥"+data.getPrice());
        txt_title.setText(data.getTitle());
    }
}

