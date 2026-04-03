package e.c.c.k.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import e.c.c.k.c;
import e.c.c.k.d;
import e.c.c.k.f.e;
import e.c.c.m.h;
import e.c.c.m.i;
import e.c.c.o.f;
import e.c.c.o.g;
import e.c.c.o.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f1258d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f1259e = false;
    public Handler a;
    public HandlerThread b = new HandlerThread("bi_sdk_sender");
    public boolean c = false;

    public class a implements Runnable {
        public a(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f1259e) {
                return;
            }
            g.a("bisdk", "begin send start up");
            h hVar = new h(f.a());
            hVar.disableOffline(true);
            try {
                hVar.request(new i(), null);
                b.f1259e = true;
            } catch (Exception e2) {
                e2.printStackTrace();
                b.f1259e = false;
            }
        }
    }

    /* JADX INFO: renamed from: e.c.c.k.g.b$b, reason: collision with other inner class name */
    public class HandlerC0203b extends Handler {
        public HandlerC0203b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 0) {
                g.a("DataCollectContentProvider", "WHAT_LOOP_TASK");
                try {
                    if (e.q().h() != 0) {
                        b.this.c();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                sendEmptyMessageDelayed(0, 60000L);
                return;
            }
            if (i2 == 1) {
                try {
                    g.a("siganid", "SENT_AT_ONCE");
                    b.this.c();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static b a() {
        return f1258d;
    }

    public void b(String str) {
        if (this.c) {
            return;
        }
        this.c = true;
        if ((str == null || str.length() == 0) && !j.e()) {
            return;
        }
        if (j.d(str) || j.e()) {
            this.b.start();
            HandlerC0203b handlerC0203b = new HandlerC0203b(this.b.getLooper());
            this.a = handlerC0203b;
            handlerC0203b.sendEmptyMessageDelayed(0, 1L);
            g();
        }
    }

    public void c() {
        g();
        HashMap<String, e.c.c.k.b> mapA = c.c().a();
        long jH = e.q().h();
        for (Map.Entry<String, e.c.c.k.b> entry : mapA.entrySet()) {
            e.c.c.k.b value = entry.getValue();
            String key = entry.getKey();
            g.a("DataCollectContentProvider", "send type:" + key);
            if (jH != 0) {
                d(key, value);
            }
            f(key, value);
            if (jH != 0) {
                e(key, value);
            }
        }
    }

    public void d(String str, e.c.c.k.b bVar) {
        if (bVar.f()) {
            g.a("DataCollectContentProvider", "sendLastFailData");
            d dVarB = bVar.b();
            for (Map.Entry<Long, List<e.c.c.k.f.b>> entry : e.q().l(str).entrySet()) {
                dVarB.sendLastFailData(bVar.c().toSenderData(entry.getValue()), entry.getKey().longValue());
            }
        }
    }

    public void e(String str, e.c.c.k.b bVar) {
        if (bVar.f()) {
            g.a("DataCollectContentProvider", "sendNormalData");
            d dVarB = bVar.b();
            List<e.c.c.k.f.b> listP = e.q().p(str);
            if (listP == null || listP.size() == 0) {
                return;
            }
            dVarB.send(bVar.c().toSenderData(listP));
        }
    }

    public void f(String str, e.c.c.k.b bVar) {
        if (bVar.e()) {
            g.a("DataCollectContentProvider", "sendNormalDataInMomery");
            d dVarB = bVar.b();
            List<e.c.c.k.f.b> listO = e.q().o(str);
            if (listO == null || listO.size() == 0) {
                return;
            }
            dVarB.send(bVar.c().toSenderData(listO));
            if (str.equals("2")) {
                listO.clear();
            }
        }
    }

    public void g() {
        if (f1259e) {
            return;
        }
        this.a.post(new a(this));
    }

    public void h() {
        g.a("bisdk", "sentAtOnce");
        this.a.sendEmptyMessageDelayed(1, 100L);
    }
}
