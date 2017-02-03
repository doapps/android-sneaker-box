package com.example.win10.validator;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by WIN10 on 19/12/2016.
 */

public class StatusBarUtil {

    public static void setStatusBarColor(Context context,int RidColor){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ((AppCompatActivity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            ((AppCompatActivity)context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ((AppCompatActivity)context).getWindow().setStatusBarColor(context.getResources().getColor(RidColor));
            ((AppCompatActivity)context).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}
