package e.c.a.g.a.d.h.b;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f429g = "b";
    public final Handler a = new Handler(Looper.getMainLooper());
    public final c b = new c();
    public final Object c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedList<d> f430d = new LinkedList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.a f431e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f432f = new RunnableC0052b();

    public class a implements d.a {
        public a() {
        }

        @Override // e.c.a.g.a.d.h.b.b.d.a
        public void onStop(d dVar) {
            b.this.c(dVar);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.h.b.b$b, reason: collision with other inner class name */
    public class RunnableC0052b implements Runnable {
        public RunnableC0052b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.h();
        }
    }

    public static class c {
        public long a() {
            return 0L;
        }

        public long b() {
            long jC = e.c.a.g.a.d.v.e.b().c();
            if (jC <= 0) {
                return 200L;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - jC;
            if (jElapsedRealtime < 0) {
                return 200L;
            }
            long j = 1200 - jElapsedRealtime;
            if (j > 0) {
                return j;
            }
            return 200L;
        }
    }

    public static class d implements Comparable {
        public final Dialog a;
        public float b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f433d;

        public interface a {
            void onStop(d dVar);
        }

        public d(Dialog dialog) {
            this.a = dialog;
        }

        public void a() {
            b.e().i(this);
        }

        public void b() {
            this.a.show();
        }

        public float c() {
            return this.b;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Object obj) {
            float f2 = this.b - ((d) obj).b;
            if (f2 > 0.0f) {
                return 1;
            }
            return f2 < 0.0f ? -1 : 0;
        }

        public boolean d() {
            return this.a.isShowing();
        }

        public void e() {
            a aVar = this.f433d;
            if (aVar != null) {
                aVar.onStop(this);
            }
        }

        public void f(float f2) {
            this.b = f2;
            b.e().f(this);
        }

        public void g(a aVar) {
            this.f433d = aVar;
        }

        public String toString() {
            return "Member-" + this.b;
        }
    }

    public static class e {
        public static final b a = new b();
    }

    public static b e() {
        return e.a;
    }

    public static void g(String str) {
        Log.d(f429g, str);
    }

    public final void c(d dVar) {
        synchronized (this.c) {
            d dVarPeek = this.f430d.peek();
            if (dVarPeek != null && dVarPeek == dVar) {
                dVar.g(null);
                this.f430d.poll();
                k(this.b.a());
                return;
            }
            g("stopping member is NOT the heard of the order queue !!!");
        }
    }

    public final void d(d dVar) {
        synchronized (this.c) {
            if (this.f430d.contains(dVar)) {
                g("already in queue, return.");
                return;
            }
            dVar.g(this.f431e);
            this.f430d.add(dVar);
            if (this.f430d.size() > 1) {
                g("member enqueueOrder and appended.");
                j();
            } else {
                g("member enqueueOrder and being the heard, schedule now.");
                k(this.b.b());
            }
        }
    }

    public void f(@NonNull d dVar) {
        float fC = dVar.c();
        if (fC >= 100.0f) {
            d(dVar);
        } else if (fC == 0.0f) {
            dVar.b();
        }
    }

    public final void h() {
        synchronized (this.c) {
            d dVarPeek = this.f430d.peek();
            if (dVarPeek != null) {
                dVarPeek.b();
            }
        }
    }

    public void i(d dVar) {
        int i2;
        synchronized (this.c) {
            int size = this.f430d.size();
            int iIndexOf = this.f430d.indexOf(dVar);
            if (iIndexOf >= 0 && iIndexOf < size - 1) {
                int i3 = i2 - iIndexOf;
                for (int i4 = 0; i4 < i3; i4++) {
                    this.f430d.pollLast();
                }
            }
        }
    }

    public final void j() {
        int i2;
        int size = this.f430d.size();
        d dVarPeek = this.f430d.peek();
        d dVarPeekLast = this.f430d.peekLast();
        Iterator<d> it = this.f430d.iterator();
        if (!dVarPeek.d()) {
            i2 = -1;
        } else {
            if (size < 3) {
                return;
            }
            it.next();
            i2 = 0;
        }
        while (it.hasNext()) {
            i2++;
            if (dVarPeekLast.compareTo(it.next()) > 0) {
                break;
            }
        }
        if (i2 < size - 1) {
            LinkedList<d> linkedList = this.f430d;
            linkedList.add(i2, linkedList.pollLast());
        }
        g("after reorder, queue = " + Arrays.deepToString(this.f430d.toArray()));
    }

    public final void k(long j) {
        g("delay = " + j);
        if (j <= 0) {
            h();
        } else {
            this.a.postDelayed(this.f432f, j);
        }
    }
}
