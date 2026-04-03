package e.f.a.a.a.j;

import android.content.Context;
import com.tme.fireeye.crash.comm.biz.UserInfoBean;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import e.f.a.a.d.a.j;
import e.f.a.a.d.a.k;
import e.f.a.a.d.b.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static <T extends f> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                e.f.a.a.d.b.d dVar = new e.f.a.a.d.b.d(bArr);
                dVar.z("utf-8");
                tNewInstance.b(dVar);
                return tNewInstance;
            } catch (Throwable th) {
                if (!e.f.a.a.a.k.c.d(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static e.f.a.a.d.a.f b(Context context, int i2, byte[] bArr) {
        String str;
        e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
        StrategyBean strategyBeanH = e.f.a.a.a.i.a.g().h();
        if (bVarM == null || strategyBeanH == null) {
            e.f.a.a.a.k.c.c("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            e.f.a.a.d.a.f fVar = new e.f.a.a.d.a.f();
            synchronized (bVarM) {
                fVar.a = bVarM.f1344d;
                fVar.b = bVarM.c();
                fVar.f1440d = bVarM.f1345e;
                fVar.f1441f = bVarM.d();
                fVar.f1442h = bVarM.D;
                fVar.f1443i = bVarM.f1349i;
                fVar.j = i2;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                fVar.k = bArr;
                fVar.l = bVarM.k;
                fVar.m = bVarM.l;
                fVar.n = new HashMap();
                fVar.o = bVarM.t();
                fVar.p = strategyBeanH.o;
                fVar.r = bVarM.l();
                fVar.s = e.f.a.a.a.h.c.j(context);
                fVar.t = System.currentTimeMillis();
                fVar.v = bVarM.q();
                fVar.y = "" + bVarM.l();
                fVar.z = fVar.s;
                Objects.requireNonNull(bVarM);
                fVar.q = "com.tme.fireeye";
                fVar.n.put("A26", "" + bVarM.r());
                fVar.n.put("A62", "" + bVarM.C());
                fVar.n.put("A63", "" + bVarM.A());
                fVar.n.put("F11", "" + bVarM.b0);
                fVar.n.put("F12", "" + bVarM.a0);
                fVar.n.put("D3", "" + bVarM.B);
                List<e.f.a.a.a.a> list = e.f.a.a.a.c.a;
                if (list != null) {
                    for (e.f.a.a.a.a aVar : list) {
                        String str2 = aVar.b;
                        if (str2 != null && (str = aVar.c) != null) {
                            fVar.n.put(str2, str);
                        }
                    }
                }
                fVar.n.put("G15", e.f.a.a.a.k.f.k("G15", ""));
                fVar.n.put("D4", e.f.a.a.a.k.f.k("D4", "0"));
            }
            Map<String, String> mapF = bVarM.f();
            if (mapF != null) {
                for (Map.Entry<String, String> entry : mapF.entrySet()) {
                    fVar.n.put(entry.getKey(), entry.getValue());
                }
            }
            return fVar;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.d(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] c(f fVar) {
        try {
            e.f.a.a.d.b.e eVar = new e.f.a.a.d.b.e();
            eVar.b("utf-8");
            fVar.c(eVar);
            return eVar.c();
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.d(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static j d(UserInfoBean userInfoBean, e.f.a.a.a.h.b bVar) {
        if (userInfoBean == null) {
            return null;
        }
        j jVar = new j();
        jVar.a = userInfoBean.f266h;
        jVar.f1454h = userInfoBean.m;
        jVar.f1453f = userInfoBean.f264d;
        jVar.f1452d = userInfoBean.f265f;
        jVar.k = userInfoBean.r == 1;
        int i2 = userInfoBean.b;
        if (i2 == 1) {
            jVar.b = (byte) 1;
        } else if (i2 == 2) {
            jVar.b = (byte) 4;
        } else if (i2 == 3) {
            jVar.b = (byte) 2;
        } else if (i2 == 4) {
            jVar.b = (byte) 3;
        } else {
            if (i2 < 10 || i2 >= 20) {
                e.f.a.a.a.k.c.c("unknown uinfo type %d ", Integer.valueOf(i2));
                return null;
            }
            jVar.b = (byte) i2;
        }
        HashMap map = new HashMap();
        jVar.f1455i = map;
        if (userInfoBean.s >= 0) {
            map.put("C01", "" + userInfoBean.s);
        }
        if (userInfoBean.t >= 0) {
            jVar.f1455i.put("C02", "" + userInfoBean.t);
        }
        Map<String, String> map2 = userInfoBean.u;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.u.entrySet()) {
                jVar.f1455i.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = userInfoBean.v;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.v.entrySet()) {
                jVar.f1455i.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map4 = jVar.f1455i;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(!userInfoBean.o);
        map4.put("A36", sb.toString());
        jVar.f1455i.put("F02", "" + userInfoBean.j);
        jVar.f1455i.put("F03", "" + userInfoBean.k);
        jVar.f1455i.put("F04", "" + userInfoBean.m);
        jVar.f1455i.put("F05", "" + userInfoBean.l);
        jVar.f1455i.put("F06", "" + userInfoBean.p);
        jVar.f1455i.put("F10", "" + userInfoBean.n);
        e.f.a.a.a.k.c.b("summary type %d vm:%d", Byte.valueOf(jVar.b), Integer.valueOf(jVar.f1455i.size()));
        return jVar;
    }

    public static k e(List<UserInfoBean> list, int i2) {
        e.f.a.a.a.h.b bVarM;
        if (list == null || list.size() == 0 || (bVarM = e.f.a.a.a.h.b.m()) == null) {
            return null;
        }
        bVarM.E();
        k kVar = new k();
        kVar.b = bVarM.f1346f;
        kVar.f1457d = bVarM.l();
        ArrayList<j> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            j jVarD = d(it.next(), bVarM);
            if (jVarD != null) {
                arrayList.add(jVarD);
            }
        }
        kVar.f1458f = arrayList;
        HashMap map = new HashMap();
        kVar.f1459h = map;
        map.put("A7", "" + bVarM.j);
        kVar.f1459h.put("A6", "" + bVarM.j());
        kVar.f1459h.put("A5", "" + bVarM.k());
        kVar.f1459h.put("A2", "" + bVarM.v());
        kVar.f1459h.put("A1", "" + bVarM.u());
        kVar.f1459h.put("A24", "" + bVarM.l);
        kVar.f1459h.put("A17", "" + bVarM.w());
        kVar.f1459h.put("A15", "" + bVarM.i());
        kVar.f1459h.put("A13", "" + bVarM.n());
        kVar.f1459h.put("F08", "" + bVarM.W);
        kVar.f1459h.put("F09", "" + bVarM.X);
        Map<String, String> mapG = bVarM.g();
        if (mapG != null && mapG.size() > 0) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                kVar.f1459h.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 == 1) {
            kVar.a = (byte) 1;
        } else {
            if (i2 != 2) {
                e.f.a.a.a.k.c.c("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            kVar.a = (byte) 2;
        }
        return kVar;
    }
}
