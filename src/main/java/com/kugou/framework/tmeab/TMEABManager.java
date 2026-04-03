package com.kugou.framework.tmeab;

import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.INoGuard;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.u0;
import f.c0.e;
import f.d;
import f.f;
import f.g;
import f.z.d.j;
import f.z.d.n;
import f.z.d.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TMEABManager implements INoGuard {
    public static final Companion Companion = new Companion(null);
    private static final d<TMEABManager> instance$delegate = f.a(g.SYNCHRONIZED, TMEABManager$Companion$instance$2.INSTANCE);
    private boolean initialized;
    private final String logTag;
    private final int pageSize;
    private int requestCount;
    private boolean requesting;

    public static final class Companion {
        public static final /* synthetic */ e<Object>[] $$delegatedProperties;

        static {
            n nVar = new n(s.a(Companion.class), "instance", "getInstance()Lcom/kugou/framework/tmeab/TMEABManager;");
            s.c(nVar);
            $$delegatedProperties = new e[]{nVar};
        }

        private Companion() {
        }

        public /* synthetic */ Companion(f.z.d.g gVar) {
            this();
        }

        public static /* synthetic */ void getInstance$annotations() {
        }

        public final TMEABManager getInstance() {
            return (TMEABManager) TMEABManager.instance$delegate.getValue();
        }
    }

    private TMEABManager() {
        this.logTag = "TMEABManager";
        this.pageSize = Math.max(c.a.a().getConfigAsInt(b.M, 20), 10);
        for (e.c.a.e.b bVar : getABList()) {
            Map<String, String> map = e.c.a.e.c.a;
            j.d(map, "abTestKeyMap");
            map.put(bVar.getSource(), bVar.getSPKey());
        }
    }

    public /* synthetic */ TMEABManager(f.z.d.g gVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<e.c.a.e.b> getABList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VipPriABConfigHandler());
        return arrayList;
    }

    public static final TMEABManager getInstance() {
        return Companion.getInstance();
    }

    public final void initConfig() {
        int i2;
        if (u0.n(KGApplication.getContext(), false)) {
            if (g0.a) {
                g0.e(this.logTag, "initConfig initialized:" + this.initialized + " requesting:" + this.requesting);
            }
            if (this.initialized || this.requesting || (i2 = this.requestCount) >= 3) {
                return;
            }
            this.requesting = true;
            int i3 = i2 + 1;
            this.requestCount = i3;
            if (g0.a) {
                g0.e(this.logTag, j.l("initConfig requestCount:", Integer.valueOf(i3)));
            }
            j0.b().a(new Runnable() { // from class: com.kugou.framework.tmeab.TMEABManager.initConfig.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        List aBList = TMEABManager.this.getABList();
                        if (g0.a) {
                            g0.e(TMEABManager.this.logTag, j.l("config list size:", Integer.valueOf(aBList.size())));
                        }
                        int size = (aBList.size() / TMEABManager.this.pageSize) + 1;
                        TMEABManager tMEABManager = TMEABManager.this;
                        int i4 = 0;
                        while (i4 < size) {
                            int i5 = i4 + 1;
                            List listSubList = aBList.subList(tMEABManager.pageSize * i4, Math.min(aBList.size(), tMEABManager.pageSize * i5));
                            if (!listSubList.isEmpty()) {
                                if (g0.a) {
                                    g0.e(tMEABManager.logTag, "request page:" + i4 + " subList size:" + listSubList.size());
                                }
                                e.c.a.e.c.b(listSubList);
                                try {
                                    Thread.sleep(100L);
                                } catch (InterruptedException e2) {
                                    if (g0.a) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            i4 = i5;
                        }
                        final TMEABManager tMEABManager2 = TMEABManager.this;
                        j0.g(new Runnable() { // from class: com.kugou.framework.tmeab.TMEABManager.initConfig.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                tMEABManager2.requesting = false;
                                tMEABManager2.initialized = true;
                                if (g0.a) {
                                    g0.e(tMEABManager2.logTag, "config request end.");
                                }
                            }
                        });
                    } catch (Exception e3) {
                        if (g0.a) {
                            e3.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public final void onNetworkChanged() {
        if (g0.a) {
            g0.e(this.logTag, "onNetworkChanged.");
        }
        initConfig();
    }
}
