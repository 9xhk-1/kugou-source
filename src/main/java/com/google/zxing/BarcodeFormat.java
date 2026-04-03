package com.google.zxing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface BarcodeFormat {
    public static final int AZTEC = 1;
    public static final int CODABAR = 2;
    public static final int CODE_128 = 5;
    public static final int CODE_39 = 3;
    public static final int CODE_93 = 4;
    public static final int DATA_MATRIX = 6;
    public static final int EAN_13 = 8;
    public static final int EAN_8 = 7;
    public static final int ITF = 9;
    public static final int MAXICODE = 10;
    public static final int PDF_417 = 11;
    public static final int QR_CODE = 12;
    public static final int RSS_14 = 13;
    public static final int RSS_EXPANDED = 14;
    public static final int UPC_A = 15;
    public static final int UPC_E = 16;
    public static final int UPC_EAN_EXTENSION = 17;
}
