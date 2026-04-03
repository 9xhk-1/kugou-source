package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f2) {
        this.radius = f2 - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        double d2 = this.radius;
        double dSqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        float f5 = (float) ((d2 * dSqrt) / 2.0d);
        float fSqrt = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(f5, 2.0d));
        double d3 = this.radius;
        double dSqrt2 = Math.sqrt(2.0d);
        Double.isNaN(d3);
        double d4 = d3 * dSqrt2;
        double d5 = this.radius;
        Double.isNaN(d5);
        shapePath.reset(f3 - f5, ((float) (-(d4 - d5))) + fSqrt);
        double d6 = this.radius;
        double dSqrt3 = Math.sqrt(2.0d);
        Double.isNaN(d6);
        double d7 = d6 * dSqrt3;
        double d8 = this.radius;
        Double.isNaN(d8);
        shapePath.lineTo(f3, (float) (-(d7 - d8)));
        double d9 = this.radius;
        double dSqrt4 = Math.sqrt(2.0d);
        Double.isNaN(d9);
        double d10 = d9 * dSqrt4;
        double d11 = this.radius;
        Double.isNaN(d11);
        shapePath.lineTo(f3 + f5, ((float) (-(d10 - d11))) + fSqrt);
    }
}
