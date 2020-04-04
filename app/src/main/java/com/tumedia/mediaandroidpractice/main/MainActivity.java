package com.tumedia.mediaandroidpractice.main;

import android.os.Bundle;

import com.tumedia.mediaandroidpractice.R;
import com.tumedia.mediaandroidpractice.base.BaseActivity;

public class MainActivity
        extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @Override
    protected MainContract.Presenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
