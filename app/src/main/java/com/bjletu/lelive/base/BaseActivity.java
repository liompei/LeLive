package com.bjletu.lelive.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bjletu.lelive.App;
import com.bjletu.lelive.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Liompei
 * Time 2017/8/8 21:36
 * 1137694912@qq.com
 * remark:
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    protected BaseActivity mBaseActivity;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().addActivity(this);
        mBaseActivity = this;
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        unbinder = ButterKnife.bind(this);

        initViews(savedInstanceState);
        initData();
        onEvent();
    }

    protected <T extends View> T findView(int resId) {
        return (T) (findViewById(resId));
    }

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initData();

    public abstract void onEvent();


    protected Toolbar getToolbar(CharSequence title, boolean showHomeAsUp) {
        Toolbar toolbar = findView(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        return toolbar;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        App.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
    }

    private ProgressDialog mProgressDialog = null;

    protected void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("请稍后...");
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }



    protected void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    protected void fullScreen(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
    }

    protected void toast(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.getInstance(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //*****************************网络请求**************

}
