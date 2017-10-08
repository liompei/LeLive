package com.bjletu.lelive.util;

import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

/**
 * Created by Liompei
 * Time 2017/10/8 21:28
 * 1137694912@qq.com
 * remark:
 */

public class MyUIKit {

    public static String getAccount() {
        return SharedPreferencesUtils.getString("accid");
    }

    public static String getToken(){
        return SharedPreferencesUtils.getString("token");
    }

    public static AbortableFuture<LoginInfo> doLogin(LoginInfo loginInfo, final RequestCallback<LoginInfo> callback) {

        AbortableFuture<LoginInfo> loginRequest = NIMClient.getService(AuthService.class).login(loginInfo);
        loginRequest.setCallback(new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo loginInfo) {
                callback.onSuccess(loginInfo);
            }

            @Override
            public void onFailed(int code) {
                callback.onFailed(code);
            }

            @Override
            public void onException(Throwable exception) {
                callback.onException(exception);
            }
        });
        return loginRequest;
    }
}
