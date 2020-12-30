package com.example.item.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.item.R;
import com.example.item.base.BaseActivity;
import com.example.item.bean.login.LoginBean;
import com.example.item.interfaces.Net.ILoging;
import com.example.item.presenter.LoginPresenter;
import com.example.item.utils.SpUtils;
import com.luck.picture.lib.tools.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<ILoging.Presenter> implements ILoging.View, View.OnClickListener {

    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.input_pw)
    EditText inputPw;
    @BindView(R.id.img_pw)
    ImageView imgPw;
    @BindView(R.id.layout_pw)
    FrameLayout layoutPw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private String username;
    private String pw;
    private TextView mRegister;


    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected ILoging.Presenter createPrenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        imgPw.setTag(1);
        mRegister = (TextView) findViewById(R.id.register);
        mRegister.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        //presenter.login(username,pw);

    }

    @Override
    public void loginReturn(LoginBean loginBean) {
        if (!TextUtils.isEmpty(loginBean.getData().getToken())) {
            SpUtils.getInstance().setValue("token", loginBean.getData().getToken());
            SpUtils.getInstance().setValue("uid", loginBean.getData().getUserInfo().getUid());
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_pw, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_pw:
                int tag = (int) imgPw.getTag();
                if (tag == 1) {
                    imgPw.setImageResource(R.mipmap.ic_pw_open);
                    imgPw.setTag(2);
                    inputPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    imgPw.setImageResource(R.mipmap.ic_pw_close);
                    imgPw.setTag(1);
                    inputPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        username = inputUsername.getText().toString();
        pw = inputPw.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pw)) {
            presenter.login(username, pw);
        } else {
            ToastUtils.s(this, getString(R.string.tips_login));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}