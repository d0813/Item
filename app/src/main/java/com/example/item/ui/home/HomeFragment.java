package com.example.item.ui.home;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseAdapter;
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
import com.example.item.ui.home.activity.HomeDirectActivity;
import com.example.item.ui.home.activity.HomeNewActivity;
import com.example.item.ui.home.activity.SubHomeDirectActivity;
import com.example.item.ui.home.adapter.ShopActivity;
import com.example.item.ui.shopping.ShoppingFragment;
import com.example.item.utils.ItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment<IHome.Presenter> implements IHome.View, View.OnClickListener {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.linefragmet)
    LinearLayout lineFragment;
    @BindView(R.id.recycelr_direct)
    RecyclerView recycelrDirect;
    @BindView(R.id.recycler_new)
    RecyclerView recyclerNew;
    @BindView(R.id.recycler_recommend)
    RecyclerView recyclerRecommend;
    @BindView(R.id.recycler_topic)
    RecyclerView recyclerTopic;
    @BindView(R.id.lines)
    LinearLayout lines;
    @BindView(R.id.home_direct_supply)
    TextView homeDirectSupply;
    @BindView(R.id.home_new_arrival)
    TextView homeNewArrival;
    @BindView(R.id.home_hot)
    TextView homeHot;
    @BindView(R.id.home_choiceness)
    TextView homeChoiceness;


    private ArrayList<HomeBean.DataBean.BannerBean> bannerBeans;
    private DirectAdapter directAdapter;
    private NewAdapter newAdapter;
    private HotGoodsAdapter hotGoodsAdapter;
    private TopicAdapter topicAdapter;
    private CategoryAdapter categoryAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected IHome.Presenter createPrenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    private void banner(List<HomeBean.DataBean.BannerBean> list) {
        homeBanner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataBean.BannerBean bannerBean = (HomeBean.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();

    }

    @Override
    protected void initData() {
        presenter.getHome();

    }


    @Override
    public void getHomeReturn(HomeBean homeBean) {
        if (homeBean != null) {
            banner(homeBean.getData().getBanner());
            channel(homeBean.getData().getChannel());
            direct(homeBean.getData().getBrandList());
            newrecycler(homeBean.getData().getNewGoodsList());
            hotGoods(homeBean.getData().getHotGoodsList());
            topic(homeBean.getData().getTopicList());
            category(homeBean.getData().getCategoryList());
        }

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


    //居家

    private void category(List<HomeBean.DataBean.CategoryListBean> categoryList) {
        for (int i = 0; i < categoryList.size(); i++) {
            View view = View.inflate(getActivity(), R.layout.item_category, null);
            TextView categroytitle = view.findViewById(R.id.categroy_title);
            categroytitle.setText(categoryList.get(i).getName());
            RecyclerView recycler = view.findViewById(R.id.prorecycler_categroy);
            recycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryList.get(i).getGoodsList();
            categoryAdapter = new CategoryAdapter(getActivity(), goodsList);
            recycler.setAdapter(categoryAdapter);
            lines.addView(view);
            categoryAdapter.addListClick(new BaseAdapter.IListClick() {
                @Override
                public void itemClick(int pos) {
                    int id = goodsList.get(pos).getId();
                    Intent intent = new Intent(getActivity(), ShopActivity.class);
                    intent.putExtra("Categorykey",id);
                    startActivityForResult(intent,100);
                }
            });
        }
    }

    //专题精选
    private void topic(List<HomeBean.DataBean.TopicListBean> topicList) {
        topicAdapter = new TopicAdapter(getActivity(), topicList);
        recyclerTopic.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recyclerTopic.setAdapter(topicAdapter);
        topicAdapter.notifyDataSetChanged();


    }
    //人气推荐

    private void hotGoods(List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList) {
        hotGoodsAdapter = new HotGoodsAdapter(getActivity(), hotGoodsList);
        recyclerRecommend.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerRecommend.setAdapter(hotGoodsAdapter);
        hotGoodsAdapter.notifyDataSetChanged();
        recyclerRecommend.addItemDecoration(new ItemDecoration(getActivity()));
        hotGoodsAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = hotGoodsList.get(pos).getId();
                Intent intent = new Intent(getActivity(), ShopActivity.class);
                intent.putExtra("Categorykey",id);
                startActivityForResult(intent,100);
            }
        });
//        hotGoodsAdapter.addListClick(new BaseAdapter.IListClick() {
//            @Override
//            public void itemClick(int pos) {
//                int id = hotGoodsList.get(pos).getId();q
//                Intent intent = new Intent(getActivity(), ShopActivity.class);
//                intent.putExtra("fragment",1);
//                intent.putExtra("Categorykey",id);
//                startActivityForResult(intent,100);
//            }
//        });

    }

    //新品首发
    private void newrecycler(List<HomeBean.DataBean.NewGoodsListBean> newGoodsList) {

        newAdapter = new NewAdapter(getActivity(), newGoodsList);
        recyclerNew.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerNew.setAdapter(newAdapter);
        newAdapter.notifyDataSetChanged();
        newAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = newGoodsList.get(pos).getId();
                Intent intent = new Intent(getActivity(), ShopActivity.class);
                intent.putExtra("Categorykey",id);
                startActivityForResult(intent,100);

            }
        });

    }

    //品牌制造商直供
    private void direct(List<HomeBean.DataBean.BrandListBean> brandList) {
        directAdapter = new DirectAdapter(getActivity(), brandList);
        recycelrDirect.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycelrDirect.setAdapter(directAdapter);
        directAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = brandList.get(pos).getId();
                Intent intent = new Intent(getActivity(), SubHomeDirectActivity.class);
                intent.putExtra("key",id);
                startActivity(intent);

            }
        });
        directAdapter.notifyDataSetChanged();
    }


    private void channel(List<HomeBean.DataBean.ChannelBean> channel) {
        lineFragment.removeAllViews();
        for (HomeBean.DataBean.ChannelBean item : channel) {
            View view = View.inflate(getContext(), R.layout.layout_channel_item, null);
            LinearLayout lineView = view.findViewById(R.id.line);
            ImageView imgChannel = view.findViewById(R.id.img_channel);
            TextView txtChannel = view.findViewById(R.id.txt_channel);
            //设置布局水平展示
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            lineView.setLayoutParams(layoutParams);
            //赋值
            txtChannel.setText(item.getName());
            Glide.with(getActivity()).load(item.getIcon_url()).into(imgChannel);
            lineFragment.addView(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = item.getId();
                    String name = item.getName();
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("key", id);
                    intent.putExtra("name", name);
                    startActivityForResult(intent, 100);

                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.home_direct_supply, R.id.home_new_arrival, R.id.home_hot, R.id.home_choiceness})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_direct_supply:
                Intent intent = new Intent(getActivity(), HomeDirectActivity.class);
                startActivity(intent);
                break;
            case R.id.home_new_arrival:
                Intent intent1 = new Intent(getActivity(), HomeNewActivity.class);
                startActivity(intent1);
                break;
            case R.id.home_hot:
                break;
            case R.id.home_choiceness:
                break;
        }
    }


}