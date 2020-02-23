package com.tumedia.mediaandroidpractice.util;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.tumedia.mediaandroidpractice.BuildConfig;

/**
 * 로그 레벨 설정 및 로그 Util 클래스
 * // Android SDK에서 기본 제공하는 log는 로그 레벨에 따라 출력여부를 판단하는 기능이 없기 때문에
 * // 지정된 레벨별로 설정할 수 있게 기능을 추가한다.
 */
public class TUMediaLog {
    // 로그 출력 여부
    private static boolean PRINTABLE = BuildConfig.IS_REAL;
    // 로그를 표시할 레벨
    private static int LogLevel = Log.VERBOSE;
    // 로그를 표시할 기본 TAG
    private static String LogTag = "TUMediaLog";


    public static void d(String log) {
        if (!PRINTABLE) {

        }
    }

    public static void e(String log) {

    }

    public static void w(String log) {

    }

    public static void v(String log) {

    }

    public static void i(String log) {

    }
}
