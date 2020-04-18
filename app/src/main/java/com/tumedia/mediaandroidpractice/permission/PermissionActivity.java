package com.tumedia.mediaandroidpractice.permission;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
import com.tumedia.mediaandroidpractice.AccessService;
import com.tumedia.mediaandroidpractice.R;
import com.tumedia.mediaandroidpractice.base.BaseActivity;
import com.tumedia.mediaandroidpractice.main.MainActivity;

import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;

/**
 * 권한 설정 화면
 *
 * @author 서영래(XIMON)
 * @version 1.0.0
 * @since 2020-03-15 오후 7:52
 */
public class PermissionActivity
        extends BaseActivity<PermissionContract.View, PermissionContract.Presenter>
        implements PermissionContract.View {
//        , View.OnClickListener{

    private static final int ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 1001;
    private static final int ACTION_MANAGE_ACCESSIBLITY_PERMISSION_REQUEST_CODE = 1002;
    /**
     * overlay permission: 다른 앱 위에 표시되는 권한
     * access permission: 접근성 권한(설정)
     */
    private AppCompatButton mBtnOverlayPermission;
    private AppCompatButton mBtnAccessPermission;

    @Override
    protected PermissionContract.Presenter setPresenter() {
        return new PermissionPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setBtnColor();
        Intent intent = new Intent(this, MainActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(getApplication()) && checkAccessibilityService(getApplication())) {
                startActivity(intent);
                finish();
            }
        } else {
            if (checkAccessibilityService(getApplication())) {
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        initView();
        initListener();
        setBtnColor();
    }

    private void initView() {
        mBtnOverlayPermission = findViewById(R.id.btnOverlay);
        mBtnAccessPermission = findViewById(R.id.btnAccess);
    }

    private void initListener() {
//        mBtnOverlayPermission.setOnClickListener(this);
//        mBtnAccessPermission.setOnClickListener(this);

        // Rx 적인 클릭의 추상화
        // 중복 클릭 방지
        RxView.clicks(mBtnOverlayPermission)
                .throttleFirst(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        Intent intent = new Intent(
                                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:" + getPackageName()));
                        startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
                    }
                });
        RxView.clicks(mBtnAccessPermission)
                .throttleFirst(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(result -> startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));
    }

    private void setBtnColor() {
        // 마시멜로 버전 이상
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(getApplication())) {
                // 오버레이(다른 앱 위에 표시) 동의 했을 경우
                mBtnOverlayPermission.setBackgroundResource(R.color.colorAccent);
                mBtnOverlayPermission.setTextColor(ContextCompat.getColor(getApplication(), R.color.colorBackground));
            } else {
                // (오버레이 퍼미션)다시 권한 설정 취소할 경우 고려
                mBtnOverlayPermission.setBackgroundResource(R.color.inComplete);
                mBtnOverlayPermission.setTextColor(ContextCompat.getColor(getApplication(), R.color.colorBlack));
            }
        } else {
            mBtnOverlayPermission.setBackgroundResource(R.color.colorAccent);
            mBtnOverlayPermission.setTextColor(ContextCompat.getColor(getApplication(), R.color.colorBackground));
        }
        if (checkAccessibilityService(getApplication())) {
            // 접근성 설정 동의 했을 경우
            mBtnAccessPermission.setBackgroundResource(R.color.colorAccent);
            mBtnAccessPermission.setTextColor(ContextCompat.getColor(getApplication(), R.color.colorBackground));
        } else {
            // (접근성 퍼미션)다시 권한 설정 취소할 경우 고려
            mBtnAccessPermission.setBackgroundResource(R.color.inComplete);
            mBtnAccessPermission.setTextColor(ContextCompat.getColor(getApplication(), R.color.colorBlack));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                setBtnColor();
//                if(!Settings.canDrawOverlays(getApplication())){
////                    finish();
//                }else{
////                    startService();
//                }
            }
        }
//        if (requestCode == ACTION_MANAGE_ACCESSIBLITY_PERMISSION_REQUEST_CODE) {
//            setBtnColor();
//        }
    }

    /***
     * 안드로이드 접근성 서비스
     *
     * @param mContext
     * @return
     */
    // 접근성 권한이 있는지 없는지 확인하는 부분
    private boolean checkAccessibilityService(Context mContext) {
        int accessibilityEnabled = 0;
        final String service = getPackageName() + "/" + AccessService.class.getCanonicalName();
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
//                        startService(new Intent(getApplication(),AccessService.class));
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
