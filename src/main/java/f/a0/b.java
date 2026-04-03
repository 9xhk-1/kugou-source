package f.a0;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {
    public static final int a(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }
}
