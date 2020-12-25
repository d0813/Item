package com.example.item.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.item.R;
import com.example.item.base.BaseActivity;
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
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity<HomePresenter> implements IHome.View {


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private ArrayList<Fragment> fragments;
    private String homename;

    @Override
    protected int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected HomePresenter createPrenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        Intent intent = getIntent();
        homename = intent.getStringExtra("name");


    }


    @Override
    protected void initData() {
        presenter.getDetail(1005000);

    }


    @Override
    public void getHomeReturn(HomeBean homeBean) {

    }

    @Override
    public void getDetailReturn(DetailBean detailBean) {
        List<DetailBean.DataBean.BrotherCategoryBean> brotherCategory = detailBean.getData().getBrotherCategory();
        for (int i = 0; i < brotherCategory.size(); i++) {
            int id = brotherCategory.get(i).getId();
            String front_desc = brotherCategory.get(i).getFront_desc();
            String name = brotherCategory.get(i).getName();
            InFormationFragment inFormationFragment = new InFormationFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key", id);
            bundle.putString("front",front_desc);
            bundle.putString("name",name);
            inFormationFragment.setArguments(bundle);
            fragments.add(inFormationFragment);
        }
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tablayout.setupWithViewPager(viewpager);

        for (int i = 0; i < brotherCategory.size(); i++) {
            String name = brotherCategory.get(i).getName();
            tablayout.getTabAt(i).setText(name);

        }
        for (int i = 0; i < brotherCategory.size(); i++) {
            if(homename.equals(brotherCategory.get(i).getName())){
                viewpager.setCurrentItem(i);
                return;
            }
        }

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
    public void getSubdetailHead(SubDetailHeadBean subDetailHeadBean) {

    }

    @Override
    public void getsubDetail(SubHomeDetailBean subHomeDetailBean) {

    }

    @Override
    public void gethomenewprice(HomeNewPriceBean homeNewPriceBean) {

    }
}