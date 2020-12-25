package com.example.item.ui.home.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.item.ui.home.adapter.HomeNewAdapter;
import com.example.item.ui.home.adapter.SubHoemNewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeNewActivity extends BaseActivity<HomePresenter> implements IHome.View {


    @BindView(R.id.new_synthesize)
    TextView newSynthesize;
    @BindView(R.id.new_price)
    TextView newPrice;
    @BindView(R.id.up_no)
    ImageView upNo;
    @BindView(R.id.down_no)
    ImageView downNo;
    @BindView(R.id.new_classify)
    TextView newClassify;
    @BindView(R.id.recycler_homenew)
    RecyclerView recyclerHomenew;
    @BindView(R.id.l)
    LinearLayout l;
    private HomeNewAdapter homeNewAdapter;
    private HashMap<String, String> map;

    private static final int DESC = 0;
    private static final int ASC = 1;
    private String order = "asc";
    private String sort = "default";
    private String categoryId = "0";
    private SubHoemNewAdapter newAdapter;
    private PopupWindow popupWindow;
    private ArrayList<HomeNewPriceBean.DataBeanX.FilterCategoryBean> filterCategoryBeans1;
    private View mview;
    private List<HomeNewPriceBean.DataBeanX.FilterCategoryBean> filterCategory;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_new;
    }

    @Override
    protected HomePresenter createPrenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        map = new HashMap<>();

        newPrice.setTag(0);

    }

    @Override
    protected void initData() {
        map.clear();
        map.put("isNew", "1");
        map.put("page", "1");
        map.put("size", "1000");
        map.put("order", order);
        map.put("sort", sort);
        map.put("categoryId", categoryId);
        presenter.gethomenewprice(map);
    }


    @Override
    public void gethomenewprice(HomeNewPriceBean homeNewPriceBean) {
        List<HomeNewPriceBean.DataBeanX.DataBean> data = homeNewPriceBean.getData().getData();
        filterCategory = homeNewPriceBean.getData().getFilterCategory();
        homeNewAdapter = new HomeNewAdapter(this, data);
        recyclerHomenew.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerHomenew.setAdapter(homeNewAdapter);


    }

    @OnClick({R.id.new_synthesize, R.id.new_price, R.id.up_no, R.id.down_no, R.id.new_classify})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.new_synthesize:
                newSynthesize.setTextColor(Color.RED);
                newClassify.setTextColor(Color.BLACK);
                newPrice.setTextColor(Color.BLACK);
                downNo.setImageResource(R.drawable.down_no);
                upNo.setImageResource(R.drawable.up_no);
                order = "asc";
                sort = "default";
                initData();
                break;
            case R.id.new_price:
                int tag = (int) newPrice.getTag();
                if (tag == 0) {
                    newPrice.setTag(ASC);
                    upNo.setImageResource(R.drawable.up_select);
                    newPrice.setTextColor(Color.RED);
                    newClassify.setTextColor(Color.BLACK);
                    newSynthesize.setTextColor(Color.BLACK);
                    downNo.setImageResource(R.drawable.down_no);
                    order = "asc";
                    sort = "price";
                    initData();
                } else if (tag == 1) {
                    newPrice.setTag(DESC);
                    downNo.setImageResource(R.drawable.down_select);
                    newPrice.setTextColor(Color.RED);
                    newClassify.setTextColor(Color.BLACK);
                    newSynthesize.setTextColor(Color.BLACK);
                    upNo.setImageResource(R.drawable.up_no);
                    order = "desc";
                    sort = "price";
                    initData();
                }
                break;
            case R.id.up_no:
                break;
            case R.id.down_no:
                break;
            case R.id.new_classify:
                newPrice.setTextColor(Color.BLACK);
                newClassify.setTextColor(Color.RED);
                newSynthesize.setTextColor(Color.BLACK);
                downNo.setImageResource(R.drawable.down_no);
                upNo.setImageResource(R.drawable.up_no);
                getpopwindows();
                break;
        }
    }

    private void getpopwindows() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.pop_item, null,false);
        RecyclerView mNewRecycler = inflate.findViewById(R.id.recycler_new);

        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);


        filterCategoryBeans1 = new ArrayList<>();
        mNewRecycler.setLayoutManager(new LinearLayoutManager(HomeNewActivity.this,RecyclerView.HORIZONTAL,false));
        newAdapter = new SubHoemNewAdapter(HomeNewActivity.this, filterCategoryBeans1);
        mNewRecycler.setAdapter(newAdapter);

        filterCategoryBeans1.addAll(filterCategory);
        newAdapter.notifyDataSetChanged();
        newAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                HomeNewPriceBean.DataBeanX.FilterCategoryBean bean = filterCategoryBeans1.get(pos);
                categoryId=bean.getId()+"";
                popupWindow.dismiss();
                initData();
            }
        });

        popupWindow.showAsDropDown(l);
    }

    @Override
    public void getHomeNew(HomeNewBean homeNewBean) {

    }


    @Override
    public void getHomeReturn(HomeBean homeBean) {

    }

    @Override
    public void getSubdetailHead(SubDetailHeadBean subDetailHeadBean) {

    }

    @Override
    public void getsubDetail(SubHomeDetailBean subHomeDetailBean) {


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

}