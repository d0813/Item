package com.example.item.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.ShopBean;

import java.util.List;

public class IssueAdapter extends BaseAdapter {
    public IssueAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.issue_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView title = (TextView) vh.getViewById(R.id.title);
        TextView text = (TextView) vh.getViewById(R.id.text);
        ShopBean.DataBeanX.IssueBean issueBean= (ShopBean.DataBeanX.IssueBean) data;
        title.setText(issueBean.getQuestion());
        text.setText(issueBean.getAnswer());

    }
}

