package com.tumedia.mediaandroidpractice.intro;

import android.os.Bundle;

import com.tumedia.mediaandroidpractice.R;
import com.tumedia.mediaandroidpractice.base.BaseActivity;
import com.tumedia.mediaandroidpractice.main.MainContract;

/**
 * Created by XIMON on 2020-02-05
 */
public class IntroActivity
        extends BaseActivity<IntroContract.View, IntroContract.Presenter>
        implements MainContract.View {

    @Override
    protected IntroContract.Presenter setPresenter() {
        return new IntroPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }
}
