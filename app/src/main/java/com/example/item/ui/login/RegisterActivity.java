package com.example.item.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.item.R;
import com.example.item.base.BaseActivity;
import com.example.item.bean.RegisterBean;
import com.example.item.interfaces.Net.IRegister;
import com.example.item.presenter.RegisterPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IRegister.View {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_newpwd)
    EditText etNewpwd;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private String name;
    private String pwd;


    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenter createPrenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(etName.getText().toString())){
                    if (!TextUtils.isEmpty(etPwd.getText().toString())){
                        if (!TextUtils.isEmpty(etNewpwd.getText().toString())){
                            if (etPwd.getText().toString().equals(etNewpwd.getText().toString())){
                                name =etName.getText().toString();
                                pwd =etPwd.getText().toString();
                                initData();
                                Intent intent = getIntent();
                                intent.putExtra("name", name);
                                intent.putExtra("pwd", pwd);
                                setResult(100,intent);
                                finish();
                            }else{
                                Toast.makeText(RegisterActivity.this, "两次密码不一致,请重新输入", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "请再次密码", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void initData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", name);
        map.put("password", pwd);
        presenter.Register(map);

    }

    @Override
    public void RegisterReturn(RegisterBean registerBean) {

    }
}