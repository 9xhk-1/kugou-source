package e.c.a.g.a.g.j.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.g.p.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.x1;
import f.s;
import f.z.d.j;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e.c.a.g.a.g.j.c.a {
    public final e.c.a.g.a.g.j.f.d b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f952d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f953f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f955i;
    public ValueAnimator j;
    public Runnable k;
    public Runnable l;
    public boolean m;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            YoungBITask youngBITask = new YoungBITask(22020004, "click");
            KGMusicWrapper cur = f.this.d().getCur();
            e.c.a.g.a.e.b.b(youngBITask.setMixsongid(cur == null ? null : Long.valueOf(cur.getMixId()).toString()));
            if (e.c.a.g.a.r.b.F()) {
                s0.a.D();
            } else {
                s0.a.l("9");
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TextView a;

        public b(TextView textView) {
            this.a = textView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getPaint().setShader(new LinearGradient(0.0f, 0.0f, x1.a(77), x1.a(14), new int[]{-8590337, -203265, -2886145}, (float[]) null, Shader.TileMode.CLAMP));
            this.a.invalidate();
        }
    }

    public static final class c implements Runnable {

        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ f a;

            public a(f fVar) {
                this.a = fVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue).floatValue();
                this.a.f954h.setVisibility(0);
                this.a.f954h.setAlpha(fFloatValue);
                this.a.f953f.setVisibility(0);
                this.a.f953f.setAlpha(1.0f - fFloatValue);
            }
        }

        public static final class b extends AnimatorListenerAdapter {
            public final /* synthetic */ f a;

            public b(f fVar) {
                this.a = fVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.a.H();
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (f.this.j == null) {
                f fVar = f.this;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                f fVar2 = f.this;
                valueAnimatorOfFloat.setDuration(500L);
                valueAnimatorOfFloat.addUpdateListener(new a(fVar2));
                valueAnimatorOfFloat.addListener(new b(fVar2));
                s sVar = s.a;
                fVar.j = valueAnimatorOfFloat;
            }
            ValueAnimator valueAnimator = f.this.j;
            if (valueAnimator == null) {
                return;
            }
            valueAnimator.start();
        }
    }

    public static final class d implements Runnable {

        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ f a;

            public a(f fVar) {
                this.a = fVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue).floatValue();
                this.a.f954h.setVisibility(0);
                this.a.f954h.setAlpha(fFloatValue);
                this.a.f953f.setVisibility(4);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (f.this.f955i == null) {
                f fVar = f.this;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                f fVar2 = f.this;
                valueAnimatorOfFloat.setDuration(500L);
                valueAnimatorOfFloat.addUpdateListener(new a(fVar2));
                s sVar = s.a;
                fVar.f955i = valueAnimatorOfFloat;
            }
            ValueAnimator valueAnimator = f.this.f955i;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
            f.this.J();
            f.this.d().setShowingVipBar(true);
            f.this.b.q(true);
            e.c.a.g.a.f.m.b.m().f0(System.currentTimeMillis());
            e.c.a.g.a.f.m.b.m().A();
            YoungBITask youngBITask = new YoungBITask(22020003, "exposure");
            KGMusicWrapper cur = f.this.d().getCur();
            e.c.a.g.a.e.b.b(youngBITask.setMixsongid(cur == null ? null : Long.valueOf(cur.getMixId()).toString()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e.c.a.g.a.g.j.f.d dVar, View view, e.c.a.g.a.g.j.c.b bVar) {
        super(bVar);
        j.e(dVar, "parent");
        j.e(view, "contentView");
        j.e(bVar, "provider");
        this.b = dVar;
        this.f952d = view;
        this.f953f = view.findViewById(R.id.song_info_container);
        this.f954h = view.findViewById(R.id.vip_song_bar);
    }

    public final void C() {
        Runnable runnable = this.k;
        if (runnable != null) {
            this.f954h.removeCallbacks(runnable);
        }
    }

    public final void D() {
        Runnable runnable = this.l;
        if (runnable != null) {
            this.f954h.removeCallbacks(runnable);
        }
    }

    public final void E() {
        ValueAnimator valueAnimator = this.f955i;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        C();
        H();
    }

    public final void F() {
        if (this.m) {
            return;
        }
        this.m = true;
        this.f954h.setBackground(u1.d(x1.a(30), new int[]{-13883588, -13092544}, GradientDrawable.Orientation.LEFT_RIGHT));
        ((ImageView) this.f952d.findViewById(R.id.vip_song_icon)).setImageResource(R.drawable.icon_vip_entry);
        TextView textView = (TextView) this.f952d.findViewById(R.id.vip_song_text);
        textView.post(new b(textView));
        ImageView imageView = (ImageView) this.f952d.findViewById(R.id.vip_song_arrow);
        imageView.setImageResource(R.drawable.ic_vip_arrow);
        imageView.setColorFilter(-2493441);
    }

    public final void G() {
        D();
        if (d().isShowingVipBar()) {
            E();
        }
    }

    public final void H() {
        if (this.f954h.getVisibility() == 0) {
            this.f954h.setVisibility(8);
            this.f954h.setAlpha(1.0f);
            this.f953f.setVisibility(0);
            this.f953f.setAlpha(1.0f);
            d().setShowingVipBar(false);
            this.b.q(false);
        }
    }

    public final void I() {
        if (d().getCur() == null) {
            return;
        }
        b.C0154b c0154b = e.c.a.g.a.g.p.b.f1018d;
        if (c0154b.a().h() <= 0) {
            return;
        }
        if (!d().isResume() || d().getFragment() == null || !d().getFragment().getUserVisibleHint()) {
            if (g0.a) {
                g0.b("PlayerVipBarView", "showVipBarAnim: player in background");
                return;
            }
            return;
        }
        if (d().isShowingVipBar() || e.c.a.g.a.r.b.O()) {
            return;
        }
        if (!f()) {
            if (g0.a) {
                g0.b("PlayerVipBarView", "showVipBarAnim: not vip music");
                return;
            }
            return;
        }
        int iT = e.c.a.g.a.f.m.b.m().t();
        int iH = c0154b.a().h();
        if (iT < iH) {
            K();
            return;
        }
        if (g0.a) {
            g0.b("PlayerVipBarView", "showVipBarAnim: show:" + iT + " max:" + iH);
        }
    }

    public final void J() {
        if (this.k == null) {
            this.k = new c();
        }
        this.f954h.removeCallbacks(this.k);
        this.f954h.postDelayed(this.k, 5000L);
    }

    public final void K() {
        F();
        if (this.l == null) {
            this.l = new d();
        }
        this.f954h.removeCallbacks(this.l);
        this.f954h.postDelayed(this.l, 2000L);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void e() {
        super.e();
        this.f954h.setOnClickListener(new a());
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void k() {
        super.k();
        I();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void l() {
        super.l();
        G();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void r(boolean z) {
        super.r(z);
        if (z) {
            return;
        }
        G();
    }
}
