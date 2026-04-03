package com.kugou.common.startAppAPM.task;

import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.d0.a;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.d;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.q;
import e.c.c.o.f;
import f.z.d.j;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryReportHelper {
    public static final MemoryReportHelper INSTANCE = new MemoryReportHelper();

    private MemoryReportHelper() {
    }

    private final boolean canReport() {
        try {
            return c.a.a().getConfigAsInt(b.Z3, 1) == 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ void memoryReport$default(MemoryReportHelper memoryReportHelper, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        memoryReportHelper.memoryReport(i2, str);
    }

    public static /* synthetic */ void memoryReport2$default(MemoryReportHelper memoryReportHelper, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        memoryReportHelper.memoryReport2(i2, str);
    }

    public void memoryReport(int i2, String str) {
        if (canReport()) {
            long jD = d.d(KGApplication.getContext());
            long jI = l1.i(f.a());
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("6").setFo("/首页/内存toast").setTab(j.l("", Integer.valueOf(i2))).setSvar1(m.g()).setSvar2(m.d()).setSvar3("存储内存=" + jD + ", 运行内存 = " + jI).setSvar4(str));
            a.a(RingBiReportHelper.INSTANCE.getTAG(), "page /首页/内存toast 1," + i2 + ", 2," + ((Object) m.g()) + ", 3 , " + ((Object) m.d()) + ", 4," + ((Object) str));
        }
    }

    public void memoryReport2(final int i2, final String str) {
        if (canReport()) {
            m1.e(1000, new Action1() { // from class: com.kugou.common.startAppAPM.task.MemoryReportHelper.memoryReport2.1
                @Override // rx.functions.Action1
                public final void call(String str2) {
                    try {
                        Log.e("memoryReport2", j.l("memoryReport2:", str));
                        Observable observableObserveOn = Observable.just(1).subscribeOn(Schedulers.io()).map(new Func1() { // from class: com.kugou.common.startAppAPM.task.MemoryReportHelper.memoryReport2.1.1
                            @Override // rx.functions.Func1
                            public final String call(Integer num) {
                                KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
                                return h1.i(q.r(kGMusicWrapperE == null ? null : kGMusicWrapperE.getFileHashValue())[1]);
                            }
                        }).observeOn(Schedulers.io());
                        final int i3 = i2;
                        final String str3 = str;
                        observableObserveOn.subscribe(new Action1() { // from class: com.kugou.common.startAppAPM.task.MemoryReportHelper.memoryReport2.1.2
                            @Override // rx.functions.Action1
                            public final void call(String str4) {
                                try {
                                    e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("6").setFo("/清除缓存前后对比/内存").setTab(j.l("", Integer.valueOf(i3))).setSvar1(m.g()).setSvar2(m.d()).setSvar3(((Object) str3) + ", 清除后展示 = " + ((Object) str4)));
                                    a.a(RingBiReportHelper.INSTANCE.getTAG(), "page /清除缓存前后对比/内存 1," + i3 + ", 2," + ((Object) m.g()) + ", 3 , " + ((Object) m.d()) + ", 4," + ((Object) str3) + ", 清除后展示 = " + ((Object) str4));
                                } catch (Exception unused) {
                                }
                            }
                        }, new Action1() { // from class: com.kugou.common.startAppAPM.task.MemoryReportHelper.memoryReport2.1.3
                            @Override // rx.functions.Action1
                            public final void call(Throwable th) {
                                th.printStackTrace();
                            }
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }
}
