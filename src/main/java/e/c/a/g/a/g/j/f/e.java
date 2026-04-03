package e.c.a.g.a.g.j.f;

import android.content.Context;
import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.widget.MarqueeTextView;
import e.c.a.g.a.s.s0;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends e.c.a.g.a.g.j.c.a {
    public final View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MarqueeTextView f950d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MarqueeTextView f951f;

    public static final class a implements View.OnClickListener {
        public static final a a = new a();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!e.c.a.g.a.r.b.F()) {
                s0.a.l("9");
            } else if (e.c.a.g.a.r.b.O()) {
                s0.a.A();
            } else {
                s0.a.D();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(View view, e.c.a.g.a.g.j.c.b bVar) {
        super(bVar);
        j.e(view, "contentView");
        j.e(bVar, "provider");
        View viewFindViewById = view.findViewById(R.id.iv_song_vip);
        j.d(viewFindViewById, "contentView.findViewById(R.id.iv_song_vip)");
        this.b = viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_song_name);
        j.d(viewFindViewById2, "contentView.findViewById(R.id.tv_song_name)");
        this.f950d = (MarqueeTextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_song_singer);
        j.d(viewFindViewById3, "contentView.findViewById(R.id.tv_song_singer)");
        this.f951f = (MarqueeTextView) viewFindViewById3;
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void e() {
        k();
        this.b.setOnClickListener(a.a);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void k() {
        KGMusicWrapper cur = d().getCur();
        if (cur == null) {
            o();
            return;
        }
        this.f950d.setText(cur.getTrackName());
        this.f951f.setText(cur.getArtistName());
        if (f()) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void l() {
        super.l();
        t(false);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void o() {
        Context context = KGApplication.getContext();
        this.f950d.setText(context.getString(R.string.app_name));
        this.f951f.setText(context.getString(R.string.kugou_short_slogan));
        this.b.setVisibility(8);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void p() {
        super.p();
        KGMusicWrapper cur = d().getCur();
        if (cur == null) {
            return;
        }
        this.f950d.setText(cur.getTrackName());
        this.f951f.setText(cur.getArtistName());
        t(true);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void r(boolean z) {
        super.r(z);
        t(z);
    }

    public final void t(boolean z) {
        this.f950d.setFocus(z);
        this.f951f.setFocus(z);
    }
}
