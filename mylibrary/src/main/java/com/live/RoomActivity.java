package com.live;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.live.adapter.GainAdapter;
import com.live.base.BaseActivity;
import com.live.base.BaseAdapter;
import com.live.bean.BeginLiveBean;
import com.live.bean.GainBean;
import com.live.bean.LiveBean;
import com.live.bean.MyRoomBean;
import com.live.bean.RoomLiveUrlBean;
import com.live.interfaces.live.ILive;
import com.live.presenter.LivePresenter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomActivity extends BaseActivity<ILive.Presenter> implements ILive.View, View.OnClickListener {

    RecyclerView recyRoom;
    ImageView imgBack;
    ImageView imgStartLive;
    List<GainBean.DataBean> list;
    GainAdapter gainAdapter;
    private int myroomid;


    @Override
    protected int getLayout() {
        return R.layout.activity_room;
    }

    @Override
    protected ILive.Presenter createPrenter() {
        return new LivePresenter(this);
    }
    @Override
    protected void initData() {
        presenter.getGainReturn();
    }

    protected void initView() {
        recyRoom = findViewById(R.id.recy_room);
        imgBack = findViewById(R.id.img_back);
        imgStartLive = findViewById(R.id.img_startLive);

        imgStartLive.setOnClickListener(this);
        imgBack.setOnClickListener(this);

        list = new ArrayList<>();
        recyRoom.setLayoutManager(new GridLayoutManager(this, 2));
        gainAdapter = new GainAdapter(this, list);
        recyRoom.setAdapter(gainAdapter);
        gainAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Toast.makeText(RoomActivity.this, "直播", Toast.LENGTH_SHORT).show();
                int isopen = list.get(pos).getIsopen();
                if (isopen == 1) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("roomid", String.valueOf(list.get(pos).getId()));
                    presenter.RoomLiveUrlReturn(map);
                    Log.e("TAG", "itemClick: 拉流" );
                }else if (isopen == 2) {
                    //密码

                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.img_startLive) {
            presenter.MyRoomReturn();
        } else if (id == R.id.img_back) {
            finish();
        }
    }

    //创建房间
    @Override
    public void liveReturn(LiveBean liveBean) {
        Toast.makeText(this, "创建成功`", Toast.LENGTH_SHORT).show();
    }

    //开启直播
    @Override
    public void beginLiveReturn(BeginLiveBean beginLiveBean) {
        if(beginLiveBean.getErrno()==0){
            Log.i("TAG", "beginLiveReturn: 开启直播");
            if(!TextUtils.isEmpty(beginLiveBean.getData().getPush_url())){
                Intent intent = new Intent(RoomActivity.this, PushActivity.class);
                intent.putExtra("Push_url",beginLiveBean.getData().getPush_url());
                startActivity(intent);
            }
        }else{
            Log.e("TAG", "beginLiveReturn: "+beginLiveBean.getErrmsg() );
        }
    }

    //获取房间列表
    @Override
    public void getGainReturn(GainBean gainBean) {
        list.clear();
        List<GainBean.DataBean> data = gainBean.getData();
        if(data!=null && data.size()!=0){
            list.addAll(data);
            gainAdapter.notifyDataSetChanged();
        }

    }

    //获取自己房间列表
    @Override
    public void MyRoomReturn(MyRoomBean myRoomBean) {
        if(myRoomBean.getErrno() == 0){
            myroomid = myRoomBean.getData().getId();
            Log.e("TAG", "MyRoomReturn:列表id "+myroomid);
            presenter.beginLive("教你会玩",myroomid);
        }else{
            Log.e("TAG", "MyRoomReturn: "+myRoomBean.getErrmsg() );
        }

    }

    //获取房间播放地址
    @Override
    public void RoomLiveUrlReturn(RoomLiveUrlBean roomLiveUrlBean) {
        if (roomLiveUrlBean.getErrno() == 0) {
            if (!TextUtils.isEmpty(roomLiveUrlBean.getData().getPlay_url())) {
                Log.e("TAG", "RoomLiveUrlReturn: 跳转到xxx直播间");
                Intent intent = new Intent(this, LiveActivity.class);
                intent.putExtra("play_url", roomLiveUrlBean.getData().getPlay_url());
                Log.e("TAG", "RoomLiveUrlReturn: "+roomLiveUrlBean.getData().getPlay_url() );
                startActivityForResult(intent, 100);
            }
        }
    }
}
