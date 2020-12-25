package com.example.item.ui.me;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.item.R;
import com.example.item.base.BaseFragment;
import com.example.item.interfaces.IBasePresenter;
import com.example.item.ui.me.click.LikeActivity;

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

    }

    @OnClick({R.id.retures, R.id.me_order, R.id.me_discounts, R.id.me_gift, R.id.me_like, R.id.me_track, R.id.me_vip, R.id.me_site, R.id.me_safyty, R.id.me_service, R.id.me_help, R.id.me_idea, R.id.line5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.retures:
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
}

