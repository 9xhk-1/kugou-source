package e.c.c.l;

import e.c.c.k.f.e;
import e.c.c.l.e.d;
import e.c.c.o.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements e.c.c.k.d<b> {

    public class a implements d.a {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public a(c cVar, long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        @Override // e.c.c.l.e.d.a
        public void onGetThisSendTime(long j) {
            if (j != 0) {
                e.q().t(j, this.a, this.b);
            }
        }
    }

    @Override // e.c.c.k.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean send(b bVar) {
        g.a("siganid", "開始發送bi");
        List<e.c.c.k.f.b> list = bVar.a;
        if (list.size() == 0) {
            return false;
        }
        long jC = list.get(0).c();
        long jC2 = list.get(list.size() - 1).c();
        e.c.c.l.e.d.c().f(new a(this, jC, jC2));
        e.c.c.l.e.g gVarG = e.c.c.l.e.d.c().g(bVar.b, 0L);
        if (!gVarG.b()) {
            g.a("siganid", "发送失败：dataCollectCacheInfo.getFirstPostTime()：" + gVarG.toString());
            if (gVarG.a() != 0) {
                e.q().t(gVarG.a(), jC, jC2);
            }
            return false;
        }
        g.a("bisdk", "发送成功");
        ArrayList arrayList = new ArrayList();
        for (e.c.c.k.f.b bVar2 : bVar.a) {
            if (bVar2.c() != 0) {
                arrayList.add(Long.valueOf(bVar2.c()));
            }
        }
        e.q().f(arrayList);
        g.a("siganid", "删除记录成功" + arrayList);
        return true;
    }

    @Override // e.c.c.k.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean sendLastFailData(b bVar, long j) {
        List<e.c.c.k.f.b> list = bVar.a;
        if (list.size() == 0) {
            return false;
        }
        long jC = list.get(0).c();
        long jC2 = list.get(list.size() - 1).c();
        e.c.c.l.e.g gVarG = e.c.c.l.e.d.c().g(bVar.b, j);
        if (gVarG.b()) {
            g.a("bisdk", "发送成功");
            ArrayList arrayList = new ArrayList();
            for (e.c.c.k.f.b bVar2 : bVar.a) {
                if (bVar2.c() != 0) {
                    arrayList.add(Long.valueOf(bVar2.c()));
                }
            }
            e.q().f(arrayList);
        } else if (gVarG.a() != 0) {
            e.q().t(gVarG.a(), jC, jC2);
        }
        return false;
    }
}
