package com.bjletu.lelive.network;

import com.bjletu.lelive.bean.HttpResult;

import io.reactivex.disposables.Disposable;

/**
 * Created by Liompei
 * Time 2017/10/6 16:49
 * 1137694912@qq.com
 * remark:
 */

public interface HttpCallback<T> {

    void onStart(Disposable d);

    void onNext(HttpResult<T> value);

    void onError(Throwable e);

    void onFinish();
}
