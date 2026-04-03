package e.c.a.g.a.d.x;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.apm.task.MusicPlayAPM;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.player.kgplayer.PlayStream;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.uilib.widget.recyclerview.delegate.adapter.BaseHeaderAdapter;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.j1;
import e.c.a.g.a.s.k0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.y0;
import e.c.e.b.c.c;
import e.c.e.b.c.e.b;
import e.c.e.b.c.e.c;
import e.c.e.b.d.a;
import e.c.e.b.e.e;
import e.c.e.b.f.d;
import e.c.e.c.a.a;
import e.c.e.c.a.c;
import e.c.e.c.a.e.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class o extends e.c.e.c.a.f.f<KGMusicWrapper> {
    public static final String t = "e.c.a.g.a.d.x.o";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f567f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public KGMusicWrapper f570i;
    public CommNetSongUrlInfo j;
    public Pair<Integer, Integer> k;
    public boolean l;
    public MusicPlayAPM n;
    public boolean o;
    public int p;
    public k0<Field> q;
    public long r;
    public long s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f568g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f569h = null;
    public final Object m = new Object();

    public class a extends k0<Field> {

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.o$a$a, reason: collision with other inner class name */
        public class C0086a implements e.c.a.g.a.s.y1.b<Field, Boolean> {
            public C0086a(a aVar) {
            }

            @Override // e.c.a.g.a.s.y1.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean onCall(Field field) {
                return Boolean.valueOf(field.getType().isAssignableFrom(d.a.class));
            }
        }

        public a(o oVar) {
        }

        @Override // e.c.a.g.a.s.k0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Field a() {
            try {
                Field field = (Field) l0.b(e.c.e.b.f.f.class.getDeclaredFields(), new C0086a(this));
                if (field != null) {
                    field.setAccessible(true);
                }
                return field;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public class b implements e.c.e.b.c.b {

        public class a extends a.C0237a {

            /* JADX INFO: renamed from: e.c.a.g.a.d.x.o$b$a$a, reason: collision with other inner class name */
            public class C0087a extends c.a<KGMusicWrapper> {
                public C0087a() {
                }

                @Override // e.c.e.b.c.e.c.a, e.c.e.b.c.e.c
                public void afterPause(e.c.e.b.c.e.a<c.C0217c, Void> aVar) {
                    super.afterPause(aVar);
                    o.this.V();
                    e.c.a.g.a.d.d0.a.a("Play", "afterPause");
                }

                @Override // e.c.e.b.c.e.c.a, e.c.e.b.c.e.c
                public void afterPlay(e.c.e.b.c.e.a<c.d, Void> aVar) {
                    o.this.p = 2;
                    o.this.i0();
                    if (!e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false) && u0.o(KGApplication.getContext())) {
                        o.this.g0();
                        e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.action.traffic.protection"));
                    }
                    if (o.this.l) {
                        o.this.l = false;
                        o.this.g0();
                        e.c.a.g.a.d.d0.a.a("Play", "abort play");
                    }
                    e.c.a.g.a.d.d0.a.a("Play", "afterPlay");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // e.c.e.b.c.e.c.a, e.c.e.b.c.e.c
                public int beforeLoad(e.c.e.b.c.e.a<c.b<KGMusicWrapper>, Void> aVar) {
                    String str;
                    e.c.a.g.a.d.d0.a.a("Play", "beforeLoad");
                    o.this.m0();
                    o.this.j0();
                    KGMusicWrapper kGMusicWrapper = aVar.a.a;
                    int size = e.c.a.g.a.d.x.b.c().size();
                    KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
                    if (size > 1 && kGMusicWrapper != null && !kGMusicWrapper.isForceNext() && currentSong != null && kGMusicWrapper.getHashValue() != null && kGMusicWrapper.getHashValue().equals(currentSong.getHashValue())) {
                        if (e.c.a.g.a.d.x.b.b().isPrepared()) {
                            o.this.h0();
                        } else if (o.this.f570i != null && o.this.f570i.getHashValue().equals(currentSong.getHashValue())) {
                            if (!u0.n(KGApplication.getContext(), false)) {
                                p1.k(KGApplication.getContext(), "抱歉，歌曲加载失败，请检查网络", true);
                                u0.A(103, "WatchPlayerManager-beforeLoad", "errorType-3, curErrorSong = " + o.this.f570i);
                                e.c.a.g.a.d.d0.a.a("Play", "beforeLoad3. no net");
                            } else if (o.this.j != null) {
                                if (o.this.k != null) {
                                    str = e.c.a.g.a.d.i.b.l(((Integer) o.this.k.first).intValue(), ((Integer) o.this.k.second).intValue()) + ", detail = " + o.this.k.first + "_" + o.this.k.second;
                                } else {
                                    str = "";
                                }
                                p1.k(KGApplication.getContext(), "抱歉，" + k.c(o.this.j, "歌曲加载失败"), true);
                                u0.A(101, "WatchPlayerManager-beforeLoad", "errorType-1:" + o.this.j.toString() + ", curErrorSong = " + o.this.f570i + str);
                                StringBuilder sb = new StringBuilder();
                                sb.append("beforeLoad: ");
                                sb.append(str);
                                e.c.a.g.a.d.d0.a.a("Play", sb.toString());
                            } else {
                                String strL = e.c.a.g.a.d.i.b.l(((Integer) o.this.k.first).intValue(), ((Integer) o.this.k.second).intValue());
                                p1.k(KGApplication.getContext(), strL, true);
                                u0.A(102, "WatchPlayerManager-beforeLoad", "errorType-2, errMsg = " + strL + ", detail = " + o.this.k.first + "_" + o.this.k.second + ", curErrorSong = " + o.this.f570i);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("beforeLoad2: ");
                                sb2.append(strL);
                                e.c.a.g.a.d.d0.a.a("Play", sb2.toString());
                            }
                        }
                        if (j1.a("playAbort")) {
                            if (o.this.getIQueue().getPlayMode() != 1) {
                                return 1;
                            }
                            o.this.n0();
                            return super.beforeLoad(aVar);
                        }
                    }
                    o.this.n0();
                    return super.beforeLoad(aVar);
                }

                @Override // e.c.e.b.c.e.c.a, e.c.e.b.c.e.c
                public int beforePlay(e.c.e.b.c.e.a<c.d, Void> aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "beforePlay");
                    o.this.W();
                    return super.beforePlay(aVar);
                }
            }

            /* JADX INFO: renamed from: e.c.a.g.a.d.x.o$b$a$b, reason: collision with other inner class name */
            public class C0088b extends a.C0239a {
                public C0088b() {
                }

                @Override // e.c.e.c.a.e.a
                public void afterSetPlayMode(e.c.e.b.c.e.a<a.b, Void> aVar) {
                    e.c.a.g.a.d.x.h.y().B("com.kugou.young.watch.playmodechanged");
                    e.b bVarQueue = o.this.c().queue();
                    if (bVarQueue != null) {
                        e.c.e.b.f.c mode = bVarQueue.getMode();
                        e.c.e.b.f.d<?> queueList = bVarQueue.getQueueList();
                        if (mode == null || queueList == null) {
                            return;
                        }
                        mode.updateQueueList(queueList);
                    }
                }

                @Override // e.c.e.c.a.e.a.C0239a, e.c.e.c.a.e.a
                public int beforeSetPlayMode(e.c.e.b.c.e.a<a.b, Void> aVar) {
                    e.c.e.b.f.c mode = o.this.c().queue().getMode();
                    if (mode instanceof e.c.e.b.f.f) {
                        o.this.o0(mode);
                    }
                    return super.beforeSetPlayMode(aVar);
                }
            }

            public a() {
            }

            @Override // e.c.e.c.a.a.C0237a, e.c.e.c.a.a
            public e.c.e.c.a.e.a getMainPlayerHooker() {
                return new C0088b();
            }

            @Override // e.c.e.b.c.b.a.C0215a, e.c.e.b.c.b.a, e.c.e.b.c.c, e.c.e.c.a.a
            public e.c.e.b.c.e.c<KGMusicWrapper> getSongActionHooker() {
                return new C0087a();
            }
        }

        public b() {
        }

        @Override // e.c.e.b.c.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.c.e.c.a.a getProvider() {
            return new a();
        }
    }

    public class c implements e.c.e.b.c.b {

        public class a extends c.a {

            /* JADX INFO: renamed from: e.c.a.g.a.d.x.o$c$a$a, reason: collision with other inner class name */
            public class C0089a extends b.C0216b<KGMusicWrapper> {
                public C0089a() {
                }

                @Override // e.c.e.b.c.e.b
                public void afterClear(e.c.e.b.c.e.a aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "afterClear");
                    e.c.a.g.a.d.x.g.h().j(o.this.getIQueue());
                }

                @Override // e.c.e.b.c.e.b
                public void afterInsert(e.c.e.b.c.e.a aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "afterInsert");
                    e.c.a.g.a.d.x.g.h().j(o.this.getIQueue());
                }

                @Override // e.c.e.b.c.e.b
                public void afterNext(e.c.e.b.c.e.a aVar) {
                    if (g0.a) {
                        g0.b(o.t, "afterNext: ");
                    }
                    o.this.p = 2;
                    e.c.a.g.a.d.x.g.h().k(o.this.getIQueue().getCurrentIndex());
                    e.c.a.g.a.d.d0.a.a("Play", "afterNext");
                }

                @Override // e.c.e.b.c.e.b
                public void afterOnCompleteNext(e.c.e.b.c.e.a aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "afterOnCompleteNext");
                    e.c.a.g.a.d.x.g.h().k(o.this.getIQueue().getCurrentIndex());
                }

                @Override // e.c.e.b.c.e.b
                public void afterPrevious(e.c.e.b.c.e.a aVar) {
                    if (g0.a) {
                        g0.b(o.t, "afterPrevious: ");
                    }
                    o.this.p = 1;
                    e.c.a.g.a.d.x.g.h().k(o.this.getIQueue().getCurrentIndex());
                    e.c.a.g.a.d.d0.a.a("Play", "afterPrevious");
                }

                @Override // e.c.e.b.c.e.b
                public void afterRemove(e.c.e.b.c.e.a aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "afterRemove");
                    e.c.a.g.a.d.x.g.h().j(o.this.getIQueue());
                }

                @Override // e.c.e.b.c.e.b
                public void afterSetIndex(e.c.e.b.c.e.a aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "afterSetIndex");
                    e.c.a.g.a.d.x.g.h().k(o.this.getIQueue().getCurrentIndex());
                }

                @Override // e.c.e.b.c.e.b
                public void afterSetQueue(e.c.e.b.c.e.a aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "afterSetQueue");
                    e.c.a.g.a.d.x.g.h().j(o.this.getIQueue());
                    e.c.a.g.a.d.x.h.y().B("com.kugou.young.watch.queuechanged");
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // e.c.e.b.c.e.b.C0216b, e.c.e.b.c.e.b
                public int beforeInsert(e.c.e.b.c.e.a<b.c, Void> aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "beforeInsert");
                    List<T> list = aVar.a.a;
                    ArrayList arrayList = null;
                    for (T t : list) {
                        if (e.c.a.g.a.d.x.g.h().f().containsKey(t.getHashValue())) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(t);
                        }
                    }
                    if (arrayList != null) {
                        list.removeAll(arrayList);
                    }
                    return super.beforeInsert(aVar);
                }

                @Override // e.c.e.b.c.e.b.C0216b, e.c.e.b.c.e.b
                public int beforeNext(e.c.e.b.c.e.a<b.d, Void> aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "beforeNext");
                    if (o.this.getIQueue().size() <= 0) {
                        return 1;
                    }
                    return super.beforeNext(aVar);
                }

                @Override // e.c.e.b.c.e.b.C0216b, e.c.e.b.c.e.b
                public int beforeOnCompleteNext(e.c.e.b.c.e.a<b.e, Void> aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "beforeOnCompleteNext");
                    if (l1.V()) {
                        c.InterfaceC0238c<KGMusicWrapper> interfaceC0238cC = e.c.a.g.a.d.x.b.c();
                        if (interfaceC0238cC.getPlayMode() == 0) {
                            if (interfaceC0238cC.getCurrentIndex() == interfaceC0238cC.size() - 1) {
                                o.this.l = true;
                            }
                        }
                    }
                    KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
                    if (currentSong != null) {
                        currentSong.setReportState("完整播放");
                    }
                    return super.beforeOnCompleteNext(aVar);
                }

                @Override // e.c.e.b.c.e.b.C0216b, e.c.e.b.c.e.b
                public int beforePrevious(e.c.e.b.c.e.a<b.f, Void> aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "beforePrevious");
                    if (o.this.getIQueue().size() <= 0) {
                        return 1;
                    }
                    return super.beforePrevious(aVar);
                }

                @Override // e.c.e.b.c.e.b.C0216b, e.c.e.b.c.e.b
                public int beforeSetQueue(e.c.e.b.c.e.a<b.i, Void> aVar) {
                    e.c.a.g.a.d.d0.a.a("Play", "beforeSetQueue");
                    if (l0.g(aVar.a.a)) {
                        return 1;
                    }
                    return super.beforeSetQueue(aVar);
                }
            }

            public a() {
            }

            @Override // e.c.e.b.c.c.a, e.c.e.b.c.c
            public e.c.e.b.c.e.b<KGMusicWrapper> getQueueActionHooker() {
                return new C0089a();
            }
        }

        public c() {
        }

        @Override // e.c.e.b.c.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.c.e.b.c.c getProvider() {
            return new a();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ KGMusicWrapper f574d;

        public e(int i2, int i3, KGMusicWrapper kGMusicWrapper) {
            this.a = i2;
            this.b = i3;
            this.f574d = kGMusicWrapper;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.a.g.a.d.d0.a.a("Play", "error autoNext: " + this.a + ", " + this.b);
            o.this.d0(e.c.a.g.a.d.i.b.l(this.a, this.b), this.f574d, this.a, this.b);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ KGMusicWrapper a;
        public final /* synthetic */ long b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f576d;

        public f(KGMusicWrapper kGMusicWrapper, long j, long j2) {
            this.a = kGMusicWrapper;
            this.b = j;
            this.f576d = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.j = null;
            KGMusicWrapper kGMusicWrapper = this.a;
            if (kGMusicWrapper == null || kGMusicWrapper.getMixId() <= 0 || TextUtils.isEmpty(this.a.getHashValueV2())) {
                if (g0.a) {
                    String str = o.t;
                    StringBuilder sb = new StringBuilder();
                    sb.append("歌曲信息错误:");
                    KGMusicWrapper kGMusicWrapper2 = this.a;
                    sb.append(kGMusicWrapper2 != null ? kGMusicWrapper2.getDisplayName() : "null");
                    g0.b(str, sb.toString());
                }
                if (o.this.f568g > 2) {
                    return;
                }
                o.p(o.this);
                o.this.c0("歌曲信息错误，已自动切换到下一曲", this.a);
                o.this.l0(this.a, 0L, "2");
                e.c.a.g.a.d.d0.a.a("Play", "error autoNext, error song msg");
                o.this.Z(4, AckManager.SERVICE_ID_ACK_DNS, 0);
                return;
            }
            if (!u0.n(KGApplication.getContext(), false) && e.c.a.g.a.f.j.c.d.c(this.a) && !e.c.a.g.a.r.b.O() && !e.c.a.g.a.d.s.i.a(this.a)) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("7").setFo("/播放器/离线").setSvar1(this.a.getAlbumID() + ":" + this.a.getMixId() + ":" + this.a.getHashValue()).setSvar2(this.a.getDisplayName()));
                Context context = KGApplication.getContext();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("handleNext,ong=");
                sb2.append(this.a);
                p1.j(context, "暂无法播放VIP歌曲，请检查是否网络无连接", sb2.toString(), true);
                if (o.this.f568g > 2) {
                    e.c.a.g.a.d.d0.a.a("Play", "无网，vip歌曲多次播放失败暂停");
                    return;
                }
                o.p(o.this);
                if (o.this.p != 2 && o.this.p == 1) {
                    o.this.getIQueue().previous();
                } else {
                    o.this.getIQueue().next();
                }
                e.c.a.g.a.d.d0.a.a("Play", "无网，vip歌曲切歌");
                return;
            }
            e.c.a.g.a.d.r.o.b.c(this.a);
            if (e.c.a.g.a.g.o.b.l() && e.c.a.g.a.g.o.b.m(this.a)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (e.c.a.g.a.g.o.b.f(this.a.getKgmusic())) {
                    if (o.this.f569h != null && this.a.getMixId() == o.this.f569h.longValue()) {
                        o.this.c().audio().setDataSource("", y0.d(this.a, this.b), y0.b(this.a, this.f576d), new AudioTypeInfo());
                        e.c.a.g.a.d.d0.a.a("Play", "filter song: " + o.this.f569h);
                        return;
                    }
                    if (o.this.f569h == null) {
                        o.this.f569h = Long.valueOf(this.a.getMixId());
                    }
                    o.this.c0(e.c.a.g.a.g.o.b.d() + "，已自动切换到下一曲", this.a);
                    o.this.l0(this.a, System.currentTimeMillis() - jCurrentTimeMillis, "");
                    e.c.a.g.a.d.d0.a.a("Play", "error autoNext, error history song: " + o.this.f569h);
                    o.this.Z(4, 10002, 0);
                    return;
                }
            }
            o.this.f569h = null;
            if (g0.a) {
                Log.e("试听片段兼容", "song.isNeedListenPart() = " + this.a.isNeedListenPart() + ", 歌曲名称 = " + this.a.getDisplayName() + ", 当前播放队列大小 = " + e.c.a.g.a.d.x.f.k().size());
            }
            if (this.a.isNeedListenPart()) {
                this.a.setIsListenPart(true);
            }
            e.c.a.g.a.d.d0.a.a("Play", "loadDataSource: " + this.a.getDisplayName() + ", " + this.a.getMixId() + ", vip: " + e.c.a.g.a.r.b.O());
            long jD = y0.d(this.a, this.b);
            long jB = y0.b(this.a, this.f576d);
            if (!o.this.c().audio().isCore()) {
                String strA = e.c.a.g.a.d.i.b.a(this.a.getHashValue(), this.a.getSongQuality(), this.a.getMixId());
                if (e.c.a.g.a.d.x.d.b(strA)) {
                    strA = o.this.b0(this.a);
                }
                String str2 = strA;
                if (!e.c.a.g.a.d.x.d.b(str2)) {
                    o.this.c().audio().setDataSource(str2, jD, jB, new AudioTypeInfo());
                    return;
                }
                o.this.k0(new e.c.e.c.a.d.a.b(2));
                e.c.a.g.a.d.d0.a.a("Play", "error invalid path: " + str2 + ", songid: " + this.a.getMixId());
                o.this.Z(4, 10003, 0);
                return;
            }
            l lVarM = e.c.a.g.a.d.x.c.g().m(this.a, o.this.f568g > 0);
            long j = lVarM.a;
            CommNetSongUrlInfo commNetSongUrlInfo = lVarM.b;
            if (j != 0) {
                PlayStream playStream = new PlayStream();
                playStream.setStreamPtr(j);
                o.this.c().audio().setDataSource(playStream, jD, jB, new AudioTypeInfo());
                return;
            }
            o.this.j = commNetSongUrlInfo;
            o.p(o.this);
            if (k.a(commNetSongUrlInfo)) {
                if (o.this.f568g >= 2) {
                    o.this.c().audio().setDataSource("", jD, jB, new AudioTypeInfo());
                    e.c.a.g.a.d.d0.a.a("Play", "no streamPtr, free error");
                    return;
                }
                e.c.a.g.a.d.d0.a.a("Play", "no streamPtr, free");
            } else {
                if (o.this.f568g > o.this.getIQueue().size()) {
                    o.this.c().audio().setDataSource("", jD, jB, new AudioTypeInfo());
                    e.c.a.g.a.d.d0.a.a("Play", "no streamPtr, not free error");
                    return;
                }
                e.c.a.g.a.d.d0.a.a("Play", "no streamPtr, not free");
            }
            String str3 = "歌曲加载失败";
            if (k.a(commNetSongUrlInfo)) {
                e.c.a.g.a.d.r.p.a.h hVar = new e.c.a.g.a.d.r.p.a.h();
                hVar.b = "audio";
                e.c.a.g.a.d.r.p.a.a aVarF = new e.c.a.g.a.d.r.p.b.e().f(hVar, "play", 0, Collections.singletonList(e.c.a.g.a.d.r.g.J(this.a)), 0);
                e.c.a.g.a.d.r.p.a.c cVar = (e.c.a.g.a.d.r.p.a.c) l0.c(aVarF != null ? aVarF.d() : null, 0);
                if (cVar != null) {
                    if (g0.a) {
                        e.c.a.g.a.d.r.i.g(o.t, cVar);
                    }
                    if (e.c.a.g.a.d.r.g.e(cVar) && !e.c.a.g.a.r.b.O()) {
                        str3 = "歌曲为VIP专享";
                    }
                    if (e.c.a.g.a.d.r.g.j(cVar) && !e.c.a.g.a.d.r.g.l(cVar)) {
                        str3 = "付费专辑歌曲，付费后可畅享";
                    }
                    if (e.c.a.g.a.d.r.g.n(cVar) || e.c.a.g.a.d.r.g.y(cVar.f())) {
                        str3 = "该歌曲暂无版权";
                    }
                }
            }
            String strC = k.c(commNetSongUrlInfo, str3);
            o.this.c0(strC + "，已自动切换到下一曲", this.a);
            e.c.a.g.a.d.d0.a.a("Play", "error autoNext, no streamPtr: " + strC);
            Log.e("mhs_watch", "试听片段兼容 err = " + strC + ", song = " + this.a);
            if (commNetSongUrlInfo != null) {
                o.this.Z(4, commNetSongUrlInfo.getErrorType(), 0);
            } else {
                o.this.Z(4, 10004, 0);
            }
        }
    }

    public class g implements Action1<Pair<KGMusicWrapper, Long>> {
        public g() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Pair<KGMusicWrapper, Long> pair) {
            KGMusicWrapper kGMusicWrapper = pair.first;
            if (kGMusicWrapper != null) {
                String strB = b(kGMusicWrapper);
                Long l = pair.second;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("displayname", pair.first.getDisplayName());
                    jSONObject.put("hashoffset", pair.first.getHashOffset());
                    jSONObject.put("islistenPart", pair.first.isListenPart());
                    jSONObject.put("kgfile", pair.first.getInnerKGfile(false));
                    jSONObject.put("transParam", pair.first.getMusicTransParamEnenty());
                    c.InterfaceC0238c<KGMusicWrapper> iQueue = o.this.getIQueue();
                    if (iQueue != null && iQueue.getQueue() != null) {
                        jSONObject.put("queueSize", iQueue.size());
                        jSONObject.put("queuePreIndex", iQueue.getPreviousIndex());
                        jSONObject.put("queueCurIndex", iQueue.getCurrentIndex());
                        jSONObject.put("queueNextIndex", iQueue.getNextIndex());
                    }
                    jSONObject.put("volume", String.format("%.2f", Float.valueOf(((AudioManager) KGApplication.getContext().getSystemService("audio")) != null ? (r3.getStreamVolume(3) * 1.0f) / r3.getStreamMaxVolume(3) : 1.0f)));
                    jSONObject.put("isBluetoothConnected", e.c.a.g.a.s.m.j());
                    if (e.c.a.g.a.s.m.j()) {
                        jSONObject.put("connectedBluetoothName", e.c.a.g.a.f.n.a.b().e(10205, ""));
                        jSONObject.put("connectedBluetoothMac", e.c.a.g.a.f.n.a.b().e(10206, ""));
                    }
                    String strI = e.c.a.g.a.d.x.c.g().i();
                    String strK = TextUtils.isEmpty(strI) ? "" : e.c.a.g.a.d.x.c.k(strI);
                    if (!TextUtils.isEmpty(strK)) {
                        jSONObject.putOpt("error", strK);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                e.c.a.g.a.e.b.b(new YoungBITask(4, "play").setStrList(jSONObject.toString()).setSource(e.c.a.g.a.f.j.a.f.a.b(pair.first)).setState(pair.first.getReportState()).setMixsongid(String.valueOf(pair.first.getMixId())).setDuration(String.valueOf(l)).setSty("完整播放".equals(pair.first.getReportState()) ? "自动" : "手动").setType("1").setIvar1(strB));
            }
        }

        public final String b(KGMusicWrapper kGMusicWrapper) {
            return e.c.a.g.a.d.x.d.c(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId(), true) ? "1" : e.c.a.g.a.d.x.d.c(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId(), false) ? "2" : e.c.a.g.a.d.i.b.c(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId()) ? "4" : "3";
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.n(KGApplication.getContext(), false)) {
                p1.k(KGApplication.getContext(), "抱歉，歌曲加载失败,请您稍后再试", true);
            } else {
                o.this.Y();
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<KGMusicWrapper> queue = o.this.getIQueue().getQueue();
            int currentIndex = o.this.getIQueue().getCurrentIndex();
            while (currentIndex < queue.size() && currentIndex >= 0) {
                KGMusicWrapper kGMusicWrapper = queue.get(currentIndex);
                if (e.c.a.g.a.d.x.d.c(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId(), kGMusicWrapper.isNeedListenPart())) {
                    p1.k(KGApplication.getContext(), "该歌曲未缓存，已自动切换到下一曲", true);
                    e.c.a.g.a.d.x.f.z(currentIndex, true);
                    return;
                } else {
                    if (e.c.a.g.a.d.i.b.c(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId())) {
                        p1.k(KGApplication.getContext(), "该歌曲未缓存，已自动切换到下一曲", true);
                        e.c.a.g.a.d.x.f.z(currentIndex, true);
                        return;
                    }
                    currentIndex = (o.this.p != 2 && o.this.p == 1) ? currentIndex - 1 : currentIndex + 1;
                }
            }
            e.c.a.g.a.d.d0.a.a("Play", "autoNextPlayWhenNoNetwork, no song to play");
            o.this.f0();
            p1.k(KGApplication.getContext(), "当前列表没有可播放的歌曲, 暂停播放, 请检查网络", true);
            u0.A(105, "autoNextPlayWhenNoNetwork", "pauseOnError 当前列表没有可播放的歌曲, 暂停播放, 请检查网络");
        }
    }

    public o() {
        this.o = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.Q0, 1) == 1;
        this.p = 2;
        this.q = new a(this);
        this.f567f = new Handler(Looper.getMainLooper());
        c().extendManager().d(new b());
        c().extendManager().d(new c());
        c().audio().addListener(new d());
    }

    public static /* synthetic */ int p(o oVar) {
        int i2 = oVar.f568g;
        oVar.f568g = i2 + 1;
        return i2;
    }

    public final void V() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.s;
        this.r += j;
        this.s = jElapsedRealtime;
        if (g0.a) {
            g0.b(t, "recordSongPause: timeLen=" + j);
        }
    }

    public final void W() {
        synchronized (this.m) {
            MusicPlayAPM musicPlayAPM = this.n;
            if (musicPlayAPM != null) {
                musicPlayAPM.netFinish();
                this.n.success();
                this.n = null;
            }
        }
    }

    public final void X(KGMusicWrapper kGMusicWrapper, int i2, int i3) {
        if (e.c.a.g.a.f.m.c.a.e("play_auto_start", false)) {
            this.f567f.post(new e(i2, i3, kGMusicWrapper));
        }
    }

    public final void Y() {
        j0.b().a(new i());
    }

    public final void Z(int i2, int i3, int i4) {
        MusicPlayAPM musicPlayAPM = this.n;
        if (musicPlayAPM != null) {
            musicPlayAPM.fail(i2, i3, i4);
        }
    }

    public final void a0(int i2, int i3, int i4, int i5) {
        MusicPlayAPM musicPlayAPM = this.n;
        if (musicPlayAPM != null) {
            musicPlayAPM.fail(i2, i3, i4, i5);
        }
    }

    public final String b0(KGMusicWrapper kGMusicWrapper) {
        CommNetSongUrlInfo commNetSongUrlInfoA = m.a(kGMusicWrapper);
        if (commNetSongUrlInfoA == null || commNetSongUrlInfoA.isError()) {
            return null;
        }
        return commNetSongUrlInfoA.getUrl();
    }

    public final void c0(String str, KGMusicWrapper kGMusicWrapper) {
        d0(str, kGMusicWrapper, 0, 0);
    }

    public final void d0(String str, KGMusicWrapper kGMusicWrapper, int i2, int i3) {
        if (!u0.n(KGApplication.getContext(), false)) {
            Y();
            return;
        }
        CommNetSongUrlInfo commNetSongUrlInfo = this.j;
        String string = commNetSongUrlInfo != null ? commNetSongUrlInfo.toString() : "";
        if ((i2 == 4 && i3 == -9100 && this.o) ? false : true) {
            p1.j(KGApplication.getContext(), str, "handleNext,ong=" + kGMusicWrapper + string, true);
        }
        int i4 = this.p;
        if (i4 == 2) {
            getIQueue().next();
        } else if (i4 == 1) {
            getIQueue().previous();
        } else {
            getIQueue().next();
        }
    }

    @Override // e.c.e.b.e.d.c
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void loadDataSource(KGMusicWrapper kGMusicWrapper, boolean z, long j, long j2) {
        if (g0.a) {
            g0.b(t, "onLoadDataSource: " + kGMusicWrapper);
        }
        e.c.a.g.a.d.x.e.b();
        e.c.e.b.b.b.g().execute(new f(kGMusicWrapper, j, j2));
    }

    public final void f0() {
        g0();
        Intent intent = new Intent("com.kugou.young.watch.playstatechanged");
        intent.putExtra("arg_is_playing", false);
        e.c.a.g.a.d.u.d.b().showNotification(KGApplication.getContext());
        e.c.a.g.a.f.d.a.d(intent);
        e.c.a.g.a.d.d0.a.a("Play", "pauseOnError");
    }

    public final void g0() {
        getIControl().pause();
    }

    public final void h0() {
        getIControl().play();
    }

    public final void i0() {
        this.s = SystemClock.elapsedRealtime();
        if (g0.a) {
            g0.b(t, "recordSongPlay: ");
        }
    }

    public final void j0() {
        this.r = 0L;
        this.s = SystemClock.elapsedRealtime();
    }

    public final void k0(e.c.e.c.a.d.a.a aVar) {
        this.f567f.post(new h());
        e.c.e.b.b.b.f().e(t, "reportError: " + aVar);
    }

    public final void l0(KGMusicWrapper kGMusicWrapper, long j, String str) {
        e.c.a.g.a.e.b.b(new YoungBITask(22020016, "statistics").setSource(e.c.a.g.a.f.j.c.d.b(kGMusicWrapper)).setMixsongid(kGMusicWrapper != null ? String.valueOf(kGMusicWrapper.getMixId()) : "0").setDuration(String.valueOf(j)).setType(str));
    }

    public final void m0() {
        V();
        Observable.just(new Pair(e.c.a.g.a.d.x.b.b().getCurrentSong(), Long.valueOf(this.r))).throttleFirst(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new g(), i1.b);
    }

    public final void n0() {
        synchronized (this.m) {
            MusicPlayAPM musicPlayAPM = this.n;
            if (musicPlayAPM != null) {
                musicPlayAPM.release();
            }
            MusicPlayAPM musicPlayAPM2 = new MusicPlayAPM();
            this.n = musicPlayAPM2;
            musicPlayAPM2.start();
        }
    }

    public final void o0(e.c.e.b.f.c cVar) {
        Field fieldB = this.q.b();
        if (fieldB != null) {
            try {
                c().queue().getQueueList().unregisterObserver((d.a) fieldB.get(cVar));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class d extends a.C0221a {

        public class a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ KGMusicWrapper b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f571d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f572f;

            public a(String str, KGMusicWrapper kGMusicWrapper, int i2, int i3) {
                this.a = str;
                this.b = kGMusicWrapper;
                this.f571d = i2;
                this.f572f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g0.a) {
                    g0.b(o.t, "retry:uniqueKey:" + this.a);
                }
                e.c.a.g.a.d.x.c.g().n(this.a, true);
                if (this.b.isNeedListenPart()) {
                    this.b.setIsListenPart(true);
                }
                long jD = y0.d(this.b, 0L);
                long jB = y0.b(this.b, 0L);
                long j = e.c.a.g.a.d.x.c.g().m(this.b, true).a;
                if (j == 0) {
                    o.this.X(this.b, this.f571d, this.f572f);
                    e.c.a.g.a.d.d0.a.a("Play", "error to retry fail");
                    return;
                }
                PlayStream playStream = new PlayStream();
                playStream.setStreamPtr(j);
                o.this.c().audio().setDataSource(playStream, jD, jB, new AudioTypeInfo());
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setMixsongid(String.valueOf(this.b.getMixId())).setFo("/播放器/重试").setType("7").setSvar1("重试成功"));
                e.c.a.g.a.d.d0.a.a("Play", "error to retry suc");
            }
        }

        public d() {
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onBufferEnd() {
            super.onBufferEnd();
            e.c.a.g.a.d.d0.a.a("Play", "onBufferEnd");
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onBufferStart() {
            super.onBufferStart();
            e.c.a.g.a.d.d0.a.a("Play", "onBufferStart");
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onBufferingUpdate(int i2) {
            super.onBufferingUpdate(i2);
            e.c.a.g.a.d.d0.a.a("Play", "onBufferingUpdate: " + i2);
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onCompletion() {
            super.onCompletion();
            e.c.a.g.a.d.d0.a.a("Play", "onCompletion");
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onError(int i2, int i3) {
            int errorType;
            if (g0.a) {
                g0.b(o.t, "onError: what=" + i2 + "   extra=" + i3);
            }
            String str = "onError: what=" + i2 + "   extra=" + i3;
            e.c.a.g.a.d.d0.a.a("Play", str);
            if (!u0.n(KGApplication.getContext(), false)) {
                o.this.Z(1, i2, i3);
                e.c.a.g.a.d.d0.a.a("Play", str + ", no net");
            } else if (o.this.j == null) {
                o.this.Z(3, i2, i3);
                e.c.a.g.a.d.d0.a.a("Play", str + ", data error");
            } else if (k.a(o.this.j)) {
                o oVar = o.this;
                oVar.a0(2, oVar.j.getErrorType(), i2, i3);
                e.c.a.g.a.d.d0.a.a("Play", str + ", free: " + o.this.j.getErrorType() + ", " + o.this.j.getErrorMessage());
            } else {
                e.c.a.g.a.d.d0.a.a("Play", str + ", not free: " + o.this.j.getErrorType() + ", " + o.this.j.getErrorMessage());
                o oVar2 = o.this;
                oVar2.a0(2, oVar2.j.getErrorType(), i2, i3);
            }
            o.p(o.this);
            KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
            if (currentSong != null) {
                currentSong.setReportState("播放错误");
            }
            RingBiReportHelper.INSTANCE.reportHead2("/播放器/异常上报", "onError: what=" + i2 + ", extra=" + i3 + ", curSongUrlInfo = " + o.this.j + ",isGlobalNetAvailable = " + u0.n(KGApplication.getContext(), false));
            if (o.this.f568g < 2) {
                if (e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.r4, true) && currentSong != null) {
                    if (g0.a) {
                        g0.b(o.t, "retry:errorCount: " + o.this.f568g + "   currentSong=" + currentSong);
                    }
                    String strE = e.c.a.g.a.d.x.d.e(currentSong.getHashValueV2(), currentSong.getSongQuality(), currentSong.getMixId(), currentSong.isNeedListenPart());
                    if (e.c.a.g.a.d.x.c.g().j(strE) && u0.n(KGApplication.getContext(), false)) {
                        e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setState(currentSong.getReportState()).setMixsongid(String.valueOf(currentSong.getMixId())).setFo("/播放器/重试").setType("7").setSvar1("开始重试"));
                        if (g0.a) {
                            g0.b(o.t, "retry:isGlobalNetAvailable");
                        }
                        j0.b().a(new a(strE, currentSong, i2, i3));
                        return;
                    }
                }
                o.this.X(currentSong, i2, i3);
                e.c.a.g.a.d.d0.a.a("Play", "error to next");
                return;
            }
            o.this.f568g = 0;
            o.this.f570i = currentSong;
            o.this.k = new Pair(Integer.valueOf(i2), Integer.valueOf(i3));
            CommNetSongUrlInfo commNetSongUrlInfo = o.this.j;
            if (commNetSongUrlInfo != null) {
                p1.k(KGApplication.getContext(), "抱歉，" + k.c(commNetSongUrlInfo, "歌曲加载失败"), true);
                errorType = commNetSongUrlInfo.getErrorType();
            } else if (o.this.f569h != null) {
                p1.j(KGApplication.getContext(), "抱歉，该歌曲暂无版权，已暂停播放", "onError, currentSong:" + currentSong, true);
                errorType = BaseHeaderAdapter.ITEM_TYPE_FOOTERAREA;
            } else {
                p1.k(KGApplication.getContext(), "抱歉，歌曲加载失败，已暂停播放", true);
                errorType = -202;
            }
            e.c.a.g.a.d.d0.a.a("Play", "error to pause");
            o.this.f0();
            u0.A(104, "WatchPlayerManager-beforeLoad", "errorType-" + errorType + "，errMsg:" + (e.c.a.g.a.d.i.b.l(i2, i3) + ", detail = " + i2 + "_" + i3));
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onInfo(int i2, int i3) {
            super.onInfo(i2, i3);
            e.c.a.g.a.d.d0.a.a("Play", "onInfo: " + i2 + ", " + i3);
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onPause() {
            super.onPause();
            e.c.a.g.a.d.d0.a.a("Play", "onPause");
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onPlay() {
            super.onPlay();
            e.c.a.g.a.d.d0.a.a("Play", "onPlay");
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onPlayerMessageReceived(Message message) {
            super.onPlayerMessageReceived(message);
            e.c.a.g.a.d.d0.a.a("Play", "onPlayerMessageReceived: " + message);
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onPrepared() {
            e.c.a.g.a.d.d0.a.a("Play", "onPrepared");
            e.c.a.g.a.f.m.c.a.j("play_auto_start", true);
            o.this.f568g = 0;
            o.this.f570i = null;
            o.this.j = null;
            o.this.k = null;
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onSeekComplete() {
            super.onSeekComplete();
            e.c.a.g.a.d.d0.a.a("Play", "onSeekComplete");
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onStop() {
            super.onStop();
            e.c.a.g.a.d.d0.a.a("Play", "onStop");
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onInfo(int i2, int i3, byte[] bArr) {
            super.onInfo(i2, i3, bArr);
            e.c.a.g.a.d.d0.a.a("Play", "onInfo2: " + i2 + ", " + i3);
        }

        @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
        public void onInfo(int i2, int i3, String str) {
            super.onInfo(i2, i3, str);
            e.c.a.g.a.d.d0.a.a("Play", "onInfo2: " + i2 + ", " + i3 + ", " + str);
        }
    }
}
