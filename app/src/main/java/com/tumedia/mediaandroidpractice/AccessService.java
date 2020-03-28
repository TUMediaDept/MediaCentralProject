package com.tumedia.mediaandroidpractice;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

import com.orhanobut.logger.Logger;

/**
 * Created by Ximon on 2020-03-28
 */
public class AccessService extends AccessibilityService {
    private static final String TAG = "AccessibilityService";

    String inputText = null;
    int prevEvent = 0;

    // 이벤트가 발생할때마다 실행되는 부분
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Logger.i(TAG, "Catch Event Package Name : " + accessibilityEvent.getPackageName());
        Logger.i(TAG, "Catch Event TEXT : " + accessibilityEvent.getText());
        Logger.i(TAG, "Catch Event ContentDescription : " + accessibilityEvent.getContentDescription());
        Logger.i(TAG, "Catch Event getSource : " + accessibilityEvent.getSource());
        Logger.i(TAG, "=========================================================================");
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }
}
