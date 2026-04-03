package e.c.a.g.a.s;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.R;
import com.kugou.common.network.AbsHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {
    public static String a() {
        return "8bc5fbeb";
    }

    public static String b(Context context) {
        String strC = c(context, R.raw.platform, AbsHttpClient.GB2312);
        return TextUtils.isEmpty(strC) ? String.valueOf(3337) : strC;
    }

    public static String c(Context context, int i2, String str) {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i2);
        } catch (Exception unused) {
            inputStreamOpenRawResource = null;
        }
        if (inputStreamOpenRawResource == null) {
            return "";
        }
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(1024);
        while (true) {
            try {
                try {
                    int i3 = inputStreamOpenRawResource.read();
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayBuffer.append(i3);
                } catch (UnsupportedEncodingException | IOException unused2) {
                    inputStreamOpenRawResource.close();
                    return "";
                } catch (Throwable th) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                return "";
            }
            return "";
        }
        String string = EncodingUtils.getString(byteArrayBuffer.toByteArray(), str);
        try {
            inputStreamOpenRawResource.close();
        } catch (IOException unused5) {
        }
        return string;
    }
}
