package com.example.item.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.item.R;
import com.luck.picture.lib.photoview.PhotoView;


public class TxtUtils {

    public static void setTextView(TextView textView,String word){
        if(textView != null && !TextUtils.isEmpty(word)){
            textView.setText(word);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setConstraintLayoutView(ConstraintLayout constraintLayout , Context context, int labelId){
        if(constraintLayout != null ){

            if (labelId%2==0){
                constraintLayout.setBackgroundDrawable(context.getDrawable(R.color.colorAccent));
            }else if(labelId%3==1){
                constraintLayout.setBackgroundDrawable(context.getDrawable(R.color.colorPrimary));
            }else {
                constraintLayout.setBackgroundDrawable(context.getDrawable(R.color.colorPrimaryDark));
            }

        }
    }
    //手势
    public static void setPhotoView(Context context, PhotoView photoView, String image) {
        if (photoView != null && !TextUtils.isEmpty(image)) {
            Glide.with(context).load(image)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                    .into(photoView);
        }
    }


}
