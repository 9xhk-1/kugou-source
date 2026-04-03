package androidx.core.animation;

import android.animation.Animator;
import f.z.c.l;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ l $onPause;
    public final /* synthetic */ l $onResume;

    public AnimatorKt$addPauseListener$listener$1(l lVar, l lVar2) {
        this.$onPause = lVar;
        this.$onResume = lVar2;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        j.f(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        j.f(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
