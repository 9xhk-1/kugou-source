package com.kugou.uilib.widget.textview.span;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class KGUICustomTypefaceSpan extends TypefaceSpan {
    public static final Parcelable.Creator<KGUICustomTypefaceSpan> CREATOR = new Parcelable.Creator<KGUICustomTypefaceSpan>() { // from class: com.kugou.uilib.widget.textview.span.KGUICustomTypefaceSpan.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KGUICustomTypefaceSpan createFromParcel(Parcel parcel) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KGUICustomTypefaceSpan[] newArray(int i2) {
            return new KGUICustomTypefaceSpan[i2];
        }
    };

    @Nullable
    private final Typeface newType;

    public KGUICustomTypefaceSpan(String str, @Nullable Typeface typeface) {
        super(str);
        this.newType = typeface;
    }

    private static void applyCustomTypeFace(Paint paint, @Nullable Typeface typeface) {
        if (typeface == null) {
            return;
        }
        Typeface typeface2 = paint.getTypeface();
        int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (typeface.getStyle() ^ (-1));
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }
}
