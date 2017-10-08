package com.bjletu.lelive.main.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import com.bjletu.lelive.App;
import com.bjletu.lelive.R;
import com.bjletu.lelive.base.BaseActivity;
import com.bjletu.lelive.main.activity.SplashActivity;
import com.bjletu.lelive.util.SharedPreferencesUtils;

/**
 * Created by Liompei
 * Time 2017/10/8 22:35
 * 1137694912@qq.com
 * remark:
 */

public class SettingFragment extends PreferenceFragment {

    private Preference app_signOut;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_preferences);
        app_signOut = findPreference("app_signOut");
        app_signOut.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                SharedPreferencesUtils.reset(getActivity());//清除所有缓存
                App.getInstance().finishAllActivity();
                SplashActivity.start((BaseActivity) getActivity());
                return false;
            }
        });
    }
}
