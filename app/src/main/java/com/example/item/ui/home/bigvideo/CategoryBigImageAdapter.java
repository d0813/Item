package com.example.item.ui.home.bigvideo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.utils.ImageLoader;

import java.util.List;

public class CategoryBigImageAdapter extends BaseAdapter {
    public CategoryBigImageAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_category_bigimage_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String str= (String) data;
        ImageView img= (ImageView) vh.getViewById(R.id.iv_bigimage_img);
        Glide.with(context).load(str).into(img);
    }

}
