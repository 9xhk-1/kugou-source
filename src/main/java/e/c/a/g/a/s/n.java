package e.c.a.g.a.s;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.apache.http.conn.util.InetAddressUtils;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static String a = "";
    public static long b;

    @Nullable
    public static String a() {
        if (!TextUtils.isEmpty(a) && SystemClock.elapsedRealtime() - b <= 120000) {
            return a;
        }
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "127.0.0.1";
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String hostAddress = inetAddressNextElement.getHostAddress();
                    if (!inetAddressNextElement.isLoopbackAddress() && InetAddressUtils.isIPv4Address(hostAddress)) {
                        str = hostAddress;
                    }
                }
            }
        } catch (SocketException e2) {
            if (g0.a) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            a = str;
            b = SystemClock.elapsedRealtime();
        }
        if (g0.a) {
            g0.e("EasytraceUtil", String.format("systemLocalIP:%s", str));
        }
        return str;
    }
}
