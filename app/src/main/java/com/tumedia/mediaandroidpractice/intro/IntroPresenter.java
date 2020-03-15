package com.tumedia.mediaandroidpractice.intro;

import com.tumedia.mediaandroidpractice.base.BasePresenterImpl;
import com.tumedia.mediaandroidpractice.logic.Repository;
import com.tumedia.mediaandroidpractice.logic.RepositoryImpl;

/**
 * Created by XIMON on 2020-02-05
 */
public class IntroPresenter extends BasePresenterImpl<IntroContract.View>
        implements IntroContract.Presenter {

    Repository repository;

    IntroPresenter(){
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void showActivityToCheckPermission() {

    }
}
