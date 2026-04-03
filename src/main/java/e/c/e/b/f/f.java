package e.c.e.b.f;

import android.support.annotation.NonNull;
import e.c.e.b.f.d;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class f extends e.c.e.b.f.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f1304h = e.c.e.b.b.b.f().debug();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Random f1305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public volatile int[] f1306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f1307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d.a f1308g;

    public class a extends d.a.C0234a {
        public a() {
        }

        @Override // e.c.e.b.f.d.a
        public void onQueueChange() {
            f.this.h();
        }
    }

    public f(@NonNull d<?> dVar) {
        super(dVar);
        this.f1305d = f1304h ? new Random(1L) : new Random();
        this.f1308g = new a();
        g();
    }

    public static void e(int[] iArr, int i2, int i3) {
        int i4 = iArr[i2];
        iArr[i2] = iArr[i3];
        iArr[i3] = i4;
    }

    public final int[] c(int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = i3;
        }
        d(iArr);
        return iArr;
    }

    public final void d(int[] iArr) {
        for (int length = iArr.length; length > 1; length--) {
            e(iArr, length - 1, this.f1305d.nextInt(length));
        }
    }

    public final void f(int i2) {
        int[] iArr = this.f1306e;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i2 == iArr[i3]) {
                this.f1307f = i3;
                return;
            }
        }
    }

    public final void g() {
        this.f1306e = c(a().getSize());
    }

    @Override // e.c.e.b.f.c
    public int getNextIndex() {
        int i2 = this.f1307f;
        int[] iArr = this.f1306e;
        int i3 = i2 >= iArr.length + (-1) ? 0 : i2 + 1;
        this.f1307f = i3;
        return iArr[i3];
    }

    @Override // e.c.e.b.f.c
    public int getPreviousIndex() {
        int length = this.f1307f;
        int[] iArr = this.f1306e;
        if (length <= 0) {
            length = iArr.length;
        }
        int i2 = length - 1;
        this.f1307f = i2;
        return iArr[i2];
    }

    public final void h() {
        g();
        f(getCurrentIndex());
    }

    @Override // e.c.e.b.f.a, e.c.e.b.f.c
    public void setCurrentIndex(int i2) {
        super.setCurrentIndex(i2);
        f(i2);
    }

    @Override // e.c.e.b.f.a, e.c.e.b.f.c
    public void updateQueueList(@NonNull d<?> dVar) {
        super.updateQueueList(dVar);
        dVar.registerObserver(this.f1308g);
    }
}
