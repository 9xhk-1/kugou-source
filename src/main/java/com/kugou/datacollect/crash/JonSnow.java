package com.kugou.datacollect.crash;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import e.c.c.o.l;
import e.c.c.o.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class JonSnow {
    public boolean a;
    public int b;
    public h c = new h(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f252d;

    public static class HintActivity extends Activity {
        @Override // android.app.Activity
        public void onBackPressed() {
        }

        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null || !intent.hasExtra("caller_pid")) {
                return;
            }
            intent.getIntExtra("caller_pid", 0);
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ Thread b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Throwable f253d;

        public a(JonSnow jonSnow, c cVar, Thread thread, Throwable th) {
            this.a = cVar;
            this.b = thread;
            this.f253d = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onDecideHandle(this.b, this.f253d);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JonSnow.this.f252d.c();
        }
    }

    public interface c {
        void onDecideHandle(Thread thread, Throwable th);

        void onRisingGiveUp();
    }

    public class d implements e {
        public d() {
        }

        @Override // com.kugou.datacollect.crash.JonSnow.e
        public void execute(Thread thread, Throwable th, c cVar) {
            JonSnow.this.c.b();
            JonSnow.g("not the main thread, let it go destroy, rise = " + JonSnow.this.c.c());
        }

        public /* synthetic */ d(JonSnow jonSnow, a aVar) {
            this();
        }
    }

    public interface e {
        void execute(Thread thread, Throwable th, c cVar);
    }

    public class f implements e {
        public f() {
        }

        @Override // com.kugou.datacollect.crash.JonSnow.e
        public void execute(Thread thread, Throwable th, c cVar) {
            JonSnow.g("main thread, try re-loop First-Time");
            while (Looper.myLooper() != null && JonSnow.this.c.b()) {
                try {
                    JonSnow.g("start re-loop, rise = " + JonSnow.this.c.c());
                    Looper.loop();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    JonSnow.g("snow-mode throw an ex, re-loop Again");
                }
            }
            JonSnow.g("snow-mode crash many times, abandon rising");
        }

        public /* synthetic */ f(JonSnow jonSnow, a aVar) {
            this();
        }
    }

    public static final class g {

        public class a implements Comparator<Long> {
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Long l, Long l2) {
                return (int) (l2.longValue() - l.longValue());
            }
        }

        public g() {
        }

        public static void a(List<Long> list, long j) {
            if (list == null || list.size() <= 0) {
                return;
            }
            Collections.sort(list, new a());
            int i2 = 0;
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (next.longValue() < j || i2 > 3) {
                    it.remove();
                    JonSnow.g("remove overdue crash ts " + next + ", count = " + i2);
                } else {
                    i2++;
                }
            }
        }

        public static JSONArray c(List<Long> list, int i2) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                jSONArray.put(i2);
                Iterator<Long> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            return jSONArray;
        }

        public static List<Long> d(JSONArray jSONArray, int i2) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        arrayList.add(Long.valueOf(jSONArray.getLong(i3)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (arrayList.size() > 0) {
                    long jLongValue = ((Long) arrayList.get(0)).longValue();
                    if (jLongValue == i2) {
                        arrayList.remove(0);
                        JonSnow.g("remove first item, value = " + jLongValue);
                    } else {
                        arrayList.clear();
                        JonSnow.g("version changed, clean the old crash record");
                    }
                }
            }
            return arrayList;
        }

        public boolean b() {
            JSONArray jSONArray;
            Context contextA = e.c.c.o.f.a();
            int iX = m.x(contextA);
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                jSONArray = new JSONArray(l.e(contextA).d("Melisandre.Notebook.", ""));
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONArray = null;
            }
            List<Long> listD = d(jSONArray, iX);
            listD.add(Long.valueOf(jCurrentTimeMillis));
            a(listD, jCurrentTimeMillis - 86400000);
            JonSnow.g("after filter, timeList.size = " + listD.size());
            l.e(contextA).g("Melisandre.Notebook.", c(listD, iX).toString());
            return listD.size() > 3;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public static final class i {
        public BroadcastReceiver a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                i.this.d(intent);
            }
        }

        public class b extends BroadcastReceiver {
            public b(i iVar) {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null && intent.hasExtra("caller_pid") && intent.getIntExtra("caller_pid", 0) == Process.myPid()) {
                    JonSnow.g("user ask me to die ... other");
                    Process.killProcess(Process.myPid());
                }
            }
        }

        public i(Context context) {
            if (e.c.c.o.f.b()) {
                a aVar = new a();
                this.a = aVar;
                JonSnow.j(aVar, new IntentFilter("notify.show.snow.mode.hint"));
            } else {
                b bVar = new b(this);
                this.a = bVar;
                JonSnow.j(bVar, new IntentFilter("notify.exist.snow.mode"));
            }
        }

        public static i b(Context context) {
            return new i(context);
        }

        public void c() {
            Intent intent = new Intent();
            intent.putExtra("caller_pid", Process.myPid());
            d(intent);
        }

        public final void d(Intent intent) {
            JonSnow.g("display user hint NOW !!!");
            e.c.c.d dVarC = e.c.c.m.g.d(e.c.c.o.f.a()).c();
            if (dVarC != null) {
                dVarC.onCallBack(intent);
            }
        }
    }

    public JonSnow(Context context) {
        this.f252d = i.b(context);
    }

    public static void g(Object obj) {
        Log.d("burone-snow", "" + obj);
    }

    public static void h(Object obj) {
        Log.e("burone-snow", "" + obj);
    }

    public static void j(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            e.c.c.o.f.a().registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void d(Thread thread, Throwable th, c cVar) {
        a aVar = new a(this, cVar, thread, th);
        if (thread == Looper.getMainLooper().getThread()) {
            e.c.c.o.h.d(aVar);
        } else {
            aVar.run();
        }
    }

    public final void e(Thread thread, Throwable th, c cVar) {
        if (thread == Looper.getMainLooper().getThread() || this.c.a()) {
            cVar.onRisingGiveUp();
        }
    }

    public boolean f(Thread thread, Throwable th, c cVar) {
        synchronized (this) {
            a aVar = null;
            if (!new g(aVar).b()) {
                this.a = true;
            }
            if (this.a) {
                g("cant not do rise, sorry");
                return false;
            }
            int i2 = this.b;
            this.b = i2 + 1;
            if (i2 == 0) {
                i();
            }
            g(this.b + "uncaughtException invoke, thread = " + thread);
            StringBuilder sb = new StringBuilder();
            sb.append("exp = ");
            sb.append(th);
            h(sb.toString());
            d(thread, th, cVar);
            (Thread.currentThread() == Looper.getMainLooper().getThread() ? new f(this, aVar) : new d(this, aVar)).execute(thread, th, cVar);
            e(thread, th, cVar);
            return true;
        }
    }

    public final void i() {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new b());
    }

    public static class h {
        public AtomicInteger a;
        public volatile Long b;

        public h() {
            this.a = new AtomicInteger(0);
            this.b = null;
        }

        public boolean a() {
            return this.a.get() > 3 && !d();
        }

        public boolean b() {
            if (this.b == null) {
                this.b = Long.valueOf(SystemClock.elapsedRealtime());
            }
            return this.a.getAndAdd(1) < 3 || d();
        }

        public int c() {
            return this.a.get();
        }

        public final boolean d() {
            try {
                return SystemClock.elapsedRealtime() - this.b.longValue() < 180000;
            } catch (Exception unused) {
                return false;
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }
}
