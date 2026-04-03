package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import f.s;
import f.z.c.l;
import f.z.d.i;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i2, int i3, l<? super Canvas, s> lVar) {
        j.f(picture, "$this$record");
        j.f(lVar, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i2, i3);
        try {
            j.b(canvasBeginRecording, "c");
            lVar.invoke(canvasBeginRecording);
            return picture;
        } finally {
            i.b(1);
            picture.endRecording();
            i.a(1);
        }
    }
}
