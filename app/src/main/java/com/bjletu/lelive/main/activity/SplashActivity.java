package com.bjletu.lelive.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.bjletu.lelive.MainActivity;
import com.bjletu.lelive.R;
import com.bjletu.lelive.base.BaseActivity;
import com.bjletu.lelive.util.SharedPreferencesUtils;

public class SplashActivity extends BaseActivity {

    public static void start(BaseActivity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, SplashActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        fullScreen();  //全屏
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onEvent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean liompei = SharedPreferencesUtils.getBoolean("liompei", false);
                if (liompei) {
                    toMain();
                } else {
                    toLogin();
                }
            }
        }, 1000);
    }

    private void toMain() {
        MainActivity.start(this);
        finish();
    }

    private void toLogin() {
        LoginActivity.start(this);
        finish();
    }

}
