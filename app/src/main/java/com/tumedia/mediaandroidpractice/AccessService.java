package com.tumedia.mediaandroidpractice;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import androidx.appcompat.widget.AppCompatImageButton;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;


/**
 * Created by Ximon on 2020-03-28
 */
public class AccessService extends AccessibilityService {
    private static final String TAG = "AccessibilityService";

    String inputText = null;
//    int prevEvent = 0;

    WindowManager wm;
    View mView;

    // 이벤트가 발생할때마다 실행되는 부분
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Log.i(TAG, "Catch Event Package Name : " + accessibilityEvent.getPackageName());
        Log.i(TAG, "Catch Event TEXT : " + accessibilityEvent.getText());
        Log.i(TAG, "Catch Event ContentDescription : " + accessibilityEvent.getContentDescription());
        Log.i(TAG, "Catch Event getSource : " + accessibilityEvent.getSource());
        Log.i(TAG, "=========================================================================");

        if ("com.kakao.talk".equals(accessibilityEvent.getPackageName().toString())) {
//            inputText = accessibilityEvent.getText().toString();

            // 카카오톡 채팅방 화면이며, 해당 화면에서 아이템에 롱클릭 시 상태가 체인지 될 때
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_LONG_CLICKED
//                    && "채팅".equals(accessibilityEvent.getText().toString())
            ) {
                // 앱 아이콘 3초간 표시 (클릭 가능하도록)
                Log.d(TAG, "[TODO EVENT] show hidden overlay view");
                showIcon(); // 2020-04-13 FATAL EXCEPTION 발생 ( 앱 충돌 )
            }
        }


    }


    private void showIcon() {
        LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);

//        params.gravity = Gravity.LEFT | Gravity.TOP;
        mView = inflate.inflate(R.layout.view_in_service, null);
        AppCompatImageButton bt = mView.findViewById(R.id.imgBtnIcon);

        RxView.clicks(bt)
                .throttleFirst(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(result -> {
//                        startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))

                        }
                );
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bt.setImageResource(R.mipmap.ic_launcher_round);
////                textView.setText("on click!!");
//            }
//        });
        wm.addView(mView, params); // 2020-04-13 FATAL EXCEPTION 발생 ( 앱 충돌 )
    }

    @Override
    protected void onServiceConnected() {
//        super.onServiceConnected();

//        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
//
//        // We are interested in all types of accessibility events.
//        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
//
//        // We want to provide specific type of feedback.
//        info.feedbackType = AccessibilityServiceInfo.DEFAULT | AccessibilityServiceInfo.FEEDBACK_HAPTIC;
//
//        // We want to receive events in a certain interval.
//        info.notificationTimeout = 100;
//
//        // We want to receive accessibility events only from certain packages.
//        // info.packageNames = PACKAGE_NAMES;
//
//        setServiceInfo(info);
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "OnInterrupt");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(wm != null) {
            if(mView != null) {
                wm.removeView(mView);
                mView = null;
            }
            wm = null;
        }
    }

}