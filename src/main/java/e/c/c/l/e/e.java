package e.c.c.l.e;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import e.c.c.o.k;
import e.c.c.o.m;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.zip.Deflater;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    public static class a {
        public long a = 0;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1263d;

        public a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.b = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                this.c = jSONObject.getInt("errcode");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public boolean a(boolean z) {
            int i2;
            int i3;
            return z ? this.b == 1 || (i3 = this.c) == 1310 || i3 == 1311 : this.b == 1 || (i2 = this.c) == 1311 || i2 == 1310;
        }

        public boolean b() {
            int i2 = this.c;
            return i2 == 1201 || i2 == 1202;
        }

        public boolean c() {
            int i2;
            return !TextUtils.isEmpty(this.f1263d) || (i2 = this.c) == 1203 || i2 == 1299;
        }

        public boolean d() {
            int i2;
            return ((TextUtils.isEmpty(this.f1263d) && this.c != 1299) || (i2 = this.c) == 1201 || i2 == 1202 || i2 == 1203) ? false : true;
        }

        public String toString() {
            return "status:" + this.b + " errCode:" + this.c;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public a b(byte[] bArr, boolean z, long j, long j2, Hashtable<String, String> hashtable, int i2) {
        byte[] bArrA = bArr;
        if (bArrA == null || bArrA.length == 0) {
            return null;
        }
        int length = 0;
        if (z) {
            length = bArrA.length;
            bArrA = a(bArr);
        }
        byte[] bArrA2 = e.c.c.l.e.a.f().a(bArrA);
        Hashtable hashtable2 = new Hashtable();
        hashtable2.putAll(hashtable);
        hashtable2.put("uuid", m.w(true));
        hashtable2.put("ver", Integer.valueOf(m.x(e.c.c.o.f.a())));
        hashtable2.put("pkid", Integer.valueOf(i2));
        hashtable2.put("cookie", e.c.c.l.e.a.f().e());
        hashtable2.put("length", Integer.valueOf(length));
        if (j2 > 0) {
            hashtable2.put("t2", Long.valueOf(j2));
        }
        k.d(hashtable2, e.c.c.l.e.a.b, e.c.c.l.e.a.c, j, bArrA2, true);
        return new a(e.c.c.o.d.b("http://nbcollect.kugou.com/v3/post", hashtable2, bArrA2));
    }
}
