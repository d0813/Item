package com.example.item.ui.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
import com.example.item.ui.home.adapter.ShopActivity;
import com.example.item.ui.home.adapter.SubAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubHomeDirectActivity extends BaseActivity<HomePresenter> implements IHome.View {


    @BindView(R.id.sub_img)
    ImageView subImg;
    @BindView(R.id.sub_title)
    TextView subTitle;
    @BindView(R.id.sub_text)
    TextView subText;
    @BindView(R.id.recycelr_sub)
    RecyclerView recycelrSub;
    private int key;
    private SubAdapter subAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_sub_home_direct;
    }

    @Override
    protected HomePresenter createPrenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);

    }

    @Override
    protected void initData() {
        presenter.getSubdetailHead(key);
        presenter.getsubDetail(key,1,1000);

    }

    @Override
    public void getSubdetailHead(SubDetailHeadBean subDetailHeadBean) {
        subTitle.setText(subDetailHeadBean.getData().getBrand().getName());
        subText.setText(subDetailHeadBean.getData().getBrand().getSimple_desc());
        Glide.with(this).load(subDetailHeadBean.getData().getBrand().getList_pic_url()).into(subImg);

    }

    @Override
    public void getsubDetail(SubHomeDetailBean subHomeDetailBean) {
        List<SubHomeDetailBean.DataBeanX.GoodsListBean> goodsList = subHomeDetailBean.getData().getGoodsList();
        recycelrSub.setLayoutManager(new GridLayoutManager(this,2));
        subAdapter = new SubAdapter(this, goodsList);
        recycelrSub.setAdapter(subAdapter);
        subAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = goodsList.get(pos).getId();
                Intent intent = new Intent(SubHomeDirectActivity.this, ShopActivity.class);
                intent.putExtra("Categorykey",id);
                startActivityForResult(intent,100);
            }
        });
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

    }

    @Override
    public void getHomeNew(HomeNewBean homeNewBean) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}