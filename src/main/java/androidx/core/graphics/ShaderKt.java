package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import f.s;
import f.z.c.l;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, l<? super Matrix, s> lVar) {
        j.f(shader, "$this$transform");
        j.f(lVar, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        lVar.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
