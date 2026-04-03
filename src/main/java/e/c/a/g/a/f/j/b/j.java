package e.c.a.g.a.f.j.b;

import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j {

    public class a implements Runnable {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.a;
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException unused) {
            }
            int size = this.a.size();
            if (size <= 20) {
                j.b().d(this.a).a();
                return;
            }
            int i2 = size % 20 == 0 ? size / 20 : (size / 20) + 1;
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 * 20;
                int i5 = i4 + 20;
                if (i5 > size) {
                    i5 = size;
                }
                arrayList2.clear();
                while (i4 < i5) {
                    arrayList2.add((e.c.a.g.a.g.k.c.a) this.a.get(i4));
                    i4++;
                }
                j.b().d(arrayList2).a();
            }
        }
    }

    public static class b {
        public List<e.c.a.g.a.f.j.b.b> a = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> void b(List<T> list) {
            if (list == null || list.size() <= 0 || !(list.get(0) instanceof e.c.a.g.a.f.j.b.b)) {
                list = (List<T>) new g().a(list);
            }
            if (list != null) {
                for (T t : list) {
                    if (t != null && t.feeKeyVaild()) {
                        this.a.add(t);
                    }
                }
            }
        }

        public final List<e.c.a.g.a.f.j.b.b> c() {
            return this.a;
        }

        public <T> d d(List<T> list) {
            b(list);
            return new d(this);
        }
    }

    public static class c {
    }

    public static class d extends e {
        public d(b bVar) {
            super(bVar);
        }

        public void a() {
            c(true, true);
        }

        public void b() {
            c(true, false);
        }

        public final void c(boolean z, boolean z2) {
            if (!z) {
                l.b().a(this.a.c());
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (e.c.a.g.a.f.j.b.b bVar : this.a.c()) {
                if (bVar.fromCache()) {
                    if (g0.a) {
                        g0.e("FeeStatus——insertData-from cache", e.c.a.g.a.f.j.b.e.b(bVar));
                    }
                } else if (!m.g(bVar)) {
                    if (bVar.getMusicTransParamEnenty() != null) {
                        bVar.e(true);
                        bVar.f(true);
                        bVar.a(true);
                        bVar.b(true);
                        if (z2) {
                            bVar.d(true);
                        }
                    }
                    if (m.d(bVar)) {
                        bVar.c(true);
                    }
                    if (m.f(bVar.getUpdataFlag())) {
                        arrayList.add(bVar);
                    }
                } else if (g0.a) {
                    g0.e("FeeStatus——insertData-无效数据", e.c.a.g.a.f.j.b.e.b(bVar));
                }
            }
            if (arrayList.size() > 0) {
                l.b().a(arrayList);
            }
        }
    }

    public static abstract class e {
        public b a;

        public e(b bVar) {
            this.a = bVar;
        }
    }

    public static void a(ArrayList<e.c.a.g.a.g.k.c.a> arrayList) {
        j0.b().a(new a(arrayList));
    }

    public static b b() {
        return new b();
    }
}
