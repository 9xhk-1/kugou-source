package h.a.b.o;

import android.util.Log;
import android.util.Pair;
import h.a.b.h;
import h.a.b.k;
import h.a.b.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class f extends h.a {
    public static final String r = "f";
    public final b a;
    public final String b;
    public final m.b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f1666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1667e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1670h;
    public Collection<Object> j;
    public k k;
    public Executor l;
    public boolean n;
    public int o;
    public boolean p;
    public int q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<Pair<String, String>> f1668f = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1671i = 3;
    public boolean m = false;

    public f(String str, m.b bVar, Executor executor, b bVar2) {
        Objects.requireNonNull(str, "URL is required.");
        Objects.requireNonNull(bVar, "Callback is required.");
        Objects.requireNonNull(executor, "Executor is required.");
        Objects.requireNonNull(bVar2, "CronetEngine is required.");
        this.b = str;
        this.c = bVar;
        this.f1666d = executor;
        this.a = bVar2;
    }

    @Override // h.a.b.m.a
    public /* bridge */ /* synthetic */ m.a a(String str, String str2) {
        f(str, str2);
        return this;
    }

    @Override // h.a.b.m.a
    public /* bridge */ /* synthetic */ m.a c() {
        h();
        return this;
    }

    @Override // h.a.b.m.a
    public /* bridge */ /* synthetic */ m.a d(String str) {
        i(str);
        return this;
    }

    @Override // h.a.b.m.a
    public /* bridge */ /* synthetic */ m.a e(k kVar, Executor executor) {
        j(kVar, executor);
        return this;
    }

    public f f(String str, String str2) {
        Objects.requireNonNull(str, "Invalid header name.");
        Objects.requireNonNull(str2, "Invalid header value.");
        if ("Accept-Encoding".equalsIgnoreCase(str)) {
            Log.w(r, "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            return this;
        }
        this.f1668f.add(Pair.create(str, str2));
        return this;
    }

    @Override // h.a.b.m.a
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public e b() {
        e eVarD = this.a.d(this.b, this.c, this.f1666d, this.f1671i, this.j, this.f1669g, this.f1670h, this.m, this.n, this.o, this.p, this.q);
        String str = this.f1667e;
        if (str != null) {
            eVarD.g(str);
        }
        for (Pair<String, String> pair : this.f1668f) {
            eVarD.f((String) pair.first, (String) pair.second);
        }
        k kVar = this.k;
        if (kVar != null) {
            eVarD.h(kVar, this.l);
        }
        return eVarD;
    }

    public f h() {
        this.f1669g = true;
        return this;
    }

    public h.a i(String str) {
        Objects.requireNonNull(str, "Method is required.");
        this.f1667e = str;
        return this;
    }

    public f j(k kVar, Executor executor) {
        Objects.requireNonNull(kVar, "Invalid UploadDataProvider.");
        Objects.requireNonNull(executor, "Invalid UploadDataProvider Executor.");
        if (this.f1667e == null) {
            this.f1667e = "POST";
        }
        this.k = kVar;
        this.l = executor;
        return this;
    }
}
