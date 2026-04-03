package e.c.c.m;

import com.kugou.common.network.AbsHttpClient;
import com.kugou.datacollect.crash.bean.CrashBean;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements e.c.c.k.d<List<CrashBean>> {
    @Override // e.c.c.k.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean send(List<CrashBean> list) {
        for (CrashBean crashBean : list) {
            e(crashBean);
            b(crashBean);
            if (crashBean.isSendRateResult() && crashBean.isSendCrashTreeResult()) {
                e.c.c.k.f.e.q().e(Long.valueOf(crashBean.getCacheBeanId()));
            } else {
                h(crashBean);
            }
        }
        return false;
    }

    public void b(CrashBean crashBean) {
        if (crashBean.isSendCrashTreeResult()) {
            return;
        }
        crashBean.setSendCrashTreeResult(f(crashBean));
    }

    @Override // e.c.c.k.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean sendLastFailData(List<CrashBean> list, long j) {
        return false;
    }

    public boolean d(CrashBean crashBean) {
        e.c.c.o.g.a("bisdk", "begin sendToCCrashRate crashBean" + crashBean.toJson());
        AbsHttpClient absHttpClientB = g.d(e.c.c.o.f.a()).b();
        if (absHttpClientB == null) {
            absHttpClientB = new h(e.c.c.o.f.a());
        }
        absHttpClientB.disableOffline(true);
        try {
            absHttpClientB.request(new a(e.c.c.o.f.a(), crashBean), null);
            e.c.c.o.g.a("bisdk", "sendToCCrashRate success");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void e(CrashBean crashBean) {
        if (crashBean.isSendRateResult()) {
            return;
        }
        if (crashBean.isCCrashType()) {
            d(crashBean);
        }
        crashBean.setSendRateResult(g(crashBean));
    }

    public boolean f(CrashBean crashBean) {
        e.c.c.o.g.a("bisdk", "begin sendToCrashTree crashBean：" + crashBean.toString());
        AbsHttpClient absHttpClientB = g.d(e.c.c.o.f.a()).b();
        if (absHttpClientB == null) {
            absHttpClientB = new h(e.c.c.o.f.a());
        }
        absHttpClientB.disableOffline(true);
        try {
            absHttpClientB.request(new e(crashBean), null);
            e.c.c.o.g.a("bisdk", "sendToCrashTree success");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean g(CrashBean crashBean) {
        e.c.c.o.g.a("bisdk", "begin sendToJCrashRate crashBean" + crashBean.toJson());
        AbsHttpClient absHttpClientB = g.d(e.c.c.o.f.a()).b();
        if (absHttpClientB == null) {
            absHttpClientB = new h(e.c.c.o.f.a());
        }
        absHttpClientB.disableOffline(true);
        try {
            absHttpClientB.request(new f(e.c.c.o.f.a(), crashBean), null);
            e.c.c.o.g.a("bisdk", "sendToJCrashRate success");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void h(CrashBean crashBean) {
        e.c.c.k.f.e.q().s(crashBean.cacheBeanId, crashBean.toJson().toString());
    }
}
