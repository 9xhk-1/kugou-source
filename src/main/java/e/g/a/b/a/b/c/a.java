package e.g.a.b.a.b.c;

import android.os.Bundle;
import android.util.Base64;
import d.a.a.a$b.c.d.a.b;
import f.d;
import f.e0.c;
import f.i;
import f.z.d.j;
import f.z.d.s;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Deflater;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public b a;

    public a() {
        Object value;
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, d<?>> concurrentHashMapA = aVar.a();
        f.c0.b bVarA = s.a(b.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        b bVar = null;
        d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        b bVar2 = (orDefault == null || (value = orDefault.getValue()) == null || !(value instanceof b)) ? null : (b) value;
        if (bVar2 == null) {
            aVar.b(s.a(b.class));
        } else {
            bVar = bVar2;
        }
        this.a = bVar;
    }

    public final Bundle a(String str, e.g.a.c.a.a aVar, boolean z) {
        i iVar;
        e.g.b.b bVar = e.g.b.b.a;
        bVar.a("Update.BaseDataPack", "[DEBUG_" + str + "] createPatch begin...");
        byte[] bArrA = aVar.a();
        b bVar2 = this.a;
        if (bVar2 == null) {
            iVar = null;
        } else {
            Charset charset = c.a;
            String str2 = new String(bArrA, charset);
            j.e(str2, "data");
            int length = str2.length();
            if (length >= 2000) {
                if (length > 20000) {
                    bVar.b("DataPackCompressor", "not allow to post data of size over 20000 Bytes");
                }
                j.e(str2, "originString");
                bVar.a("StringCompressor", j.l("- enCompress source size is ", Integer.valueOf(str2.length())));
                Deflater deflater = new Deflater(9);
                byte[] bytes = str2.getBytes(charset);
                j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                deflater.setInput(bytes);
                deflater.finish();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                byte[] bArr = new byte[512];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
                }
                deflater.end();
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 1);
                j.d(strEncodeToString, "encodeToString(byteArrayOutputStream.toByteArray(), Base64.NO_PADDING)");
                iVar = new i(strEncodeToString, 1);
            } else {
                bVar.a("DataPackCompressor", j.l("no need to compress origin source size is ", Integer.valueOf(length)));
                iVar = new i(str2, 0);
            }
        }
        if (iVar == null) {
            iVar = new i("", 0);
        }
        Bundle bundle = new Bundle();
        bundle.putString("widget_code", str);
        bundle.putString("data", (String) iVar.c());
        bundle.putInt("compress", ((Number) iVar.d()).intValue());
        bundle.putBoolean("forceChange", z);
        e.g.b.b.a.a("Update.BaseDataPack", "[DEBUG_" + str + "] layout data.first encompress size is " + ((String) iVar.c()).length());
        return bundle;
    }

    public abstract boolean b(e.g.a.c.a.a aVar);

    public final e.g.a.c.a.a c(byte[] bArr, boolean z) throws JSONException {
        e.g.b.b.a.a("Update.BaseDataPack", "onPrepare");
        if (bArr == null) {
            return null;
        }
        e.g.a.c.a.a aVar = new e.g.a.c.a.a(bArr);
        aVar.d(z);
        return aVar;
    }

    public final Bundle d(String str, byte[] bArr, boolean z, boolean z2) throws JSONException {
        j.e(str, "widgetCode");
        j.e(bArr, "dslData");
        e.g.b.b.a.a("Update.BaseDataPack", str + " [DEBUG_" + str + "] onProcess begin... forceUpdate: " + z);
        e.g.a.c.a.a aVarC = c(bArr, z2);
        if (aVarC == null || !b(aVarC)) {
            return null;
        }
        return a(str, aVarC, z);
    }
}
