package e.c.a.g.a.g.n.g;

import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import e.c.a.g.a.g.n.g.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {
    public static int[] q = {0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, ShareCloudFileResource.WIDTH, 0};
    public static int[] r = {0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160, 0};
    public static int[] s = {44100, 48000, 32000, 0};
    public static int[] t = {22050, 24000, 16000, 0};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f986i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    public class a implements c.a {
        @Override // e.c.a.g.a.g.n.g.c.a
        public c create() {
            return new b();
        }

        @Override // e.c.a.g.a.g.n.g.c.a
        public String[] getSupportedExtensions() {
            return new String[]{"mp3"};
        }
    }

    public static c.a k() {
        return new a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01cd, code lost:
    
        r2 = r17.f983f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01cf, code lost:
    
        if (r2 <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d1, code lost:
    
        r17.k = r17.n / r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d7, code lost:
    
        r17.k = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01d9, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ac A[LOOP:0: B:3:0x0039->B:93:0x01ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01bc A[LOOP:5: B:97:0x01ba->B:98:0x01bc, LOOP_END] */
    @Override // e.c.a.g.a.g.n.g.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.io.File r18) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.n.g.b.a(java.io.File):void");
    }

    @Override // e.c.a.g.a.g.n.g.c
    public void b(File file, int i2, int i3) throws IOException {
        file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(this.b);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = this.f985h;
            int i6 = i2 + i5;
            if (iArr[i6] > i4) {
                i4 = iArr[i6];
            }
        }
        byte[] bArr = new byte[i4];
        int i7 = 0;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i2 + i8;
            int i10 = this.f984g[i9] - i7;
            int i11 = this.f985h[i9];
            if (i10 > 0) {
                if (fileInputStream.skip(i10) < 0) {
                    throw new IOException("Can not skip skip len");
                }
                i7 += i10;
            }
            if (fileInputStream.read(bArr, 0, i11) < 0) {
                throw new IOException("Can not read buffer");
            }
            fileOutputStream.write(bArr, 0, i11);
            i7 += i11;
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int[] d() {
        return this.f985h;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int f() {
        return this.f983f;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int g() {
        return this.l;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int h() {
        return 1152;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int i(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return i2 >= this.f983f ? this.j : this.f984g[i2];
    }
}
