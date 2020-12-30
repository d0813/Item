package com.example.item.ui.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.bean.login.CarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.site)
    TextView site;
    @BindView(R.id.tv_order_form_coupon)
    TextView tvOrderFormCoupon;
    @BindView(R.id.iv_order_form_z)
    ImageView ivOrderFormZ;
    @BindView(R.id.tv_totalname)
    TextView tvTotalname;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_moneyname)
    TextView tvMoneyname;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_salename)
    TextView tvSalename;
    @BindView(R.id.tv_sale)
    TextView tvSale;
    @BindView(R.id.recycler_total)
    RecyclerView recyclerTotal;
    @BindView(R.id.tv_order_form_payment)
    TextView tvOrderFormPayment;
    @BindView(R.id.tv_moneys)
    TextView mMoney;
    @BindView(R.id.tv_order_form_add)
    TextView tvOrderFormAdd;
    @BindView(R.id.layout_order_form)
    ConstraintLayout layoutOrderForm;
    @BindView(R.id.cons)
    ConstraintLayout cons;
    private List<CarBean.DataBean.CartListBean> list;
    private PayAdapter payAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        String str = null;

        for (int i = 0; i < list.size(); i++) {
            str+=(""+Integer.valueOf(list.get(i).getRetail_price()*list.get(i).getNumber()));

        }
        tvTotal.setText("￥" + str);
        mMoney.setText("" + str);
        recyclerTotal.setLayoutManager(new LinearLayoutManager(this));
        payAdapter = new PayAdapter(this, list);
        recyclerTotal.setAdapter(payAdapter);


    }

    @OnClick(R.id.cons)
    public void onViewClicked() {
        Intent intent = new Intent(PaymentActivity.this,Address_AddActivity.class);
        startActivity(intent);
    }
}