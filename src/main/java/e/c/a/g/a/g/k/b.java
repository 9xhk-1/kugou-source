package e.c.a.g.a.g.k;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import e.c.a.g.a.d.f.c.a.k;
import e.c.a.g.a.d.f.c.a.m;
import e.c.a.g.a.s.l0;
import e.c.c.o.f;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();
    public static final k b;
    public static final m c;

    public static final class a<T> implements e.c.a.g.a.s.y1.a {
        public static final a<T> a = new a<>();

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(List<KGPlaylistMusic> list) {
            m mVar = b.c;
            j.d(list, "it");
            mVar.z(list);
        }
    }

    static {
        e.c.a.g.a.d.f.b bVar = e.c.a.g.a.d.f.b.a;
        Context contextA = f.a();
        j.d(contextA, "getContext()");
        b = bVar.a(contextA).i();
        Context contextA2 = f.a();
        j.d(contextA2, "getContext()");
        c = bVar.a(contextA2).j();
    }

    public final void A(String str, int i2) {
        j.e(str, "playlist");
        b.k(i2, str);
    }

    public final int b(String str) {
        j.e(str, "globalCollectionId");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return c.i(str);
    }

    public final int c(String str, List<Long> list) {
        j.e(str, "globalCollectionId");
        j.e(list, "filterMixs");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return c.j(str, list);
    }

    public final int d(String str, long j, long j2) {
        j.e(str, "globalId");
        return j > 0 ? c.k(str, j) : c.l(str, j2);
    }

    public final int e(String str) {
        j.e(str, "globalId");
        return c.m(str);
    }

    public final int f(String str) {
        j.e(str, "globalId");
        return c.n(str);
    }

    public final int g(String str) {
        j.e(str, "id");
        int i2 = b.i(str);
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public final e.c.a.g.a.d.f.c.a.j h(String str, boolean z) {
        j.e(str, "id");
        e.c.a.g.a.d.f.c.a.j jVarJ = b.j(str);
        if (z && jVarJ != null) {
            jVarJ.b0(b(str));
        }
        return jVarJ;
    }

    public final e.c.a.g.a.d.f.c.a.j i(String str) {
        j.e(str, "globalId");
        return b.h(str);
    }

    public final KGPlaylistMusic j(String str, long j) {
        j.e(str, "globalId");
        return c.p(str, j);
    }

    public final KGPlaylistMusic k(String str, String str2) {
        j.e(str, "globalId");
        j.e(str2, "hashValue");
        return c.q(str, str2);
    }

    public final String l(String str, long j) {
        j.e(str, "globalId");
        KGPlaylistMusic kGPlaylistMusicP = c.p(str, j);
        if (kGPlaylistMusicP == null) {
            return null;
        }
        return kGPlaylistMusicP.h();
    }

    public final List<KGPlaylistMusic> m(String str) {
        j.e(str, "globalId");
        return c.r(str);
    }

    public final List<KGPlaylistMusic> n(String str, int i2, int i3) {
        j.e(str, "globalId");
        return c.s(str, i2, i3);
    }

    public final long o(e.c.a.g.a.d.f.c.a.j jVar) {
        j.e(jVar, "playlist");
        e.c.a.g.a.d.f.c.a.j jVarH = h(jVar.d(), false);
        if (jVarH == null) {
            return b.d(jVar);
        }
        jVar.R(jVarH.e());
        b.g(jVar);
        return jVarH.e();
    }

    public final void p(KGPlaylistMusic kGPlaylistMusic) {
        KGPlaylistMusic kGPlaylistMusicJ;
        String str;
        j.e(kGPlaylistMusic, "song");
        KGMusic kGMusicM = kGPlaylistMusic.m();
        if ((kGMusicM == null ? null : Long.valueOf(kGMusicM.mixId)) == null) {
            String strH = kGPlaylistMusic.h();
            KGMusic kGMusicM2 = kGPlaylistMusic.m();
            String str2 = "";
            if (kGMusicM2 != null && (str = kGMusicM2.hashValue) != null) {
                str2 = str;
            }
            kGPlaylistMusicJ = k(strH, str2);
        } else {
            kGPlaylistMusicJ = j(kGPlaylistMusic.h(), kGPlaylistMusic.p());
        }
        if (kGPlaylistMusicJ == null) {
            s(kGPlaylistMusic);
        } else {
            kGPlaylistMusic.Q(kGPlaylistMusicJ.j());
            c.g(kGPlaylistMusic);
        }
    }

    public final void q(List<KGPlaylistMusic> list) {
        Object next;
        j.e(list, "targetList");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (((KGPlaylistMusic) next).h().length() > 0) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        KGPlaylistMusic kGPlaylistMusic = (KGPlaylistMusic) next;
        if (kGPlaylistMusic == null) {
            return;
        }
        m mVar = c;
        List<KGPlaylistMusic> listO = mVar.o(kGPlaylistMusic.h());
        if (listO.isEmpty()) {
            mVar.e(list);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(listO.size());
        for (Object obj : listO) {
            linkedHashMap.put(Long.valueOf(((KGPlaylistMusic) obj).p()), obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(listO.size());
        for (Object obj2 : listO) {
            KGMusic kGMusicM = ((KGPlaylistMusic) obj2).m();
            linkedHashMap2.put(kGMusicM == null ? null : kGMusicM.hashValue, obj2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (KGPlaylistMusic kGPlaylistMusic2 : list) {
            KGPlaylistMusic kGPlaylistMusic3 = (KGPlaylistMusic) linkedHashMap.get(Long.valueOf(kGPlaylistMusic2.p()));
            if (kGPlaylistMusic3 == null) {
                KGMusic kGMusicM2 = kGPlaylistMusic2.m();
                kGPlaylistMusic3 = (KGPlaylistMusic) linkedHashMap2.get(kGMusicM2 == null ? null : kGMusicM2.hashValue);
            }
            if (kGPlaylistMusic3 != null) {
                kGPlaylistMusic2.Q(kGPlaylistMusic3.j());
                arrayList2.add(kGPlaylistMusic2);
            } else {
                arrayList.add(kGPlaylistMusic2);
            }
        }
        if (!arrayList.isEmpty()) {
            c.e(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            c.z(arrayList2);
        }
    }

    public final int r(List<KGPlaylistMusic> list) {
        j.e(list, "musics");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            c.t((KGPlaylistMusic) it.next());
        }
        return list.size();
    }

    public final void s(KGPlaylistMusic kGPlaylistMusic) {
        j.e(kGPlaylistMusic, "song");
        c.t(kGPlaylistMusic);
    }

    public final void t(String str) {
        j.e(str, "globalId");
        c.h(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [e.c.a.g.a.d.f.c.a.m] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.ArrayList<java.lang.String>, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List] */
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
    public final int u(String str, ArrayList<Long> arrayList, ArrayList<String> arrayList2) {
        j.e(str, "globalId");
        boolean z = true;
        if (arrayList == null || arrayList.isEmpty()) {
            if (arrayList2 != 0 && !arrayList2.isEmpty()) {
                z = false;
            }
            if (z) {
                return 0;
            }
        }
        ?? r0 = c;
        List listD = arrayList;
        if (arrayList == null) {
            listD = f.u.m.d();
        }
        if (arrayList2 == 0) {
            arrayList2 = f.u.m.d();
        }
        return r0.u(str, listD, arrayList2);
    }

    public final int v(String str) {
        j.e(str, "globalId");
        return c.v(str);
    }

    public final void w(String str, List<String> list) {
        j.e(str, "globalId");
        j.e(list, "hashIds");
        if (list.isEmpty()) {
            return;
        }
        c.w(str, list);
    }

    public final void x(String str, List<Long> list) {
        j.e(str, "globalId");
        j.e(list, "mixIds");
        if (list.isEmpty()) {
            return;
        }
        c.x(str, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [e.c.a.g.a.d.f.c.a.m] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.ArrayList<java.lang.Long>, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
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
    public final int y(String str, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        j.e(str, "globalId");
        boolean z = true;
        if (arrayList == 0 || arrayList.isEmpty()) {
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z = false;
            }
            if (z) {
                return 0;
            }
        }
        ?? r0 = c;
        List listD = arrayList2;
        if (arrayList2 == null) {
            listD = f.u.m.d();
        }
        if (arrayList == 0) {
            arrayList = f.u.m.d();
        }
        return r0.y(str, listD, arrayList);
    }

    public final void z(String str, int i2, List<KGPlaylistMusic> list) {
        int iF;
        j.e(str, "globalCollectionId");
        int iAbs = 0;
        if ((list == null || list.isEmpty()) || i2 <= 0) {
            return;
        }
        for (KGPlaylistMusic kGPlaylistMusic : list) {
            if (kGPlaylistMusic != null && iAbs > (iF = kGPlaylistMusic.f())) {
                iAbs = iF;
            }
        }
        if (iAbs < 0) {
            iAbs = Math.abs(iAbs);
        }
        List<KGPlaylistMusic> listO = c.o(str);
        if (listO.isEmpty()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        for (Object obj : list) {
            KGPlaylistMusic kGPlaylistMusic2 = (KGPlaylistMusic) obj;
            linkedHashMap.put(Long.valueOf(kGPlaylistMusic2 == null ? 0L : kGPlaylistMusic2.p()), obj);
        }
        for (KGPlaylistMusic kGPlaylistMusic3 : listO) {
            KGPlaylistMusic kGPlaylistMusic4 = (KGPlaylistMusic) linkedHashMap.get(Long.valueOf(kGPlaylistMusic3.p()));
            if (kGPlaylistMusic4 != null) {
                kGPlaylistMusic3.M(kGPlaylistMusic4.f() + iAbs + i2);
            }
        }
        l0.i(listO, 1000, a.a);
    }
}
