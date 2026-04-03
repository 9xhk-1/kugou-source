package com.kugou.common.player.kugouplayer;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class CameraRender implements GLSurfaceView.Renderer, Camera.PreviewCallback {
    private static final int MaxBeforeProcessQueueSize = 1;
    private RenderInterface mController;
    private int mDegress;
    private boolean mFlipHorizontal;
    private boolean mFlipVertical;
    private int mImageHeight;
    private int mImageWidth;
    public boolean mUseOpenGL;
    private SurfaceTexture mSurfaceTexture = null;
    private int mFilterType = 0;
    private boolean mGaussFilterFlag = false;
    public int mLastLeft = -1;
    public int mLastTop = -1;
    public int mLastWidth = -1;
    public int mLastHeight = -1;
    private final Queue<byte[]> mBeforeProcessFrameQueue = new LinkedList();
    private final Queue<byte[]> mAfterProcessFrameQueue = new LinkedList();

    public interface RenderInterface {
        void changeFilterType(int i2, int i3);

        void render(byte[] bArr, int i2, int i3);

        void setDisplayRecordVideo(boolean z);

        void setRecodeDisplayArea(int i2, int i3, int i4, int i5);

        void setRotation(int i2, int i3, int i4);
    }

    public CameraRender(RenderInterface renderInterface, boolean z) {
        this.mController = renderInterface;
        this.mUseOpenGL = z;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void changeFilterType(int i2) {
        this.mFilterType = i2;
        RenderInterface renderInterface = this.mController;
        if (renderInterface != null) {
            renderInterface.changeFilterType(i2, this.mGaussFilterFlag ? 1 : 0);
        }
    }

    public int getFilterType() {
        return this.mFilterType;
    }

    public boolean getGaussFilterFlag() {
        return this.mGaussFilterFlag;
    }

    public SurfaceTexture getSurfaceTexture() {
        if (this.mSurfaceTexture == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9728.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            this.mSurfaceTexture = new SurfaceTexture(iArr[0]);
        }
        return this.mSurfaceTexture;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.mUseOpenGL) {
            synchronized (this) {
                if (this.mBeforeProcessFrameQueue.isEmpty()) {
                    this.mController.render(null, this.mImageWidth, this.mImageHeight);
                    return;
                }
                byte[] bArrPoll = this.mBeforeProcessFrameQueue.poll();
                RenderInterface renderInterface = this.mController;
                if (renderInterface != null) {
                    renderInterface.render(bArrPoll, this.mImageWidth, this.mImageHeight);
                }
                synchronized (this) {
                    this.mAfterProcessFrameQueue.offer(bArrPoll);
                }
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            if (this.mUseOpenGL) {
                if (this.mBeforeProcessFrameQueue.isEmpty()) {
                    this.mBeforeProcessFrameQueue.add(bArr);
                } else {
                    camera.addCallbackBuffer(bArr);
                }
                if (this.mAfterProcessFrameQueue.size() > 0) {
                    camera.addCallbackBuffer(this.mAfterProcessFrameQueue.poll());
                }
            } else {
                RenderInterface renderInterface = this.mController;
                if (renderInterface != null) {
                    renderInterface.render(bArr, this.mImageWidth, this.mImageHeight);
                }
                camera.addCallbackBuffer(bArr);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.mController.setRecodeDisplayArea(0, 0, i2, i3);
        this.mLastLeft = 0;
        this.mLastTop = 0;
        this.mLastWidth = i2;
        this.mLastHeight = i3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        RenderInterface renderInterface = this.mController;
        if (renderInterface != null) {
            renderInterface.setDisplayRecordVideo(true);
            this.mController.setRotation(this.mDegress, this.mFlipHorizontal ? 1 : 0, this.mFlipVertical ? 1 : 0);
        }
    }

    public void setGaussFilterFlag(boolean z) {
        this.mGaussFilterFlag = z;
        RenderInterface renderInterface = this.mController;
        if (renderInterface != null) {
            renderInterface.changeFilterType(this.mFilterType, z ? 1 : 0);
        }
    }

    public void setImageSize(int i2, int i3) {
        this.mImageWidth = i2;
        this.mImageHeight = i3;
    }

    public void setRotation(int i2, boolean z, boolean z2) {
        this.mDegress = i2;
        this.mFlipHorizontal = z;
        this.mFlipVertical = z2;
        RenderInterface renderInterface = this.mController;
        if (renderInterface != null) {
            renderInterface.setRotation(i2, z ? 1 : 0, z2 ? 1 : 0);
        }
    }
}
