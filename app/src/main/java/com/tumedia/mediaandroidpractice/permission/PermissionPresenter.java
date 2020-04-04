package com.tumedia.mediaandroidpractice.permission;

import com.tumedia.mediaandroidpractice.base.BasePresenterImpl;
import com.tumedia.mediaandroidpractice.logic.Repository;
import com.tumedia.mediaandroidpractice.logic.RepositoryImpl;

/**
 * Created by XIMON on 2020-02-05
 */
public class PermissionPresenter
        extends BasePresenterImpl<PermissionContract.View>
        implements PermissionContract.Presenter {

    Repository repository;

    PermissionPresenter(){
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

}
