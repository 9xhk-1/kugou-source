package com.kugou.common.permission.checker;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* JADX INFO: loaded from: classes2.dex */
public class CameraTest implements PermissionTest {
    private Context mContext;
    private static final Camera.PreviewCallback PREVIEW_CALLBACK = new Camera.PreviewCallback() { // from class: com.kugou.common.permission.checker.CameraTest.1
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    };
    private static final SurfaceHolder.Callback CALLBACK = new SurfaceHolder.Callback() { // from class: com.kugou.common.permission.checker.CameraTest.2
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    };

    public CameraTest(Context context) {
        this.mContext = context;
    }

    @Override // com.kugou.common.permission.checker.PermissionTest
    public boolean test() throws Throwable {
        Camera cameraOpen;
        SurfaceHolder holder = new SurfaceView(this.mContext).getHolder();
        holder.addCallback(CALLBACK);
        try {
            cameraOpen = Camera.open();
            try {
                cameraOpen.setParameters(cameraOpen.getParameters());
                cameraOpen.setPreviewDisplay(holder);
                cameraOpen.setPreviewCallback(PREVIEW_CALLBACK);
                cameraOpen.startPreview();
                return true;
            } catch (Throwable unused) {
                try {
                    boolean z = !this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera");
                    if (cameraOpen != null) {
                        cameraOpen.stopPreview();
                        cameraOpen.setPreviewDisplay(null);
                        cameraOpen.setPreviewCallback(null);
                        cameraOpen.release();
                    }
                    return z;
                } finally {
                    if (cameraOpen != null) {
                        cameraOpen.stopPreview();
                        cameraOpen.setPreviewDisplay(null);
                        cameraOpen.setPreviewCallback(null);
                        cameraOpen.release();
                    }
                }
            }
        } catch (Throwable unused2) {
            cameraOpen = null;
        }
    }
}
