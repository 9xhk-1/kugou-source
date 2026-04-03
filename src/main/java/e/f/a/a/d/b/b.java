package e.f.a.a.d.b;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public StringBuilder a;
    public int b;

    public b(StringBuilder sb, int i2) {
        this.b = 0;
        this.a = sb;
        this.b = i2;
    }

    public b a(byte b, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    public b b(char c, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append(c);
        sb.append('\n');
        return this;
    }

    public b c(double d2, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append(d2);
        sb.append('\n');
        return this;
    }

    public b d(float f2, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append(f2);
        sb.append('\n');
        return this;
    }

    public b e(int i2, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append(i2);
        sb.append('\n');
        return this;
    }

    public b f(long j, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public b g(f fVar, String str) {
        b('{', str);
        if (fVar == null) {
            StringBuilder sb = this.a;
            sb.append('\t');
            sb.append("null");
        } else {
            fVar.a(this.a, this.b + 1);
        }
        b('}', null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> b h(T t, String str) {
        if (t == 0) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
        } else if (t instanceof Byte) {
            h((Byte) t, str);
        } else if (t instanceof Boolean) {
            h((Boolean) t, str);
        } else if (t instanceof Short) {
            h((Short) t, str);
        } else if (t instanceof Integer) {
            h((Integer) t, str);
        } else if (t instanceof Long) {
            h((Long) t, str);
        } else if (t instanceof Float) {
            h((Float) t, str);
        } else if (t instanceof Double) {
            h((Double) t, str);
        } else if (t instanceof String) {
            i((String) t, str);
        } else if (t instanceof Map) {
            k((Map) t, str);
        } else if (t instanceof List) {
            j((List) t, str);
        } else if (t instanceof f) {
            g((f) t, str);
        } else if (t instanceof byte[]) {
            n((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            h((boolean[]) t, str);
        } else if (t instanceof short[]) {
            t((short[]) t, str);
        } else if (t instanceof int[]) {
            q((int[]) t, str);
        } else if (t instanceof long[]) {
            r((long[]) t, str);
        } else if (t instanceof float[]) {
            p((float[]) t, str);
        } else if (t instanceof double[]) {
            o((double[]) t, str);
        } else {
            if (!t.getClass().isArray()) {
                throw new c("write object error: unsupport type.");
            }
            s((Object[]) t, str);
        }
        return this;
    }

    public b i(String str, String str2) {
        u(str2);
        if (str == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
        } else {
            StringBuilder sb2 = this.a;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> b j(Collection<T> collection, String str) {
        if (collection != null) {
            s(collection.toArray(), str);
            return this;
        }
        u(str);
        StringBuilder sb = this.a;
        sb.append("null");
        sb.append('\t');
        return this;
    }

    public <K, V> b k(Map<K, V> map, String str) {
        u(str);
        if (map == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(map.size());
        sb3.append(", {");
        sb3.append('\n');
        StringBuilder sb4 = this.a;
        int i2 = this.b;
        b bVar = new b(sb4, i2 + 1);
        b bVar2 = new b(sb4, i2 + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            bVar.b('(', null);
            bVar2.h(entry.getKey(), null);
            bVar2.h(entry.getValue(), null);
            bVar.b(')', null);
        }
        b('}', null);
        return this;
    }

    public b l(short s, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public b m(boolean z, String str) {
        u(str);
        StringBuilder sb = this.a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public b n(byte[] bArr, String str) {
        u(str);
        if (bArr == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(bArr.length);
        sb3.append(", [");
        sb3.append('\n');
        b bVar = new b(this.a, this.b + 1);
        for (byte b : bArr) {
            bVar.a(b, null);
        }
        b(']', null);
        return this;
    }

    public b o(double[] dArr, String str) {
        u(str);
        if (dArr == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb2 = this.a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(dArr.length);
        sb3.append(", [");
        sb3.append('\n');
        b bVar = new b(this.a, this.b + 1);
        for (double d2 : dArr) {
            bVar.c(d2, null);
        }
        b(']', null);
        return this;
    }

    public b p(float[] fArr, String str) {
        u(str);
        if (fArr == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb2 = this.a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(fArr.length);
        sb3.append(", [");
        sb3.append('\n');
        b bVar = new b(this.a, this.b + 1);
        for (float f2 : fArr) {
            bVar.d(f2, null);
        }
        b(']', null);
        return this;
    }

    public b q(int[] iArr, String str) {
        u(str);
        if (iArr == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb2 = this.a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(iArr.length);
        sb3.append(", [");
        sb3.append('\n');
        b bVar = new b(this.a, this.b + 1);
        for (int i2 : iArr) {
            bVar.e(i2, null);
        }
        b(']', null);
        return this;
    }

    public b r(long[] jArr, String str) {
        u(str);
        if (jArr == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb2 = this.a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(jArr.length);
        sb3.append(", [");
        sb3.append('\n');
        b bVar = new b(this.a, this.b + 1);
        for (long j : jArr) {
            bVar.f(j, null);
        }
        b(']', null);
        return this;
    }

    public <T> b s(T[] tArr, String str) {
        u(str);
        if (tArr == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(tArr.length);
        sb3.append(", [");
        sb3.append('\n');
        b bVar = new b(this.a, this.b + 1);
        for (T t : tArr) {
            bVar.h(t, null);
        }
        b(']', null);
        return this;
    }

    public b t(short[] sArr, String str) {
        u(str);
        if (sArr == null) {
            StringBuilder sb = this.a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb2 = this.a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.a;
        sb3.append(sArr.length);
        sb3.append(", [");
        sb3.append('\n');
        b bVar = new b(this.a, this.b + 1);
        for (short s : sArr) {
            bVar.l(s, null);
        }
        b(']', null);
        return this;
    }

    public final void u(String str) {
        for (int i2 = 0; i2 < this.b; i2++) {
            this.a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.a;
            sb.append(str);
            sb.append(": ");
        }
    }
}
