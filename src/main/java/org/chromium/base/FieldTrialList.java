package org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class FieldTrialList {
    private static native String nativeFindFullName(String str);

    private static native String nativeGetVariationParameter(String str, String str2);

    private static native boolean nativeTrialExists(String str);
}
