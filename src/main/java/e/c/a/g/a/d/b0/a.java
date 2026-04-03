package e.c.a.g.a.d.b0;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: dontRemove */
/* JADX WARN: Method from annotation default annotation not found: titleBarTransparent */
/* JADX WARN: Method from annotation default annotation not found: titleText */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean animationFirstForbiddenEnable() default false;

    @ColorRes
    int backgroundColor() default 0;

    @ColorRes
    int fakeContentColor() default 0;

    @DimenRes
    int fakeContentHeight() default -2;

    boolean hasFakeContent() default false;

    boolean hasPlayingBar() default true;

    boolean skinEnable() default true;

    int viewType() default 1;
}
