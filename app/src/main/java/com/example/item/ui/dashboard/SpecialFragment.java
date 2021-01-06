package com.example.item.ui.dashboard;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.app.MyApp;
import com.example.item.base.BaseAdapter;
import com.example.item.base.BaseFragment;
import com.example.item.bean.SpCommentBean;
import com.example.item.bean.SpDetailsBean;
import com.example.item.bean.SpecialBean;
import com.example.item.bean.SpecialDetailsButtomBean;
import com.example.item.interfaces.Net.ISpecial;
import com.example.item.presenter.SpecialPresenter;

import java.util.List;

import butterknife.BindView;


public class SpecialFragment extends BaseFragment<ISpecial.Presenter> implements ISpecial.View {


    @BindView(R.id.lines)
    LinearLayout lines;
    private SpecialAdapter specialAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_dashboard;
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
        presenter.getSpecial();

    }


    @Override
    public void getSpecial(SpecialBean specialBean) {
        List<SpecialBean.DataBeanX.DataBean> data = specialBean.getData().getData();
        for (int i = 0; i < data.size(); i++) {
            View view = View.inflate(getActivity(), R.layout.sp_item, null);
            RecyclerView special = view.findViewById(R.id.recycler_special);
            special.setLayoutManager(new LinearLayoutManager(getActivity()));
            specialAdapter = new SpecialAdapter(getActivity(), data);
            special.setAdapter(specialAdapter);
            lines.addView(view);
            specialAdapter.addListClick(new BaseAdapter.IListClick() {
                @Override
                public void itemClick(int pos) {
                    Intent intent = new Intent(getActivity(), SpecialDetailsActivity.class);
                    MyApp.getMap().put("specialId",data.get(pos).getId());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void getgSpDetails(SpDetailsBean spDetailsBean) {

    }

    @Override
    public void getSpComment(SpCommentBean spCommentBean) {

    }

    @Override
    public void getSpDetailsButtom(SpecialDetailsButtomBean specialDetailsButtomBean) {

    }
}