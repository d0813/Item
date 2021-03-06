package com.example.item.ui.dashboard.comment;

import android.content.Context;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;

import java.util.List;

public class DiscussAdapter extends BaseAdapter {

    public DiscussAdapter(Context context, List Data) {
        super(context, Data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_discuss_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String path = (String) data;
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        Glide.with(context).load(path).into(img_pic);
    }
}
