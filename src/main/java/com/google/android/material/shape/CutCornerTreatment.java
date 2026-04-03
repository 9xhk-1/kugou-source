package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class CutCornerTreatment extends CornerTreatment {
    public float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        shapePath.reset(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double dSin = Math.sin(Math.toRadians(f2));
        double d2 = f4;
        Double.isNaN(d2);
        double d3 = f3;
        Double.isNaN(d3);
        double dSin2 = Math.sin(Math.toRadians(90.0f - f2));
        Double.isNaN(d2);
        Double.isNaN(d3);
        shapePath.lineTo((float) (dSin * d2 * d3), (float) (dSin2 * d2 * d3));
    }

    @Deprecated
    public CutCornerTreatment(float f2) {
        this.size = -1.0f;
        this.size = f2;
    }
}
