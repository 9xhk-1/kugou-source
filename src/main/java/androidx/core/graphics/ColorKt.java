package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(Color color) {
        j.f(color, "$this$component1");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        j.f(color, "$this$component2");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        j.f(color, "$this$component3");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        j.f(color, "$this$component4");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace.Named named) {
        j.f(named, "colorSpace");
        return Color.convert(i2, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = Color.colorSpace(j);
        j.b(colorSpace, "Color.colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return Color.green(j);
    }

    public static final int getGreen(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i2) {
        return Color.luminance(i2);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return Color.red(j);
    }

    public static final int getRed(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return Color.isWideGamut(j);
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color color2) {
        j.f(color, "$this$plus");
        j.f(color2, "c");
        Color colorCompositeColors = ColorUtils.compositeColors(color2, color);
        j.b(colorCompositeColors, "ColorUtils.compositeColors(c, this)");
        return colorCompositeColors;
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i2) {
        Color colorValueOf = Color.valueOf(i2);
        j.b(colorValueOf, "Color.valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j) {
        return Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i2) {
        return Color.pack(i2);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace colorSpace) {
        j.f(colorSpace, "colorSpace");
        return Color.convert(i2, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return Color.luminance(j);
    }

    @RequiresApi(26)
    public static final Color toColor(long j) {
        Color colorValueOf = Color.valueOf(j);
        j.b(colorValueOf, "Color.valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        j.f(str, "$this$toColorInt");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace.Named named) {
        j.f(named, "colorSpace");
        return Color.convert(j, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace colorSpace) {
        j.f(colorSpace, "colorSpace");
        return Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        j.f(color, "$this$convertTo");
        j.f(named, "colorSpace");
        Color colorConvert = color.convert(ColorSpace.get(named));
        j.b(colorConvert, "convert(ColorSpace.get(colorSpace))");
        return colorConvert;
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        j.f(color, "$this$convertTo");
        j.f(colorSpace, "colorSpace");
        Color colorConvert = color.convert(colorSpace);
        j.b(colorConvert, "convert(colorSpace)");
        return colorConvert;
    }
}
