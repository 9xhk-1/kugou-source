package e.c.a.g.a.g.j.f;

import android.animation.Animator;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.player.NormalPlayerHolderFragment;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.y0;
import f.z.d.j;
import f.z.d.u;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e.c.a.g.a.g.j.c.a {
    public final SeekBar b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f946d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f947f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Subscription f948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f949i;
    public final Runnable j;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: e.c.a.g.a.g.j.f.c$a$a, reason: collision with other inner class name */
        public static final class C0143a implements Animator.AnimatorListener {
            public final /* synthetic */ c a;

            public C0143a(c cVar) {
                this.a = cVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                j.e(animator, "animation");
                this.a.f946d.setAlpha(1.0f);
                u1.o(this.a.f946d, 8);
                u1.p(this.a.f947f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                j.e(animator, "animation");
                this.a.f946d.setAlpha(1.0f);
                u1.o(this.a.f946d, 8);
                u1.p(this.a.f947f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                j.e(animator, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                j.e(animator, "animation");
                this.a.f946d.setAlpha(1.0f);
                u1.o(this.a.f946d, 0);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f946d.animate().alpha(0.0f).setDuration(300L).setListener(new C0143a(c.this)).start();
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {

        public static final class a<T> implements Action1 {
            public final /* synthetic */ int a;

            public a(int i2) {
                this.a = i2;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(String str) {
                e.c.a.g.a.d.x.f.E(this.a);
                Log.e("mhs_watch_anr", "seekTo.");
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.j.f.c$b$b, reason: collision with other inner class name */
        public static final class C0144b<T> implements Action1 {
            public final /* synthetic */ c a;
            public final /* synthetic */ int b;

            public C0144b(c cVar, int i2) {
                this.a = cVar;
                this.b = i2;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(String str) {
                if (this.a.d().isShowingVipBar()) {
                    u1.o(this.a.f946d, 8);
                    return;
                }
                this.a.F(this.b);
                this.a.b.removeCallbacks(this.a.j);
                this.a.b.postDelayed(this.a.j, 1000L);
                Log.e("mhs_watch_anr", "seekTo update.");
            }
        }

        public b() {
        }

        public final void a(int i2, int i3) {
            if (c.this.f949i) {
                Observable.just("").subscribeOn(Schedulers.io()).doOnNext(new a(i3)).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0144b(c.this, i2));
                return;
            }
            e.c.a.g.a.d.x.f.E(i3);
            if (c.this.d().isShowingVipBar()) {
                u1.o(c.this.f946d, 8);
                return;
            }
            c.this.F(i2);
            c.this.b.removeCallbacks(c.this.j);
            c.this.b.postDelayed(c.this.j, 1000L);
            Log.e("mhs_watch_anr", "seekTo update2.");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (g0.a) {
                g0.b("PlayerProgressView", "onProgressChanged: progress=" + i2 + "   fromUser=" + z);
            }
            if (z) {
                c.this.F(i2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (g0.a) {
                g0.b("PlayerProgressView", "onStartTrackingTouch: ");
            }
            if (c.this.d().isShowingVipBar()) {
                return;
            }
            c.this.f946d.setAlpha(1.0f);
            u1.o(c.this.f946d, 0);
            u1.f(c.this.f947f);
            c.this.b.removeCallbacks(c.this.j);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (g0.a) {
                g0.b("PlayerProgressView", "onStopTrackingTouch: ");
            }
            KGMusicWrapper cur = c.this.d().getCur();
            if (cur == null) {
                cur = e.c.a.g.a.d.x.f.e();
            }
            if (cur != null) {
                int iC = c.this.C();
                int progress = (c.this.b.getProgress() * iC) / 100;
                if (cur.isListenPart() && !e.c.a.g.a.r.b.O()) {
                    long jB = y0.b(cur, 60000L);
                    if (progress < 0 || jB < progress) {
                        int i2 = 0 / iC;
                        c.this.b.setProgress(i2);
                        a(i2, 0);
                        if (!e.c.a.g.a.r.b.F()) {
                            p1.h(KGApplication.getContext(), "请登录后再尝试操作");
                            return;
                        }
                        p1.h(KGApplication.getContext(), "会员专属歌曲，可试听" + y0.c(cur, 30) + (char) 31186);
                        return;
                    }
                }
                a(c.this.b.getProgress(), progress);
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.j.f.c$c, reason: collision with other inner class name */
    public static final class C0145c<T, R> implements Func1 {
        public C0145c() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(Long l) {
            return Integer.valueOf(c.this.D());
        }
    }

    public static final class d<T> implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Integer num) {
            if (!c.this.d().isPlaying()) {
                i1.a(c.this.f948h);
            } else {
                if (c.this.b.isPressed()) {
                    return;
                }
                SeekBar seekBar = c.this.b;
                j.d(num, "it");
                seekBar.setProgress(num.intValue());
                Log.e("mhs_watch_playseek", j.l("startTimer progress = ", num));
            }
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            i1.a(c.this.f948h);
        }
    }

    public static final class f<T, R> implements Func1 {
        public f() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(String str) {
            return Integer.valueOf(c.this.D());
        }
    }

    public static final class g<T> implements Action1 {
        public g() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Integer num) {
            e.c.a.g.a.g.j.c.b bVarD = c.this.d();
            if ((bVarD == null ? null : Boolean.valueOf(bVarD.isPlaying())).booleanValue()) {
                if (!c.this.b.isPressed()) {
                    SeekBar seekBar = c.this.b;
                    j.d(num, "it");
                    seekBar.setProgress(num.intValue());
                }
                Log.e("mhs_watch_playseek", j.l("updateNow progress = ", num));
            }
        }
    }

    public static final class h<T> implements Action1 {
        public static final h<T> a = new h<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view, e.c.a.g.a.g.j.c.b bVar) {
        super(bVar);
        j.e(view, "contentView");
        j.e(bVar, "provider");
        View viewFindViewById = view.findViewById(R.id.progress_music);
        j.d(viewFindViewById, "contentView.findViewById(R.id.progress_music)");
        this.b = (SeekBar) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_progress_tip);
        j.d(viewFindViewById2, "contentView.findViewById(R.id.tv_progress_tip)");
        this.f946d = (TextView) viewFindViewById2;
        this.f947f = view.findViewById(R.id.song_info_container);
        this.f949i = e.c.a.g.a.s.c.a.a();
        this.j = new a();
    }

    public final int C() {
        KGMusicWrapper cur = d().getCur();
        return (cur == null || cur.getDuration() <= 0) ? e.c.a.g.a.d.x.f.g() : (int) cur.getDuration();
    }

    public final int D() {
        int[] iArrJ = e.c.a.g.a.d.x.f.j();
        if (iArrJ != null && iArrJ.length == 2) {
            int i2 = iArrJ[0];
            int i3 = iArrJ[1];
            if (i2 > 1000 && i3 > 1000) {
                e.c.a.g.a.g.j.g.b.d().g(i2, i3);
            }
            if (i3 > 0) {
                return (i2 * 100) / i3;
            }
        }
        return 0;
    }

    public final boolean E() {
        if (!d().isPlaying() || this.b.isPressed()) {
            return false;
        }
        DelegateFragment fragment = d().getFragment();
        if (!(fragment == null ? false : fragment.isResumed())) {
            return false;
        }
        DelegateFragment fragment2 = d().getFragment();
        return fragment2 == null ? false : fragment2.getUserVisibleHint();
    }

    public final void F(int i2) {
        int iC = C() / 1000;
        TextView textView = this.f946d;
        u uVar = u.a;
        String str = String.format("%s / %s", Arrays.copyOf(new Object[]{h1.e((i2 * iC) / 100), h1.e(iC)}, 2));
        j.d(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
    }

    public final void G(boolean z) {
        if (!z) {
            i1.a(this.f948h);
            this.f948h = null;
        } else if (this.f948h == null) {
            this.f948h = Observable.interval(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).map(new C0145c()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(), new e());
            H();
        }
    }

    public final void H() {
        e.c.a.g.a.g.j.c.b bVarD = d();
        boolean z = false;
        if (bVarD != null && !bVarD.isPlaying()) {
            z = true;
        }
        if (z) {
            return;
        }
        Observable.just("").subscribeOn(Schedulers.io()).map(new f()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(), h.a);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void e() {
        this.b.setMax(100);
        this.b.setOnSeekBarChangeListener(new b());
        k();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void g(DelegateFragment delegateFragment, int i2) {
        MainFragmentContainer mainFragmentContainerK;
        super.g(delegateFragment, i2);
        if (i2 == 1) {
            if (delegateFragment == null || (mainFragmentContainerK = delegateFragment.k()) == null) {
                return;
            }
            mainFragmentContainerK.b(this.b);
            return;
        }
        if (i2 != 2) {
            return;
        }
        Fragment parentFragment = delegateFragment == null ? null : delegateFragment.getParentFragment();
        if (parentFragment instanceof NormalPlayerHolderFragment) {
            ((NormalPlayerHolderFragment) parentFragment).b(this.b);
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void k() {
        super.k();
        if (d().getCur() == null) {
            o();
            return;
        }
        this.b.setProgress(0);
        this.b.setEnabled(true);
        G(E());
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void l() {
        G(false);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void m() {
        G(E());
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void o() {
        super.o();
        this.b.setEnabled(false);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void p() {
        G(E());
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void q(boolean z) {
        super.q(z);
        if (z) {
            if (this.f946d.getVisibility() == 0) {
                this.f946d.animate().cancel();
            }
            this.b.removeCallbacks(this.j);
            u1.o(this.f946d, 8);
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void r(boolean z) {
        super.r(z);
        G(E());
    }
}
