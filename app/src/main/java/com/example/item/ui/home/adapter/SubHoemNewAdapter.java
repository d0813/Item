package com.example.item.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.HomeNewPriceBean;

import java.util.List;

public class SubHoemNewAdapter extends BaseAdapter {
    public SubHoemNewAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.sub_new_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView textitem = (TextView) vh.getViewById(R.id.text_item);
        HomeNewPriceBean.DataBeanX.FilterCategoryBean dataBean= (HomeNewPriceBean.DataBeanX.FilterCategoryBean) data;
        textitem.setText(dataBean.getName());


    }
}

