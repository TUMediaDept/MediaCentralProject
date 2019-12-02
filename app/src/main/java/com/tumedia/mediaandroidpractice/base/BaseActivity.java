package com.tumedia.mediaandroidpractice.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by XIMON on 2019-11-29
 */
public abstract class BaseActivity
        <V extends BaseView, P extends BasePresenter<V>>
        extends AppCompatActivity {

    protected P mPresenter;

    protected abstract P setPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = setPresenter();
        mPresenter.setView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.removeView();
    }
}
