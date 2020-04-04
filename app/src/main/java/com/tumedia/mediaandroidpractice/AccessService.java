package com.tumedia.mediaandroidpractice;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;


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
        Log.i(TAG, "Catch Event Package Name : " + accessibilityEvent.getPackageName());
        Log.i(TAG, "Catch Event TEXT : " + accessibilityEvent.getText());
        Log.i(TAG, "Catch Event ContentDescription : " + accessibilityEvent.getContentDescription());
        Log.i(TAG, "Catch Event getSource : " + accessibilityEvent.getSource());
        Log.i(TAG, "=========================================================================");
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "OnInterrupt");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }
}
