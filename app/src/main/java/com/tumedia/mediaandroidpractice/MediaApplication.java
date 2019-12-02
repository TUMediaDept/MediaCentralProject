package com.tumedia.mediaandroidpractice;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.ArrayList;

/**
 * Created by Ximon on 2019-11-27
 */
public class MediaApplication extends Application
        implements LifecycleObserver, Application.ActivityLifecycleCallbacks {

    public static final String TAG = MediaApplication.class.getSimpleName();

//    private static ArrayList<Activity> mActivityStack;

    private static Context mContext;

    public MediaApplication() {

    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
//        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

        mContext = getApplicationContext();

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
}
