package com.example.item.ui.me;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.item.R;
import com.example.item.base.BaseFragment;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.ui.login.LoginActivity;
import com.example.item.ui.me.click.LikeActivity;
import com.example.item.utils.SpUtils;
import com.luck.picture.lib.tools.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends BaseFragment {


    @BindView(R.id.retures)
    ImageView retures;
    @BindView(R.id.me_order)
    LinearLayout meOrder;
    @BindView(R.id.me_discounts)
    LinearLayout meDiscounts;
    @BindView(R.id.me_gift)
    LinearLayout meGift;
    @BindView(R.id.me_like)
    LinearLayout meLike;
    @BindView(R.id.me_track)
    LinearLayout meTrack;
    @BindView(R.id.me_vip)
    LinearLayout meVip;
    @BindView(R.id.me_site)
    LinearLayout meSite;
    @BindView(R.id.me_safyty)
    LinearLayout meSafyty;
    @BindView(R.id.me_service)
    LinearLayout meService;
    @BindView(R.id.me_help)
    LinearLayout meHelp;
    @BindView(R.id.me_idea)
    LinearLayout meIdea;
    @BindView(R.id.line5)
    LinearLayout line5;
    @BindView(R.id.iv_userhead)
    ImageView userhead;
    @BindView(R.id.tv_username)
    TextView username;

    public static final int LOGIN_ME = 10001; //登录成功的回传值
    public static final int LOGINOUT_ME = 10002;
    @BindView(R.id.log_out)
    Button logOut;

    @Override
    protected int getLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        String token = SpUtils.getInstance().getString("token");
        if (!TextUtils.isEmpty(token)) {
            isLogin(true);
        } else {
            isLogin(false);
        }

    }

    private void isLogin(boolean b) {
        if (b) {
            String usernames = SpUtils.getInstance().getString("name");
            String nicknames = SpUtils.getInstance().getString("nickname");
            String avatar = SpUtils.getInstance().getString("avatar");
            if (!TextUtils.isEmpty(usernames)) {
                username.setText(usernames);
            } else {

            }

            String img = SpUtils.getInstance().getString("img");
            if (!TextUtils.isEmpty(img)) {
                Glide.with(this).load(img).apply(new RequestOptions().circleCrop()).into(userhead);
            }
        }
    }

    @OnClick({R.id.retures, R.id.me_order, R.id.me_discounts, R.id.me_gift, R.id.me_like, R.id.me_track, R.id.me_vip, R.id.me_site, R.id.me_safyty, R.id.me_service, R.id.me_help, R.id.me_idea, R.id.line5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //点击小箭头
            case R.id.retures:
                String token = SpUtils.getInstance().getString("token");
                if (!TextUtils.isEmpty(token)) {
                    Intent intent1 = new Intent(getActivity(), PresonActivity.class);
                    startActivityForResult(intent1, 100);
                } else {
                    Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent2);
                }

                break;
            case R.id.me_order:
                break;
            case R.id.me_discounts:
                break;
            case R.id.me_gift:
                break;
            case R.id.me_like:
                Intent intent = new Intent(getActivity(), LikeActivity.class);
                startActivity(intent);
                break;
            case R.id.me_track:
                break;
            case R.id.me_vip:
                break;
            case R.id.me_site:
                break;
            case R.id.me_safyty:
                break;
            case R.id.me_service:
                break;
            case R.id.me_help:
                break;
            case R.id.me_idea:
                break;
            case R.id.line5:
                break;
        }
    }

    @OnClick(R.id.log_out)
    public void onViewClicked() {
        String token = SpUtils.getInstance().getString("token");
        if(!TextUtils.isEmpty(token)){
            openUserInfoDetail();
        }else{
            openLogin();
        }

    }
    //TODO 打开登录页面
    private void openLogin() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivityForResult(intent, LOGIN_ME);
    }
    //TODO 打开用户信息
    private void openUserInfoDetail() {
        ToastUtils.s(getActivity(), "此用户已登录");
    }


}

