package e.c.a.g.a.g.h.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.component.MainFragment;
import e.c.a.g.a.p.l;
import e.c.a.g.a.s.o;
import f.z.d.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e.c.a.g.a.g.h.b {
    public final d c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f824e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MainFragment mainFragment, ViewGroup viewGroup) {
        super(mainFragment, viewGroup);
        j.e(mainFragment, "frag");
        j.e(viewGroup, "container");
        View viewFindViewById = b().findViewById(R.id.simple_radio_entry);
        j.d(viewFindViewById, "content.findViewById(R.id.simple_radio_entry)");
        this.c = new d(mainFragment, (TextView) viewFindViewById);
        View viewFindViewById2 = b().findViewById(R.id.simple_new_song_entry);
        j.d(viewFindViewById2, "content.findViewById(R.id.simple_new_song_entry)");
        this.f823d = new c(mainFragment, viewFindViewById2);
        View viewFindViewById3 = b().findViewById(R.id.simple_song_rank_entry);
        j.d(viewFindViewById3, "content.findViewById(R.id.simple_song_rank_entry)");
        this.f824e = new b(mainFragment, viewFindViewById3);
        EventBus.getDefault().register(this);
    }

    @Override // e.c.a.g.a.g.h.b
    public void a() {
        super.a();
        o.a(this);
    }

    @Override // e.c.a.g.a.g.h.b
    public int c() {
        return R.layout.fragment_main_header_content_simplify;
    }

    @Override // e.c.a.g.a.g.h.b
    public void h() {
        super.h();
        this.c.b.setVisibility(d(e.c.a.g.a.f.e.b.I1, true));
        int iD = d(e.c.a.g.a.f.e.b.J1, true);
        this.f823d.b.setVisibility(iD);
        this.f824e.b.setVisibility(iD);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(l lVar) {
        j.e(lVar, NotificationCompat.CATEGORY_EVENT);
        this.c.b(lVar);
    }
}
