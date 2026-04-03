package d.a.a.a$b.d;

import android.os.Bundle;
import f.s;
import f.z.c.l;
import f.z.d.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class b implements i<d.a.a.a$b.c.b.c.b> {
    public static final a c = new a(null);
    public final f.d a = f.f.b(C0036b.a);
    public final Map<String, l<byte[], s>> b = new LinkedHashMap();

    public static final class a {
        public /* synthetic */ a(f.z.d.g gVar) {
        }

        public final void a(f.z.c.a<s> aVar) {
            e.g.a.b.b.a.g.b.a.a("Facade.CardClientFacade", aVar);
        }
    }

    /* JADX INFO: renamed from: d.a.a.a$b.d.b$b, reason: collision with other inner class name */
    public static final class C0036b extends k implements f.z.c.a<ExecutorService> {
        public static final C0036b a = new C0036b();

        public C0036b() {
            super(0);
        }

        @Override // f.z.c.a
        public ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    }

    public static final class c extends k implements f.z.c.a<s> {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Bundle bundle, b bVar) {
            super(0);
            this.a = bundle;
            this.b = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[PHI: r3 r4
  0x0098: PHI (r3v12 java.lang.String) = (r3v2 java.lang.String), (r3v9 java.lang.String) binds: [B:22:0x0096, B:31:0x00d5] A[DONT_GENERATE, DONT_INLINE]
  0x0098: PHI (r4v10 java.lang.String) = (r4v3 java.lang.String), (r4v9 java.lang.String) binds: [B:22:0x0096, B:31:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // f.z.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public f.s invoke() throws org.json.JSONException {
            /*
                Method dump skipped, instruction units count: 277
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: d.a.a.a$b.d.b.c.invoke():java.lang.Object");
        }
    }

    public static final void c(f.z.c.a aVar) {
        f.z.d.j.e(aVar, "$function");
        c.a(aVar);
    }

    public void a(Bundle bundle) {
        f.z.d.j.e(bundle, "dslData");
        b(new c(bundle, this));
    }

    public final void b(final f.z.c.a<s> aVar) {
        ((ExecutorService) this.a.getValue()).submit(new Runnable() { // from class: d.a.a.a$b.d.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(aVar);
            }
        });
    }
}
