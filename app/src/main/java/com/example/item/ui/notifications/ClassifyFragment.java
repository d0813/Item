package com.example.item.ui.notifications;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.item.R;
import com.example.item.base.BaseFragment;
import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;
import com.example.item.interfaces.Net.IClassify;
import com.example.item.presenter.ClassifyPresenter;
import com.example.item.ui.notifications.adapter.FagTAbAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class ClassifyFragment extends BaseFragment<IClassify.Presenter> implements IClassify.View {


    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.VTAblayout)
    VerticalTabLayout VTAblayout;
    @BindView(R.id.Viewpager)
    ViewPager Viewpager;

    private ArrayList<Fragment> fragments;
    private int id;
    private String name;
    private FagTAbAdapter fagTAbAdapter;
    private ArrayList<String> titlelist;

    @Override
    protected int getLayout() {
        return R.layout.fragment_notifications;
    }

    @Override
    protected IClassify.Presenter createPrenter() {
        return new ClassifyPresenter();
    }

    @Override
    protected void initView() {
        fragments = new ArrayList<>();

    }

    @Override
    protected void initData() {
        presenter.getClassifyListReturn();


    }

    @Override
    public void getClassifyReturn(ClassifyBean classifyBean) {

    }

    @Override
    public void getClassifyTitleReturn(ClassifyTitleBean classifyTitleBean) {

    }



    @Override
    public void getClassifyListReturn(ClassifyVerticalBean classifyVerticalBeanBean) {
        List<ClassifyVerticalBean.DataBean.CategoryListBean>
                categoryList = classifyVerticalBeanBean.getData().getCategoryList();
        titlelist = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            id = categoryList.get(i).getId();
            name = categoryList.get(i).getName();
            SubClassifyFragment subClassifyFragment = new SubClassifyFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key",id);
            bundle.putString("name",name);
            subClassifyFragment.setArguments(bundle);
            fragments.add(subClassifyFragment);
            titlelist.add(categoryList.get(i).getName());

       }
        fagTAbAdapter = new FagTAbAdapter(getChildFragmentManager(), fragments, titlelist);
        Viewpager.setAdapter(fagTAbAdapter);
        VTAblayout.setupWithViewPager(Viewpager);

    }

    @Override
    public void getclassdetailReturn(ClassifyDetailbean classifyDetailbean) {

    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
    }
}