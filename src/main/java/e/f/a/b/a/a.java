package e.f.a.b.a;

import com.kugou.common.config.BaseConfigManager;
import com.tme.fireeye.lib.base.db.DBHelper;
import e.f.a.b.a.c;
import f.e0.n;
import f.s;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static boolean a = true;
    public static boolean b;
    public static String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Long f1460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static JSONObject f1461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1462f = new a();

    /* JADX INFO: renamed from: e.f.a.b.a.a$a, reason: collision with other inner class name */
    public static final class C0251a extends k implements f.z.c.a<s> {
        public static final C0251a a = new C0251a();

        public C0251a() {
            super(0);
        }

        public final void a() {
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public static final class b extends k implements l<String, s> {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f1463d;

        /* JADX INFO: renamed from: e.f.a.b.a.a$b$a, reason: collision with other inner class name */
        public static final class C0252a extends k implements f.z.c.a<Long> {
            public static final C0252a a = new C0252a();

            public C0252a() {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2() {
                return 0L;
            }

            @Override // f.z.c.a
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, String str, c cVar) {
            super(1);
            this.a = j;
            this.b = str;
            this.f1463d = cVar;
        }

        public final void a(String str) {
            Long lValueOf;
            e.f.a.b.a.g.c dbHandler;
            j.f(str, "cfgString");
            a aVar = a.f1462f;
            synchronized (aVar) {
                long j = this.a;
                Long lA = a.a(aVar);
                if (lA != null && j == lA.longValue() && this.b.equals(a.b(aVar))) {
                    e.f.a.b.a.c.b.d(BaseConfigManager.TAG, "[updateConfig] newCfgUpdateTime equals localCfgUpdateTime, newCfgUrl equals localCfgUrl, return");
                    return;
                }
                boolean zC = e.f.a.b.a.m.c.c(str);
                c.a aVar2 = e.f.a.b.a.c.b;
                aVar2.d(BaseConfigManager.TAG, "[updateConfig] successAction, isCfgJsonFormat=" + zC + ", cfgString=" + str);
                if (!zC) {
                    this.f1463d.onError(-1, "cfg is not json", false);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", this.b);
                jSONObject.put("ts", this.a);
                jSONObject.put("cfg", str);
                DBHelper dBHelper = d.c;
                if (dBHelper == null || (dbHandler = dBHelper.getDbHandler()) == null) {
                    lValueOf = null;
                } else {
                    String string = jSONObject.toString();
                    j.b(string, "value.toString()");
                    lValueOf = Long.valueOf(dbHandler.g(new e.f.a.b.a.g.e.a("fireeye_cfg_key", string), C0252a.a));
                }
                aVar2.d(BaseConfigManager.TAG, "[updateConfig] successAction, update ret=" + lValueOf);
                if (lValueOf != null && lValueOf.longValue() >= 0) {
                    aVar2.d(BaseConfigManager.TAG, "[updateConfig] update cfg success");
                    a.f1461e = new JSONObject(str);
                    a.c = this.b;
                    a.f1460d = Long.valueOf(this.a);
                    s sVar = s.a;
                    return;
                }
                this.f1463d.onError(-2, "save to db failed, ret=" + lValueOf, false);
            }
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(String str) {
            a(str);
            return s.a;
        }
    }

    public static final class c implements e.f.a.b.a.m.d.a {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // e.f.a.b.a.m.d.a
        public void onError(int i2, String str, boolean z) {
            j.f(str, "errorMsg");
            e.f.a.b.a.c.b.b(BaseConfigManager.TAG, "[updateConfig] update cfg failed, url=" + this.a + ", errorCode=" + i2 + ", errorMsg=" + str + ", isHttpError=" + z);
        }
    }

    public static final /* synthetic */ Long a(a aVar) {
        return f1460d;
    }

    public static final /* synthetic */ String b(a aVar) {
        return c;
    }

    public final synchronized long f() {
        if (!a) {
            return 0L;
        }
        h();
        Long l = f1460d;
        return l != null ? l.longValue() : 0L;
    }

    public final boolean g() {
        return a;
    }

    public final void h() {
        e.f.a.b.a.g.c dbHandler;
        if (b) {
            return;
        }
        try {
            DBHelper dBHelper = d.c;
            Object objE = (dBHelper == null || (dbHandler = dBHelper.getDbHandler()) == null) ? null : dbHandler.e(new e.f.a.b.a.g.e.a("fireeye_cfg_key"), C0251a.a);
            if (!(objE instanceof String)) {
                objE = null;
            }
            String str = (String) objE;
            c.a aVar = e.f.a.b.a.c.b;
            aVar.d(BaseConfigManager.TAG, "[loadLocalConfig] value = " + str);
            if (!(str == null || n.n(str))) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("url") && jSONObject.has("ts") && jSONObject.has("cfg")) {
                    f1461e = new JSONObject(jSONObject.getString("cfg"));
                    c = jSONObject.getString("url");
                    f1460d = Long.valueOf(jSONObject.getLong("ts"));
                    aVar.d(BaseConfigManager.TAG, "[loadLocalConfig] localCfgUpdateTime = " + f1460d + ", localCfgUrl = " + c);
                    StringBuilder sb = new StringBuilder();
                    sb.append("[loadLocalConfig] localCfg = ");
                    sb.append(f1461e);
                    aVar.d(BaseConfigManager.TAG, sb.toString());
                }
            }
        } catch (Throwable th) {
            f1461e = null;
            c = null;
            f1460d = null;
            e.f.a.b.a.c.b.c(BaseConfigManager.TAG, "[loadLocalConfig]", th);
        }
        b = true;
    }

    public final synchronized void i(e.f.a.b.a.k.b.b bVar) {
        Long l;
        j.f(bVar, "config");
        if (a) {
            h();
            long j = bVar.k;
            String str = bVar.f1481f;
            e.f.a.b.a.c.b.d(BaseConfigManager.TAG, "[updateConfig] localCfgUpdateTime=" + f1460d + ", newCfgUpdateTime=" + j + ", newCfgUrl=" + str + ", localCfgUrl=" + c);
            if (!(str == null || n.n(str))) {
                if (str.equals(c) && (l = f1460d) != null && l.longValue() == j) {
                }
                c cVar = new c(str);
                new e.f.a.b.a.m.d.b().d(str, cVar, new b(j, str, cVar));
            }
        }
    }
}
