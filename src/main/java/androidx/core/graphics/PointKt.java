package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class PointKt {
    public static final int component1(Point point) {
        j.f(point, "$this$component1");
        return point.x;
    }

    public static final int component2(Point point) {
        j.f(point, "$this$component2");
        return point.y;
    }

    public static final Point minus(Point point, Point point2) {
        j.f(point, "$this$minus");
        j.f(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    public static final Point plus(Point point, Point point2) {
        j.f(point, "$this$plus");
        j.f(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    public static final Point toPoint(PointF pointF) {
        j.f(pointF, "$this$toPoint");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    public static final PointF toPointF(Point point) {
        j.f(point, "$this$toPointF");
        return new PointF(point);
    }

    public static final Point unaryMinus(Point point) {
        j.f(point, "$this$unaryMinus");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(PointF pointF) {
        j.f(pointF, "$this$component1");
        return pointF.x;
    }

    public static final float component2(PointF pointF) {
        j.f(pointF, "$this$component2");
        return pointF.y;
    }

    public static final PointF unaryMinus(PointF pointF) {
        j.f(pointF, "$this$unaryMinus");
        return new PointF(-pointF.x, -pointF.y);
    }

    public static final PointF minus(PointF pointF, PointF pointF2) {
        j.f(pointF, "$this$minus");
        j.f(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    public static final PointF plus(PointF pointF, PointF pointF2) {
        j.f(pointF, "$this$plus");
        j.f(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    public static final Point minus(Point point, int i2) {
        j.f(point, "$this$minus");
        Point point2 = new Point(point.x, point.y);
        int i3 = -i2;
        point2.offset(i3, i3);
        return point2;
    }

    public static final Point plus(Point point, int i2) {
        j.f(point, "$this$plus");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i2, i2);
        return point2;
    }

    public static final PointF minus(PointF pointF, float f2) {
        j.f(pointF, "$this$minus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f3 = -f2;
        pointF2.offset(f3, f3);
        return pointF2;
    }

    public static final PointF plus(PointF pointF, float f2) {
        j.f(pointF, "$this$plus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f2, f2);
        return pointF2;
    }
}
