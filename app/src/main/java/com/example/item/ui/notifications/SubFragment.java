package com.example.item.ui.notifications;

import android.content.Intent;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.base.BaseFragment;
import com.example.item.bean.ClassifyBean;
import com.example.item.bean.ClassifyDetailbean;
import com.example.item.bean.ClassifyTitleBean;
import com.example.item.bean.ClassifyVerticalBean;
import com.example.item.interfaces.Net.IClassify;
import com.example.item.presenter.ClassifyPresenter;
import com.example.item.ui.home.adapter.ShopActivity;
import com.example.item.ui.notifications.adapter.MyAdapter;

import java.util.List;

import butterknife.BindView;


public class SubFragment extends BaseFragment<IClassify.Presenter> implements IClassify.View {

    @BindView(R.id.classify_title)
    TextView classifyTitle;
    @BindView(R.id.classify_text)
    TextView classifyText;
    @BindView(R.id.recycler_classify)
    RecyclerView recyclerClassify;
    private int activityKey;
    private String activityName;
    private MyAdapter myAdapter;
    private String front_desc;

    @Override
    protected int getLayout() {
        return R.layout.fragment_sub;
    }

    @Override
    protected IClassify.Presenter createPrenter() {
        return new ClassifyPresenter();
    }

    @Override
    protected void initView() {
        activityKey = getArguments().getInt("ActivityKey");
        activityName = getArguments().getString("ActivityName");
        front_desc = getArguments().getString("front_desc");
    }

    @Override
    protected void initData() {
        presenter.getClassifyTitleReturn(activityKey);
        presenter.getclassdetail(activityKey, 1, 100);

    }
    @Override
    public void getclassdetailReturn(ClassifyDetailbean classifyDetailbean) {
        List<ClassifyDetailbean.DataBeanX.GoodsListBean> goodsList = classifyDetailbean.getData().getGoodsList();
        classifyTitle.setText(activityName);
        classifyText.setText(front_desc);
        recyclerClassify.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myAdapter = new MyAdapter(getActivity(), goodsList);
        recyclerClassify.setAdapter(myAdapter);
        myAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = goodsList.get(pos).getId();
                Intent intent = new Intent(getActivity(), ShopActivity.class);
                intent.putExtra("Categorykey",id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getClassifyReturn(ClassifyBean classifyBean) {

    }

    @Override
    public void getClassifyTitleReturn(ClassifyTitleBean classifyTitleBean) {

    }


    @Override
    public void getClassifyListReturn(ClassifyVerticalBean classifyVerticalBeanBean) {

    }


}