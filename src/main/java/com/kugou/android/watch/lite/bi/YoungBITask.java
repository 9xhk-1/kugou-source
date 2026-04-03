package com.kugou.android.watch.lite.bi;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.datacollect.bi.use.TraceFullTask;
import e.c.a.g.a.e.d;
import e.c.a.g.a.s.l1;
import e.c.c.o.m;
import f.c0.e;
import f.f;
import f.z.d.g;
import f.z.d.j;
import f.z.d.k;
import f.z.d.n;
import f.z.d.s;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class YoungBITask extends TraceFullTask implements e.c.a.g.a.e.c, d {
    public static final b Companion = new b(null);
    private static final f.d<String> sessionId$delegate = f.b(a.a);
    private final f.d paramMap$delegate;
    private final f.d<HashMap<String, String>> paramsLazy;
    private final String typeAction;
    private final int typeId;

    public static final class a extends k implements f.z.c.a<String> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        public final String invoke() {
            return m.e(KGApplication.getContext());
        }
    }

    public static final class b {
        public static final /* synthetic */ e<Object>[] a;

        static {
            n nVar = new n(s.a(b.class), "sessionId", "getSessionId()Ljava/lang/String;");
            s.c(nVar);
            a = new e[]{nVar};
        }

        public b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final String a() {
            return (String) YoungBITask.sessionId$delegate.getValue();
        }
    }

    public static final class c extends k implements f.z.c.a<HashMap<String, String>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HashMap<String, String> invoke() {
            return new HashMap<>();
        }
    }

    public YoungBITask(int i2, String str) {
        super(new e.c.c.l.f.a(i2, "", str, ""));
        this.typeId = i2;
        this.typeAction = str;
        f.d<HashMap<String, String>> dVarB = f.b(c.a);
        this.paramsLazy = dVarB;
        this.paramMap$delegate = dVarB;
        String str2 = e.c.a.g.a.r.b.R() ? "1" : "0";
        setId1(e.c.a.g.a.r.b.Q() ? j.l(str2, ",1") : str2);
        append("preAppVersion", j.l("", Integer.valueOf(e.c.a.g.a.d.c.a.a.a())));
    }

    private final HashMap<String, String> getParamMap() {
        return (HashMap) this.paramMap$delegate.getValue();
    }

    private final int transNetType(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -284840886) {
            str.equals("unknown");
        } else if (iHashCode != 1621) {
            if (iHashCode != 1652) {
                if (iHashCode != 1683) {
                    if (iHashCode != 3649301) {
                        if (iHashCode == 770408781 && str.equals("nonetwork")) {
                            return 0;
                        }
                    } else if (str.equals("wifi")) {
                        return 1;
                    }
                } else if (str.equals("4G")) {
                    return 4;
                }
            } else if (str.equals("3G")) {
                return 2;
            }
        } else if (str.equals("2G")) {
            return 2;
        }
        return -1;
    }

    public final YoungBITask append(String str, String str2) {
        j.e(str, "key");
        if (!(str2 == null || str2.length() == 0)) {
            getParamMap().put(str, str2);
        }
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceFullTask, com.kugou.datacollect.bi.use.TraceTask
    public void putValue(String str, String str2, Hashtable<String, Object> hashtable) {
        super.putValue(str, str2, hashtable);
        if (hashtable == null) {
            return;
        }
        if (hashtable.containsKey("imei")) {
            hashtable.remove("imei");
        }
        if (j.a(str, "fo")) {
            hashtable.put("sid", Companion.a());
            if (this.paramsLazy.isInitialized()) {
                for (Map.Entry<String, String> entry : getParamMap().entrySet()) {
                    append(hashtable, entry.getKey(), entry.getValue());
                }
            }
        }
        if (!hashtable.containsKey("type_id")) {
            append(hashtable, "type_id", Integer.valueOf(this.typeId));
        }
        if (!hashtable.containsKey("action")) {
            append(hashtable, "action", this.typeAction);
        }
        if (!hashtable.containsKey("mid")) {
            append(hashtable, "mid", l1.n(KGApplication.getContext()));
        }
        if (!hashtable.containsKey("uuid")) {
            append(hashtable, "uuid", e.c.a.g.a.s.m.i(false));
        }
        if (!hashtable.containsKey("ss1")) {
            append(hashtable, "ss1", "1");
        }
        if (!hashtable.containsKey(NotificationCompat.CATEGORY_SYSTEM)) {
            append(hashtable, NotificationCompat.CATEGORY_SYSTEM, l1.u());
        }
        if (!hashtable.containsKey("mod")) {
            append(hashtable, "mod", Build.MODEL);
        }
        if (!hashtable.containsKey("brand")) {
            append(hashtable, "brand", Build.BRAND);
        }
        if (!hashtable.containsKey("channelid")) {
            append(hashtable, "channelid", l1.j());
        }
        if (!hashtable.containsKey("ip")) {
            append(hashtable, "ip", e.c.a.g.a.s.n.a());
        }
        if (!hashtable.containsKey("net")) {
            String strO = l1.o(KGApplication.getContext());
            j.d(strO, "getNetworkType(KGApplication.getContext())");
            append(hashtable, "net", Integer.valueOf(transNetType(strO)));
        }
        if (!hashtable.containsKey("ver")) {
            append(hashtable, "ver", Integer.valueOf(l1.G()));
        }
        if (!hashtable.containsKey("time")) {
            append(hashtable, "time", Long.valueOf(System.currentTimeMillis()));
        }
        if (!hashtable.containsKey("userid")) {
            append(hashtable, "userid", Long.valueOf(e.c.a.g.a.r.b.o()));
        }
        if (!hashtable.containsKey("fo")) {
            append(hashtable, "fo", e.c.a.g.a.e.a.a.a());
        }
        if (hashtable.containsKey("gitversion")) {
            return;
        }
        append(hashtable, "gitversion", "8bc5fbeb");
    }

    public final YoungBITask setKw1(String str) {
        if (str != null && !j.a(str, "")) {
            getParamMap().put("kw1", str);
        }
        return this;
    }

    public final YoungBITask setSource(String str) {
        if (str != null && !j.a(str, "")) {
            getParamMap().put("source", str);
        }
        return this;
    }

    public final YoungBITask setSpt(String str) {
        if (str != null && !j.a(str, "")) {
            getParamMap().put("spt", str);
        }
        return this;
    }

    public final YoungBITask setState(String str) {
        if (str != null && !j.a(str, "")) {
            getParamMap().put(ApmDataKey.STATE, str);
        }
        return this;
    }

    public final YoungBITask setStrList(String str) {
        if (str != null && !j.a(str, "")) {
            getParamMap().put("strlist", str);
        }
        return this;
    }

    private final void append(Hashtable<String, Object> hashtable, String str, Object obj) {
        if (obj == null) {
            return;
        }
        hashtable.put(str, obj);
    }
}
