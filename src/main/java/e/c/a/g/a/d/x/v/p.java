package e.c.a.g.a.d.x.v;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public class p extends e.c.a.g.a.d.x.v.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BroadcastReceiver f631i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.xtc.alarmclock.action.ALARM_VIEW_SHOWING".equals(intent.getAction())) {
                p.this.b.pause();
                e.c.a.g.a.d.x.e.d(3);
            }
        }
    }

    @Override // e.c.a.g.a.d.x.v.a
    public void g() {
        super.g();
        if (this.f631i != null) {
            this.b.x().unregisterReceiver(this.f631i);
            this.f631i = null;
        }
    }

    @Override // e.c.a.g.a.d.x.v.a
    public void h(e.c.a.g.a.d.x.h hVar) {
        super.h(hVar);
        k();
        i();
        m();
        j();
    }

    public final void m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xtc.alarmclock.action.ALARM_VIEW_SHOWING");
        this.f631i = new a();
        this.b.x().registerReceiver(this.f631i, intentFilter);
    }
}
