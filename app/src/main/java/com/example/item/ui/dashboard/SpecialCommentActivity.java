package com.example.item.ui.dashboard;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.item.R;
import com.example.item.app.MyApp;
import com.example.item.base.BaseActivity;
import com.example.item.bean.SpCommentBean;
import com.example.item.bean.SpDetailsBean;
import com.example.item.bean.SpecialBean;
import com.example.item.bean.SpecialDetailsButtomBean;
import com.example.item.interfaces.Net.ISpecial;
import com.example.item.presenter.SpecialPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

public class SpecialCommentActivity extends BaseActivity<ISpecial.Presenter> implements ISpecial.View {

    @BindView(R.id.mRlv_special_comment)
    RecyclerView mRlv;
    private int id;

    @Override
    protected int getLayout() {
        return R.layout.activity_special_comment;
    }

    @Override
    protected ISpecial.Presenter createPrenter() {
        return new SpecialPresenter(this);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        id = (int) MyApp.getMap().get("specialId");

        presenter.getSpComment(getMap());
    }

    private HashMap<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("valueId",String.valueOf(id));
        map.put("typeId",String.valueOf(1));
        map.put("size","");
        return map;
    }



    @Override
    public void getSpecial(SpecialBean specialBean) {

    }

    @Override
    public void getgSpDetails(SpDetailsBean spDetailsBean) {

    }

    @Override
    public void getSpComment(SpCommentBean spCommentBean) {
        List<SpCommentBean.DataBeanX.DataBean> data = spCommentBean.getData().getData();
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        SpecialDetailsCommentAdapter specialDetailsCommentAdapter = new SpecialDetailsCommentAdapter(this, data);
        mRlv.setAdapter(specialDetailsCommentAdapter);
        specialDetailsCommentAdapter.notifyDataSetChanged();

    }

    @Override
    public void getSpDetailsButtom(SpecialDetailsButtomBean specialDetailsButtomBean) {

    }
}