package com.tumedia.mediaandroidpractice.logic.remote.network;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 공통 헤더값 저장 클래스
 *
 * Created by XIMON on 2020-01-12
 */
public class AddHeaderInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        return null;
    }
}
