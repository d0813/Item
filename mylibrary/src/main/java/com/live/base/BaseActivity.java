package com.live.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.live.interfaces.IBasePresenter;
import com.live.interfaces.IBaseView;
import com.live.util.ActivityManager2;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected  P presenter;
    Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = getLayout();
        if(layout <= 0){
            new RuntimeException("layout id not allow 0 or <0");
        }else{
            setContentView(getLayout());
        }
        unbinder = ButterKnife.bind(this);
        initView();
        presenter = createPrenter();
        if(presenter != null){
            presenter.attachView(this);
        }
        initData();
    }

    protected abstract int getLayout();
    protected abstract P createPrenter();
    protected abstract void initView();
    protected abstract  void initData();
    @Override
    public void showLoading(int visible) {

    }

    @Override
    public void show(String tips) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            presenter.unAttachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }
}

