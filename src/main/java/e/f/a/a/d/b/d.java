package e.f.a.a.d.b;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public ByteBuffer a;
    public String b = "GBK";

    public static class a {
        public byte a;
        public int b;
    }

    public d(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    public static int u(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        int i2 = (b & 240) >> 4;
        aVar.b = i2;
        if (i2 != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
        return 2;
    }

    public final void A(int i2) {
        ByteBuffer byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + i2);
    }

    public final void B(byte b) {
        switch (b) {
            case 0:
                A(1);
                return;
            case 1:
                A(2);
                return;
            case 2:
                A(4);
                return;
            case 3:
                A(8);
                return;
            case 4:
                A(4);
                return;
            case 5:
                A(8);
                return;
            case 6:
                int i2 = this.a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                A(i2);
                return;
            case 7:
                A(this.a.getInt());
                return;
            case 8:
                e(0, 0, true);
                return;
            case 9:
                e(0, 0, true);
                return;
            case 10:
                C();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                v(aVar);
                if (aVar.a == 0) {
                    A(e(0, 0, true));
                    return;
                }
                throw new e.f.a.a.d.b.a("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar.a));
            default:
                throw new e.f.a.a.d.b.a("invalid type.");
        }
    }

    public void C() {
        a aVar = new a();
        do {
            v(aVar);
            B(aVar.a);
        } while (aVar.a != 11);
    }

    public boolean D(int i2) {
        int i3;
        try {
            a aVar = new a();
            while (true) {
                int iA = a(aVar);
                i3 = aVar.b;
                if (i2 <= i3 || aVar.a == 11) {
                    break;
                }
                A(iA);
                B(aVar.a);
            }
            return i2 == i3;
        } catch (e.f.a.a.d.b.a | BufferUnderflowException unused) {
            return false;
        }
    }

    public final int a(a aVar) {
        return u(aVar, this.a.duplicate());
    }

    public byte b(byte b, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        v(aVar);
        byte b2 = aVar.a;
        if (b2 == 0) {
            return this.a.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new e.f.a.a.d.b.a("type mismatch.");
    }

    public double c(double d2, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return d2;
        }
        a aVar = new a();
        v(aVar);
        byte b = aVar.a;
        if (b == 4) {
            return this.a.getFloat();
        }
        if (b == 5) {
            return this.a.getDouble();
        }
        if (b == 12) {
            return 0.0d;
        }
        throw new e.f.a.a.d.b.a("type mismatch.");
    }

    public float d(float f2, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return f2;
        }
        a aVar = new a();
        v(aVar);
        byte b = aVar.a;
        if (b == 4) {
            return this.a.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new e.f.a.a.d.b.a("type mismatch.");
    }

    public int e(int i2, int i3, boolean z) {
        if (!D(i3)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return i2;
        }
        a aVar = new a();
        v(aVar);
        byte b = aVar.a;
        if (b == 0) {
            return this.a.get();
        }
        if (b == 1) {
            return this.a.getShort();
        }
        if (b == 2) {
            return this.a.getInt();
        }
        if (b == 12) {
            return 0;
        }
        throw new e.f.a.a.d.b.a("type mismatch.");
    }

    public long f(long j, int i2, boolean z) {
        int i3;
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return j;
        }
        a aVar = new a();
        v(aVar);
        byte b = aVar.a;
        if (b == 0) {
            i3 = this.a.get();
        } else if (b == 1) {
            i3 = this.a.getShort();
        } else {
            if (b != 2) {
                if (b == 3) {
                    return this.a.getLong();
                }
                if (b == 12) {
                    return 0L;
                }
                throw new e.f.a.a.d.b.a("type mismatch.");
            }
            i3 = this.a.getInt();
        }
        return i3;
    }

    public f g(f fVar, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        try {
            f fVar2 = (f) fVar.getClass().newInstance();
            a aVar = new a();
            v(aVar);
            if (aVar.a != 10) {
                throw new e.f.a.a.d.b.a("type mismatch.");
            }
            fVar2.b(this);
            C();
            return fVar2;
        } catch (Exception e2) {
            throw new e.f.a.a.d.b.a(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object h(T t, int i2, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(b((byte) 0, i2, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(j(false, i2, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(i((short) 0, i2, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(e(0, i2, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(f(0L, i2, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(d(0.0f, i2, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(c(0.0d, i2, z));
        }
        if (t instanceof String) {
            return String.valueOf(y(i2, z));
        }
        if (t instanceof Map) {
            return w((Map) t, i2, z);
        }
        if (t instanceof List) {
            return r((List) t, i2, z);
        }
        if (t instanceof f) {
            return g((f) t, i2, z);
        }
        if (t.getClass().isArray()) {
            return ((t instanceof byte[]) || (t instanceof Byte[])) ? k(null, i2, z) : t instanceof boolean[] ? q(null, i2, z) : t instanceof short[] ? p(null, i2, z) : t instanceof int[] ? n(null, i2, z) : t instanceof long[] ? o(null, i2, z) : t instanceof float[] ? m(null, i2, z) : t instanceof double[] ? l(null, i2, z) : s((Object[]) t, i2, z);
        }
        throw new e.f.a.a.d.b.a("read object error: unsupport type.");
    }

    public short i(short s, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        v(aVar);
        byte b = aVar.a;
        if (b == 0) {
            return this.a.get();
        }
        if (b == 1) {
            return this.a.getShort();
        }
        if (b == 12) {
            return (short) 0;
        }
        throw new e.f.a.a.d.b.a("type mismatch.");
    }

    public boolean j(boolean z, int i2, boolean z2) {
        return b((byte) 0, i2, z2) != 0;
    }

    public byte[] k(byte[] bArr, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        byte b = aVar.a;
        if (b == 9) {
            int iE = e(0, 0, true);
            if (iE < 0) {
                throw new e.f.a.a.d.b.a("size invalid: " + iE);
            }
            byte[] bArr2 = new byte[iE];
            for (int i3 = 0; i3 < iE; i3++) {
                bArr2[i3] = b(bArr2[0], 0, true);
            }
            return bArr2;
        }
        if (b != 13) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        a aVar2 = new a();
        v(aVar2);
        if (aVar2.a != 0) {
            throw new e.f.a.a.d.b.a("type mismatch, tag: " + i2 + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a));
        }
        int iE2 = e(0, 0, true);
        if (iE2 >= 0) {
            byte[] bArr3 = new byte[iE2];
            this.a.get(bArr3);
            return bArr3;
        }
        throw new e.f.a.a.d.b.a("invalid size, tag: " + i2 + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a) + ", size: " + iE2);
    }

    public double[] l(double[] dArr, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        if (aVar.a != 9) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int iE = e(0, 0, true);
        if (iE < 0) {
            throw new e.f.a.a.d.b.a("size invalid: " + iE);
        }
        double[] dArr2 = new double[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            dArr2[i3] = c(dArr2[0], 0, true);
        }
        return dArr2;
    }

    public float[] m(float[] fArr, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        if (aVar.a != 9) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int iE = e(0, 0, true);
        if (iE < 0) {
            throw new e.f.a.a.d.b.a("size invalid: " + iE);
        }
        float[] fArr2 = new float[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            fArr2[i3] = d(fArr2[0], 0, true);
        }
        return fArr2;
    }

    public int[] n(int[] iArr, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        if (aVar.a != 9) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int iE = e(0, 0, true);
        if (iE < 0) {
            throw new e.f.a.a.d.b.a("size invalid: " + iE);
        }
        int[] iArr2 = new int[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            iArr2[i3] = e(iArr2[0], 0, true);
        }
        return iArr2;
    }

    public long[] o(long[] jArr, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        if (aVar.a != 9) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int iE = e(0, 0, true);
        if (iE < 0) {
            throw new e.f.a.a.d.b.a("size invalid: " + iE);
        }
        long[] jArr2 = new long[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            jArr2[i3] = f(jArr2[0], 0, true);
        }
        return jArr2;
    }

    public short[] p(short[] sArr, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        if (aVar.a != 9) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int iE = e(0, 0, true);
        if (iE < 0) {
            throw new e.f.a.a.d.b.a("size invalid: " + iE);
        }
        short[] sArr2 = new short[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            sArr2[i3] = i(sArr2[0], 0, true);
        }
        return sArr2;
    }

    public boolean[] q(boolean[] zArr, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        if (aVar.a != 9) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int iE = e(0, 0, true);
        if (iE < 0) {
            throw new e.f.a.a.d.b.a("size invalid: " + iE);
        }
        boolean[] zArr2 = new boolean[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            zArr2[i3] = j(zArr2[0], 0, true);
        }
        return zArr2;
    }

    public <T> List<T> r(List<T> list, int i2, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] objArrT = t(list.get(0), i2, z);
        if (objArrT == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArrT) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    public <T> T[] s(T[] tArr, int i2, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new e.f.a.a.d.b.a("unable to get type of key and value.");
        }
        return (T[]) t(tArr[0], i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] t(T t, int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        if (aVar.a != 9) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int iE = e(0, 0, true);
        if (iE < 0) {
            throw new e.f.a.a.d.b.a("size invalid: " + iE);
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), iE));
        for (int i3 = 0; i3 < iE; i3++) {
            tArr[i3] = h(t, 0, true);
        }
        return tArr;
    }

    public void v(a aVar) {
        u(aVar, this.a);
    }

    public <K, V> HashMap<K, V> w(Map<K, V> map, int i2, boolean z) {
        return (HashMap) x(new HashMap(), map, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Map<K, V> x(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (D(i2)) {
            a aVar = new a();
            v(aVar);
            if (aVar.a != 8) {
                throw new e.f.a.a.d.b.a("type mismatch.");
            }
            int iE = e(0, 0, true);
            if (iE < 0) {
                throw new e.f.a.a.d.b.a("size invalid: " + iE);
            }
            for (int i3 = 0; i3 < iE; i3++) {
                map.put(h(key, 0, true), h(value, 1, true));
            }
        } else if (z) {
            throw new e.f.a.a.d.b.a("require field not exist.");
        }
        return map;
    }

    public String y(int i2, boolean z) {
        if (!D(i2)) {
            if (z) {
                throw new e.f.a.a.d.b.a("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        v(aVar);
        byte b = aVar.a;
        if (b == 6) {
            int i3 = this.a.get();
            if (i3 < 0) {
                i3 += 256;
            }
            byte[] bArr = new byte[i3];
            this.a.get(bArr);
            try {
                return new String(bArr, this.b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b != 7) {
            throw new e.f.a.a.d.b.a("type mismatch.");
        }
        int i4 = this.a.getInt();
        if (i4 > 104857600 || i4 < 0) {
            throw new e.f.a.a.d.b.a("String too long: " + i4);
        }
        byte[] bArr2 = new byte[i4];
        this.a.get(bArr2);
        try {
            return new String(bArr2, this.b);
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArr2);
        }
    }

    public int z(String str) {
        this.b = str;
        return 0;
    }
}
