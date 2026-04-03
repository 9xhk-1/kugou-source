package com.kugou.uilib.utils;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIAssert {
    public static void assertEquals(boolean z, boolean z2) {
        assertEquals((String) null, z, z2);
    }

    public static void assertFalse(boolean z) {
        assertFalse(null, z);
    }

    public static void assertHoldLock(Object obj) {
        if (KGUILog.DEBUG) {
            assertTrue(Thread.holdsLock(obj));
        }
    }

    public static void assertMainThread() {
        if (KGUILog.DEBUG) {
            assertTrue(Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public static void assertNotMainThread() {
        if (KGUILog.DEBUG) {
            assertTrue(Looper.getMainLooper() != Looper.myLooper());
        }
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame(null, obj, obj2);
    }

    public static void assertNull(Object obj) {
        assertNull(null, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame(null, obj, obj2);
    }

    public static void assertSubThread() {
        if (KGUILog.DEBUG) {
            assertTrue(Looper.getMainLooper() != Looper.myLooper());
        }
    }

    public static void assertTrue(boolean z) {
        assertTrue(null, z);
    }

    public static void fail() {
        fail(null);
    }

    private static void failNotEquals(String str, Object obj, Object obj2) {
        if (KGUILog.DEBUG) {
            fail(format(str, obj, obj2));
        }
    }

    private static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (KGUILog.DEBUG) {
            if (str != null) {
                str2 = str + " ";
            } else {
                str2 = "";
            }
            fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
        }
    }

    private static void failSame(String str) {
        String str2;
        if (KGUILog.DEBUG) {
            if (str != null) {
                str2 = str + " ";
            } else {
                str2 = "";
            }
            fail(str2 + "expected not same");
        }
    }

    public static String format(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }

    public static void logFail() {
        try {
            fail();
        } catch (Error e2) {
            if (KGUILog.DEBUG) {
                KGUILog.e("AssertionFailedError: ", e2.getMessage());
            }
        }
    }

    public static void logNotNull(Object obj) {
        if (KGUILog.DEBUG) {
            try {
                assertNotNull(null, obj);
            } catch (Error e2) {
                if (KGUILog.DEBUG) {
                    KGUILog.e("AssertionFailedError: ", e2.getMessage());
                }
            }
        }
    }

    public static void logTrue(boolean z) {
        try {
            assertTrue(z);
        } catch (Error e2) {
            if (KGUILog.DEBUG) {
                KGUILog.e("AssertionFailedError: ", e2.getMessage());
            }
        }
    }

    public static void assertEquals(byte b, byte b2) {
        assertEquals((String) null, b, b2);
    }

    public static void assertFalse(String str, boolean z) {
        assertTrue(str, !z);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        failNotSame(str, obj, obj2);
    }

    public static void assertTrue(String str, boolean z) {
        if (z) {
            return;
        }
        fail(str);
    }

    public static void fail(String str) {
        if (KGUILog.DEBUG) {
            throw new Error(str);
        }
    }

    public static void assertEquals(char c, char c2) {
        assertEquals((String) null, c, c2);
    }

    public static void logFail(String str) {
        try {
            fail(str);
        } catch (Error e2) {
            if (KGUILog.DEBUG) {
                KGUILog.e("AssertionFailedError: ", e2.getMessage());
            }
        }
    }

    public static void logTrue(String str, boolean z) {
        try {
            assertTrue(str, z);
        } catch (Error e2) {
            if (KGUILog.DEBUG) {
                KGUILog.e("AssertionFailedError: ", e2.getMessage());
            }
        }
    }

    public static void assertEquals(double d2, double d3, double d4) {
        assertEquals((String) null, d2, d3, d4);
    }

    public static void fail(String str, Throwable th) {
        if (KGUILog.DEBUG) {
            if (th != null) {
                throw new Error(str, th);
            }
            throw new Error(str);
        }
    }

    public static void logNotNull(String str, Object obj) {
        if (KGUILog.DEBUG) {
            try {
                assertTrue(str, obj != null);
            } catch (Error e2) {
                if (KGUILog.DEBUG) {
                    KGUILog.e("AssertionFailedError: ", e2.getMessage());
                }
            }
        }
    }

    public static void assertEquals(float f2, float f3, float f4) {
        assertEquals((String) null, f2, f3, f4);
    }

    public static void assertEquals(int i2, int i3) {
        assertEquals((String) null, i2, i3);
    }

    public static void assertEquals(long j, long j2) {
        assertEquals((String) null, j, j2);
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertEquals(short s, short s2) {
        assertEquals((String) null, s, s2);
    }

    public static void assertEquals(String str, boolean z, boolean z2) {
        if (KGUILog.DEBUG) {
            assertEquals(str, Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public static void assertEquals(String str, byte b, byte b2) {
        if (KGUILog.DEBUG) {
            assertEquals(str, Byte.valueOf(b), Byte.valueOf(b2));
        }
    }

    public static void assertEquals(String str, char c, char c2) {
        if (KGUILog.DEBUG) {
            assertEquals(str, Character.valueOf(c), Character.valueOf(c2));
        }
    }

    public static void assertEquals(String str, double d2, double d3, double d4) {
        if (KGUILog.DEBUG) {
            if (Double.isInfinite(d2)) {
                if (d2 != d3) {
                    failNotEquals(str, Double.valueOf(d2), Double.valueOf(d3));
                }
            } else if (Math.abs(d2 - d3) > d4) {
                failNotEquals(str, Double.valueOf(d2), Double.valueOf(d3));
            }
        }
    }

    public static void assertEquals(String str, float f2, float f3, float f4) {
        if (KGUILog.DEBUG) {
            if (Float.isInfinite(f2)) {
                if (f2 != f3) {
                    failNotEquals(str, Float.valueOf(f2), Float.valueOf(f3));
                }
            } else if (Math.abs(f2 - f3) > f4) {
                failNotEquals(str, Float.valueOf(f2), Float.valueOf(f3));
            }
        }
    }

    public static void assertEquals(String str, int i2, int i3) {
        if (KGUILog.DEBUG) {
            assertEquals(str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public static void assertEquals(String str, long j, long j2) {
        if (KGUILog.DEBUG) {
            assertEquals(str, Long.valueOf(j), Long.valueOf(j2));
        }
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (KGUILog.DEBUG) {
            if (obj == null && obj2 == null) {
                return;
            }
            if (obj == null || !obj.equals(obj2)) {
                failNotEquals(str, obj, obj2);
            }
        }
    }

    public static void assertEquals(String str, short s, short s2) {
        if (KGUILog.DEBUG) {
            assertEquals(str, new Short(s), new Short(s2));
        }
    }

    public static void assertEquals(String str, String str2) {
        assertEquals((String) null, str, str2);
    }

    public static void assertEquals(String str, String str2, String str3) {
        if (KGUILog.DEBUG) {
            if (str2 == null && str3 == null) {
                return;
            }
            if (str2 == null || !str2.equals(str3)) {
                fail(format(str, str2, str3));
            }
        }
    }
}
