package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    public Arc[] mArcs;
    private final double[] mTime;

    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        public boolean linear;
        public double mArcDistance;
        public double mArcVelocity;
        public double mEllipseA;
        public double mEllipseB;
        public double mEllipseCenterX;
        public double mEllipseCenterY;
        public double[] mLut;
        public double mOneOverDeltaTime;
        public double mTime1;
        public double mTime2;
        public double mTmpCosAngle;
        public double mTmpSinAngle;
        public boolean mVertical;
        public double mX1;
        public double mX2;
        public double mY1;
        public double mY2;

        public Arc(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            this.linear = false;
            this.mVertical = i2 == 1;
            this.mTime1 = d2;
            this.mTime2 = d3;
            this.mOneOverDeltaTime = 1.0d / (d3 - d2);
            if (3 == i2) {
                this.linear = true;
            }
            double d8 = d6 - d4;
            double d9 = d7 - d5;
            if (this.linear || Math.abs(d8) < EPSILON || Math.abs(d9) < EPSILON) {
                this.linear = true;
                this.mX1 = d4;
                this.mX2 = d6;
                this.mY1 = d5;
                this.mY2 = d7;
                double dHypot = Math.hypot(d9, d8);
                this.mArcDistance = dHypot;
                this.mArcVelocity = dHypot * this.mOneOverDeltaTime;
                double d10 = this.mTime2;
                double d11 = this.mTime1;
                this.mEllipseCenterX = d8 / (d10 - d11);
                this.mEllipseCenterY = d9 / (d10 - d11);
                return;
            }
            this.mLut = new double[101];
            boolean z = this.mVertical;
            double d12 = z ? -1 : 1;
            Double.isNaN(d12);
            this.mEllipseA = d8 * d12;
            double d13 = z ? 1 : -1;
            Double.isNaN(d13);
            this.mEllipseB = d9 * d13;
            this.mEllipseCenterX = z ? d6 : d4;
            this.mEllipseCenterY = z ? d5 : d7;
            buildTable(d4, d5, d6, d7);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
        }

        private void buildTable(double d2, double d3, double d4, double d5) {
            double dHypot;
            double d6 = d4 - d2;
            double d7 = d3 - d5;
            int i2 = 0;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            while (true) {
                if (i2 >= ourPercent.length) {
                    break;
                }
                double d11 = i2;
                Double.isNaN(d11);
                double d12 = d8;
                double length = r15.length - 1;
                Double.isNaN(length);
                double radians = Math.toRadians((d11 * 90.0d) / length);
                double dSin = Math.sin(radians) * d6;
                double dCos = Math.cos(radians) * d7;
                if (i2 > 0) {
                    dHypot = Math.hypot(dSin - d9, dCos - d10) + d12;
                    ourPercent[i2] = dHypot;
                } else {
                    dHypot = d12;
                }
                i2++;
                d10 = dCos;
                d8 = dHypot;
                d9 = dSin;
            }
            double d13 = d8;
            this.mArcDistance = d13;
            int i3 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i3 >= dArr.length) {
                    break;
                }
                dArr[i3] = dArr[i3] / d13;
                i3++;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.mLut.length) {
                    return;
                }
                double d14 = i4;
                double length2 = r1.length - 1;
                Double.isNaN(d14);
                Double.isNaN(length2);
                double d15 = d14 / length2;
                int iBinarySearch = Arrays.binarySearch(ourPercent, d15);
                if (iBinarySearch >= 0) {
                    this.mLut[i4] = iBinarySearch / (ourPercent.length - 1);
                } else if (iBinarySearch == -1) {
                    this.mLut[i4] = 0.0d;
                } else {
                    int i5 = -iBinarySearch;
                    int i6 = i5 - 2;
                    double d16 = i6;
                    double[] dArr2 = ourPercent;
                    double d17 = (d15 - dArr2[i6]) / (dArr2[i5 - 1] - dArr2[i6]);
                    Double.isNaN(d16);
                    double length3 = dArr2.length - 1;
                    Double.isNaN(length3);
                    this.mLut[i4] = (d16 + d17) / length3;
                }
                i4++;
            }
        }

        public double getDX() {
            double d2 = this.mEllipseA * this.mTmpCosAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d2, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d2 = -d2;
            }
            return d2 * dHypot;
        }

        public double getDY() {
            double d2 = this.mEllipseA * this.mTmpCosAngle;
            double d3 = (-this.mEllipseB) * this.mTmpSinAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d2, d3);
            return this.mVertical ? (-d3) * dHypot : d3 * dHypot;
        }

        public double getLinearDX(double d2) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d2) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d2) {
            double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
            double d4 = this.mX1;
            return d4 + (d3 * (this.mX2 - d4));
        }

        public double getLinearY(double d2) {
            double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
            double d4 = this.mY1;
            return d4 + (d3 * (this.mY2 - d4));
        }

        public double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        public double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        public double lookup(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = dArr.length - 1;
            Double.isNaN(length);
            double d3 = d2 * length;
            int i2 = (int) d3;
            double d4 = i2;
            Double.isNaN(d4);
            return dArr[i2] + ((d3 - d4) * (dArr[i2 + 1] - dArr[i2]));
        }

        public void setPoint(double d2) {
            double dLookup = lookup((this.mVertical ? this.mTime2 - d2 : d2 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(dLookup);
            this.mTmpCosAngle = Math.cos(dLookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i2 >= arcArr.length) {
                return;
            }
            int i5 = iArr[i2];
            if (i5 == 0) {
                i4 = 3;
            } else if (i5 == 1) {
                i3 = 1;
                i4 = 1;
            } else if (i5 == 2) {
                i3 = 2;
                i4 = 2;
            } else if (i5 == 3) {
                i3 = i3 == 1 ? 2 : 1;
                i4 = i3;
            }
            int i6 = i2 + 1;
            arcArr[i2] = new Arc(i4, dArr[i2], dArr[i6], dArr2[i2][0], dArr2[i2][1], dArr2[i6][0], dArr2[i6][1]);
            i2 = i6;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        }
        if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d2 <= arcArr2[i2].mTime2) {
                if (arcArr2[i2].linear) {
                    dArr[0] = arcArr2[i2].getLinearX(d2);
                    dArr[1] = this.mArcs[i2].getLinearY(d2);
                    return;
                } else {
                    arcArr2[i2].setPoint(d2);
                    dArr[0] = this.mArcs[i2].getX();
                    dArr[1] = this.mArcs[i2].getY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d2, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d2 <= arcArr2[i2].mTime2) {
                if (arcArr2[i2].linear) {
                    dArr[0] = arcArr2[i2].getLinearDX(d2);
                    dArr[1] = this.mArcs[i2].getLinearDY(d2);
                    return;
                } else {
                    arcArr2[i2].setPoint(d2);
                    dArr[0] = this.mArcs[i2].getDX();
                    dArr[1] = this.mArcs[i2].getDY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d2 <= arcArr2[i2].mTime2) {
                if (arcArr2[i2].linear) {
                    fArr[0] = (float) arcArr2[i2].getLinearX(d2);
                    fArr[1] = (float) this.mArcs[i2].getLinearY(d2);
                    return;
                } else {
                    arcArr2[i2].setPoint(d2);
                    fArr[0] = (float) this.mArcs[i2].getX();
                    fArr[1] = (float) this.mArcs[i2].getY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d2, int i2) {
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        }
        if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d2 <= arcArr2[i3].mTime2) {
                if (arcArr2[i3].linear) {
                    if (i2 == 0) {
                        return arcArr2[i3].getLinearDX(d2);
                    }
                    return arcArr2[i3].getLinearDY(d2);
                }
                arcArr2[i3].setPoint(d2);
                if (i2 == 0) {
                    return this.mArcs[i3].getDX();
                }
                return this.mArcs[i3].getDY();
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d2, int i2) {
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d2 <= arcArr2[i3].mTime2) {
                if (arcArr2[i3].linear) {
                    if (i2 == 0) {
                        return arcArr2[i3].getLinearX(d2);
                    }
                    return arcArr2[i3].getLinearY(d2);
                }
                arcArr2[i3].setPoint(d2);
                if (i2 == 0) {
                    return this.mArcs[i3].getX();
                }
                return this.mArcs[i3].getY();
            }
            i3++;
        }
    }
}
