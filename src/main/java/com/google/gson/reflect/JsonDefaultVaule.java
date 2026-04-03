package com.google.gson.reflect;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.Timestamp;
import java.sql.Time;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public class JsonDefaultVaule {
    private static JsonDefaultVaule instance;
    private final ConcurrentHashMap<Class<?>, Object> defaultEmptyObject;
    private final ConcurrentHashMap<Class<?>, Object> defaultValues;

    private JsonDefaultVaule() {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        this.defaultValues = concurrentHashMap;
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.defaultEmptyObject = concurrentHashMap2;
        concurrentHashMap.put(String.class, "");
        concurrentHashMap.put(Integer.class, 0);
        concurrentHashMap.put(Boolean.class, Boolean.FALSE);
        concurrentHashMap.put(Byte.class, (byte) 0);
        concurrentHashMap.put(Short.class, (short) 0);
        concurrentHashMap.put(Long.class, 0L);
        concurrentHashMap.put(Double.class, Double.valueOf(0.0d));
        concurrentHashMap.put(Float.class, Float.valueOf(0.0f));
        concurrentHashMap.put(Number.class, 0);
        concurrentHashMap2.put(AtomicInteger.class, AtomicInteger.class);
        concurrentHashMap2.put(AtomicBoolean.class, AtomicInteger.class);
        concurrentHashMap2.put(AtomicLong.class, AtomicLong.class);
        concurrentHashMap2.put(AtomicLongArray.class, AtomicLongArray.class);
        concurrentHashMap2.put(AtomicIntegerArray.class, AtomicIntegerArray.class);
        concurrentHashMap2.put(Character.class, Character.class);
        concurrentHashMap2.put(StringBuilder.class, StringBuilder.class);
        concurrentHashMap2.put(StringBuffer.class, StringBuffer.class);
        concurrentHashMap2.put(BigDecimal.class, BigDecimal.class);
        concurrentHashMap2.put(BigInteger.class, BigInteger.class);
        concurrentHashMap2.put(URL.class, URL.class);
        concurrentHashMap2.put(URI.class, URI.class);
        concurrentHashMap2.put(UUID.class, UUID.class);
        concurrentHashMap2.put(Currency.class, Currency.class);
        concurrentHashMap2.put(Locale.class, Locale.class);
        concurrentHashMap2.put(InetAddress.class, InetAddress.class);
        concurrentHashMap2.put(BitSet.class, BitSet.class);
        concurrentHashMap2.put(Date.class, Date.class);
        concurrentHashMap2.put(Calendar.class, Calendar.class);
        concurrentHashMap2.put(GregorianCalendar.class, GregorianCalendar.class);
        concurrentHashMap2.put(Time.class, Time.class);
        concurrentHashMap2.put(java.sql.Date.class, java.sql.Date.class);
        concurrentHashMap2.put(Timestamp.class, Timestamp.class);
    }

    public static JsonDefaultVaule getInstance() {
        if (instance == null) {
            synchronized (JsonDefaultVaule.class) {
                if (instance == null) {
                    instance = new JsonDefaultVaule();
                }
            }
        }
        return instance;
    }

    public Object getDefaultVaule(Class<?> cls) {
        if (cls != null) {
            return this.defaultValues.get(cls);
        }
        return null;
    }
}
