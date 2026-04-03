package androidx.core.animation;

import android.animation.Animator;
import f.z.c.l;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    public final /* synthetic */ l $onCancel;
    public final /* synthetic */ l $onEnd;
    public final /* synthetic */ l $onRepeat;
    public final /* synthetic */ l $onStart;

    public AnimatorKt$addListener$listener$1(l lVar, l lVar2, l lVar3, l lVar4) {
        this.$onRepeat = lVar;
        this.$onEnd = lVar2;
        this.$onCancel = lVar3;
        this.$onStart = lVar4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        j.f(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        j.f(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        j.f(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        j.f(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
