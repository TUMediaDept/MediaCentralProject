package com.tumedia.mediaandroidpractice.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by XIMON on 2019-12-03
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    protected T view;
    protected CompositeDisposable bag = new CompositeDisposable();

    @Override
    public void setView(T view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
        bag.clear();
    }
}
