package com.example.item.ui.dashboard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.SpecialBean;

import java.util.List;

public class SpecialAdapter extends BaseAdapter {
    public SpecialAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.ap_adapter_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView spimg = (ImageView) vh.getViewById(R.id.sp_img);
        TextView sptitle = (TextView) vh.getViewById(R.id.sp_title);
        TextView sptext = (TextView) vh.getViewById(R.id.sp_text);
        TextView spprice = (TextView) vh.getViewById(R.id.sp_price);
        SpecialBean.DataBeanX.DataBean dataBean= (SpecialBean.DataBeanX.DataBean) data;
        Glide.with(context).load(dataBean.getScene_pic_url()).into(spimg);
        sptitle.setText(dataBean.getTitle());
        sptext.setText(dataBean.getSubtitle());
        spprice.setText("¥"+dataBean.getPrice_info());

    }
}

