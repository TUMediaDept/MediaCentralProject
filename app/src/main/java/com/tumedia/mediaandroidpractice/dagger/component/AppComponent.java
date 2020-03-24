package com.tumedia.mediaandroidpractice.dagger.component;

import com.tumedia.mediaandroidpractice.dagger.module.AppModule;
import com.tumedia.mediaandroidpractice.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author 서영래(XIMON)
 * @version 1.0.0
 * @since 2020-03-24 오후 11:22
 **/
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

}
