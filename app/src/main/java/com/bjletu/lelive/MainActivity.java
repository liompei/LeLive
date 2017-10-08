package com.bjletu.lelive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bjletu.lelive.base.BaseActivity;
import com.bjletu.lelive.ui.discover.DiscoverFragment;
import com.bjletu.lelive.ui.home.HomeFragment;
import com.bjletu.lelive.ui.me.MeFragment;
import com.bjletu.lelive.ui.message.MessageFragment;

/**
 * Created by Liompei
 * Time 2017/10/5 10:49
 * 1137694912@qq.com
 * remark:
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mRlTab1, mRlTab2, mRlTab3, mRlTab4;
    private ImageView mIvTab1, mIvTab2, mIvTab3, mIvTab4;
    private TextView mTvTab1, mTvTab2, mTvTab3, mTvTab4;
    private ImageView mFabCenter;

    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private DiscoverFragment mDiscoverFragment;
    private MeFragment mMeFragment;

    private int nowNum = 0;  //记录当前位置

    public static void start(BaseActivity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mFabCenter = findView(R.id.fab_center);
        mRlTab1 = findView(R.id.rl_tab1);
        mRlTab2 = findView(R.id.rl_tab2);
        mRlTab3 = findView(R.id.rl_tab3);
        mRlTab4 = findView(R.id.rl_tab4);
        mIvTab1 = findView(R.id.iv_tab1);
        mIvTab2 = findView(R.id.iv_tab2);
        mIvTab3 = findView(R.id.iv_tab3);
        mIvTab4 = findView(R.id.iv_tab4);
        mTvTab1 = findView(R.id.tv_tab1);
        mTvTab2 = findView(R.id.tv_tab2);
        mTvTab3 = findView(R.id.tv_tab3);
        mTvTab4 = findView(R.id.tv_tab4);
    }

    @Override
    public void initData() {
        mFabCenter.setOnClickListener(this);
        mRlTab1.setOnClickListener(this);
        mRlTab2.setOnClickListener(this);
        mRlTab3.setOnClickListener(this);
        mRlTab4.setOnClickListener(this);
    }

    @Override
    public void onEvent() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_tab1:
                setTabSelect(0);
                break;
            case R.id.rl_tab2:
                setTabSelect(1);
                break;
            case R.id.rl_tab3:
                setTabSelect(2);
                break;
            case R.id.rl_tab4:
                setTabSelect(3);
                break;
            case R.id.fab_center:  //开直播
                mFabCenter.setEnabled(false);
//                netGetMyRoomList(view);
                break;
        }
    }

    //********tab相关*********
    private void setTabSelect(int i) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        resetTab();
        switch (i) {
            case 0:
                mHomeFragment = (HomeFragment) manager.findFragmentByTag("HOME");
                hideTab(transaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.content, mHomeFragment, "HOME");
                } else {
                    transaction.show(mHomeFragment);
                }
                nowNum = 0;
                mIvTab1.setImageResource(R.drawable.tab_home_selector);
                mTvTab1.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 1:
                mMessageFragment = (MessageFragment) manager.findFragmentByTag("MESSAGE");
                hideTab(transaction);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();

                    transaction.add(R.id.content, mMessageFragment, "MESSAGE");
                } else {
                    transaction.show(mMessageFragment);
                }
                nowNum = 1;
                mIvTab2.setImageResource(R.drawable.tab_chat_selector);
                mTvTab2.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                mDiscoverFragment = (DiscoverFragment) manager.findFragmentByTag("DISCOVER");
                hideTab(transaction);
                if (mDiscoverFragment == null) {
                    mDiscoverFragment = new DiscoverFragment();
                    transaction.add(R.id.content, mDiscoverFragment, "DISCOVER");
                } else {
                    transaction.show(mDiscoverFragment);
                }
                nowNum = 2;
                mIvTab3.setImageResource(R.drawable.tab_discover_selector);
                mTvTab3.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                mMeFragment = (MeFragment) manager.findFragmentByTag("ME");
                hideTab(transaction);
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.content, mMeFragment, "ME");
                } else {
                    transaction.show(mMeFragment);
                }
                nowNum = 3;
                mIvTab4.setImageResource(R.drawable.tab_me_selector);
                mTvTab4.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
        transaction.commit();
    }

    //重置
    private void resetTab() {
        mIvTab1.setImageResource(R.drawable.tab_home);
        mIvTab2.setImageResource(R.drawable.tab_chat);
        mIvTab3.setImageResource(R.drawable.tab_discover);
        mIvTab4.setImageResource(R.drawable.tab_me);

        mTvTab1.setTextColor(getResources().getColor(R.color.main_reset_color));
        mTvTab2.setTextColor(getResources().getColor(R.color.main_reset_color));
        mTvTab3.setTextColor(getResources().getColor(R.color.main_reset_color));
        mTvTab4.setTextColor(getResources().getColor(R.color.main_reset_color));
    }

    //不为空则隐藏
    private void hideTab(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }
        if (mDiscoverFragment != null) {
            transaction.hide(mDiscoverFragment);
        }
        if (mMeFragment != null) {
            transaction.hide(mMeFragment);
        }
    }
    //********end*************
}
