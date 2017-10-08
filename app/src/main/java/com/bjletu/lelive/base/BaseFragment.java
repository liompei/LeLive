package com.bjletu.lelive.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bjletu.lelive.R;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Liompei
 * Time 2017/8/9 21:54
 * 1137694912@qq.com
 * remark:
 */

public abstract class BaseFragment extends RxFragment {

    private View parentView;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, parentView);
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(savedInstanceState);
        initData();
        onEvent();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    protected <T extends View> T findView(int resId) {
        return (T) (parentView.findViewById(resId));
    }

    public abstract
    @LayoutRes
    int getLayoutResId();

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void onEvent();

    protected Toolbar getToolbar(CharSequence title, boolean showHomeAsUp) {
        Toolbar toolbar = findView(R.id.toolbar);
        toolbar.setTitle(title);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getBaseActivity().onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    protected void toast(final String s) {
        getBaseActivity().toast(s);
    }

}
