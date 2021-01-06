package com.example.item.ui.me.click;

import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.base.BaseActivity;
import com.example.item.interfaces.IBasePresenter;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;

import io.realm.Realm;

import io.realm.RealmResults;

public class LikeActivity extends BaseActivity {

    private SwipeMenuRecyclerView mLikeRecycler;
    private ArrayList<LikeBean> likeBeans;
    private LikeAdapter likeAdapter;
    private RealmResults<LikeBean> users;

    @Override
    protected int getLayout() {
        return R.layout.activity_like;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    protected void initView() {
        mLikeRecycler = (SwipeMenuRecyclerView) findViewById(R.id.recycler_favorites);
        likeBeans = new ArrayList<>();
        mLikeRecycler.setLayoutManager(new LinearLayoutManager(this));
        //设置菜单创建器
        mLikeRecycler.setSwipeMenuCreator(swipeMenuCreator);
        //点击事件
        mLikeRecycler.setSwipeMenuItemClickListener(menuItemClickListener);
        mLikeRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        likeAdapter = new LikeAdapter(this, likeBeans);
        mLikeRecycler.setAdapter(likeAdapter);

        users = Realms.getRealm(this).where(LikeBean.class)
                .findAll();
        likeBeans.addAll(users);
        likeAdapter.notifyDataSetChanged();
    }

    //创建侧滑菜单
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            SwipeMenuItem swipeMenuItem = new SwipeMenuItem(LikeActivity.this)
                    .setImage(R.mipmap.icon_delete)
                    .setWidth(144)//设置
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);//高（MATCH_PARENT意为Item多高侧滑菜单多高 （推荐使用）;
            swipeRightMenu.addMenuItem(swipeMenuItem);
        }
    };
    //创建侧滑菜单的点击事件
    private SwipeMenuItemClickListener menuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {

            //删除数据库
            Realms.getRealm(LikeActivity.this).executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                    menuBridge.closeMenu();
                    //在menuBridge中我们可以得到侧滑的这一项item的position (menuBridge.getAdapterPosition())
                    int adapterPosition = menuBridge.getAdapterPosition();
                    users.get(adapterPosition).deleteFromRealm();
                    likeBeans.remove(adapterPosition);
                }
            });
            likeAdapter.notifyDataSetChanged();
        }
    };


    @Override
    protected void initData() {

    }
}