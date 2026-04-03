package e.c.e.a.a.d;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e.c.e.a.a.b {
    @Override // e.c.e.a.a.b
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // e.c.e.a.a.b
    public boolean debug() {
        return false;
    }

    @Override // e.c.e.a.a.b
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // e.c.e.a.a.b
    public void eLF(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // e.c.e.a.a.b
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // e.c.e.a.a.b
    public void iLF(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // e.c.e.a.a.b
    public void s(String str, String str2) {
        Log.d(str, str2 + "\n" + Log.getStackTraceString(new Throwable()));
    }

    @Override // e.c.e.a.a.b
    public void uploadException(Exception exc) {
        exc.printStackTrace();
    }

    @Override // e.c.e.a.a.b
    public void w(String str, String str2) {
        Log.w(str, str2);
    }
}
