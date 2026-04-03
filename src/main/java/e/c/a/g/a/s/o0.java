package e.c.a.g.a.s;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o0<K, V> extends LinkedHashMap<K, V> {
    public final int a;

    public o0(int i2, int i3, float f2) {
        super(i3, f2, true);
        this.a = i2;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.a;
    }
}
