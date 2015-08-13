package com.chiplua.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Method;

public class FlashLightActivity extends Activity {
    private static Boolean isOpen = false;
    private Camera mCamera = null;
    private Camera.Parameters mCameraParameters = null;
    private ImageView mBgView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);
        mBgView = (ImageView)findViewById(R.id.bg);

        findViewById(R.id.button_switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpen = !isOpen;

                if (isOpen) {
                    setLedOn();
                } else {
                    setLedOff();
                }
            }
        });
    }

    private boolean openCamera() {
        mCamera = Camera.open();
        mCameraParameters = mCamera.getParameters();
        mCameraParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        mCamera.startPreview();
        return true;
    }

    private void closeCamera(){
        if(mCamera != null){
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    private void setLedOn() {
        setFlashlightEnabled(true);
        openCamera();
        mBgView.setImageResource(R.drawable.on);
        mCameraParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        mCamera.setParameters(mCameraParameters);
    }

    private void setLedOff() {
        setFlashlightEnabled(false);
        mBgView.setImageResource(R.drawable.close);
        mCameraParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        mCamera.setParameters(mCameraParameters);
        closeCamera();
    }

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

    private void setFlashlightEnabled(boolean isEnable) {
        try {
            Method method = Class.forName("android.os.ServiceManager").getMethod("getService",
                    String.class);
            IBinder binder = (IBinder) method.invoke(null, new Object[] {
                    "hardware"
            });
            IHardwareService localhardwareservice = IHardwareService.Stub.asInterface(binder);
            localhardwareservice.setFlashlightEnabled(isEnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //back键退出程序

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (isOpen) {
                isOpen = !isOpen;
                setLedOff();
            }
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
