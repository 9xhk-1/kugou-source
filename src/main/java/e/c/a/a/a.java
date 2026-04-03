package e.c.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import f.d;
import f.f;
import f.z.d.j;
import f.z.d.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements e.c.a.a.b {
    public final View a;
    public final View b;
    public final d c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f360d;

    /* JADX INFO: renamed from: e.c.a.a.a$a, reason: collision with other inner class name */
    public static final class C0038a extends k implements f.z.c.a<AnimatorSet> {
        public C0038a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AnimatorSet invoke() {
            a aVar = a.this;
            return aVar.d(aVar.a, 0L);
        }
    }

    public static final class b extends k implements f.z.c.a<AnimatorSet> {
        public b() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AnimatorSet invoke() {
            a aVar = a.this;
            return aVar.d(aVar.b, 900L);
        }
    }

    public a(View view, View view2) {
        j.e(view, "view1");
        j.e(view2, "view2");
        this.a = view;
        this.b = view2;
        this.c = f.b(new C0038a());
        this.f360d = f.b(new b());
    }

    public final AnimatorSet d(View view, long j) {
        ObjectAnimator[] objectAnimatorArr = {ObjectAnimator.ofFloat(view, Key.SCALE_X, 1.0f, 1.6f), ObjectAnimator.ofFloat(view, Key.SCALE_Y, 1.0f, 1.6f), ObjectAnimator.ofFloat(view, Key.ALPHA, 0.9f, 0.0f)};
        for (int i2 = 0; i2 < 3; i2++) {
            objectAnimatorArr[i2].setRepeatCount(-1);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether((Animator[]) Arrays.copyOf(objectAnimatorArr, 3));
        animatorSet.setDuration(1800L);
        animatorSet.setStartDelay(j);
        animatorSet.setInterpolator(new LinearInterpolator());
        return animatorSet;
    }

    public final AnimatorSet e() {
        return (AnimatorSet) this.c.getValue();
    }

    public final AnimatorSet f() {
        return (AnimatorSet) this.f360d.getValue();
    }

    @Override // e.c.a.a.b
    public void startWaveAnim() {
        e().start();
        f().start();
    }

    @Override // e.c.a.a.b
    public void stopWaveAnim() {
        e().cancel();
        f().cancel();
        this.a.setScaleX(1.0f);
        this.a.setScaleY(1.0f);
        this.b.setScaleX(1.0f);
        this.b.setScaleY(1.0f);
    }
}
