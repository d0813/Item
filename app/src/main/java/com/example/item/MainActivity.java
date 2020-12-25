package com.example.item;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.item.presenter.LoginPresenter;
import com.example.item.ui.dashboard.SpecialFragment;
import com.example.item.ui.home.HomeFragment;
import com.example.item.ui.login.LoginActivity;
import com.example.item.ui.me.MyFragment;
import com.example.item.ui.notifications.ClassifyFragment;
import com.example.item.ui.shopping.ShoppingFragment;
import com.example.item.utils.SpUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_special, R.id.navigation_classify, R.id.navigation_shopping, R.id.navigation_me)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//     //   NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        initView();

    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new ShoppingFragment());
        fragments.add(new MyFragment());
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

        });
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setText("首页").setIcon(R.drawable.ic_menu_choice_nor);
        tablayout.getTabAt(1).setText("专题").setIcon(R.drawable.ic_menu_topic_nor);
        tablayout.getTabAt(2).setText("分类").setIcon(R.drawable.ic_menu_sort_nor);
        tablayout.getTabAt(3).setText("购物车").setIcon(R.drawable.ic_menu_shoping_nor);
        tablayout.getTabAt(4).setText("我的").setIcon(R.drawable.ic_menu_me_nor);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==3){
                    String token = SpUtils.getInstance().getString("token");
//                    String token="";
                    if(token.isEmpty()){
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivityForResult(intent,100);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode==1){
            viewpager.setCurrentItem(3);
        }
    }
}