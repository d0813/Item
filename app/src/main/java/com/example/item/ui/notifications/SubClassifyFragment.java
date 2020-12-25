package com.example.item.ui.notifications;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.base.BaseFragment;
import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;
import com.example.item.interfaces.Net.IClassify;
import com.example.item.presenter.ClassifyPresenter;
import com.example.item.ui.notifications.adapter.SubClassifyAdapter;

import java.util.List;

import butterknife.BindView;

public class SubClassifyFragment extends BaseFragment<IClassify.Presenter> implements IClassify.View {


    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.head_text)
    TextView headText;
    @BindView(R.id.recycler_classify)
    RecyclerView recyclerClassify;
    @BindView(R.id.classify)
    TextView classify;
    private int key;
    private String name;
    private SubClassifyAdapter subClassifyAdapter;

    @Override
    protected int getLayout() {
        return R.layout.subclassify_item;
    }

    @Override
    protected IClassify.Presenter createPrenter() {
        return new ClassifyPresenter();
    }

    @Override
    protected void initView() {
        key = getArguments().getInt("key");
        name = getArguments().getString("name");

    }

    @Override
    protected void initData() {
        presenter.getClassifyReturn(key);

    }

    @Override
    public void getClassifyReturn(ClassifyBean classifyBean) {
        ClassifyBean.DataBean.CurrentCategoryBean currentCategory = classifyBean.getData().getCurrentCategory();
        Glide.with(getActivity()).load(currentCategory.getWap_banner_url()).into(headImg);
        headText.setText(currentCategory.getFront_name());
        classify.setText("-- "+currentCategory.getName()+"分类--");
        List<ClassifyBean.DataBean.CurrentCategoryBean.SubCategoryListBean>
                subCategoryList = currentCategory.getSubCategoryList();
        recyclerClassify.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        subClassifyAdapter = new SubClassifyAdapter(getActivity(), subCategoryList);
        recyclerClassify.setAdapter(subClassifyAdapter);
        subClassifyAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = subCategoryList.get(pos).getId();
                String name = subCategoryList.get(pos).getName();
                Intent intent = new Intent(getActivity(), ClassifyActivity.class);
                intent.putExtra("subkey",id);
                intent.putExtra("subName",name);
                startActivityForResult(intent,100);
            }
        });

    }

    @Override
    public void getClassifyTitleReturn(ClassifyTitleBean classifyTitleBean) {

    }


    @Override
    public void getClassifyListReturn(ClassifyVerticalBean classifyVerticalBeanBean) {

    }

    @Override
    public void getclassdetailReturn(ClassifyDetailbean classifyDetailbean) {

    }


}

