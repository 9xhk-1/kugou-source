package e.f.a.a.b.h;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {
    public final Handler a;
    public final String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1403d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1404f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1405h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1406i;

    public a(Handler handler, String str, long j) {
        this.a = handler;
        this.b = str;
        this.f1403d = j;
        this.f1404f = j;
    }

    public int a() {
        if (this.f1405h) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f1406i < this.f1403d ? 1 : 3;
    }

    public Looper b() {
        return this.a.getLooper();
    }

    public String c() {
        return this.b;
    }

    public boolean d() {
        return !this.f1405h && SystemClock.uptimeMillis() > this.f1406i + this.f1403d;
    }

    public void e() {
        this.f1403d = this.f1404f;
    }

    public void f() {
        if (this.f1405h) {
            this.f1405h = false;
            this.f1406i = SystemClock.uptimeMillis();
            this.a.post(this);
        }
    }

    public void g(long j) {
        this.f1403d = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1405h = true;
        e();
    }
}
