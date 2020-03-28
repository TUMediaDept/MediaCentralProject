package com.tumedia.mediaandroidpractice.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;

import com.tumedia.mediaandroidpractice.R;
import com.tumedia.mediaandroidpractice.base.BaseActivity;
import com.tumedia.mediaandroidpractice.main.MainActivity;

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

        if(checkDrawOverlayPermission(getApplication()) && checkAccessibilityService(getApplication())){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this,PermissionActivity.class);
            startActivity(intent);
        }
        onDestroy();
    }

    //오버레이 권한 확인(마시멜로 이상부터만 가능)
    public boolean checkDrawOverlayPermission(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return Settings.canDrawOverlays(context);
        }
        else{
            return true;
        }
    }

    // 접근성 권한이 있는지 없는지 확인하는 부분
    private boolean checkAccessibilityService(Context mContext) {
        int accessibilityEnabled = 0;
        final String service = getPackageName() + "/" + Service_AppListener.class.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    mContext.getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(
                    mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);

            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);

                while (mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();

                    if (accessibilityService.equalsIgnoreCase(service)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


}
