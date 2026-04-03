package e.c.a.g.a.f.m;

import android.content.Context;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.tencent.mmkv.MMKV;
import e.c.a.g.a.s.g0;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();

    public final boolean a(String str) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
        if (mmkvDefaultMMKV == null) {
            return false;
        }
        return mmkvDefaultMMKV.contains(str);
    }

    public final int b(String str, int i2) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        return mmkvDefaultMMKV == null ? i2 : mmkvDefaultMMKV.decodeInt(str, i2);
    }

    public final long c(String str, long j) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        return mmkvDefaultMMKV == null ? j : mmkvDefaultMMKV.decodeLong(str, j);
    }

    public final String d(String str, String str2) {
        String strDecodeString;
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        return (mmkvDefaultMMKV == null || (strDecodeString = mmkvDefaultMMKV.decodeString(str, str2)) == null) ? str2 : strDecodeString;
    }

    public final boolean e(String str, boolean z) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        return mmkvDefaultMMKV == null ? z : mmkvDefaultMMKV.decodeBool(str, z);
    }

    public final void f(Context context) {
        j.e(context, "context");
        String strInitialize = MMKV.initialize(context);
        if (g0.a) {
            g0.b(KGApplication.TAG, j.l("mmkv root: ", strInitialize));
        }
    }

    public final void g(String str, int i2) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        if (mmkvDefaultMMKV == null) {
            return;
        }
        mmkvDefaultMMKV.encode(str, i2);
    }

    public final void h(String str, long j) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        if (mmkvDefaultMMKV == null) {
            return;
        }
        mmkvDefaultMMKV.encode(str, j);
    }

    public final void i(String str, String str2) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        if (mmkvDefaultMMKV == null) {
            return;
        }
        mmkvDefaultMMKV.encode(str, str2);
    }

    public final void j(String str, boolean z) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV(2, "");
        if (mmkvDefaultMMKV == null) {
            return;
        }
        mmkvDefaultMMKV.encode(str, z);
    }

    public final void k(String str) {
        j.e(str, "key");
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
        if (mmkvDefaultMMKV == null) {
            return;
        }
        mmkvDefaultMMKV.removeValueForKey(str);
    }
}
