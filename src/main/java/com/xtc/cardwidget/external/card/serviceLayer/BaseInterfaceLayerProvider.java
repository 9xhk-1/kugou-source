package com.xtc.cardwidget.external.card.serviceLayer;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.xtc.cardwidget.external.card.serviceLayer.BaseInterfaceLayerProvider;
import d.a.a.a$b.d.i;
import f.s;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseInterfaceLayerProvider extends BaseCardStrategyProvider implements e.g.a.b.a.a.a.a, e.g.a.b.b.a.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i<d.a.a.a$b.c.b.c.b> f279f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f.d f280h = f.f.b(b.a);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f.d f281i = f.f.b(d.a);
    public final f.d j = f.f.b(a.a);

    public static final class a extends k implements f.z.c.a<ExecutorService> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    }

    public static final class b extends k implements f.z.c.a<d.a.a.a$b.c.a.b> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d.a.a.a$b.c.a.b invoke() {
            return new d.a.a.a$b.c.a.b();
        }
    }

    public static final class c extends k implements f.z.c.a<s> {
        public c() {
            super(0);
        }

        public final void a() {
            i iVar = BaseInterfaceLayerProvider.this.f279f;
            if (iVar == null) {
                return;
            }
            d.a.a.a$b.c.b.d.b bVar = new d.a.a.a$b.c.b.d.b();
            j.e(iVar, "iClientEvent");
            e.g.b.b.a.a("Update.CardUpdateProcessor", j.l("listener state callback: ", iVar));
            bVar.a.add(iVar);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public static final class d extends k implements f.z.c.a<ExecutorService> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    }

    public static final class e extends k implements l<d.a.a.a$b.c.b.c.b, s> {

        public static final class a extends k implements l<BaseInterfaceLayerProvider, s> {
            public final /* synthetic */ d.a.a.a$b.c.b.c.b a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d.a.a.a$b.c.b.c.b bVar) {
                super(1);
                this.a = bVar;
            }

            public final void a(BaseInterfaceLayerProvider baseInterfaceLayerProvider) throws Throwable {
                j.e(baseInterfaceLayerProvider, "it");
                baseInterfaceLayerProvider.f().a(this.a);
            }

            @Override // f.z.c.l
            public /* bridge */ /* synthetic */ s invoke(BaseInterfaceLayerProvider baseInterfaceLayerProvider) throws Throwable {
                a(baseInterfaceLayerProvider);
                return s.a;
            }
        }

        public e() {
            super(1);
        }

        public final void a(d.a.a.a$b.c.b.c.b bVar) {
            j.e(bVar, "cardStateEvent");
            BaseInterfaceLayerProvider baseInterfaceLayerProvider = BaseInterfaceLayerProvider.this;
            baseInterfaceLayerProvider.m(baseInterfaceLayerProvider, new a(bVar));
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(d.a.a.a$b.c.b.c.b bVar) {
            a(bVar);
            return s.a;
        }
    }

    public static final class f extends k implements l<d.a.a.a$b.c.b.c.b, s> {

        public static final class a extends k implements l<BaseInterfaceLayerProvider, s> {
            public final /* synthetic */ d.a.a.a$b.c.b.c.b a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d.a.a.a$b.c.b.c.b bVar) {
                super(1);
                this.a = bVar;
            }

            public final void a(BaseInterfaceLayerProvider baseInterfaceLayerProvider) throws Throwable {
                j.e(baseInterfaceLayerProvider, "it");
                baseInterfaceLayerProvider.f().a(this.a);
            }

            @Override // f.z.c.l
            public /* bridge */ /* synthetic */ s invoke(BaseInterfaceLayerProvider baseInterfaceLayerProvider) throws Throwable {
                a(baseInterfaceLayerProvider);
                return s.a;
            }
        }

        public f() {
            super(1);
        }

        public final void a(d.a.a.a$b.c.b.c.b bVar) {
            j.e(bVar, "cardStateEvent");
            e.g.b.b.a.a("BaseInterfaceLayerProvider", "request: post data");
            BaseInterfaceLayerProvider baseInterfaceLayerProvider = BaseInterfaceLayerProvider.this;
            baseInterfaceLayerProvider.m(baseInterfaceLayerProvider, new a(bVar));
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(d.a.a.a$b.c.b.c.b bVar) {
            a(bVar);
            return s.a;
        }
    }

    public static final class g extends k implements f.z.c.a<s> {
        public final /* synthetic */ l<T, s> a;
        public final /* synthetic */ T b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(l<? super T, s> lVar, T t) {
            super(0);
            this.a = lVar;
            this.b = t;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            this.a.invoke(this.b);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public static final void i(BaseInterfaceLayerProvider baseInterfaceLayerProvider) {
        j.e(baseInterfaceLayerProvider, "this$0");
        e.g.a.b.b.a.g.b.a.a("BaseInterfaceLayerProvider", baseInterfaceLayerProvider.new c());
    }

    public static final void n(l lVar, Object obj) {
        j.e(lVar, "$function");
        e.g.a.b.b.a.g.b.a.a("BaseInterfaceLayerProvider", new g(lVar, obj));
    }

    public final ExecutorService e() {
        return (ExecutorService) this.j.getValue();
    }

    public final d.a.a.a$b.c.a.b f() {
        return (d.a.a.a$b.c.a.b) this.f280h.getValue();
    }

    public final ExecutorService g() {
        return (ExecutorService) this.f281i.getValue();
    }

    public final void h() {
        e().submit(new Runnable() { // from class: e.g.a.b.a.c.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseInterfaceLayerProvider.i(this.a);
            }
        });
    }

    public final void j() {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        e.g.a.b.b.a.c cVar = e.g.a.b.b.a.c.a;
        cVar.f(applicationContext);
        String simpleName = getClass().getSimpleName();
        cVar.e("com.xtc.i3launcher.card.service.CardServerProvider", simpleName, this);
        e.g.b.b.a.a("BaseInterfaceLayerProvider", j.l("provider create and initial ClientChannel: ", simpleName));
    }

    public final void k() {
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar.a();
        f.c0.b bVarA = f.z.d.s.a(i.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        i<d.a.a.a$b.c.b.c.b> iVar = null;
        f.d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        Object value = orDefault == null ? null : orDefault.getValue();
        i<d.a.a.a$b.c.b.c.b> iVar2 = value instanceof i ? (i) value : null;
        if (iVar2 != null) {
            this.f279f = iVar2;
            iVar = iVar2;
        }
        if (iVar == null) {
            aVar.b(f.z.d.s.a(i.class));
        }
    }

    public final void l() {
        e.g.b.b.a.a("BaseInterfaceLayerProvider", "on interface layer initial ...");
        k();
        j();
        h();
    }

    public final <T> void m(final T t, final l<? super T, s> lVar) {
        j.e(lVar, "function");
        e.g.b.b.a.a("BaseInterfaceLayerProvider", j.l("runOnCardThread: ", t));
        g().submit(new Runnable() { // from class: e.g.a.b.a.c.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseInterfaceLayerProvider.n(lVar, t);
            }
        });
    }

    @Override // e.g.a.b.b.a.e
    public void observe(String str, l<? super byte[], s> lVar) {
        j.e(str, "observeResStr");
        j.e(lVar, "callback");
        j.e(str, "<this>");
        String strSubstring = null;
        if (!(str.length() > 5)) {
            str = null;
        }
        if (str != null) {
            strSubstring = str.substring(5);
            j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        if (strSubstring != null) {
            d.a.a.a$b.c.c.b bVar = d.a.a.a$b.c.c.b.a;
            ExecutorService executorServiceE = e();
            j.d(executorServiceE, "cardDataTask");
            bVar.c(strSubstring, executorServiceE);
            d.a.a.a$b.a.b.a.d(strSubstring, this);
            i<d.a.a.a$b.c.b.c.b> iVar = this.f279f;
            if (iVar != null) {
                d.a.a.a$b.d.b bVar2 = (d.a.a.a$b.d.b) iVar;
                j.e(strSubstring, "widgetCode");
                j.e(lVar, NotificationCompat.CATEGORY_CALL);
                bVar2.b(new d.a.a.a$b.d.c(bVar2, strSubstring, lVar));
                return;
            }
        }
        e.g.b.b.a.b("BaseInterfaceLayerProvider", "observe widgetCode is error");
    }

    @Override // e.g.a.b.b.a.e
    public void observes(List<String> list) {
        j.e(list, "ids");
        i<d.a.a.a$b.c.b.c.b> iVar = this.f279f;
        if (iVar == null) {
            return;
        }
        e eVar = new e();
        j.e(list, "ids");
        j.e(eVar, NotificationCompat.CATEGORY_CALL);
        ((d.a.a.a$b.d.b) iVar).b(new d.a.a.a$b.d.d(list, eVar));
    }

    @Override // e.g.a.b.b.a.e
    public void request(byte[] bArr) {
        j.e(bArr, "requestData");
        i<d.a.a.a$b.c.b.c.b> iVar = this.f279f;
        if (iVar == null) {
            return;
        }
        f fVar = new f();
        d.a.a.a$b.d.b bVar = (d.a.a.a$b.d.b) iVar;
        j.e(bArr, "reqData");
        j.e(fVar, NotificationCompat.CATEGORY_CALL);
        bVar.b(new d.a.a.a$b.d.e(bVar, bArr, fVar));
    }

    @Override // e.g.a.b.b.a.e
    public void unObserve(String str) {
        j.e(str, "observeResStr");
        j.e(str, "<this>");
        String strSubstring = null;
        if (!(str.length() > 5)) {
            str = null;
        }
        if (str != null) {
            strSubstring = str.substring(5);
            j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        if (strSubstring != null) {
            d.a.a.a$b.a.b.a.j(strSubstring);
            d.a.a.a$b.c.c.b.a.b(strSubstring);
            i<d.a.a.a$b.c.b.c.b> iVar = this.f279f;
            if (iVar != null) {
                d.a.a.a$b.d.b bVar = (d.a.a.a$b.d.b) iVar;
                j.e(strSubstring, "widgetCode");
                bVar.b(new d.a.a.a$b.d.f(strSubstring, bVar));
                return;
            }
        }
        e.g.b.b.a.b("BaseInterfaceLayerProvider", "unObserve widgetCode is error");
    }
}
