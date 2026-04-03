package e.f.a.a.d.b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public ByteBuffer a;
    public String b;

    public e(int i2) {
        this.b = "GBK";
        this.a = ByteBuffer.allocate(i2);
    }

    public void A(long[] jArr, int i2) {
        a(8);
        E((byte) 9, i2);
        g(jArr.length, 0);
        for (long j : jArr) {
            h(j, 0);
        }
    }

    public void B(short[] sArr, int i2) {
        a(8);
        E((byte) 9, i2);
        g(sArr.length, 0);
        for (short s : sArr) {
            u(s, 0);
        }
    }

    public void C(boolean[] zArr, int i2) {
        a(8);
        E((byte) 9, i2);
        g(zArr.length, 0);
        for (boolean z : zArr) {
            v(z, 0);
        }
    }

    public final void D(Object[] objArr, int i2) {
        a(8);
        E((byte) 9, i2);
        g(objArr.length, 0);
        for (Object obj : objArr) {
            p(obj, 0);
        }
    }

    public void E(byte b, int i2) {
        if (i2 < 15) {
            this.a.put((byte) (b | (i2 << 4)));
        } else if (i2 < 256) {
            this.a.put((byte) (b | 240));
            this.a.put((byte) i2);
        } else {
            throw new c("tag is too large: " + i2);
        }
    }

    public void a(int i2) {
        if (this.a.remaining() < i2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.a.capacity() + i2) * 2);
            byteBufferAllocate.put(this.a.array(), 0, this.a.position());
            this.a = byteBufferAllocate;
        }
    }

    public int b(String str) {
        this.b = str;
        return 0;
    }

    public byte[] c() {
        byte[] bArr = new byte[this.a.position()];
        System.arraycopy(this.a.array(), 0, bArr, 0, this.a.position());
        return bArr;
    }

    public void d(byte b, int i2) {
        a(3);
        if (b == 0) {
            E((byte) 12, i2);
        } else {
            E((byte) 0, i2);
            this.a.put(b);
        }
    }

    public void e(double d2, int i2) {
        a(10);
        E((byte) 5, i2);
        this.a.putDouble(d2);
    }

    public void f(float f2, int i2) {
        a(6);
        E((byte) 4, i2);
        this.a.putFloat(f2);
    }

    public void g(int i2, int i3) {
        a(6);
        if (i2 >= -32768 && i2 <= 32767) {
            u((short) i2, i3);
        } else {
            E((byte) 2, i3);
            this.a.putInt(i2);
        }
    }

    public void h(long j, int i2) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            g((int) j, i2);
        } else {
            E((byte) 3, i2);
            this.a.putLong(j);
        }
    }

    public void i(f fVar, int i2) {
        a(2);
        E((byte) 10, i2);
        fVar.c(this);
        a(2);
        E((byte) 11, 0);
    }

    public void j(Boolean bool, int i2) {
        j(bool, i2);
    }

    public void k(Byte b, int i2) {
        k(b, i2);
    }

    public void l(Double d2, int i2) {
        l(d2, i2);
    }

    public void m(Float f2, int i2) {
        m(f2, i2);
    }

    public void n(Integer num, int i2) {
        n(num, i2);
    }

    public void o(Long l, int i2) {
        o(l, i2);
    }

    public void p(Object obj, int i2) {
        if (obj instanceof Byte) {
            k((Byte) obj, i2);
            return;
        }
        if (obj instanceof Boolean) {
            j((Boolean) obj, i2);
            return;
        }
        if (obj instanceof Short) {
            q((Short) obj, i2);
            return;
        }
        if (obj instanceof Integer) {
            n((Integer) obj, i2);
            return;
        }
        if (obj instanceof Long) {
            o((Long) obj, i2);
            return;
        }
        if (obj instanceof Float) {
            m((Float) obj, i2);
            return;
        }
        if (obj instanceof Double) {
            l((Double) obj, i2);
            return;
        }
        if (obj instanceof String) {
            r((String) obj, i2);
            return;
        }
        if (obj instanceof Map) {
            t((Map) obj, i2);
            return;
        }
        if (obj instanceof List) {
            s((List) obj, i2);
            return;
        }
        if (obj instanceof f) {
            i((f) obj, i2);
            return;
        }
        if (obj instanceof byte[]) {
            w((byte[]) obj, i2);
            return;
        }
        if (obj instanceof boolean[]) {
            C((boolean[]) obj, i2);
            return;
        }
        if (obj instanceof short[]) {
            B((short[]) obj, i2);
            return;
        }
        if (obj instanceof int[]) {
            z((int[]) obj, i2);
            return;
        }
        if (obj instanceof long[]) {
            A((long[]) obj, i2);
            return;
        }
        if (obj instanceof float[]) {
            y((float[]) obj, i2);
            return;
        }
        if (obj instanceof double[]) {
            x((double[]) obj, i2);
            return;
        }
        if (obj.getClass().isArray()) {
            D((Object[]) obj, i2);
        } else {
            if (obj instanceof Collection) {
                s((Collection) obj, i2);
                return;
            }
            throw new c("write object error: unsupport type. " + obj.getClass());
        }
    }

    public void q(Short sh, int i2) {
        q(sh, i2);
    }

    public void r(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            E((byte) 7, i2);
            this.a.putInt(bytes.length);
            this.a.put(bytes);
        } else {
            E((byte) 6, i2);
            this.a.put((byte) bytes.length);
            this.a.put(bytes);
        }
    }

    public <T> void s(Collection<T> collection, int i2) {
        a(8);
        E((byte) 9, i2);
        g(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                p(it.next(), 0);
            }
        }
    }

    public <K, V> void t(Map<K, V> map, int i2) {
        a(8);
        E((byte) 8, i2);
        g(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                p(entry.getKey(), 0);
                p(entry.getValue(), 1);
            }
        }
    }

    public void u(short s, int i2) {
        a(4);
        if (s >= -128 && s <= 127) {
            d((byte) s, i2);
        } else {
            E((byte) 1, i2);
            this.a.putShort(s);
        }
    }

    public void v(boolean z, int i2) {
        d(z ? (byte) 1 : (byte) 0, i2);
    }

    public void w(byte[] bArr, int i2) {
        a(bArr.length + 8);
        E((byte) 13, i2);
        E((byte) 0, 0);
        g(bArr.length, 0);
        this.a.put(bArr);
    }

    public void x(double[] dArr, int i2) {
        a(8);
        E((byte) 9, i2);
        g(dArr.length, 0);
        for (double d2 : dArr) {
            e(d2, 0);
        }
    }

    public void y(float[] fArr, int i2) {
        a(8);
        E((byte) 9, i2);
        g(fArr.length, 0);
        for (float f2 : fArr) {
            f(f2, 0);
        }
    }

    public void z(int[] iArr, int i2) {
        a(8);
        E((byte) 9, i2);
        g(iArr.length, 0);
        for (int i3 : iArr) {
            g(i3, 0);
        }
    }

    public e() {
        this(128);
    }
}
