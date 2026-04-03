package com.google.webp;

/* JADX INFO: loaded from: classes.dex */
public class libwebpJNI {
    public static final native byte[] WebPDecodeARGB(byte[] bArr, long j, int[] iArr, int[] iArr2);

    public static final native byte[] WebPDecodeBGR(byte[] bArr, long j, int[] iArr, int[] iArr2);

    public static final native byte[] WebPDecodeBGRA(byte[] bArr, long j, int[] iArr, int[] iArr2);

    public static final native byte[] WebPDecodeRGB(byte[] bArr, long j, int[] iArr, int[] iArr2);

    public static final native byte[] WebPDecodeRGBA(byte[] bArr, long j, int[] iArr, int[] iArr2);

    public static final native int WebPGetDecoderVersion();

    public static final native int WebPGetEncoderVersion();

    public static final native int WebPGetInfo(byte[] bArr, long j, int[] iArr, int[] iArr2);

    public static final native byte[] wrap_WebPEncodeBGR(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2);

    public static final native byte[] wrap_WebPEncodeBGRA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2);

    public static final native byte[] wrap_WebPEncodeLosslessBGR(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6);

    public static final native byte[] wrap_WebPEncodeLosslessBGRA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6);

    public static final native byte[] wrap_WebPEncodeLosslessRGB(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6);

    public static final native byte[] wrap_WebPEncodeLosslessRGBA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6);

    public static final native byte[] wrap_WebPEncodeRGB(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2);

    public static final native byte[] wrap_WebPEncodeRGBA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2);
}
