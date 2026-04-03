package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import f.z.c.l;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i2) {
        if (!typedArray.hasValue(i2)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getBooleanOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getBoolean(i2, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getColorOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getColor(i2, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getColorStateListOrThrow");
        checkAttribute(typedArray, i2);
        ColorStateList colorStateList = typedArray.getColorStateList(i2);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDimensionOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getDimension(i2, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getDimensionPixelOffset(i2, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getDimensionPixelSize(i2, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDrawableOrThrow");
        checkAttribute(typedArray, i2);
        Drawable drawable = typedArray.getDrawable(i2);
        if (drawable != null) {
            return drawable;
        }
        j.n();
        throw null;
    }

    public static final float getFloatOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getFloatOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getFloat(i2, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getFontOrThrow");
        checkAttribute(typedArray, i2);
        Typeface font = typedArray.getFont(i2);
        if (font != null) {
            return font;
        }
        j.n();
        throw null;
    }

    public static final int getIntOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getIntOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getInt(i2, 0);
    }

    public static final int getIntegerOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getIntegerOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getInteger(i2, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getResourceIdOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getResourceId(i2, 0);
    }

    public static final String getStringOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getStringOrThrow");
        checkAttribute(typedArray, i2);
        String string = typedArray.getString(i2);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getTextArrayOrThrow");
        checkAttribute(typedArray, i2);
        CharSequence[] textArray = typedArray.getTextArray(i2);
        j.b(textArray, "getTextArray(index)");
        return textArray;
    }

    public static final CharSequence getTextOrThrow(TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getTextOrThrow");
        checkAttribute(typedArray, i2);
        CharSequence text = typedArray.getText(i2);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(TypedArray typedArray, l<? super TypedArray, ? extends R> lVar) {
        j.f(typedArray, "$this$use");
        j.f(lVar, "block");
        R rInvoke = lVar.invoke(typedArray);
        typedArray.recycle();
        return rInvoke;
    }
}
