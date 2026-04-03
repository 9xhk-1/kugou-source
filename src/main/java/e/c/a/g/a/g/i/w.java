package e.c.a.g.a.g.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.apm.task.FavSongThreadAPM;
import com.kugou.common.network.ExceptionParse;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.p1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends e.c.a.g.a.g.i.a {
    public static final a l = new a(null);
    public static int m = 1;
    public static int n = 2;
    public static int o = 3;
    public static int p = 4;
    public static int q = 5;
    public static volatile boolean r = false;
    public static String s = "CloudSyncThread";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f912d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f913f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f914h = e.c.a.g.a.g.f.c.a.h();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f.d f915i = f.f.b(b.a);
    public final FavSongThreadAPM j = new FavSongThreadAPM();
    public Runnable k = c.a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }

        public int a() {
            return w.p;
        }

        public int b() {
            return w.q;
        }

        public int c() {
            return w.n;
        }

        public int d() {
            return w.m;
        }

        public int e() {
            return w.o;
        }

        public final String f() {
            return w.s;
        }

        public boolean g() {
            return w.r;
        }

        public void h(boolean z) {
            w.r = z;
        }
    }

    public static final class b extends f.z.d.k implements f.z.c.a<Context> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Context invoke() {
            return KGApplication.getContext();
        }
    }

    public static final class c implements Runnable {
        public static final c a = new c();

        @Override // java.lang.Runnable
        public final void run() {
            p1.h(KGApplication.getContext(), "同步歌曲数量较多，请耐心等待");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0397 A[Catch: all -> 0x03a5, TryCatch #1 {all -> 0x03a5, blocks: (B:14:0x0037, B:17:0x0067, B:19:0x006f, B:21:0x00c5, B:22:0x00ca, B:24:0x00d0, B:26:0x00d4, B:29:0x00de, B:32:0x00e7, B:34:0x00eb, B:36:0x0107, B:38:0x0115, B:43:0x011e, B:47:0x0128, B:49:0x017e, B:50:0x0183, B:56:0x01a9, B:59:0x01af, B:61:0x01b6, B:120:0x0367, B:122:0x0397, B:123:0x039c, B:62:0x01d7, B:64:0x01f5, B:66:0x01fd, B:69:0x0203, B:70:0x0208, B:72:0x0212, B:73:0x0215, B:75:0x0220, B:77:0x0226, B:79:0x022f, B:85:0x023f, B:87:0x0271, B:88:0x0276, B:90:0x027d, B:92:0x0289, B:93:0x0297, B:95:0x02bc, B:96:0x02c1, B:98:0x02cd, B:102:0x02f3, B:100:0x02d7, B:104:0x02f9, B:107:0x0307, B:108:0x030c, B:112:0x032b, B:111:0x0323, B:114:0x0331, B:117:0x0339, B:118:0x033e), top: B:144:0x0037 }] */
    @Override // e.c.a.g.a.g.i.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 986
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.i.w.a():void");
    }

    public final int l(p pVar) {
        ArrayList<o> arrayListF;
        String string = n().getString(R.string.kg_navigation_my_fav);
        f.z.d.j.d(string, "context.getString(R.string.kg_navigation_my_fav)");
        o oVar = null;
        Object obj = null;
        oVar = null;
        if (pVar != null && (arrayListF = pVar.f()) != null) {
            Iterator<T> it = arrayListF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                o oVar2 = (o) next;
                if (oVar2.d() == 0 && f.z.d.j.a(string, oVar2.j())) {
                    obj = next;
                    break;
                }
            }
            oVar = (o) obj;
        }
        if (oVar == null) {
            return 0;
        }
        return oVar.i();
    }

    public final p m(String str, t tVar) {
        m mVar = new m(e.c.a.g.a.r.b.o(), tVar.d(), 0, e.c.a.g.a.d.k.b.a() ? 0 : 2);
        mVar.g(str);
        p pVarA = mVar.a();
        if (g0.a) {
            String str2 = s;
            f.z.d.u uVar = f.z.d.u.a;
            Object[] objArr = new Object[1];
            objArr[0] = pVarA == null ? null : Integer.valueOf(pVarA.e());
            String str3 = String.format("getCloudMusicLMListData end data size:%s", Arrays.copyOf(objArr, 1));
            f.z.d.j.d(str3, "java.lang.String.format(format, *args)");
            g0.e(str2, str3);
        }
        return pVarA;
    }

    public final Context n() {
        return (Context) this.f915i.getValue();
    }

    public final void o(String str) {
        if (e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.g4, true)) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setSource("CloudSyncFavThread").setSvar1(str).setType(ExceptionParse.NET_URL_PROTOCOL_ERROR));
            e.c.a.g.a.d.d0.a.a(s, "CloudSyncFavThread = " + l + ", svar1 = " + str);
        }
    }

    public final int p(ArrayList<o> arrayList, ArrayList<e.c.a.g.a.d.f.c.a.j> arrayList2, boolean z, int i2, FavSongThreadAPM favSongThreadAPM) {
        Object next;
        o oVar;
        boolean z2;
        int i3;
        e.c.a.g.a.g.f.c cVar;
        Object next2;
        String strL = f.z.d.j.l("setCloudListInfo count:", Integer.valueOf(arrayList == null ? -1 : arrayList.size()));
        if (g0.a) {
            g0.b(s, strL);
        }
        e.c.a.g.a.g.f.c.t(e.c.a.g.a.g.f.c.a, strL, null, 2, null);
        String string = n().getString(R.string.kg_navigation_my_fav);
        f.z.d.j.d(string, "context.getString(R.string.kg_navigation_my_fav)");
        String string2 = n().getString(R.string.kg_my_cloud_playlist_default_list);
        f.z.d.j.d(string2, "context.getString(R.string.kg_my_cloud_playlist_default_list)");
        if (arrayList == null) {
            oVar = null;
        } else {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                o oVar2 = (o) next;
                if (oVar2.d() == 0 && f.z.d.j.a(oVar2.j(), string)) {
                    break;
                }
            }
            oVar = (o) next;
        }
        if (oVar == null) {
            if (arrayList == null) {
                oVar = null;
            } else {
                Iterator<T> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    o oVar3 = (o) next2;
                    if (oVar3.d() == 0 && f.z.d.j.a(oVar3.j(), string2)) {
                        break;
                    }
                }
                oVar = (o) next2;
            }
            if (oVar == null) {
                return 0;
            }
        } else {
            string2 = string;
        }
        e.c.a.g.a.d.f.c.a.j jVarA = oVar.a();
        e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
        f.z.d.j.d(jVarA, "playlist");
        bVar.o(jVarA);
        v.a(n(), arrayList2, jVarA);
        e.c.a.g.a.r.b.Z(jVarA.d());
        StringBuilder sb = new StringBuilder();
        sb.append("当前同步的歌单是 ");
        sb.append(string2);
        sb.append(", playlist.globalCollectionId: ");
        sb.append(jVarA.d());
        sb.append(", setCloudListInfo count:");
        sb.append(arrayList != null ? arrayList.size() : -1);
        sb.append(", playlist.numOfSongs = ");
        sb.append(jVarA.z());
        String string3 = sb.toString();
        if (g0.a) {
            g0.b(s, string3);
        }
        e.c.a.g.a.g.f.c cVar2 = e.c.a.g.a.g.f.c.a;
        e.c.a.g.a.g.f.c.t(cVar2, string3, null, 2, null);
        x.o();
        if (g0.a) {
            g0.b(s, f.z.d.j.l("fav playlist song count：", Integer.valueOf(jVarA.z())));
        }
        String strB = oVar.b();
        f.z.d.j.d(strB, "cloudPlaylist.globalCollectionId");
        int iB = bVar.b(strB);
        boolean z3 = iB != jVarA.z() && jVarA.z() > 0;
        boolean z4 = cVar2.a() && (jVarA.z() == 0 || iB == 0) && string.equals(string2);
        if (jVarA.z() == 0 && this.f914h) {
            e.c.a.g.a.f.m.b.m().X(false);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z3 || z || z4) {
            if (i2 == p && jVarA.z() > 1000) {
                this.f913f.postDelayed(this.k, NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME);
            }
            if (i2 == q) {
                if (jVarA.z() > cVar2.m()) {
                    Log.d(s, "歌曲数较多的检查");
                    p1.h(KGApplication.getContext(), "歌曲数量较多，正在同步中");
                } else {
                    Log.d(s, "synthread 开始同步...");
                    p1.f(KGApplication.getContext(), "正在同步...");
                }
            }
            z2 = z3;
            i3 = iB;
            cVar = cVar2;
            r(n(), jVarA.m(), jVarA.H(), jVarA.d(), jVarA.p(), jVarA.z(), true);
            this.f913f.removeCallbacks(this.k);
        } else {
            z2 = z3;
            i3 = iB;
            cVar = cVar2;
        }
        String strJ = e.c.a.g.a.r.b.j();
        f.z.d.j.d(strJ, "getMyFavPlaylistId()");
        int iB2 = bVar.b(strJ);
        String str = "本地插入成功" + iB2 + "条,\n, 线上预期歌单数量是多少 = " + jVarA.z() + "\n, 原先本地歌单的歌曲数量 = " + i3 + "\n, 实际插入多少条 = " + (iB2 - i3) + "\n, 是否需要同步 = " + z2 + "\n, 是否强制刷新 = " + z + "\n, 同步数据耗时 = " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms\n, favLastApiError = " + e.c.a.g.a.f.m.b.m().k();
        if (g0.a) {
            g0.b(s, str);
        }
        if (e.c.a.g.a.f.m.b.m().k() == 0) {
            e.c.a.g.a.g.f.h.a.e();
            e.c.a.g.a.g.f.i.a.a();
            favSongThreadAPM.netFinish();
            favSongThreadAPM.success(f.z.d.j.l("数据同步成功：data = ", str));
            if (this.f914h) {
                e.c.a.g.a.f.m.b.m().X(false);
            }
        } else {
            favSongThreadAPM.fail(67, f.z.d.j.l("未知错误，数据同步成功：data = ", str), 58);
        }
        e.c.a.g.a.g.f.c.t(cVar, str, null, 2, null);
        return iB2;
    }

    public final void q(int i2) {
        this.f912d = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int r(android.content.Context r17, int r18, int r19, java.lang.String r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.i.w.r(android.content.Context, int, int, java.lang.String, int, int, boolean):int");
    }
}
