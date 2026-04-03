package e.c.a.g.a.d.y;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.c.a.g.a.d.y.b;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ View b;

        public a(c cVar, f fVar, View view) {
            this.a = fVar;
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            switch (((Integer) this.a.b()).intValue()) {
                case 0:
                    this.b.setTranslationX(fFloatValue);
                    break;
                case 1:
                    this.b.setTranslationY(fFloatValue);
                    break;
                case 2:
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.b.setTranslationZ(fFloatValue);
                    }
                    break;
                case 3:
                    this.b.setScaleX(fFloatValue);
                    break;
                case 4:
                    this.b.setScaleY(fFloatValue);
                    break;
                case 5:
                    this.b.setRotation(fFloatValue);
                    break;
                case 6:
                    this.b.setRotationX(fFloatValue);
                    break;
                case 7:
                    this.b.setRotationY(fFloatValue);
                    break;
                case 8:
                    this.b.setX(fFloatValue);
                    break;
                case 9:
                    this.b.setY(fFloatValue);
                    break;
                case 10:
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.b.setZ(fFloatValue);
                    }
                    break;
                case 11:
                    this.b.setAlpha(fFloatValue);
                    break;
            }
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    @NonNull
    public b.a a(@NonNull View view, @NonNull ViewPropertyAnimator viewPropertyAnimator) {
        return new b.a();
    }

    @NonNull
    public Animator b(@NonNull View view, @NonNull g<Integer> gVar, float f2) {
        return gVar.a() ? c(view, (e.c.a.g.a.d.y.a) gVar, f2) : e(view, (f) gVar, f2);
    }

    @NonNull
    public Animator c(@NonNull View view, @NonNull e.c.a.g.a.d.y.a<Integer> aVar, float f2) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public e.c.a.g.a.d.y.a<Integer> d(int i2) {
        return null;
    }

    @NonNull
    public Animator e(@Nullable View view, @NonNull f<Integer> fVar, float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fVar.b().intValue(), f2);
        valueAnimatorOfFloat.addUpdateListener(new a(this, fVar, view));
        return valueAnimatorOfFloat;
    }

    @NonNull
    public f<Integer> f(int i2) {
        return new f<>(Integer.valueOf(i2));
    }

    @NonNull
    public g<Integer> g(@NonNull View view, int i2, boolean z) {
        e.c.a.g.a.d.y.a<Integer> aVarD = z ? d(i2) : null;
        return aVarD != null ? aVarD : f(i2);
    }

    public boolean h() {
        return false;
    }
}
