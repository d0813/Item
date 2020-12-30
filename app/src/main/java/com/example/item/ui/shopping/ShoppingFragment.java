package com.example.item.ui.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.R;
import com.example.item.base.BaseAdapter;
import com.example.item.base.BaseFragment;
import com.example.item.bean.DeleteCarBean;
import com.example.item.bean.UpdateCarBean;
import com.example.item.bean.login.CarBean;
import com.example.item.interfaces.ICar;
import com.example.item.presenter.CarPresenter;
import com.example.item.ui.home.HotGoodsAdapter;
import com.example.item.ui.shopping.adapter.GoodsAdapter;
import com.example.item.utils.SpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingFragment extends BaseFragment<ICar.Presenter> implements ICar.View,View.OnClickListener {


    @BindView(R.id.recy_good)
    RecyclerView recyGood;
    @BindView(R.id.checkbox_all)
    CheckBox checkboxAlll;
    @BindView(R.id.txt_totalPrice)
    TextView txtTotalPrice;
    @BindView(R.id.txt_edit)
    TextView txtEdit;
    @BindView(R.id.txt_submit)
    TextView txtSubmit;
    private CarBean carBean;

    private boolean isEdit;//是否是编辑状态


    private GoodsAdapter goodsAdapter;
    private List<CarBean.DataBean.CartListBean> list;

    @Override
    protected int getLayout() {
        return R.layout.fragment_shopping;
    }


    @Override
    protected ICar.Presenter createPrenter() {
        return new CarPresenter();
    }



    @Override
    protected void initView() {
      //  ButterKnife.bind(getActivity());
//        checkboxAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (isEdit) {
//                    updateGoodSelectStateEdit(b);
//                } else {
//                    updateGoodSelectStateOrder(b);
//                }
//            }
//        });
        checkboxAlll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG","checkboxall:"+checkboxAlll.isChecked());
                boolean bool = checkboxAlll.isChecked();
                if(isEdit){
                    updateGoodSelectStateEdit(bool);
                }else{
                    updateGoodSelectStateOrder(bool);
                }
            }
        });
        txtEdit.setOnClickListener(this);
        txtSubmit.setOnClickListener(this);


    }



    @Override
    protected void initData() {
        list = new ArrayList<>();
        goodsAdapter = new GoodsAdapter(mContext, list);
        recyGood.setLayoutManager(new LinearLayoutManager(mContext));
        recyGood.setAdapter(goodsAdapter);

        String token = SpUtils.getInstance().getString("token");
        if (!TextUtils.isEmpty(token)) {
            presenter.getCarList();
        } else {
            gotoLogin();
        }
        /**
         * 监听条目元素点击的时候的接口回调
         */

        goodsAdapter.addItemViewClick(new BaseAdapter.IItemViewClick() {
            @Override
            public void itemViewClick(int id, Object data) {
                for(CarBean.DataBean.CartListBean item:list){
                    if(item.getId() == id){
                        if(!isEdit){
                            item.selectOrder = (boolean) data;
                        }else{
                            item.selectEdit = (boolean) data;
                        }
                        break;
                    }
                }
                boolean isSelectAll;
                if(!isEdit){
                    isSelectAll = totalSelectOrder();
                }else{
                    isSelectAll = totalSelectEdit();
                }
                checkboxAlll.setChecked(isSelectAll);

            }
        });
        // 监听编辑状态下item的数据变化
        goodsAdapter.setUpdateItem(new GoodsAdapter.UpdateItem() {
            @Override
            public void updateItemDate(CarBean.DataBean.CartListBean data) {
                HashMap<String, String> map = new HashMap<>();
                map.put("goodsId", String.valueOf(data.getGoods_id()));
                map.put("productId", String.valueOf(data.getProduct_id()));
                map.put("id", String.valueOf(data.getId()));
                map.put("number", String.valueOf(data.getNumber()));
                presenter.updateCar(map);
                totalSelectEdit();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.getCarList();
    }

    @Override
    public void getCarListReturn(CarBean carBean) {
        this.carBean = carBean;
        list.clear();
        list.addAll(carBean.getData().getCartList());
        goodsAdapter.notifyDataSetChanged();
    }
    /**
     * 更新接口之后的返回
     * @param result
     */
    @Override
    public void updateCarReturn(UpdateCarBean result) {
        Log.i("TAG", result.toString());

        for (UpdateCarBean.DataBean.CartListBean item : result.getData().getCartList()) {
            updateCartListBeanNumberById(item.getId(), item.getNumber());

        }
        carBean.getData().getCartTotal().setGoodsCount(result.getData().getCartTotal().getGoodsCount());
        carBean.getData().getCartTotal().setGoodsAmount(result.getData().getCartTotal().getGoodsAmount());
        goodsAdapter.notifyDataSetChanged();
        totalSelectEdit();
    }

    //刷新购物车列表的数据
    private void updateCartListBeanNumberById(int id, int number) {
        for (CarBean.DataBean.CartListBean item:list){
            if(item.getId() ==id){
                item.setNumber(number);
                break;

            }
        }
    }
    /**
     * 删除购物车列表返回
     * @param result
     */
    @Override
    public void deleteCarReturn(DeleteCarBean result) {
        Log.i("TAG","deleteCar:"+result.toString());
        //通过购物车返回的最新数据，同步本地列表中的数据
        int index,lg=list.size();
        for(index=0;index<lg; index++){
            CarBean.DataBean.CartListBean item = list.get(index);
            boolean bool = deleteCarListById(result.getData().getCartList(),item.getId());
            Log.i("TAG","delete bool:"+bool +" item:"+item.getId());
            if(bool){
                list.remove(index);
                index--;
                lg--;
            }

        }
        goodsAdapter.notifyDataSetChanged();
        totalSelectEdit();
    }
    /**
     * 判断当前的本地列表的购物车列表数据是否在返回的最新列表中存在
     * @param list
     * @param carId
     * @return
     */
    private boolean deleteCarListById(List<DeleteCarBean.DataBean.CartListBean> list ,int carId){
        for(DeleteCarBean.DataBean.CartListBean item:list){
            if(item.getId() == carId){
                return false;
            }
        }
        return true;
    }

    /**
     * 下单状态的数据刷新
     *
     * @param bool
     */
    private void updateGoodSelectStateOrder(boolean bool) {
        for (CarBean.DataBean.CartListBean item : list) {
            item.selectOrder = bool;
        }
        totalSelectOrder();
        goodsAdapter.notifyDataSetChanged();
    }
    /**
     * 编辑状态下的数据刷新
     *
     * @param bool
     */
    private void updateGoodSelectStateEdit(boolean bool) {
        for (CarBean.DataBean.CartListBean item : list) {
            item.selectEdit = bool;
        }
        totalSelectOrder();
        goodsAdapter.notifyDataSetChanged();
    }



    /**
     * 下单状态下的总数和价格的计算
     */
    private boolean totalSelectOrder() {
        int num = 0;
        int totalPrice = 0;
        boolean isSelectAll = true;
        for (CarBean.DataBean.CartListBean item : list) {
            if (item.selectOrder) {
                num += item.getNumber();
                totalPrice += item.getNumber()*item.getRetail_price();
            } else {
                if (isSelectAll) {
                    isSelectAll = false;
                }
            }
        }
        String strAll = "全选($)";
        strAll = strAll.replace("$",String.valueOf(num));
        checkboxAlll.setText(strAll);
        txtTotalPrice.setText("￥"+totalPrice);
        Log.i("TAG","num: "+num+"price："+totalPrice);
        return isSelectAll;
    }
    /**
     * 编辑状态下的
     */
    private boolean totalSelectEdit() {
        int num = 0;
        boolean isSelectAll = true;
        for (CarBean.DataBean.CartListBean item : list)
            if (item.selectEdit) {
                num += item.getNumber();
            } else {
                if (isSelectAll) {
                    isSelectAll = false;
                }
            }
        String strAll = "全选($)";
        strAll = strAll.replace("$", String.valueOf(num));
        checkboxAlll.setText(strAll);
        return isSelectAll;
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_edit:
                changEdit();
                break;
            case R.id.txt_submit:
                submit();
                break;
        }
    }
    //修改编辑和完成的状态
    private void changEdit() {
        if("编辑".equals(txtEdit.getText().toString())){
            txtEdit.setText("完成");
            txtSubmit.setText("删除所选");
            isEdit = true;
            txtTotalPrice.setVisibility(View.GONE);
        }else if("完成".equals(txtEdit.getText().toString())){
            txtEdit.setText("编辑");
            txtSubmit.setText("下单");
            isEdit = false;
            updateGoodSelectStateEdit(false);
            txtTotalPrice.setVisibility(View.VISIBLE);
        }
        goodsAdapter.setEditState(isEdit);
        goodsAdapter.notifyDataSetChanged();

    }
//提交

    private void submit() {

        if ("下单".equals(txtSubmit.getText().toString())) {
            //下单
            Intent intent = new Intent(getActivity(), PaymentActivity.class);
            startActivity(intent);
        } else if ("删除所选".equals(txtSubmit.getText().toString())) {
            //删除购物车所选数据
            deleteCar();


        }
    }
    /**
     *删除所有选中的商品数据
     */
    private void deleteCar() {
        StringBuilder sb = new StringBuilder();
        for(CarBean.DataBean.CartListBean item:list){
            if(item.selectEdit){
                sb.append(item.getProduct_id());
                sb.append(",");
            }
        }
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length()-1);
        }
        Log.i("TAG",sb.toString());
        presenter.deleteCar(sb.toString());

    }

}

