package com.example.item.ui.dashboard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;

import java.util.List;

public class SpecialDetailsAdapter extends BaseAdapter {
    public SpecialDetailsAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_special_details_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String str= (String) data;
        ImageView img = (ImageView) vh.getViewById(R.id.iv_special_details_item_img);
        Glide.with(context).load(str).into(img);
    }
}

