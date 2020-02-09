package com.tumedia.mediaandroidpractice.intro;

import com.tumedia.mediaandroidpractice.base.BasePresenter;
import com.tumedia.mediaandroidpractice.base.BaseView;

/**
 * Created by XIMON on 2020-02-05
 */
public class IntroContract {
    public interface View extends BaseView {
        // 조회한 결과를 뷰에 다시 올림
    }
    public interface Presenter extends BasePresenter<View> {
        // 원하는 데이터 요청(조회)
    }
}
