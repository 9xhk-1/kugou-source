package com.kugou.common.player.kugouplayer;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class NativeMediaSource {
    private static String TAG = "nativeMediaSource";
    private static boolean mLibraryLoadSuccess = LibraryManager.loadLibrary();
    private int mNativeContext;
    private long mNativeObject = 0;

    public NativeMediaSource() {
        if (!mLibraryLoadSuccess) {
            Log.e(TAG, "==aaa===mLibraryLoadSuccess is false");
        } else {
            Log.d(TAG, "==aaa===mLibraryLoadSuccess");
            Setup();
        }
    }

    private void Setup() {
        long jNativeSetup = nativeSetup();
        this.mNativeObject = jNativeSetup;
        if (jNativeSetup == 0) {
            Log.e(TAG, "==aaa===Setup failed");
            return;
        }
        Log.d(TAG, "==aaa===Setup mNativeObject:" + this.mNativeObject);
    }

    private native void nativeClearBuffer(long j);

    private native int nativeIsFull(long j, int i2);

    private native void nativeRelease(long j);

    private native int nativeSetAudioTrack(long j, int i2, int i3, int i4, int i5, int i6);

    private native int nativeSetDuration(long j, long j2);

    private native void nativeSetSeekState(long j, int i2, int i3);

    private native int nativeSetVideoTrack(long j, int i2, int i3, int i4, int i5, int i6);

    private native long nativeSetup();

    private native void nativeStop(long j);

    private native int nativeWaitRender(long j, int i2);

    private native int nativeWaitWrite(long j, int i2);

    private native int nativeWriteSampleDate(long j, int i2, ByteBuffer byteBuffer, int i3, int i4, long j2, int i5);

    public void ClearBuffer() {
        long j = this.mNativeObject;
        if (j != 0) {
            nativeClearBuffer(j);
        } else {
            Log.e(TAG, "==aaa===ClearBuffer mNativeObject is null");
        }
    }

    public boolean IsFull(int i2) {
        long j = this.mNativeObject;
        if (j != 0) {
            return nativeIsFull(j, i2) > 0;
        }
        Log.e(TAG, "==aaa===IsFull mNativeObject is null");
        return false;
    }

    public void Release() {
        long j = this.mNativeObject;
        if (j == 0) {
            Log.e(TAG, "==aaa===Release mNativeObject is null");
        } else {
            nativeRelease(j);
            this.mNativeObject = 0L;
        }
    }

    public int SetAudioTrack(int i2, int i3, int i4, int i5) {
        long j = this.mNativeObject;
        if (j != 0) {
            return nativeSetAudioTrack(j, i2, i3, i4, 1, i5);
        }
        Log.e(TAG, "==aaa===AddAudioTrack mNativeObject is null");
        return -1;
    }

    public int SetDuration(long j) {
        long j2 = this.mNativeObject;
        if (j2 != 0 && j > 0) {
            return nativeSetDuration(j2, j);
        }
        Log.e(TAG, "==aaa===SetDuration mNativeObject is null or durationUs( " + j + ") invalid");
        return -1;
    }

    public void SetSeekState(int i2, boolean z) {
        long j = this.mNativeObject;
        if (j != 0) {
            nativeSetSeekState(j, i2, z ? 1 : 0);
        } else {
            Log.e(TAG, "==aaa===SetSeekState mNativeObject is null");
        }
    }

    public int SetVideoTrack(int i2, MediaFormat mediaFormat, String str, int i3, int i4, int i5, int i6) {
        long j = this.mNativeObject;
        if (j != 0) {
            return nativeSetVideoTrack(j, i2, i3, i4, i5, i6);
        }
        Log.e(TAG, "==aaa===AddVideoTrack mNativeObject is null");
        return 0;
    }

    public void Stop() {
        long j = this.mNativeObject;
        if (j != 0) {
            nativeStop(j);
        } else {
            Log.e(TAG, "==aaa===Stop mNativeObject is null");
        }
    }

    public int WaitRender(int i2) {
        long j = this.mNativeObject;
        if (j != 0) {
            return nativeWaitRender(j, i2);
        }
        Log.e(TAG, "==aaa===WaitWrite mNativeObject is null");
        return 0;
    }

    public int WaitWrite(int i2) {
        long j = this.mNativeObject;
        if (j != 0) {
            return nativeWaitWrite(j, i2);
        }
        Log.e(TAG, "==aaa===WaitWrite mNativeObject is null");
        return 0;
    }

    public int WriteSampleDate(int i2, ByteBuffer byteBuffer, int i3, int i4, long j, int i5) {
        long j2 = this.mNativeObject;
        if (j2 != 0) {
            return nativeWriteSampleDate(j2, i2, byteBuffer, i3, i4, j, i5);
        }
        Log.e(TAG, "==aaa===WriteSampleDate mNativeObject is null");
        return 0;
    }

    public long getMvMediaSource() {
        return this.mNativeObject;
    }

    public void parseFormat(MediaFormat mediaFormat, String str) {
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        int integer3 = mediaFormat.getInteger("stride");
        if (integer3 <= 0) {
            integer3 = integer;
        }
        int integer4 = mediaFormat.getInteger("slice-heigh");
        if (integer4 <= 0) {
            integer4 = integer2;
        }
        if (str.indexOf("OMX.Nvidia.") >= 0) {
            integer4 = ((integer2 + 15) / 16) * 16;
        } else if (str.indexOf("OMX.SEC.avc.dec") >= 0) {
            integer3 = integer;
            integer4 = integer2;
        }
        int integer5 = mediaFormat.getInteger("color-format");
        if (str.indexOf("OMX.k3.video.decoder.avc") >= 0 && integer5 == 25) {
            integer5 = 2130706688;
        }
        int integer6 = mediaFormat.getInteger("crop-top");
        int integer7 = mediaFormat.getInteger("crop-bottom");
        int integer8 = mediaFormat.getInteger("crop-left");
        int integer9 = mediaFormat.getInteger("crop-right");
        Log.d(TAG, "mediacodec_dec_parse_format: width=" + integer + " stride=" + integer3 + " height=" + integer2 + " slice-height=" + integer4 + " crop-top=" + integer6 + " crop-bottom=" + integer7 + " crop-left=" + integer8 + " crop-right=" + integer9 + " decoder=" + str + " color-format:" + integer5);
    }
}
