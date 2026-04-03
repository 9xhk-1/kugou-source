package e.c.a.g.a.g.h.k;

import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.component.MainFragment;
import e.c.a.g.a.p.l;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.o;
import f.z.d.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e.c.a.g.a.g.h.b {
    public final d c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f804e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MainFragment mainFragment, ViewGroup viewGroup) {
        super(mainFragment, viewGroup);
        j.e(mainFragment, "frag");
        j.e(viewGroup, "container");
        this.c = new d(mainFragment, b().findViewById(R.id.radio_entry));
        this.f803d = new c(mainFragment, b().findViewById(R.id.new_song_entry));
        this.f804e = new b(mainFragment, b().findViewById(R.id.song_rank_entry));
        EventBus.getDefault().register(this);
    }

    @Override // e.c.a.g.a.g.h.b
    public void a() {
        super.a();
        o.a(this);
        this.c.i();
    }

    @Override // e.c.a.g.a.g.h.b
    public int c() {
        return l1.X() ? R.layout.fragment_main_header_content_jxw : R.layout.fragment_main_header_content;
    }

    @Override // e.c.a.g.a.g.h.b
    public void e() {
        super.e();
        this.c.m();
    }

    @Override // e.c.a.g.a.g.h.b
    public void f() {
        super.f();
        this.c.n();
    }

    @Override // e.c.a.g.a.g.h.b
    public void g() {
        super.g();
        this.c.s();
    }

    @Override // e.c.a.g.a.g.h.b
    public void h() {
        super.h();
        this.c.b.setVisibility(d(e.c.a.g.a.f.e.b.I1, true));
        int iD = d(e.c.a.g.a.f.e.b.J1, true);
        this.f803d.b.setVisibility(iD);
        this.f804e.b.setVisibility(iD);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(l lVar) {
        j.e(lVar, NotificationCompat.CATEGORY_EVENT);
        this.f803d.c();
        this.c.t(true, lVar);
    }
}
