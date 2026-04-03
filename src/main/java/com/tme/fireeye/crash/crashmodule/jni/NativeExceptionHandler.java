package com.tme.fireeye.crash.crashmodule.jni;

import com.tme.fireeye.crash.crashmodule.CrashDetailBean;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface NativeExceptionHandler {
    void handleNativeException(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7);

    void handleNativeException2(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7, String[] strArr);

    CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2);
}
