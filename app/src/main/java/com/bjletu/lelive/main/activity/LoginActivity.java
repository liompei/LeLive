package com.bjletu.lelive.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bjletu.lelive.MainActivity;
import com.bjletu.lelive.R;
import com.bjletu.lelive.base.BaseActivity;
import com.bjletu.lelive.bean.HttpResult;
import com.bjletu.lelive.bean.MyUser;
import com.bjletu.lelive.network.HttpCallback;
import com.bjletu.lelive.network.RetrofitMethods;
import com.bjletu.lelive.util.MyUIKit;
import com.bjletu.lelive.util.RxUtils;
import com.liompei.zxlog.Zx;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * Created by Liompei
 * Time 2017/10/5 11:19
 * 1137694912@qq.com
 * remark:登录界面
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.logo)
    ImageView mLogo;
    @BindView(R.id.et_mobile)
    EditText mEtMobile;
    @BindView(R.id.iv_clean_phone)
    ImageView mIvCleanPhone;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.clean_password)
    ImageView mCleanPassword;
    @BindView(R.id.iv_show_pwd)
    ImageView mIvShowPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.regist)
    TextView mRegist;
    @BindView(R.id.forget_password)
    TextView mForgetPassword;
    @BindView(R.id.content)
    LinearLayout mContent;
    @BindView(R.id.scrollView)
    ScrollView mScrollView;
    @BindView(R.id.service)
    LinearLayout mService;
    @BindView(R.id.root)
    RelativeLayout mRoot;

    public static void start(BaseActivity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        fullScreen();  //全屏
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mEtMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && mIvCleanPhone.getVisibility() == View.GONE) {
                    mIvCleanPhone.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    mIvCleanPhone.setVisibility(View.GONE);
                }
            }
        });
        mEtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && mCleanPassword.getVisibility() == View.GONE) {
                    mCleanPassword.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    mCleanPassword.setVisibility(View.GONE);
                }
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxUtils.hideSoftInput(mBaseActivity);  //隐藏软键盘
                String username = mEtMobile.getText().toString();
                String password = mEtPassword.getText().toString();
                if ("".equals(username)) {
                    toast("请输入手机号");
                    return;
                }
                if ("".equals(password)) {
                    toast("请输入密码");
                    return;
                }
                toLogin(username, password);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onEvent() {

    }

    @OnClick({R.id.iv_clean_phone, R.id.clean_password, R.id.iv_show_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_clean_phone:
                mEtMobile.setText("");
                break;
            case R.id.clean_password:
                mEtPassword.setText("");
                break;
            case R.id.iv_show_pwd:
                if (mEtPassword.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mIvShowPwd.setImageResource(R.drawable.pass_visuable);
                } else {
                    mEtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mIvShowPwd.setImageResource(R.drawable.pass_gone);
                }
                String pwd = mEtPassword.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    mEtPassword.setSelection(pwd.length());
                break;
        }
    }


    //登录
    private void toLogin(String username, String password) {
        showProgress();
        RetrofitMethods.getInstance().login(this, username, password, new HttpCallback<MyUser>() {
            @Override
            public void onStart(Disposable d) {
            }

            @Override
            public void onNext(HttpResult<MyUser> value) {
                if (value.isSuccess()) {
                    toLoginChat(value.getResult());
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onFinish() {
            }
        });
    }

    //登录聊天服务器
    private AbortableFuture<LoginInfo> mLoginRequest;

    private void toLoginChat(final MyUser myUser) {
        LoginInfo loginInfo = new LoginInfo(myUser.getAccid(), myUser.getToken());
        mLoginRequest = MyUIKit.doLogin(loginInfo, new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {
                Zx.d("onSuccess");
                dismissProgress();
                MyUser.save(myUser);
                toStart();
            }

            @Override
            public void onFailed(int code) {
                Zx.d("onFailed");
                dismissProgress();
                if (code == 408) {
                    toast("网络连接超时");
                } else if (code == 302 || code == 404) {
                    toast("账号或密码错误");
                } else {
                    toast("登录失败: " + code);
                }
            }

            @Override
            public void onException(Throwable exception) {
                Zx.d("onException: 无效输入 " + exception.getMessage());
                toast("无效输入");
                dismissProgress();
            }
        });

    }

    private void toStart() {
        MainActivity.start(LoginActivity.this);
        finish();
    }
}
