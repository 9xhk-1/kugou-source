package e.c.a.g.a.d.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int a = 50;
    public static int b = 100;
    public static String c = "audio";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f481d = "module";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f482e = "module";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f483f = "module";

    public class a implements Func1<List<e.c.a.g.a.d.r.p.a.g>, Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f484d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f485f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f486h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f487i;
        public final /* synthetic */ e.c.a.g.a.d.r.p.a.a j;
        public final /* synthetic */ SparseArray k;
        public final /* synthetic */ b l;

        public a(String str, String str2, int i2, int i3, boolean z, int i4, e.c.a.g.a.d.r.p.a.a aVar, SparseArray sparseArray, b bVar) {
            this.a = str;
            this.b = str2;
            this.f484d = i2;
            this.f485f = i3;
            this.f486h = z;
            this.f487i = i4;
            this.j = aVar;
            this.k = sparseArray;
            this.l = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Boolean call(java.util.List<e.c.a.g.a.d.r.p.a.g> r12) {
            /*
                r11 = this;
                e.c.a.g.a.d.r.d r0 = e.c.a.g.a.d.r.d.this
                java.lang.String r1 = r11.a
                e.c.a.g.a.d.r.p.a.h r3 = e.c.a.g.a.d.r.d.a(r0, r1)
                e.c.a.g.a.d.r.p.b.e r0 = new e.c.a.g.a.d.r.p.b.e
                r0.<init>()
                java.lang.String r4 = r11.b
                int r5 = r11.f484d
                int r7 = r11.f485f
                boolean r1 = r11.f486h
                r9 = 0
                r10 = 1
                if (r1 == 0) goto L1f
                int r1 = r11.f487i
                if (r1 != 0) goto L1f
                r8 = 1
                goto L20
            L1f:
                r8 = 0
            L20:
                r2 = r0
                r6 = r12
                e.c.a.g.a.d.r.p.a.a r12 = r2.g(r3, r4, r5, r6, r7, r8)
                e.c.a.g.a.d.r.p.a.a r1 = r11.j
                monitor-enter(r1)
                if (r12 == 0) goto L45
                int r2 = r12.f()     // Catch: java.lang.Throwable -> L43
                if (r2 != r10) goto L45
                java.util.List r2 = r12.d()     // Catch: java.lang.Throwable -> L43
                if (r2 == 0) goto L45
                android.util.SparseArray r2 = r11.k     // Catch: java.lang.Throwable -> L43
                int r3 = r11.f487i     // Catch: java.lang.Throwable -> L43
                java.util.List r12 = r12.d()     // Catch: java.lang.Throwable -> L43
                r2.put(r3, r12)     // Catch: java.lang.Throwable -> L43
                goto L76
            L43:
                r12 = move-exception
                goto Lb2
            L45:
                if (r12 == 0) goto L59
                int r2 = r12.c()     // Catch: java.lang.Throwable -> L43
                r3 = 20018(0x4e32, float:2.8051E-41)
                if (r2 != r3) goto L59
                android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L43
                java.lang.String r3 = "com.kugou.android.login_token_expire"
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L43
                e.c.a.g.a.f.d.a.d(r2)     // Catch: java.lang.Throwable -> L43
            L59:
                e.c.a.g.a.d.r.p.a.a r2 = r11.j     // Catch: java.lang.Throwable -> L43
                r2.m(r9)     // Catch: java.lang.Throwable -> L43
                e.c.a.g.a.d.r.d$b r2 = r11.l     // Catch: java.lang.Throwable -> L43
                r2.a = r10     // Catch: java.lang.Throwable -> L43
                if (r12 == 0) goto L6d
                e.c.a.g.a.d.r.p.a.a r2 = r11.j     // Catch: java.lang.Throwable -> L43
                int r12 = r12.c()     // Catch: java.lang.Throwable -> L43
                r2.i(r12)     // Catch: java.lang.Throwable -> L43
            L6d:
                e.c.a.g.a.d.r.p.a.a r12 = r11.j     // Catch: java.lang.Throwable -> L43
                e.c.a.g.a.d.b.a r2 = r0.d()     // Catch: java.lang.Throwable -> L43
                r12.l(r2)     // Catch: java.lang.Throwable -> L43
            L76:
                e.c.a.g.a.d.r.p.a.a r12 = r11.j     // Catch: java.lang.Throwable -> L43
                int r0 = r0.j()     // Catch: java.lang.Throwable -> L43
                r12.n(r0)     // Catch: java.lang.Throwable -> L43
                e.c.a.g.a.d.r.d$b r12 = r11.l     // Catch: java.lang.Throwable -> Lc2
                java.lang.Boolean[] r12 = r12.b     // Catch: java.lang.Throwable -> Lc2
                int r0 = r11.f487i     // Catch: java.lang.Throwable -> Lc2
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Lc2
                r12[r0] = r2     // Catch: java.lang.Throwable -> Lc2
                e.c.a.g.a.d.r.p.a.a r12 = r11.j     // Catch: java.lang.Throwable -> Lc2
                r12.notify()     // Catch: java.lang.Throwable -> Lc2
                boolean r12 = e.c.a.g.a.s.g0.a     // Catch: java.lang.Throwable -> Lc2
                if (r12 == 0) goto Lb0
                java.lang.String r12 = "zhpu_thread"
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc2
                r0.<init>()     // Catch: java.lang.Throwable -> Lc2
                java.lang.String r3 = "io : "
                r0.append(r3)     // Catch: java.lang.Throwable -> Lc2
                java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> Lc2
                long r3 = r3.getId()     // Catch: java.lang.Throwable -> Lc2
                r0.append(r3)     // Catch: java.lang.Throwable -> Lc2
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc2
                e.c.a.g.a.s.g0.b(r12, r0)     // Catch: java.lang.Throwable -> Lc2
            Lb0:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lc2
                return r2
            Lb2:
                e.c.a.g.a.d.r.d$b r0 = r11.l     // Catch: java.lang.Throwable -> Lc2
                java.lang.Boolean[] r0 = r0.b     // Catch: java.lang.Throwable -> Lc2
                int r2 = r11.f487i     // Catch: java.lang.Throwable -> Lc2
                java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Lc2
                r0[r2] = r3     // Catch: java.lang.Throwable -> Lc2
                e.c.a.g.a.d.r.p.a.a r0 = r11.j     // Catch: java.lang.Throwable -> Lc2
                r0.notify()     // Catch: java.lang.Throwable -> Lc2
                throw r12     // Catch: java.lang.Throwable -> Lc2
            Lc2:
                r12 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lc2
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.r.d.a.call(java.util.List):java.lang.Boolean");
        }
    }

    public class b {
        public boolean a;
        public Boolean[] b;

        public b(d dVar, int i2) {
            this.b = new Boolean[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.b[i3] = Boolean.FALSE;
            }
        }
    }

    public static <T> List<List<T>> k(List<T> list, int i2) {
        int size = list.size();
        int i3 = i2 - 1;
        int i4 = (size + i3) / i2;
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < i4; i5++) {
            ArrayList arrayList2 = new ArrayList();
            int i6 = 0;
            while (i6 < size) {
                int i7 = i6 + 1;
                if ((i7 + i3) / i2 == i5 + 1) {
                    arrayList2.add(list.get(i6));
                }
                if (i7 == i7 * i2) {
                    break;
                }
                i6 = i7;
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public e.c.a.g.a.d.r.p.a.a b(List<e.c.a.g.a.d.r.p.a.g> list, String str, String str2, String str3, int i2) {
        if (list == null || list.size() == 0) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.h hVar = new e.c.a.g.a.d.r.p.a.h();
        hVar.a = str2;
        hVar.b = str;
        return new e.c.a.g.a.d.r.p.b.e().a(hVar, str3, list, i2);
    }

    public e.c.a.g.a.d.r.p.a.a c(List<e.c.a.g.a.d.r.p.a.g> list, String str, String str2, String str3) {
        if (list == null || list.size() == 0) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.h hVar = new e.c.a.g.a.d.r.p.a.h();
        hVar.a = str2;
        hVar.b = str;
        return new e.c.a.g.a.d.r.p.b.e().b(hVar, str3, list);
    }

    public final e.c.a.g.a.d.r.p.a.f d(List<e.c.a.g.a.d.r.p.a.g> list, e.c.a.g.a.d.r.p.a.f fVar, boolean z) {
        if (g0.a) {
            g0.e("zzm-log", "resources size:" + list.size() + "首歌都造假的goods，是否免费：" + z);
        }
        e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
        e.c.a.g.a.d.r.p.a.b bVar = new e.c.a.g.a.d.r.p.a.b();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= list.size()) {
                bVar.d(arrayList);
                aVar.h(bVar);
                aVar.j(arrayList);
                fVar.h(1);
                fVar.g(aVar);
                return fVar;
            }
            if (!list.get(i2).h() || !z) {
                z2 = false;
            }
            arrayList.add(e.c.a.g.a.d.r.p.a.c.c(z2));
            i2++;
        }
    }

    public final boolean e(Boolean[] boolArr) {
        for (Boolean bool : boolArr) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public e.c.a.g.a.d.r.p.a.a f(List<e.c.a.g.a.d.r.p.a.g> list, String str, String str2, int i2, int i3) {
        return g(list, str, str2, i2, i3, false);
    }

    public e.c.a.g.a.d.r.p.a.a g(List<e.c.a.g.a.d.r.p.a.g> list, String str, String str2, int i2, int i3, boolean z) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int iL = l(list);
        if (g0.a) {
            g0.b("zhpu_check", "resource ： " + list.size() + " size ： " + iL);
        }
        List arrayList = new ArrayList();
        if (list.size() > iL) {
            arrayList = k(list, iL);
        } else {
            arrayList.add(list);
        }
        List list2 = arrayList;
        e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        int iA = i3 == 0 ? 0 : m0.a();
        b bVar = new b(this, list2.size());
        int i4 = 0;
        while (i4 < list2.size()) {
            b bVar2 = bVar;
            Observable.just((List) list2.get(i4)).subscribeOn(Schedulers.computation()).map(new a(str, str2, i2, iA, z, i4, aVar, sparseArray, bVar2)).subscribe(i1.a, i1.b);
            i4++;
            arrayList2 = arrayList2;
            iA = iA;
            bVar = bVar2;
            list2 = list2;
            sparseArray = sparseArray;
        }
        b bVar3 = bVar;
        SparseArray sparseArray2 = sparseArray;
        List list3 = list2;
        ArrayList arrayList3 = arrayList2;
        synchronized (aVar) {
            while (!e(bVar3.b) && !bVar3.a) {
                try {
                    aVar.wait();
                } catch (InterruptedException e2) {
                    g0.k(e2);
                }
            }
        }
        if (bVar3.a) {
            aVar.m(0);
        } else {
            for (int i5 = 0; i5 < list3.size(); i5++) {
                arrayList3.addAll((Collection) sparseArray2.get(i5));
            }
            aVar.j(arrayList3);
            aVar.m(1);
        }
        if (g0.a) {
            g0.b("zhpu_thread", "cur : " + Thread.currentThread().getId());
        }
        return aVar;
    }

    public e.c.a.g.a.d.r.p.a.f h(List<e.c.a.g.a.d.r.p.a.g> list, String str, String str2, int i2) {
        e.c.a.g.a.d.r.p.a.g gVar = null;
        if (list == null || list.size() <= 0 || list.get(0) == null) {
            return null;
        }
        e.c.a.g.a.d.r.p.b.e eVar = new e.c.a.g.a.d.r.p.b.e();
        e.c.a.g.a.d.r.p.a.h hVarI = i(str);
        if (list.size() == 1) {
            if (g0.a) {
                g0.e("zzm-log", "just one ,need recovery");
            }
            gVar = list.get(0);
            list.get(0).n(true);
        }
        if (list.size() > 1 && str2.equals("play")) {
            Iterator<e.c.a.g.a.d.r.p.a.g> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.c.a.g.a.d.r.p.a.g next = it.next();
                if (next.h()) {
                    if (g0.a) {
                        g0.e("zzm-log", "from play,one need recovery");
                    }
                    gVar = next;
                }
            }
        }
        if (gVar == null) {
            e.c.a.g.a.d.r.p.a.f fVar = new e.c.a.g.a.d.r.p.a.f();
            d(list, fVar, false);
            return fVar;
        }
        e.c.a.g.a.d.r.p.a.f fVarI = eVar.i(hVarI, str2, gVar, m0.a());
        if (fVarI != null && fVarI.c()) {
            if (g0.a) {
                g0.e("zzm-log", "isIntercept:true");
            }
            e.c.a.g.a.d.r.p.a.a aVarA = fVarI.a();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).h()) {
                    arrayList.add(aVarA.b().a().get(0));
                } else {
                    arrayList.add(e.c.a.g.a.d.r.p.a.c.c(false));
                }
            }
            aVarA.j(arrayList);
        } else if (fVarI != null && fVarI.b()) {
            if (g0.a) {
                g0.e("zzm-log", "hasPrivilege:true");
            }
            d(list, fVarI, true);
        }
        return fVarI;
    }

    public final e.c.a.g.a.d.r.p.a.h i(String str) {
        e.c.a.g.a.d.r.p.a.h hVar = new e.c.a.g.a.d.r.p.a.h();
        if (str != null && !TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "kMoreDialog":
                    hVar.c = AckManager.SERVICE_ID_ACK_DNS;
                    hVar.a = str;
                    hVar.b = c;
                    break;
                case "kILike":
                    hVar.c = 1007;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kRecentPlay":
                    hVar.c = 1005;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kListOwn":
                    hVar.c = PointerIconCompat.TYPE_COPY;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kListNoPrivUpdate":
                    hVar.c = PointerIconCompat.TYPE_GRAB;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kLocalSinger":
                    hVar.c = 1002;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kListFavoriteOl":
                    hVar.c = PointerIconCompat.TYPE_ALIAS;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kLocalAlbum":
                    hVar.c = 1003;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kPlayerMoreDialog":
                    hVar.c = 9001;
                    hVar.a = str;
                    hVar.b = c;
                    break;
                case "kKuqunSong":
                    hVar.c = BaseConnection.CONNECT_TIMEOUT;
                    hVar.a = str;
                    hVar.b = f481d;
                    break;
                case "kUgcUpload":
                    hVar.c = 8001;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kListFavorite":
                    hVar.c = PointerIconCompat.TYPE_VERTICAL_TEXT;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kListILike":
                    hVar.c = 1008;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kLocalIpod":
                    hVar.c = 1004;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kLocalSong":
                    hVar.c = 1001;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kDownload":
                    hVar.c = 1006;
                    hVar.a = str;
                    hVar.b = f482e;
                    break;
                case "kSiliaoSong":
                    hVar.c = 6001;
                    hVar.a = str;
                    hVar.b = f483f;
                    break;
                default:
                    hVar.a = str;
                    hVar.b = c;
                    break;
            }
        } else {
            hVar.a = str;
            hVar.b = c;
        }
        return hVar;
    }

    public e.c.a.g.a.d.r.r.a.a j(Context context) {
        return new e.c.a.g.a.d.r.r.b.b().a(context);
    }

    public final <T> int l(List<T> list) {
        return list.size() < 500 ? a : b;
    }
}
