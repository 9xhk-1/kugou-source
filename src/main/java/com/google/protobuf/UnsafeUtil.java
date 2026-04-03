package com.google.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeUtil {
    private static final Unsafe UNSAFE = getUnsafe();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final long ARRAY_BASE_OFFSET = byteArrayBaseOffset();
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(field(Buffer.class, "address"));

    private UnsafeUtil() {
    }

    public static long addressOffset(ByteBuffer byteBuffer) {
        return UNSAFE.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    public static Object allocateInstance(Class<?> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static int byteArrayBaseOffset() {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return UNSAFE.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    public static void copyMemory(Object obj, long j, Object obj2, long j2, long j3) {
        UNSAFE.copyMemory(obj, j, obj2, j2, j3);
    }

    private static java.lang.reflect.Field field(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(java.lang.reflect.Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = UNSAFE) == null) {
            return -1L;
        }
        return unsafe.objectFieldOffset(field);
    }

    public static long getArrayBaseOffset() {
        return ARRAY_BASE_OFFSET;
    }

    public static boolean getBoolean(Object obj, long j) {
        return UNSAFE.getBoolean(obj, j);
    }

    public static byte getByte(Object obj, long j) {
        return UNSAFE.getByte(obj, j);
    }

    public static double getDouble(Object obj, long j) {
        return UNSAFE.getDouble(obj, j);
    }

    public static float getFloat(Object obj, long j) {
        return UNSAFE.getFloat(obj, j);
    }

    public static int getInt(Object obj, long j) {
        return UNSAFE.getInt(obj, j);
    }

    public static long getLong(Object obj, long j) {
        return UNSAFE.getLong(obj, j);
    }

    public static Object getObject(Object obj, long j) {
        return UNSAFE.getObject(obj, j);
    }

    private static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws Exception {
                    for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static long objectFieldOffset(java.lang.reflect.Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    public static void putBoolean(Object obj, long j, boolean z) {
        UNSAFE.putBoolean(obj, j, z);
    }

    public static void putByte(Object obj, long j, byte b) {
        UNSAFE.putByte(obj, j, b);
    }

    public static void putDouble(Object obj, long j, double d2) {
        UNSAFE.putDouble(obj, j, d2);
    }

    public static void putFloat(Object obj, long j, float f2) {
        UNSAFE.putFloat(obj, j, f2);
    }

    public static void putInt(Object obj, long j, int i2) {
        UNSAFE.putInt(obj, j, i2);
    }

    public static void putLong(Object obj, long j, long j2) {
        UNSAFE.putLong(obj, j, j2);
    }

    public static void putObject(Object obj, long j, Object obj2) {
        UNSAFE.putObject(obj, j, obj2);
    }

    public static void setMemory(long j, long j2, byte b) {
        UNSAFE.setMemory(j, j2, b);
    }

    private static boolean supportsUnsafeArrayOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("allocateInstance", Class.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("setMemory", cls2, cls2, Byte.TYPE);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void copyMemory(long j, long j2, long j3) {
        UNSAFE.copyMemory(j, j2, j3);
    }

    public static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    public static int getInt(long j) {
        return UNSAFE.getInt(j);
    }

    public static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    public static void putByte(long j, byte b) {
        UNSAFE.putByte(j, b);
    }

    public static void putInt(long j, int i2) {
        UNSAFE.putInt(j, i2);
    }

    public static void putLong(long j, long j2) {
        UNSAFE.putLong(j, j2);
    }
}
