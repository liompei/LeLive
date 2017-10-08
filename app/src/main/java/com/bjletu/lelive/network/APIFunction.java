package com.bjletu.lelive.network;

import com.bjletu.lelive.bean.HttpResult;
import com.bjletu.lelive.bean.MyUser;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Liompei
 * Time 2017/10/5 18:59
 * 1137694912@qq.com
 * remark:
 */

public interface APIFunction {

    //模板
    @FormUrlEncoded
    @POST("aaaaaaaaaaaaa")
    Observable<HttpResult<String>> aaaaa(@Field("aaaaaa") String aaaaaa,
                                         @Field("aaaaaaa") String aaaaaaa);

    //登录
    @FormUrlEncoded
    @POST("login")
    Observable<HttpResult<MyUser>> login(@Field("telNumber") String telNumber, @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("register")
    Observable<HttpResult<String>> register(@Field("loginType") String loginType,
                                            @Field("telNumber") String telNumber,
                                            @Field("username") String username,
                                            @Field("password") String password,
                                            @Field("code") String code);


}
