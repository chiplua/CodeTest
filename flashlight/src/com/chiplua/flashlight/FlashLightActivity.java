package com.chiplua.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.os.IHardwareService;

public class FlashLightActivity extends Activity {
    private static Boolean isOpen = false;
    private Camera mCamera = null;
    private Camera.Parameters mCameraParameters = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);

        findViewById(R.id.button_switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpen = !isOpen;

                if (isOpen) {
                    openCamera();
                }
            }
        });
    }

    private boolean openCamera() {
        mCamera = Camera.open();
        mCameraParameters = mCamera.getParameters();
        mCameraParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        return true;
    }
/*
    private boolean getFlashlightEnabled() {
        try {
            return IHardwareService.Stub.asInterface(
                    (IBinder) Class.forName("android.os.ServiceManager")
                            .getMethod("getService", new Class[] {
                                    String.class
                            }).invoke(null, new Object[] {
                                    "hardware"
                            })).getFlashlightEnabled();
        } catch (Exception e) {
            return false;
        }
    }
*/
}
