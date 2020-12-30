package com.example.item.ui.me;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.item.R;
import com.example.item.app.Constants;
import com.example.item.base.BaseActivity;
import com.example.item.bean.UserInfoBean;
import com.example.item.interfaces.Net.INetease;
import com.example.item.interfaces.Net.IPro;
import com.example.item.presenter.ProPresenter;
import com.example.item.utils.BitmapUtils;
import com.example.item.utils.GlideEngine;
import com.example.item.utils.SpUtils;
import com.example.item.utils.SystemUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PresonActivity extends BaseActivity<IPro.Presenter> implements IPro.View {

    //头像
    @BindView(R.id.iv_img_head)
    ImageView ivImgHead;
    //头像后面的小箭头
    @BindView(R.id.iv_heda_right)
    ImageView ivHedaRight;
    //头像一列
    @BindView(R.id.cons_avatar_head)
    ConstraintLayout consAvatarHead;
    //姓名
    @BindView(R.id.in_include_name)
    ConstraintLayout include_pro_name;
    //昵称
    @BindView(R.id.in_include_nikename)
    ConstraintLayout include_pro_nikename;
    //电话
    @BindView(R.id.in_include_tel)
    ConstraintLayout include_pro_tel;
    //输入框
    @BindView(R.id.txt_input)
    EditText txtInput;
    //提交按钮
    @BindView(R.id.btn_save)
    Button btnSave;
    //输入框一列
    @BindView(R.id.layout_input)
    ConstraintLayout layoutInput;

    String bucketName = "d-0813";
    String ossPoint = "http://oss-cn-beijing.aliyuncs.com";

    String key = " LTAI4G293XQTVckdLbzNMgij";  //appkey
    String secret = " ZCDhqzlt47uMQjVC2g9E54sHVgqGAu";  //密码

    private OSS ossClient;

    @Override
    protected int getLayout() {
        return R.layout.activity_preson;
    }

    @Override
    protected IPro.Presenter createPrenter() {
        return new ProPresenter();
    }

    @Override
    protected void initView() {
        initOss();
        TextView sub_name_left = include_pro_name.findViewById(R.id.tv_pre_sub_left);
        sub_name_left.setText("姓名");
        TextView sub_nikename_left = include_pro_nikename.findViewById(R.id.tv_pre_sub_left);
        sub_nikename_left.setText("昵称");
        TextView sub_tel_left = include_pro_tel.findViewById(R.id.tv_pre_sub_left);
        sub_tel_left.setText("电话");

        TextView sub_name_right = include_pro_name.findViewById(R.id.tv_pre_sub_right);
        sub_name_right.setText("陈丹");
        TextView sub_nikename_right = include_pro_nikename.findViewById(R.id.tv_pre_sub_right);
        sub_nikename_right.setText("dddddddddddd");
        String strname = sub_nikename_right.getText().toString();
        SpUtils.getInstance().setValue("name",strname);
        TextView sub_imgname_right = include_pro_tel.findViewById(R.id.tv_pre_sub_right);
        sub_imgname_right.setText("12345679");

        ImageView sub_right_img = include_pro_name.findViewById(R.id.tv_pre_sub_img);

        sub_right_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开输入状态
                showInput();
            }
        });
        String img = SpUtils.getInstance().getString("img");
        if (!TextUtils.isEmpty(img)) {
            Glide.with(this).load(img).apply(new RequestOptions().circleCrop()).into(ivImgHead);
        }

    }

    //初始化OSS
    private void initOss() {
        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider(key, secret, "");
        // 配置类如果不设置，会有默认配置。
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒。
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒。
        conf.setMaxConcurrentRequest(5); // 最大并发请求数，默认5个。
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次。
        ossClient = new OSSClient(getApplicationContext(), ossPoint, credentialProvider);

    }

    private void showInput() {
        //显示布局
        layoutInput.setVisibility(View.VISIBLE);
        //获取焦点
        txtInput.setFocusable(true);
        //打开软键盘
        SystemUtils.openSoftKeyBoard(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PresonReturn(UserInfoBean userInfoBean) {
        if (userInfoBean != null) {
            SystemUtils.closeSoftKeyBoard(this);
            layoutInput.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_img_head, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_img_head:
                openPhotos();
                break;
            case R.id.btn_save:
                String nickname = txtInput.getText().toString();
                if (!TextUtils.isEmpty(nickname)) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("nickname", nickname);
                    presenter.Preson(map);
                }
                break;
        }
    }

    private void openPhotos() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine()) // Please refer to the Demo GlideEngine.java
                .maxSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.MULTIPLE)
                .forResult(PictureConfig.CHOOSE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                if (selectList.size() == 0) return;
                //获取本地图片的选择地址，上传到服务器

                //把选中的图片插入到列表
                try {
                    for (int i = 0; i < selectList.size(); i++) {
                        //头像的压缩和二次采样
                        Bitmap scaleBitmp = BitmapUtils.getScaleBitmap(selectList.get(i).getPath(), Constants.HEAD_WIDTH, Constants.HEAD_HEIGHT);
                        //Bitmap转uri
                        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), scaleBitmp, null, null));
                        //uri转字符串
                        String path = getRealPathFromUri(this, uri);
                        uploadHead(path);//上传头像
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);

        }
    }

    private void uploadHead(String path) {
        String uid = SpUtils.getInstance().getString("uid");
        //String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
        String fileName = uid + "/" + System.currentTimeMillis() + Math.random() * 10000 + ".png";
        PutObjectRequest put = new PutObjectRequest(bucketName, fileName, path);
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                //上次进度
                Log.i("oss_upload", currentSize + "/" + totalSize);
                // 进度百分比的计算
                // int p = (int) (currentSize/totalSize*100);
                if (currentSize == totalSize) {
                    //完成
                    String headUrl = request.getUploadFilePath();
                    //
                    Log.i("HeadUrl", headUrl);
                    //request.getUploadFilePath()
                }

            }
        });
        OSSAsyncTask task = ossClient.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                Log.d("PutObject", "UploadSuccess");
                Log.d("ETag", result.getETag());
                Log.d("RequestId", result.getRequestId());
                //成功的回调中读取相关的上传文件的信息  生成一个url地址
                String url = ossClient.presignPublicObjectURL(request.getBucketName(), request.getObjectKey());
                //TODO 刷新显示到界面上
                updateHead(url);
                //调用服务器接口，把url上传到服务器的接口
                SpUtils.getInstance().setValue("img", url);
                HashMap<String, String> map = new HashMap<>();
                map.put("avatar", url);
                presenter.Preson(map);
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // 请求异常。
                if (clientExcepion != null) {
                    // 本地异常，如网络异常等。
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常。
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }
        });
    }

    //TODO 上传头像
    private void updateHead(String url) {
        ivImgHead.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(ivImgHead).load(url).apply(new RequestOptions().circleCrop()).into(ivImgHead);
            }
        });
    }

    //TODO uri转字符串的方法
    public static String getRealPathFromUri(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}