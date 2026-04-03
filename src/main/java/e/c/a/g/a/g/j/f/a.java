package e.c.a.g.a.g.j.f;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.u0;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.c.a.g.a.g.j.c.a implements View.OnClickListener {
    public final ImageView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f938d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f939f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f941i;

    /* JADX INFO: renamed from: e.c.a.g.a.g.j.f.a$a, reason: collision with other inner class name */
    public static final class RunnableC0141a implements Runnable {
        public RunnableC0141a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DelegateFragment fragment;
            DelegateFragment fragment2 = a.this.d().getFragment();
            if (u0.n(fragment2 == null ? null : fragment2.getContext(), false) && (fragment = a.this.d().getFragment()) != null) {
                fragment.p0();
            }
            e.c.a.g.a.d.x.f.s();
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DelegateFragment fragment;
            DelegateFragment fragment2 = a.this.d().getFragment();
            if (u0.n(fragment2 == null ? null : fragment2.getContext(), false) && (fragment = a.this.d().getFragment()) != null) {
                fragment.p0();
            }
            e.c.a.g.a.d.x.f.B();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View view, e.c.a.g.a.g.j.c.b bVar) {
        super(bVar);
        j.e(view, "contentView");
        j.e(bVar, "provider");
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_prev);
        this.b = imageView;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_next);
        this.f938d = imageView2;
        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_toggle);
        this.f939f = imageView3;
        this.f940h = ContextCompat.getDrawable(KGApplication.getContext(), R.drawable.ic_player_act_play);
        this.f941i = ContextCompat.getDrawable(KGApplication.getContext(), R.drawable.ic_player_act_pause);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void e() {
        m();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void k() {
        super.k();
        DelegateFragment fragment = d().getFragment();
        if (fragment == null) {
            return;
        }
        fragment.i0();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void m() {
        super.m();
        if (d().isPlaying()) {
            this.f939f.setImageDrawable(this.f941i);
        } else {
            this.f939f.setImageDrawable(this.f940h);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_next) {
            t(view);
        } else if (id == R.id.iv_prev) {
            u(view);
        } else {
            if (id != R.id.iv_toggle) {
                return;
            }
            v(view);
        }
    }

    public final void t(View view) {
        if (e.c.a.g.a.g.j.c.a.b(this, true, false, false, true, view, null, 32, null)) {
            e.c.a.g.a.g.j.g.a.a(11, d().getCur());
            DelegateFragment fragment = d().getFragment();
            u0.d(fragment == null ? null : fragment.getContext(), new RunnableC0141a());
        }
    }

    public final void u(View view) {
        if (e.c.a.g.a.g.j.c.a.b(this, true, false, false, true, view, null, 32, null)) {
            e.c.a.g.a.g.j.g.a.a(10, d().getCur());
            DelegateFragment fragment = d().getFragment();
            u0.d(fragment == null ? null : fragment.getContext(), new b());
        }
    }

    public final void v(View view) {
        String str;
        String string;
        if (e.c.a.g.a.g.j.c.a.b(this, true, false, false, true, view, null, 32, null)) {
            if (d().isPlaying()) {
                e.c.a.g.a.d.x.f.v();
                str = "2";
            } else {
                e.c.a.g.a.d.x.f.x();
                str = "1";
            }
            YoungBITask youngBITask = new YoungBITask(14, "click");
            KGMusicWrapper cur = d().getCur();
            String str2 = "";
            if (cur != null && (string = Long.valueOf(cur.getMixId()).toString()) != null) {
                str2 = string;
            }
            e.c.a.g.a.e.b.b(youngBITask.setMixsongid(str2).setType("1").setTab(str));
            Intent intent = new Intent("com.kugou.young.xtc.statusupdate");
            if ("2".equals(str)) {
                intent.putExtra(e.c.a.g.a.t.e.a.l(), 2);
            } else {
                intent.putExtra(e.c.a.g.a.t.e.a.l(), 3);
            }
            e.c.a.g.a.f.d.a.d(intent);
        }
    }
}
