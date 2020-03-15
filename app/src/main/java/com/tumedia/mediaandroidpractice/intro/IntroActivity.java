package com.tumedia.mediaandroidpractice.intro;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

import com.tumedia.mediaandroidpractice.R;
import com.tumedia.mediaandroidpractice.base.BaseActivity;

/**
 * Created by XIMON on 2020-02-05
 */
public class IntroActivity
        extends BaseActivity<IntroContract.View, IntroContract.Presenter>
        implements IntroContract.View {

    @Override
    protected IntroContract.Presenter setPresenter() {
        return new IntroPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        checkPermission();
    }

    // 다른 앱 위에 표시 (오버레이) 권한 체크
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {   // 마시멜로우 이상일 경우 체크
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(this,PermissionActivity.class);
                startActivity(intent);
                finish();
//                startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
            } else {
//                Log.e("myLog", "startService")
//                startService()
            }
        } else {
//            startService()
        }
    }


}
