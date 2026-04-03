package e.g.a.b.b.a;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import f.j;
import f.k;
import f.s;
import f.u.m;
import f.u.u;
import f.z.c.l;
import f.z.d.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final c l = new c(null);
    public final String a;
    public final String b;
    public final e.g.a.b.b.a.e c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f1489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f1490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e.g.a.b.b.a.g.c f1491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f1492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set<String> f1493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1494i;
    public ContentObserver j;
    public boolean k;

    public static final class a {
        public String a;
        public String b;
        public String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1495d;

        public a(String str, String str2, String str3, String str4) {
            j.e(str, "type");
            j.e(str2, "cardId");
            j.e(str3, "hostId");
            j.e(str4, "action");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f1495d = str4;
        }

        public final void a(String str) {
            j.e(str, "<set-?>");
            this.f1495d = str;
        }

        public final void b(String str) {
            j.e(str, "<set-?>");
            this.b = str;
        }

        public final void c(String str) {
            j.e(str, "<set-?>");
            this.c = str;
        }

        public final void d(String str) {
            j.e(str, "<set-?>");
            this.a = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.a(this.a, aVar.a) && j.a(this.b, aVar.b) && j.a(this.c, aVar.c) && j.a(this.f1495d, aVar.f1495d);
        }

        public int hashCode() {
            return this.f1495d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
        }

        public String toString() {
            return "ActionIdentify(type=" + this.a + ", cardId=" + this.b + ", hostId=" + this.c + ", action=" + this.f1495d + ')';
        }
    }

    public final class b extends ContentObserver {
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, e.g.a.b.b.a.g.c cVar) {
            super(cVar);
            j.e(dVar, "this$0");
            this.a = dVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            e.g.b.b.a.d(this.a.f1494i, "onChange selfChange = [ " + z + " ]");
            this.a.n();
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(f.z.d.g gVar) {
            this();
        }

        public final void b(d dVar) {
            Object objA;
            if (dVar.k) {
                dVar.x();
            }
            try {
                j.a aVar = f.j.a;
                objA = dVar.p();
                f.j.a(objA);
            } catch (Throwable th) {
                j.a aVar2 = f.j.a;
                objA = k.a(th);
                f.j.a(objA);
            }
            Throwable thB = f.j.b(objA);
            if (thB != null) {
                e.g.b.b.a.b(dVar.f1494i, "pullAndRunCommand exception = " + ((Object) thB.getMessage()) + ' ');
            }
            C0260d c0260d = new C0260d(m.d(), true);
            if (f.j.c(objA)) {
                objA = c0260d;
            }
            C0260d c0260d2 = (C0260d) objA;
            if (c0260d2.b()) {
                e.g.b.b.a.d(dVar.f1494i, "pullAndRunCommand pullResult.idleState = true ");
                return;
            }
            List<e.g.a.b.b.a.f.a> listA = c0260d2.a();
            e.g.b.b.a.d(dVar.f1494i, "pullAndRunCommand commandList = " + listA + ' ');
            dVar.m(listA);
        }
    }

    /* JADX INFO: renamed from: e.g.a.b.b.a.d$d, reason: collision with other inner class name */
    public static final class C0260d {
        public final List<e.g.a.b.b.a.f.a> a;
        public final boolean b;

        public C0260d(List<e.g.a.b.b.a.f.a> list, boolean z) {
            f.z.d.j.e(list, "commandList");
            this.a = list;
            this.b = z;
        }

        public final List<e.g.a.b.b.a.f.a> a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public static final class e extends f.z.d.k implements l<byte[], s> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(1);
            this.b = str;
        }

        public final void a(byte[] bArr) throws RemoteException {
            ContentResolver contentResolver;
            f.z.d.j.e(bArr, "byteArray");
            Context contextJ = d.this.j();
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = (contextJ == null || (contentResolver = contextJ.getContentResolver()) == null) ? null : contentResolver.acquireUnstableContentProviderClient(d.this.l());
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                return;
            }
            e.g.b.b.a.d("DataChannel.ClientProxy", f.z.d.j.l("processObserve size is: ", Integer.valueOf(bArr.length)));
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_CALLBACK_ID", this.b);
            bundle.putByteArray("RESULT_CALLBACK_DATA", bArr);
            contentProviderClientAcquireUnstableContentProviderClient.call("callback", d.this.i(), bundle);
            d.this.r(contentProviderClientAcquireUnstableContentProviderClient);
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(byte[] bArr) throws RemoteException {
            a(bArr);
            return s.a;
        }
    }

    public static final class f extends f.z.d.k implements f.z.c.a<s> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.b = str;
        }

        public final void a() {
            d.this.q(this.b);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public static final class g extends f.z.d.k implements f.z.c.a<s> {
        public final /* synthetic */ e.g.a.b.b.a.f.a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e.g.a.b.b.a.f.a aVar) {
            super(0);
            this.b = aVar;
        }

        public final void a() {
            d.this.k().request(this.b.c());
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public static final class h extends f.z.d.k implements f.z.c.a<s> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(0);
            this.b = str;
        }

        public final void a() {
            d.this.k().unObserve(this.b);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public d(String str, String str2, e.g.a.b.b.a.e eVar) {
        Object value;
        Object value2;
        f.z.d.j.e(str, "serverAuthority");
        f.z.d.j.e(str2, "clientName");
        f.z.d.j.e(eVar, "iClient");
        this.a = str;
        this.b = str2;
        this.c = eVar;
        Uri uri = Uri.parse("content://" + str + "/pull/" + str2);
        f.z.d.j.d(uri, "parse(\"content://$serverAuthority/pull/$clientName\")");
        this.f1490e = uri;
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar.a();
        f.c0.b bVarA = f.z.d.s.a(Context.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        Object obj = null;
        obj = null;
        f.d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        if (orDefault == null || (value = orDefault.getValue()) == null) {
            value = null;
        } else {
            this.f1489d = value instanceof Context ? (Context) value : null;
        }
        if (value == null) {
            aVar.b(f.z.d.s.a(Context.class));
        }
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA2 = aVar.a();
        f.c0.b bVarA2 = f.z.d.s.a(e.g.a.b.b.a.g.c.class);
        Objects.requireNonNull(concurrentHashMapA2, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        f.d<?> orDefault2 = concurrentHashMapA2.getOrDefault(bVarA2, null);
        if (orDefault2 != null && (value2 = orDefault2.getValue()) != null) {
            this.f1491f = value2 instanceof e.g.a.b.b.a.g.c ? (e.g.a.b.b.a.g.c) value2 : null;
            obj = value2;
        }
        if (obj == null) {
            aVar.b(f.z.d.s.a(e.g.a.b.b.a.g.c.class));
        }
        this.f1492g = new ArrayList();
        this.f1493h = new LinkedHashSet();
        this.k = true;
        this.f1494i = "DataChannel.ClientProxy}";
        this.j = new b(this, this.f1491f);
        n();
    }

    public static final void o(d dVar) {
        f.z.d.j.e(dVar, "this$0");
        l.b(dVar);
    }

    public static final void w(d dVar, f.z.c.a aVar) {
        Object objA;
        f.z.d.j.e(dVar, "this$0");
        f.z.d.j.e(aVar, "$function");
        try {
            j.a aVar2 = f.j.a;
            aVar.invoke();
            objA = s.a;
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar3 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        Throwable thB = f.j.b(objA);
        if (thB != null) {
            e.g.b.b.a.b("DataChannel.ClientProxy._ERR", f.z.d.j.l("executorService has error: ", thB.getStackTrace()));
        }
    }

    public final a h(e.g.a.b.b.a.f.a aVar) {
        Object value;
        d.a.a.a$b.d.j jVar;
        String str;
        String str2 = "";
        a aVar2 = new a("", "", "", "");
        int iB = aVar.b();
        if (iB == 0) {
            byte[] bArrC = aVar.c();
            f.z.d.j.e(bArrC, "<this>");
            aVar2 = new a("", "", "", "");
            e.g.a.b.b.a.g.a aVar3 = e.g.a.b.b.a.g.a.a;
            ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar3.a();
            f.c0.b bVarA = f.z.d.s.a(d.a.a.a$b.d.j.class);
            Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            f.d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
            if (orDefault == null || (value = orDefault.getValue()) == null) {
                value = null;
                jVar = null;
            } else {
                jVar = value instanceof d.a.a.a$b.d.j ? (d.a.a.a$b.d.j) value : null;
            }
            if (value == null) {
                aVar3.b(f.z.d.s.a(d.a.a.a$b.d.j.class));
            }
            d.a.a.a$b.a.a aVarA = jVar != null ? ((d.a.a.a$b.d.h) jVar).a(bArrC) : null;
            if (aVarA != null) {
                String strB = aVarA.b();
                d.a.a.a$b.e.a aVar4 = d.a.a.a$b.e.a.a;
                aVar2.d(String.valueOf(aVar4.b(strB)));
                aVar2.b(String.valueOf(aVar4.a(strB)));
                aVar2.c(String.valueOf(aVar4.c(strB)));
                Map<String, String> mapA = aVarA.a();
                if (mapA != null && (str = mapA.get("life_circle")) != null) {
                    str2 = str;
                }
                aVar2.a(str2);
            }
        } else if (iB == 2 || iB == 3) {
            aVar2.d(String.valueOf(aVar.b()));
            aVar2.b(aVar.a());
        }
        return aVar2;
    }

    public final String i() {
        return this.b;
    }

    public final Context j() {
        return this.f1489d;
    }

    public final e.g.a.b.b.a.e k() {
        return this.c;
    }

    public final String l() {
        return this.a;
    }

    public final void m(List<e.g.a.b.b.a.f.a> list) {
        if (f.z.d.j.a(this.b, "card_service") || f.z.d.j.a(this.b, "card_service_launcher")) {
            e.g.b.b.a.d(this.f1494i, f.z.d.j.l("processCommandList: clientName = ", this.b));
        } else {
            ArrayList arrayList = new ArrayList();
            List<e.g.a.b.b.a.f.a> listF = u.F(list);
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (e.g.a.b.b.a.f.a aVar : listF) {
                a aVarH = h(aVar);
                arrayList.add(aVarH);
                if (hashSet.add(aVarH)) {
                    arrayList2.add(aVar);
                }
            }
            list = u.F(arrayList2);
            e.g.b.b bVar = e.g.b.b.a;
            bVar.d(this.f1494i, f.z.d.j.l("processCommandList: distinct processCommands = ", list));
            bVar.d(this.f1494i, f.z.d.j.l("processCommandList: detail processCommands = ", u.F(u.p(arrayList))));
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z = false;
        for (e.g.a.b.b.a.f.a aVar2 : list) {
            int iB = aVar2.b();
            if (iB == 0) {
                u(aVar2);
            } else if (iB == 2) {
                String strA = aVar2.a();
                if (this.f1493h.contains(strA)) {
                    e.g.b.b.a.f("DataChannel.ClientProxy", "observing card is in observeResBlackList.");
                } else {
                    arrayList3.add(strA);
                    if (s(strA)) {
                        z = true;
                    }
                }
            } else if (iB == 3) {
                String strA2 = aVar2.a();
                arrayList3.add(strA2);
                String string = aVar2.c().toString();
                e.g.b.b.a.d("DataChannel.ClientProxy", f.z.d.j.l("ReplaceObserve, clientName: ", string));
                if (string.length() == 0) {
                    s(strA2);
                } else {
                    t(string, strA2);
                }
            } else if (iB == 4) {
                arrayList4.add(aVar2.a());
            }
        }
        for (String str : this.f1492g) {
            if (!arrayList3.contains(str) && !this.f1493h.contains(str) && !arrayList4.contains(str)) {
                y(str);
                z = true;
            }
        }
        if (z) {
            this.c.observes(arrayList3);
        }
        this.f1492g.clear();
        this.f1492g.addAll(arrayList3);
    }

    public final void n() {
        e.g.a.b.b.a.g.c cVar = this.f1491f;
        if (cVar == null) {
            return;
        }
        cVar.post(new Runnable() { // from class: e.g.a.b.b.a.b
            @Override // java.lang.Runnable
            public final void run() {
                d.o(this.a);
            }
        });
    }

    public final C0260d p() throws RemoteException {
        boolean z;
        ContentResolver contentResolver;
        Context context = this.f1489d;
        byte[] byteArray = null;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = (context == null || (contentResolver = context.getContentResolver()) == null) ? null : contentResolver.acquireUnstableContentProviderClient(this.a);
        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
            e.g.b.b.a.b(this.f1494i, "pullCommand with null client");
            return new C0260d(m.d(), false);
        }
        Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("pullCommand", this.b, null);
        if (bundleCall == null) {
            z = false;
        } else {
            byteArray = bundleCall.getByteArray("RESULT_COMMAND_LIST");
            z = bundleCall.getBoolean("RESULT_IDLE_STATE", false);
        }
        r(contentProviderClientAcquireUnstableContentProviderClient);
        if (byteArray == null) {
            return new C0260d(m.d(), z);
        }
        ArrayList arrayList = new ArrayList();
        try {
            f.z.d.j.c(byteArray);
            JSONArray jSONArray = new JSONArray(new String(byteArray, f.e0.c.a));
            int length = jSONArray.length();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    int iOptInt = jSONObjectOptJSONObject.optInt("METHOD_TYPE");
                    String strOptString = jSONObjectOptJSONObject.optString("CALLBACK_ID");
                    String strOptString2 = jSONObjectOptJSONObject.optString("PARAM");
                    f.z.d.j.d(strOptString2, "js.optString(\"PARAM\")");
                    byte[] bytes = strOptString2.getBytes(f.e0.c.a);
                    f.z.d.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                    f.z.d.j.d(strOptString, "callbackId");
                    arrayList.add(new e.g.a.b.b.a.f.a(iOptInt, strOptString, bytes));
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return new C0260d(arrayList, z);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new C0260d(m.d(), false);
        }
    }

    public final void q(String str) {
        this.c.observe(str, new e(str));
    }

    public final void r(ContentProviderClient contentProviderClient) {
        if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClient.close();
        } else {
            contentProviderClient.release();
        }
    }

    public final boolean s(String str) {
        if (this.f1492g.contains(str)) {
            return false;
        }
        v(new f(str));
        return true;
    }

    public final void t(String str, String str2) {
        this.f1493h.remove(str2);
        Iterator<d> it = e.g.a.b.b.a.c.a.c().iterator();
        f.z.d.j.d(it, "ClientChannel.clients.iterator()");
        d dVar = null;
        while (it.hasNext()) {
            d next = it.next();
            if (f.z.d.j.a(next.i(), str)) {
                dVar = next;
            }
        }
        if (dVar == null) {
            return;
        }
        dVar.f1493h.add(str2);
    }

    public final void u(e.g.a.b.b.a.f.a aVar) {
        v(new g(aVar));
    }

    public final void v(final f.z.c.a<s> aVar) {
        Object value;
        e.g.a.b.b.a.g.a aVar2 = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar2.a();
        f.c0.b bVarA = f.z.d.s.a(ExecutorService.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        Object obj = null;
        obj = null;
        f.d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        if (orDefault != null && (value = orDefault.getValue()) != null) {
            ExecutorService executorService = value instanceof ExecutorService ? (ExecutorService) value : null;
            if (executorService != null) {
                executorService.submit(new Runnable() { // from class: e.g.a.b.b.a.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.w(this.a, aVar);
                    }
                });
            }
            obj = value;
        }
        if (obj == null) {
            aVar2.b(f.z.d.s.a(ExecutorService.class));
        }
    }

    public final void x() {
        Object obj;
        Context context;
        e.g.b.b.a.d(this.f1494i, "tryRegisterContentObserver");
        try {
            j.a aVar = f.j.a;
            Context contextJ = j();
            if (contextJ == null) {
                context = null;
            } else {
                contextJ.getContentResolver().registerContentObserver(this.f1490e, false, this.j);
                this.k = false;
                context = contextJ;
            }
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            Object objA = k.a(th);
            f.j.a(objA);
            obj = objA;
        }
        if (context == null) {
            throw new NullPointerException();
        }
        f.j.a(context);
        obj = context;
        if (f.j.b(obj) != null) {
            e.g.b.b.a.b(this.f1494i, "tryRegisterContentObserver");
            this.k = true;
        }
    }

    public final void y(String str) {
        v(new h(str));
    }
}
