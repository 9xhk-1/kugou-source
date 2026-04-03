package com.kugou.common.player.kugouplayer;

import android.os.Environment;
import e.c.e.b.b.b;

/* JADX INFO: loaded from: classes2.dex */
public class JniGlobal {
    public static JniGlobalEventListen _listen;

    public static native long createCobj(String str, Object[] objArr, byte[] bArr);

    public static native int deleteCobj(String str, long j);

    public static native byte[] getValue(String str, long j, String str2, Object[] objArr, byte[] bArr);

    public static native void makeNativeCrash(String str);

    public static void nativeCrashed(Object[] objArr) {
        if (objArr != null) {
            for (Object obj : objArr) {
                if (b.f().debug()) {
                    b.f().d("vz-JniGlobal-nativeCrashed", "msg " + obj);
                }
            }
        }
        JniGlobalEventListen jniGlobalEventListen = _listen;
        if (jniGlobalEventListen == null) {
            return;
        }
        jniGlobalEventListen.onNativeCrashed((String[]) objArr);
    }

    public static String nativeGetDmpAbsPath() {
        return Environment.getExternalStorageDirectory() + "/kugou/log/dmp";
    }

    public static void setEventListen(JniGlobalEventListen jniGlobalEventListen) {
        _listen = jniGlobalEventListen;
    }

    public static native void setRunTimeDebug(boolean z);

    public static native int setValue(String str, long j, String str2, Object[] objArr, byte[] bArr);
}
