package com.bjletu.lelive;

import android.app.Activity;
import android.app.Application;
import android.support.multidex.MultiDex;
import android.text.TextUtils;

import com.bjletu.lelive.util.MyUIKit;
import com.bjletu.lelive.util.RxUtils;
import com.liompei.zxlog.Zx;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.auth.LoginInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liompei
 * Time 2017/10/5 10:14
 * 1137694912@qq.com
 * remark:
 */

public class App extends Application {
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        instance = this;
        initZx();
        initSDK();
    }

    private void initZx() {
        Zx.initLog("blm", true);
        Zx.initToast(getApplicationContext(), true);
    }


    private void initSDK() {
        // SDK初始化（启动后台服务，若已经存在用户登录信息， SDK 将完成自动登录）
        NIMClient.init(this, getLoginInfo(), getOptions());
        // ... your codes
        if (RxUtils.inMainProcess(this)) {
            // 注意：以下操作必须在主进程中进行
            // 1、UI相关初始化操作
            // 2、相关Service调用
        }
    }

    private LoginInfo getLoginInfo() {
        // 如果已经存在用户登录信息，返回LoginInfo，否则返回null即可
        String account = MyUIKit.getAccount();
        String token = MyUIKit.getToken();

        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(token)) {
            return new LoginInfo(account, token);
        } else {
            return null;
        }
    }

    private SDKOptions getOptions() {
        SDKOptions sdkOptions = new SDKOptions();
        sdkOptions.appKey = "36ad3a2c1333fce8c993bc7fa886a583";
        // 如果返回值为 null，则全部使用默认参数。
        return sdkOptions;
    }


    //***全局***
    public static App instance;

    public static App getInstance() {
        return instance;
    }

    private List<Activity> activityList = new ArrayList<>();

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void deleteActivity(Activity activity) {
        activityList.remove(activity);
    }

    public void finishAllActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }

    // 退出
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
        System.exit(0);
    }
    //***end***


}
