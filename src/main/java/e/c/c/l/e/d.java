package e.c.c.l.e;

import com.kugou.datacollect.bi.senter.CsccEntity;
import e.c.c.l.e.e;
import java.util.Hashtable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile d f1261e;
    public e.c.c.l.e.a a;
    public int b;
    public long c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f1262d;

    public interface a {
        void onGetThisSendTime(long j);
    }

    public static d c() {
        if (f1261e == null) {
            synchronized (d.class) {
                if (f1261e == null) {
                    f1261e = new d();
                }
            }
        }
        return f1261e;
    }

    public boolean a() {
        if (this.a == null) {
            this.a = e.c.c.l.e.a.f();
        }
        if (!this.a.h()) {
            this.a.i();
        }
        return this.a.h();
    }

    public final synchronized e.a b(byte[] bArr, e.a aVar, long j, Hashtable<String, String> hashtable, int i2) {
        e.a aVarB;
        aVarB = null;
        boolean zI = true;
        if (aVar != null) {
            try {
                if (aVar.b()) {
                    zI = this.a.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zI) {
            long jC = this.a.c();
            long j2 = this.c;
            if (j2 != 0 && jC - j2 <= 1) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            long jC2 = this.a.c();
            this.c = jC2;
            e eVar = new e();
            a aVar2 = this.f1262d;
            if (aVar2 != null) {
                if (j > 0) {
                    aVar2.onGetThisSendTime(j);
                } else {
                    aVar2.onGetThisSendTime(jC2);
                }
            }
            aVarB = eVar.b(bArr, true, jC2, j, hashtable, i2);
            if (j == 0) {
                aVarB.a = jC2;
            } else {
                aVarB.a = j;
            }
            e.c.c.o.g.a("bisdk", "send success postEntity " + aVarB.toString());
        } else {
            e.c.c.o.g.a("siganid", "regen failed");
        }
        return aVarB;
    }

    public Hashtable<String, String> d(List<CsccEntity> list) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        for (CsccEntity csccEntity : list) {
            hashtable.put(csccEntity.a + "", csccEntity.f251d + "");
        }
        return hashtable;
    }

    public boolean e(long j) {
        return j > e.c.c.k.f.e.q().k() / 1000 || (System.currentTimeMillis() / 1000) - (e.c.c.k.f.e.q().m() / 1000) < 14400;
    }

    public void f(a aVar) {
        this.f1262d = aVar;
    }

    public g g(List<CsccEntity> list, long j) {
        String str;
        boolean z = false;
        if (list == null || list.size() == 0) {
            return new g(false, j, "entits is null");
        }
        if (!a()) {
            return new g(false, j, "IsCryptManagerOk error");
        }
        byte[] bArrB = f.b(list);
        Hashtable<String, String> hashtableD = d(list);
        e.a aVarB = null;
        int i2 = 0;
        while (true) {
            if ((aVarB != null && !aVarB.c() && !aVarB.b()) || i2 >= 3) {
                break;
            }
            aVarB = (j == 0 || !e(j)) ? b(bArrB, aVarB, 0L, hashtableD, this.b) : b(bArrB, aVarB, j, hashtableD, this.b);
            if (j == 0 && aVarB != null && aVarB.d()) {
                j = aVarB.a;
            }
            i2++;
        }
        if (aVarB != null) {
            if (aVarB.a(i2 > 1)) {
                z = true;
            }
        }
        if (z) {
            this.b++;
            str = "";
        } else if (aVarB == null) {
            str = "lastPostEntity is null";
        } else {
            str = "error" + aVarB.toString();
        }
        return new g(z, j, str);
    }
}
