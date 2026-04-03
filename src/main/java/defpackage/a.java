package defpackage;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class a {
    public static /* synthetic */ int a(double d2) {
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
