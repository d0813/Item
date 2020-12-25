package com.example.item.ui.notifications;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.item.R;
import com.example.item.base.BaseActivity;
import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;
import com.example.item.interfaces.Net.IClassify;
import com.example.item.presenter.ClassifyPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassifyActivity extends BaseActivity<IClassify.Presenter> implements IClassify.View {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private int subkey;
    private ArrayList<Fragment> fragments;
    private String subName;

    @Override
    protected int getLayout() {
        return R.layout.activity_classify;
    }

    @Override
    protected IClassify.Presenter createPrenter() {
        return new ClassifyPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        subkey = intent.getIntExtra("subkey", 0);
        subName = intent.getStringExtra("subName");
        fragments = new ArrayList<>();

    }

    @Override
    protected void initData() {
        presenter.getClassifyTitleReturn(subkey);
        presenter.getclassdetail(subkey,1,100);

    }



    @Override
    public void getclassdetailReturn(ClassifyDetailbean classifyDetailbean) {

    }


    @Override
    public void getClassifyReturn(ClassifyBean classifyBean) {

    }

    @Override
    public void getClassifyTitleReturn(ClassifyTitleBean classifyTitleBean) {
        List<ClassifyTitleBean.DataBean.BrotherCategoryBean> filterCategory = classifyTitleBean.getData().getBrotherCategory();
        for (int i = 0; i < filterCategory.size(); i++) {
            String name = filterCategory.get(i).getName();
            int id = filterCategory.get(i).getId();
            String front_desc = filterCategory.get(i).getFront_desc();
            SubFragment subFragment = new SubFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("ActivityKey",id);
            bundle.putString("ActivityName",name);
            bundle.putString("front_desc",front_desc);
            subFragment.setArguments(bundle);

            fragments.add(subFragment);

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
        for (int i = 0; i < filterCategory.size(); i++) {
            if(subName.equals(filterCategory.get(i).getName())){
                viewpager.setCurrentItem(i);
            }
            tablayout.getTabAt(i).setText(filterCategory.get(i).getName());

        }
    }


    @Override
    public void getClassifyListReturn(ClassifyVerticalBean classifyVerticalBeanBean) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            setResult(1);
            viewpager.setCurrentItem(3);
            finish();
        }
    }
}