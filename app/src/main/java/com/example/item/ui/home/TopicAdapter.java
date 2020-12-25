package com.example.item.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.HomeBean;

import java.util.List;

public class TopicAdapter  extends BaseAdapter {
    public TopicAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.topic_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView topicimg = (ImageView) vh.getViewById(R.id.iv_topic_img);
        TextView topicname = (TextView) vh.getViewById(R.id.topic_name);
        TextView topicsubtitle = (TextView) vh.getViewById(R.id.topic_subtitle);
        TextView topicprice = (TextView) vh.getViewById(R.id.topic_price);
        HomeBean.DataBean.TopicListBean topicListBean= (HomeBean.DataBean.TopicListBean) data;
        Glide.with(context).load(topicListBean.getItem_pic_url()).into(topicimg);
        topicname.setText(topicListBean.getTitle());
        topicsubtitle.setText(topicListBean.getSubtitle());
        topicprice.setText("¥"+topicListBean.getPrice_info()+"元起");
    }
}
