package e.c.a.g.a.d.r.o;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.r.d;
import e.c.a.g.a.d.r.h;
import e.c.a.g.a.d.r.p.a.g;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.m0;
import e.c.a.g.a.s.r0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public class a implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ KGMusicWrapper b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0075b f508d;

        public a(ArrayList arrayList, KGMusicWrapper kGMusicWrapper, InterfaceC0075b interfaceC0075b) {
            this.a = arrayList;
            this.b = kGMusicWrapper;
            this.f508d = interfaceC0075b;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.a.g.a.d.r.p.a.a aVarF;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (KGMusicWrapper kGMusicWrapper : this.a) {
                g gVarG = b.g(kGMusicWrapper);
                if (gVarG != null) {
                    kGMusicWrapper.setNeedCheckListenPartPermission(true);
                    arrayList.add(gVarG);
                    arrayList2.add(kGMusicWrapper);
                }
            }
            if (arrayList.size() > 0 && (aVarF = new d().f(arrayList, "", "play", 0, m0.a())) != null && aVarF.f() == 1) {
                List<e.c.a.g.a.d.r.p.a.c> listD = aVarF.d();
                int size = listD.size();
                ArrayList arrayList3 = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    KGMusicWrapper kGMusicWrapper2 = (KGMusicWrapper) arrayList2.get(i2);
                    e.c.a.g.a.d.r.p.a.c cVar = listD.get(i2);
                    if (kGMusicWrapper2 == this.b && e.c.a.g.a.d.r.g.p(cVar)) {
                        b.f(this.b);
                        InterfaceC0075b interfaceC0075b = this.f508d;
                        if (interfaceC0075b != null) {
                            interfaceC0075b.resumePlay(this.b);
                        }
                    } else if (b.h(kGMusicWrapper2, cVar)) {
                        arrayList3.add(kGMusicWrapper2);
                    }
                }
                f.J(arrayList3);
            }
            InterfaceC0075b interfaceC0075b2 = this.f508d;
            if (interfaceC0075b2 != null) {
                interfaceC0075b2.notifyQueueChange();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.r.o.b$b, reason: collision with other inner class name */
    public interface InterfaceC0075b {
        void notifyQueueChange();

        void resumePlay(KGMusicWrapper kGMusicWrapper);
    }

    public static boolean b(KGMusicWrapper kGMusicWrapper) {
        return !e.c.a.g.a.d.r.g.k(kGMusicWrapper.getMusicFeeType()) && h.f(kGMusicWrapper.getFailProcess(), kGMusicWrapper.getPayType());
    }

    public static boolean c(KGMusicWrapper kGMusicWrapper) {
        if (!e.c.a.g.a.r.b.G() || (!r0.h(kGMusicWrapper.getMusicTransParamEnenty()) && !r0.g(kGMusicWrapper.getMusicTransParamEnenty()) && kGMusicWrapper.getPlayChareStatus() != 1 && !b(kGMusicWrapper))) {
            return true;
        }
        if (g0.a) {
            g0.e("FeeListenPartUtils", "checkListenPart is music pkg");
        }
        f(kGMusicWrapper);
        e.c.a.g.a.d.d0.a.a("Play", "checkListenPart resetKGMusicWrapper");
        return false;
    }

    public static void d(String str, KGMusicWrapper kGMusicWrapper, boolean z, List<KGMusicWrapper> list, InterfaceC0075b interfaceC0075b) {
        if (g0.a) {
            g0.e("refreshPlayQueue", "support action=" + str);
        }
        ArrayList<KGMusicWrapper> arrayList = new ArrayList(list);
        if (!e.c.a.g.a.r.b.G()) {
            ArrayList arrayList2 = new ArrayList();
            for (KGMusicWrapper kGMusicWrapper2 : arrayList) {
                if (r0.h(kGMusicWrapper2.getMusicTransParamEnenty()) || r0.e(kGMusicWrapper2.getMusicTransParamEnenty()) || kGMusicWrapper2.getPlayChareStatus() != 0) {
                    arrayList2.add(kGMusicWrapper2);
                }
            }
            if (g0.a) {
                g0.e("refreshPlayQueue", "support refreshPlayQueue size:" + arrayList2.size());
            }
            if (arrayList2.size() > 0) {
                e(arrayList2, kGMusicWrapper, interfaceC0075b);
                return;
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (KGMusicWrapper kGMusicWrapper3 : arrayList) {
            if (r0.h(kGMusicWrapper3.getMusicTransParamEnenty()) || r0.g(kGMusicWrapper3.getMusicTransParamEnenty())) {
                f(kGMusicWrapper3);
            } else if (r0.f(kGMusicWrapper3.getMusicTransParamEnenty())) {
                arrayList3.add(kGMusicWrapper3);
            } else if (kGMusicWrapper3.getPlayChareStatus() != 0) {
                arrayList3.add(kGMusicWrapper3);
            }
        }
        if (z && kGMusicWrapper != null && r0.g(kGMusicWrapper.getMusicTransParamEnenty())) {
            if (interfaceC0075b != null) {
                interfaceC0075b.resumePlay(kGMusicWrapper);
            }
            kGMusicWrapper = null;
            interfaceC0075b = null;
        } else if (g0.a) {
            g0.e("refreshPlayQueue", "support isPlayListenPartMode false ");
        }
        if (arrayList3.size() > 0) {
            e(arrayList3, kGMusicWrapper, interfaceC0075b);
        }
    }

    public static void e(ArrayList<KGMusicWrapper> arrayList, KGMusicWrapper kGMusicWrapper, InterfaceC0075b interfaceC0075b) {
        j0.b().a(new a(arrayList, kGMusicWrapper, interfaceC0075b));
    }

    public static void f(KGMusicWrapper kGMusicWrapper) {
        kGMusicWrapper.setNeedCheckListenPartPermission(false);
        kGMusicWrapper.setPlayChareStatus(0);
        kGMusicWrapper.setHashOffset(null);
        if (e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.j4, true)) {
            kGMusicWrapper.setIsListenPart(false);
        }
        Log.d("mhs_watch_crm", "resetKGMusicWrapper: 重置数据, " + kGMusicWrapper.getDisplayName() + "stack = " + Log.getStackTraceString(new Throwable()));
    }

    public static g g(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null) {
            return null;
        }
        if (!r0.h(kGMusicWrapper.getMusicTransParamEnenty()) && !r0.e(kGMusicWrapper.getMusicTransParamEnenty()) && kGMusicWrapper.getPlayChareStatus() == 0) {
            return null;
        }
        if (kGMusicWrapper.isConstructFromKGmusic()) {
            return e.c.a.g.a.d.r.g.I(kGMusicWrapper.getKgmusic());
        }
        if (kGMusicWrapper.isConstructFromKGFile() && kGMusicWrapper.getSongSource() == 1005) {
            return e.c.a.g.a.d.r.g.E(kGMusicWrapper.getInnerKGfile());
        }
        return null;
    }

    public static boolean h(KGMusicWrapper kGMusicWrapper, e.c.a.g.a.d.r.p.a.c cVar) {
        f(kGMusicWrapper);
        if (e.c.a.g.a.d.r.g.p(cVar) || e.c.a.g.a.d.r.g.n(cVar)) {
            return false;
        }
        if (cVar.F()) {
            kGMusicWrapper.setHashOffset(cVar.l());
        } else if (!TextUtils.isEmpty(kGMusicWrapper.getCouponID())) {
            kGMusicWrapper.setPlayChareStatus(4);
        } else if (r0.h(cVar.r()) || r0.h(kGMusicWrapper.getMusicTransParamEnenty())) {
            kGMusicWrapper.setPlayChareStatus(1);
        } else if (e.c.a.g.a.d.r.g.j(cVar)) {
            kGMusicWrapper.setPlayChareStatus(3);
        } else {
            kGMusicWrapper.setPlayChareStatus(2);
        }
        if (kGMusicWrapper.isConstructFromKGFile()) {
            kGMusicWrapper.getInnerKGfile().setMusicTransParamEnenty(cVar.r());
        } else {
            kGMusicWrapper.getKgmusic().setMusicTransParamEnenty(cVar.r());
        }
        if (g0.a) {
            g0.e("FeeListenPartUtils", "refreshOffsetInfo name = " + kGMusicWrapper.getDisplayName());
        }
        return true;
    }

    public static void i(List<KGMusicWrapper> list, List<KGMusicWrapper> list2) {
        if (g0.a) {
            g0.e("listen_part_log", "updateListenPart size = " + list.size());
        }
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        SparseArray sparseArray3 = new SparseArray();
        for (KGMusicWrapper kGMusicWrapper : list) {
            if (kGMusicWrapper != null) {
                int musicWrapperCode = kGMusicWrapper.getMusicWrapperCode();
                if (kGMusicWrapper.getHashOffset() != null) {
                    sparseArray.put(musicWrapperCode, kGMusicWrapper);
                }
                sparseArray2.put(musicWrapperCode, Boolean.valueOf(kGMusicWrapper.isNeedCheckListenPartPermission()));
                sparseArray3.put(musicWrapperCode, Integer.valueOf(kGMusicWrapper.getPlayChareStatus()));
            }
        }
        for (KGMusicWrapper kGMusicWrapper2 : list2) {
            int musicWrapperCode2 = kGMusicWrapper2.getMusicWrapperCode();
            if (sparseArray.indexOfKey(musicWrapperCode2) >= 0) {
                KGMusicWrapper kGMusicWrapper3 = (KGMusicWrapper) sparseArray.get(musicWrapperCode2);
                kGMusicWrapper2.setHashOffset(kGMusicWrapper3.getHashOffset());
                if (kGMusicWrapper2.isConstructFromKGFile()) {
                    kGMusicWrapper2.getInnerKGfile().setMusicTransParamEnenty(kGMusicWrapper3.getMusicTransParamEnenty());
                } else {
                    kGMusicWrapper2.getKgmusic().setMusicTransParamEnenty(kGMusicWrapper3.getMusicTransParamEnenty());
                }
                if (g0.a) {
                    g0.e("listen_part_log", "updateListenPart name = " + kGMusicWrapper2.getDisplayName());
                }
            }
            Boolean bool = (Boolean) sparseArray2.get(musicWrapperCode2);
            if (bool != null) {
                kGMusicWrapper2.setNeedCheckListenPartPermission(bool.booleanValue());
            } else {
                kGMusicWrapper2.setNeedCheckListenPartPermission(false);
            }
            Integer num = (Integer) sparseArray3.get(musicWrapperCode2);
            if (num != null) {
                kGMusicWrapper2.setPlayChareStatus(num.intValue());
            }
        }
    }
}
