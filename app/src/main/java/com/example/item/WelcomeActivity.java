package com.example.item;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager mViewpager;
    Disposable disposable;
    private ArrayList<View> list;
    private TextView mtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        list = new ArrayList<>();
        View p1 = LayoutInflater.from(this).inflate(R.layout.page1, null);
        View p2 = LayoutInflater.from(this).inflate(R.layout.page2, null);
        View p3 = LayoutInflater.from(this).inflate(R.layout.page3, null);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        mViewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = list.get(position);
                container.addView(view);
                return  view;
            }
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
        TextView mtime = p3.findViewById(R.id.time);
        TextView register = p3.findViewById(R.id.jump);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               if(position ==2){//在最后一页执行倒计时
                   //TODO            Interval操作符(有范围)：创建一个按照固定时间发射整数序列的Observable
                   disposable = Observable.intervalRange(0, 6, 0, 1, TimeUnit.SECONDS) //起始值，发送总数量，初始延迟，固定延迟
                           .subscribeOn(Schedulers.io())
                           .observeOn(AndroidSchedulers.mainThread())
                           .subscribe(new Consumer<Long>() {
                               @Override
                               public void accept(Long aLong) throws Exception {
                                   long time = 5 - aLong;
                                   mtime.setText(time+"s");
                                   if(time == 0){
                                       startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                                   }
                               }
                           });
               }else{
                   cancelCallback();
               }

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }
    //取消订阅的方法
    private void cancelCallback() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }


}