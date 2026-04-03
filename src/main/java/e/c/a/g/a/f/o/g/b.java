package e.c.a.g.a.f.o.g;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import e.c.a.g.a.f.o.g.c;
import e.c.a.g.a.f.o.g.e.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.c.o.f;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f717d = l1.z(f.a());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f719f;
    public e.c.a.g.a.f.o.g.e.d a;
    public Handler b;
    public d.a c;

    public class a implements d.a {
        public a(b bVar) {
        }

        @Override // e.c.a.g.a.f.o.g.e.d.a
        public boolean handleInstruction(e.c.a.g.a.f.o.g.e.a aVar) {
            Object obj;
            c.f fVar;
            int i2 = aVar.a;
            if ((i2 != 0 && i2 != 1 && i2 != 2) || (obj = aVar.b) == null || (fVar = (c.f) ((WeakReference) obj).get()) == null) {
                return false;
            }
            int i3 = aVar.a;
            if (i3 == 0) {
                fVar.onStartTrigger();
            } else if (i3 == 1) {
                fVar.onPrimaryTrigger();
            } else {
                fVar.onSecondaryTrigger();
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.f.o.g.b$b, reason: collision with other inner class name */
    public static class C0106b {
        public static final b a = new b(null);
    }

    static {
        d.d(1, 0);
        d.d(2, 0);
        d.d(3, 0);
        d.d(4, 0);
        d.d(5, 0);
        d.d(6, 0);
        d.d(7, 0);
        d.d(8, 0);
        d.d(9, 0);
        f718e = d.d(10, 0);
        d.d(5, 0);
        f719f = d.d(15, 0);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b b() {
        return C0106b.a;
    }

    public int a() {
        return f718e;
    }

    public void c(WeakReference<c.f> weakReference, int i2) {
        f(weakReference);
        int iA = d.a(i2);
        int iB = d.b(i2);
        this.a.h(this.a.e(0, weakReference));
        if (iA > 0) {
            this.a.j(this.a.e(1, weakReference), iA * 1000);
        }
        if (iB > 0) {
            this.a.j(this.a.e(2, weakReference), iB * 1000);
        }
    }

    public void d(Runnable runnable) {
        this.b.post(runnable);
    }

    public final void e() {
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.y);
        if (TextUtils.isEmpty(config)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(config);
            int iOptInt = jSONObject.optInt("ot_l1", 0);
            int iOptInt2 = jSONObject.optInt("ot_l2", 0);
            int iOptInt3 = jSONObject.optInt("ot_l3", 0);
            int iOptInt4 = jSONObject.optInt("ot_l4", 0);
            int iOptInt5 = jSONObject.optInt("ot_l5", 0);
            int iOptInt6 = jSONObject.optInt("ot_l6", 0);
            int iOptInt7 = jSONObject.optInt("ot_l7", 0);
            int iOptInt8 = jSONObject.optInt("ot_l8", 0);
            int iOptInt9 = jSONObject.optInt("ot_l9", 0);
            int iOptInt10 = jSONObject.optInt("ot_l10", 0);
            int iOptInt11 = jSONObject.optInt("ot_search", 0);
            if (iOptInt > 0) {
                d.c(iOptInt);
            }
            if (iOptInt2 > 0) {
                d.c(iOptInt2);
            }
            if (iOptInt3 > 0) {
                d.c(iOptInt3);
            }
            if (iOptInt4 > 0) {
                d.c(iOptInt4);
            }
            if (iOptInt5 > 0) {
                d.c(iOptInt5);
            }
            if (iOptInt6 > 0) {
                d.c(iOptInt6);
            }
            if (iOptInt7 > 0) {
                d.c(iOptInt7);
            }
            if (iOptInt8 > 0) {
                d.c(iOptInt8);
            }
            if (iOptInt9 > 0) {
                d.c(iOptInt9);
            }
            if (iOptInt10 > 0) {
                f718e = d.c(iOptInt10);
            }
            if (iOptInt11 > 0) {
                d.c(iOptInt11);
            }
            if (g0.a) {
                g0.e("LoadingManager", "readConfigTime level_1:" + iOptInt + " level_2:" + iOptInt2 + " level_3:" + iOptInt3 + " level_4:" + iOptInt4 + " level_5:" + iOptInt5 + " level_6:" + iOptInt6 + " level_7:" + iOptInt7 + " level_8:" + iOptInt8 + " level_9:" + iOptInt9 + " level_10:" + iOptInt10 + " levelSearch:" + iOptInt11);
            }
        } catch (JSONException e2) {
            g0.k(e2);
        }
    }

    public void f(WeakReference<c.f> weakReference) {
        this.a.g(0, weakReference);
        this.a.g(1, weakReference);
        this.a.g(2, weakReference);
    }

    public b() {
        a aVar = new a(this);
        this.c = aVar;
        this.a = new e.c.a.g.a.f.o.g.e.d("LoadingManager", aVar);
        this.b = new Handler(Looper.getMainLooper());
        e();
    }
}
