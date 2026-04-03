package okhttp3;

import android.util.Log;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public class HostVerifyHooker implements HostnameVerifier {
    private static final Pattern WHITE_LIST_PATTERN = Pattern.compile("[0-9a-zA-Z]+\\.[0-9a-zA-Z]+\\.kugou.com");
    private final HostnameVerifier mVerifier;

    public HostVerifyHooker(HostnameVerifier hostnameVerifier) {
        this.mVerifier = hostnameVerifier;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (str == null || !WHITE_LIST_PATTERN.matcher(str).matches()) {
            HostnameVerifier hostnameVerifier = this.mVerifier;
            if (hostnameVerifier != null) {
                return hostnameVerifier.verify(str, sSLSession);
            }
            return true;
        }
        Log.d("young-hqd", "verify: accept white list host " + str);
        return true;
    }
}
