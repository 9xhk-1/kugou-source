package com.kugou.common.player.kugouplayer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.Camera;
import android.util.Log;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CameraLoader {
    private Activity mActivity;
    private CameraHelper mCameraHelper;
    private CameraView mCameraView;
    private int mCurrentCameraId;
    private Camera mCameraInstance = null;
    private int mPreviewWidth = ShareCloudFileResource.WIDTH;
    private int mPreviewHeight = OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_3;

    public CameraLoader(int i2, Activity activity, CameraHelper cameraHelper, CameraView cameraView) {
        this.mCurrentCameraId = 0;
        this.mCameraHelper = null;
        this.mCameraView = null;
        this.mActivity = null;
        this.mCurrentCameraId = i2;
        this.mActivity = activity;
        this.mCameraHelper = cameraHelper;
        this.mCameraView = cameraView;
    }

    private Camera getCameraInstance(int i2) {
        try {
            return this.mCameraHelper.openCamera(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Camera.Size> getSupportPrevideSizes() {
        Camera camera = this.mCameraInstance;
        if (camera != null) {
            return camera.getParameters().getSupportedPreviewSizes();
        }
        return null;
    }

    public void releaseCamera() {
        this.mCameraInstance.setPreviewCallback(null);
        this.mCameraInstance.release();
        this.mCameraInstance = null;
    }

    public void setPreviewSize(int i2, int i3) {
        this.mPreviewWidth = i2;
        this.mPreviewHeight = i3;
    }

    public void setUpCamera() {
        setUpCamera(this.mActivity, this.mCurrentCameraId);
    }

    public void startPreview() {
        this.mCameraView.startPreview(this.mCameraInstance);
    }

    public void switchCamera() {
        releaseCamera();
        int numberOfCameras = (this.mCurrentCameraId + 1) % this.mCameraHelper.getNumberOfCameras();
        this.mCurrentCameraId = numberOfCameras;
        setUpCamera(this.mActivity, numberOfCameras);
        startPreview();
    }

    @SuppressLint({"InlinedApi"})
    private void setUpCamera(Activity activity, int i2) {
        if (this.mCameraInstance != null) {
            return;
        }
        Camera cameraInstance = getCameraInstance(i2);
        this.mCameraInstance = cameraInstance;
        Camera.Parameters parameters = cameraInstance.getParameters();
        parameters.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
        if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        }
        parameters.setPreviewFormat(17);
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= supportedPreviewFpsRange.size()) {
                    break;
                }
                int[] iArr = supportedPreviewFpsRange.get(i3);
                if (iArr[0] <= 25000 && iArr[1] >= 25000) {
                    parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                    Log.d("CameraLoader", "FpsRange " + iArr[0] + " to " + iArr[1]);
                    break;
                }
                i3++;
            }
        }
        this.mCameraInstance.setParameters(parameters);
        Camera.Size previewSize = this.mCameraInstance.getParameters().getPreviewSize();
        List<Camera.Size> supportedPreviewSizes = this.mCameraInstance.getParameters().getSupportedPreviewSizes();
        if (supportedPreviewSizes != null) {
            for (Camera.Size size : supportedPreviewSizes) {
                Log.d("RecordAndPlayActivity", String.format("size(%d, %d)", Integer.valueOf(size.width), Integer.valueOf(size.height)));
            }
        }
        int i4 = (((((previewSize.width + 15) / 16) * 16) * 3) * (((previewSize.height + 15) / 16) * 16)) / 2;
        for (int i5 = 0; i5 < 3; i5++) {
            this.mCameraInstance.addCallbackBuffer(new byte[i4]);
        }
        int cameraDisplayOrientation = this.mCameraHelper.getCameraDisplayOrientation(activity, this.mCurrentCameraId);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.mCameraHelper.getCameraInfo(this.mCurrentCameraId, cameraInfo);
        int i6 = cameraInfo.facing;
        this.mCameraView.setUpCamera(this.mCameraInstance, cameraDisplayOrientation, i6 == 1, i6 == 1);
    }
}
