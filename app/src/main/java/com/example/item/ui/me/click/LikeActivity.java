package com.example.item.ui.me.click;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.base.BaseActivity;
import com.example.item.interfaces.IBasePresenter;

import java.util.ArrayList;
import io.realm.Realm;

import io.realm.RealmResults;

public class LikeActivity extends BaseActivity {

    private RecyclerView mLikeRecycler;
    private ArrayList<LikeBean> likeBeans;
    private LikeAdapter likeAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_like;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    protected void initView() {
        mLikeRecycler = (RecyclerView) findViewById(R.id.recycler_like);
        likeBeans = new ArrayList<>();
        mLikeRecycler.setLayoutManager(new LinearLayoutManager(this));
        mLikeRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        likeAdapter = new LikeAdapter(this, likeBeans);
        mLikeRecycler.setAdapter(likeAdapter);

        RealmResults<LikeBean> users = Realms.getRealm(this).where(LikeBean.class)
                .findAll();
        likeBeans.addAll(users);
        likeAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }
}