package e.c.a.g.a.g.i;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import com.xtc.payapi.contact.BaseResponse;
import e.c.a.g.a.g.i.c;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static d c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HandlerThread f916d;
    public static Map<String, Integer> a = new HashMap();
    public static final Byte[] b = new Byte[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static List<c> f917e = new LinkedList();

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ List b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f918d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f919f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f920h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ e f921i;

        public a(Context context, List list, List list2, String str, boolean z, e eVar) {
            this.a = context;
            this.b = list;
            this.f918d = list2;
            this.f919f = str;
            this.f920h = z;
            this.f921i = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (x.b) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                x.e(this.a, this.b, this.f918d, this.f919f, this.f920h, this.f921i);
                x.k("completeMusicInfoTime=" + String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            }
        }
    }

    public class b implements Comparator<KGPlaylistMusic> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(KGPlaylistMusic kGPlaylistMusic, KGPlaylistMusic kGPlaylistMusic2) {
            if (kGPlaylistMusic == null || kGPlaylistMusic2 == null) {
                return 0;
            }
            if (kGPlaylistMusic.f() > kGPlaylistMusic2.f()) {
                return 1;
            }
            return kGPlaylistMusic.f() == kGPlaylistMusic2.f() ? 0 : -1;
        }
    }

    public interface c {
        void onNewListGot();

        void onStartSync();

        void onSyncDone(boolean z, String str);
    }

    public static class d extends Handler {
        public boolean a;
        public final Object b;

        public d(Looper looper) {
            super(looper);
            this.a = false;
            this.b = new Object();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (this.b) {
                if (message.what == 1001) {
                    this.a = true;
                    y.e().b(1, new w());
                    this.a = false;
                }
            }
        }
    }

    public static boolean c(String str, String str2) {
        return TextUtils.isEmpty(str) && TextUtils.isEmpty(str2);
    }

    public static synchronized int d(Context context, List<e.c.a.g.a.g.k.c.a> list, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, e eVar) {
        int iG;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            KGPlaylistMusic kGPlaylistMusic = new KGPlaylistMusic(list.get(i2), str2);
            kGPlaylistMusic.H(list.get(i2).d());
            arrayList.add(kGPlaylistMusic);
            arrayList2.add(kGPlaylistMusic.i());
        }
        s(str, z, z2, arrayList);
        iG = g(arrayList, arrayList2, eVar);
        if (e.c.a.g.a.d.k.b.a()) {
            i(str, arrayList);
        } else {
            h(str, arrayList);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(((KGPlaylistMusic) arrayList.get(i3)).i());
        }
        Executors.newSingleThreadExecutor().execute(new a(context, arrayList, arrayList2, str, z4, eVar));
        return iG;
    }

    public static void e(Context context, List<KGPlaylistMusic> list, List<String> list2, String str, boolean z, e eVar) {
        ArrayList arrayList;
        boolean z2;
        System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<KGPlaylistMusic> arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (List<String> list3 : e.c.a.g.a.d.r.d.k(list2, 500)) {
            List<KGMusic> listS = e.c.a.g.a.g.k.a.a.s(list3);
            if (listS != null) {
                k("tempSize=" + listS.size() + "\tlistSize=" + list3.size());
                arrayList5.addAll(listS);
            }
        }
        HashMap map = new HashMap();
        int size = arrayList5.size();
        for (int i2 = 0; i2 < size; i2++) {
            KGMusic kGMusic = (KGMusic) arrayList5.get(i2);
            String m4aHash = kGMusic.getM4aHash();
            String hashValue = kGMusic.getHashValue();
            String hash320 = kGMusic.getHash320();
            String sqHash = kGMusic.getSqHash();
            if (!TextUtils.isEmpty(m4aHash)) {
                map.put(m4aHash, Integer.valueOf(i2));
            }
            if (!TextUtils.isEmpty(hashValue)) {
                map.put(hashValue, Integer.valueOf(i2));
            }
            if (!TextUtils.isEmpty(hash320)) {
                map.put(hash320, Integer.valueOf(i2));
            }
            if (!TextUtils.isEmpty(sqHash)) {
                map.put(sqHash, Integer.valueOf(i2));
            }
        }
        int i3 = 0;
        while (true) {
            arrayList = null;
            KGMusic kGMusic2 = null;
            if (i3 >= list.size()) {
                break;
            }
            KGPlaylistMusic kGPlaylistMusic = list.get(i3);
            if (map.containsKey(kGPlaylistMusic.i())) {
                kGMusic2 = (KGMusic) arrayList5.get(((Integer) map.get(kGPlaylistMusic.i())).intValue());
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                arrayList3.add(kGPlaylistMusic);
            } else if (kGMusic2 != null) {
                KGMusic kGMusicK = kGPlaylistMusic.k();
                String mvHashValue = kGMusic2.getMvHashValue();
                String mvHashValue2 = kGMusicK.getMvHashValue();
                if (!e.c.a.g.a.f.j.a.b.a(kGMusic2.getHashType()) || !kGMusic2.hasOrtherQuelityHash()) {
                    arrayList2.add(kGPlaylistMusic);
                    kGMusic2.setFeeAlbumId(kGMusicK.getFeeAlbumId());
                    kGPlaylistMusic.T(kGMusic2);
                    if ((TextUtils.isEmpty(mvHashValue) && !TextUtils.isEmpty(mvHashValue2)) || (z && kGPlaylistMusic != null)) {
                        if (g0.a) {
                            g0.b("zhpu_mv_hash", "incomplete music " + kGMusicK.getDisplayName() + " mv hash : " + mvHashValue2);
                        }
                        kGMusic2.setMvHashValue(mvHashValue2);
                        kGMusic2.setMvMatchTime(kGMusicK.getMvMatchTime());
                        kGMusic2.setMvTracks(kGMusicK.getMvTracks());
                        kGMusic2.setMvType(kGMusicK.getMvType());
                    }
                } else if (z) {
                    if (g0.a) {
                        g0.b("zhpu_mv_hash", "complete music " + kGMusicK.getDisplayName() + " mv hash : " + mvHashValue2);
                    }
                    if (!c(mvHashValue, mvHashValue2) || !l(mvHashValue, mvHashValue2)) {
                        kGMusic2.setMvHashValue(kGMusicK.getMvHashValue());
                        kGMusic2.setMvMatchTime(kGMusicK.getMvMatchTime());
                        kGMusic2.setMvTracks(kGMusicK.getMvTracks());
                        kGMusic2.setMvType(kGMusicK.getMvType());
                        arrayList4.add(kGPlaylistMusic);
                    }
                }
            }
            i3++;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList6 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            arrayList6.add(((KGPlaylistMusic) arrayList2.get(i4)).k());
        }
        for (int i5 = 0; i5 < arrayList3.size(); i5++) {
            arrayList6.add(((KGPlaylistMusic) arrayList3.get(i5)).k());
        }
        List<c.a> listC = new e.c.a.g.a.g.i.c().c(arrayList6);
        k("MusicInfoCompletionProtocol-Time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        ArrayList<c.a> arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        HashMap map2 = new HashMap();
        ArrayList arrayList9 = new ArrayList();
        boolean z3 = eVar != null && eVar.a();
        for (c.a aVar : listC) {
            if (z3) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar.f838d);
            }
            KGMusic kGMusicM = e.c.a.g.a.g.k.a.a.m(aVar.b, aVar.a);
            if (kGMusicM != null) {
                long j = kGMusicM.dbId;
                if (j > 0) {
                    KGMusic kGMusic3 = aVar.f838d;
                    kGMusic3.dbId = j;
                    kGMusic3.setSid(kGMusicM.getSid());
                    long sid = aVar.f838d.getSid();
                    if (sid != kGMusicM.getSid() && kGMusicM.getSid() > 0) {
                        map2.put(Long.valueOf(sid), Long.valueOf(kGMusicM.getSid()));
                    }
                    arrayList9.add(aVar.f838d);
                    arrayList8.add(aVar);
                }
            }
            arrayList7.add(aVar);
        }
        if (z3 && arrayList != null) {
            arrayList.size();
        }
        map2.size();
        boolean zD = arrayList9.size() > 0 ? e.c.a.g.a.g.k.a.a.D(arrayList9, true, false) | false : false;
        if (arrayList8.size() > 0) {
            zD |= e.c.a.g.a.g.k.a.a.C(arrayList8);
        }
        HashMap map3 = new HashMap();
        for (KGPlaylistMusic kGPlaylistMusic2 : arrayList3) {
            map3.put(kGPlaylistMusic2.k(), kGPlaylistMusic2);
        }
        Map<String, Long> mapJ = e.c.a.g.a.g.k.a.a.j(arrayList7);
        if (mapJ != null) {
            for (c.a aVar2 : arrayList7) {
                String hashValue2 = aVar2.f838d.getHashValue();
                if (mapJ.containsKey(hashValue2)) {
                    aVar2.f838d.dbId = mapJ.get(hashValue2).longValue();
                    if (map3.containsKey(aVar2.f838d)) {
                        KGPlaylistMusic kGPlaylistMusic3 = (KGPlaylistMusic) map3.get(aVar2.f838d);
                        arrayList2.add(kGPlaylistMusic3);
                        arrayList3.remove(kGPlaylistMusic3);
                    }
                }
            }
        }
        k(" errorMusicsSize = " + listC.size());
        try {
            ArrayList arrayList10 = new ArrayList();
            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                arrayList10.add(((KGPlaylistMusic) arrayList2.get(i6)).k());
            }
            for (int i7 = 0; i7 < arrayList4.size(); i7++) {
                arrayList10.add(((KGPlaylistMusic) arrayList4.get(i7)).k());
            }
            zD |= e.c.a.g.a.g.k.a.a.D(arrayList10, true, false);
        } catch (SQLiteConstraintException e2) {
            e2.printStackTrace();
        }
        e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.cloud_playlist_updateed").putExtra("global_collection_id", str).putExtra("once_update_playlist", zD));
        e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.update_playlist_audio"));
    }

    public static void f() {
        if (f916d == null) {
            synchronized (b) {
                if (f916d == null) {
                    HandlerThread handlerThread = new HandlerThread("CloudSyncManger-updateCloudPlaylist");
                    f916d = handlerThread;
                    handlerThread.start();
                }
            }
        }
        try {
            if (!f916d.isAlive()) {
                f916d.run();
            }
            if (c == null) {
                c = new d(f916d.getLooper());
            }
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    public static int g(List<KGPlaylistMusic> list, List<String> list2, e eVar) {
        return e.c.a.g.a.g.k.a.a.e(r(list, eVar), eVar);
    }

    public static void h(String str, List<KGPlaylistMusic> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            KGPlaylistMusic kGPlaylistMusic = list.get(i2);
            kGPlaylistMusic.O(str);
            KGMusic kGMusicK = kGPlaylistMusic.k();
            if (kGMusicK != null) {
                kGPlaylistMusic.W(kGMusicK.mixId);
                kGPlaylistMusic.P(kGMusicK.hashValue);
            }
            e.c.a.g.a.g.k.b.a.p(kGPlaylistMusic);
        }
    }

    public static void i(String str, List<KGPlaylistMusic> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (KGPlaylistMusic kGPlaylistMusic : list) {
            kGPlaylistMusic.O(str);
            KGMusic kGMusicK = kGPlaylistMusic.k();
            if (kGMusicK != null) {
                kGPlaylistMusic.W(kGMusicK.mixId);
                kGPlaylistMusic.P(kGMusicK.hashValue);
            }
            arrayList.add(kGPlaylistMusic);
        }
        e.c.a.g.a.g.k.b.a.q(arrayList);
    }

    public static boolean j(int i2, int i3) {
        return (i3 * 2) + 10 < i2;
    }

    public static void k(String str) {
        if (g0.a) {
            g0.c("yabinCloudSync", "CloudSyncManager-->log," + str);
        }
    }

    public static boolean l(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }

    public static void m(boolean z, String str) {
        e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.mymusic.fav.cloudsycing").putExtra("KEY_SYNCING", false).putExtra("KEY_FAV_CLOUD_SUCCESS", z).putExtra("KEY_FAV_CLOUD_ERRORCODE", str));
    }

    public static void n(boolean z) {
        e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.mymusic.fav.cloudsycing").putExtra("KEY_SYNCING", true).putExtra("KEY_SYNCING_REAL", z));
    }

    public static void o() {
        e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.mymusic.fav.list_id_done"));
    }

    public static void p(boolean z, String str) {
        synchronized (x.class) {
            k("notifySyncDone " + z + "\tmUpdateCloudListenersSize" + f917e.size());
            for (c cVar : f917e) {
                if (cVar != null) {
                    cVar.onSyncDone(z, str);
                }
            }
            if (z) {
                e.c.a.g.a.g.f.g.k().i(e.c.a.g.a.r.b.o());
            }
            f917e.clear();
        }
    }

    public static void q() {
        synchronized (x.class) {
            k("notifySyncStart " + f917e.size());
            for (c cVar : f917e) {
                if (cVar != null) {
                    cVar.onStartSync();
                }
            }
        }
    }

    public static ArrayList<KGMusic> r(List<KGPlaylistMusic> list, e eVar) {
        Long l;
        int size = list.size();
        ArrayList<KGMusic> arrayList = new ArrayList<>(size);
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list.get(i2).k());
        }
        Iterator<KGMusic> it = arrayList.iterator();
        e.c.a.g.a.g.k.a aVar = e.c.a.g.a.g.k.a.a;
        List<String> listK = aVar.k(arrayList, true);
        List<Long> listU = aVar.u(arrayList);
        if (eVar != null && eVar.a()) {
            z = true;
        }
        Log.d("mhs_watch_fav_update", "isFromSync = " + z + ", FavOptionHelper.forceUpdatCharge = " + e.c.a.g.a.g.f.c.a.j());
        Map<String, Long> mapI = aVar.i(listK, true);
        Map<Long, Long> mapH = aVar.h(listU, Boolean.valueOf(z));
        if (mapH != null && mapH.size() > 0) {
            while (it.hasNext()) {
                Long l2 = mapH.get(Long.valueOf(it.next().getMixId()));
                if (l2 != null && l2.longValue() > 0) {
                    it.remove();
                }
            }
        }
        if (mapI != null && mapI.size() > 0) {
            while (it.hasNext()) {
                KGMusic next = it.next();
                if (next.getMixId() <= 0 && (l = mapI.get(next.getHashValue())) != null && l.longValue() > 0) {
                    it.remove();
                }
            }
        }
        Log.e("mhs_watch_fav_update", "CloudMusicListFile, cloudMusicsNeedInsert = " + arrayList.size());
        return arrayList;
    }

    public static void s(String str, boolean z, boolean z2, List<KGPlaylistMusic> list) {
        if (z && !z2) {
            e.c.a.g.a.g.k.b.a.t(str);
            return;
        }
        if (z && z2) {
            e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
            int iF = bVar.f(str);
            bVar.v(str);
            u(str, list, iF);
            return;
        }
        int size = list.size();
        ArrayList<Long> arrayList = null;
        ArrayList<Long> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        for (int i2 = 0; i2 < size; i2++) {
            KGPlaylistMusic kGPlaylistMusic = list.get(i2);
            if (kGPlaylistMusic.p() <= 0 || kGPlaylistMusic.F()) {
                if (!TextUtils.isEmpty(kGPlaylistMusic.i())) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    arrayList3.add(kGPlaylistMusic.i());
                }
                if (kGPlaylistMusic.n() > 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(Long.valueOf(kGPlaylistMusic.n()));
                }
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                arrayList2.add(Long.valueOf(kGPlaylistMusic.p()));
            }
        }
        e.c.a.g.a.g.k.b bVar2 = e.c.a.g.a.g.k.b.a;
        int iY = bVar2.y(str, arrayList, arrayList2);
        if (iY != list.size()) {
            if (g0.a) {
                k("there should be a music duplication in the KGMusic table, " + iY + "/" + list.size() + " removed, you should pay attention to these musicIds: " + arrayList);
            }
            bVar2.u(str, arrayList2, arrayList3);
        }
    }

    public static int t(Context context, String str, q qVar) {
        ArrayList<e.c.a.g.a.g.k.c.a> arrayListH = qVar.h();
        e eVar = new e();
        eVar.b(true);
        int iD = d(context, arrayListH, str, KGMusic.MUSIC_SOURCE_CLOUD, true, true, false, true, eVar);
        k("save play list count : " + iD);
        if (!y.h()) {
            e.c.a.g.a.g.k.b.a.A(str, qVar.f());
        }
        return iD;
    }

    public static void u(String str, List<KGPlaylistMusic> list, int i2) {
        List<KGPlaylistMusic> listM = e.c.a.g.a.g.k.b.a.m(str);
        if (listM == null || listM.size() <= 0) {
            return;
        }
        Collections.sort(list, new b());
        e.c.a.g.a.g.k.a.a.A(str);
        int size = listM.size();
        int size2 = list.size();
        boolean z = listM.get(0).f() == i2;
        for (int i3 = 0; i3 < size; i3++) {
            int iF = (listM.get(i3).f() - i2) + 1 <= size2 ? z ? (listM.get(i3).f() - i2) + 1 : listM.get(i3).f() - i2 : size2;
            if (iF < 0) {
                iF = 0;
            }
            if (iF >= size2) {
                iF = size2;
            }
            list.add(iF, listM.get(i3));
        }
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            list.get(i4).M(i4);
        }
    }

    public static void v(c cVar, boolean z, boolean z2) {
        if (cVar != null) {
            synchronized (x.class) {
                f917e.add(cVar);
            }
        }
        if ((!e.c.c.o.m.z(e.c.c.o.f.a()) || e.c.a.g.a.r.b.o() <= 0) && !e.c.a.g.a.r.b.C()) {
            p(false, BaseResponse.Code.ERROR_NETWORK);
            return;
        }
        f();
        d dVar = c;
        if (dVar == null || dVar.a) {
            if (cVar != null) {
                cVar.onStartSync();
            }
        } else {
            Message messageObtainMessage = dVar.obtainMessage();
            messageObtainMessage.arg1 = !z ? 1 : 0;
            messageObtainMessage.arg2 = !z2 ? 1 : 0;
            messageObtainMessage.what = 1001;
            c.removeMessages(1001);
            c.sendMessage(messageObtainMessage);
        }
    }
}
