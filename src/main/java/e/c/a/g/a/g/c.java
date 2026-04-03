package e.c.a.g.a.g;

import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public final int[] a;
    public final int[] b;

    public c(int[] iArr) {
        this(iArr, new int[]{2});
    }

    public int a(@IntRange(from = 1) int i2) {
        int i3 = i2 - 1;
        if (i3 >= 0) {
            int[] iArr = this.a;
            if (iArr.length > i3) {
                return iArr[i3];
            }
        }
        return this.a[r3.length - 1];
    }

    public boolean b(@IntRange(from = 1) int i2) {
        for (int i3 : this.b) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    public c(int[] iArr, int[] iArr2) {
        this.a = iArr;
        this.b = iArr2;
    }
}
