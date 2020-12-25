package com.example.item.ui.home.adapter;

import android.content.Context;

import com.example.item.R;
import com.example.item.base.BaseAdapter;

import java.util.List;

public class AttributeAdapter extends BaseAdapter {
    public AttributeAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.attribute;
    }

    @Override
    protected void bindData(Object data, VH vh) {


    }
}

