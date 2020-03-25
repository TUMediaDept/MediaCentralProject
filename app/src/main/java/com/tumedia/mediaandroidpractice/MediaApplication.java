package com.tumedia.mediaandroidpractice;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tumedia.mediaandroidpractice.di.component.AppComponent;
import com.tumedia.mediaandroidpractice.di.component.DaggerAppComponent;
import com.tumedia.mediaandroidpractice.di.module.AppModule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by Ximon on 2019-11-27
 */
public class MediaApplication extends Application
        implements LifecycleObserver, Application.ActivityLifecycleCallbacks {

    public static final String TAG = MediaApplication.class.getSimpleName();

//    private static ArrayList<Activity> mActivityStack;

    private AppComponent appComponent;

    private static Context mContext;

    public MediaApplication() {

    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        registerActivityLifecycleCallbacks(this);
//        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

        checkDebugLogInfo();
    }

    private void init(){
//        appComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .build();
//        appComponent.inject(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onForeground() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onBackground() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }

    /**
     * Debug 로그 설정
     */
    private void checkDebugLogInfo(){

        // 디버그 로그 설정
        if(!BuildConfig.IS_REAL){
            // WebView 디버깅
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }else{

        }

        // Release 빌드 시 로그 제거
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    // 앱 키해시 추출
//    private void getAppKeyHash() {
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md;
//                md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                String something = new String(Base64.encode(md.digest(), 0));
//                Logger.d("Hash key", something);
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            Logger.e("name not found", e.toString());
//        }
//    }
}
