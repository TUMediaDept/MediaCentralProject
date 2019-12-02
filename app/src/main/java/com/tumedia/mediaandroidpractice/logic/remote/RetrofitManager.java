package com.tumedia.mediaandroidpractice.logic.remote;

import android.os.Build;
import android.webkit.CookieManager;

import com.google.gson.GsonBuilder;
import com.tumedia.mediaandroidpractice.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 네트워크 통신을 위한 정의 클래스
 * <p>
 * Created by XIMON on 2019-12-01
 */
public class RetrofitManager {
    private static RetrofitManager mInstance;
    private static RetrofitService mService;
    private static Retrofit mRetrofit;

    private static RetrofitManager getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitManager();
        }
        return mInstance;
    }

    public RetrofitManager getRetrofitInstance() {
        mRetrofit = new Retrofit.Builder()
                .client(provideOkHttpClient())
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return getInstance();
    }

    public RetrofitService getApiService() {
        if (mService == null) {
            mService = mRetrofit.create(RetrofitService.class);
        }
        return mService;
    }

    private OkHttpClient provideOkHttpClient() {

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        // DEBUG 모드일 경우에만 http 로그 출력
        if (BuildConfig.DEBUG) {
            okHttpClient.addNetworkInterceptor(httpLoggingInterceptor);
        }

        okHttpClient
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);

        return okHttpClient.build();
    }

    public void clearCookie() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().removeAllCookies(null);
        } else {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
        }
    }
}
