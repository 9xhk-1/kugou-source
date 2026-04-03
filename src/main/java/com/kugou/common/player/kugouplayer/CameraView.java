package com.kugou.common.player.kugouplayer;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.view.SurfaceView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.common.player.kugouplayer.CameraRender;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class CameraView {
    private final CameraRender mRenderer;
    private boolean mUseOpenGL;
    private GLSurfaceView mGlSurfaceView = null;
    private SurfaceView mSurfaceView = null;

    public CameraView(Context context, CameraRender.RenderInterface renderInterface, boolean z) {
        this.mUseOpenGL = true;
        this.mUseOpenGL = z;
        if (z && !supportsOpenGLES2(context)) {
            throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
        }
        this.mRenderer = new CameraRender(renderInterface, z);
    }

    private boolean supportsOpenGLES2(Context context) {
        return ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void changeFilterType(int i2) {
        this.mRenderer.changeFilterType(i2);
    }

    public int getFilterType() {
        return this.mRenderer.getFilterType();
    }

    public boolean getGaussFilterFlag() {
        return this.mRenderer.getGaussFilterFlag();
    }

    public void pauseRender() {
        GLSurfaceView gLSurfaceView = this.mGlSurfaceView;
        if (gLSurfaceView != null) {
            gLSurfaceView.onPause();
        }
    }

    public void requestRender() {
        GLSurfaceView gLSurfaceView = this.mGlSurfaceView;
        if (gLSurfaceView != null) {
            gLSurfaceView.onResume();
            this.mGlSurfaceView.requestRender();
        }
    }

    public void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        this.mGlSurfaceView = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.mGlSurfaceView.setRenderer(this.mRenderer);
        this.mGlSurfaceView.setRenderMode(0);
    }

    public void setGaussFilterFlag(boolean z) {
        this.mRenderer.setGaussFilterFlag(z);
    }

    public void setSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
    }

    public void setUpCamera(Camera camera) {
        setUpCamera(camera, 0, false, false);
    }

    public void startPreview(Camera camera) {
        camera.startPreview();
    }

    public void setUpCamera(Camera camera, int i2, boolean z, boolean z2) {
        GLSurfaceView gLSurfaceView = this.mGlSurfaceView;
        if (gLSurfaceView != null) {
            gLSurfaceView.setRenderMode(1);
        }
        try {
            if (this.mUseOpenGL) {
                camera.setPreviewTexture(this.mRenderer.getSurfaceTexture());
            } else if (this.mSurfaceView.getHolder() != null) {
                camera.setPreviewDisplay(this.mSurfaceView.getHolder());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        camera.setPreviewCallbackWithBuffer(this.mRenderer);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        this.mRenderer.setImageSize(previewSize.width, previewSize.height);
        this.mRenderer.setRotation(i2, z, z2);
        if (z2) {
            i2 = 360 - i2;
        }
        camera.setDisplayOrientation(i2);
    }
}
