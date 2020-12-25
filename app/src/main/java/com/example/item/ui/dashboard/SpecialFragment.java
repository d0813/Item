package com.example.item.ui.dashboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseFragment;
import com.example.item.bean.SpecialBean;
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
        return new SpecialPresenter();
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
        }
    }
}