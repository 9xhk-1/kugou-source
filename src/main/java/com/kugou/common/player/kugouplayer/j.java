package com.kugou.common.player.kugouplayer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static final j a = new j();
    public static boolean hh = false;
    public static String hhMessage;
    public static boolean hhSend;
    public boolean b;
    private long mNativeContext;

    public static class A {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f246e = 0;
        public byte[] a = null;
        public byte[] r = null;
    }

    public j() {
    }

    public static native String _t(Object obj);

    public static native Object _u(Object obj);

    private static native byte[] _v(byte[] bArr, byte[] bArr2);

    private native String _x(Object obj);

    private static native byte[] _y(int i2, byte[] bArr);

    public static synchronized j a(Context context) throws Exception {
        return a.b(context);
    }

    public static final synchronized boolean hh() {
        boolean z = hh;
        if (z) {
            return z;
        }
        try {
            System.loadLibrary("j");
            hh = true;
        } catch (Exception e2) {
            g0.k(e2);
            hh = false;
            hhMessage = Log.getStackTraceString(e2);
        } catch (UnsatisfiedLinkError e3) {
            g0.j(e3);
            hh = false;
            hhMessage = Log.getStackTraceString(e3);
        }
        boolean z2 = hh;
        if (!z2 && !hhSend) {
            hhSend = true;
        }
        return z2;
    }

    public static String t(byte[] bArr) {
        return hh() ? _t(bArr) : "";
    }

    public static A u(byte[] bArr) {
        Object obj_u;
        if (!hh()) {
            return null;
        }
        try {
            obj_u = _u(bArr);
        } catch (Error unused) {
            obj_u = null;
        }
        if (obj_u != null) {
            return (A) obj_u;
        }
        return null;
    }

    public static byte[] v(byte[] bArr, byte[] bArr2) {
        if (hh()) {
            try {
                return _v(bArr, bArr2);
            } catch (Error unused) {
            }
        }
        return null;
    }

    public static byte[] y(int i2, byte[] bArr) {
        return _y(i2, bArr);
    }

    public native int _c(Object obj);

    public native String _d(Object obj);

    public native String _e(Object obj);

    public native int _f(Object obj);

    public native String _h(Object obj);

    public native String _i(Object obj);

    public native int _k(Object obj);

    public native synchronized void _l(Object obj);

    public native synchronized String _m(Object obj);

    public native synchronized void _n(Object obj);

    public native synchronized byte[] _o(Object obj);

    public native synchronized boolean _p(Object obj);

    public native synchronized String _q(Object obj);

    public native synchronized long _r(Object obj);

    public native synchronized long _s(Object obj);

    public j b(Context context) throws Exception {
        if (!hh()) {
            throw new Exception("Cannot load library");
        }
        if (!this.b) {
            this.b = _k(context.getApplicationContext()) == 0;
        }
        return this;
    }

    public int c(Object obj) {
        return _c(obj);
    }

    public String d(Object obj) {
        return _d(obj);
    }

    public String e(Object obj) {
        return _e(obj);
    }

    public int f(Object obj) {
        return _f(obj);
    }

    public String g(Object obj) {
        return i(j(obj));
    }

    public String h(Object obj) {
        return _h(obj);
    }

    public String i(Object obj) {
        return _i(obj);
    }

    public List<Pair<byte[], byte[]>> j(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    String string = key.toString();
                    String string2 = value.toString();
                    if (!TextUtils.isEmpty(string) && string2 != null) {
                        byte[] bytes = string2.getBytes();
                        byte[] bArr = new byte[bytes.length + 1];
                        if (value instanceof Integer) {
                            bArr[0] = 73;
                        } else if (value instanceof Long) {
                            bArr[0] = 74;
                        } else if (value instanceof Float) {
                            bArr[0] = 70;
                        } else if (value instanceof Double) {
                            bArr[0] = 68;
                        } else {
                            bArr[0] = 83;
                        }
                        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
                        arrayList.add(new Pair(string.getBytes(), bArr));
                    }
                }
            }
        }
        return arrayList;
    }

    public void l(String str) {
        _l(str);
    }

    public String m(Object obj) {
        return _m(obj == null ? null : obj.toString());
    }

    public void n(String str) {
        _n(str);
    }

    public byte[] o(byte[] bArr) {
        return _o(bArr);
    }

    public boolean p(Object obj) {
        return _p(obj);
    }

    public String q(Object obj) {
        return _q(obj);
    }

    public long r(Object obj) {
        return _r(obj);
    }

    public native synchronized void release(Object obj);

    public long s(Object obj) {
        return _s(obj);
    }

    public String x(Map<?, ?> map) {
        return _x(j(map));
    }

    public j(Context context) throws Exception {
        if (!hh()) {
            throw new Exception("Cannot load library");
        }
        this.b = _k(context.getApplicationContext()) == 0;
    }
}
