package com.tumedia.mediaandroidpractice.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;

import com.tumedia.mediaandroidpractice.R;

public class PermissionActivity extends AppCompatActivity implements View.OnClickListener {
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
    }

    private void initView() {
        mBtnOverlayPermission = findViewById(R.id.btn1);
        mBtnAccessPermission = findViewById(R.id.btn2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:

                break;
            case R.id.btn2:

                break;
            default:
                break;
        }
    }
}
