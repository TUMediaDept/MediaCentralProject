package com.tumedia.mediaandroidpractice.di.module;

import android.content.Context;

import com.tumedia.mediaandroidpractice.MediaApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author 서영래(XIMON)
 * @version 1.0.0
 * @since 2020-03-24 오후 11:23
 **/

@Module
public class AppModule {
    private MediaApplication application;

    public AppModule(MediaApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return this.application;
    }
}
