package e.c.a.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.kugou.android.watch.lite.R;
import f.d;
import f.f;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    public final View a;
    public final d b;

    public static final class a extends k implements f.z.c.a<Animation> {
        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Animation invoke() {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(c.this.a.getContext(), R.anim.anim_wave_identify);
            animationLoadAnimation.setDuration(1800L);
            return animationLoadAnimation;
        }
    }

    public c(View view, View view2) {
        j.e(view, "view");
        j.e(view2, "view2");
        this.a = view;
        this.b = f.b(new a());
    }

    public final Animation b() {
        return (Animation) this.b.getValue();
    }

    @Override // e.c.a.a.b
    public void startWaveAnim() {
        this.a.startAnimation(b());
    }

    @Override // e.c.a.a.b
    public void stopWaveAnim() {
        b().cancel();
        this.a.clearAnimation();
        this.a.setScaleX(1.0f);
        this.a.setScaleY(1.0f);
    }
}
