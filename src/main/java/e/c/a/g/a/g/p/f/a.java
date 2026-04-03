package e.c.a.g.a.g.p.f;

import e.c.a.g.a.f.k.c;
import e.c.a.g.a.f.k.d;
import e.c.a.g.a.f.k.f;
import e.c.a.g.a.g.p.d.e;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final String a = "VipConfigProtocol";

    /* JADX INFO: renamed from: e.c.a.g.a.g.p.f.a$a, reason: collision with other inner class name */
    public static final class C0160a<T, R> implements Func1 {
        public static final C0160a<T, R> a = new C0160a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends c<e>> call(ResponseBody responseBody) {
            f fVar = f.a;
            j.d(responseBody, "responseBody");
            return f.b(fVar, responseBody, e.class, null, 4, null);
        }
    }

    public final Observable<c<e>> a() {
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName(this.a).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.Y2, "https://gateway.kugou.com/youth/v1/watch/get_watch_config")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build();
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        if (e.c.a.g.a.r.b.F()) {
            cVarZ.q("userid");
            cVarZ.p(new String[0]);
        }
        cVarZ.c("source", l1.j());
        cVarZ.c("source", l1.j());
        cVarZ.c("get_default", "0");
        cVarZ.j("");
        Map<String, String> mapE = cVarZ.E();
        d dVar = (d) retrofitBuild.create(d.class);
        j.d(mapE, "params");
        Observable observableFlatMap = dVar.get(mapE).flatMap(C0160a.a);
        j.d(observableFlatMap, "request.create(ICommonService::class.java)\n            .get(params)\n            .flatMap { responseBody ->\n                ProtocolUtil.bodyToResponse(responseBody, VipConfigEntity::class.java)\n            }");
        return observableFlatMap;
    }
}
