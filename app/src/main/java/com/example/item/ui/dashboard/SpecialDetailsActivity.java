package com.example.item.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.app.MyApp;
import com.example.item.base.BaseActivity;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.SpCommentBean;
import com.example.item.bean.SpDetailsBean;
import com.example.item.bean.SpecialBean;
import com.example.item.bean.SpecialDetailsButtomBean;
import com.example.item.interfaces.Net.ISpecial;
import com.example.item.presenter.SpecialPresenter;
import com.example.item.ui.dashboard.comment.DiscussActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialDetailsActivity extends BaseActivity<ISpecial.Presenter> implements ISpecial.View {

    @BindView(R.id.mRlv_special_details_img)
    RecyclerView mRlv_Img;
    @BindView(R.id.iv_special_details_leave_img)
    ImageView iv_Leave_Img;
    @BindView(R.id.mCl_special_details)
    ConstraintLayout mCl_Details;
    @BindView(R.id.mRlv_special_details_leave)
    RecyclerView mRlv_Leave;
    @BindView(R.id.btn_special_details_move)
    Button btn_Move;
    @BindView(R.id.mRlv_special_details_list)
    RecyclerView mRlv_List;
    private int id;
    private SpecialDetailsAdapter specialDetailsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_special_details;
    }


    @Override
    protected void initView() {
        iv_Leave_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpecialDetailsActivity.this, DiscussActivity.class);
                startActivityForResult(intent,100);
            }
        });

    }

    @Override
    protected ISpecial.Presenter createPrenter() {
        return new SpecialPresenter(this);
    }


    @Override
    protected void initData() {
        presenter = new SpecialPresenter(this);
        id = (int) MyApp.getMap().get("specialId");
        //详情
        presenter.getgSpDetails(id);
        //评论
        presenter.getSpComment(getMap());
        //底部数据
        presenter.getSpDetailsButtom(id);

    }

    private HashMap<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("valueId", String.valueOf(id));
        map.put("typeId", String.valueOf(1));
        map.put("size", String.valueOf(5));
        return map;
    }

    //专题数据
    @Override
    public void getSpecial(SpecialBean specialBean) {

    }

    //专题详情
    @Override
    public void getgSpDetails(SpDetailsBean spDetailsBean) {
        SpDetailsBean.DataBean data = spDetailsBean.getData();
        initgetImage(data.getContent());

    }

    //专题评论
    @Override
    public void getSpComment(SpCommentBean spCommentBean) {
        List<SpCommentBean.DataBeanX.DataBean> data = spCommentBean.getData().getData();
        if (spCommentBean.getData().getData() != null && spCommentBean.getData().getData().size() > 0) {
            mRlv_Leave.setLayoutManager(new LinearLayoutManager(this));
            mRlv_Leave.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
            SpecialDetailsCommentAdapter specialDetailsCommentAdapter = new SpecialDetailsCommentAdapter(this, data);
            mRlv_Leave.setAdapter(specialDetailsCommentAdapter);
            specialDetailsCommentAdapter.notifyDataSetChanged();
            btn_Move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SpecialDetailsActivity.this, SpecialCommentActivity.class);
                    startActivity(intent);
                }
            });

        } else {
            btn_Move.setVisibility(View.GONE);
        }
    }

    //专题底部数据
    @Override
    public void getSpDetailsButtom(SpecialDetailsButtomBean specialDetailsButtomBean) {
        List<SpecialDetailsButtomBean.DataBean> data = specialDetailsButtomBean.getData();

        mRlv_List.setLayoutManager(new LinearLayoutManager(this));
        SpecialDetailsButtomAdapter specialDetailsButtomAdapter = new SpecialDetailsButtomAdapter(this, data);
        mRlv_List.setAdapter(specialDetailsButtomAdapter);
        specialDetailsButtomAdapter.notifyDataSetChanged();

        specialDetailsButtomAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = data.get(pos).getId();
                Intent intent = new Intent(SpecialDetailsActivity.this,SpecialDetailsActivity.class);
                presenter.getgSpDetails(id);
                presenter.getSpDetailsButtom(id);
                HashMap<String, String> map = new HashMap<>();
                map.put("valueId",String.valueOf(id));
                map.put("typeId",String.valueOf(1));
                map.put("size",String.valueOf(5));
                presenter.getSpComment(map);
                startActivity(intent);


            }
        });
    }

    //TODO H5分割图片
    private void initgetImage(String content) {
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(content);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            int start = word.indexOf("\"") + 1;
            int end = word.indexOf(".jpg");
            //判断图片的格式
            if (end > 0) {
                String url = word.substring(start, end);
                if (url != null) {
                    url = "http:" + url + ".jpg";
                    list.add(url);
                } else {
                    return;
                }
            } else {
                int end1 = word.indexOf(".png");
                String url = word.substring(start, end1);
                if (url != null) {
                    url = url + ".png";
                    list.add(url);
                } else {
                    return;
                }
            }
        }
        mRlv_Img.setLayoutManager(new LinearLayoutManager(this));
        specialDetailsAdapter = new SpecialDetailsAdapter(this, list);
        mRlv_Img.setAdapter(specialDetailsAdapter);
        specialDetailsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}