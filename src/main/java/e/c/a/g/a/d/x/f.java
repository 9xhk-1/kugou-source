package e.c.a.g.a.d.x;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fav.CloudMusicModel;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.p1;
import java.util.List;
import java.util.Random;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class f {

    public class a implements Action1<String> {
        public final /* synthetic */ Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            RingBiReportHelper.INSTANCE.reportAutoStop(Log.getStackTraceString(this.a), "pause");
        }
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            f.f().previous();
        }
    }

    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            f.f().next();
        }
    }

    public class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            List<KGMusicWrapper> listK = f.k();
            if (listK != null) {
                int size = listK.size();
                if (size <= 0) {
                    Log.e("mhs_watch", "语音随机一首 队列为空");
                    return;
                }
                try {
                    int iNextInt = new Random().nextInt(listK.size());
                    if (iNextInt < 0 || iNextInt >= size) {
                        iNextInt = 0;
                        Log.e("mhs_watch", "语音随机一首 重置为0 randomIndex = 0");
                    }
                    f.z(iNextInt, true);
                    KGMusicWrapper kGMusicWrapper = listK.get(iNextInt);
                    if (kGMusicWrapper == null) {
                        Log.e("mhs_watch", "语音随机一首  randomIndex = " + iNextInt + ", queue size 大小 = " + size);
                        return;
                    }
                    Log.e("mhs_watch", "语音随机一首  randomIndex = " + iNextInt + ", name = " + kGMusicWrapper.getDisplayName() + ", queue 大小 = " + size);
                } catch (Exception e2) {
                    Log.e("mhs_watch", "语音随机一首 e = " + e2);
                }
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f549d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e.c.a.g.a.d.r.e f550f;

        public e(List list, boolean z, boolean z2, e.c.a.g.a.d.r.e eVar) {
            this.a = list;
            this.b = z;
            this.f549d = z2;
            this.f550f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) this.a.get(0);
            e.c.a.g.a.e.b.b(new YoungBITask(22020025, "click").setSource(e.c.a.g.a.f.j.c.d.b(kGMusicWrapper)).setMixsongid(kGMusicWrapper.getMixId() + "").setTab("1").setSvar1(this.b + "").setSvar2(this.a.size() + "").setIvar1(this.f549d + ""));
            e.c.a.g.a.d.r.f.d(this.b, this.a, this.f549d, this.f550f);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.x.f$f, reason: collision with other inner class name */
    public class RunnableC0083f implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ List b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f551d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f552f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e.c.a.g.a.d.r.e f553h;

        public RunnableC0083f(int i2, List list, boolean z, boolean z2, e.c.a.g.a.d.r.e eVar) {
            this.a = i2;
            this.b = list;
            this.f551d = z;
            this.f552f = z2;
            this.f553h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.a;
            if (i2 >= 0 && i2 < this.b.size()) {
                KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) this.b.get(this.a);
                e.c.a.g.a.e.b.b(new YoungBITask(22020025, "click").setSource(e.c.a.g.a.f.j.c.d.b(kGMusicWrapper)).setMixsongid(kGMusicWrapper.getMixId() + "").setTab((this.a + 1) + "").setSvar1(this.f551d + "").setSvar2(this.b.size() + "").setIvar1(this.f552f + ""));
            }
            e.c.a.g.a.d.r.f.e(this.f551d, this.b, this.a, this.f552f, this.f553h);
        }
    }

    public static void A(boolean z, List<KGMusicWrapper> list, int i2, boolean z2) {
        if (z) {
            EventBus.getDefault().post(new j());
        }
        f().playSongList(list, i2, z2);
    }

    public static void B() {
        j0.b().a(new b());
    }

    public static void C() {
        j0.b().a(new d());
    }

    public static void D(String str) {
        f().refreshPlayQueue(str);
    }

    public static void E(int i2) {
        f().seekTo(i2);
    }

    public static void F(int i2) {
        f().setPlayMode(i2, true);
    }

    public static int G() {
        return f().size();
    }

    public static void H(Initiator initiator, List<KGSong> list, CloudMusicModel cloudMusicModel, e.c.a.g.a.d.f.c.a.j jVar, e.c.a.g.a.d.r.e eVar) {
        e.c.a.g.a.d.r.f.f(initiator, list, cloudMusicModel, jVar, eVar);
    }

    public static void I(boolean z) {
        if (o()) {
            f().updateForegroundState(z);
        }
    }

    public static void J(List<KGMusicWrapper> list) {
        f().updateListenPart(list);
    }

    public static void b() {
        f().cancelNotification();
    }

    public static void c(boolean z, List<KGMusicWrapper> list) {
        if (z) {
            EventBus.getDefault().post(new j());
        }
        f().append(list);
    }

    public static int d() {
        return f().getCurrentPosition();
    }

    @Nullable
    public static KGMusicWrapper e() {
        return f().getCurrentSong();
    }

    public static e.c.a.g.a.d.x.a f() {
        return h.y();
    }

    public static int g() {
        return f().getDuration();
    }

    public static e.c.a.g.a.d.q.b h() {
        return f().getMediaSession();
    }

    public static int i() {
        return f().getPlayMode();
    }

    public static int[] j() {
        return f().getPosAndDuration();
    }

    @Nullable
    public static List<KGMusicWrapper> k() {
        return f().getQueue();
    }

    public static void l(boolean z, List<KGMusicWrapper> list, boolean z2, @Nullable e.c.a.g.a.d.r.e eVar) {
        if (list == null || list.size() == 0) {
            p1.h(KGApplication.getContext(), "你所选择的播放列表为空");
        } else {
            j0.b().a(new e(list, z, z2, eVar));
        }
    }

    public static void m(boolean z, List<KGMusicWrapper> list, boolean z2) {
        if (z) {
            EventBus.getDefault().post(new j());
        }
        f().insert(list, z2);
    }

    public static boolean n() {
        KGMusicWrapper kGMusicWrapperE = e();
        return kGMusicWrapperE != null && kGMusicWrapperE.getMusicLinkSource() == 1023;
    }

    public static boolean o() {
        return h.A();
    }

    public static boolean p(boolean z) {
        return f().isPlayListenPartMode(z);
    }

    public static boolean q() {
        return f().isPlaying();
    }

    public static boolean r() {
        return G() == 0;
    }

    public static void s() {
        j0.b().a(new c());
    }

    public static void t() {
        f().pause();
        u();
    }

    public static void u() {
        RingBiReportHelper ringBiReportHelper = RingBiReportHelper.INSTANCE;
        if (ringBiReportHelper.getNeedReportPause()) {
            m1.f(new a(new Throwable("自动暂停")));
        }
        if (ringBiReportHelper.getNeedReportPause2()) {
            e.c.a.g.a.d.d0.a.a("PlayerController", "暂停, throwable  = " + new Throwable("自动暂停"));
        }
    }

    public static void v() {
        f().pause();
        Log.e("mhs_watch_pasue", "pauseWhenClickView playicon");
    }

    public static void w() {
        f().pauseWhenExit();
        u();
    }

    public static void x() {
        f().play();
    }

    public static void y(boolean z, @Nullable List<KGMusicWrapper> list, int i2, boolean z2, @Nullable e.c.a.g.a.d.r.e eVar) {
        if (list == null || list.size() == 0) {
            p1.h(KGApplication.getContext(), "你选择的歌曲列表为空");
        } else {
            j0.b().a(new RunnableC0083f(i2, list, z, z2, eVar));
        }
    }

    public static boolean z(int i2, boolean z) {
        return f().playByIndex(i2, z);
    }
}
