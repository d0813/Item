package com.example.item.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.item.R;
import com.example.item.base.BaseActivity;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.ShopBean;
import com.example.item.bean.ShopListBean;
import com.example.item.bean.login.AddCarBean;
import com.example.item.interfaces.Net.IShop;
import com.example.item.presenter.ShopPresenter;
import com.example.item.ui.home.bigvideo.BigImageActivity;
import com.example.item.ui.home.bigvideo.CategoryBigImageAdapter;
import com.example.item.ui.login.LoginActivity;
import com.luck.picture.lib.tools.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopActivity extends BaseActivity<ShopPresenter> implements IShop.View {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.txt_assess)
    TextView txtAssess;

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.img_collect)
    ImageView imgCollect;
    @BindView(R.id.layout_collect)
    FrameLayout layoutCollect;
    @BindView(R.id.img_car)
    ImageView imgCar;
    @BindView(R.id.txt_number)
    TextView txtNumber;
    @BindView(R.id.layout_car)
    FrameLayout layoutCar;
    @BindView(R.id.txt_buy)
    TextView txtBuy;
    @BindView(R.id.txt_addCar)
    TextView txtAddCar;
    @BindView(R.id.layout_shop)
    ConstraintLayout layoutShop;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.recycler_issue)
    RecyclerView recyclerIssue;
    @BindView(R.id.recycler_look)
    RecyclerView recyclerLook;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.head_text)
    TextView headText;
    @BindView(R.id.head_price)
    TextView headPrice;
    @BindView(R.id.size)
    TextView size;
    @BindView(R.id.texture)
    TextView texture;
    @BindView(R.id.Liner)
    TextView Liner;
    @BindView(R.id.hint)
    TextView hint;
    @BindView(R.id.recycler_h5)
    RecyclerView recyclerH5;
    ShopBean.DataBeanX.InfoBean info;
    ShopBean shopBean;

    private String h5 = "<html>\n" +
            "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
            "            <head>\n" +
            "                <style>\n" +
            "                    p{\n" +
            "                        margin:0px;\n" +
            "                    }\n" +
            "                    img{\n" +
            "                        width:100%;\n" +
            "                        height:auto;\n" +
            "                    }\n" +
            "                </style>\n" +
            "            </head>\n" +
            "            <body>\n" +
            "                word\n" +
            "            </body>\n" +
            "        </html>";
    private int id;
    private IssueAdapter issueAdapter;
    private AttributeAdapter attributeAdapter;
    private LookAdapter lookAdapter;
    private CategoryBigImageAdapter categoryBigImageAdapter;
    private int f;
    private int shu;
    private PopupWindow popupWindow;


    @Override
    protected int getLayout() {
        return R.layout.activity_shop;
    }

    @Override
    protected ShopPresenter createPrenter() {
        return new ShopPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("Categorykey", 0);
    }

    @Override
    protected void initData() {
        presenter.getShop(id);
        presenter.getShopList(id);

    }

    @Override
    public void getShopReturn(ShopBean shopBean) {
        this.shopBean=shopBean;
        banners(shopBean.getData().getGallery());
        //h5
        detail(shopBean.getData().getInfo().getGoods_desc());
        issue(shopBean.getData().getIssue());
        attribute(shopBean.getData().getAttribute());
        heandname(shopBean.getData().getInfo());
        //评论
        //  initComment(shopBean.getData().getComment().getData());

        //展示h5
        //showImage(shopBean.getData().getInfo().getGoods_desc());

    }

    private void initComment(ShopBean.DataBeanX.CommentBean.DataBean data) {
//        if (data != null) {
//            mCl_assess.setVisibility(View.VISIBLE);//进行显示评论
//            mCl_comment.setVisibility(View.VISIBLE);//显示商品文字
//
//            //时间
//            tv_head_date.setText(data.getAdd_time());
//            //名字
//            tv_head_name.setText(data.getNickname());
//            //评论内容
//            tv_head_desc.setText(data.getContent());
//            //底部图片
//            if (data.getPic_list() != null && data.getPic_list().size() > 0) {
//                ImageLoaderUtils.loadImage(data.getPic_list().get(0).getPic_url(), iv_img);
//            } else {
//                mCl_comment.setVisibility(View.GONE);//隐藏下面的图片
//            }
//        } else {
//            Log.i("TAG", "该详情没有评论");
//        }
    }

    private void detail(String goods_desc) {
        showImage(goods_desc);
        String content = h5.replace("word", goods_desc);
        Log.i("TAG", "detail: " + content);
        // recyclerH5.loadDataWithBaseURL("about:blank", content, "text/html", "utf-8", null);

    }

    private void showImage(String goods_desc) {
        ArrayList<String> listUrl = new ArrayList<>();
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(goods_desc);
        while (matcher.find()) {//如果是jpg格式就截取
            String word = matcher.group();
            int start = word.indexOf("\"") + 1;
            int end = word.indexOf(".jpg");
            if (end > 0) {
                String url = word.substring(start, end);
                if (url != null) {
                    url = url + ".jpg";
                    listUrl.add(url);
                } else {
                    return;
                }
            } else {
                int end1 = word.indexOf(".png");
                String url = word.substring(start, end1);
                if (url != null) {
                    url = url + ".png";
                    listUrl.add(url);
                } else {
                    return;
                }
            }
        }
        recyclerH5.setLayoutManager(new LinearLayoutManager(this));
        categoryBigImageAdapter = new CategoryBigImageAdapter(this, listUrl);
        recyclerH5.setAdapter(categoryBigImageAdapter);
        categoryBigImageAdapter.notifyDataSetChanged();

        categoryBigImageAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(ShopActivity.this, BigImageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("image", listUrl);
                bundle.putInt("pos", pos);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });

    }

    private void heandname(ShopBean.DataBeanX.InfoBean info) {
        this.info = info;
        headTitle.setText(info.getName());
        headText.setText(info.getGoods_brief());
        headPrice.setText("¥" + info.getRetail_price());
    }

    @Override
    public void getShopList(ShopListBean shopListBean) {
        List<ShopListBean.DataBean.GoodsListBean> goodsList = shopListBean.getData().getGoodsList();
        recyclerLook.setLayoutManager(new GridLayoutManager(ShopActivity.this, 2));
        lookAdapter = new LookAdapter(ShopActivity.this, goodsList);
        recyclerLook.setAdapter(lookAdapter);
    }

    @Override
    public void addGoodCarReturn(AddCarBean addCarBean) {

    }

    //商品参数    有问题
    private void attribute(List<ShopBean.DataBeanX.AttributeBean> attribute) {


    }

    private void issue(List<ShopBean.DataBeanX.IssueBean> issueList) {
        recyclerIssue.setLayoutManager(new LinearLayoutManager(ShopActivity.this));
        issueAdapter = new IssueAdapter(ShopActivity.this, issueList);
        recyclerIssue.setAdapter(issueAdapter);


    }


    private void banners(List<ShopBean.DataBeanX.GalleryBean> bannerList) {
        banner.setImages(bannerList).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ShopBean.DataBeanX.GalleryBean galleryBean = (ShopBean.DataBeanX.GalleryBean) path;
                Glide.with(ShopActivity.this).load(galleryBean.getImg_url()).into(imageView);
            }
        }).start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.img_car, R.id.txt_buy,R.id.txt_addCar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_car:
                setResult(1);
                finish();
                break;
            case R.id.txt_buy:
                txtBuy.setTag(1);
                int tag = (int) txtBuy.getTag();
                if(tag==1){
                    pops();
                    txtBuy.setTag(2);
                }
                txtBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int tag = (int) txtBuy.getTag();
                        if (tag == 2) {
                            addCar();
                            Toast.makeText(ShopActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                            popupWindow.dismiss();
                        }
                    }
                });

                break;
            case R.id.txt_addCar:

                break;
        }
    }

    int buyNumber = 0;//购买数量默认1

    public void pops(){
        if (info != null) {
            View join_view = LayoutInflater.from(this).inflate(R.layout.join_item, null);
            popupWindow = new PopupWindow(join_view, GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT);
            ImageView image_pop = join_view.findViewById(R.id.image_pop);
            TextView price_pop = join_view.findViewById(R.id.tv_price_pop);
            Button btn_jia = join_view.findViewById(R.id.btn_jia);
            TextView shul = join_view.findViewById(R.id.btn_shu);
            Button btn_jian = join_view.findViewById(R.id.btn_jian);
            TextView tv_back = join_view.findViewById(R.id.tv_back);
            Glide.with(this).load(info.getList_pic_url()).into(image_pop);
            price_pop.setText("￥" + info.getRetail_price() + "");
            String s = shul.getText().toString();

            popupWindow.showAtLocation(recyclerH5, Gravity.BOTTOM, 0, 130);
            f = 0;
            shu = 1;
            btn_jia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    f++;
                    buyNumber++;
                    if (f > 0) {
                        shu += f;
                        shul.setText(String.valueOf(f));

                    }

                }
            });
            btn_jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    f--;
                    buyNumber--;
                    if (f > 0) {
                        shu -= f;
                        shul.setText(String.valueOf(f));

                    }
                }
            });
            tv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
        }
    }

    public void addCar() {
        if (buyNumber <=0) {
            ToastUtils.s(this, getString(R.string.tips_buynumber));
            return;
        }
        if (shopBean.getData().getProductList().size() > 0) {
            int goodsId = this.shopBean.getData().getProductList().get(0).getGoods_id();
            int productid = this.shopBean.getData().getProductList().get(0).getId();
            Map<String, String> map = new HashMap<>();
            map.put("goodsId", String.valueOf(goodsId));
            map.put("number", String.valueOf(buyNumber));
            map.put("productId", String.valueOf(productid));
            presenter.addGoodCar(map);
        }
    }


}