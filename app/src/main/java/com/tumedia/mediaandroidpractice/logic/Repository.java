package com.tumedia.mediaandroidpractice.logic;

import com.tumedia.mediaandroidpractice.base.BasePresenter;

/**
 * 로컬/서버 중 어떤 데이터를 불러올지 정의하고,
 * 메모리 캐시를 포함한다.
 */
public interface Repository<T> {
    void setPresenter(BasePresenter<T> presenter);
}
