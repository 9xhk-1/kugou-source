package e.c.a.g.a.f.j.b;

import android.os.Process;
import e.c.a.g.a.s.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends e.c.a.g.a.f.j.b.a {
    public e.c.a.g.a.f.j.b.a a = new k();

    public class a implements Runnable {
        public final /* synthetic */ n a;

        public a(n nVar) {
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.feeKeyVaild()) {
                i.this.a.addFees(this.a);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            for (n nVar : this.a) {
                if (nVar.feeKeyVaild()) {
                    arrayList.add(nVar);
                }
            }
            i.this.a.addFees(arrayList);
            Process.setThreadPriority(19);
            Process.setThreadPriority(10);
        }
    }

    @Override // e.c.a.g.a.f.j.b.c
    public void addFees(n nVar) {
        j0.b().a(new a(nVar));
    }

    @Override // e.c.a.g.a.f.j.b.c
    public void clearCache() {
        this.a.clearCache();
    }

    @Override // e.c.a.g.a.f.j.b.a, e.c.a.g.a.f.j.b.c
    public n getFeesEntity(o oVar, boolean z) {
        n nVarA = this.a.a(oVar);
        if (nVarA == null && !z && nVarA != null) {
            this.a.addFees(nVarA);
        }
        return nVarA;
    }

    @Override // e.c.a.g.a.f.j.b.c
    public void addFees(List<n> list) {
        j0.b().a(new b(list));
    }

    @Override // e.c.a.g.a.f.j.b.a, e.c.a.g.a.f.j.b.c
    public List<n> getFeesEntity(List<o> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<n> listB = this.a.b(list);
        if (z) {
            for (n nVar : listB) {
                if (m.a(nVar)) {
                    arrayList.add(nVar);
                }
            }
        } else {
            HashMap map = new HashMap();
            for (n nVar2 : listB) {
                map.put(nVar2.getFeeKey(), nVar2);
            }
            for (o oVar : list) {
                n nVar3 = (n) map.get(oVar.getFeeKey());
                if (nVar3 == null) {
                    arrayList2.add(oVar);
                } else if (m.a(nVar3)) {
                    arrayList.add(nVar3);
                }
            }
        }
        return arrayList;
    }
}
