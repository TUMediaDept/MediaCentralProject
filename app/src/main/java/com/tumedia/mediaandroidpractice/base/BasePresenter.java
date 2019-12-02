package com.tumedia.mediaandroidpractice.base;

/**
 * Created by XIMON on 2019-11-29
 */
public interface BasePresenter<T> {
    void setView(T view);

    void removeView();
}
