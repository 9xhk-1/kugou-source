package e.f.a.a.b.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public boolean a = false;
    public final ConcurrentLinkedQueue<Long> b = new ConcurrentLinkedQueue<>();
    public final ConcurrentLinkedQueue<Long> c = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1400d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f1401e;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (d.this.f1400d == 0) {
                d.this.f1400d = SystemClock.elapsedRealtime();
                d.this.f1401e.sendEmptyMessageDelayed(1, 2500L);
                return;
            }
            if (d.this.b.size() == 20) {
                d.this.b.poll();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (d.this.c.size() == 20) {
                d.this.c.poll();
            }
            d.this.c.add(Long.valueOf(jElapsedRealtime));
            d.this.b.add(Long.valueOf(jElapsedRealtime - d.this.f1400d));
            d.this.f1400d = jElapsedRealtime;
            d.this.f1401e.sendEmptyMessageDelayed(1, 2500L);
        }
    }

    public ArrayList<Long> f() {
        ArrayList<Long> arrayList = new ArrayList<>(this.b);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f1400d;
        if (jElapsedRealtime > 2500) {
            arrayList.add(Long.valueOf(jElapsedRealtime));
        }
        return arrayList;
    }

    public void g() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.f1401e = new a(e.f.a.b.a.m.e.a.f());
        this.f1400d = SystemClock.elapsedRealtime();
        this.f1401e.sendEmptyMessageDelayed(1, 2500L);
    }

    public void h() {
        if (this.a) {
            this.a = false;
        }
    }
}
