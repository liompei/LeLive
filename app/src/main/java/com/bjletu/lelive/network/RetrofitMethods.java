package com.bjletu.lelive.network;

import com.bjletu.lelive.base.BaseActivity;
import com.bjletu.lelive.bean.HttpResult;
import com.bjletu.lelive.network.config.HttpConfig;
import com.liompei.zxlog.Zx;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Liompei
 * Time 2017/10/5 19:35
 * 1137694912@qq.com
 * remark:
 */

public class RetrofitMethods<T> implements Function<HttpResult<T>, HttpResult<T>> {

    private Retrofit mRetrofit;
    private OkHttpClient mHttpClient;
    private APIFunction mAPIFunction;

    private static RetrofitMethods instance;


    public static RetrofitMethods getInstance() {

        if (instance == null) {
            synchronized (RetrofitMethods.class) {
                instance = new RetrofitMethods();
            }
        }
        return instance;
    }

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Zx.i(message);
        }
    });

    private RetrofitMethods() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //手动创建一个OkHttpClient并设置超时时间
        mHttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .client(mHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mAPIFunction = mRetrofit.create(APIFunction.class);
    }


    private void toSubscribe(BaseActivity activity,Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .compose(RxLifecycle.bindUntilEvent(activity.lifecycle(), ActivityEvent.DESTROY))
                .observeOn(AndroidSchedulers.mainThread())
                .map(this)
                .subscribe(observer);
    }

    @Override
    public HttpResult<T> apply(HttpResult<T> httpResult) throws Exception {
        if (httpResult.getCode() == 0) {
            throw new Exception(httpResult.getMessage() + "错误码: " + httpResult.getCode());
        }
        return httpResult;
    }


    //***********************请求********************

    //登录
    public void login(BaseActivity activity,String telNumber, String password, HttpCallback<T> httpCallback) {
        toSubscribe(activity,mAPIFunction.login(telNumber, password), new MyObserver(activity, false, httpCallback));
    }


}
