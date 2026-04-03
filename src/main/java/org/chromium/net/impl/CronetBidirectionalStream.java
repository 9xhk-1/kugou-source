package org.chromium.net.impl;

import h.a.b.f;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class CronetBidirectionalStream extends f {
    private native long nativeCreateBidirectionalStream(long j, boolean z, boolean z2, boolean z3, int i2, boolean z4, int i3);

    private native void nativeDestroy(long j, boolean z);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    private native void nativeSendRequestHeaders(long j);

    private native int nativeStart(long j, String str, int i2, String str2, String[] strArr, boolean z);

    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);
}
