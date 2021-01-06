package com.example.item.ui.dashboard;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.SpecialDetailsButtomBean;
import com.example.item.utils.TxtUtils;

import java.util.List;

public class SpecialDetailsButtomAdapter extends BaseAdapter {

    public SpecialDetailsButtomAdapter(Context context, List Data) {
        super(context, Data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_special_details_buttom_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        SpecialDetailsButtomBean.DataBean bean = (SpecialDetailsButtomBean.DataBean) data;

        ImageView img = (ImageView) vh.getViewById(R.id.iv_special_details_buttom_item_img);
        TextView title = (TextView) vh.getViewById(R.id.tv_special_details_buttom_item_title);
        Glide.with(context).load(bean.getScene_pic_url()).into(img);
        TxtUtils.setTextView(title,bean.getTitle());
    }
}
