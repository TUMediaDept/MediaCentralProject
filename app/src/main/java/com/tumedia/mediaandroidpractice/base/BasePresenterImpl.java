package com.tumedia.mediaandroidpractice.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by XIMON on 2019-12-03
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    protected T view;

    // <TODO> CompositeDisposable: 생성된 Observable을 안드로이드 라이프 사이클에 맞춰서 한 번에 모두 메모리 해제 가능
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
