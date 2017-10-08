package com.bjletu.lelive.main.activity;

import android.content.Intent;
import android.os.Bundle;

import com.bjletu.lelive.R;
import com.bjletu.lelive.base.BaseActivity;

/**
 * Created by Liompei
 * Time 2017/10/8 22:36
 * 1137694912@qq.com
 * remark:设置
 */
public class SettingActivity extends BaseActivity {

    public static void start(BaseActivity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, SettingActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        getToolbar("设置", true);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onEvent() {

    }
}
