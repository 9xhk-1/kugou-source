package e.g.a.c.a;

import androidx.core.app.NotificationCompat;
import f.e0.c;
import f.z.d.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final JSONObject a;

    public a(byte[] bArr) {
        j.e(bArr, "byteArray");
        this.a = (bArr.length == 0) ^ true ? new JSONObject(new String(bArr, c.a)) : new JSONObject();
    }

    public final byte[] a() {
        String string = this.a.toString();
        j.d(string, "this.jsonObject.toString()");
        byte[] bytes = string.getBytes(c.a);
        j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public final void b(String str, int i2) throws JSONException {
        j.e(str, "id");
        b.a.c(this.a, str, "src", Integer.valueOf(i2));
    }

    public final void c(String str, String str2) throws JSONException {
        j.e(str, "id");
        j.e(str2, "src");
        b.a.c(this.a, str, "src", str2);
    }

    public final void d(boolean z) throws JSONException {
        if (z) {
            this.a.put("LOCAL_UPDATE", true);
        }
    }

    public final void e(String str, int i2) throws JSONException {
        j.e(str, "id");
        b.a.c(this.a, str, "progress", Integer.valueOf(i2));
    }

    public final void f(String str, String str2) throws JSONException {
        j.e(str, "id");
        j.e(str2, "value");
        b.a.c(this.a, str, NotificationCompat.MessagingStyle.Message.KEY_TEXT, str2);
    }

    public final void g(String str, boolean z) throws JSONException {
        j.e(str, "id");
        b.a.c(this.a, str, "usePicCache", Boolean.valueOf(z));
    }
}
