package e.b.a;

import androidx.exifinterface.media.ExifInterface;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {
    public long a = 1;

    @Override // e.b.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a copy() {
        a aVar = new a();
        aVar.a = this.a;
        return aVar;
    }

    @Override // e.b.a.c
    public long getValue() {
        return this.a;
    }

    @Override // e.b.a.c
    public void reset(long j) {
        this.a = j;
    }

    @Override // e.b.a.c
    public void update(byte[] bArr, int i2, int i3) {
        long j = this.a;
        long j2 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j3 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        while (i3 > 0) {
            int i4 = i3 < 5552 ? i3 : 5552;
            i3 -= i4;
            while (true) {
                int i5 = i4 - 1;
                if (i4 <= 0) {
                    break;
                }
                j2 += (long) (bArr[i2] & ExifInterface.MARKER);
                j3 += j2;
                i2++;
                i4 = i5;
            }
            j2 %= 65521;
            j3 %= 65521;
        }
        this.a = (j3 << 16) | j2;
    }

    @Override // e.b.a.c
    public void reset() {
        this.a = 1L;
    }
}
