package e.c.a.g.a.d.s;

import android.content.ContentProviderResult;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.s.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j1;
import e.c.a.g.a.s.l0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final f a = e.c.a.g.a.d.f.b.a.a(KGApplication.getContext()).f();

    public static void a(@IntRange(from = 0) long j, List<Long> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Long l : list) {
            if (l != null && l.longValue() != 0) {
                arrayList.add(new d(0L, "", 0L, j, System.currentTimeMillis(), System.currentTimeMillis(), l.longValue()));
            }
        }
        d(arrayList, j);
    }

    public static void b(@IntRange(from = 0) long j, List<KGSong> list) {
        if (list == null || list.size() == 0 || !e.c.a.g.a.r.b.F()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (KGSong kGSong : list) {
            if (kGSong != null) {
                arrayList.add(new d(0L, kGSong.J1(), kGSong.T1(), j, System.currentTimeMillis(), System.currentTimeMillis(), 0L));
            }
        }
        e(arrayList, j);
    }

    public static HashMap<Long, d> c(List<d> list, @IntRange(from = 0) long j) {
        HashMap<Long, d> map = new HashMap<>();
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().a()));
            }
            for (d dVar : a.k(arrayList, j)) {
                map.put(Long.valueOf(dVar.a()), dVar);
            }
        } catch (Exception e2) {
            g0.e("FeeKubiBuyInfoDaoLog", "getExistAlbumData:e" + Log.getStackTraceString(e2));
        }
        return map;
    }

    public static ArrayList<ContentProviderResult> d(List<d> list, @IntRange(from = 0) long j) {
        HashMap<Long, d> map;
        ArrayList arrayList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            Iterator<d> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().a() <= 0) {
                    it.remove();
                }
            }
            HashMap<Long, d> mapC = c(list, j);
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList2 = new ArrayList();
            for (d dVar : list) {
                if (mapC.get(Long.valueOf(dVar.a())) == null) {
                    map = mapC;
                    arrayList = arrayList2;
                    arrayList.add(new d(0L, "", 0L, j, jCurrentTimeMillis, jCurrentTimeMillis, dVar.a()));
                } else {
                    map = mapC;
                    arrayList = arrayList2;
                }
                arrayList2 = arrayList;
                mapC = map;
            }
            ArrayList arrayList3 = arrayList2;
            if (!arrayList3.isEmpty()) {
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    if (g0.a) {
                        g0.e("FeeKubiBuyInfoDaoLog", "insertAlbumBuyDataWithRoom inserted: " + arrayList3.size() + " records");
                    }
                    int i3 = i2 + 500;
                    a.m(arrayList3.subList(i2, Math.min(i3, arrayList3.size())));
                    i2 = i3;
                }
            }
            if (!g0.a) {
                return null;
            }
            g0.e("FeeKubiBuyInfoDaoLog", "intsetAlbumBuyData operations");
            return null;
        } catch (Exception e2) {
            g0.k(e2);
            return null;
        }
    }

    public static void e(List<d> list, long j) {
        long j2;
        long j3;
        List<d> listL;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList<d> arrayList = new ArrayList();
        for (d dVar : list) {
            if (dVar.e() > 0) {
                arrayList.add(dVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((d) it.next()).e()));
        }
        HashMap map = new HashMap();
        if (!l0.g(arrayList2) && (listL = a.l(j, arrayList2)) != null) {
            for (d dVar2 : listL) {
                map.put(Long.valueOf(dVar2.e()), dVar2);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (d dVar3 : arrayList) {
            d dVar4 = (d) map.get(Long.valueOf(dVar3.e()));
            if (dVar4 == null) {
                j2 = jCurrentTimeMillis;
                a.d(new d(0L, dVar3.c(), dVar3.e(), j, jCurrentTimeMillis, j2, 0L));
            } else {
                j2 = jCurrentTimeMillis;
                if (!j1.a("updateBuy")) {
                    String strC = dVar4.c();
                    String strC2 = dVar3.c();
                    if (TextUtils.isEmpty(strC)) {
                        dVar4.h(strC2);
                        j3 = j2;
                        dVar4.i(j3);
                        a.n(dVar4);
                    } else {
                        j3 = j2;
                        if (!TextUtils.isEmpty(strC2) && !strC.contains(strC2)) {
                            dVar4.h(strC + "," + strC2);
                            dVar4.i(j3);
                            a.n(dVar4);
                        }
                    }
                }
                jCurrentTimeMillis = j3;
            }
            j3 = j2;
            jCurrentTimeMillis = j3;
        }
    }

    public static /* synthetic */ boolean f(Long l) {
        return l.longValue() != 0;
    }

    public static c.a g(long j) {
        c.a aVar = new c.a();
        try {
            List<d> listJ = a.j(j);
            if (listJ != null && !listJ.isEmpty()) {
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                for (d dVar : listJ) {
                    long jA = dVar.a();
                    long jE = dVar.e();
                    if (jA > 0 && jE <= 0) {
                        hashSet.add(Long.valueOf(jA));
                    }
                    if (jE > 0) {
                        hashSet2.add(Long.valueOf(jE));
                    }
                    String strC = dVar.c();
                    if (!TextUtils.isEmpty(strC)) {
                        for (String str : strC.split(",")) {
                            if (!TextUtils.isEmpty(str)) {
                                hashSet3.add(str);
                            }
                        }
                    }
                }
                aVar.h().addAll(hashSet);
                aVar.i().addAll(hashSet3);
                aVar.j().addAll(hashSet2);
            }
        } catch (Exception e2) {
            g0.k(e2);
        }
        if (g0.a) {
            g0.e("FeeKubiBuyInfoDaoLog", "queryData buyData:" + aVar);
        }
        return aVar;
    }

    public static void h(long j, HashSet<Long> hashSet) {
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        try {
            List<Long> list = (List) hashSet.stream().filter(new Predicate() { // from class: e.c.a.g.a.d.s.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return e.f((Long) obj);
                }
            }).collect(Collectors.toList());
            if (list.isEmpty()) {
                return;
            }
            a.h(j, list);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void i(long j, HashSet<Long> hashSet) {
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Long l : hashSet) {
            if (l.longValue() != 0) {
                arrayList.add(l);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            a.i(j, arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
