package com.example.item.ui.home;

import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.base.BaseFragment;
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

import java.util.List;

import butterknife.BindView;

public class InFormationFragment extends BaseFragment<IHome.Presenter> implements IHome.View {
    @BindView(R.id.infor_title)
    TextView inforTitle;
    @BindView(R.id.infor_text)
    TextView inforText;
    @BindView(R.id.recycler_infor)
    RecyclerView recyclerInfor;
    private int key;
    private InforAdapter inforAdapter;
    private String name;
    private String title;


    @Override
    protected int getLayout() {
        return R.layout.infor_item;
    }

    @Override
    protected IHome.Presenter createPrenter() {
        return new HomePresenter();
    }


    @Override
    protected void initView() {
        key = getArguments().getInt("key");
        name = getArguments().getString("front");
        title = getArguments().getString("name");

    }

    @Override
    protected void initData() {
        presenter.getInfor(key,1,100);
    }

    @Override
    public void getHomeReturn(HomeBean homeBean) {

    }

    @Override
    public void getDetailReturn(DetailBean detailBean) {

    }

    @Override
    public void getInfor(InformationBean informationBean) {
        inforTitle.setText(title);
        inforText.setText(name);
        List<InformationBean.DataBeanX.GoodsListBean> goodsList = informationBean.getData().getGoodsList();
        inforAdapter = new InforAdapter(getActivity(), goodsList);
        recyclerInfor.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerInfor.setAdapter(inforAdapter);
        inforAdapter.notifyDataSetChanged();

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

