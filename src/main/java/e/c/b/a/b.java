package e.c.b.a;

import android.content.Context;
import android.os.Build;
import com.kugou.common.utils.PrivacyUtil;
import e.c.a.g.a.s.b0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.f.a.a.c.a;
import f.c0.e;
import f.d;
import f.f;
import f.g;
import f.z.d.j;
import f.z.d.k;
import f.z.d.n;
import f.z.d.s;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final C0200b a = new C0200b(null);
    public static final d<b> b = f.a(g.SYNCHRONIZED, a.a);

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends k implements f.z.c.a<b> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(null);
        }
    }

    /* JADX INFO: renamed from: e.c.b.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class C0200b {
        public static final /* synthetic */ e<Object>[] a;

        static {
            n nVar = new n(s.a(C0200b.class), "instance", "getInstance()Lcom/kugou/crash/fireeye/FireEyeCrashManager;");
            s.c(nVar);
            a = new e[]{nVar};
        }

        public C0200b() {
        }

        public /* synthetic */ C0200b(f.z.d.g gVar) {
            this();
        }

        public final b a() {
            return (b) b.b.getValue();
        }
    }

    public b() {
    }

    public /* synthetic */ b(f.z.d.g gVar) {
        this();
    }

    public static final b c() {
        return a.a();
    }

    public final String b() {
        String strN = l1.n(e.c.c.o.f.a());
        j.d(strN, "getMid(KGCommonApplication.getContext())");
        return strN;
    }

    public final void d() {
        Context contextA = e.c.c.o.f.a();
        if (contextA == null) {
            return;
        }
        c cVar = new c();
        if (cVar.a()) {
            return;
        }
        cVar.g();
        try {
            e.f.a.b.a.b.a(false);
            e.f.a.a.c.a.a(contextA, false);
            String strB = b();
            e.f.a.b.a.d.b.b(strB);
            e.f.a.a.c.a.e(contextA, strB);
        } catch (Exception e2) {
            if (g0.a) {
                e2.printStackTrace();
            }
        }
        a.C0249a c0249a = new a.C0249a();
        c0249a.a(true);
        c0249a.c(true);
        c0249a.b(true);
        String absolutePath = contextA.getDir("fire_eye_dump", 0).getAbsolutePath();
        a.b bVar = new a.b();
        bVar.g(g0.a);
        bVar.h(true);
        bVar.c(absolutePath);
        bVar.e(cVar.e());
        bVar.f(cVar.f());
        boolean zC = cVar.c();
        if (!cVar.c()) {
            c0249a = null;
        }
        bVar.d(zC, c0249a);
        bVar.a(new e.c.b.a.a());
        bVar.b(new e.f.a.a.c.c.c());
        e.f.a.a.c.a.c(contextA, "hy15jr30w2", bVar);
        e(contextA);
    }

    public final void e(Context context) {
        try {
            e.f.a.a.c.a.d(context, "gitversion", b0.a());
            e.f.a.a.c.a.d(context, "stable_gitversion", b0.a());
            e.f.a.a.c.a.d(context, "processName", e.c.a.g.a.s.d.c(context));
            e.f.a.a.c.a.d(context, "channelID", l1.j());
            e.f.a.a.c.a.d(context, "currentPage", e.c.b.a.a.a.a());
            e.f.a.a.c.a.d(context, "uuidForeground", m.h());
            e.f.a.a.c.a.d(context, "uuidBackground", m.h());
            e.f.a.a.c.a.d(context, "sword", "sword_ver:-");
            e.f.a.a.c.a.g(context, j.l("", Integer.valueOf(l1.G())));
            e.f.a.a.c.a.h(context, b0.a());
            if (PrivacyUtil.hasAgreed()) {
                String strB = b();
                e.f.a.a.c.a.f(context, Build.MODEL);
                e.f.a.a.c.a.e(context, strB);
                e.f.a.a.c.a.i(context, strB);
                e.f.a.a.c.a.d(context, "preversion", j.l("", Long.valueOf(e.c.c.o.m.h(context))));
            }
        } catch (Exception e2) {
            if (g0.a) {
                e2.printStackTrace();
            }
        }
    }

    public final void f() {
        e.f.a.a.c.a.j();
    }

    public final void g() {
        e.f.a.a.c.a.k();
    }

    public final void h() {
        e.f.a.a.c.a.l();
    }
}
