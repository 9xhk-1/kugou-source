package e.c.a.g.a.g.k;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.a.g.a.d.f.c.a.g;
import e.c.a.g.a.g.i.c;
import e.c.a.g.a.s.l0;
import f.u.d0;
import f.u.m;
import f.u.u;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();
    public static final g b;

    /* JADX INFO: renamed from: e.c.a.g.a.g.k.a$a, reason: collision with other inner class name */
    public static final class C0147a<T> implements e.c.a.g.a.s.y1.a {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ HashMap<Long, Long> b;

        public C0147a(Boolean bool, HashMap<Long, Long> map) {
            this.a = bool;
            this.b = map;
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(List<Long> list) {
            if (e.c.c.o.g.d()) {
                Log.e("mhs_watch_fav_update", "2 mixidGroup = " + list + ", FavOptionHelper.forceUpdatCharge = " + e.c.a.g.a.g.f.c.a.j());
            }
            if (j.a(this.a, Boolean.TRUE) || e.c.a.g.a.g.f.c.a.j()) {
                HashMap<Long, Long> map = this.b;
                a aVar = a.a;
                g gVar = a.b;
                j.d(list, "it");
                map.putAll(aVar.x(gVar.k(list)));
                return;
            }
            HashMap<Long, Long> map2 = this.b;
            a aVar2 = a.a;
            g gVar2 = a.b;
            j.d(list, "it");
            map2.putAll(aVar2.x(gVar2.l(list)));
        }
    }

    public static final class b<T> implements e.c.a.g.a.s.y1.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ HashMap<String, Long> b;

        public b(boolean z, HashMap<String, Long> map) {
            this.a = z;
            this.b = map;
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(List<String> list) {
            if (this.a) {
                HashMap<String, Long> map = this.b;
                a aVar = a.a;
                g gVar = a.b;
                j.d(list, "it");
                map.putAll(aVar.y(gVar.j(list)));
                return;
            }
            HashMap<String, Long> map2 = this.b;
            a aVar2 = a.a;
            g gVar2 = a.b;
            j.d(list, "it");
            map2.putAll(aVar2.y(gVar2.i(list)));
        }
    }

    public static final class c<T> implements e.c.a.g.a.s.y1.a {
        public final /* synthetic */ ArrayList<KGMusic> a;

        public c(ArrayList<KGMusic> arrayList) {
            this.a = arrayList;
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(List<String> list) {
            a aVar = a.a;
            j.d(list, "it");
            List listP = aVar.p(list);
            if (listP != null) {
                this.a.addAll(listP);
            }
        }
    }

    public static final class d<T> implements e.c.a.g.a.s.y1.a {
        public final /* synthetic */ ArrayList<KGMusic> a;

        public d(ArrayList<KGMusic> arrayList) {
            this.a = arrayList;
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(List<Long> list) {
            a aVar = a.a;
            j.d(list, "it");
            List listR = aVar.r(list);
            if (listR != null) {
                this.a.addAll(listR);
            }
        }
    }

    public static final class e<T> implements e.c.a.g.a.s.y1.a {
        public final /* synthetic */ ArrayList<KGMusic> a;

        public e(ArrayList<KGMusic> arrayList) {
            this.a = arrayList;
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(List<String> list) {
            List listT = a.a.t(list);
            if (listT != null) {
                this.a.addAll(listT);
            }
        }
    }

    public static final class f extends k implements l<KGMusic, CharSequence> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(KGMusic kGMusic) {
            StringBuilder sb = new StringBuilder();
            sb.append("dbId:");
            sb.append(kGMusic == null ? null : Long.valueOf(kGMusic.dbId));
            sb.append("  mixId:");
            sb.append(kGMusic == null ? null : Long.valueOf(kGMusic.mixId));
            sb.append("  hash=");
            sb.append((Object) (kGMusic != null ? kGMusic.hashValue : null));
            return sb.toString();
        }
    }

    static {
        e.c.a.g.a.d.f.b bVar = e.c.a.g.a.d.f.b.a;
        Context contextA = e.c.c.o.f.a();
        j.d(contextA, "getContext()");
        b = bVar.a(contextA).h();
    }

    public final void A(String str) {
        j.e(str, "globalCollectionId");
        b.h(str);
    }

    public final void B(List<? extends KGMusic> list) {
        if (list.isEmpty()) {
            return;
        }
        int iS = b.s(list);
        StringBuilder sb = new StringBuilder();
        sb.append("更新数据 是否成功 dao.update(list) = ");
        sb.append(iS);
        sb.append(", size = ");
        sb.append(list == null ? null : Integer.valueOf(list.size()));
        Log.e("mhs_watch_fav_update", sb.toString());
    }

    public final boolean C(List<c.a> list) {
        j.e(list, "list");
        ArrayList arrayList = new ArrayList();
        for (c.a aVar : list) {
            KGMusic kGMusic = aVar == null ? null : aVar.f838d;
            if (kGMusic != null) {
                arrayList.add(kGMusic);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        b.s(arrayList);
        return true;
    }

    public final boolean D(List<? extends KGMusic> list, boolean z, boolean z2) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        if (e.c.c.o.g.a) {
            e.c.c.o.g.a("KGMusicDaoHelper", j.l("updateMusicsNoOverride:", u.B(list, null, null, null, 0, null, f.a, 31, null)));
        }
        ArrayList arrayList = new ArrayList();
        for (KGMusic kGMusic : list) {
            if (kGMusic != null) {
                arrayList.add(kGMusic);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        b.s(arrayList);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int e(java.util.ArrayList<com.kugou.android.watch.lite.common.music.entity.KGMusic> r18, e.c.a.g.a.g.i.e r19) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.k.a.e(java.util.ArrayList, e.c.a.g.a.g.i.e):int");
    }

    public final int f(ArrayList<KGMusic> arrayList) {
        for (KGMusic kGMusic : arrayList) {
            a aVar = a;
            aVar.w(kGMusic);
            aVar.z(kGMusic);
        }
        return arrayList.size();
    }

    public final int g(ArrayList<KGMusic> arrayList) {
        long j;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        Iterator<T> it = arrayList.iterator();
        while (true) {
            j = 0;
            if (!it.hasNext()) {
                break;
            }
            KGMusic kGMusic = (KGMusic) it.next();
            a.z(kGMusic);
            long j2 = kGMusic.mixId;
            if (j2 > 0) {
                arrayList2.add(Long.valueOf(j2));
            } else if (!TextUtils.isEmpty(kGMusic.hashValue)) {
                arrayList3.add(kGMusic.hashValue);
            }
        }
        List<KGMusic> listQ = q(arrayList2);
        List<KGMusic> listO = o(arrayList3);
        if (listQ == null) {
            linkedHashMap = null;
        } else {
            linkedHashMap = new LinkedHashMap(listQ.size());
            for (Object obj : listQ) {
                linkedHashMap.put(Long.valueOf(((KGMusic) obj).mixId), obj);
            }
        }
        if (listO == null) {
            linkedHashMap2 = null;
        } else {
            linkedHashMap2 = new LinkedHashMap(listO.size());
            for (Object obj2 : listO) {
                linkedHashMap2.put(((KGMusic) obj2).hashValue, obj2);
            }
        }
        boolean z = true;
        if (listQ == null || listQ.isEmpty()) {
            if (listO != null && !listO.isEmpty()) {
                z = false;
            }
            if (z) {
                v(arrayList);
                return arrayList.size();
            }
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (KGMusic kGMusic2 : arrayList) {
            long j3 = kGMusic2.mixId;
            KGMusic kGMusic3 = j3 > j ? (KGMusic) linkedHashMap.get(Long.valueOf(j3)) : (KGMusic) linkedHashMap2.get(kGMusic2.hashValue);
            StringBuilder sb = new StringBuilder();
            sb.append("updateMusic.id = ");
            sb.append(kGMusic3 == null ? null : Long.valueOf(kGMusic3.id));
            sb.append(", updateMusic.dbId = ");
            sb.append(kGMusic3 == null ? null : Long.valueOf(kGMusic3.dbId));
            sb.append(", updateMusic?.charge = ");
            sb.append(kGMusic3 == null ? null : Integer.valueOf(kGMusic3.charge));
            sb.append(", it.id = ");
            sb.append(kGMusic2 == null ? null : Long.valueOf(kGMusic2.id));
            sb.append(", it?.dbId = ");
            sb.append(kGMusic2 == null ? null : Long.valueOf(kGMusic2.dbId));
            sb.append(", it?.charge = ");
            sb.append(kGMusic2 == null ? null : Integer.valueOf(kGMusic2.charge));
            Log.e("mhs_watch_fav_update", sb.toString());
            if (e.c.c.o.g.d()) {
                Log.e("mhs_watch_fav_update", j.l("更新前数据 本地数据库数据 updateMusic = ", kGMusic3));
                Log.e("mhs_watch_fav_update", j.l("更新前数据 要写入的数据 it = ", kGMusic2));
            }
            if (kGMusic3 != null) {
                kGMusic2.dbId = kGMusic3.dbId;
                arrayList5.add(kGMusic2);
            } else {
                arrayList4.add(kGMusic2);
            }
            j = 0;
        }
        v(arrayList4);
        B(arrayList5);
        if (e.c.c.o.g.d()) {
            List<KGMusic> listQ2 = q(arrayList2);
            if (listQ2.size() > 0) {
                Log.e("mhs_watch_fav_update", "更新后 实际的数据 existMusics2 = " + listQ2.size() + ", 结果 = " + listQ2.get(0));
            }
        }
        return arrayList.size();
    }

    public final Map<Long, Long> h(List<Long> list, Boolean bool) {
        if (list == null || list.isEmpty()) {
            return d0.d();
        }
        if (list.size() > 200) {
            HashMap map = new HashMap(list.size());
            l0.i(list, 200, new C0147a(bool, map));
            return map;
        }
        if (e.c.c.o.g.d()) {
            Log.e("mhs_watch_fav_update", "1, mixidGroup = " + list + ", FavOptionHelper.forceUpdatCharge = " + e.c.a.g.a.g.f.c.a.j());
        }
        return (j.a(bool, Boolean.TRUE) || e.c.a.g.a.g.f.c.a.j()) ? x(b.k(list)) : x(b.l(list));
    }

    public final Map<String, Long> i(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return d0.d();
        }
        if (list.size() <= 200) {
            return z ? y(b.j(list)) : y(b.i(list));
        }
        HashMap map = new HashMap(list.size());
        l0.i(list, 200, new b(z, map));
        return map;
    }

    public final Map<String, Long> j(List<? extends c.a> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends c.a> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next().a;
            if (!TextUtils.isEmpty(str)) {
                j.d(str, "hashValue");
                Locale locale = Locale.getDefault();
                j.d(locale, "getDefault()");
                String upperCase = str.toUpperCase(locale);
                j.d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                arrayList.add(upperCase);
            }
        }
        return i(arrayList, false);
    }

    public final List<String> k(List<? extends KGMusic> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return m.d();
        }
        ArrayList arrayList = new ArrayList();
        for (KGMusic kGMusic : list) {
            if (!z || kGMusic.mixId <= 0) {
                String str = kGMusic.hashValue;
                if (!TextUtils.isEmpty(str)) {
                    j.d(str, "hashValue");
                    Locale locale = Locale.getDefault();
                    j.d(locale, "getDefault()");
                    String upperCase = str.toUpperCase(locale);
                    j.d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    arrayList.add(upperCase);
                }
            }
        }
        return arrayList;
    }

    public final KGMusic l(String str) {
        j.e(str, "hash");
        return b.m(str);
    }

    public final KGMusic m(long j, String str) {
        j.e(str, "musicHash");
        return b.n(j, str);
    }

    public final KGMusic n(long j) {
        return b.o(j);
    }

    public final List<KGMusic> o(List<String> list) {
        j.e(list, "hashList");
        if (list.size() <= 200) {
            return p(list);
        }
        ArrayList arrayList = new ArrayList(list.size());
        try {
            l0.i(list, 200, new c(arrayList));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final List<KGMusic> p(List<String> list) {
        return list.isEmpty() ? m.d() : b.p(list);
    }

    public final List<KGMusic> q(List<Long> list) {
        j.e(list, "mixIds");
        if (list.size() <= 200) {
            return r(list);
        }
        ArrayList arrayList = new ArrayList(list.size());
        l0.i(list, 200, new d(arrayList));
        return arrayList;
    }

    public final List<KGMusic> r(List<Long> list) {
        return list.isEmpty() ? m.d() : b.q(list);
    }

    public final List<KGMusic> s(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() <= 200) {
            return t(list);
        }
        ArrayList arrayList = new ArrayList(list.size());
        l0.i(list, 200, new e(arrayList));
        return arrayList;
    }

    public final List<KGMusic> t(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return b.r(list);
    }

    public final List<Long> u(List<? extends KGMusic> list) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size > 0) {
            while (true) {
                int i3 = i2 + 1;
                long j = list.get(i2).mixId;
                if (j > 0) {
                    arrayList.add(Long.valueOf(j));
                }
                if (i3 >= size) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    public final void v(List<? extends KGMusic> list) {
        if (list.isEmpty()) {
            return;
        }
        b.e(list);
    }

    public final long w(KGMusic kGMusic) {
        KGMusic kGMusicL;
        j.e(kGMusic, "music");
        long j = kGMusic.mixId;
        if (j > 0) {
            kGMusicL = n(j);
        } else {
            String str = kGMusic.hashValue;
            j.d(str, "music.hashValue");
            kGMusicL = l(str);
        }
        if (kGMusicL == null) {
            return b.d(kGMusic);
        }
        kGMusic.id = kGMusicL.getId();
        return b.g(kGMusic);
    }

    public final Map<Long, Long> x(Cursor cursor) {
        j.e(cursor, "cursor");
        if (cursor.getCount() <= 0) {
            return d0.d();
        }
        HashMap map = new HashMap();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex("mixId");
            int columnIndex2 = cursor.getColumnIndex(DbOpenHelper.ID);
            Log.e("mhs_watch_fav_update", "mixIdIdx = " + columnIndex + ", idIdx = " + columnIndex2);
            if (columnIndex >= 0 && columnIndex2 >= 0) {
                map.put(Long.valueOf(cursor.getLong(columnIndex)), Long.valueOf(cursor.getLong(columnIndex2)));
            }
            cursor.moveToNext();
        }
        return map;
    }

    public final Map<String, Long> y(Cursor cursor) {
        j.e(cursor, "cursor");
        if (cursor.getCount() <= 0) {
            return d0.d();
        }
        HashMap map = new HashMap();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex("hashValue");
            int columnIndex2 = cursor.getColumnIndex(DbOpenHelper.ID);
            if (columnIndex >= 0 && columnIndex2 >= 0) {
                map.put(cursor.getString(columnIndex), Long.valueOf(cursor.getLong(columnIndex2)));
            }
            cursor.moveToNext();
        }
        return map;
    }

    public final void z(KGMusic kGMusic) {
        if (kGMusic != null) {
            String[] strArrA = e.c.a.g.a.f.j.c.a.a(kGMusic.displayName);
            j.d(strArrA, "getArtistAndTrackTitle(kgMusic.displayName)");
            kGMusic.trackName = strArrA[1];
            kGMusic.artistName = strArrA[0];
        }
    }
}
