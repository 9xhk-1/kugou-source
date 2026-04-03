package f.e0;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final int a(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new f.b0.d(2, 36));
    }

    public static final int b(char c, int i2) {
        return Character.digit((int) c, i2);
    }

    public static final boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
