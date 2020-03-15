package com.tumedia.mediaandroidpractice.intro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.tumedia.mediaandroidpractice.R;

/**
 * 권한 설정 화면
 * @author 서영래(XIMON)
 * @version 1.0.0
 * @since 2020-03-15 오후 7:52
 */
public class PermissionActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 1;
    /**
     * overlay permission: 다른 앱 위에 표시되는 권한
     * access permission: 접근성 권한(설정)
     */
    private AppCompatButton mBtnOverlayPermission;
    private AppCompatButton mBtnAccessPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        initView();
        initListener();
    }

    private void initView() {
        mBtnOverlayPermission = findViewById(R.id.btn1);
        mBtnAccessPermission = findViewById(R.id.btn2);
    }

    private void initListener(){
        mBtnOverlayPermission.setOnClickListener(this);
        mBtnAccessPermission.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Intent intent = new Intent(
                            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                            Uri.parse("package:$packageName"));
                    startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
                }
                break;
            case R.id.btn2:

                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(!Settings.canDrawOverlays(this)){
                    finish();
                }else{
//                    startService();
                }
            }
        }
    }
}
