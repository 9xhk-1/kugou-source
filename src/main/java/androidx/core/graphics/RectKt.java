package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect rect, Rect rect2) {
        j.f(rect, "$this$and");
        j.f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(Rect rect) {
        j.f(rect, "$this$component1");
        return rect.left;
    }

    public static final int component2(Rect rect) {
        j.f(rect, "$this$component2");
        return rect.top;
    }

    public static final int component3(Rect rect) {
        j.f(rect, "$this$component3");
        return rect.right;
    }

    public static final int component4(Rect rect) {
        j.f(rect, "$this$component4");
        return rect.bottom;
    }

    public static final boolean contains(Rect rect, Point point) {
        j.f(rect, "$this$contains");
        j.f(point, "p");
        return rect.contains(point.x, point.y);
    }

    public static final Region minus(Rect rect, Rect rect2) {
        j.f(rect, "$this$minus");
        j.f(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Rect or(Rect rect, Rect rect2) {
        j.f(rect, "$this$or");
        j.f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final Rect plus(Rect rect, Rect rect2) {
        j.f(rect, "$this$plus");
        j.f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final Rect times(Rect rect, int i2) {
        j.f(rect, "$this$times");
        Rect rect2 = new Rect(rect);
        rect2.top *= i2;
        rect2.left *= i2;
        rect2.right *= i2;
        rect2.bottom *= i2;
        return rect2;
    }

    public static final Rect toRect(RectF rectF) {
        j.f(rectF, "$this$toRect");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect rect) {
        j.f(rect, "$this$toRectF");
        return new RectF(rect);
    }

    public static final Region toRegion(Rect rect) {
        j.f(rect, "$this$toRegion");
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix matrix) {
        j.f(rectF, "$this$transform");
        j.f(matrix, "m");
        matrix.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(Rect rect, Rect rect2) {
        j.f(rect, "$this$xor");
        j.f(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(RectF rectF) {
        j.f(rectF, "$this$component1");
        return rectF.left;
    }

    public static final float component2(RectF rectF) {
        j.f(rectF, "$this$component2");
        return rectF.top;
    }

    public static final float component3(RectF rectF) {
        j.f(rectF, "$this$component3");
        return rectF.right;
    }

    public static final float component4(RectF rectF) {
        j.f(rectF, "$this$component4");
        return rectF.bottom;
    }

    public static final boolean contains(RectF rectF, PointF pointF) {
        j.f(rectF, "$this$contains");
        j.f(pointF, "p");
        return rectF.contains(pointF.x, pointF.y);
    }

    public static final Region toRegion(RectF rectF) {
        j.f(rectF, "$this$toRegion");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF rectF, RectF rectF2) {
        j.f(rectF, "$this$and");
        j.f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    public static final Rect minus(Rect rect, int i2) {
        j.f(rect, "$this$minus");
        Rect rect2 = new Rect(rect);
        int i3 = -i2;
        rect2.offset(i3, i3);
        return rect2;
    }

    public static final RectF or(RectF rectF, RectF rectF2) {
        j.f(rectF, "$this$or");
        j.f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final RectF plus(RectF rectF, RectF rectF2) {
        j.f(rectF, "$this$plus");
        j.f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final Region xor(RectF rectF, RectF rectF2) {
        j.f(rectF, "$this$xor");
        j.f(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final RectF minus(RectF rectF, float f2) {
        j.f(rectF, "$this$minus");
        RectF rectF2 = new RectF(rectF);
        float f3 = -f2;
        rectF2.offset(f3, f3);
        return rectF2;
    }

    public static final Rect plus(Rect rect, int i2) {
        j.f(rect, "$this$plus");
        Rect rect2 = new Rect(rect);
        rect2.offset(i2, i2);
        return rect2;
    }

    public static final RectF times(RectF rectF, float f2) {
        j.f(rectF, "$this$times");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }

    public static final Rect minus(Rect rect, Point point) {
        j.f(rect, "$this$minus");
        j.f(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    public static final RectF plus(RectF rectF, float f2) {
        j.f(rectF, "$this$plus");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final RectF minus(RectF rectF, PointF pointF) {
        j.f(rectF, "$this$minus");
        j.f(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }

    public static final Rect plus(Rect rect, Point point) {
        j.f(rect, "$this$plus");
        j.f(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    public static final Region minus(RectF rectF, RectF rectF2) {
        j.f(rectF, "$this$minus");
        j.f(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF plus(RectF rectF, PointF pointF) {
        j.f(rectF, "$this$plus");
        j.f(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    public static final RectF times(RectF rectF, int i2) {
        j.f(rectF, "$this$times");
        float f2 = i2;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }
}
