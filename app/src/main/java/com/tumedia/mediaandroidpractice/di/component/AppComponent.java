package com.tumedia.mediaandroidpractice.di.component;

import com.tumedia.mediaandroidpractice.MediaApplication;
import com.tumedia.mediaandroidpractice.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author 서영래(XIMON)
 * @version 1.0.0
 * @since 2020-03-24 오후 11:22
 **/


/**
 * AppComponent: 컴포넌트로 묶어둘 모듈
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MediaApplication mediaApplication);
}
