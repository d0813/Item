package com.example.item.ui.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.base.BaseActivity;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.DetailBean;
import com.example.item.bean.HomeBean;
import com.example.item.bean.HomeDetailBean;
import com.example.item.bean.HomeNewBean;
import com.example.item.bean.HomeNewPriceBean;
import com.example.item.bean.InformationBean;
import com.example.item.bean.SubDetailHeadBean;
import com.example.item.bean.SubHomeDetailBean;
import com.example.item.interfaces.Net.IHome;
import com.example.item.presenter.HomePresenter;
import com.example.item.ui.home.adapter.HomeDetailAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeDirectActivity extends BaseActivity<HomePresenter> implements IHome.View {

    @BindView(R.id.lines)
    LinearLayout lines;
    private HomeDetailAdapter homeDetailAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_direct;
    }

    @Override
    protected HomePresenter createPrenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getHomeDetail();

    }


    @Override
    public void getHomeNew(HomeNewBean homeNewBean) {

    }

    @Override
    public void getSubdetailHead(SubDetailHeadBean subDetailHeadBean) {

    }

    @Override
    public void getsubDetail(SubHomeDetailBean subHomeDetailBean) {

    }

    @Override
    public void gethomenewprice(HomeNewPriceBean homeNewPriceBean) {

    }


    @Override
    public void getHomeReturn(HomeBean homeBean) {

    }

    @Override
    public void getDetailReturn(DetailBean detailBean) {

    }

    @Override
    public void getInfor(InformationBean informationBean) {

    }

    @Override
    public void getHomeDetail(HomeDetailBean homeDetailBean) {
        List<HomeDetailBean.DataBeanX.DataBean> data = homeDetailBean.getData().getData();
        for (int i = 0; i < data.size(); i++) {
            View view = View.inflate(this, R.layout.homedetail, null);
            RecyclerView Home_detail = view.findViewById(R.id.recycleer_Home_detail);
            Home_detail.setLayoutManager(new LinearLayoutManager(this));
            homeDetailAdapter = new HomeDetailAdapter(this, data);
            Home_detail.setAdapter(homeDetailAdapter);
            lines.addView(view);
            homeDetailAdapter.addListClick(new BaseAdapter.IListClick() {
                @Override
                public void itemClick(int pos) {
                    int id = data.get(pos).getId();
                    Intent intent = new Intent(HomeDirectActivity.this, SubHomeDirectActivity.class);
                    intent.putExtra("key",id);
                    startActivity(intent);
                }
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}