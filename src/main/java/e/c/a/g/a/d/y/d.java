package e.c.a.g.a.d.y;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.c.a.g.a.d.y.b;
import e.c.a.g.a.d.y.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d extends c {

    @NonNull
    public final e a;
    public final h b;

    public d(@NonNull e eVar, @NonNull h hVar) {
        this.a = eVar;
        this.b = hVar;
    }

    @Override // e.c.a.g.a.d.y.c
    @NonNull
    public b.a a(@NonNull View view, @NonNull ViewPropertyAnimator viewPropertyAnimator) {
        b.a aVar = new b.a();
        try {
            long startDelay = viewPropertyAnimator.getStartDelay();
            long duration = viewPropertyAnimator.getDuration();
            TimeInterpolator interpolator = viewPropertyAnimator.getInterpolator();
            ArrayList<Object> arrayListE = this.b.e(viewPropertyAnimator);
            Animator.AnimatorListener animatorListenerB = this.b.b(viewPropertyAnimator);
            if (arrayListE != null) {
                for (int i2 = 0; i2 < arrayListE.size(); i2++) {
                    Object obj = arrayListE.get(i2);
                    h.a aVarD = this.b.d(obj);
                    Animator animatorB = b.b(view, b.C0098b.a(aVarD.c(obj)), aVarD.b(obj) + aVarD.a(obj));
                    if (i2 == 0 && animatorListenerB != null) {
                        animatorB.addListener(animatorListenerB);
                    }
                    animatorB.setDuration(duration);
                    animatorB.setStartDelay(startDelay);
                    animatorB.setInterpolator(interpolator);
                    aVar.a.add(animatorB);
                }
                view.postOnAnimation(aVar);
                viewPropertyAnimator.cancel();
            }
        } catch (Exception unused) {
            viewPropertyAnimator.start();
        }
        return aVar;
    }

    @Override // e.c.a.g.a.d.y.c
    @NonNull
    public Animator c(@NonNull View view, @NonNull a<Integer> aVar, float f2) {
        Animator animatorC = this.a.c(aVar.b(), f2);
        i(animatorC, view);
        return animatorC;
    }

    @Override // e.c.a.g.a.d.y.c
    @Nullable
    public a<Integer> d(int i2) {
        return new a<>(Integer.valueOf(i2));
    }

    @Override // e.c.a.g.a.d.y.c
    public boolean h() {
        return true;
    }

    public void i(@NonNull Animator animator, @NonNull View view) {
        this.a.x(animator, view);
    }
}
