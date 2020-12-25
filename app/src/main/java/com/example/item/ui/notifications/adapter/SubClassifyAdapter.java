package com.example.item.ui.notifications.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.ClassifyBean;

import java.util.List;

public class SubClassifyAdapter extends BaseAdapter {
    public SubClassifyAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.subclassifyadapter_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView subimg = (ImageView) vh.getViewById(R.id.sub_img);
        TextView subtitle = (TextView) vh.getViewById(R.id.sub_title);
        ClassifyBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean= (ClassifyBean.DataBean.CurrentCategoryBean.SubCategoryListBean) data;
        Glide.with(context).load(subCategoryListBean.getWap_banner_url()).into(subimg);
        subtitle.setText(subCategoryListBean.getName());
    }
}

