package com.tumedia.mediaandroidpractice.util;

import android.text.TextUtils;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 반복적이거나 공통으로 쓰이는 기능들을 처리하는 Util 클래스
 */
public class CommonUtil {

    /**
     * URL Decode
     *
     * @param url target url
     * @return decoded string by utf-8
     */
    public static String getURLDecode(String url) {
        String result = "";
        if (!TextUtils.isEmpty(url)) {
            try {
                result = URLDecoder.decode(url, "UTF-8");
            } catch (UnsupportedEncodingException e) {
//                TUMediaLog.e(e.getLocalizedMessage());
            }
        }

        return result;
    }

    /**
     * URL Encode
     *
     * @param url target url
     * @return encoded string by utf-8
     */
    public static String getURLEncode(String url) {
        String result = "";
        if (!TextUtils.isEmpty(url)) {
            try {
                result = URLEncoder.encode(url, "UTF-8");
            } catch (Exception e) {
//                TUMediaLog.e(e.getLocalizedMessage());
            }
        }

        return result;
    }
}
