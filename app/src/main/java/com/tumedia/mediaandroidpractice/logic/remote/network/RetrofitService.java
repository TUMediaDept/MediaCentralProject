package com.tumedia.mediaandroidpractice.logic.remote.network;

import com.tumedia.mediaandroidpractice.common.Constants;
import com.tumedia.mediaandroidpractice.model.SearchRepoResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by XIMON on 2019-12-01
 */
public interface RetrofitService {

    /**
     *
     * @param keyword : 검색할 repository 키워드
     * @return
     */
    @GET(Constants.SEARCH_REPO)
    Flowable<SearchRepoResult> doSearchRepo(@Query("q") String keyword);



}
