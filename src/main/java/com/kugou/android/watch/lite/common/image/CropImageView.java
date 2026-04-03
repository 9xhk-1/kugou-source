package com.kugou.android.watch.lite.common.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import e.c.a.g.a.f.i.d;
import e.c.a.g.a.f.i.j;
import e.c.a.g.a.s.l0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CropImageView extends ImageViewTouchBase {
    public float A;
    public int B;
    public ArrayList<d> o;
    public d p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public a u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    public interface a {
        boolean isSaving();

        boolean isWaitingToPick();

        void setCropHightlight(d dVar);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new ArrayList<>();
        this.p = null;
        this.t = true;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = 0.0f;
        this.B = 1;
    }

    public Rect getFixHighlightViewCrop() {
        ArrayList<d> arrayList = this.o;
        d dVar = (arrayList == null || arrayList.size() <= 0) ? null : this.o.get(0);
        if (dVar == null) {
            return null;
        }
        Rect rect = dVar.f668f;
        j jVar = this.f105h;
        if ((jVar != null ? jVar.a() : null) == null) {
            return null;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, r3.getWidth(), r3.getHeight());
        imageViewMatrix.mapRect(rectF);
        RectF rectF2 = new RectF(rect);
        rectF2.offset(-rectF.left, -rectF.top);
        float fE = e(imageViewMatrix, 0);
        return new Rect((int) (rectF2.left / fE), (int) (rectF2.top / fE), (int) (rectF2.right / fE), (int) (rectF2.bottom / fE));
    }

    @Override // com.kugou.android.watch.lite.common.image.ImageViewTouchBase
    public void i(float f2, float f3) {
        super.i(f2, f3);
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            d dVar = this.o.get(i2);
            dVar.f671i.postTranslate(f2, f3);
            dVar.l();
        }
    }

    @Override // com.kugou.android.watch.lite.common.image.ImageViewTouchBase
    public void n(float f2, float f3, float f4) {
        super.n(f2, f3, f4);
        for (d dVar : this.o) {
            dVar.f671i.set(getImageMatrix());
            dVar.l();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            this.o.get(i2).d(canvas);
        }
    }

    @Override // com.kugou.android.watch.lite.common.image.ImageViewTouchBase, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f105h.a() != null) {
            for (d dVar : this.o) {
                dVar.f671i.set(getImageMatrix());
                dVar.l();
                if (dVar.b) {
                    r(dVar);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iG;
        d dVar;
        int i2 = 0;
        if (this.u.isSaving()) {
            return false;
        }
        if (this.t) {
            return v(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.u.isWaitingToPick()) {
                    ArrayList<d> arrayList = this.o;
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar2 = (d) l0.c(arrayList, i3);
                        if (dVar2 != null && dVar2.j()) {
                            this.u.setCropHightlight(dVar2);
                            for (int i4 = 0; i4 < size; i4++) {
                                if (i4 != i3 && (dVar = (d) l0.c(arrayList, i4)) != null) {
                                    dVar.q(true);
                                }
                            }
                            r(dVar2);
                            ((CropImage) getContext()).z = false;
                            return true;
                        }
                    }
                } else {
                    d dVar3 = this.p;
                    if (dVar3 != null) {
                        r(dVar3);
                        this.p.r(1);
                    }
                }
                this.p = null;
            } else if (action == 2) {
                if (this.u.isWaitingToPick()) {
                    x(motionEvent);
                } else {
                    d dVar4 = this.p;
                    if (dVar4 != null) {
                        dVar4.i(this.s, motionEvent.getX() - this.q, motionEvent.getY() - this.r);
                        this.q = motionEvent.getX();
                        this.r = motionEvent.getY();
                        t(this.p);
                    }
                }
            }
        } else if (this.u.isWaitingToPick()) {
            x(motionEvent);
        } else {
            ArrayList<d> arrayList2 = this.o;
            int size2 = arrayList2.size();
            while (true) {
                if (i2 >= size2) {
                    break;
                }
                d dVar5 = (d) l0.c(arrayList2, i2);
                if (dVar5 == null || (iG = dVar5.g(motionEvent.getX(), motionEvent.getY())) == 1) {
                    i2++;
                } else {
                    this.s = iG;
                    this.p = dVar5;
                    this.q = motionEvent.getX();
                    this.r = motionEvent.getY();
                    this.p.r(iG == 32 ? 2 : 3);
                }
            }
        }
        int action2 = motionEvent.getAction();
        if (action2 == 1) {
            a(true, true);
        } else if (action2 == 2 && getScale() == 1.0f) {
            a(true, true);
        }
        return true;
    }

    public void p(d dVar) {
        this.o.add(dVar);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Point q(int r8, int r9) {
        /*
            r7 = this;
            java.util.ArrayList<e.c.a.g.a.f.i.d> r0 = r7.o
            r1 = 0
            if (r0 == 0) goto L14
            int r0 = r0.size()
            if (r0 <= 0) goto L14
            java.util.ArrayList<e.c.a.g.a.f.i.d> r0 = r7.o
            java.lang.Object r0 = r0.get(r1)
            e.c.a.g.a.f.i.d r0 = (e.c.a.g.a.f.i.d) r0
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L7c
            android.graphics.Rect r0 = r0.f668f
            e.c.a.g.a.f.i.j r2 = r7.f105h
            android.graphics.Bitmap r2 = r2.a()
            if (r2 != 0) goto L27
            android.graphics.Point r8 = new android.graphics.Point
            r8.<init>(r1, r1)
            return r8
        L27:
            android.graphics.Matrix r3 = r7.getImageViewMatrix()
            android.graphics.RectF r4 = new android.graphics.RectF
            int r5 = r2.getWidth()
            float r5 = (float) r5
            int r2 = r2.getHeight()
            float r2 = (float) r2
            r6 = 0
            r4.<init>(r6, r6, r5, r2)
            r3.mapRect(r4)
            if (r8 <= 0) goto L4d
            int r2 = r0.left
            float r3 = r4.left
            int r3 = (int) r3
            int r2 = r2 - r3
            if (r2 <= 0) goto L5c
            int r8 = java.lang.Math.min(r2, r8)
            goto L5d
        L4d:
            if (r8 >= 0) goto L5d
            int r2 = r0.right
            float r3 = r4.right
            int r3 = (int) r3
            int r2 = r2 - r3
            if (r2 >= 0) goto L5c
            int r8 = java.lang.Math.max(r2, r8)
            goto L5d
        L5c:
            r8 = 0
        L5d:
            if (r9 <= 0) goto L6c
            int r0 = r0.top
            float r2 = r4.top
            int r2 = (int) r2
            int r0 = r0 - r2
            if (r0 <= 0) goto L7b
            int r9 = java.lang.Math.min(r9, r0)
            goto L7c
        L6c:
            if (r9 >= 0) goto L7c
            int r0 = r0.bottom
            float r2 = r4.bottom
            int r2 = (int) r2
            int r0 = r0 - r2
            if (r0 >= 0) goto L7b
            int r9 = java.lang.Math.max(r9, r0)
            goto L7c
        L7b:
            r9 = 0
        L7c:
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>(r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.common.image.CropImageView.q(int, int):android.graphics.Point");
    }

    public final void r(d dVar) {
        Rect rect = dVar.f668f;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.8f, (getHeight() / rect.height()) * 0.8f) * getScale());
        if (Math.abs(fMax - getScale()) / fMax > 0.1d) {
            float[] fArr = {dVar.f670h.centerX(), dVar.f670h.centerY()};
            getImageMatrix().mapPoints(fArr);
            o(fMax, fArr[0], fArr[1], 300.0f);
        }
        t(dVar);
    }

    public final float s(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    public void setContainer(a aVar) {
        this.u = aVar;
    }

    public void setFixHighlightView(boolean z) {
        this.t = z;
    }

    public final void t(d dVar) {
        Rect rect = dVar.f668f;
        int iMax = Math.max(0, getLeft() - rect.left);
        int iMin = Math.min(0, getRight() - rect.right);
        int iMax2 = Math.max(0, getTop() - rect.top);
        int iMin2 = Math.min(0, getBottom() - rect.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 == 0) {
            iMax2 = iMin2;
        }
        if (iMax == 0 && iMax2 == 0) {
            return;
        }
        h(iMax, iMax2);
    }

    public final void u() {
        Rect rect = new Rect();
        getDrawingRect(rect);
        d dVar = (d) l0.c(this.o, 0);
        Rect rect2 = dVar != null ? dVar.f668f : null;
        if (rect2 != null) {
            if (rect.centerX() == rect2.centerX() && rect.centerY() == rect2.centerY()) {
                return;
            }
            h(rect.centerX() - rect2.centerX(), rect.centerY() - rect2.centerY());
        }
    }

    public boolean v(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            int i2 = this.B;
            if (i2 == 1) {
                this.B = 2;
                this.x = motionEvent.getX(0);
                this.y = motionEvent.getY(0);
                this.z = motionEvent.getX(1);
                this.A = motionEvent.getY(1);
            } else if (i2 == 2) {
                this.B = 3;
            }
        } else {
            int i3 = this.B;
            if (i3 == 2 || i3 == 3) {
                this.x = 0.0f;
                this.y = 0.0f;
                this.z = 0.0f;
                this.A = 0.0f;
                this.v = motionEvent.getX();
                this.w = motionEvent.getY();
            }
            this.B = 1;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.v = motionEvent.getX();
            this.w = motionEvent.getY();
        } else if (action == 1) {
            u();
        } else if (action == 2) {
            int i4 = this.B;
            if (i4 == 3) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                float x2 = motionEvent.getX(1);
                float y2 = motionEvent.getY(1);
                float fAbs = Math.abs(this.z - this.x);
                float fAbs2 = Math.abs(this.A - this.y);
                float fAbs3 = Math.abs(x2 - x);
                float fAbs4 = Math.abs(y2 - y);
                float fSqrt = (float) Math.sqrt((fAbs3 * fAbs3) + (fAbs4 * fAbs4));
                float fSqrt2 = (float) Math.sqrt((fAbs * fAbs) + (fAbs2 * fAbs2));
                if (fSqrt2 > 0.0f) {
                    w(fSqrt / fSqrt2);
                    this.x = x;
                    this.y = y;
                    this.z = x2;
                    this.A = y2;
                }
            } else if (i4 == 1) {
                Point pointQ = q((int) (motionEvent.getX() - this.v), (int) (motionEvent.getY() - this.w));
                int i5 = pointQ.x;
                int i6 = pointQ.y;
                if (i5 != 0 || i6 != 0) {
                    super.i(i5, i6);
                    super.setImageMatrix(getImageViewMatrix());
                    this.v = motionEvent.getX();
                    this.w = motionEvent.getY();
                }
            }
        }
        return true;
    }

    public final void w(float f2) {
        if (f2 <= 1.0f || e(getUnrotatedMatrix(), 0) * f2 < 4.0f) {
            ArrayList<d> arrayList = this.o;
            Point point = null;
            d dVar = (arrayList == null || arrayList.size() <= 0) ? null : this.o.get(0);
            if (dVar != null) {
                Rect rect = dVar.f668f;
                j jVar = this.f105h;
                if ((jVar != null ? jVar.a() : null) == null) {
                    return;
                }
                Matrix imageViewMatrix = getImageViewMatrix();
                RectF rectF = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
                imageViewMatrix.mapRect(rectF);
                if (f2 >= 1.0f || !(rectF.width() == rect.width() || rectF.height() == rect.height())) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(f2, f2, rectF.centerX(), rectF.centerY());
                    RectF rectF2 = new RectF(rectF);
                    matrix.mapRect(rectF2);
                    if (rectF2.contains(new RectF(rect.left, rect.top, rect.right, rect.bottom)) && f2 != 1.0f) {
                        this.b.postScale(f2, f2, rect.centerX(), rect.centerY());
                        setImageMatrix(getImageViewMatrix());
                        return;
                    }
                    if (f2 < 1.0f) {
                        float fWidth = rectF.width() / rect.width();
                        float fHeight = rectF.height() / rect.height();
                        if (fWidth <= 1.0f || fHeight <= 1.0f) {
                            return;
                        }
                        float fS = s(rect.left, rect.top, rectF.left, rectF.top);
                        float fS2 = s(rect.left, rect.bottom, rectF.left, rectF.bottom);
                        float fS3 = s(rect.right, rect.bottom, rectF.right, rectF.bottom);
                        float fS4 = s(rect.right, rect.top, rectF.right, rectF.top);
                        float fMin = Math.min(Math.min(Math.min(fS, fS2), fS3), fS4);
                        if (fMin == fS) {
                            point = new Point(rect.left, rect.top);
                        } else if (fMin == fS2) {
                            point = new Point(rect.left, rect.bottom);
                        } else if (fMin == fS3) {
                            point = new Point(rect.right, rect.bottom);
                        } else if (fMin == fS4) {
                            point = new Point(rect.right, rect.top);
                        }
                        if (point != null) {
                            float fMax = Math.max(f2, Math.max(rect.width() / Math.max(Math.abs(rectF.left - point.x), Math.abs(rectF.right - point.x)), rect.height() / Math.max(Math.abs(rectF.top - point.y), Math.abs(rectF.bottom - point.y))));
                            this.b.postScale(fMax, fMax, point.x, point.y);
                            setImageMatrix(getImageViewMatrix());
                        }
                    }
                }
            }
        }
    }

    public final void x(MotionEvent motionEvent) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.o.size(); i3++) {
            d dVar = this.o.get(i3);
            dVar.o(false);
            dVar.l();
        }
        while (true) {
            if (i2 >= this.o.size()) {
                break;
            }
            d dVar2 = this.o.get(i2);
            if (dVar2.g(motionEvent.getX(), motionEvent.getY()) == 1) {
                i2++;
            } else if (!dVar2.j()) {
                dVar2.o(true);
                dVar2.l();
            }
        }
        invalidate();
    }
}
