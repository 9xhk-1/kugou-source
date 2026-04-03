package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f2, float f3) {
            return f3 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f2, float f3) {
            return Math.abs(f3) < this.mVelocityThreshold;
        }

        public void setFrictionScalar(float f2) {
            this.mFriction = f2 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float f2) {
            this.mVelocityThreshold = f2 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float f2, float f3, long j) {
            DynamicAnimation.MassState massState = this.mMassState;
            double d2 = f3;
            float f4 = j;
            double dExp = Math.exp((f4 / 1000.0f) * this.mFriction);
            Double.isNaN(d2);
            massState.mVelocity = (float) (d2 * dExp);
            DynamicAnimation.MassState massState2 = this.mMassState;
            float f5 = this.mFriction;
            double d3 = f2 - (f3 / f5);
            double d4 = f3 / f5;
            double dExp2 = Math.exp((f5 * f4) / 1000.0f);
            Double.isNaN(d4);
            Double.isNaN(d3);
            massState2.mValue = (float) (d3 + (d4 * dExp2));
            DynamicAnimation.MassState massState3 = this.mMassState;
            if (isAtEquilibrium(massState3.mValue, massState3.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f2, float f3) {
        return this.mFlingForce.getAcceleration(f2, f3);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f2, float f3) {
        return f2 >= this.mMaxValue || f2 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f2, f3);
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f2);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f2) {
        this.mFlingForce.setValueThreshold(f2);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j) {
        DynamicAnimation.MassState massStateUpdateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j);
        float f2 = massStateUpdateValueAndVelocity.mValue;
        this.mValue = f2;
        float f3 = massStateUpdateValueAndVelocity.mVelocity;
        this.mVelocity = f3;
        float f4 = this.mMinValue;
        if (f2 < f4) {
            this.mValue = f4;
            return true;
        }
        float f5 = this.mMaxValue;
        if (f2 <= f5) {
            return isAtEquilibrium(f2, f3);
        }
        this.mValue = f5;
        return true;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f2) {
        super.setMaxValue(f2);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f2) {
        super.setMinValue(f2);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f2) {
        super.setStartVelocity(f2);
        return this;
    }

    public <K> FlingAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
