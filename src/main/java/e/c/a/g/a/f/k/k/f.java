package e.c.a.g.a.f.k.k;

import android.text.TextUtils;
import com.kugou.common.network.KugouNetException;
import e.c.a.g.a.s.u0;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;
import retrofit2.HttpException;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static boolean a() {
        return u0.r(e.c.c.o.f.a());
    }

    public static String b(Throwable th, String str) {
        return ((th instanceof UnknownHostException) || (th instanceof HttpException) || (th instanceof ConnectTimeoutException) || (th instanceof SocketTimeoutException) || (th instanceof SocketException)) ? "网络异常，请稍后重试" : th instanceof SSLException ? "证书校验失败，请稍后重试" : TextUtils.isEmpty(str) ? "加载失败，请稍后重试" : str;
    }

    public static int c(Exception exc) {
        int iCode;
        if (exc instanceof UnknownHostException) {
            return a() ? 1000001 : 1001000;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 1000005;
        }
        if (exc instanceof ConnectException) {
            return a() ? 1000005 : 1001000;
        }
        if (exc instanceof SocketTimeoutException) {
            return a() ? 1000006 : 1001000;
        }
        if (exc instanceof SocketException) {
            return 1000006;
        }
        if (!(exc instanceof KugouNetException)) {
            if (exc instanceof SSLException) {
                return (exc.getMessage().contains("Certificate expired at") || exc.getMessage().contains("Certificate not valid until")) ? 1000192 : 1000191;
            }
            if (exc instanceof IOException) {
                return TextUtils.equals("network is offline-mode", exc.getMessage()) ? 1000034 : 1000032;
            }
            if (exc instanceof URISyntaxException) {
                return 1000036;
            }
            if (exc instanceof IllegalStateException) {
                if (TextUtils.equals("network is offline-mode", exc.getMessage())) {
                    return 1000034;
                }
                return TextUtils.equals("can not use kugou net service", exc.getMessage()) ? 1000035 : 1000031;
            }
            if (!(exc instanceof HttpException) || (iCode = ((HttpException) exc).code()) < 300 || iCode >= 600) {
                return 1000031;
            }
            return iCode + 1000000;
        }
        KugouNetException kugouNetException = (KugouNetException) exc;
        switch (kugouNetException.getError()) {
            case 1:
                return 1000180;
            case 2:
                return 1000170;
            case 3:
                return 1000188;
            case 4:
                if (kugouNetException == null || kugouNetException.getRightResponseType() == null) {
                    return 1000181;
                }
                int checkType = kugouNetException.getRightResponseType().getCheckType();
                if (checkType == 0) {
                    return 1000182;
                }
                if (checkType == 1) {
                    return 1000187;
                }
                if (checkType != 2) {
                    return checkType != 3 ? 1000181 : 1000186;
                }
                return 1000189;
            case 5:
                return 1000011;
            case 6:
                return 1000030;
            case 7:
                return kugouNetException.getStatusCode() + 1000000;
            default:
                return 1000033;
        }
    }

    public static int d(Throwable th) {
        if (th instanceof Exception) {
            return c((Exception) th);
        }
        return -1;
    }
}
