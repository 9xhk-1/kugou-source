package e.c.a.g.a.g.n;

import android.content.Context;
import f.z.d.j;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Context b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ File[] f972d;

        public b(Context context, File[] fileArr) {
            this.b = context;
            this.f972d = fileArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d dVar = d.this;
            Context context = this.b;
            File[] fileArr = this.f972d;
            j.d(fileArr, "listFiles");
            dVar.b(context, fileArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.content.Context r19, java.io.File[] r20) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.n.d.b(android.content.Context, java.io.File[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            f.z.d.j.e(r5, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto Lc
            return
        Lc:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = e.c.a.g.a.f.f.a.b()
            r0.<init>(r1)
            java.lang.String r1 = r0.getAbsolutePath()
            boolean r1 = e.c.a.g.a.s.q.F(r1)
            if (r1 != 0) goto L20
            return
        L20:
            java.io.File[] r0 = r0.listFiles()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L30
            int r3 = r0.length
            if (r3 != 0) goto L2d
            r3 = 1
            goto L2e
        L2d:
            r3 = 0
        L2e:
            if (r3 == 0) goto L31
        L30:
            r1 = 1
        L31:
            if (r1 == 0) goto L34
            return
        L34:
            e.c.a.g.a.s.j0 r1 = e.c.a.g.a.s.j0.b()
            e.c.a.g.a.g.n.d$b r2 = new e.c.a.g.a.g.n.d$b
            r2.<init>(r5, r0)
            r1.a(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.n.d.c(android.content.Context):void");
    }
}
