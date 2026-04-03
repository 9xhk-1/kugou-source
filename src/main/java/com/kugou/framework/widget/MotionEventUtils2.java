package com.kugou.framework.widget;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class MotionEventUtils2 {
    public static final int ACTION_MASK = 255;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static boolean sMultiTouchApiAvailable;

    public static class WrappedStaticMotionEvent {
        private WrappedStaticMotionEvent() {
        }

        public static int findPointerIndex(MotionEvent motionEvent, int i2) {
            return motionEvent.findPointerIndex(i2);
        }

        public static int getPointerId(MotionEvent motionEvent, int i2) {
            return motionEvent.getPointerId(i2);
        }

        public static float getX(MotionEvent motionEvent, int i2) {
            return motionEvent.getX(i2);
        }

        public static float getY(MotionEvent motionEvent, int i2) {
            return motionEvent.getY(i2);
        }
    }

    static {
        try {
            MotionEvent.class.getMethod("getPointerId", Integer.TYPE);
            sMultiTouchApiAvailable = true;
        } catch (NoSuchMethodException unused) {
            sMultiTouchApiAvailable = false;
        }
    }

    public static int findPointerIndex(MotionEvent motionEvent, int i2) {
        return sMultiTouchApiAvailable ? WrappedStaticMotionEvent.findPointerIndex(motionEvent, i2) : i2 == 0 ? 0 : -1;
    }

    public static int getPointerId(MotionEvent motionEvent, int i2) {
        if (sMultiTouchApiAvailable) {
            return WrappedStaticMotionEvent.getPointerId(motionEvent, i2);
        }
        return 0;
    }

    public static float getX(MotionEvent motionEvent, int i2) {
        return sMultiTouchApiAvailable ? WrappedStaticMotionEvent.getX(motionEvent, i2) : motionEvent.getX();
    }

    public static float getY(MotionEvent motionEvent, int i2) {
        return sMultiTouchApiAvailable ? WrappedStaticMotionEvent.getY(motionEvent, i2) : motionEvent.getY();
    }
}
