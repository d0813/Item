package com.live.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.live.R;

import com.live.base.BaseAdapter;
import com.live.bean.GainBean;
import com.live.interfaces.live.ILive;

import java.util.List;

public class GainAdapter extends BaseAdapter {

    public GainAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_room_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        GainBean.DataBean dataBean= (GainBean.DataBean) data;
        ImageView gainimg = (ImageView) vh.getViewById(R.id.iv_room_img);
        Glide.with(context).load(dataBean.getIcon()).into(gainimg);
        TextView gaintitle = (TextView) vh.getViewById(R.id.tv_room_title);
        gaintitle.setText(dataBean.getName());

    }


}

