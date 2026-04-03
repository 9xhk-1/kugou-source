package e.c.a.g.a.g;

import android.text.TextUtils;
import android.util.Pair;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.m;
import f.u.u;
import f.z.d.j;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {
    public final int a;
    public final List<T> b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(int i2, List<? extends T> list) {
        j.e(list, "list");
        this.a = i2;
        this.b = list;
    }

    public final int a() {
        String config = e.c.a.g.a.f.e.c.a.a().getConfig(e.c.a.g.a.f.e.b.V3);
        boolean zIsEmpty = TextUtils.isEmpty(config);
        int iMax = HttpStatus.SC_BAD_REQUEST;
        int iMax2 = 550;
        if (!zIsEmpty) {
            try {
                String[] strArrT = h1.t(config, "_");
                String str = strArrT[0];
                j.d(str, "array[0]");
                iMax = Math.max(HttpStatus.SC_BAD_REQUEST, Integer.parseInt(str));
                String str2 = strArrT[1];
                j.d(str2, "array[1]");
                iMax2 = Math.max(550, Integer.parseInt(str2));
            } catch (Exception unused) {
            }
        }
        return m.m() ? iMax : iMax2;
    }

    public final Pair<Integer, List<T>> b() {
        int iA = a();
        int size = this.b.size();
        Object objW = u.w(this.b, this.a);
        if (size <= iA || objW == null) {
            return new Pair<>(Integer.valueOf(this.a), this.b);
        }
        ArrayList arrayList = new ArrayList(iA);
        int i2 = this.a - ((int) (iA * 0.33f));
        int i3 = iA + i2;
        if (i2 <= i3) {
            while (true) {
                int i4 = i2 + 1;
                arrayList.add(this.b.get((i2 + size) % size));
                if (i2 == i3) {
                    break;
                }
                i2 = i4;
            }
        }
        return new Pair<>(Integer.valueOf(arrayList.indexOf(objW)), arrayList);
    }
}
