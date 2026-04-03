package com.kugou.common.player.kugouplayer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;

/* JADX INFO: loaded from: classes2.dex */
public class CameraHelper {
    public CameraHelper(Context context) {
    }

    private int getCameraId(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == i2) {
                return i3;
            }
        }
        return -1;
    }

    public int getCameraDisplayOrientation(Activity activity, int i2) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        getCameraInfo(i2, cameraInfo);
        return cameraInfo.facing == 1 ? (cameraInfo.orientation + i3) % ShareCloudFileResource.HEIGHT : ((cameraInfo.orientation - i3) + ShareCloudFileResource.HEIGHT) % ShareCloudFileResource.HEIGHT;
    }

    public void getCameraInfo(int i2, Camera.CameraInfo cameraInfo) {
        Camera.getCameraInfo(i2, cameraInfo);
    }

    public int getNumberOfCameras() {
        return Camera.getNumberOfCameras();
    }

    public int hasBackCamera() {
        return getCameraId(0);
    }

    public int hasFrontCamera() {
        return getCameraId(1);
    }

    public Camera openBackCamera() {
        return Camera.open(getCameraId(0));
    }

    public Camera openCamera(int i2) {
        return Camera.open(i2);
    }

    public Camera openDefaultCamera() {
        return Camera.open();
    }

    public Camera openFrontCamera() {
        return Camera.open(getCameraId(1));
    }

    public void setCameraDisplayOrientation(Activity activity, int i2, Camera camera) {
        camera.setDisplayOrientation(getCameraDisplayOrientation(activity, i2));
    }
}
