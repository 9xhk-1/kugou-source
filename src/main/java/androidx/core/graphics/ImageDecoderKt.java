package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import f.s;
import f.z.c.q;
import f.z.d.j;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, s> qVar) throws IOException {
        j.f(source, "$this$decodeBitmap");
        j.f(qVar, "action");
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeBitmap.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                j.f(imageDecoder, "decoder");
                j.f(imageInfo, "info");
                j.f(source2, "source");
                qVar.invoke(imageDecoder, imageInfo, source2);
            }
        });
        j.b(bitmapDecodeBitmap, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, s> qVar) throws IOException {
        j.f(source, "$this$decodeDrawable");
        j.f(qVar, "action");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeDrawable.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                j.f(imageDecoder, "decoder");
                j.f(imageInfo, "info");
                j.f(source2, "source");
                qVar.invoke(imageDecoder, imageInfo, source2);
            }
        });
        j.b(drawableDecodeDrawable, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
