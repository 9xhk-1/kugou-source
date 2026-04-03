package e.c.a.g.a.i;

import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.historycloud.HistoryRecord;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.g.p.d.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.u0;
import f.u.n;
import f.u.u;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();
    public static boolean b;
    public static int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f1090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Subscription f1091e;

    public static final class a<T> implements Action1 {
        public final /* synthetic */ String a;
        public final /* synthetic */ List<HistoryRecord> b;

        /* JADX INFO: renamed from: e.c.a.g.a.i.b$a$a, reason: collision with other inner class name */
        public static final class C0164a<T> implements Action1 {
            public final /* synthetic */ List<HistoryRecord> a;

            public C0164a(List<HistoryRecord> list) {
                this.a = list;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(String str) {
                try {
                    List<HistoryRecord> list = this.a;
                    ArrayList arrayList = new ArrayList(n.j(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((HistoryRecord) it.next()).getMixId()));
                    }
                    int iC = e.c.a.g.a.f.h.a.a.a.c(arrayList);
                    StringBuilder sb = new StringBuilder();
                    sb.append("db result = ");
                    sb.append(iC == 1 ? "true" : "false");
                    sb.append(", mixIds = ");
                    sb.append(arrayList);
                    Log.e("mhs_watch_history", sb.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public a(String str, List<HistoryRecord> list) {
            this.a = str;
            this.b = list;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<List<d>> cVar) {
            Log.e("mhs_watch_history", j.l("api resp.isSuccess = ", Boolean.valueOf(cVar.f())));
            RingBiReportHelper.INSTANCE.reportHead4(j.l("上传结果 result = ", cVar.f() ? "成功" : "失败"), this.a);
            if (cVar.f()) {
                m1.f(new C0164a(this.b));
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.i.b$b, reason: collision with other inner class name */
    public static final class C0165b<T> implements Action1 {
        public static final C0165b<T> a = new C0165b<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            Log.e("mhs_watch_history", "uploadHistoryRecord success resp.error");
        }
    }

    static {
        e.c.a.g.a.f.h.a.a aVar = e.c.a.g.a.f.h.a.a.a;
        b = aVar.k();
        c = aVar.e();
        f1090d = aVar.f();
    }

    public final void a(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "song");
        if (!e.c.a.g.a.r.b.F() || e.c.a.g.a.r.b.o() <= 0 || kGMusicWrapper.getMixId() == 0) {
            Log.e("mhs_watch_history", "addOrUpdateCachedSong 没有login直接返回");
            return;
        }
        if (g0.f()) {
            List<e.c.a.g.a.d.f.c.a.d> listC = c();
            Log.e("mhs_watch_history", j.l("插入前多少首 historyList = ", listC == null ? null : Integer.valueOf(listC.size())));
        }
        e.c.a.g.a.f.h.a.a.a.j(kGMusicWrapper);
        b();
    }

    public final void b() {
        Log.d("mhs_watch_history", "checkAndReportIfNeeded do., listen.historycloud.playsong_max_chunk = " + f1090d + ", listen.historycloud.play_song_maxcount = " + c + ", watch.switch.upload_history_enable = " + b);
        if (!b) {
            Log.e("mhs_watch_history", "checkAndReportIfNeeded switch false.");
            return;
        }
        if (!e.c.a.g.a.r.b.F() || e.c.a.g.a.r.b.o() <= 0 || !u0.n(KGApplication.getContext(), false)) {
            Log.e("mhs_watch_history", j.l("checkAndReportIfNeeded 没有login直接返回, isGlobalNetAvailable = ", Boolean.valueOf(u0.n(KGApplication.getContext(), false))));
            return;
        }
        List<e.c.a.g.a.d.f.c.a.d> listC = c();
        if (listC == null || !(!listC.isEmpty()) || listC.size() < c) {
            return;
        }
        List listN = u.n(listC, f1090d);
        Log.e("mhs_watch_history", "当前总共多少个列表要上传 tempChunkList = " + listN.size() + ", historyList.size = " + listC.size());
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            a.d((List) it.next());
        }
    }

    public final List<e.c.a.g.a.d.f.c.a.d> c() {
        return e.c.a.g.a.f.h.a.a.a.g(System.currentTimeMillis(), 100);
    }

    public final void d(List<e.c.a.g.a.d.f.c.a.d> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        List<HistoryRecord> listA = e.c.a.g.a.f.h.a.a.a.a(list);
        List arrayList = new ArrayList(n.j(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((HistoryRecord) it.next()).getMixId()));
        }
        int size = arrayList.size();
        if (arrayList.size() > 10) {
            arrayList = arrayList.subList(0, 10);
        }
        String str = "uploadApi key = " + list.hashCode() + ", size = " + size;
        Log.e("mhs_watch_history", "开始上传 mixids = " + arrayList + ", key = " + str);
        RingBiReportHelper.INSTANCE.reportHead4(j.l("开始上传 mixids = ", arrayList), str);
        f1091e = c.a.a(listA).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(str, listA), C0165b.a);
    }
}
