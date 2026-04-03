package e.c.a.g.a.d.y;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h {

    @NonNull
    public final Field a;

    @NonNull
    public final Field b;

    @Nullable
    public a c;

    public static class a {
        public final Field a;
        public final Field b;
        public final Field c;

        public a(Field field, Field field2, Field field3) {
            this.a = field;
            this.b = field2;
            this.c = field3;
        }

        public float a(Object obj) throws IllegalAccessException {
            return 0.0f;
        }

        public float b(Object obj) throws IllegalAccessException {
            return 0.0f;
        }

        public int c(Object obj) throws IllegalAccessException {
            return 0;
        }
    }

    public static class b extends a {
        public b(@NonNull Field field, @NonNull Field field2, @NonNull Field field3) {
            super(field, field2, field3);
        }

        @Override // e.c.a.g.a.d.y.h.a
        public float a(Object obj) throws IllegalAccessException {
            return this.c.getFloat(obj);
        }

        @Override // e.c.a.g.a.d.y.h.a
        public float b(Object obj) throws IllegalAccessException {
            return this.b.getFloat(obj);
        }

        @Override // e.c.a.g.a.d.y.h.a
        public int c(Object obj) throws IllegalAccessException {
            return this.a.getInt(obj);
        }
    }

    public h(@NonNull Class<?> cls, @NonNull Field field, @NonNull Field field2) {
        this.a = field;
        this.b = field2;
    }

    public static h a() {
        try {
            Class<?> cls = Class.forName("android.view.ViewPropertyAnimator");
            Field declaredField = cls.getDeclaredField("mPendingAnimations");
            Field declaredField2 = cls.getDeclaredField("mListener");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            return new h(cls, declaredField, declaredField2);
        } catch (ClassNotFoundException | NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Nullable
    public Animator.AnimatorListener b(@NonNull ViewPropertyAnimator viewPropertyAnimator) throws IllegalAccessException {
        return (Animator.AnimatorListener) this.b.get(viewPropertyAnimator);
    }

    public final a c(Object obj) {
        if (this.c == null) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("mNameConstant");
                Field declaredField2 = obj.getClass().getDeclaredField("mFromValue");
                Field declaredField3 = obj.getClass().getDeclaredField("mDeltaValue");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField3.setAccessible(true);
                this.c = new b(declaredField, declaredField2, declaredField3);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
                this.c = new a(null, null, null);
            }
        }
        return this.c;
    }

    public a d(Object obj) {
        return c(obj);
    }

    @Nullable
    public ArrayList<Object> e(@NonNull ViewPropertyAnimator viewPropertyAnimator) throws IllegalAccessException {
        return (ArrayList) this.a.get(viewPropertyAnimator);
    }
}
