package e.c.c.j;

import e.c.c.k.d;
import e.c.c.l.e.e;
import e.c.c.o.f;
import e.c.c.o.g;
import e.c.c.o.k;
import e.c.c.o.m;
import java.util.ArrayList;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class b implements d<ArrayList<e.c.c.j.e.a>> {
    public e.a a = null;

    public final e.a a(byte[] bArr, e.a aVar) {
        boolean zI;
        long j;
        long j2 = (aVar == null || aVar.c != 1203) ? 0L : aVar.a;
        if (aVar == null || !aVar.b()) {
            zI = true;
            j = j2;
        } else {
            zI = e.c.c.l.e.a.f().i();
            j = 0;
        }
        if (zI) {
            return b(bArr, true, e.c.c.l.e.a.f().c(), j);
        }
        return null;
    }

    public e.a b(byte[] bArr, boolean z, long j, long j2) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int length = 0;
        if (z) {
            length = bArr.length;
            bArr = e.a(bArr);
        }
        byte[] bArrA = e.c.c.l.e.a.f().a(bArr);
        Hashtable hashtable = new Hashtable();
        hashtable.put("uuid", m.w(true));
        hashtable.put("ver", Integer.valueOf(m.x(f.a())));
        hashtable.put("cookie", e.c.c.l.e.a.f().e());
        hashtable.put("length", Integer.valueOf(length));
        if (j2 > 0) {
            hashtable.put("t2", Long.valueOf(j2));
        }
        k.d(hashtable, e.c.c.l.e.a.b, e.c.c.l.e.a.c, j, bArrA, true);
        return new e.a(e.c.c.o.d.b("http://rt-m.kugou.com/v2/post", hashtable, bArrA));
    }

    @Override // e.c.c.k.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean send(ArrayList<e.c.c.j.e.a> arrayList) {
        return e(arrayList);
    }

    @Override // e.c.c.k.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean sendLastFailData(ArrayList<e.c.c.j.e.a> arrayList, long j) {
        return false;
    }

    public boolean e(ArrayList<e.c.c.j.e.a> arrayList) {
        g.a("siganid", "APMSender startExecute");
        if (arrayList == null || arrayList.size() == 0 || !e.c.c.l.e.d.c().a()) {
            return false;
        }
        this.a = a(e.c.c.j.e.b.b(arrayList), this.a);
        g.a("siganid", "APMSender result:" + this.a);
        return true;
    }
}
