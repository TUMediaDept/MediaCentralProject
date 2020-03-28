package com.tumedia.mediaandroidpractice;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

import com.orhanobut.logger.Logger;

/**
 * Created by Ximon on 2020-03-28
 */
public class AccessService extends AccessibilityService {
    String inputText = null;
    int prevEvent = 0;
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Logger.d("TEST", "Catch Event : " + accessibilityEvent.toString());
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }
}
