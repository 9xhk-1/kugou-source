package com.google.webp;

/* JADX INFO: loaded from: classes.dex */
public class libwebp {
    private static final int UNUSED = 1;
    private static int[] outputSize = {0};

    public static byte[] WebPDecodeARGB(byte[] bArr, long j, int[] iArr, int[] iArr2) {
        return libwebpJNI.WebPDecodeARGB(bArr, j, iArr, iArr2);
    }

    public static byte[] WebPDecodeBGR(byte[] bArr, long j, int[] iArr, int[] iArr2) {
        return libwebpJNI.WebPDecodeBGR(bArr, j, iArr, iArr2);
    }

    public static byte[] WebPDecodeBGRA(byte[] bArr, long j, int[] iArr, int[] iArr2) {
        return libwebpJNI.WebPDecodeBGRA(bArr, j, iArr, iArr2);
    }

    public static byte[] WebPDecodeRGB(byte[] bArr, long j, int[] iArr, int[] iArr2) {
        return libwebpJNI.WebPDecodeRGB(bArr, j, iArr, iArr2);
    }

    public static byte[] WebPDecodeRGBA(byte[] bArr, long j, int[] iArr, int[] iArr2) {
        return libwebpJNI.WebPDecodeRGBA(bArr, j, iArr, iArr2);
    }

    public static byte[] WebPEncodeBGR(byte[] bArr, int i2, int i3, int i4, float f2) {
        return wrap_WebPEncodeBGR(bArr, 1, 1, outputSize, i2, i3, i4, f2);
    }

    public static byte[] WebPEncodeBGRA(byte[] bArr, int i2, int i3, int i4, float f2) {
        return wrap_WebPEncodeBGRA(bArr, 1, 1, outputSize, i2, i3, i4, f2);
    }

    public static byte[] WebPEncodeLosslessBGR(byte[] bArr, int i2, int i3, int i4) {
        return wrap_WebPEncodeLosslessBGR(bArr, 1, 1, outputSize, i2, i3, i4);
    }

    public static byte[] WebPEncodeLosslessBGRA(byte[] bArr, int i2, int i3, int i4) {
        return wrap_WebPEncodeLosslessBGRA(bArr, 1, 1, outputSize, i2, i3, i4);
    }

    public static byte[] WebPEncodeLosslessRGB(byte[] bArr, int i2, int i3, int i4) {
        return wrap_WebPEncodeLosslessRGB(bArr, 1, 1, outputSize, i2, i3, i4);
    }

    public static byte[] WebPEncodeLosslessRGBA(byte[] bArr, int i2, int i3, int i4) {
        return wrap_WebPEncodeLosslessRGBA(bArr, 1, 1, outputSize, i2, i3, i4);
    }

    public static byte[] WebPEncodeRGB(byte[] bArr, int i2, int i3, int i4, float f2) {
        return wrap_WebPEncodeRGB(bArr, 1, 1, outputSize, i2, i3, i4, f2);
    }

    public static byte[] WebPEncodeRGBA(byte[] bArr, int i2, int i3, int i4, float f2) {
        return wrap_WebPEncodeRGBA(bArr, 1, 1, outputSize, i2, i3, i4, f2);
    }

    public static int WebPGetDecoderVersion() {
        return libwebpJNI.WebPGetDecoderVersion();
    }

    public static int WebPGetEncoderVersion() {
        return libwebpJNI.WebPGetEncoderVersion();
    }

    public static int WebPGetInfo(byte[] bArr, long j, int[] iArr, int[] iArr2) {
        return libwebpJNI.WebPGetInfo(bArr, j, iArr, iArr2);
    }

    private static byte[] wrap_WebPEncodeBGR(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2) {
        return libwebpJNI.wrap_WebPEncodeBGR(bArr, i2, i3, iArr, i4, i5, i6, f2);
    }

    private static byte[] wrap_WebPEncodeBGRA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2) {
        return libwebpJNI.wrap_WebPEncodeBGRA(bArr, i2, i3, iArr, i4, i5, i6, f2);
    }

    private static byte[] wrap_WebPEncodeLosslessBGR(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6) {
        return libwebpJNI.wrap_WebPEncodeLosslessBGR(bArr, i2, i3, iArr, i4, i5, i6);
    }

    private static byte[] wrap_WebPEncodeLosslessBGRA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6) {
        return libwebpJNI.wrap_WebPEncodeLosslessBGRA(bArr, i2, i3, iArr, i4, i5, i6);
    }

    private static byte[] wrap_WebPEncodeLosslessRGB(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6) {
        return libwebpJNI.wrap_WebPEncodeLosslessRGB(bArr, i2, i3, iArr, i4, i5, i6);
    }

    private static byte[] wrap_WebPEncodeLosslessRGBA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6) {
        return libwebpJNI.wrap_WebPEncodeLosslessRGBA(bArr, i2, i3, iArr, i4, i5, i6);
    }

    private static byte[] wrap_WebPEncodeRGB(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2) {
        return libwebpJNI.wrap_WebPEncodeRGB(bArr, i2, i3, iArr, i4, i5, i6, f2);
    }

    private static byte[] wrap_WebPEncodeRGBA(byte[] bArr, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f2) {
        return libwebpJNI.wrap_WebPEncodeRGBA(bArr, i2, i3, iArr, i4, i5, i6, f2);
    }
}
